<%@include file="../app/taglibs.jsp"  %>																							<html:view title="{title}" template="master" attribute="body">																													<html:card>																														<html:cardHeader>																				mapOptions							</html:cardHeader>																											<html:cardBody>																												<html:tabs>																														<html:tabsHeader>																												<html:tabsTab active="true" labelKey="about" id="tab1"></html:tabsTab> 												<html:tabsTab labelKey="attributes" id="tab2"></html:tabsTab> 														<html:tabsTab labelKey="demo" id="tab3"></html:tabsTab> 																<html:tabsTab labelKey="source" id="tab4"></html:tabsTab> 														</html:tabsHeader> 																										<html:tabsBody> 																												<html:tabsContent active="true" contentOf="tab1">																			<html:alert state="warning">													Renders a mapping of an options list to select a component											</html:alert>																											</html:tabsContent>																										<html:tabsContent contentOf="tab2">												<html:table stripe="true" hover="true"><html:tableHeader light="true"><html:tableRow><html:tableHead><fmt:message key="tag.attribute"/></html:tableHead><html:tableHead><fmt:message key="tag.required"/></html:tableHead><html:tableHead><fmt:message key="tag.type"/></html:tableHead><html:tableHead><fmt:message key="tag.description"/></html:tableHead></html:tableRow></html:tableHeader><html:tableBody><html:tableRow><html:tableData>target</html:tableData><html:tableData>true</html:tableData><html:tableData>java.lang.String</html:tableData><html:tableData>Indicates the component name to be achieved</html:tableData></html:tableRow><html:tableRow><html:tableData>text</html:tableData><html:tableData>true</html:tableData><html:tableData>java.lang.Boolean</html:tableData><html:tableData>It indicates the contents of the option to be displayed</html:tableData></html:tableRow><html:tableRow><html:tableData>value</html:tableData><html:tableData>true</html:tableData><html:tableData>java.lang.String</html:tableData><html:tableData>Indicates the value of the option to be filled</html:tableData></html:tableRow></html:tableBody></html:table>										</html:tabsContent>																								<html:tabsContent contentOf="tab3">										
			<html:select name="input2">
				<html:option value="">- - -</html:option>
			</html:select>
			
			<ajax:function name="dados" url="/app/ajax/list" execute="true">
			    <ajax:onSuccess>
			          <ajax:mapOptions target="input2" value="id" text="nome" />
			    </ajax:onSuccess>
			    <ajax:onError>
			           
			    </ajax:onError>
			</ajax:function>
												</html:tabsContent>																								<html:tabsContent contentOf="tab4">																					<html:code>																												&lt;html:view&gt;
			&lt;html:select name="input2"&gt;
				&lt;html:option value=""&gt;- - -&lt;/html:option&gt;
			&lt;/html:select&gt;
			
			&lt;ajax:function name="dados" url="/app/ajax/list" execute="true"&gt;
			    &lt;ajax:onSuccess&gt;
			          &lt;ajax:mapOptions target="input2" value="id" text="nome" /&gt;
			    &lt;/ajax:onSuccess&gt;
			    &lt;ajax:onError&gt;
			           
			    &lt;/ajax:onError&gt;
			&lt;/ajax:function&gt;
		&lt;/html:view&gt;												</html:code>																									</html:tabsContent>																							</html:tabsBody> 																								</html:tabs>																									</html:cardBody>																								</html:card>																									</html:view>																			