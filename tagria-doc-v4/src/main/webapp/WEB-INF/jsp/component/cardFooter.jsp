<%@include file="../app/taglibs.jsp"  %>																							<html:view title="{title}" template="master">					<html:template render="body">																													<html:card>																														<html:cardHeader>																				cardFooter							</html:cardHeader>																											<html:cardBody>																												<html:tabs>																														<html:tabsHeader>																												<html:tabsTab active="true" labelKey="about" id="tab1"></html:tabsTab> 												<html:tabsTab labelKey="attributes" id="tab2"></html:tabsTab> 														<html:tabsTab labelKey="demo" id="tab3"></html:tabsTab> 																<html:tabsTab labelKey="source" id="tab4"></html:tabsTab> 														</html:tabsHeader> 																										<html:tabsBody> 																												<html:tabsContent active="true" contentOf="tab1">																			<html:alert state="warning">													Renders card footer											</html:alert>																											</html:tabsContent>																										<html:tabsContent contentOf="tab2">												<html:alert state="info" labelKey="tag.empty.attributes"></html:alert>										</html:tabsContent>																								<html:tabsContent contentOf="tab3">										
			<html:card>
				<html:cardImage url="/image/person.png" width="32" height="32" responsive="false"></html:cardImage>
				<html:cardHeader>
					My header
				</html:cardHeader>
				<html:cardBody>
					<html:cardTitle>My title</html:cardTitle>
					<html:cardSubTitle>My subtitle</html:cardSubTitle>
					<html:cardText>My text</html:cardText>
					<html:cardLink label="My link 1" url="#"></html:cardLink>
				</html:cardBody>
				<html:cardFooter>
					My footer
				</html:cardFooter>
			</html:card>
												</html:tabsContent>																								<html:tabsContent contentOf="tab4">																					<html:code>																												&lt;html:view&gt;
			&lt;html:card&gt;
				&lt;html:cardImage url="/image/person.png" width="32" height="32" responsive="false"&gt;&lt;/html:cardImage&gt;
				&lt;html:cardHeader&gt;
					My header
				&lt;/html:cardHeader&gt;
				&lt;html:cardBody&gt;
					&lt;html:cardTitle&gt;My title&lt;/html:cardTitle&gt;
					&lt;html:cardSubTitle&gt;My subtitle&lt;/html:cardSubTitle&gt;
					&lt;html:cardText&gt;My text&lt;/html:cardText&gt;
					&lt;html:cardLink label="My link 1" url="#"&gt;&lt;/html:cardLink&gt;
				&lt;/html:cardBody&gt;
				&lt;html:cardFooter&gt;
					My footer
				&lt;/html:cardFooter&gt;
			&lt;/html:card&gt;
		&lt;/html:view&gt;												</html:code>																									</html:tabsContent>																							</html:tabsBody> 																								</html:tabs>																									</html:cardBody>																								</html:card>																									    </html:template> 																							</html:view>																			