<%@include file="../app/taglibs.jsp"  %>																							<html:view title="{title}" template="master">					<html:template render="body">																													<html:card>																														<html:cardHeader>																				menuBrand							</html:cardHeader>																											<html:cardBody>																												<html:tabs>																														<html:tabsHeader>																												<html:tabsTab active="true" labelKey="about" id="tab1"></html:tabsTab> 												<html:tabsTab labelKey="attributes" id="tab2"></html:tabsTab> 														<html:tabsTab labelKey="demo" id="tab3"></html:tabsTab> 																<html:tabsTab labelKey="source" id="tab4"></html:tabsTab> 														</html:tabsHeader> 																										<html:tabsBody> 																												<html:tabsContent active="true" contentOf="tab1">																			<html:alert state="warning">													Renders a logo in the navigation menu in text format											</html:alert>																											</html:tabsContent>																										<html:tabsContent contentOf="tab2">												<html:table stripe="true" hover="true"><html:tableHeader light="true"><html:tableRow><html:tableHead><fmt:message key="tag.attribute"/></html:tableHead><html:tableHead><fmt:message key="tag.required"/></html:tableHead><html:tableHead><fmt:message key="tag.type"/></html:tableHead><html:tableHead><fmt:message key="tag.description"/></html:tableHead></html:tableRow></html:tableHeader><html:tableBody><html:tableRow><html:tableData>url</html:tableData><html:tableData>true</html:tableData><html:tableData>java.lang.String</html:tableData><html:tableData>Indicates the URL to be called by clicking on the logo</html:tableData></html:tableRow><html:tableRow><html:tableData>label</html:tableData><html:tableData>false</html:tableData><html:tableData>java.lang.String</html:tableData><html:tableData>It indicates the label to be used in brand logo</html:tableData></html:tableRow><html:tableRow><html:tableData>labelKey</html:tableData><html:tableData>false</html:tableData><html:tableData>java.lang.String</html:tableData><html:tableData>It indicates the label key (i18n) to be used in brand logo</html:tableData></html:tableRow></html:tableBody></html:table>										</html:tabsContent>																								<html:tabsContent contentOf="tab3">										
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