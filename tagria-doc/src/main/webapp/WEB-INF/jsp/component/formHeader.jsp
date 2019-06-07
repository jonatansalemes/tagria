<%@include file="../app/taglibs.jsp"%>										<html:view title="{title}">																	<html:card>																									<html:cardHeader>															formHeader							</html:cardHeader>																						<html:cardBody>																								<html:tabPanel>																									<html:tab label="{about}" active="true">																	<html:alert state="warning">																				     	Renders a form header on the form component																			</html:alert>																							</html:tab>																									<html:tab label="{attributes}">										<html:table stripe="true" hover="true"><html:tableHeader light="true"><html:tableLine><html:tableHead><fmt:message key="tag.attribute"/></html:tableHead><html:tableHead><fmt:message key="tag.required"/></html:tableHead><html:tableHead><fmt:message key="tag.type"/></html:tableHead><html:tableHead><fmt:message key="tag.description"/></html:tableHead></html:tableLine></html:tableHeader><html:tableBody><html:tableLine><html:tableColumn>rendered</html:tableColumn><html:tableColumn>false</html:tableColumn><html:tableColumn>java.lang.Boolean</html:tableColumn><html:tableColumn>It indicates whether the component should be rendered</html:tableColumn></html:tableLine><html:tableLine><html:tableColumn>label</html:tableColumn><html:tableColumn>false</html:tableColumn><html:tableColumn>java.lang.String</html:tableColumn><html:tableColumn>Indicates the label of the form</html:tableColumn></html:tableLine><html:tableLine><html:tableColumn>labelKey</html:tableColumn><html:tableColumn>false</html:tableColumn><html:tableColumn>java.lang.String</html:tableColumn><html:tableColumn>Indicates the localize (i18n) label key of the form</html:tableColumn></html:tableLine></html:tableBody></html:table>																																	</html:tab>																									<html:tab label="{demo}">																						
			<html:form action="#">
				
				<html:formHeader label="My title">
				
				</html:formHeader>
				
				<html:formBody>
					<html:formGroup label="Campo 1" required="true">
						<html:input required="true" name="field1"/>
					</html:formGroup>
					<html:formGroup label="Campo 2">
						<html:input name="field2"/>
					</html:formGroup>
				</html:formBody>
					
				<html:formFooter>
				    <html:button state="primary" type="submit" label="Label for submit"/>
				</html:formFooter>
			</html:form> 																							</html:tab>																									<html:tab label="{source}">																					<html:code>																										&lt;html:view&gt;
			&lt;html:form action="#"&gt;
				
				&lt;html:formHeader label="My title"&gt;
				
				&lt;/html:formHeader&gt;
				
				&lt;html:formBody&gt;
					&lt;html:formGroup label="Campo 1" required="true"&gt;
						&lt;html:input required="true" name="field1"/&gt;
					&lt;/html:formGroup&gt;
					&lt;html:formGroup label="Campo 2"&gt;
						&lt;html:input name="field2"/&gt;
					&lt;/html:formGroup&gt;
				&lt;/html:formBody&gt;
					
				&lt;html:formFooter&gt;
				    &lt;html:button state="primary" type="submit" label="Label for submit"/&gt;
				&lt;/html:formFooter&gt;
			&lt;/html:form&gt; &lt;/html:view&gt;																					</html:code>																							</html:tab>																								</html:tabPanel>																						</html:cardBody>																						</html:card>																							</html:view>																			