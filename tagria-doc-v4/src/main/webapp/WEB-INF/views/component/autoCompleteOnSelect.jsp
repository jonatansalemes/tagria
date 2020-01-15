<%@include file="../app/taglibs.jsp"  %>																							<html:view title="{title}" template="master">					<html:template render="body">																													<html:card>																														<html:cardHeader>																				autoCompleteOnSelect							</html:cardHeader>																											<html:cardBody>																												<html:tabs>																														<html:tabsHeader>																												<html:tabsTab active="true" labelKey="about" id="tab1"></html:tabsTab> 												<html:tabsTab labelKey="attributes" id="tab2"></html:tabsTab> 														<html:tabsTab labelKey="demo" id="tab3"></html:tabsTab> 																<html:tabsTab labelKey="source" id="tab4"></html:tabsTab> 														</html:tabsHeader> 																										<html:tabsBody> 																												<html:tabsContent active="true" contentOf="tab1">																			<html:alert state="warning">													Renders an onSelect 											</html:alert>																											</html:tabsContent>																										<html:tabsContent contentOf="tab2">												<html:alert state="info" labelKey="tag.empty.attributes"></html:alert>										</html:tabsContent>																								<html:tabsContent contentOf="tab3">										
			<html:autoComplete url="/app/autoComplete" name="myautoComplete">
				<html:autoCompleteOnSelect>
					/* function signature is f(value,text):void. value: value of item selected, text: text of item selected */      
					console.log(value);
					console.log(text);
				</html:autoCompleteOnSelect>
			</html:autoComplete>
												</html:tabsContent>																								<html:tabsContent contentOf="tab4">																					<html:code>																												&lt;html:view&gt;
			&lt;html:autoComplete url="/app/autoComplete" name="myautoComplete"&gt;
				&lt;html:autoCompleteOnSelect&gt;
					/* function signature is f(value,text):void. value: value of item selected, text: text of item selected */      
					console.log(value);
					console.log(text);
				&lt;/html:autoCompleteOnSelect&gt;
			&lt;/html:autoComplete&gt;
		&lt;/html:view&gt;												</html:code>																									</html:tabsContent>																							</html:tabsBody> 																								</html:tabs>																									</html:cardBody>																								</html:card>																									    </html:template> 																							</html:view>																			