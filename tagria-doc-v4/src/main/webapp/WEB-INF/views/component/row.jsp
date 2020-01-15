<%@include file="../app/taglibs.jsp"  %>																							<html:view title="{title}" template="master">					<html:template render="body">																													<html:card>																														<html:cardHeader>																				row							</html:cardHeader>																											<html:cardBody>																												<html:tabs>																														<html:tabsHeader>																												<html:tabsTab active="true" labelKey="about" id="tab1"></html:tabsTab> 												<html:tabsTab labelKey="attributes" id="tab2"></html:tabsTab> 														<html:tabsTab labelKey="demo" id="tab3"></html:tabsTab> 																<html:tabsTab labelKey="source" id="tab4"></html:tabsTab> 														</html:tabsHeader> 																										<html:tabsBody> 																												<html:tabsContent active="true" contentOf="tab1">																			<html:alert state="warning">													Renders a line of columns of subdivision (divided into 12 sections combined with the col tag)											</html:alert>																											</html:tabsContent>																										<html:tabsContent contentOf="tab2">												<html:alert state="info" labelKey="tag.empty.attributes"></html:alert>										</html:tabsContent>																								<html:tabsContent contentOf="tab3">										
			<html:form action="#">
				<html:formGroup forElement="field1" label="Field 1" required="true">
					<html:row>
						<html:col extraSmall="6">
							<html:input required="true" name="field1"/>
						</html:col>
						<html:col extraSmall="6">
							<html:input name="field2"/>
						</html:col>
					</html:row>
				</html:formGroup>
			</html:form> 
												</html:tabsContent>																								<html:tabsContent contentOf="tab4">																					<html:code>																												&lt;html:view&gt;
			&lt;html:form action="#"&gt;
				&lt;html:formGroup forElement="field1" label="Field 1" required="true"&gt;
					&lt;html:row&gt;
						&lt;html:col extraSmall="6"&gt;
							&lt;html:input required="true" name="field1"/&gt;
						&lt;/html:col&gt;
						&lt;html:col extraSmall="6"&gt;
							&lt;html:input name="field2"/&gt;
						&lt;/html:col&gt;
					&lt;/html:row&gt;
				&lt;/html:formGroup&gt;
			&lt;/html:form&gt; 
		&lt;/html:view&gt;												</html:code>																									</html:tabsContent>																							</html:tabsBody> 																								</html:tabs>																									</html:cardBody>																								</html:card>																									    </html:template> 																							</html:view>																			