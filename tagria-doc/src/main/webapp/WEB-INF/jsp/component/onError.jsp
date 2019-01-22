<%@include file="../app/taglibs.jsp"%>										<html:view title="{title}">																	<html:panel>																									<html:panelHead label="onError"></html:panelHead>												<html:panelBody>																								<html:tabPanel>																									<html:tab label="{about}" active="true">																	<html:alert state="warning">																				     	Renders the error block if they occur in ajax request																			</html:alert>																							</html:tab>																									<html:tab label="{attributes}">										<html:alert state="info" label="{tag.empty.attributes}"></html:alert>																																	</html:tab>																									<html:tab label="{demo}">																						
			<ajax:function name="dados" url="/app/url/nao/existe" executeOnDocumentLoad="true">
			    <ajax:onSuccess>
			    	      
			    </ajax:onSuccess>
			    <ajax:onError>
			           /*Nesse trecho está disponivel as variaveis javascript ( jqXHR jqXHR, String textStatus, String errorThrown )*/
			           alert(textStatus);
			           alert(errorThrown);
			           alert(jqXHR);
			    </ajax:onError>
			</ajax:function>
																									</html:tab>																									<html:tab label="{source}">																					<html:code>																										&lt;html:view&gt;
			&lt;ajax:function name="dados" url="/app/url/nao/existe" executeOnDocumentLoad="true"&gt;
			    &lt;ajax:onSuccess&gt;
			    	      
			    &lt;/ajax:onSuccess&gt;
			    &lt;ajax:onError&gt;
			           /*Nesse trecho está disponivel as variaveis javascript ( jqXHR jqXHR, String textStatus, String errorThrown )*/
			           alert(textStatus);
			           alert(errorThrown);
			           alert(jqXHR);
			    &lt;/ajax:onError&gt;
			&lt;/ajax:function&gt;
		&lt;/html:view&gt;																					</html:code>																							</html:tab>																								</html:tabPanel>																						</html:panelBody>																						</html:panel>																							</html:view>																			