<%@include file="../app/taglibs.jsp"  %>																							<html:view title="{title}" template="master">					<html:template render="body">																													<html:card>																														<html:cardHeader>																				tabsOnAfterShow							</html:cardHeader>																											<html:cardBody>																												<html:tabs>																														<html:tabsHeader>																												<html:tabsTab active="true" labelKey="about" id="tab1"></html:tabsTab> 												<html:tabsTab labelKey="attributes" id="tab2"></html:tabsTab> 														<html:tabsTab labelKey="demo" id="tab3"></html:tabsTab> 																<html:tabsTab labelKey="source" id="tab4"></html:tabsTab> 														</html:tabsHeader> 																										<html:tabsBody> 																												<html:tabsContent active="true" contentOf="tab1">																			<html:alert state="warning">													Renders a javascript block to be performed after show tab											</html:alert>																											</html:tabsContent>																										<html:tabsContent contentOf="tab2">												<html:alert state="info" labelKey="tag.empty.attributes"></html:alert>										</html:tabsContent>																								<html:tabsContent contentOf="tab3">										
			<html:tabs>
			
				<html:tabsOnAfterShow>
					/* function signature is f(oldTab,newTab):void. oldTab: previous active tab, newTab: newly activated tab */
					console.log(oldTab);
					console.log(newTab);
				</html:tabsOnAfterShow>
			
				<html:tabsHeader>
					<html:tabsTab active="true" label="my tab 1" id="etab1"></html:tabsTab>
					<html:tabsTab label="my tab 2" id="tab2"></html:tabsTab>
					<html:tabsTab label="my tab 3" id="tab3"></html:tabsTab>
				</html:tabsHeader>
				<html:tabsBody>
					<html:tabsContent active="true" contentOf="etab1"> My content 1</html:tabsContent>
					<html:tabsContent contentOf="tab2"> My content 2</html:tabsContent>
					<html:tabsContent contentOf="tab3"> My content 3</html:tabsContent>
				</html:tabsBody>
			</html:tabs>
												</html:tabsContent>																								<html:tabsContent contentOf="tab4">																					<html:code>																												&lt;html:view&gt;
			&lt;html:tabs&gt;
			
				&lt;html:tabsOnAfterShow&gt;
					/* function signature is f(oldTab,newTab):void. oldTab: previous active tab, newTab: newly activated tab */
					console.log(oldTab);
					console.log(newTab);
				&lt;/html:tabsOnAfterShow&gt;
			
				&lt;html:tabsHeader&gt;
					&lt;html:tabsTab active="true" label="my tab 1" id="etab1"&gt;&lt;/html:tabsTab&gt;
					&lt;html:tabsTab label="my tab 2" id="tab2"&gt;&lt;/html:tabsTab&gt;
					&lt;html:tabsTab label="my tab 3" id="tab3"&gt;&lt;/html:tabsTab&gt;
				&lt;/html:tabsHeader&gt;
				&lt;html:tabsBody&gt;
					&lt;html:tabsContent active="true" contentOf="etab1"&gt; My content 1&lt;/html:tabsContent&gt;
					&lt;html:tabsContent contentOf="tab2"&gt; My content 2&lt;/html:tabsContent&gt;
					&lt;html:tabsContent contentOf="tab3"&gt; My content 3&lt;/html:tabsContent&gt;
				&lt;/html:tabsBody&gt;
			&lt;/html:tabs&gt;
		&lt;/html:view&gt;												</html:code>																									</html:tabsContent>																							</html:tabsBody> 																								</html:tabs>																									</html:cardBody>																								</html:card>																									    </html:template> 																							</html:view>																			