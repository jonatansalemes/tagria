<%@include file="../app/taglibs.jsp"%>																							<html:view title="{title}">																													<html:card>																														<html:card-header>																				form-on-before-submit							</html:card-header>																											<html:card-body>																												<html:tabs>																														<html:tabs-header>																												<html:tabs-tab active="true" labelKey="about" id="tab1"></html:tabs-tab> 												<html:tabs-tab labelKey="attributes" id="tab2"></html:tabs-tab> 														<html:tabs-tab labelKey="demo" id="tab3"></html:tabs-tab> 																<html:tabs-tab labelKey="source" id="tab4"></html:tabs-tab> 														</html:tabs-header> 																										<html:tabs-body> 																												<html:tabs-content active="true" contentOf="tab1">																			<html:alert state="warning">													Renders a before submit block											</html:alert>																											</html:tabs-content>																										<html:tabs-content contentOf="tab2">												<html:alert state="info" labelKey="tag.empty.attributes"></html:alert>										</html:tabs-content>																								<html:tabs-content contentOf="tab3">										
			<html:form action="#" label="My title">
				<html:form-on-before-submit>
				    //function signature is f():boolean (true to continue submit and false to cancel submit)
				    //do some checking here
					return true;
				</html:form-on-before-submit>
				<html:form-toolbar>
				    <html:button state="primary" type="submit" label="Label for submit"/>
				</html:form-toolbar>
			</html:form> 
												</html:tabs-content>																								<html:tabs-content contentOf="tab4">																					<html:code>																												&lt;html:view&gt;
			&lt;html:form action="#" label="My title"&gt;
				&lt;html:form-on-before-submit&gt;
				    //function signature is f():boolean (true to continue submit and false to cancel submit)
				    //do some checking here
					return true;
				&lt;/html:form-on-before-submit&gt;
				&lt;html:form-toolbar&gt;
				    &lt;html:button state="primary" type="submit" label="Label for submit"/&gt;
				&lt;/html:form-toolbar&gt;
			&lt;/html:form&gt; 
		&lt;/html:view&gt;												</html:code>																									</html:tabs-content>																							</html:tabs-body> 																								</html:tabs>																									</html:card-body>																								</html:card>																									</html:view>																			