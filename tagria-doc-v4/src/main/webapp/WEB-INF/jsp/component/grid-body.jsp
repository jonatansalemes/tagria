<%@include file="../app/taglibs.jsp"%>																							<html:view title="{title}">																													<html:card>																														<html:card-header>																				grid-body							</html:card-header>																											<html:card-body>																												<html:tabs>																														<html:tabs-header>																												<html:tabs-tab active="true" labelKey="about" id="tab1"></html:tabs-tab> 												<html:tabs-tab labelKey="attributes" id="tab2"></html:tabs-tab> 														<html:tabs-tab labelKey="demo" id="tab3"></html:tabs-tab> 																<html:tabs-tab labelKey="source" id="tab4"></html:tabs-tab> 														</html:tabs-header> 																										<html:tabs-body> 																												<html:tabs-content active="true" contentOf="tab1">																			<html:alert state="warning">													Renders a grid body											</html:alert>																											</html:tabs-content>																										<html:tabs-content contentOf="tab2">												<html:alert state="info" labelKey="tag.empty.attributes"></html:alert>										</html:tabs-content>																								<html:tabs-content contentOf="tab3">										
			<html:grid var="person" data="${ persons }" label="My grid">
				<html:grid-export/>
				<html:grid-paginate totalResults="${ totalResults }"></html:grid-paginate>
				<html:grid-search/>
				<html:grid-toolbar>
					<html:alert state="danger">my toolbar</html:alert>
				</html:grid-toolbar>
				<html:grid-header>
					<html:grid-column label="Column 1" align="left" exportable="true"></html:grid-column>
					<html:grid-column label="Column 2" align="center" exportable="true"></html:grid-column>
					<html:grid-column label="Column 3" align="center" exportable="true"></html:grid-column>
				</html:grid-header>
				<html:grid-body>
					<html:grid-column-data align="right" exportable="true">
						${ person.name }
					</html:grid-column-data>
					<html:grid-column-data align="center" exportable="true" booleanType="true">
						${ person.likeChocolate }
					</html:grid-column-data>
					<html:grid-column-data align="center" exportable="true" collapsable="true">
						${ person.cpf }
					</html:grid-column-data>
				</html:grid-body>
			</html:grid>
												</html:tabs-content>																								<html:tabs-content contentOf="tab4">																					<html:code>																												&lt;html:view&gt;
			&lt;html:grid var="person" data="\${ persons }" label="My grid"&gt;
				&lt;html:grid-export/&gt;
				&lt;html:grid-paginate totalResults="\${ totalResults }"&gt;&lt;/html:grid-paginate&gt;
				&lt;html:grid-search/&gt;
				&lt;html:grid-toolbar&gt;
					&lt;html:alert state="danger"&gt;my toolbar&lt;/html:alert&gt;
				&lt;/html:grid-toolbar&gt;
				&lt;html:grid-header&gt;
					&lt;html:grid-column label="Column 1" align="left" exportable="true"&gt;&lt;/html:grid-column&gt;
					&lt;html:grid-column label="Column 2" align="center" exportable="true"&gt;&lt;/html:grid-column&gt;
					&lt;html:grid-column label="Column 3" align="center" exportable="true"&gt;&lt;/html:grid-column&gt;
				&lt;/html:grid-header&gt;
				&lt;html:grid-body&gt;
					&lt;html:grid-column-data align="right" exportable="true"&gt;
						\${ person.name }
					&lt;/html:grid-column-data&gt;
					&lt;html:grid-column-data align="center" exportable="true" booleanType="true"&gt;
						\${ person.likeChocolate }
					&lt;/html:grid-column-data&gt;
					&lt;html:grid-column-data align="center" exportable="true" collapsable="true"&gt;
						\${ person.cpf }
					&lt;/html:grid-column-data&gt;
				&lt;/html:grid-body&gt;
			&lt;/html:grid&gt;
		&lt;/html:view&gt;												</html:code>																									</html:tabs-content>																							</html:tabs-body> 																								</html:tabs>																									</html:card-body>																								</html:card>																									</html:view>																			