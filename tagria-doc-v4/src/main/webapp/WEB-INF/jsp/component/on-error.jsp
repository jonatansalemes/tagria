<%@include file="../app/taglibs.jsp"  %>																							<html:view title="{title}" template="master" attribute="body">																													<html:card>																														<html:card-header>																				on-error							</html:card-header>																											<html:card-body>																												<html:tabs>																														<html:tabs-header>																												<html:tabs-tab active="true" labelKey="about" id="tab1"></html:tabs-tab> 												<html:tabs-tab labelKey="attributes" id="tab2"></html:tabs-tab> 														<html:tabs-tab labelKey="demo" id="tab3"></html:tabs-tab> 																<html:tabs-tab labelKey="source" id="tab4"></html:tabs-tab> 														</html:tabs-header> 																										<html:tabs-body> 																												<html:tabs-content active="true" contentOf="tab1">																			<html:alert state="warning">													Renders the error block if they occur in ajax request											</html:alert>																											</html:tabs-content>																										<html:tabs-content contentOf="tab2">												<html:alert state="info" labelKey="tag.empty.attributes"></html:alert>										</html:tabs-content>																								<html:tabs-content contentOf="tab3">										
			<ajax:function name="checkForUrl" url="/app/url/not/found" execute="true">
			    <ajax:on-success>
			    	      
			    </ajax:on-success>
			    <ajax:on-error>
			           //function signature is f(jqXHR,textStatus,errorThrown):void. jqXHR: ajax request object,textStatus: status response text,errorThrown: error response text  */
			           alert(textStatus);
			           alert(errorThrown);
			           alert(jqXHR);
			    </ajax:on-error>
			</ajax:function>
												</html:tabs-content>																								<html:tabs-content contentOf="tab4">																					<html:code>																												&lt;html:view&gt;
			&lt;ajax:function name="checkForUrl" url="/app/url/not/found" execute="true"&gt;
			    &lt;ajax:on-success&gt;
			    	      
			    &lt;/ajax:on-success&gt;
			    &lt;ajax:on-error&gt;
			           //function signature is f(jqXHR,textStatus,errorThrown):void. jqXHR: ajax request object,textStatus: status response text,errorThrown: error response text  */
			           alert(textStatus);
			           alert(errorThrown);
			           alert(jqXHR);
			    &lt;/ajax:on-error&gt;
			&lt;/ajax:function&gt;
		&lt;/html:view&gt;												</html:code>																									</html:tabs-content>																							</html:tabs-body> 																								</html:tabs>																									</html:card-body>																								</html:card>																									</html:view>																			