<%@include file="../app/taglibs.jsp"  %>																							<html:view title="{title}" template="master" attribute="body">																													<html:card>																														<html:card-header>																				function							</html:card-header>																											<html:card-body>																												<html:tabs>																														<html:tabs-header>																												<html:tabs-tab active="true" labelKey="about" id="tab1"></html:tabs-tab> 												<html:tabs-tab labelKey="attributes" id="tab2"></html:tabs-tab> 														<html:tabs-tab labelKey="demo" id="tab3"></html:tabs-tab> 																<html:tabs-tab labelKey="source" id="tab4"></html:tabs-tab> 														</html:tabs-header> 																										<html:tabs-body> 																												<html:tabs-content active="true" contentOf="tab1">																			<html:alert state="warning">													Renders an ajax function											</html:alert>																											</html:tabs-content>																										<html:tabs-content contentOf="tab2">												<html:table stripe="true" hover="true"><html:table-header light="true"><html:table-row><html:table-head><fmt:message key="tag.attribute"/></html:table-head><html:table-head><fmt:message key="tag.required"/></html:table-head><html:table-head><fmt:message key="tag.type"/></html:table-head><html:table-head><fmt:message key="tag.description"/></html:table-head></html:table-row></html:table-header><html:table-body><html:table-row><html:table-data>dataType</html:table-data><html:table-data>false</html:table-data><html:table-data>java.lang.String</html:table-data><html:table-data>Indicates the type of return expected by ajax request. Default: json. Options: xml, json, script, html, jsonp, text</html:table-data></html:table-row><html:table-row><html:table-data>execute</html:table-data><html:table-data>false</html:table-data><html:table-data>java.lang.Boolean</html:table-data><html:table-data>It indicates whether the ajax function should be run to load the DOM. Default: false.</html:table-data></html:table-row><html:table-row><html:table-data>name</html:table-data><html:table-data>true</html:table-data><html:table-data>java.lang.String</html:table-data><html:table-data>It indicates the name of the ajax function</html:table-data></html:table-row><html:table-row><html:table-data>url</html:table-data><html:table-data>true</html:table-data><html:table-data>java.lang.String</html:table-data><html:table-data>Indicates the url to be called by the Ajax request</html:table-data></html:table-row><html:table-row><html:table-data>rendered</html:table-data><html:table-data>false</html:table-data><html:table-data>java.lang.Boolean</html:table-data><html:table-data>It indicates whether the component should be rendered. Default : true</html:table-data></html:table-row></html:table-body></html:table>										</html:tabs-content>																								<html:tabs-content contentOf="tab3">										
			<html:input name="input1" value="Valor 0"/>
			
			<html:js-event attachTo="input1" event="blur">
			     checkForUrl();
			</html:js-event>
		
			<ajax:function name="checkForUrl" url="/app/ajax">
				<ajax:parameters>
					<ajax:parameter name="input1" src="input1" type="val" />
				</ajax:parameters>
			    <ajax:on-success>
			           //function signature is f(data,textStatus,jqXHR):void. data: result data response, textStatus: status response text,jqXHR: ajax request object  */
			           alert('Value was sent' + data.field);
			    </ajax:on-success>
			    <ajax:on-error>
			           
			    </ajax:on-error>
			</ajax:function>
												</html:tabs-content>																								<html:tabs-content contentOf="tab4">																					<html:code>																												&lt;html:view&gt;
			&lt;html:input name="input1" value="Valor 0"/&gt;
			
			&lt;html:js-event attachTo="input1" event="blur"&gt;
			     checkForUrl();
			&lt;/html:js-event&gt;
		
			&lt;ajax:function name="checkForUrl" url="/app/ajax"&gt;
				&lt;ajax:parameters&gt;
					&lt;ajax:parameter name="input1" src="input1" type="val" /&gt;
				&lt;/ajax:parameters&gt;
			    &lt;ajax:on-success&gt;
			           //function signature is f(data,textStatus,jqXHR):void. data: result data response, textStatus: status response text,jqXHR: ajax request object  */
			           alert('Value was sent' + data.field);
			    &lt;/ajax:on-success&gt;
			    &lt;ajax:on-error&gt;
			           
			    &lt;/ajax:on-error&gt;
			&lt;/ajax:function&gt;
		&lt;/html:view&gt;												</html:code>																									</html:tabs-content>																							</html:tabs-body> 																								</html:tabs>																									</html:card-body>																								</html:card>																									</html:view>																			