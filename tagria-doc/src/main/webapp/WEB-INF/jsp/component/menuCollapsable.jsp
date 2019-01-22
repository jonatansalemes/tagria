<%@include file="../app/taglibs.jsp"%>										<html:view title="{title}">																	<html:panel>																									<html:panelHead label="menuCollapsable"></html:panelHead>												<html:panelBody>																								<html:tabPanel>																									<html:tab label="{about}" active="true">																	<html:alert state="warning">																				     	Renders a menu collapsable content group																			</html:alert>																							</html:tab>																									<html:tab label="{attributes}">										<html:table><html:tableLine><html:tableColumn header="true"><fmt:message key="tag.attribute"/></html:tableColumn><html:tableColumn header="true"><fmt:message key="tag.required"/></html:tableColumn><html:tableColumn header="true"><fmt:message key="tag.type"/></html:tableColumn><html:tableColumn header="true"><fmt:message key="tag.description"/></html:tableColumn></html:tableLine><html:tableLine><html:tableColumn>id</html:tableColumn><html:tableColumn>false</html:tableColumn><html:tableColumn>java.lang.String</html:tableColumn><html:tableColumn>Indicates the id of menu block to be collapsed</html:tableColumn></html:tableLine></html:table>																																	</html:tab>																									<html:tab label="{demo}">																						
			<html:menu>
				
					<html:menuCollapse attachToSelector="#block1">
					
					</html:menuCollapse>
				
				<html:menuCollapsable id="block1">
					<html:menuText>
						My text menu
					</html:menuText>
				</html:menuCollapsable>
				
			</html:menu>
																									</html:tab>																									<html:tab label="{source}">																					<html:code>																										&lt;html:view&gt;
			&lt;html:menu&gt;
				
					&lt;html:menuCollapse attachToSelector="#block1"&gt;
					
					&lt;/html:menuCollapse&gt;
				
				&lt;html:menuCollapsable id="block1"&gt;
					&lt;html:menuText&gt;
						My text menu
					&lt;/html:menuText&gt;
				&lt;/html:menuCollapsable&gt;
				
			&lt;/html:menu&gt;
		&lt;/html:view&gt;																					</html:code>																							</html:tab>																								</html:tabPanel>																						</html:panelBody>																						</html:panel>																							</html:view>																			