<%@include file="../app/taglibs.jsp"  %>																							<html:view title="{title}" template="master">					<html:template render="body">																													<html:card>																														<html:cardHeader>																				tableCaption							</html:cardHeader>																											<html:cardBody>																												<html:tabs>																														<html:tabsHeader>																												<html:tabsTab active="true" labelKey="about" id="tab1"></html:tabsTab> 												<html:tabsTab labelKey="attributes" id="tab2"></html:tabsTab> 														<html:tabsTab labelKey="demo" id="tab3"></html:tabsTab> 																<html:tabsTab labelKey="source" id="tab4"></html:tabsTab> 														</html:tabsHeader> 																										<html:tabsBody> 																												<html:tabsContent active="true" contentOf="tab1">																			<html:alert state="warning">													Renders a table caption											</html:alert>																											</html:tabsContent>																										<html:tabsContent contentOf="tab2">												<html:table stripe="true" hover="true"><html:tableHeader light="true"><html:tableRow><html:tableHead><fmt:message key="tag.attribute"/></html:tableHead><html:tableHead><fmt:message key="tag.required"/></html:tableHead><html:tableHead><fmt:message key="tag.type"/></html:tableHead><html:tableHead><fmt:message key="tag.description"/></html:tableHead></html:tableRow></html:tableHeader><html:tableBody><html:tableRow><html:tableData>label</html:tableData><html:tableData>false</html:tableData><html:tableData>java.lang.String</html:tableData><html:tableData>It indicates a label for column content</html:tableData></html:tableRow></html:tableBody></html:table>										</html:tabsContent>																								<html:tabsContent contentOf="tab3">										
			<html:table dark="true" hover="true" stripe="true">
				<html:tableCaption>
					Caption
				</html:tableCaption>
				<html:tableHeader light="true">
					<html:tableRow>
						<html:tableHead>Head 1</html:tableHead>
					</html:tableRow>
				</html:tableHeader>
				<html:tableBody>
					<html:tableRow>
						<html:tableData>Column 1</html:tableData>
					</html:tableRow>
					<html:tableRow state="danger">
						<html:tableData>Value 1</html:tableData>
					</html:tableRow>
				</html:tableBody>
				<html:tableFooter>
					<html:tableRow>
						<html:tableData>Foot 1</html:tableData>
					</html:tableRow>
					<html:tableRow state="danger">
						<html:tableData>Foot value 1</html:tableData>
					</html:tableRow>
				</html:tableFooter>
			</html:table> 
												</html:tabsContent>																								<html:tabsContent contentOf="tab4">																					<html:code>																												&lt;html:view&gt;
			&lt;html:table dark="true" hover="true" stripe="true"&gt;
				&lt;html:tableCaption&gt;
					Caption
				&lt;/html:tableCaption&gt;
				&lt;html:tableHeader light="true"&gt;
					&lt;html:tableRow&gt;
						&lt;html:tableHead&gt;Head 1&lt;/html:tableHead&gt;
					&lt;/html:tableRow&gt;
				&lt;/html:tableHeader&gt;
				&lt;html:tableBody&gt;
					&lt;html:tableRow&gt;
						&lt;html:tableData&gt;Column 1&lt;/html:tableData&gt;
					&lt;/html:tableRow&gt;
					&lt;html:tableRow state="danger"&gt;
						&lt;html:tableData&gt;Value 1&lt;/html:tableData&gt;
					&lt;/html:tableRow&gt;
				&lt;/html:tableBody&gt;
				&lt;html:tableFooter&gt;
					&lt;html:tableRow&gt;
						&lt;html:tableData&gt;Foot 1&lt;/html:tableData&gt;
					&lt;/html:tableRow&gt;
					&lt;html:tableRow state="danger"&gt;
						&lt;html:tableData&gt;Foot value 1&lt;/html:tableData&gt;
					&lt;/html:tableRow&gt;
				&lt;/html:tableFooter&gt;
			&lt;/html:table&gt; 
		&lt;/html:view&gt;												</html:code>																									</html:tabsContent>																							</html:tabsBody> 																								</html:tabs>																									</html:cardBody>																								</html:card>																									    </html:template> 																							</html:view>																			