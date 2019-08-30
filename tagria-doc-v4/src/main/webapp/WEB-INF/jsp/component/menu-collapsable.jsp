<%@include file="../app/taglibs.jsp"  %>																							<html:view title="{title}" template="master" attribute="body">																													<html:card>																														<html:card-header>																				menu-collapsable							</html:card-header>																											<html:card-body>																												<html:tabs>																														<html:tabs-header>																												<html:tabs-tab active="true" labelKey="about" id="tab1"></html:tabs-tab> 												<html:tabs-tab labelKey="attributes" id="tab2"></html:tabs-tab> 														<html:tabs-tab labelKey="demo" id="tab3"></html:tabs-tab> 																<html:tabs-tab labelKey="source" id="tab4"></html:tabs-tab> 														</html:tabs-header> 																										<html:tabs-body> 																												<html:tabs-content active="true" contentOf="tab1">																			<html:alert state="warning">													Renders a menu collapsable content group											</html:alert>																											</html:tabs-content>																										<html:tabs-content contentOf="tab2">												<html:table stripe="true" hover="true"><html:table-header light="true"><html:table-row><html:table-head><fmt:message key="tag.attribute"/></html:table-head><html:table-head><fmt:message key="tag.required"/></html:table-head><html:table-head><fmt:message key="tag.type"/></html:table-head><html:table-head><fmt:message key="tag.description"/></html:table-head></html:table-row></html:table-header><html:table-body><html:table-row><html:table-data>id</html:table-data><html:table-data>false</html:table-data><html:table-data>java.lang.String</html:table-data><html:table-data>Indicates the id of menu block to be collapsed</html:table-data></html:table-row></html:table-body></html:table>										</html:tabs-content>																								<html:tabs-content contentOf="tab3">										
			<html:menu dark="true">
				<html:menu-brand label="my brand" url="/app/playground"></html:menu-brand>
				<html:menu-collapse attachToSelector="#block1" />
				<html:menu-collapsable id="block1">
					<html:menu-dropdown label="Menu">
						<html:menu-dropdown-item label="Item 1" url="#" />
						<html:menu-dropdown-divider />
						<html:menu-dropdown-item label="Item 2" target="_blank" url="#" />
						<html:menu-dropdown-item icon="trash" label="Item 3" url="#" />
					</html:menu-dropdown>
					<html:menu-link label="My link" url="#" />
				</html:menu-collapsable>
			</html:menu>
												</html:tabs-content>																								<html:tabs-content contentOf="tab4">																					<html:code>																												&lt;html:view&gt;
			&lt;html:menu dark="true"&gt;
				&lt;html:menu-brand label="my brand" url="/app/playground"&gt;&lt;/html:menu-brand&gt;
				&lt;html:menu-collapse attachToSelector="#block1" /&gt;
				&lt;html:menu-collapsable id="block1"&gt;
					&lt;html:menu-dropdown label="Menu"&gt;
						&lt;html:menu-dropdown-item label="Item 1" url="#" /&gt;
						&lt;html:menu-dropdown-divider /&gt;
						&lt;html:menu-dropdown-item label="Item 2" target="_blank" url="#" /&gt;
						&lt;html:menu-dropdown-item icon="trash" label="Item 3" url="#" /&gt;
					&lt;/html:menu-dropdown&gt;
					&lt;html:menu-link label="My link" url="#" /&gt;
				&lt;/html:menu-collapsable&gt;
			&lt;/html:menu&gt;
		&lt;/html:view&gt;												</html:code>																									</html:tabs-content>																							</html:tabs-body> 																								</html:tabs>																									</html:card-body>																								</html:card>																									</html:view>																			