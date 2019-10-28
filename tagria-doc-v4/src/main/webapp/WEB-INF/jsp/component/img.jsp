<%@include file="../app/taglibs.jsp"  %>																							<html:view title="{title}" template="master">					<html:template render="body">																													<html:card>																														<html:cardHeader>																				img							</html:cardHeader>																											<html:cardBody>																												<html:tabs>																														<html:tabsHeader>																												<html:tabsTab active="true" labelKey="about" id="tab1"></html:tabsTab> 												<html:tabsTab labelKey="attributes" id="tab2"></html:tabsTab> 														<html:tabsTab labelKey="demo" id="tab3"></html:tabsTab> 																<html:tabsTab labelKey="source" id="tab4"></html:tabsTab> 														</html:tabsHeader> 																										<html:tabsBody> 																												<html:tabsContent active="true" contentOf="tab1">																			<html:alert state="warning">													Renders an image											</html:alert>																											</html:tabsContent>																										<html:tabsContent contentOf="tab2">												<html:table stripe="true" hover="true"><html:tableHeader light="true"><html:tableRow><html:tableHead><fmt:message key="tag.attribute"/></html:tableHead><html:tableHead><fmt:message key="tag.required"/></html:tableHead><html:tableHead><fmt:message key="tag.type"/></html:tableHead><html:tableHead><fmt:message key="tag.description"/></html:tableHead></html:tableRow></html:tableHeader><html:tableBody><html:tableRow><html:tableData>alt</html:tableData><html:tableData>false</html:tableData><html:tableData>java.lang.String</html:tableData><html:tableData>It indicates the label if the component can not be loaded</html:tableData></html:tableRow><html:tableRow><html:tableData>altKey</html:tableData><html:tableData>false</html:tableData><html:tableData>java.lang.String</html:tableData><html:tableData>It indicates the label key (i18n) if the component can not be loaded</html:tableData></html:tableRow><html:tableRow><html:tableData>cdn</html:tableData><html:tableData>false</html:tableData><html:tableData>java.lang.Boolean</html:tableData><html:tableData>It indicates whether the component must follow a set on the properties cdn</html:tableData></html:tableRow><html:tableRow><html:tableData>responsive</html:tableData><html:tableData>false</html:tableData><html:tableData>java.lang.Boolean</html:tableData><html:tableData>It indicates whether the component should be responsive</html:tableData></html:tableRow><html:tableRow><html:tableData>url</html:tableData><html:tableData>true</html:tableData><html:tableData>java.lang.String</html:tableData><html:tableData>Indicates the image url</html:tableData></html:tableRow><html:tableRow><html:tableData>height</html:tableData><html:tableData>false</html:tableData><html:tableData>java.lang.Integer</html:tableData><html:tableData>Indicates the height component</html:tableData></html:tableRow><html:tableRow><html:tableData>width</html:tableData><html:tableData>false</html:tableData><html:tableData>java.lang.Integer</html:tableData><html:tableData>Indicates the image width</html:tableData></html:tableRow><html:tableRow><html:tableData>shape</html:tableData><html:tableData>false</html:tableData><html:tableData>java.lang.String</html:tableData><html:tableData>It indicates a format for the component. Options: rounded, circle, thumbnail</html:tableData></html:tableRow><html:tableRow><html:tableData>cssClass</html:tableData><html:tableData>false</html:tableData><html:tableData>java.lang.String</html:tableData><html:tableData>It indicates a CSS class to the component</html:tableData></html:tableRow><html:tableRow><html:tableData>rendered</html:tableData><html:tableData>false</html:tableData><html:tableData>java.lang.Boolean</html:tableData><html:tableData>It indicates whether the component should be rendered</html:tableData></html:tableRow></html:tableBody></html:table>										</html:tabsContent>																								<html:tabsContent contentOf="tab3">										
			<html:img url="/image/person.png" alt="logo" responsive="true"/> 
												</html:tabsContent>																								<html:tabsContent contentOf="tab4">																					<html:code>																												&lt;html:view&gt;
			&lt;html:img url="/image/person.png" alt="logo" responsive="true"/&gt; 
		&lt;/html:view&gt;												</html:code>																									</html:tabsContent>																							</html:tabsBody> 																								</html:tabs>																									</html:cardBody>																								</html:card>																									    </html:template> 																							</html:view>																			