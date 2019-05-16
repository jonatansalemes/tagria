<%@include file="../app/taglibs.jsp"%>										<html:view title="{title}">																	<html:card>																									<html:cardHeader>															menuDropDownDivider							</html:cardHeader>																						<html:cardBody>																								<html:tabPanel>																									<html:tab label="{about}" active="true">																	<html:alert state="warning">																				     	Renders a menu dropdown divider																			</html:alert>																							</html:tab>																									<html:tab label="{attributes}">										<html:alert state="info" label="{tag.empty.attributes}"></html:alert>																																	</html:tab>																									<html:tab label="{demo}">																						
			<html:menu>
				<html:menuDropDown label="Menu">
					<html:menuItem label="Item 1" url="#"/>
					<html:menuSeparator/>
					<html:menuItem label="Item 2" url="#"/>
					<html:menuItem label="Item 3" url="#"/>
				</html:menuDropDown>
			</html:menu> 																							</html:tab>																									<html:tab label="{source}">																					<html:code>																										&lt;html:view&gt;
			&lt;html:menu&gt;
				&lt;html:menuDropDown label="Menu"&gt;
					&lt;html:menuItem label="Item 1" url="#"/&gt;
					&lt;html:menuSeparator/&gt;
					&lt;html:menuItem label="Item 2" url="#"/&gt;
					&lt;html:menuItem label="Item 3" url="#"/&gt;
				&lt;/html:menuDropDown&gt;
			&lt;/html:menu&gt; &lt;/html:view&gt;																					</html:code>																							</html:tab>																								</html:tabPanel>																						</html:cardBody>																						</html:card>																							</html:view>																			