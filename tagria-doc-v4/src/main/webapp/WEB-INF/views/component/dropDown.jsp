<%@include file="../app/taglibs.jsp"  %>																							<html:view title="{title}" template="master">					<html:template render="body">																													<html:card>																														<html:cardHeader>																				dropDown							</html:cardHeader>																											<html:cardBody>																												<html:tabs>																														<html:tabsHeader>																												<html:tabsTab active="true" labelKey="about" id="tab1"></html:tabsTab> 												<html:tabsTab labelKey="attributes" id="tab2"></html:tabsTab> 														<html:tabsTab labelKey="demo" id="tab3"></html:tabsTab> 																<html:tabsTab labelKey="source" id="tab4"></html:tabsTab> 														</html:tabsHeader> 																										<html:tabsBody> 																												<html:tabsContent active="true" contentOf="tab1">																			<html:alert state="warning">													Renders a dropDown list											</html:alert>																											</html:tabsContent>																										<html:tabsContent contentOf="tab2">												<html:alert state="info" labelKey="tag.empty.attributes"></html:alert>										</html:tabsContent>																								<html:tabsContent contentOf="tab3">										
			<html:dropDown label="List">
				<html:dropDownItem label="Item 1" url="#"/>
				<html:dropDownDivider/>
				<html:dropDownItem label="Item 2" target="_blank" url="#"/>
				<html:dropDownItem icon="trash" label="Item 3" url="#"/>
			</html:dropDown> 
												</html:tabsContent>																								<html:tabsContent contentOf="tab4">																					<html:code>																												&lt;html:view&gt;
			&lt;html:dropDown label="List"&gt;
				&lt;html:dropDownItem label="Item 1" url="#"/&gt;
				&lt;html:dropDownDivider/&gt;
				&lt;html:dropDownItem label="Item 2" target="_blank" url="#"/&gt;
				&lt;html:dropDownItem icon="trash" label="Item 3" url="#"/&gt;
			&lt;/html:dropDown&gt; 
		&lt;/html:view&gt;												</html:code>																									</html:tabsContent>																							</html:tabsBody> 																								</html:tabs>																									</html:cardBody>																								</html:card>																									    </html:template> 																							</html:view>																			