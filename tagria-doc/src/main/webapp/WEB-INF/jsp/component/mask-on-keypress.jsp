<%@include file="../app/taglibs.jsp"%>																							<html:view title="{title}">																													<html:card>																														<html:card-header>																				mask-on-keypress							</html:card-header>																											<html:card-body>																												<html:tabs>																														<html:tabs-header>																												<html:tabs-tab active="true" labelKey="about" id="tab1"></html:tabs-tab> 												<html:tabs-tab labelKey="attributes" id="tab2"></html:tabs-tab> 														<html:tabs-tab labelKey="demo" id="tab3"></html:tabs-tab> 																<html:tabs-tab labelKey="source" id="tab4"></html:tabs-tab> 														</html:tabs-header> 																										<html:tabs-body> 																												<html:tabs-content active="true" contentOf="tab1">																			<html:alert state="warning">													Renders event on mask after any key press											</html:alert>																											</html:tabs-content>																										<html:tabs-content contentOf="tab2">												<html:alert state="info" labelKey="tag.empty.attributes"></html:alert>										</html:tabs-content>																								<html:tabs-content contentOf="tab3">										
			<html:input name="teste"/>
			<html:mask mask="(00) 0000-00000" attachTo="teste">
				<html:mask-on-keypress>
				    var masks = ['(00) 0000-00000', '(00) 00000-0000'];
					mask = (value.length > 14) ? masks[1] : masks[0];
					$('#'+$(field[0]).attr('id')).mask(mask,options);
				</html:mask-on-keypress>
			</html:mask> 
												</html:tabs-content>																								<html:tabs-content contentOf="tab4">																					<html:code>																												&lt;html:view&gt;
			&lt;html:input name="teste"/&gt;
			&lt;html:mask mask="(00) 0000-00000" attachTo="teste"&gt;
				&lt;html:mask-on-keypress&gt;
				    var masks = ['(00) 0000-00000', '(00) 00000-0000'];
					mask = (value.length &gt; 14) ? masks[1] : masks[0];
					\$('#'+\$(field[0]).attr('id')).mask(mask,options);
				&lt;/html:mask-on-keypress&gt;
			&lt;/html:mask&gt; 
		&lt;/html:view&gt;												</html:code>																									</html:tabs-content>																							</html:tabs-body> 																								</html:tabs>																									</html:card-body>																								</html:card>																									</html:view>																			