<%@include file="../app/taglibs.jsp"  %>																							<html:view title="{title}" template="master">					<html:template render="body">																													<html:card>																														<html:cardHeader>																				maskOnKeypress							</html:cardHeader>																											<html:cardBody>																												<html:tabs>																														<html:tabsHeader>																												<html:tabsTab active="true" labelKey="about" id="tab1"></html:tabsTab> 												<html:tabsTab labelKey="attributes" id="tab2"></html:tabsTab> 														<html:tabsTab labelKey="demo" id="tab3"></html:tabsTab> 																<html:tabsTab labelKey="source" id="tab4"></html:tabsTab> 														</html:tabsHeader> 																										<html:tabsBody> 																												<html:tabsContent active="true" contentOf="tab1">																			<html:alert state="warning">													Renders event on mask after any key press											</html:alert>																											</html:tabsContent>																										<html:tabsContent contentOf="tab2">												<html:alert state="info" labelKey="tag.empty.attributes"></html:alert>										</html:tabsContent>																								<html:tabsContent contentOf="tab3">										
			<html:input name="teste"/>
			<html:mask mask="(00) 0000-00000" attachTo="teste">
				<html:maskOnKeypress>
				    var masks = ['(00) 0000-00000', '(00) 00000-0000'];
					mask = (value.length > 14) ? masks[1] : masks[0];
					$('#'+$(field[0]).attr('id')).mask(mask,options);
				</html:maskOnKeypress>
			</html:mask> 
												</html:tabsContent>																								<html:tabsContent contentOf="tab4">																					<html:code>																												&lt;html:view&gt;
			&lt;html:input name="teste"/&gt;
			&lt;html:mask mask="(00) 0000-00000" attachTo="teste"&gt;
				&lt;html:maskOnKeypress&gt;
				    var masks = ['(00) 0000-00000', '(00) 00000-0000'];
					mask = (value.length &gt; 14) ? masks[1] : masks[0];
					\$('#'+\$(field[0]).attr('id')).mask(mask,options);
				&lt;/html:maskOnKeypress&gt;
			&lt;/html:mask&gt; 
		&lt;/html:view&gt;												</html:code>																									</html:tabsContent>																							</html:tabsBody> 																								</html:tabs>																									</html:cardBody>																								</html:card>																									    </html:template> 																							</html:view>																			