<%@include file="../app/taglibs.jsp"  %>																							<html:view title="{title}" template="master" attribute="body">																													<html:card>																														<html:card-header>																				autocomplete-on-select							</html:card-header>																											<html:card-body>																												<html:tabs>																														<html:tabs-header>																												<html:tabs-tab active="true" labelKey="about" id="tab1"></html:tabs-tab> 												<html:tabs-tab labelKey="attributes" id="tab2"></html:tabs-tab> 														<html:tabs-tab labelKey="demo" id="tab3"></html:tabs-tab> 																<html:tabs-tab labelKey="source" id="tab4"></html:tabs-tab> 														</html:tabs-header> 																										<html:tabs-body> 																												<html:tabs-content active="true" contentOf="tab1">																			<html:alert state="warning">													Renders an onSelect 											</html:alert>																											</html:tabs-content>																										<html:tabs-content contentOf="tab2">												<html:alert state="info" labelKey="tag.empty.attributes"></html:alert>										</html:tabs-content>																								<html:tabs-content contentOf="tab3">										
			<html:autocomplete url="/app/autocomplete" name="myautocomplete">
				<html:autocomplete-on-select>
					//function signature is f(value,text):void. value: value of item selected, text: text of item selected      
					console.log(value);
					console.log(text);
				</html:autocomplete-on-select>
			</html:autocomplete>
												</html:tabs-content>																								<html:tabs-content contentOf="tab4">																					<html:code>																												&lt;html:view&gt;
			&lt;html:autocomplete url="/app/autocomplete" name="myautocomplete"&gt;
				&lt;html:autocomplete-on-select&gt;
					//function signature is f(value,text):void. value: value of item selected, text: text of item selected      
					console.log(value);
					console.log(text);
				&lt;/html:autocomplete-on-select&gt;
			&lt;/html:autocomplete&gt;
		&lt;/html:view&gt;												</html:code>																									</html:tabs-content>																							</html:tabs-body> 																								</html:tabs>																									</html:card-body>																								</html:card>																									</html:view>																			