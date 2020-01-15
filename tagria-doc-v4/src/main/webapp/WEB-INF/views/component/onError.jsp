<%@include file="../app/taglibs.jsp"  %>																							<html:view title="{title}" template="master">					<html:template render="body">																													<html:card>																														<html:cardHeader>																				onError							</html:cardHeader>																											<html:cardBody>																												<html:tabs>																														<html:tabsHeader>																												<html:tabsTab active="true" labelKey="about" id="tab1"></html:tabsTab> 												<html:tabsTab labelKey="attributes" id="tab2"></html:tabsTab> 														<html:tabsTab labelKey="demo" id="tab3"></html:tabsTab> 																<html:tabsTab labelKey="source" id="tab4"></html:tabsTab> 														</html:tabsHeader> 																										<html:tabsBody> 																												<html:tabsContent active="true" contentOf="tab1">																			<html:alert state="warning">													Renders the error block if they occur in ajax request											</html:alert>																											</html:tabsContent>																										<html:tabsContent contentOf="tab2">												<html:alert state="info" labelKey="tag.empty.attributes"></html:alert>										</html:tabsContent>																								<html:tabsContent contentOf="tab3">										
			<ajax:function name="checkForUrl" url="/app/url/not/found" execute="true">
			    <ajax:onSuccess>
			    	      
			    </ajax:onSuccess>
			    <ajax:onError>
			           /* function signature is f(jqXHR,textStatus,errorThrown):void. jqXHR: ajax request object,textStatus: status response text,errorThrown: error response text */
			           alert(textStatus);
			           alert(errorThrown);
			           alert(jqXHR);
			    </ajax:onError>
			</ajax:function>
												</html:tabsContent>																								<html:tabsContent contentOf="tab4">																					<html:code>																												&lt;html:view&gt;
			&lt;ajax:function name="checkForUrl" url="/app/url/not/found" execute="true"&gt;
			    &lt;ajax:onSuccess&gt;
			    	      
			    &lt;/ajax:onSuccess&gt;
			    &lt;ajax:onError&gt;
			           /* function signature is f(jqXHR,textStatus,errorThrown):void. jqXHR: ajax request object,textStatus: status response text,errorThrown: error response text */
			           alert(textStatus);
			           alert(errorThrown);
			           alert(jqXHR);
			    &lt;/ajax:onError&gt;
			&lt;/ajax:function&gt;
		&lt;/html:view&gt;												</html:code>																									</html:tabsContent>																							</html:tabsBody> 																								</html:tabs>																									</html:cardBody>																								</html:card>																									    </html:template> 																							</html:view>																			