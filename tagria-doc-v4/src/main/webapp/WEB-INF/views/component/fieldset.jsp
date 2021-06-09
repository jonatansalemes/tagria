<%@include file="../app/taglibs.jsp"  %>																							<html:view title="{title}" template="master">					<html:template render="body">																													<html:card>																														<html:cardHeader>																				fieldset							</html:cardHeader>																											<html:cardBody>																												<html:tabs>																														<html:tabsHeader>																												<html:tabsTab active="true" labelKey="about" id="tab1"></html:tabsTab> 												<html:tabsTab labelKey="attributes" id="tab2"></html:tabsTab> 														<html:tabsTab labelKey="demo" id="tab3"></html:tabsTab> 																<html:tabsTab labelKey="source" id="tab4"></html:tabsTab> 														</html:tabsHeader> 																										<html:tabsBody> 																												<html:tabsContent active="true" contentOf="tab1">																			<html:alert state="warning">													Renders a fieldset											</html:alert>																											</html:tabsContent>																										<html:tabsContent contentOf="tab2">												<html:table stripe="true" hover="true"><html:tableHeader light="true"><html:tableRow><html:tableHead><fmt:message key="tag.attribute"/></html:tableHead><html:tableHead><fmt:message key="tag.required"/></html:tableHead><html:tableHead><fmt:message key="tag.type"/></html:tableHead><html:tableHead><fmt:message key="tag.description"/></html:tableHead></html:tableRow></html:tableHeader><html:tableBody><html:tableRow><html:tableData>disabled</html:tableData><html:tableData>false</html:tableData><html:tableData>java.lang.Boolean</html:tableData><html:tableData>It indicates whether the component should be disabled. Default: false</html:tableData></html:tableRow><html:tableRow><html:tableData>rendered</html:tableData><html:tableData>false</html:tableData><html:tableData>java.lang.Boolean</html:tableData><html:tableData>It indicates whether the component should be rendered . Default : true</html:tableData></html:tableRow></html:tableBody></html:table>										</html:tabsContent>																								<html:tabsContent contentOf="tab3">										
			<html:form action="#">
				<html:fieldset>
						<html:legend>Some legend</html:legend>
						<html:col extraSmall="6">
							<html:input required="true" name="field1"/>
						</html:col>
						<html:col extraSmall="6">
							<html:input name="field2"/>
						</html:col>
				</html:fieldset>
			</html:form> 
												</html:tabsContent>																								<html:tabsContent contentOf="tab4">																					<html:code>																												&lt;html:view&gt;
			&lt;html:form action="#"&gt;
				&lt;html:fieldset&gt;
						&lt;html:legend&gt;Some legend&lt;/html:legend&gt;
						&lt;html:col extraSmall="6"&gt;
							&lt;html:input required="true" name="field1"/&gt;
						&lt;/html:col&gt;
						&lt;html:col extraSmall="6"&gt;
							&lt;html:input name="field2"/&gt;
						&lt;/html:col&gt;
				&lt;/html:fieldset&gt;
			&lt;/html:form&gt; 
		&lt;/html:view&gt;												</html:code>																									</html:tabsContent>																							</html:tabsBody> 																								</html:tabs>																									</html:cardBody>																								</html:card>																									    </html:template> 																							</html:view>																			