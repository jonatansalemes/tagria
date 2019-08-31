<%@include file="../app/taglibs.jsp"  %>																							<html:view title="{title}" template="master" attribute="body">																													<html:card>																														<html:cardHeader>																				onSuccess							</html:cardHeader>																											<html:cardBody>																												<html:tabs>																														<html:tabsHeader>																												<html:tabsTab active="true" labelKey="about" id="tab1"></html:tabsTab> 												<html:tabsTab labelKey="attributes" id="tab2"></html:tabsTab> 														<html:tabsTab labelKey="demo" id="tab3"></html:tabsTab> 																<html:tabsTab labelKey="source" id="tab4"></html:tabsTab> 														</html:tabsHeader> 																										<html:tabsBody> 																												<html:tabsContent active="true" contentOf="tab1">																			<html:alert state="warning">													Renders success block if the ajax request run smoothly											</html:alert>																											</html:tabsContent>																										<html:tabsContent contentOf="tab2">												<html:alert state="info" labelKey="tag.empty.attributes"></html:alert>										</html:tabsContent>																								<html:tabsContent contentOf="tab3">										
			<html:input name="input1" value="Valor 0"/>
		
			<ajax:function name="dados" url="/app/ajax" execute="true">
				<ajax:parameters>
					<ajax:parameter name="input1" src="input1" type="val" />
				</ajax:parameters>
			    <ajax:onSuccess>
			    	   /* function signature is f(data,textStatus,jqXHR):void. data: result data response, textStatus: status response text,jqXHR: ajax request object */ 
			           alert(textStatus);
			           alert(data);
			           alert(jqXHR);
			    </ajax:onSuccess>
			    <ajax:onError>
			          
			    </ajax:onError>
			</ajax:function>
												</html:tabsContent>																								<html:tabsContent contentOf="tab4">																					<html:code>																												&lt;html:view&gt;
			&lt;html:input name="input1" value="Valor 0"/&gt;
		
			&lt;ajax:function name="dados" url="/app/ajax" execute="true"&gt;
				&lt;ajax:parameters&gt;
					&lt;ajax:parameter name="input1" src="input1" type="val" /&gt;
				&lt;/ajax:parameters&gt;
			    &lt;ajax:onSuccess&gt;
			    	   /* function signature is f(data,textStatus,jqXHR):void. data: result data response, textStatus: status response text,jqXHR: ajax request object */ 
			           alert(textStatus);
			           alert(data);
			           alert(jqXHR);
			    &lt;/ajax:onSuccess&gt;
			    &lt;ajax:onError&gt;
			          
			    &lt;/ajax:onError&gt;
			&lt;/ajax:function&gt;
		&lt;/html:view&gt;												</html:code>																									</html:tabsContent>																							</html:tabsBody> 																								</html:tabs>																									</html:cardBody>																								</html:card>																									</html:view>																			