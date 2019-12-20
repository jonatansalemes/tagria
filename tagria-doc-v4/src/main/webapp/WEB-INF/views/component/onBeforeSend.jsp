<%@include file="../app/taglibs.jsp"  %>																							<html:view title="{title}" template="master">					<html:template render="body">																													<html:card>																														<html:cardHeader>																				onBeforeSend							</html:cardHeader>																											<html:cardBody>																												<html:tabs>																														<html:tabsHeader>																												<html:tabsTab active="true" labelKey="about" id="tab1"></html:tabsTab> 												<html:tabsTab labelKey="attributes" id="tab2"></html:tabsTab> 														<html:tabsTab labelKey="demo" id="tab3"></html:tabsTab> 																<html:tabsTab labelKey="source" id="tab4"></html:tabsTab> 														</html:tabsHeader> 																										<html:tabsBody> 																												<html:tabsContent active="true" contentOf="tab1">																			<html:alert state="warning">													Renders before send block on ajax request											</html:alert>																											</html:tabsContent>																										<html:tabsContent contentOf="tab2">												<html:alert state="info" labelKey="tag.empty.attributes"></html:alert>										</html:tabsContent>																								<html:tabsContent contentOf="tab3">										
				<ajax:function name="data" url="/app/ajax" execute="true">
			    <ajax:onBeforeSend>
			    	   /* function signature is f(jqXHR,settings):void. jqXHR: ajax request object,settings: ajax settings object  */
			           alert(settings);
			           alert(jqXHR);
			    </ajax:onBeforeSend>
			</ajax:function>
												</html:tabsContent>																								<html:tabsContent contentOf="tab4">																					<html:code>																												&lt;html:view&gt;
				&lt;ajax:function name="data" url="/app/ajax" execute="true"&gt;
			    &lt;ajax:onBeforeSend&gt;
			    	   /* function signature is f(jqXHR,settings):void. jqXHR: ajax request object,settings: ajax settings object  */
			           alert(settings);
			           alert(jqXHR);
			    &lt;/ajax:onBeforeSend&gt;
			&lt;/ajax:function&gt;
		&lt;/html:view&gt;												</html:code>																									</html:tabsContent>																							</html:tabsBody> 																								</html:tabs>																									</html:cardBody>																								</html:card>																									    </html:template> 																							</html:view>																			