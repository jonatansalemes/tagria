<%@include file="../app/taglibs.jsp"%>										<html:view title="{title}">																	<html:card>																									<html:cardHeader>															parameter							</html:cardHeader>																						<html:cardBody>																								<html:tabPanel>																									<html:tab label="{about}" active="true">																	<html:alert state="warning">																				     	Renders a parameter that must be sent by ajax request																			</html:alert>																							</html:tab>																									<html:tab label="{attributes}">										<html:table stripe="true" hover="true"><html:tableHeader light="true"><html:tableLine><html:tableHead><fmt:message key="tag.attribute"/></html:tableHead><html:tableHead><fmt:message key="tag.required"/></html:tableHead><html:tableHead><fmt:message key="tag.type"/></html:tableHead><html:tableHead><fmt:message key="tag.description"/></html:tableHead></html:tableLine></html:tableHeader><html:tableBody><html:tableLine><html:tableColumn>src</html:tableColumn><html:tableColumn>false</html:tableColumn><html:tableColumn>java.lang.String</html:tableColumn><html:tableColumn>Indicates the component of the name to be used as the source</html:tableColumn></html:tableLine><html:tableLine><html:tableColumn>value</html:tableColumn><html:tableColumn>false</html:tableColumn><html:tableColumn>java.lang.String</html:tableColumn><html:tableColumn>Indicates the fixed value to be used in parameter name</html:tableColumn></html:tableLine><html:tableLine><html:tableColumn>type</html:tableColumn><html:tableColumn>false</html:tableColumn><html:tableColumn>java.lang.Boolean</html:tableColumn><html:tableColumn>It indicates the type of iteration being used. Options: val, html</html:tableColumn></html:tableLine><html:tableLine><html:tableColumn>name</html:tableColumn><html:tableColumn>true</html:tableColumn><html:tableColumn>java.lang.String</html:tableColumn><html:tableColumn>It indicates the name of the parameter</html:tableColumn></html:tableLine><html:tableLine><html:tableColumn>required</html:tableColumn><html:tableColumn>false</html:tableColumn><html:tableColumn>java.lang.Boolean</html:tableColumn><html:tableColumn>It indicates if the value is optional occur to the function call. Default: false.</html:tableColumn></html:tableLine></html:tableBody></html:table>																																	</html:tab>																									<html:tab label="{demo}">																						
			<html:input name="input1" value="Valor 0"/>
			<html:input name="input2" value="" />
			
			<html:jsEvent attachTo="input1" event="blur">
			     dados();
			</html:jsEvent>
		
			<ajax:function name="dados" url="/app/ajax">
				<ajax:parameters>
					<ajax:parameter name="input1" src="input1" type="val" />
					<ajax:parameter name="input2" src="input2" type="val" required="false" />
				</ajax:parameters>
			    <ajax:onSuccess>
			          alert('Executada');
			    </ajax:onSuccess>
			    <ajax:onError>
			           
			    </ajax:onError>
			</ajax:function>
																									</html:tab>																									<html:tab label="{source}">																					<html:code>																										&lt;html:view&gt;
			&lt;html:input name="input1" value="Valor 0"/&gt;
			&lt;html:input name="input2" value="" /&gt;
			
			&lt;html:jsEvent attachTo="input1" event="blur"&gt;
			     dados();
			&lt;/html:jsEvent&gt;
		
			&lt;ajax:function name="dados" url="/app/ajax"&gt;
				&lt;ajax:parameters&gt;
					&lt;ajax:parameter name="input1" src="input1" type="val" /&gt;
					&lt;ajax:parameter name="input2" src="input2" type="val" required="false" /&gt;
				&lt;/ajax:parameters&gt;
			    &lt;ajax:onSuccess&gt;
			          alert('Executada');
			    &lt;/ajax:onSuccess&gt;
			    &lt;ajax:onError&gt;
			           
			    &lt;/ajax:onError&gt;
			&lt;/ajax:function&gt;
		&lt;/html:view&gt;																					</html:code>																							</html:tab>																								</html:tabPanel>																						</html:cardBody>																						</html:card>																							</html:view>																			