<%@include file="../app/taglibs.jsp"%>										<html:view title="{title}">																	<html:card>																									<html:cardHeader>															tableLine							</html:cardHeader>																						<html:cardBody>																								<html:tabPanel>																									<html:tab label="{about}" active="true">																	<html:alert state="warning">																				     	Renders a line of a table																			</html:alert>																							</html:tab>																									<html:tab label="{attributes}">										<html:table stripe="true" hover="true"><html:tableHeader light="true"><html:tableLine><html:tableHead><fmt:message key="tag.attribute"/></html:tableHead><html:tableHead><fmt:message key="tag.required"/></html:tableHead><html:tableHead><fmt:message key="tag.type"/></html:tableHead><html:tableHead><fmt:message key="tag.description"/></html:tableHead></html:tableLine></html:tableHeader><html:tableBody><html:tableLine><html:tableColumn>rendered</html:tableColumn><html:tableColumn>false</html:tableColumn><html:tableColumn>java.lang.Boolean</html:tableColumn><html:tableColumn>It indicates whether the component should be rendered. Default : true</html:tableColumn></html:tableLine><html:tableLine><html:tableColumn>state</html:tableColumn><html:tableColumn>false</html:tableColumn><html:tableColumn>java.lang.String</html:tableColumn><html:tableColumn>Indicates the table line state. Default: default. Options: success, danger, info, default, primary</html:tableColumn></html:tableLine></html:tableBody></html:table>																																	</html:tab>																									<html:tab label="{demo}">																						
			<html:table>
				<html:tableBody>
					<html:tableLine>
						<html:tableColumn>Column 1</html:tableColumn>
					</html:tableLine>
					<html:tableLine state="danger">
						<html:tableColumn>Value 1</html:tableColumn>
					</html:tableLine>
				</html:tableBody>
			</html:table> 																							</html:tab>																									<html:tab label="{source}">																					<html:code>																										&lt;html:view&gt;
			&lt;html:table&gt;
				&lt;html:tableBody&gt;
					&lt;html:tableLine&gt;
						&lt;html:tableColumn&gt;Column 1&lt;/html:tableColumn&gt;
					&lt;/html:tableLine&gt;
					&lt;html:tableLine state="danger"&gt;
						&lt;html:tableColumn&gt;Value 1&lt;/html:tableColumn&gt;
					&lt;/html:tableLine&gt;
				&lt;/html:tableBody&gt;
			&lt;/html:table&gt; &lt;/html:view&gt;																					</html:code>																							</html:tab>																								</html:tabPanel>																						</html:cardBody>																						</html:card>																							</html:view>																			