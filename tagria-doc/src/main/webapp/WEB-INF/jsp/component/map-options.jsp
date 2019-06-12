<%@include file="../app/taglibs.jsp"%>																							<html:view title="{title}">																													<html:card>																														<html:card-header>																				map-options							</html:card-header>																											<html:card-body>																												<html:tabs>																														<html:tabs-header>																												<html:tabs-tab active="true" labelKey="about" id="tab1"></html:tabs-tab> 												<html:tabs-tab labelKey="attributes" id="tab2"></html:tabs-tab> 														<html:tabs-tab labelKey="demo" id="tab3"></html:tabs-tab> 																<html:tabs-tab labelKey="source" id="tab4"></html:tabs-tab> 														</html:tabs-header> 																										<html:tabs-body> 																												<html:tabs-content active="true" contentOf="tab1">																			<html:alert state="warning">													Renders a mapping of an options list to select a component											</html:alert>																											</html:tabs-content>																										<html:tabs-content contentOf="tab2">												<html:table stripe="true" hover="true"><html:thead light="true"><html:tr><html:th><fmt:message key="tag.attribute"/></html:th><html:th><fmt:message key="tag.required"/></html:th><html:th><fmt:message key="tag.type"/></html:th><html:th><fmt:message key="tag.description"/></html:th></html:tr></html:thead><html:tbody><html:tr><html:td>target</html:td><html:td>true</html:td><html:td>java.lang.String</html:td><html:td>Indicates the component name to be achieved</html:td></html:tr><html:tr><html:td>text</html:td><html:td>true</html:td><html:td>java.lang.Boolean</html:td><html:td>It indicates the contents of the option to be displayed</html:td></html:tr><html:tr><html:td>value</html:td><html:td>true</html:td><html:td>java.lang.String</html:td><html:td>Indicates the value of the option to be filled</html:td></html:tr></html:tbody></html:table>										</html:tabs-content>																								<html:tabs-content contentOf="tab3">										
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
												</html:tabs-content>																								<html:tabs-content contentOf="tab4">																					<html:code>																												&lt;html:view&gt;
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
		&lt;/html:view&gt;												</html:code>																									</html:tabs-content>																							</html:tabs-body> 																								</html:tabs>																									</html:card-body>																								</html:card>																									</html:view>																			