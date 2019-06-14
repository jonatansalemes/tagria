<%@include file="../app/taglibs.jsp"%>																							<html:view title="{title}">																													<html:card>																														<html:card-header>																				form							</html:card-header>																											<html:card-body>																												<html:tabs>																														<html:tabs-header>																												<html:tabs-tab active="true" labelKey="about" id="tab1"></html:tabs-tab> 												<html:tabs-tab labelKey="attributes" id="tab2"></html:tabs-tab> 														<html:tabs-tab labelKey="demo" id="tab3"></html:tabs-tab> 																<html:tabs-tab labelKey="source" id="tab4"></html:tabs-tab> 														</html:tabs-header> 																										<html:tabs-body> 																												<html:tabs-content active="true" contentOf="tab1">																			<html:alert state="warning">													Renders a form											</html:alert>																											</html:tabs-content>																										<html:tabs-content contentOf="tab2">												<html:table stripe="true" hover="true"><html:thead light="true"><html:tr><html:th><fmt:message key="tag.attribute"/></html:th><html:th><fmt:message key="tag.required"/></html:th><html:th><fmt:message key="tag.type"/></html:th><html:th><fmt:message key="tag.description"/></html:th></html:tr></html:thead><html:tbody><html:tr><html:td>action</html:td><html:td>false</html:td><html:td>java.lang.String</html:td><html:td>Indicates the action of submission</html:td></html:tr><html:tr><html:td>label</html:td><html:td>false</html:td><html:td>java.lang.String</html:td><html:td>Indicates the label of the form</html:td></html:tr><html:tr><html:td>labelKey</html:td><html:td>false</html:td><html:td>java.lang.String</html:td><html:td>Indicates the localize (i18n) label key of the form</html:td></html:tr><html:tr><html:td>target</html:td><html:td>false</html:td><html:td>java.lang.String</html:td><html:td>Indicates the target of submission. Default : _self. Options : _blank,_self,_parent,_top,iframe</html:td></html:tr><html:tr><html:td>method</html:td><html:td>false</html:td><html:td>java.lang.String</html:td><html:td>It indicates the method to be used. Default: post. Options: post, get</html:td></html:tr><html:tr><html:td>name</html:td><html:td>false</html:td><html:td>java.lang.String</html:td><html:td>Indicates the name of form</html:td></html:tr><html:tr><html:td>validation</html:td><html:td>false</html:td><html:td>java.lang.String</html:td><html:td>It indicates a validation to be performed on the data form</html:td></html:tr><html:tr><html:td>rendered</html:td><html:td>false</html:td><html:td>java.lang.Boolean</html:td><html:td>It indicates whether the component should be rendered</html:td></html:tr><html:tr><html:td>multipart</html:td><html:td>false</html:td><html:td>java.lang.Boolean</html:td><html:td>It indicates whether the form should have file support</html:td></html:tr></html:tbody></html:table>										</html:tabs-content>																								<html:tabs-content contentOf="tab3">										
			<html:form action="#" label="My title">
			
				<html:form-body>
					<html:form-group label="Field 1" required="true">
						<html:input required="true" name="field1"/>
					</html:form-group>
					<html:form-group label="Field 2">
						<html:input name="field2"/>
					</html:form-group>
					<html:form-group-multiple label="Fields group">
						<html:input name="fields3[]"/>
					</html:form-group-multiple>
				</html:form-body>
					
				<html:form-toolbar>
				    <html:button state="primary" type="submit" label="Label for submit"/>
				</html:form-toolbar>
			</html:form> 
												</html:tabs-content>																								<html:tabs-content contentOf="tab4">																					<html:code>																												&lt;html:view&gt;
			&lt;html:form action="#" label="My title"&gt;
			
				&lt;html:form-body&gt;
					&lt;html:form-group label="Field 1" required="true"&gt;
						&lt;html:input required="true" name="field1"/&gt;
					&lt;/html:form-group&gt;
					&lt;html:form-group label="Field 2"&gt;
						&lt;html:input name="field2"/&gt;
					&lt;/html:form-group&gt;
					&lt;html:form-group-multiple label="Fields group"&gt;
						&lt;html:input name="fields3[]"/&gt;
					&lt;/html:form-group-multiple&gt;
				&lt;/html:form-body&gt;
					
				&lt;html:form-toolbar&gt;
				    &lt;html:button state="primary" type="submit" label="Label for submit"/&gt;
				&lt;/html:form-toolbar&gt;
			&lt;/html:form&gt; 
		&lt;/html:view&gt;												</html:code>																									</html:tabs-content>																							</html:tabs-body> 																								</html:tabs>																									</html:card-body>																								</html:card>																									</html:view>																			