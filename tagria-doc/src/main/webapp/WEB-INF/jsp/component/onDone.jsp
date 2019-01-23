<%@include file="../app/taglibs.jsp"%>										<html:view title="{title}">																	<html:card>																									<html:cardHeader label="onDone"/>												<html:cardBody>																								<html:tabPanel>																									<html:tab label="{about}" active="true">																	<html:alert state="warning">																				     	Renders block on ajax request done																			</html:alert>																							</html:tab>																									<html:tab label="{attributes}">										<html:alert state="info" label="{tag.empty.attributes}"></html:alert>																																	</html:tab>																									<html:tab label="{demo}">																						
				<ajax:function name="data" url="/app/ajax" executeOnDocumentLoad="true">
			    	<ajax:onDone>
			    	   alert('on function done');
			    	</ajax:onDone>
				</ajax:function>
																									</html:tab>																									<html:tab label="{source}">																					<html:code>																										&lt;html:view&gt;
				&lt;ajax:function name="data" url="/app/ajax" executeOnDocumentLoad="true"&gt;
			    	&lt;ajax:onDone&gt;
			    	   alert('on function done');
			    	&lt;/ajax:onDone&gt;
				&lt;/ajax:function&gt;
		&lt;/html:view&gt;																					</html:code>																							</html:tab>																								</html:tabPanel>																						</html:cardBody>																						</html:card>																							</html:view>																			