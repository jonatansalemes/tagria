<%@include file="../app/taglibs.jsp"%>										<html:view title="{title}">																	<html:panel>																									<html:panelHead label="listGroupItem"></html:panelHead>												<html:panelBody>																								<html:tabPanel>																									<html:tab label="{about}" active="true">																	<html:alert state="warning">																				     	Renders a list item																			</html:alert>																							</html:tab>																									<html:tab label="{attributes}">										<html:table><html:tableLine><html:tableColumn header="true"><fmt:message key="tag.attribute"/></html:tableColumn><html:tableColumn header="true"><fmt:message key="tag.required"/></html:tableColumn><html:tableColumn header="true"><fmt:message key="tag.type"/></html:tableColumn><html:tableColumn header="true"><fmt:message key="tag.description"/></html:tableColumn></html:tableLine><html:tableLine><html:tableColumn>rendered</html:tableColumn><html:tableColumn>false</html:tableColumn><html:tableColumn>java.lang.Boolean</html:tableColumn><html:tableColumn>It indicates whether the component should be rendered. Default : true</html:tableColumn></html:tableLine><html:tableLine><html:tableColumn>cssClass</html:tableColumn><html:tableColumn>false</html:tableColumn><html:tableColumn>java.lang.String</html:tableColumn><html:tableColumn>It indicates a CSS class to the component</html:tableColumn></html:tableLine><html:tableLine><html:tableColumn>state</html:tableColumn><html:tableColumn>false</html:tableColumn><html:tableColumn>java.lang.String</html:tableColumn><html:tableColumn>It indicates the state where the item should be rendered. Default: none. Options: primary, secondary, light, dark, warning, success, danger, info</html:tableColumn></html:tableLine></html:table>																																	</html:tab>																									<html:tab label="{demo}">																						
			<html:listGroup>
				<html:listGroupItem>
					Item 1
				</html:listGroupItem>
				<html:listGroupItem>
					Item 2
				</html:listGroupItem>
			</html:listGroup> 																							</html:tab>																									<html:tab label="{source}">																					<html:code>																										&lt;html:view&gt;
			&lt;html:listGroup&gt;
				&lt;html:listGroupItem&gt;
					Item 1
				&lt;/html:listGroupItem&gt;
				&lt;html:listGroupItem&gt;
					Item 2
				&lt;/html:listGroupItem&gt;
			&lt;/html:listGroup&gt; &lt;/html:view&gt;																					</html:code>																							</html:tab>																								</html:tabPanel>																						</html:panelBody>																						</html:panel>																							</html:view>																			