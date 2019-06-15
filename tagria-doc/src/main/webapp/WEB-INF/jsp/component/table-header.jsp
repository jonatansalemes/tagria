<%@include file="../app/taglibs.jsp"%>																							<html:view title="{title}">																													<html:card>																														<html:card-header>																				table-header							</html:card-header>																											<html:card-body>																												<html:tabs>																														<html:tabs-header>																												<html:tabs-tab active="true" labelKey="about" id="tab1"></html:tabs-tab> 												<html:tabs-tab labelKey="attributes" id="tab2"></html:tabs-tab> 														<html:tabs-tab labelKey="demo" id="tab3"></html:tabs-tab> 																<html:tabs-tab labelKey="source" id="tab4"></html:tabs-tab> 														</html:tabs-header> 																										<html:tabs-body> 																												<html:tabs-content active="true" contentOf="tab1">																			<html:alert state="warning">													Renders table head											</html:alert>																											</html:tabs-content>																										<html:tabs-content contentOf="tab2">												<html:table stripe="true" hover="true"><html:table-header light="true"><html:table-row><html:table-head><fmt:message key="tag.attribute"/></html:table-head><html:table-head><fmt:message key="tag.required"/></html:table-head><html:table-head><fmt:message key="tag.type"/></html:table-head><html:table-head><fmt:message key="tag.description"/></html:table-head></html:table-row></html:table-header><html:table-body><html:table-row><html:table-data>dark</html:table-data><html:table-data>false</html:table-data><html:table-data>java.lang.Boolean</html:table-data><html:table-data>It indicates whether the table header should be dark theme. Default : false</html:table-data></html:table-row><html:table-row><html:table-data>light</html:table-data><html:table-data>false</html:table-data><html:table-data>java.lang.Boolean</html:table-data><html:table-data>It indicates whether the table header should be light theme. Default : false</html:table-data></html:table-row></html:table-body></html:table>										</html:tabs-content>																								<html:tabs-content contentOf="tab3">										
			<html:table dark="true" hover="true" stripe="true">
				<html:table-caption>
					Caption
				</html:table-caption>
				<html:table-header light="true">
					<html:table-row>
						<html:table-head>Head 1</html:table-head>
					</html:table-row>
				</html:table-header>
				<html:table-body>
					<html:table-row>
						<html:tabel-data>Column 1</html:tabel-data>
					</html:table-row>
					<html:table-row state="danger">
						<html:tabel-data>Value 1</html:tabel-data>
					</html:table-row>
				</html:table-body>
				<html:table-footer>
					<html:table-row>
						<html:tabel-data>Foot 1</html:tabel-data>
					</html:table-row>
					<html:table-row state="danger">
						<html:tabel-data>Foot value 1</html:tabel-data>
					</html:table-row>
				</html:table-footer>
			</html:table> 
												</html:tabs-content>																								<html:tabs-content contentOf="tab4">																					<html:code>																												&lt;html:view&gt;
			&lt;html:table dark="true" hover="true" stripe="true"&gt;
				&lt;html:table-caption&gt;
					Caption
				&lt;/html:table-caption&gt;
				&lt;html:table-header light="true"&gt;
					&lt;html:table-row&gt;
						&lt;html:table-head&gt;Head 1&lt;/html:table-head&gt;
					&lt;/html:table-row&gt;
				&lt;/html:table-header&gt;
				&lt;html:table-body&gt;
					&lt;html:table-row&gt;
						&lt;html:tabel-data&gt;Column 1&lt;/html:tabel-data&gt;
					&lt;/html:table-row&gt;
					&lt;html:table-row state="danger"&gt;
						&lt;html:tabel-data&gt;Value 1&lt;/html:tabel-data&gt;
					&lt;/html:table-row&gt;
				&lt;/html:table-body&gt;
				&lt;html:table-footer&gt;
					&lt;html:table-row&gt;
						&lt;html:tabel-data&gt;Foot 1&lt;/html:tabel-data&gt;
					&lt;/html:table-row&gt;
					&lt;html:table-row state="danger"&gt;
						&lt;html:tabel-data&gt;Foot value 1&lt;/html:tabel-data&gt;
					&lt;/html:table-row&gt;
				&lt;/html:table-footer&gt;
			&lt;/html:table&gt; 
		&lt;/html:view&gt;												</html:code>																									</html:tabs-content>																							</html:tabs-body> 																								</html:tabs>																									</html:card-body>																								</html:card>																									</html:view>																			