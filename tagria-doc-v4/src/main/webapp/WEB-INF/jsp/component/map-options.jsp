<%@include file="../app/taglibs.jsp"  %>																							<html:view title="{title}" template="master" attribute="body">																													<html:card>																														<html:card-header>																				map-options							</html:card-header>																											<html:card-body>																												<html:tabs>																														<html:tabs-header>																												<html:tabs-tab active="true" labelKey="about" id="tab1"></html:tabs-tab> 												<html:tabs-tab labelKey="attributes" id="tab2"></html:tabs-tab> 														<html:tabs-tab labelKey="demo" id="tab3"></html:tabs-tab> 																<html:tabs-tab labelKey="source" id="tab4"></html:tabs-tab> 														</html:tabs-header> 																										<html:tabs-body> 																												<html:tabs-content active="true" contentOf="tab1">																			<html:alert state="warning">													Renders a mapping of an options list to select a component											</html:alert>																											</html:tabs-content>																										<html:tabs-content contentOf="tab2">												<html:table stripe="true" hover="true"><html:table-header light="true"><html:table-row><html:table-head><fmt:message key="tag.attribute"/></html:table-head><html:table-head><fmt:message key="tag.required"/></html:table-head><html:table-head><fmt:message key="tag.type"/></html:table-head><html:table-head><fmt:message key="tag.description"/></html:table-head></html:table-row></html:table-header><html:table-body><html:table-row><html:table-data>target</html:table-data><html:table-data>true</html:table-data><html:table-data>java.lang.String</html:table-data><html:table-data>Indicates the component name to be achieved</html:table-data></html:table-row><html:table-row><html:table-data>text</html:table-data><html:table-data>true</html:table-data><html:table-data>java.lang.Boolean</html:table-data><html:table-data>It indicates the contents of the option to be displayed</html:table-data></html:table-row><html:table-row><html:table-data>value</html:table-data><html:table-data>true</html:table-data><html:table-data>java.lang.String</html:table-data><html:table-data>Indicates the value of the option to be filled</html:table-data></html:table-row></html:table-body></html:table>										</html:tabs-content>																								<html:tabs-content contentOf="tab3">										
			<html:select name="input2">
				<html:option value="">- - -</html:option>
			</html:select>
			
			<ajax:function name="dados" url="/app/ajax/list" execute="true">
			    <ajax:on-success>
			          <ajax:map-options target="input2" value="id" text="nome" />
			    </ajax:on-success>
			    <ajax:on-error>
			           
			    </ajax:on-error>
			</ajax:function>
												</html:tabs-content>																								<html:tabs-content contentOf="tab4">																					<html:code>																												&lt;html:view&gt;
			&lt;html:select name="input2"&gt;
				&lt;html:option value=""&gt;- - -&lt;/html:option&gt;
			&lt;/html:select&gt;
			
			&lt;ajax:function name="dados" url="/app/ajax/list" execute="true"&gt;
			    &lt;ajax:on-success&gt;
			          &lt;ajax:map-options target="input2" value="id" text="nome" /&gt;
			    &lt;/ajax:on-success&gt;
			    &lt;ajax:on-error&gt;
			           
			    &lt;/ajax:on-error&gt;
			&lt;/ajax:function&gt;
		&lt;/html:view&gt;												</html:code>																									</html:tabs-content>																							</html:tabs-body> 																								</html:tabs>																									</html:card-body>																								</html:card>																									</html:view>																			