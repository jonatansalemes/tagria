<%@include file="../app/taglibs.jsp"  %>																							<html:view title="{title}" template="master">					<html:template render="body">																													<html:card>																														<html:cardHeader>																				modalFooter							</html:cardHeader>																											<html:cardBody>																												<html:tabs>																														<html:tabsHeader>																												<html:tabsTab active="true" labelKey="about" id="tab1"></html:tabsTab> 												<html:tabsTab labelKey="attributes" id="tab2"></html:tabsTab> 														<html:tabsTab labelKey="demo" id="tab3"></html:tabsTab> 																<html:tabsTab labelKey="source" id="tab4"></html:tabsTab> 														</html:tabsHeader> 																										<html:tabsBody> 																												<html:tabsContent active="true" contentOf="tab1">																			<html:alert state="warning">													Renders a modal footer											</html:alert>																											</html:tabsContent>																										<html:tabsContent contentOf="tab2">												<html:alert state="info" labelKey="tag.empty.attributes"></html:alert>										</html:tabsContent>																								<html:tabsContent contentOf="tab3">										
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
		&lt;/html:view&gt;												</html:code>																									</html:tabsContent>																							</html:tabsBody> 																								</html:tabs>																									</html:cardBody>																								</html:card>																									    </html:template> 																							</html:view>																			