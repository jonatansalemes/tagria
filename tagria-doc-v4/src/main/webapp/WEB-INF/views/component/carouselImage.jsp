<%@include file="../app/taglibs.jsp"  %>																							<html:view title="{title}" template="master">					<html:template render="body">																													<html:card>																														<html:cardHeader>																				carouselImage							</html:cardHeader>																											<html:cardBody>																												<html:tabs>																														<html:tabsHeader>																												<html:tabsTab active="true" labelKey="about" id="tab1"></html:tabsTab> 												<html:tabsTab labelKey="attributes" id="tab2"></html:tabsTab> 														<html:tabsTab labelKey="demo" id="tab3"></html:tabsTab> 																<html:tabsTab labelKey="source" id="tab4"></html:tabsTab> 														</html:tabsHeader> 																										<html:tabsBody> 																												<html:tabsContent active="true" contentOf="tab1">																			<html:alert state="warning">													Renders an carousel image											</html:alert>																											</html:tabsContent>																										<html:tabsContent contentOf="tab2">												<html:alert state="info" labelKey="tag.empty.attributes"></html:alert>										</html:tabsContent>																								<html:tabsContent contentOf="tab3">										
			<html:carousel>
				<html:carouselItem active="true" label="Item 1" description="Description 1">
					<html:carouselImage url="https://jslsolucoes.com/wp-content/uploads/logo.png" width="200" height="200" alt="logo"/>
				</html:carouselItem>
				<html:carouselItem label="Item 2" description="Description 2">
					<html:carouselImage url="https://jslsolucoes.com/wp-content/uploads/logo.png" width="200" height="200" alt="logo"/>
				</html:carouselItem>
			</html:carousel> 
												</html:tabsContent>																								<html:tabsContent contentOf="tab4">																					<html:code>																												&lt;html:view&gt;
			&lt;html:carousel&gt;
				&lt;html:carouselItem active="true" label="Item 1" description="Description 1"&gt;
					&lt;html:carouselImage url="https://jslsolucoes.com/wp-content/uploads/logo.png" width="200" height="200" alt="logo"/&gt;
				&lt;/html:carouselItem&gt;
				&lt;html:carouselItem label="Item 2" description="Description 2"&gt;
					&lt;html:carouselImage url="https://jslsolucoes.com/wp-content/uploads/logo.png" width="200" height="200" alt="logo"/&gt;
				&lt;/html:carouselItem&gt;
			&lt;/html:carousel&gt; 
		&lt;/html:view&gt;												</html:code>																									</html:tabsContent>																							</html:tabsBody> 																								</html:tabs>																									</html:cardBody>																								</html:card>																									    </html:template> 																							</html:view>																			