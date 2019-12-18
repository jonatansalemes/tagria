<%@include file="../app/taglibs.jsp"  %>																							<html:view title="{title}" template="master">					<html:template render="body">																													<html:card>																														<html:cardHeader>																				listGroup							</html:cardHeader>																											<html:cardBody>																												<html:tabs>																														<html:tabsHeader>																												<html:tabsTab active="true" labelKey="about" id="tab1"></html:tabsTab> 												<html:tabsTab labelKey="attributes" id="tab2"></html:tabsTab> 														<html:tabsTab labelKey="demo" id="tab3"></html:tabsTab> 																<html:tabsTab labelKey="source" id="tab4"></html:tabsTab> 														</html:tabsHeader> 																										<html:tabsBody> 																												<html:tabsContent active="true" contentOf="tab1">																			<html:alert state="warning">													Renders a list											</html:alert>																											</html:tabsContent>																										<html:tabsContent contentOf="tab2">												<html:alert state="info" labelKey="tag.empty.attributes"></html:alert>										</html:tabsContent>																								<html:tabsContent contentOf="tab3">										
			<html:listGroup>
				<html:listGroupItem>
					Item 1
				</html:listGroupItem>
				<html:listGroupItem>
					Item 2
				</html:listGroupItem>
				<html:listGroupItem>
					Item 3
				</html:listGroupItem>
			</html:listGroup> 
												</html:tabsContent>																								<html:tabsContent contentOf="tab4">																					<html:code>																												&lt;html:view&gt;
			&lt;html:listGroup&gt;
				&lt;html:listGroupItem&gt;
					Item 1
				&lt;/html:listGroupItem&gt;
				&lt;html:listGroupItem&gt;
					Item 2
				&lt;/html:listGroupItem&gt;
				&lt;html:listGroupItem&gt;
					Item 3
				&lt;/html:listGroupItem&gt;
			&lt;/html:listGroup&gt; 
		&lt;/html:view&gt;												</html:code>																									</html:tabsContent>																							</html:tabsBody> 																								</html:tabs>																									</html:cardBody>																								</html:card>																									    </html:template> 																							</html:view>																			