<%@include file="../app/taglibs.jsp"%>										<html:view title="{title}">																	<html:card>																									<html:cardHeader>															maskOnKeyPress							</html:cardHeader>																						<html:cardBody>																								<html:tabPanel>																									<html:tab label="{about}" active="true">																	<html:alert state="warning">																				     	Renders event on mask after any key press																			</html:alert>																							</html:tab>																									<html:tab label="{attributes}">										<html:alert state="info" label="{tag.empty.attributes}"></html:alert>																																	</html:tab>																									<html:tab label="{demo}">																						
			<html:input name="teste"/>
			<html:mask mask="(00) 0000-00000" attachTo="teste">
				<html:maskOnKeyPress>
				    var masks = ['(00) 0000-00000', '(00) 00000-0000'];
					mask = (value.length > 14) ? masks[1] : masks[0];
					$('#'+$(field[0]).attr('id')).mask(mask,options);
				</html:maskOnKeyPress>
			</html:mask> 																							</html:tab>																									<html:tab label="{source}">																					<html:code>																										&lt;html:view&gt;
			&lt;html:input name="teste"/&gt;
			&lt;html:mask mask="(00) 0000-00000" attachTo="teste"&gt;
				&lt;html:maskOnKeyPress&gt;
				    var masks = ['(00) 0000-00000', '(00) 00000-0000'];
					mask = (value.length &gt; 14) ? masks[1] : masks[0];
					\$('#'+\$(field[0]).attr('id')).mask(mask,options);
				&lt;/html:maskOnKeyPress&gt;
			&lt;/html:mask&gt; &lt;/html:view&gt;																					</html:code>																							</html:tab>																								</html:tabPanel>																						</html:cardBody>																						</html:card>																							</html:view>																			