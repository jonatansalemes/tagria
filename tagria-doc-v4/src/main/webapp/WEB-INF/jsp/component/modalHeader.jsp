<%@include file="../app/taglibs.jsp"  %>																							<html:view title="{title}" template="master" attribute="body">																													<html:card>																														<html:cardHeader>																				modalHeader							</html:cardHeader>																											<html:cardBody>																												<html:tabs>																														<html:tabsHeader>																												<html:tabsTab active="true" labelKey="about" id="tab1"></html:tabsTab> 												<html:tabsTab labelKey="attributes" id="tab2"></html:tabsTab> 														<html:tabsTab labelKey="demo" id="tab3"></html:tabsTab> 																<html:tabsTab labelKey="source" id="tab4"></html:tabsTab> 														</html:tabsHeader> 																										<html:tabsBody> 																												<html:tabsContent active="true" contentOf="tab1">																			<html:alert state="warning">													Renders a modal header											</html:alert>																											</html:tabsContent>																										<html:tabsContent contentOf="tab2">												<html:table stripe="true" hover="true"><html:tableHeader light="true"><html:tableRow><html:tableHead><fmt:message key="tag.attribute"/></html:tableHead><html:tableHead><fmt:message key="tag.required"/></html:tableHead><html:tableHead><fmt:message key="tag.type"/></html:tableHead><html:tableHead><fmt:message key="tag.description"/></html:tableHead></html:tableRow></html:tableHeader><html:tableBody><html:tableRow><html:tableData>label</html:tableData><html:tableData>false</html:tableData><html:tableData>java.lang.String</html:tableData><html:tableData>Indicates the label of the modal header</html:tableData></html:tableRow><html:tableRow><html:tableData>labelKey</html:tableData><html:tableData>false</html:tableData><html:tableData>java.lang.String</html:tableData><html:tableData>Indicates the label key (i18n) of the modal header</html:tableData></html:tableRow></html:tableBody></html:table>										</html:tabsContent>																								<html:tabsContent contentOf="tab3">										
		    <html:buttonGroup>
				<html:button label="My button" icon="search" id="btn1" />
			</html:buttonGroup>
			
			<html:modal attachToSelector="#btn1">
				<html:modalHeader label="My modal title"></html:modalHeader>
				<html:modalBody>
					Here is my component
				</html:modalBody>
				<html:modalFooter>
					My footer
				</html:modalFooter>
			</html:modal>
												</html:tabsContent>																								<html:tabsContent contentOf="tab4">																					<html:code>																												&lt;html:view&gt;
		    &lt;html:buttonGroup&gt;
				&lt;html:button label="My button" icon="search" id="btn1" /&gt;
			&lt;/html:buttonGroup&gt;
			
			&lt;html:modal attachToSelector="#btn1"&gt;
				&lt;html:modalHeader label="My modal title"&gt;&lt;/html:modalHeader&gt;
				&lt;html:modalBody&gt;
					Here is my component
				&lt;/html:modalBody&gt;
				&lt;html:modalFooter&gt;
					My footer
				&lt;/html:modalFooter&gt;
			&lt;/html:modal&gt;
		&lt;/html:view&gt;												</html:code>																									</html:tabsContent>																							</html:tabsBody> 																								</html:tabs>																									</html:cardBody>																								</html:card>																									</html:view>																			