<%@include file="../app/taglibs.jsp"  %>																							<html:view title="{title}" template="master">					<html:template render="body">																													<html:card>																														<html:cardHeader>																				cardImage							</html:cardHeader>																											<html:cardBody>																												<html:tabs>																														<html:tabsHeader>																												<html:tabsTab active="true" labelKey="about" id="tab1"></html:tabsTab> 												<html:tabsTab labelKey="attributes" id="tab2"></html:tabsTab> 														<html:tabsTab labelKey="demo" id="tab3"></html:tabsTab> 																<html:tabsTab labelKey="source" id="tab4"></html:tabsTab> 														</html:tabsHeader> 																										<html:tabsBody> 																												<html:tabsContent active="true" contentOf="tab1">																			<html:alert state="warning">													Renders an card image											</html:alert>																											</html:tabsContent>																										<html:tabsContent contentOf="tab2">												<html:table stripe="true" hover="true"><html:tableHeader light="true"><html:tableRow><html:tableHead><fmt:message key="tag.attribute"/></html:tableHead><html:tableHead><fmt:message key="tag.required"/></html:tableHead><html:tableHead><fmt:message key="tag.type"/></html:tableHead><html:tableHead><fmt:message key="tag.description"/></html:tableHead></html:tableRow></html:tableHeader><html:tableBody><html:tableRow><html:tableData>rendered</html:tableData><html:tableData>false</html:tableData><html:tableData>java.lang.Boolean</html:tableData><html:tableData>It indicates if the component should be rendered. Default : true</html:tableData></html:tableRow><html:tableRow><html:tableData>responsive</html:tableData><html:tableData>false</html:tableData><html:tableData>java.lang.Boolean</html:tableData><html:tableData>It indicates if cardImage is responsive. Default : false</html:tableData></html:tableRow><html:tableRow><html:tableData>height</html:tableData><html:tableData>true</html:tableData><html:tableData>java.lang.Integer</html:tableData><html:tableData>Indicates the height component</html:tableData></html:tableRow><html:tableRow><html:tableData>width</html:tableData><html:tableData>true</html:tableData><html:tableData>java.lang.Integer</html:tableData><html:tableData>Indicates the image width</html:tableData></html:tableRow><html:tableRow><html:tableData>alt</html:tableData><html:tableData>false</html:tableData><html:tableData>java.lang.String</html:tableData><html:tableData>It indicates the alt of image</html:tableData></html:tableRow><html:tableRow><html:tableData>altKey</html:tableData><html:tableData>false</html:tableData><html:tableData>java.lang.String</html:tableData><html:tableData>It indicates the alt key (i18n) of image</html:tableData></html:tableRow><html:tableRow><html:tableData>cdn</html:tableData><html:tableData>false</html:tableData><html:tableData>java.lang.Boolean</html:tableData><html:tableData>It indicates if the component must be loaded from cdn</html:tableData></html:tableRow><html:tableRow><html:tableData>url</html:tableData><html:tableData>true</html:tableData><html:tableData>java.lang.String</html:tableData><html:tableData>Indicates the image url</html:tableData></html:tableRow></html:tableBody></html:table>										</html:tabsContent>																								<html:tabsContent contentOf="tab3">										
			<html:card>
				<html:cardImage url="/assets/image/person.png" width="32" height="32" responsive="false"></html:cardImage>
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
				&lt;html:cardImage url="/assets/image/person.png" width="32" height="32" responsive="false"&gt;&lt;/html:cardImage&gt;
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