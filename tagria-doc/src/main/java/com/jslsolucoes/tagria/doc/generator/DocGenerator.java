
package com.jslsolucoes.tagria.doc.generator;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.io.FileUtils;

import com.thoughtworks.xstream.XStream;

import br.com.caelum.vraptor.util.StringUtils;

public class DocGenerator {

	private static final String CHARSET = "iso-8859-1";

	public static void main(String[] args) throws IOException {

		String workspace = args[0];
		Map<String, List<Tag>> groupments = new HashMap<>();

		String html = FileUtils
				.readFileToString(new File(workspace + "/tagria-lib/src/main/resources/META-INF/html.tld"), CHARSET);
		String ajax = FileUtils
				.readFileToString(new File(workspace + "/tagria-lib/src/main/resources/META-INF/ajax.tld"), CHARSET);
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
					"<%@include file=\"../app/taglibs.jsp\"%>										"
							+ "<html:view title=\"{title}\">											"
							+ "						<html:panel>																		"
							+ "							<html:panelHead label=\"" + tag.getName()
							+ "\"></html:panelHead>					"
							+ "							<html:panelBody>																"
							+ "								<html:tabPanel>																"
							+ "									<html:tab label=\"{about}\" active=\"true\">							"
							+ "										<html:alert state=\"warning\">										"
							+ "										     	" + tag.getDescription()
							+ "									"
							+ "										</html:alert>														"
							+ "									</html:tab>																"
							+ "									<html:tab label=\"{attributes}\">										");

			if (CollectionUtils.isEmpty(tag.getAttributes())) {
				template.append("<html:alert state=\"info\" label=\"{tag.empty.attributes}\"></html:alert>");
			} else {

				template.append("<html:table><html:tableLine>"
						+ "<html:tableColumn header=\"true\"><fmt:message key=\"tag.attribute\"/></html:tableColumn>"
						+ "<html:tableColumn header=\"true\"><fmt:message key=\"tag.required\"/></html:tableColumn>"
						+ "<html:tableColumn header=\"true\"><fmt:message key=\"tag.type\"/></html:tableColumn>"
						+ "<html:tableColumn header=\"true\"><fmt:message key=\"tag.description\"/></html:tableColumn>"
						+

						"</html:tableLine>");

				for (Attribute attribute : tag.getAttributes()) {

					template.append("<html:tableLine>" + "<html:tableColumn>" + attribute.getName()
							+ "</html:tableColumn>" + "<html:tableColumn>"
							+ (attribute.getRequired() == null ? false : true) + "</html:tableColumn>"
							+ "<html:tableColumn>" + attribute.getType() + "</html:tableColumn>" + "<html:tableColumn>"
							+ attribute.getDescription() + "</html:tableColumn>" +

							"</html:tableLine>");
				}

				template.append("</html:table>");
			}

			template.append(
					"																								"
							+ "									</html:tab>																"
							+ "									<html:tab label=\"{demo}\">												"
							+ "										" + tag.getExample()
							+ "														"
							+ "									</html:tab>																"
							+ "									<html:tab label=\"{source}\">											"
							+ "										<html:code>															"
							+ "											&lt;html:view&gt;" + tag.getExampleEscaped()
							+ "&lt;/html:view&gt;											"
							+ "										</html:code>														"
							+ "									</html:tab>																"
							+ "								</html:tabPanel>															"
							+ "							</html:panelBody>																"
							+ "						</html:panel>																		"
							+ "					</html:view>																			");
			FileUtils.writeStringToFile(
					new File(workspace + "/tagria-doc/src/main/webapp/WEB-INF/jsp/component/" + tag.getName() + ".jsp"),
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

		StringBuilder menu = new StringBuilder("<html:div cssClass=\"menu\"><html:listGroup>");
		for (String key : new TreeSet<String>(groupments.keySet())) {
			menu.append("<html:listGroupItem><html:collapsable label=\"" + key + "\"><html:listGroup>");
			for (Tag tag : groupments.get(key)) {
				menu.append("<html:listGroupItem><html:link label=\"" + StringUtils.capitalize(tag.getName())
						+ "\" target=\"conteudo\" url=\"/component/" + tag.getName()
						+ "\"></html:link></html:listGroupItem>");
			}
			menu.append("</html:listGroup></html:collapsable></html:listGroupItem>");
		}
		menu.append("</html:listGroup></html:div>");

		File home = new File(workspace + "/tagria-doc/src/main/webapp/WEB-INF/jsp/app/index.jsp");
		FileUtils.writeStringToFile(home, FileUtils.readFileToString(home, CHARSET)
				.replaceAll("<html:div cssClass=\"menu\">[\\s\\S]*?</html:div>", menu.toString()), CHARSET);

	}
}
