<%@include file="../app/taglibs.jsp"%>										<html:view title="{title}">																	<html:card>																									<html:cardHeader label="table"/>												<html:cardBody>																								<html:tabPanel>																									<html:tab label="{about}" active="true">																	<html:alert state="warning">																				     	Renders a table																			</html:alert>																							</html:tab>																									<html:tab label="{attributes}">										<html:table stripe="true" hover="true"><html:tableHeader light="true"><html:tableLine><html:tableHead><fmt:message key="tag.attribute"/></html:tableHead><html:tableHead><fmt:message key="tag.required"/></html:tableHead><html:tableHead><fmt:message key="tag.type"/></html:tableHead><html:tableHead><fmt:message key="tag.description"/></html:tableHead></html:tableLine></html:tableHeader><html:tableBody><html:tableLine><html:tableColumn>stripe</html:tableColumn><html:tableColumn>false</html:tableColumn><html:tableColumn>java.lang.Boolean</html:tableColumn><html:tableColumn>It indicates whether the table should be striped rows. Default : false</html:tableColumn></html:tableLine><html:tableLine><html:tableColumn>dark</html:tableColumn><html:tableColumn>false</html:tableColumn><html:tableColumn>java.lang.Boolean</html:tableColumn><html:tableColumn>It indicates whether the table should be dark theme. Default : false</html:tableColumn></html:tableLine><html:tableLine><html:tableColumn>hover</html:tableColumn><html:tableColumn>false</html:tableColumn><html:tableColumn>java.lang.Boolean</html:tableColumn><html:tableColumn>It indicates whether the table should be hovered rows. Default : false</html:tableColumn></html:tableLine><html:tableLine><html:tableColumn>small</html:tableColumn><html:tableColumn>false</html:tableColumn><html:tableColumn>java.lang.Boolean</html:tableColumn><html:tableColumn>It indicates whether the table should be small size. Default : false</html:tableColumn></html:tableLine><html:tableLine><html:tableColumn>border</html:tableColumn><html:tableColumn>false</html:tableColumn><html:tableColumn>java.lang.Boolean</html:tableColumn><html:tableColumn>It indicates whether the table should be bordered. Default : false</html:tableColumn></html:tableLine></html:tableBody></html:table>																																	</html:tab>																									<html:tab label="{demo}">																						
			<html:table>
				<html:tableBody>
					<html:tableLine>
						<html:tableColumn>Column 1</html:tableColumn>
					</html:tableLine>
					<html:tableLine>
						<html:tableColumn>Value 1</html:tableColumn>
					</html:tableLine>
				</html:tableBody>
			</html:table>
																									</html:tab>																									<html:tab label="{source}">																					<html:code>																										&lt;html:view&gt;
			&lt;html:table&gt;
				&lt;html:tableBody&gt;
					&lt;html:tableLine&gt;
						&lt;html:tableColumn&gt;Column 1&lt;/html:tableColumn&gt;
					&lt;/html:tableLine&gt;
					&lt;html:tableLine&gt;
						&lt;html:tableColumn&gt;Value 1&lt;/html:tableColumn&gt;
					&lt;/html:tableLine&gt;
				&lt;/html:tableBody&gt;
			&lt;/html:table&gt;
		&lt;/html:view&gt;																					</html:code>																							</html:tab>																								</html:tabPanel>																						</html:cardBody>																						</html:card>																							</html:view>																			