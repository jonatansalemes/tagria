<%@include file="../app/taglibs.jsp"%>										<html:view title="{title}">																	<html:panel>																									<html:panelHead label="row"></html:panelHead>												<html:panelBody>																								<html:tabPanel>																									<html:tab label="{about}" active="true">																	<html:alert state="warning">																				     	Renders a line of columns of subdivision (divided into 12 sections combined with the col tag)																			</html:alert>																							</html:tab>																									<html:tab label="{attributes}">										<html:table><html:tableLine><html:tableColumn header="true"><fmt:message key="tag.attribute"/></html:tableColumn><html:tableColumn header="true"><fmt:message key="tag.required"/></html:tableColumn><html:tableColumn header="true"><fmt:message key="tag.type"/></html:tableColumn><html:tableColumn header="true"><fmt:message key="tag.description"/></html:tableColumn></html:tableLine><html:tableLine><html:tableColumn>cssClass</html:tableColumn><html:tableColumn>false</html:tableColumn><html:tableColumn>java.lang.String</html:tableColumn><html:tableColumn>It indicates a CSS class to the component</html:tableColumn></html:tableLine></html:table>																																	</html:tab>																									<html:tab label="{demo}">																						
			<html:form action="#">
				<html:formGroup forElement="field1" label="Campo 1" required="true">
					<html:row>
						<html:col extraSmall="6">
							<html:input required="true" name="field1"/>
						</html:col>
						<html:col extraSmall="6">
							<html:input name="field2"/>
						</html:col>
					</html:row>
				</html:formGroup>
			</html:form> 																							</html:tab>																									<html:tab label="{source}">																					<html:code>																										&lt;html:view&gt;
			&lt;html:form action="#"&gt;
				&lt;html:formGroup forElement="field1" label="Campo 1" required="true"&gt;
					&lt;html:row&gt;
						&lt;html:col extraSmall="6"&gt;
							&lt;html:input required="true" name="field1"/&gt;
						&lt;/html:col&gt;
						&lt;html:col extraSmall="6"&gt;
							&lt;html:input name="field2"/&gt;
						&lt;/html:col&gt;
					&lt;/html:row&gt;
				&lt;/html:formGroup&gt;
			&lt;/html:form&gt; &lt;/html:view&gt;																					</html:code>																							</html:tab>																								</html:tabPanel>																						</html:panelBody>																						</html:panel>																							</html:view>																			