<%@include file="../app/taglibs.jsp"%>																							<html:view title="{title}">																													<html:card>																														<html:card-header>																				form							</html:card-header>																											<html:card-body>																												<html:tabs>																														<html:tabs-header>																												<html:tabs-tab active="true" labelKey="about" id="tab1"></html:tabs-tab> 												<html:tabs-tab labelKey="attributes" id="tab2"></html:tabs-tab> 														<html:tabs-tab labelKey="demo" id="tab3"></html:tabs-tab> 																<html:tabs-tab labelKey="source" id="tab4"></html:tabs-tab> 														</html:tabs-header> 																										<html:tabs-body> 																												<html:tabs-content active="true" contentOf="tab1">																			<html:alert state="warning">													Renders a form											</html:alert>																											</html:tabs-content>																										<html:tabs-content contentOf="tab2">												<html:table stripe="true" hover="true"><html:table-header light="true"><html:table-row><html:table-head><fmt:message key="tag.attribute"/></html:table-head><html:table-head><fmt:message key="tag.required"/></html:table-head><html:table-head><fmt:message key="tag.type"/></html:table-head><html:table-head><fmt:message key="tag.description"/></html:table-head></html:table-row></html:table-header><html:table-body><html:table-row><html:table-data>action</html:table-data><html:table-data>false</html:table-data><html:table-data>java.lang.String</html:table-data><html:table-data>Indicates the action of submission</html:table-data></html:table-row><html:table-row><html:table-data>label</html:table-data><html:table-data>false</html:table-data><html:table-data>java.lang.String</html:table-data><html:table-data>Indicates the label of the form</html:table-data></html:table-row><html:table-row><html:table-data>labelKey</html:table-data><html:table-data>false</html:table-data><html:table-data>java.lang.String</html:table-data><html:table-data>Indicates the localize (i18n) label key of the form</html:table-data></html:table-row><html:table-row><html:table-data>target</html:table-data><html:table-data>false</html:table-data><html:table-data>java.lang.String</html:table-data><html:table-data>Indicates the target of submission. Default : _self. Options : _blank,_self,_parent,_top,iframe</html:table-data></html:table-row><html:table-row><html:table-data>method</html:table-data><html:table-data>false</html:table-data><html:table-data>java.lang.String</html:table-data><html:table-data>It indicates the method to be used. Default: post. Options: post, get</html:table-data></html:table-row><html:table-row><html:table-data>name</html:table-data><html:table-data>false</html:table-data><html:table-data>java.lang.String</html:table-data><html:table-data>Indicates the name of form</html:table-data></html:table-row><html:table-row><html:table-data>validation</html:table-data><html:table-data>false</html:table-data><html:table-data>java.lang.String</html:table-data><html:table-data>It indicates a validation to be performed on the data form</html:table-data></html:table-row><html:table-row><html:table-data>rendered</html:table-data><html:table-data>false</html:table-data><html:table-data>java.lang.Boolean</html:table-data><html:table-data>It indicates whether the component should be rendered</html:table-data></html:table-row><html:table-row><html:table-data>multipart</html:table-data><html:table-data>false</html:table-data><html:table-data>java.lang.Boolean</html:table-data><html:table-data>It indicates whether the form should have file support</html:table-data></html:table-row></html:table-body></html:table>										</html:tabs-content>																								<html:tabs-content contentOf="tab3">										
			<html:form action="#" label="My title">
				<html:form-group label="Field 1" required="true">
					<html:input required="true" name="field1"/>
				</html:form-group>
				<html:form-group label="Field 2">
					<html:input name="field2"/>
				</html:form-group>
				<html:form-group-multiple label="Fields group">
					<html:input name="fields3[]"/>
				</html:form-group-multiple>				
				<html:form-toolbar>
				    <html:button state="primary" type="submit" label="Label for submit"/>
				</html:form-toolbar>
			</html:form> 
												</html:tabs-content>																								<html:tabs-content contentOf="tab4">																					<html:code>																												&lt;html:view&gt;
			&lt;html:form action="#" label="My title"&gt;
				&lt;html:form-group label="Field 1" required="true"&gt;
					&lt;html:input required="true" name="field1"/&gt;
				&lt;/html:form-group&gt;
				&lt;html:form-group label="Field 2"&gt;
					&lt;html:input name="field2"/&gt;
				&lt;/html:form-group&gt;
				&lt;html:form-group-multiple label="Fields group"&gt;
					&lt;html:input name="fields3[]"/&gt;
				&lt;/html:form-group-multiple&gt;				
				&lt;html:form-toolbar&gt;
				    &lt;html:button state="primary" type="submit" label="Label for submit"/&gt;
				&lt;/html:form-toolbar&gt;
			&lt;/html:form&gt; 
		&lt;/html:view&gt;												</html:code>																									</html:tabs-content>																							</html:tabs-body> 																								</html:tabs>																									</html:card-body>																								</html:card>																									</html:view>																			