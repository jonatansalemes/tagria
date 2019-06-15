<%@include file="../app/taglibs.jsp"%>																							<html:view title="{title}">																													<html:card>																														<html:card-header>																				target							</html:card-header>																											<html:card-body>																												<html:tabs>																														<html:tabs-header>																												<html:tabs-tab active="true" labelKey="about" id="tab1"></html:tabs-tab> 												<html:tabs-tab labelKey="attributes" id="tab2"></html:tabs-tab> 														<html:tabs-tab labelKey="demo" id="tab3"></html:tabs-tab> 																<html:tabs-tab labelKey="source" id="tab4"></html:tabs-tab> 														</html:tabs-header> 																										<html:tabs-body> 																												<html:tabs-content active="true" contentOf="tab1">																			<html:alert state="warning">													Renders writing in a particular component											</html:alert>																											</html:tabs-content>																										<html:tabs-content contentOf="tab2">												<html:table stripe="true" hover="true"><html:table-header light="true"><html:table-row><html:table-head><fmt:message key="tag.attribute"/></html:table-head><html:table-head><fmt:message key="tag.required"/></html:table-head><html:table-head><fmt:message key="tag.type"/></html:table-head><html:table-head><fmt:message key="tag.description"/></html:table-head></html:table-row></html:table-header><html:table-body><html:table-row><html:table-data>data</html:table-data><html:table-data>false</html:table-data><html:table-data>java.lang.String</html:table-data><html:table-data>Indicates which attribute of the object must be used</html:table-data></html:table-row><html:table-row><html:table-data>value</html:table-data><html:table-data>false</html:table-data><html:table-data>java.lang.String</html:table-data><html:table-data>Indicates the fixed value to be used in target val</html:table-data></html:table-row><html:table-row><html:table-data>rendered</html:table-data><html:table-data>false</html:table-data><html:table-data>java.lang.Boolean</html:table-data><html:table-data>It indicates whether the component should be rendered. Default : true</html:table-data></html:table-row><html:table-row><html:table-data>type</html:table-data><html:table-data>true</html:table-data><html:table-data>java.lang.String</html:table-data><html:table-data>It indicates the type of iteration being used. Options: val, html</html:table-data></html:table-row><html:table-row><html:table-data>target</html:table-data><html:table-data>true</html:table-data><html:table-data>java.lang.String</html:table-data><html:table-data>Indicates the component name to be achieved</html:table-data></html:table-row></html:table-body></html:table>										</html:tabs-content>																								<html:tabs-content contentOf="tab3">										
			
			<html:input name="input1" value="Valor 0"/>
			<html:input name="input2" disabled="true"/>
			
			<html:jsEvent attachTo="input1" event="blur">
			     datas();
			</html:jsEvent>
		
			<ajax:function name="dados" url="/app/ajax">
				<ajax:parameters>
					<ajax:parameter name="input1" src="input1" type="val" />
				</ajax:parameters>
			    <ajax:onSuccess>
			          <ajax:target type="val" data="field" target="input2"/>
			    </ajax:onSuccess>
			    <ajax:onError>
			           
			    </ajax:onError>
			</ajax:function>
		
												</html:tabs-content>																								<html:tabs-content contentOf="tab4">																					<html:code>																												&lt;html:view&gt;
			
			&lt;html:input name="input1" value="Valor 0"/&gt;
			&lt;html:input name="input2" disabled="true"/&gt;
			
			&lt;html:jsEvent attachTo="input1" event="blur"&gt;
			     datas();
			&lt;/html:jsEvent&gt;
		
			&lt;ajax:function name="dados" url="/app/ajax"&gt;
				&lt;ajax:parameters&gt;
					&lt;ajax:parameter name="input1" src="input1" type="val" /&gt;
				&lt;/ajax:parameters&gt;
			    &lt;ajax:onSuccess&gt;
			          &lt;ajax:target type="val" data="field" target="input2"/&gt;
			    &lt;/ajax:onSuccess&gt;
			    &lt;ajax:onError&gt;
			           
			    &lt;/ajax:onError&gt;
			&lt;/ajax:function&gt;
		
		&lt;/html:view&gt;												</html:code>																									</html:tabs-content>																							</html:tabs-body> 																								</html:tabs>																									</html:card-body>																								</html:card>																									</html:view>																			