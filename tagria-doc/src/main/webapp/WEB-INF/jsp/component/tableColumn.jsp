<%@include file="../app/taglibs.jsp"%>										<html:view title="{title}">																	<html:card>																									<html:cardHeader label="tableColumn"/>												<html:cardBody>																								<html:tabPanel>																									<html:tab label="{about}" active="true">																	<html:alert state="warning">																				     	Renders a table column																			</html:alert>																							</html:tab>																									<html:tab label="{attributes}">										<html:table stripe="true" hover="true"><html:tableHeader light="true"><html:tableLine><html:tableHead><fmt:message key="tag.attribute"/></html:tableHead><html:tableHead><fmt:message key="tag.required"/></html:tableHead><html:tableHead><fmt:message key="tag.type"/></html:tableHead><html:tableHead><fmt:message key="tag.description"/></html:tableHead></html:tableLine></html:tableHeader><html:tableBody><html:tableLine><html:tableColumn>state</html:tableColumn><html:tableColumn>false</html:tableColumn><html:tableColumn>java.lang.String</html:tableColumn><html:tableColumn>Indicates the column state. Default: default. Options: success, danger, info, default, primary</html:tableColumn></html:tableLine><html:tableLine><html:tableColumn>label</html:tableColumn><html:tableColumn>false</html:tableColumn><html:tableColumn>java.lang.String</html:tableColumn><html:tableColumn>It indicates a label for column content</html:tableColumn></html:tableLine><html:tableLine><html:tableColumn>format</html:tableColumn><html:tableColumn>false</html:tableColumn><html:tableColumn>java.lang.String</html:tableColumn><html:tableColumn>It indicates a format in which the value must be converted. Options: date,datetime, timestamp, hour, currency, zipCode, cnpj, tel, cpf</html:tableColumn></html:tableLine><html:tableLine><html:tableColumn>colspan</html:tableColumn><html:tableColumn>false</html:tableColumn><html:tableColumn>java.lang.Integer</html:tableColumn><html:tableColumn>Indicates the number of columns that this column should fill</html:tableColumn></html:tableLine></html:tableBody></html:table>																																	</html:tab>																									<html:tab label="{demo}">																						
			<html:table>
				<html:tableBody>
					<html:tableLine>
						<html:tableColumn>Value 1</html:tableColumn>
						<html:tableColumn state="info">Value 2</html:tableColumn>
					</html:tableLine>
					<html:tableLine>
						<html:tableColumn colspan="2">Value colspan 3</html:tableColumn>
					</html:tableLine>
				</html:tableBody>
			</html:table>
																									</html:tab>																									<html:tab label="{source}">																					<html:code>																										&lt;html:view&gt;
			&lt;html:table&gt;
				&lt;html:tableBody&gt;
					&lt;html:tableLine&gt;
						&lt;html:tableColumn&gt;Value 1&lt;/html:tableColumn&gt;
						&lt;html:tableColumn state="info"&gt;Value 2&lt;/html:tableColumn&gt;
					&lt;/html:tableLine&gt;
					&lt;html:tableLine&gt;
						&lt;html:tableColumn colspan="2"&gt;Value colspan 3&lt;/html:tableColumn&gt;
					&lt;/html:tableLine&gt;
				&lt;/html:tableBody&gt;
			&lt;/html:table&gt;
		&lt;/html:view&gt;																					</html:code>																							</html:tab>																								</html:tabPanel>																						</html:cardBody>																						</html:card>																							</html:view>																			