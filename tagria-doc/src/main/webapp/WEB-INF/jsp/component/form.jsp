<%@include file="../app/taglibs.jsp"%>										<html:view title="{title}">																	<html:card>																									<html:cardHeader>															form							</html:cardHeader>																						<html:cardBody>																								<html:tabPanel>																									<html:tab label="{about}" active="true">																	<html:alert state="warning">																				     	Renders a form																			</html:alert>																							</html:tab>																									<html:tab label="{attributes}">										<html:table stripe="true" hover="true"><html:tableHeader light="true"><html:tableLine><html:tableHead><fmt:message key="tag.attribute"/></html:tableHead><html:tableHead><fmt:message key="tag.required"/></html:tableHead><html:tableHead><fmt:message key="tag.type"/></html:tableHead><html:tableHead><fmt:message key="tag.description"/></html:tableHead></html:tableLine></html:tableHeader><html:tableBody><html:tableLine><html:tableColumn>action</html:tableColumn><html:tableColumn>false</html:tableColumn><html:tableColumn>java.lang.String</html:tableColumn><html:tableColumn>Indicates the action of submission</html:tableColumn></html:tableLine><html:tableLine><html:tableColumn>target</html:tableColumn><html:tableColumn>false</html:tableColumn><html:tableColumn>java.lang.String</html:tableColumn><html:tableColumn>Indicates the target of submission. Default : _self. Options : _blank,_self,_parent,_top,iframe</html:tableColumn></html:tableLine><html:tableLine><html:tableColumn>method</html:tableColumn><html:tableColumn>false</html:tableColumn><html:tableColumn>java.lang.String</html:tableColumn><html:tableColumn>It indicates the method to be used. Default: post. Options: post, get</html:tableColumn></html:tableLine><html:tableLine><html:tableColumn>name</html:tableColumn><html:tableColumn>false</html:tableColumn><html:tableColumn>java.lang.String</html:tableColumn><html:tableColumn>Indicates the name of form</html:tableColumn></html:tableLine><html:tableLine><html:tableColumn>validation</html:tableColumn><html:tableColumn>false</html:tableColumn><html:tableColumn>java.lang.String</html:tableColumn><html:tableColumn>It indicates a validation to be performed on the data form</html:tableColumn></html:tableLine><html:tableLine><html:tableColumn>label</html:tableColumn><html:tableColumn>false</html:tableColumn><html:tableColumn>java.lang.String</html:tableColumn><html:tableColumn>Indicates the label of the form</html:tableColumn></html:tableLine><html:tableLine><html:tableColumn>rendered</html:tableColumn><html:tableColumn>false</html:tableColumn><html:tableColumn>java.lang.Boolean</html:tableColumn><html:tableColumn>It indicates whether the component should be rendered</html:tableColumn></html:tableLine><html:tableLine><html:tableColumn>border</html:tableColumn><html:tableColumn>false</html:tableColumn><html:tableColumn>java.lang.Boolean</html:tableColumn><html:tableColumn>It indicates if component has border. Default true</html:tableColumn></html:tableLine><html:tableLine><html:tableColumn>inline</html:tableColumn><html:tableColumn>false</html:tableColumn><html:tableColumn>java.lang.Boolean</html:tableColumn><html:tableColumn>It indicates form to be inline. Default false</html:tableColumn></html:tableLine><html:tableLine><html:tableColumn>multipart</html:tableColumn><html:tableColumn>false</html:tableColumn><html:tableColumn>java.lang.Boolean</html:tableColumn><html:tableColumn>It indicates whether the form should have file support</html:tableColumn></html:tableLine></html:tableBody></html:table>																																	</html:tab>																									<html:tab label="{demo}">																						
		
			<html:form action="#">
				<html:formGroup label="Field 1" required="true">
					<html:input required="true" name="field1"/>
				</html:formGroup>
				<html:formGroup label="Field 2">
					<html:input name="field2"/>
				</html:formGroup>
				<html:toolbar>
					<html:buttonGroup>
						<html:button type="submit" label="Save"/>
					</html:buttonGroup>
				</html:toolbar>
			</html:form> 																							</html:tab>																									<html:tab label="{source}">																					<html:code>																										&lt;html:view&gt;
		
			&lt;html:form action="#"&gt;
				&lt;html:formGroup label="Field 1" required="true"&gt;
					&lt;html:input required="true" name="field1"/&gt;
				&lt;/html:formGroup&gt;
				&lt;html:formGroup label="Field 2"&gt;
					&lt;html:input name="field2"/&gt;
				&lt;/html:formGroup&gt;
				&lt;html:toolbar&gt;
					&lt;html:buttonGroup&gt;
						&lt;html:button type="submit" label="Save"/&gt;
					&lt;/html:buttonGroup&gt;
				&lt;/html:toolbar&gt;
			&lt;/html:form&gt; &lt;/html:view&gt;																					</html:code>																							</html:tab>																								</html:tabPanel>																						</html:cardBody>																						</html:card>																							</html:view>																			