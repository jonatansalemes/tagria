<%@include file="../app/taglibs.jsp"%>										<html:view title="{title}">																	<html:card>																									<html:cardHeader label="target"/>												<html:cardBody>																								<html:tabPanel>																									<html:tab label="{about}" active="true">																	<html:alert state="warning">																				     	Renders writing in a particular component																			</html:alert>																							</html:tab>																									<html:tab label="{attributes}">										<html:table stripe="true" hover="true"><html:tableHeader light="true"><html:tableLine><html:tableHead><fmt:message key="tag.attribute"/></html:tableHead><html:tableHead><fmt:message key="tag.required"/></html:tableHead><html:tableHead><fmt:message key="tag.type"/></html:tableHead><html:tableHead><fmt:message key="tag.description"/></html:tableHead></html:tableLine></html:tableHeader><html:tableBody><html:tableLine><html:tableColumn>data</html:tableColumn><html:tableColumn>false</html:tableColumn><html:tableColumn>java.lang.String</html:tableColumn><html:tableColumn>Indicates which attribute of the object must be used</html:tableColumn></html:tableLine><html:tableLine><html:tableColumn>value</html:tableColumn><html:tableColumn>false</html:tableColumn><html:tableColumn>java.lang.String</html:tableColumn><html:tableColumn>Indicates the fixed value to be used in target val</html:tableColumn></html:tableLine><html:tableLine><html:tableColumn>rendered</html:tableColumn><html:tableColumn>false</html:tableColumn><html:tableColumn>java.lang.Boolean</html:tableColumn><html:tableColumn>It indicates whether the component should be rendered. Default : true</html:tableColumn></html:tableLine><html:tableLine><html:tableColumn>type</html:tableColumn><html:tableColumn>true</html:tableColumn><html:tableColumn>java.lang.String</html:tableColumn><html:tableColumn>It indicates the type of iteration being used. Options: val, html</html:tableColumn></html:tableLine><html:tableLine><html:tableColumn>target</html:tableColumn><html:tableColumn>true</html:tableColumn><html:tableColumn>java.lang.String</html:tableColumn><html:tableColumn>Indicates the component name to be achieved</html:tableColumn></html:tableLine></html:tableBody></html:table>																																	</html:tab>																									<html:tab label="{demo}">																						
			
			<html:input name="input1" value="Valor 0"/>
			<html:input name="input2" disabled="true"/>
			
			<html:jsEvent attachTo="input1" event="blur">
			     dados();
			</html:jsEvent>
		
			<ajax:function name="dados" url="/app/ajax">
				<ajax:parameters>
					<ajax:parameter name="input1" src="input1" type="val" />
				</ajax:parameters>
			    <ajax:onSuccess>
			          <ajax:target type="val" data="field" target="input2"/>
			    </ajax:onSuccess>
			    <ajax:onError>
			           
			    </ajax:onError>
			</ajax:function>
		
																									</html:tab>																									<html:tab label="{source}">																					<html:code>																										&lt;html:view&gt;
			
			&lt;html:input name="input1" value="Valor 0"/&gt;
			&lt;html:input name="input2" disabled="true"/&gt;
			
			&lt;html:jsEvent attachTo="input1" event="blur"&gt;
			     dados();
			&lt;/html:jsEvent&gt;
		
			&lt;ajax:function name="dados" url="/app/ajax"&gt;
				&lt;ajax:parameters&gt;
					&lt;ajax:parameter name="input1" src="input1" type="val" /&gt;
				&lt;/ajax:parameters&gt;
			    &lt;ajax:onSuccess&gt;
			          &lt;ajax:target type="val" data="field" target="input2"/&gt;
			    &lt;/ajax:onSuccess&gt;
			    &lt;ajax:onError&gt;
			           
			    &lt;/ajax:onError&gt;
			&lt;/ajax:function&gt;
		
		&lt;/html:view&gt;																					</html:code>																							</html:tab>																								</html:tabPanel>																						</html:cardBody>																						</html:card>																							</html:view>																			