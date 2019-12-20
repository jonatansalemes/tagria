<%@include file="../app/taglibs.jsp"  %>																							<html:view title="{title}" template="master">					<html:template render="body">																													<html:card>																														<html:cardHeader>																				menuDropdownItem							</html:cardHeader>																											<html:cardBody>																												<html:tabs>																														<html:tabsHeader>																												<html:tabsTab active="true" labelKey="about" id="tab1"></html:tabsTab> 												<html:tabsTab labelKey="attributes" id="tab2"></html:tabsTab> 														<html:tabsTab labelKey="demo" id="tab3"></html:tabsTab> 																<html:tabsTab labelKey="source" id="tab4"></html:tabsTab> 														</html:tabsHeader> 																										<html:tabsBody> 																												<html:tabsContent active="true" contentOf="tab1">																			<html:alert state="warning">													Renders a menu item on dropdown											</html:alert>																											</html:tabsContent>																										<html:tabsContent contentOf="tab2">												<html:alert state="info" labelKey="tag.empty.attributes"></html:alert>										</html:tabsContent>																								<html:tabsContent contentOf="tab3">										
			<html:menu dark="true">
				<html:menuBrand label="my brand" url="/app/playground"></html:menuBrand>
				<html:menuCollapse attachToSelector="#block1" />
				<html:menuCollapsable id="block1">
					<html:menuDropdown label="Menu">
						<html:menuDropdownItem label="Item 1" url="#" />
						<html:menuDropdownDivider />
						<html:menuDropdownItem label="Item 2" target="_blank" url="#" />
						<html:menuDropdownItem icon="trash" label="Item 3" url="#" />
					</html:menuDropdown>
					<html:menuLink label="My link" url="#" />
				</html:menuCollapsable>
			</html:menu>
												</html:tabsContent>																								<html:tabsContent contentOf="tab4">																					<html:code>																												&lt;html:view&gt;
			&lt;html:menu dark="true"&gt;
				&lt;html:menuBrand label="my brand" url="/app/playground"&gt;&lt;/html:menuBrand&gt;
				&lt;html:menuCollapse attachToSelector="#block1" /&gt;
				&lt;html:menuCollapsable id="block1"&gt;
					&lt;html:menuDropdown label="Menu"&gt;
						&lt;html:menuDropdownItem label="Item 1" url="#" /&gt;
						&lt;html:menuDropdownDivider /&gt;
						&lt;html:menuDropdownItem label="Item 2" target="_blank" url="#" /&gt;
						&lt;html:menuDropdownItem icon="trash" label="Item 3" url="#" /&gt;
					&lt;/html:menuDropdown&gt;
					&lt;html:menuLink label="My link" url="#" /&gt;
				&lt;/html:menuCollapsable&gt;
			&lt;/html:menu&gt;
		&lt;/html:view&gt;												</html:code>																									</html:tabsContent>																							</html:tabsBody> 																								</html:tabs>																									</html:cardBody>																								</html:card>																									    </html:template> 																							</html:view>																			