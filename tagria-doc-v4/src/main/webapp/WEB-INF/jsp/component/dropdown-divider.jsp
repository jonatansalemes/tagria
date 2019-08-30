<%@include file="../app/taglibs.jsp"  %>																							<html:view title="{title}" template="master" attribute="body">																													<html:card>																														<html:card-header>																				dropdown-divider							</html:card-header>																											<html:card-body>																												<html:tabs>																														<html:tabs-header>																												<html:tabs-tab active="true" labelKey="about" id="tab1"></html:tabs-tab> 												<html:tabs-tab labelKey="attributes" id="tab2"></html:tabs-tab> 														<html:tabs-tab labelKey="demo" id="tab3"></html:tabs-tab> 																<html:tabs-tab labelKey="source" id="tab4"></html:tabs-tab> 														</html:tabs-header> 																										<html:tabs-body> 																												<html:tabs-content active="true" contentOf="tab1">																			<html:alert state="warning">													Renders a menu dropdown divider											</html:alert>																											</html:tabs-content>																										<html:tabs-content contentOf="tab2">												<html:alert state="info" labelKey="tag.empty.attributes"></html:alert>										</html:tabs-content>																								<html:tabs-content contentOf="tab3">										
			<html:dropdown label="List">
				<html:dropdown-item label="Item 1" url="#"/>
				<html:dropdown-divider/>
				<html:dropdown-item label="Item 2" target="_blank" url="#"/>
				<html:dropdown-item icon="trash" label="Item 3" url="#"/>
			</html:dropdown> 
												</html:tabs-content>																								<html:tabs-content contentOf="tab4">																					<html:code>																												&lt;html:view&gt;
			&lt;html:dropdown label="List"&gt;
				&lt;html:dropdown-item label="Item 1" url="#"/&gt;
				&lt;html:dropdown-divider/&gt;
				&lt;html:dropdown-item label="Item 2" target="_blank" url="#"/&gt;
				&lt;html:dropdown-item icon="trash" label="Item 3" url="#"/&gt;
			&lt;/html:dropdown&gt; 
		&lt;/html:view&gt;												</html:code>																									</html:tabs-content>																							</html:tabs-body> 																								</html:tabs>																									</html:card-body>																								</html:card>																									</html:view>																			