<%@include file="../app/taglibs.jsp"%>																							<html:view title="{title}">																													<html:card>																														<html:card-header>																				td							</html:card-header>																											<html:card-body>																												<html:tabs>																														<html:tabs-header>																												<html:tabs-tab active="true" labelKey="about" id="tab1"></html:tabs-tab> 												<html:tabs-tab labelKey="attributes" id="tab2"></html:tabs-tab> 														<html:tabs-tab labelKey="demo" id="tab3"></html:tabs-tab> 																<html:tabs-tab labelKey="source" id="tab4"></html:tabs-tab> 														</html:tabs-header> 																										<html:tabs-body> 																												<html:tabs-content active="true" contentOf="tab1">																			<html:alert state="warning">													Renders a table column											</html:alert>																											</html:tabs-content>																										<html:tabs-content contentOf="tab2">												<html:table stripe="true" hover="true"><html:thead light="true"><html:tr><html:th><fmt:message key="tag.attribute"/></html:th><html:th><fmt:message key="tag.required"/></html:th><html:th><fmt:message key="tag.type"/></html:th><html:th><fmt:message key="tag.description"/></html:th></html:tr></html:thead><html:tbody><html:tr><html:td>state</html:td><html:td>false</html:td><html:td>java.lang.String</html:td><html:td>Indicates the column state. Default: default. Options: success, danger, info, default, primary</html:td></html:tr><html:tr><html:td>label</html:td><html:td>false</html:td><html:td>java.lang.String</html:td><html:td>It indicates a label for column content</html:td></html:tr><html:tr><html:td>labelKey</html:td><html:td>false</html:td><html:td>java.lang.String</html:td><html:td>It indicates a label (i18n) for column content</html:td></html:tr><html:tr><html:td>colspan</html:td><html:td>false</html:td><html:td>java.lang.Integer</html:td><html:td>Indicates the number of columns that this column should fill</html:td></html:tr></html:tbody></html:table>										</html:tabs-content>																								<html:tabs-content contentOf="tab3">										
			<html:table dark="true" hover="true" stripe="true">
				<html:caption>
					Caption
				</html:caption>
				<html:thead light="true">
					<html:tr>
						<html:th>Head 1</html:th>
					</html:tr>
				</html:thead>
				<html:tbody>
					<html:tr>
						<html:td>Column 1</html:td>
					</html:tr>
					<html:tr state="danger">
						<html:td>Value 1</html:td>
					</html:tr>
				</html:tbody>
				<html:tfoot>
					<html:tr>
						<html:td>Foot 1</html:td>
					</html:tr>
					<html:tr state="danger">
						<html:td>Foot value 1</html:td>
					</html:tr>
				</html:tfoot>
			</html:table> 
												</html:tabs-content>																								<html:tabs-content contentOf="tab4">																					<html:code>																												&lt;html:view&gt;
			&lt;html:table dark="true" hover="true" stripe="true"&gt;
				&lt;html:caption&gt;
					Caption
				&lt;/html:caption&gt;
				&lt;html:thead light="true"&gt;
					&lt;html:tr&gt;
						&lt;html:th&gt;Head 1&lt;/html:th&gt;
					&lt;/html:tr&gt;
				&lt;/html:thead&gt;
				&lt;html:tbody&gt;
					&lt;html:tr&gt;
						&lt;html:td&gt;Column 1&lt;/html:td&gt;
					&lt;/html:tr&gt;
					&lt;html:tr state="danger"&gt;
						&lt;html:td&gt;Value 1&lt;/html:td&gt;
					&lt;/html:tr&gt;
				&lt;/html:tbody&gt;
				&lt;html:tfoot&gt;
					&lt;html:tr&gt;
						&lt;html:td&gt;Foot 1&lt;/html:td&gt;
					&lt;/html:tr&gt;
					&lt;html:tr state="danger"&gt;
						&lt;html:td&gt;Foot value 1&lt;/html:td&gt;
					&lt;/html:tr&gt;
				&lt;/html:tfoot&gt;
			&lt;/html:table&gt; 
		&lt;/html:view&gt;												</html:code>																									</html:tabs-content>																							</html:tabs-body> 																								</html:tabs>																									</html:card-body>																								</html:card>																									</html:view>																			