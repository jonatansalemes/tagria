<%@include file="../app/taglibs.jsp"%>										<html:view title="{title}">																	<html:card>																									<html:cardHeader>															dropDownDivider							</html:cardHeader>																						<html:cardBody>																								<html:tabPanel>																									<html:tab label="{about}" active="true">																	<html:alert state="warning">																				     	Renders a menu dropdown divider																			</html:alert>																							</html:tab>																									<html:tab label="{attributes}">										<html:alert state="info" label="{tag.empty.attributes}"></html:alert>																																	</html:tab>																									<html:tab label="{demo}">																						
			<html:dropDown label="List">
					<html:dropDownItem label="Item 1" url="#"/>
					<html:dropDownDivider/>
					<html:dropDownItem label="Item 2" target="_blank" url="#"/>
					<html:dropDownItem icon="trash" label="Item 3" url="#"/>
				</html:dropDown> 																							</html:tab>																									<html:tab label="{source}">																					<html:code>																										&lt;html:view&gt;
			&lt;html:dropDown label="List"&gt;
					&lt;html:dropDownItem label="Item 1" url="#"/&gt;
					&lt;html:dropDownDivider/&gt;
					&lt;html:dropDownItem label="Item 2" target="_blank" url="#"/&gt;
					&lt;html:dropDownItem icon="trash" label="Item 3" url="#"/&gt;
				&lt;/html:dropDown&gt; &lt;/html:view&gt;																					</html:code>																							</html:tab>																								</html:tabPanel>																						</html:cardBody>																						</html:card>																							</html:view>																			