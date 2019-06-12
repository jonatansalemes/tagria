<%@include file="../app/taglibs.jsp"%>																							<html:view title="{title}">																													<html:card>																														<html:card-header>																				parameter							</html:card-header>																											<html:card-body>																												<html:tabs>																														<html:tabs-header>																												<html:tabs-tab active="true" labelKey="about" id="tab1"></html:tabs-tab> 												<html:tabs-tab labelKey="attributes" id="tab2"></html:tabs-tab> 														<html:tabs-tab labelKey="demo" id="tab3"></html:tabs-tab> 																<html:tabs-tab labelKey="source" id="tab4"></html:tabs-tab> 														</html:tabs-header> 																										<html:tabs-body> 																												<html:tabs-content active="true" contentOf="tab1">																			<html:alert state="warning">													Renders a parameter that must be sent by ajax request											</html:alert>																											</html:tabs-content>																										<html:tabs-content contentOf="tab2">												<html:table stripe="true" hover="true"><html:thead light="true"><html:tr><html:th><fmt:message key="tag.attribute"/></html:th><html:th><fmt:message key="tag.required"/></html:th><html:th><fmt:message key="tag.type"/></html:th><html:th><fmt:message key="tag.description"/></html:th></html:tr></html:thead><html:tbody><html:tr><html:td>src</html:td><html:td>false</html:td><html:td>java.lang.String</html:td><html:td>Indicates the component of the name to be used as the source</html:td></html:tr><html:tr><html:td>value</html:td><html:td>false</html:td><html:td>java.lang.String</html:td><html:td>Indicates the fixed value to be used in parameter name</html:td></html:tr><html:tr><html:td>type</html:td><html:td>false</html:td><html:td>java.lang.Boolean</html:td><html:td>It indicates the type of iteration being used. Options: val, html</html:td></html:tr><html:tr><html:td>name</html:td><html:td>true</html:td><html:td>java.lang.String</html:td><html:td>It indicates the name of the parameter</html:td></html:tr><html:tr><html:td>required</html:td><html:td>false</html:td><html:td>java.lang.Boolean</html:td><html:td>It indicates if the value is optional occur to the function call. Default: false.</html:td></html:tr></html:tbody></html:table>										</html:tabs-content>																								<html:tabs-content contentOf="tab3">										
			<html:input name="input1" value="Valor 0"/>
			<html:input name="input2" value="" />
			
			<html:jsEvent attachTo="input1" event="blur">
			     datas();
			</html:jsEvent>
		
			<ajax:function name="dados" url="/app/ajax">
				<ajax:parameters>
					<ajax:parameter name="input1" src="input1" type="val" />
					<ajax:parameter name="input2" src="input2" type="val" required="false" />
				</ajax:parameters>
			    <ajax:onSuccess>
			          alert('Executada');
			    </ajax:onSuccess>
			    <ajax:onError>
			           
			    </ajax:onError>
			</ajax:function>
												</html:tabs-content>																								<html:tabs-content contentOf="tab4">																					<html:code>																												&lt;html:view&gt;
			&lt;html:input name="input1" value="Valor 0"/&gt;
			&lt;html:input name="input2" value="" /&gt;
			
			&lt;html:jsEvent attachTo="input1" event="blur"&gt;
			     datas();
			&lt;/html:jsEvent&gt;
		
			&lt;ajax:function name="dados" url="/app/ajax"&gt;
				&lt;ajax:parameters&gt;
					&lt;ajax:parameter name="input1" src="input1" type="val" /&gt;
					&lt;ajax:parameter name="input2" src="input2" type="val" required="false" /&gt;
				&lt;/ajax:parameters&gt;
			    &lt;ajax:onSuccess&gt;
			          alert('Executada');
			    &lt;/ajax:onSuccess&gt;
			    &lt;ajax:onError&gt;
			           
			    &lt;/ajax:onError&gt;
			&lt;/ajax:function&gt;
		&lt;/html:view&gt;												</html:code>																									</html:tabs-content>																							</html:tabs-body> 																								</html:tabs>																									</html:card-body>																								</html:card>																									</html:view>																			