<%@include file="../app/taglibs.jsp"  %>																							<html:view title="{title}" template="master" attribute="body">																													<html:card>																														<html:cardHeader>																				formGroupMultipleOnAfterRemove							</html:cardHeader>																											<html:cardBody>																												<html:tabs>																														<html:tabsHeader>																												<html:tabsTab active="true" labelKey="about" id="tab1"></html:tabsTab> 												<html:tabsTab labelKey="attributes" id="tab2"></html:tabsTab> 														<html:tabsTab labelKey="demo" id="tab3"></html:tabsTab> 																<html:tabsTab labelKey="source" id="tab4"></html:tabsTab> 														</html:tabsHeader> 																										<html:tabsBody> 																												<html:tabsContent active="true" contentOf="tab1">																			<html:alert state="warning">													Renders a javascript block to be performed after remove a row											</html:alert>																											</html:tabsContent>																										<html:tabsContent contentOf="tab2">												<html:alert state="info" labelKey="tag.empty.attributes"></html:alert>										</html:tabsContent>																								<html:tabsContent contentOf="tab3">										
			<html:form action="#" label="My title">
			
				<html:formGroupMultiple label="Fields group">
					<html:formGroupMultipleOnAfterRemove>
					    /* function signature is f():void */      
					    
					</html:formGroupMultipleOnAfterRemove>
					<html:input name="fields3[]"/>
				</html:formGroupMultiple>	
				<html:formToolbar>
				    <html:button state="primary" type="submit" label="Label for submit"/>
				</html:formToolbar>
			</html:form> 
												</html:tabsContent>																								<html:tabsContent contentOf="tab4">																					<html:code>																												&lt;html:view&gt;
			&lt;html:form action="#" label="My title"&gt;
			
				&lt;html:formGroupMultiple label="Fields group"&gt;
					&lt;html:formGroupMultipleOnAfterRemove&gt;
					    /* function signature is f():void */      
					    
					&lt;/html:formGroupMultipleOnAfterRemove&gt;
					&lt;html:input name="fields3[]"/&gt;
				&lt;/html:formGroupMultiple&gt;	
				&lt;html:formToolbar&gt;
				    &lt;html:button state="primary" type="submit" label="Label for submit"/&gt;
				&lt;/html:formToolbar&gt;
			&lt;/html:form&gt; 
		&lt;/html:view&gt;												</html:code>																									</html:tabsContent>																							</html:tabsBody> 																								</html:tabs>																									</html:cardBody>																								</html:card>																									</html:view>																			