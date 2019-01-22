<%@include file="../app/taglibs.jsp"%>										<html:view title="{title}">																	<html:panel>																									<html:panelHead label="mapOptions"></html:panelHead>												<html:panelBody>																								<html:tabPanel>																									<html:tab label="{about}" active="true">																	<html:alert state="warning">																				     	Renders a mapping of an options list to select a component																			</html:alert>																							</html:tab>																									<html:tab label="{attributes}">										<html:table><html:tableLine><html:tableColumn header="true"><fmt:message key="tag.attribute"/></html:tableColumn><html:tableColumn header="true"><fmt:message key="tag.required"/></html:tableColumn><html:tableColumn header="true"><fmt:message key="tag.type"/></html:tableColumn><html:tableColumn header="true"><fmt:message key="tag.description"/></html:tableColumn></html:tableLine><html:tableLine><html:tableColumn>target</html:tableColumn><html:tableColumn>true</html:tableColumn><html:tableColumn>java.lang.String</html:tableColumn><html:tableColumn>Indicates the component name to be achieved</html:tableColumn></html:tableLine><html:tableLine><html:tableColumn>text</html:tableColumn><html:tableColumn>true</html:tableColumn><html:tableColumn>java.lang.Boolean</html:tableColumn><html:tableColumn>It indicates the contents of the option to be displayed</html:tableColumn></html:tableLine><html:tableLine><html:tableColumn>value</html:tableColumn><html:tableColumn>true</html:tableColumn><html:tableColumn>java.lang.String</html:tableColumn><html:tableColumn>Indicates the value of the option to be filled</html:tableColumn></html:tableLine></html:table>																																	</html:tab>																									<html:tab label="{demo}">																						
			<html:select name="input2">
				<html:option value="">- - -</html:option>
			</html:select>
			
			<ajax:function name="dados" url="/app/ajax/list" executeOnDocumentLoad="true">
			    <ajax:onSuccess>
			          <ajax:mapOptions target="input2" value="id" text="nome" />
			    </ajax:onSuccess>
			    <ajax:onError>
			           
			    </ajax:onError>
			</ajax:function>
																									</html:tab>																									<html:tab label="{source}">																					<html:code>																										&lt;html:view&gt;
			&lt;html:select name="input2"&gt;
				&lt;html:option value=""&gt;- - -&lt;/html:option&gt;
			&lt;/html:select&gt;
			
			&lt;ajax:function name="dados" url="/app/ajax/list" executeOnDocumentLoad="true"&gt;
			    &lt;ajax:onSuccess&gt;
			          &lt;ajax:mapOptions target="input2" value="id" text="nome" /&gt;
			    &lt;/ajax:onSuccess&gt;
			    &lt;ajax:onError&gt;
			           
			    &lt;/ajax:onError&gt;
			&lt;/ajax:function&gt;
		&lt;/html:view&gt;																					</html:code>																							</html:tab>																								</html:tabPanel>																						</html:panelBody>																						</html:panel>																							</html:view>																			