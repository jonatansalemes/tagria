<%@include file="../app/taglibs.jsp"%>										<html:view title="{title}">																	<html:card>																									<html:cardHeader>															onError							</html:cardHeader>																						<html:cardBody>																								<html:tabPanel>																									<html:tab label="{about}" active="true">																	<html:alert state="warning">																				     	Renders the error block if they occur in ajax request																			</html:alert>																							</html:tab>																									<html:tab label="{attributes}">										<html:alert state="info" label="{tag.empty.attributes}"></html:alert>																																	</html:tab>																									<html:tab label="{demo}">																						
			<ajax:function name="dados" url="/app/url/nao/existe" execute="true">
			    <ajax:onSuccess>
			    	      
			    </ajax:onSuccess>
			    <ajax:onError>
			           /*Nesse trecho est� disponivel as variaveis javascript ( jqXHR jqXHR, String textStatus, String errorThrown )*/
			           alert(textStatus);
			           alert(errorThrown);
			           alert(jqXHR);
			    </ajax:onError>
			</ajax:function>
																									</html:tab>																									<html:tab label="{source}">																					<html:code>																										&lt;html:view&gt;
			&lt;ajax:function name="dados" url="/app/url/nao/existe" execute="true"&gt;
			    &lt;ajax:onSuccess&gt;
			    	      
			    &lt;/ajax:onSuccess&gt;
			    &lt;ajax:onError&gt;
			           /*Nesse trecho est� disponivel as variaveis javascript ( jqXHR jqXHR, String textStatus, String errorThrown )*/
			           alert(textStatus);
			           alert(errorThrown);
			           alert(jqXHR);
			    &lt;/ajax:onError&gt;
			&lt;/ajax:function&gt;
		&lt;/html:view&gt;																					</html:code>																							</html:tab>																								</html:tabPanel>																						</html:cardBody>																						</html:card>																							</html:view>																			