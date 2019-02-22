<%@include file="../app/taglibs.jsp"%>										<html:view title="{title}">																	<html:card>																									<html:cardHeader>															beforeSend							</html:cardHeader>																						<html:cardBody>																								<html:tabPanel>																									<html:tab label="{about}" active="true">																	<html:alert state="warning">																				     	Renders before send block on ajax request																			</html:alert>																							</html:tab>																									<html:tab label="{attributes}">										<html:alert state="info" label="{tag.empty.attributes}"></html:alert>																																	</html:tab>																									<html:tab label="{demo}">																						
				<ajax:function name="data" url="/app/ajax" executeOnDocumentLoad="true">
			    <ajax:beforeSend>
			    	    /* Available javascript variables ( jqXHR jqXHR, Object settings )*/
			           alert(settings);
			           alert(jqXHR);
			    </ajax:beforeSend>
			</ajax:function>
																									</html:tab>																									<html:tab label="{source}">																					<html:code>																										&lt;html:view&gt;
				&lt;ajax:function name="data" url="/app/ajax" executeOnDocumentLoad="true"&gt;
			    &lt;ajax:beforeSend&gt;
			    	    /* Available javascript variables ( jqXHR jqXHR, Object settings )*/
			           alert(settings);
			           alert(jqXHR);
			    &lt;/ajax:beforeSend&gt;
			&lt;/ajax:function&gt;
		&lt;/html:view&gt;																					</html:code>																							</html:tab>																								</html:tabPanel>																						</html:cardBody>																						</html:card>																							</html:view>																			