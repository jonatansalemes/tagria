<%@include file="../app/taglibs.jsp"  %>																							<html:view title="{title}" template="master">					<html:template render="body">																													<html:card>																														<html:cardHeader>																				formGroupMultiple							</html:cardHeader>																											<html:cardBody>																												<html:tabs>																														<html:tabsHeader>																												<html:tabsTab active="true" labelKey="about" id="tab1"></html:tabsTab> 												<html:tabsTab labelKey="attributes" id="tab2"></html:tabsTab> 														<html:tabsTab labelKey="demo" id="tab3"></html:tabsTab> 																<html:tabsTab labelKey="source" id="tab4"></html:tabsTab> 														</html:tabsHeader> 																										<html:tabsBody> 																												<html:tabsContent active="true" contentOf="tab1">																			<html:alert state="warning">													Renders a detail table											</html:alert>																											</html:tabsContent>																										<html:tabsContent contentOf="tab2">												<html:table stripe="true" hover="true"><html:tableHeader light="true"><html:tableRow><html:tableHead><fmt:message key="tag.attribute"/></html:tableHead><html:tableHead><fmt:message key="tag.required"/></html:tableHead><html:tableHead><fmt:message key="tag.type"/></html:tableHead><html:tableHead><fmt:message key="tag.description"/></html:tableHead></html:tableRow></html:tableHeader><html:tableBody><html:tableRow><html:tableData>indexed</html:tableData><html:tableData>false</html:tableData><html:tableData>java.lang.Boolean</html:tableData><html:tableData>Indicates if input names must be indexed. Default: true</html:tableData></html:tableRow><html:tableRow><html:tableData>label</html:tableData><html:tableData>false</html:tableData><html:tableData>java.lang.String</html:tableData><html:tableData>Indicates the label component</html:tableData></html:tableRow><html:tableRow><html:tableData>labelKey</html:tableData><html:tableData>false</html:tableData><html:tableData>java.lang.String</html:tableData><html:tableData>Indicates the label key (i18n) component</html:tableData></html:tableRow><html:tableRow><html:tableData>data</html:tableData><html:tableData>false</html:tableData><html:tableData>java.lang.Object</html:tableData><html:tableData>It indicates the collection to be iterated by the component. Supports only Map, Collection and Single objects thats is converted to Collection using immutable Arrays.asList(...).</html:tableData></html:tableRow><html:tableRow><html:tableData>dataArray</html:tableData><html:tableData>false</html:tableData><html:tableData>java.lang.Object[]</html:tableData><html:tableData>It indicates the object array to be iterated by the component.Supports only arrays of object</html:tableData></html:tableRow><html:tableRow><html:tableData>var</html:tableData><html:tableData>false</html:tableData><html:tableData>java.lang.String</html:tableData><html:tableData>It indicates the name of the variable java to be made available the object of iteration</html:tableData></html:tableRow><html:tableRow><html:tableData>varStatus</html:tableData><html:tableData>false</html:tableData><html:tableData>java.lang.String</html:tableData><html:tableData>It indicates the name of the variable to be available to current iteration</html:tableData></html:tableRow><html:tableRow><html:tableData>atLeast</html:tableData><html:tableData>false</html:tableData><html:tableData>java.lang.Integer</html:tableData><html:tableData>Indicates the minimum number of lines to be filled</html:tableData></html:tableRow><html:tableRow><html:tableData>empty</html:tableData><html:tableData>false</html:tableData><html:tableData>java.lang.Boolean</html:tableData><html:tableData>It indicates whether the component should start without lines</html:tableData></html:tableRow></html:tableBody></html:table>										</html:tabsContent>																								<html:tabsContent contentOf="tab3">										
			<html:form action="#" label="My title">
				<html:formGroup label="Field 1" required="true">
					<html:input required="true" name="field1"/>
				</html:formGroup>
				<html:formGroup label="Field 2">
					<html:input name="field2"/>
				</html:formGroup>
				<html:formGroupMultiple label="Fields group">
					<html:input name="fields3[]"/>
				</html:formGroupMultiple>				
				<html:formToolbar>
				    <html:button state="primary" type="submit" label="Label for submit"/>
				</html:formToolbar>
			</html:form> 
												</html:tabsContent>																								<html:tabsContent contentOf="tab4">																					<html:code>																												&lt;html:view&gt;
			&lt;html:form action="#" label="My title"&gt;
				&lt;html:formGroup label="Field 1" required="true"&gt;
					&lt;html:input required="true" name="field1"/&gt;
				&lt;/html:formGroup&gt;
				&lt;html:formGroup label="Field 2"&gt;
					&lt;html:input name="field2"/&gt;
				&lt;/html:formGroup&gt;
				&lt;html:formGroupMultiple label="Fields group"&gt;
					&lt;html:input name="fields3[]"/&gt;
				&lt;/html:formGroupMultiple&gt;				
				&lt;html:formToolbar&gt;
				    &lt;html:button state="primary" type="submit" label="Label for submit"/&gt;
				&lt;/html:formToolbar&gt;
			&lt;/html:form&gt; 
		&lt;/html:view&gt;												</html:code>																									</html:tabsContent>																							</html:tabsBody> 																								</html:tabs>																									</html:cardBody>																								</html:card>																									    </html:template> 																							</html:view>																			