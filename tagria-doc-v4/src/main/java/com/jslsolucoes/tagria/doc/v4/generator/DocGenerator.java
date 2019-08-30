
package com.jslsolucoes.tagria.doc.v4.generator;

import java.io.File;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import com.thoughtworks.xstream.XStream;

public class DocGenerator {

	private static final String CHARSET = "iso-8859-1";

	public static void main(String[] args) throws IOException {

		String workspace = args[0];
		String jspFolder = workspace + "/tagria-doc-v4/src/main/webapp/WEB-INF/jsp";
		Map<String, List<Tag>> groupments = new HashMap<>();

		String html = IOUtils.resourceToString("/META-INF/v4/html.tld", Charset.forName("UTF-8"));
		String ajax = IOUtils.resourceToString("/META-INF/v4/ajax.tld", Charset.forName("UTF-8"));
		XStream xStream = new XStream();
		xStream.processAnnotations(Taglib.class);
		Taglib taglibForHtml = (Taglib) xStream.fromXML(html);
		Taglib taglibForAjax = (Taglib) xStream.fromXML(ajax);
		List<Tag> tags = new ArrayList<Tag>();
		tags.addAll(taglibForHtml.getTags());
		tags.addAll(taglibForAjax.getTags());

		for (Tag tag : tags) {

			List<Tag> groups = groupments.get(tag.getGroup());
			if (groups == null) {
				groupments.put(tag.getGroup(), new ArrayList<>());
			}
			groupments.get(tag.getGroup()).add(tag);

			StringBuilder template = new StringBuilder(
					"<%@include file=\"../app/taglibs.jsp\"  %>																							"
							+ "<html:view title=\"{title}\" template=\"master\" attribute=\"body\">																							"
							+ "						<html:card>																							"
							+ "							<html:card-header>																				"
							+ tag.getName()
							+ "							</html:card-header>																				"
							+ "							<html:card-body>																				"
							+ "								<html:tabs>																					"
							+ "									<html:tabs-header>																		"
							+ "										<html:tabs-tab active=\"true\" labelKey=\"about\" id=\"tab1\"></html:tabs-tab> 		"
							+ "										<html:tabs-tab labelKey=\"attributes\" id=\"tab2\"></html:tabs-tab> 				"
							+ "										<html:tabs-tab labelKey=\"demo\" id=\"tab3\"></html:tabs-tab> 						"
							+ "										<html:tabs-tab labelKey=\"source\" id=\"tab4\"></html:tabs-tab> 					"
							+ "									</html:tabs-header> 																	"
							+ "									<html:tabs-body> 																		"
							+ "										<html:tabs-content active=\"true\" contentOf=\"tab1\">								"
							+ "											<html:alert state=\"warning\">													"
							+ tag.getDescription()
							+ "											</html:alert>																	"
							+ "										</html:tabs-content>																"
							+ "										<html:tabs-content contentOf=\"tab2\">												");

			if (CollectionUtils.isEmpty(tag.getAttributes())) {
				template.append("<html:alert state=\"info\" labelKey=\"tag.empty.attributes\"></html:alert>");
			} else {

				template.append(
						"<html:table stripe=\"true\" hover=\"true\"><html:table-header light=\"true\"><html:table-row><html:table-head><fmt:message key=\"tag.attribute\"/></html:table-head><html:table-head><fmt:message key=\"tag.required\"/></html:table-head><html:table-head><fmt:message key=\"tag.type\"/></html:table-head><html:table-head><fmt:message key=\"tag.description\"/></html:table-head></html:table-row></html:table-header><html:table-body>");
				for (Attribute attribute : tag.getAttributes()) {
					template.append("<html:table-row><html:table-data>" + attribute.getName()
							+ "</html:table-data><html:table-data>" + (attribute.getRequired() == null ? false : true)
							+ "</html:table-data><html:table-data>" + attribute.getType()
							+ "</html:table-data><html:table-data>" + attribute.getDescription()
							+ "</html:table-data></html:table-row>");
				}

				template.append("</html:table-body></html:table>");
			}

			template.append(
					"										</html:tabs-content>														"
							+ "										<html:tabs-content contentOf=\"tab3\">										"
							+ tag.getExample()
							+ "										</html:tabs-content>														"
							+ "										<html:tabs-content contentOf=\"tab4\">										"
							+ "											<html:code>																"
							+ "												&lt;html:view&gt;" + tag.getExampleEscaped()
							+ "&lt;/html:view&gt;	"
							+ "											</html:code>															"
							+ "										</html:tabs-content>														"
							+ "									</html:tabs-body> 																"
							+ "								</html:tabs>																		"
							+ "							</html:card-body>																		"
							+ "						</html:card>																				"
							+ "					</html:view>																			");
			FileUtils.writeStringToFile(
					new File(jspFolder + "/component/" + tag.getName() + ".jsp"),
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

		StringBuilder menu = new StringBuilder("<html:div cssClass=\"menu\"><html:listgroup>");
		for (String key : new TreeSet<String>(groupments.keySet())) {
			menu.append("<html:listgroup-item><html:collapsable label=\"" + key + "\"><html:listgroup>");
			for (Tag tag : groupments.get(key)) {
				menu.append("<html:listgroup-item><html:link label=\"" + tag.getName()
						+ "\" url=\"/component/" + tag.getName()
						+ "\"></html:link></html:listgroup-item>");
			}
			menu.append("</html:listgroup></html:collapsable></html:listgroup-item>");
		}
		menu.append("</html:listgroup></html:div>");

		File home = new File(jspFolder + "/app/template.jsp");
		FileUtils.writeStringToFile(home, FileUtils.readFileToString(home, CHARSET)
				.replaceAll("<html:div cssClass=\"menu\">[\\s\\S]*?</html:div>", menu.toString()), CHARSET);

	}
}
