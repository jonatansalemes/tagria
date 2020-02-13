
package com.jslsolucoes.tagria.doc.v4.generator;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.io.FileUtils;

public class DocGenerator {

    private static final String CHARSET = "iso-8859-1";

    public static void main(String[] args) throws Exception {

	String workspace = args[0];
	String jspFolder = workspace + "/tagria-doc-v4/src/main/webapp/WEB-INF/views";
	Map<String, List<Tag>> groupments = new HashMap<>();

	List<Tag> tags = new ArrayList<Tag>();
	List<String> resources = Arrays.asList("html.tld", "ajax.tld", "security.tld");
	JAXBContext jaxbContext = JAXBContext.newInstance(Taglib.class);
	Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
	for (String resource : resources) {
	    URL urlResource = DocGenerator.class.getResource("/META-INF/v4/" + resource);
	    Taglib taglib = (Taglib) unmarshaller.unmarshal(urlResource);
	    tags.addAll(taglib.getTags());
	}

	for (Tag tag : tags) {

	    System.out.println("Generating doc for tag: "  + tag.getName());
	    
	    List<Tag> groups = groupments.get(tag.getGroup());
	    if (groups == null) {
		groupments.put(tag.getGroup(), new ArrayList<>());
	    }
	    groupments.get(tag.getGroup()).add(tag);

	    StringBuilder template = new StringBuilder(
		    "<%@include file=\"../app/taglibs.jsp\"  %>																							"
			    + "<html:view title=\"{title}\" template=\"master\">"
			    + "					<html:template render=\"body\">																							"
			    + "						<html:card>																							"
			    + "							<html:cardHeader>																				"
			    + tag.getName()
			    + "							</html:cardHeader>																				"
			    + "							<html:cardBody>																				"
			    + "								<html:tabs>																					"
			    + "									<html:tabsHeader>																		"
			    + "										<html:tabsTab active=\"true\" labelKey=\"about\" id=\"tab1\"></html:tabsTab> 		"
			    + "										<html:tabsTab labelKey=\"attributes\" id=\"tab2\"></html:tabsTab> 				"
			    + "										<html:tabsTab labelKey=\"demo\" id=\"tab3\"></html:tabsTab> 						"
			    + "										<html:tabsTab labelKey=\"source\" id=\"tab4\"></html:tabsTab> 					"
			    + "									</html:tabsHeader> 																	"
			    + "									<html:tabsBody> 																		"
			    + "										<html:tabsContent active=\"true\" contentOf=\"tab1\">								"
			    + "											<html:alert state=\"warning\">													"
			    + tag.getDescription()
			    + "											</html:alert>																	"
			    + "										</html:tabsContent>																"
			    + "										<html:tabsContent contentOf=\"tab2\">												");

	    if (CollectionUtils.isEmpty(tag.getAttributes())) {
		template.append("<html:alert state=\"info\" labelKey=\"tag.empty.attributes\"></html:alert>");
	    } else {

		template.append(
			"<html:table stripe=\"true\" hover=\"true\"><html:tableHeader light=\"true\"><html:tableRow><html:tableHead><fmt:message key=\"tag.attribute\"/></html:tableHead><html:tableHead><fmt:message key=\"tag.required\"/></html:tableHead><html:tableHead><fmt:message key=\"tag.type\"/></html:tableHead><html:tableHead><fmt:message key=\"tag.description\"/></html:tableHead></html:tableRow></html:tableHeader><html:tableBody>");
		for (Attribute attribute : tag.getAttributes()) {
		    template.append("<html:tableRow><html:tableData>" + attribute.getName()
			    + "</html:tableData><html:tableData>" + (attribute.getRequired() == null ? false : true)
			    + "</html:tableData><html:tableData>" + attribute.getType()
			    + "</html:tableData><html:tableData>" + attribute.getDescription()
			    + "</html:tableData></html:tableRow>");
		}

		template.append("</html:tableBody></html:table>");
	    }

	    template.append(
		    "										</html:tabsContent>														"
			    + "										<html:tabsContent contentOf=\"tab3\">										"
			    + tag.getExample()
			    + "										</html:tabsContent>														"
			    + "										<html:tabsContent contentOf=\"tab4\">										"
			    + "											<html:code>																"
			    + "												&lt;html:view&gt;"
			    + tag.getExampleEscaped() + "&lt;/html:view&gt;	"
			    + "											</html:code>															"
			    + "										</html:tabsContent>														"
			    + "									</html:tabsBody> 																"
			    + "								</html:tabs>																		"
			    + "							</html:cardBody>																		"
			    + "						</html:card>																				"
			    + "					    </html:template> 																		"
			    + "					</html:view>																			");
	    FileUtils.writeStringToFile(new File(jspFolder + "/component/" + tag.getName() + ".jsp"),
		    template.toString(), CHARSET);
	}

	for (List<Tag> values : groupments.values()) {
	    Collections.sort(values, new Comparator<Tag>() {
		@Override
		public int compare(Tag o1, Tag o2) {
		    return o1.getName().compareTo(o2.getName());
		}
	    });
	}

	StringBuilder menu = new StringBuilder("<html:div cssClass=\"menu\">");
	for (String key : new TreeSet<String>(groupments.keySet())) {
	    menu.append("<html:collapsable cssClass=\"mt-3 mb-3\" label=\"" + key + "\"><html:listGroup>");
	    for (Tag tag : groupments.get(key)) {
		menu.append("<html:listGroupItem><html:link label=\"" + tag.getName() + "\" url=\"/component/"
			+ tag.getName() + "\"/></html:listGroupItem>");
	    }
	    menu.append("</html:listGroup></html:collapsable>");
	}
	menu.append("</html:div>");

	File home = new File(jspFolder + "/app/template.jsp");
	FileUtils.writeStringToFile(home, FileUtils.readFileToString(home, CHARSET)
		.replaceAll("<html:div cssClass=\"menu\">[\\s\\S]*?</html:div>", menu.toString()), CHARSET);

    }
}
