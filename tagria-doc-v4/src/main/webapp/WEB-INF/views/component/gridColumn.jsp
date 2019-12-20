<%@include file="../app/taglibs.jsp"  %>																							<html:view title="{title}" template="master">					<html:template render="body">																													<html:card>																														<html:cardHeader>																				gridColumn							</html:cardHeader>																											<html:cardBody>																												<html:tabs>																														<html:tabsHeader>																												<html:tabsTab active="true" labelKey="about" id="tab1"></html:tabsTab> 												<html:tabsTab labelKey="attributes" id="tab2"></html:tabsTab> 														<html:tabsTab labelKey="demo" id="tab3"></html:tabsTab> 																<html:tabsTab labelKey="source" id="tab4"></html:tabsTab> 														</html:tabsHeader> 																										<html:tabsBody> 																												<html:tabsContent active="true" contentOf="tab1">																			<html:alert state="warning">													Renders a grid header column											</html:alert>																											</html:tabsContent>																										<html:tabsContent contentOf="tab2">												<html:alert state="info" labelKey="tag.empty.attributes"></html:alert>										</html:tabsContent>																								<html:tabsContent contentOf="tab3">										
			<html:grid var="person" data="${ persons }" label="My grid">
				<html:gridExport/>
				<html:gridPaginate totalResults="${ totalResults }"></html:gridPaginate>
				<html:gridSearch/>
				<html:gridToolbar>
					<html:alert state="danger">my toolbar</html:alert>
				</html:gridToolbar>
				<html:gridHeader>
					<html:gridColumn label="Column 1" align="left" exportable="true"></html:gridColumn>
					<html:gridColumn label="Column 2" align="center" exportable="true"></html:gridColumn>
					<html:gridColumn label="Column 3" align="center" exportable="true"></html:gridColumn>
				</html:gridHeader>
				<html:gridBody>
					<html:gridColumnData align="right" exportable="true">
						${ person.name }
					</html:gridColumnData>
					<html:gridColumnData align="center" exportable="true" >
						${ person.likeChocolate }
					</html:gridColumnData>
					<html:gridColumnData align="center" exportable="true" collapsable="true">
						${ person.cpf }
					</html:gridColumnData>
				</html:gridBody>
			</html:grid>
												</html:tabsContent>																								<html:tabsContent contentOf="tab4">																					<html:code>																												&lt;html:view&gt;
			&lt;html:grid var="person" data="\${ persons }" label="My grid"&gt;
				&lt;html:gridExport/&gt;
				&lt;html:gridPaginate totalResults="\${ totalResults }"&gt;&lt;/html:gridPaginate&gt;
				&lt;html:gridSearch/&gt;
				&lt;html:gridToolbar&gt;
					&lt;html:alert state="danger"&gt;my toolbar&lt;/html:alert&gt;
				&lt;/html:gridToolbar&gt;
				&lt;html:gridHeader&gt;
					&lt;html:gridColumn label="Column 1" align="left" exportable="true"&gt;&lt;/html:gridColumn&gt;
					&lt;html:gridColumn label="Column 2" align="center" exportable="true"&gt;&lt;/html:gridColumn&gt;
					&lt;html:gridColumn label="Column 3" align="center" exportable="true"&gt;&lt;/html:gridColumn&gt;
				&lt;/html:gridHeader&gt;
				&lt;html:gridBody&gt;
					&lt;html:gridColumnData align="right" exportable="true"&gt;
						\${ person.name }
					&lt;/html:gridColumnData&gt;
					&lt;html:gridColumnData align="center" exportable="true" &gt;
						\${ person.likeChocolate }
					&lt;/html:gridColumnData&gt;
					&lt;html:gridColumnData align="center" exportable="true" collapsable="true"&gt;
						\${ person.cpf }
					&lt;/html:gridColumnData&gt;
				&lt;/html:gridBody&gt;
			&lt;/html:grid&gt;
		&lt;/html:view&gt;												</html:code>																									</html:tabsContent>																							</html:tabsBody> 																								</html:tabs>																									</html:cardBody>																								</html:card>																									    </html:template> 																							</html:view>																			