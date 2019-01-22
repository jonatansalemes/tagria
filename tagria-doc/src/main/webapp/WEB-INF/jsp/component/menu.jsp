<%@include file="../app/taglibs.jsp"%>										<html:view title="{title}">																	<html:panel>																									<html:panelHead label="menu"></html:panelHead>												<html:panelBody>																								<html:tabPanel>																									<html:tab label="{about}" active="true">																	<html:alert state="warning">																				     	Renders a horizontal menu																			</html:alert>																							</html:tab>																									<html:tab label="{attributes}">										<html:table><html:tableLine><html:tableColumn header="true"><fmt:message key="tag.attribute"/></html:tableColumn><html:tableColumn header="true"><fmt:message key="tag.required"/></html:tableColumn><html:tableColumn header="true"><fmt:message key="tag.type"/></html:tableColumn><html:tableColumn header="true"><fmt:message key="tag.description"/></html:tableColumn></html:tableLine><html:tableLine><html:tableColumn>fixed</html:tableColumn><html:tableColumn>false</html:tableColumn><html:tableColumn>java.lang.String</html:tableColumn><html:tableColumn>It indicates whether the component should be fixed. Default none. Options : top,bottom</html:tableColumn></html:tableLine></html:table>																																	</html:tab>																									<html:tab label="{demo}">																						
			<html:menu>
				<html:menuButton icon="cog" align="right">
					<html:menuDropDownItem label="Item 1" url="#"/>
					<html:menuDropDownDivider/>
					<html:menuDropDownItem label="Item 2" url="#"/>
					<html:menuDropDownItem label="Item 3" url="#"/>
				</html:menuButton>
			</html:menu> 																							</html:tab>																									<html:tab label="{source}">																					<html:code>																										&lt;html:view&gt;
			&lt;html:menu&gt;
				&lt;html:menuButton icon="cog" align="right"&gt;
					&lt;html:menuDropDownItem label="Item 1" url="#"/&gt;
					&lt;html:menuDropDownDivider/&gt;
					&lt;html:menuDropDownItem label="Item 2" url="#"/&gt;
					&lt;html:menuDropDownItem label="Item 3" url="#"/&gt;
				&lt;/html:menuButton&gt;
			&lt;/html:menu&gt; &lt;/html:view&gt;																					</html:code>																							</html:tab>																								</html:tabPanel>																						</html:panelBody>																						</html:panel>																							</html:view>																			