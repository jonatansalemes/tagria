<%@include file="../app/taglibs.jsp"%>										<html:view title="{title}">																	<html:panel>																									<html:panelHead label="onSuccess"></html:panelHead>												<html:panelBody>																								<html:tabPanel>																									<html:tab label="{about}" active="true">																	<html:alert state="warning">																				     	Renders success block if the ajax request run smoothly																			</html:alert>																							</html:tab>																									<html:tab label="{attributes}">										<html:alert state="info" label="{tag.empty.attributes}"></html:alert>																																	</html:tab>																									<html:tab label="{demo}">																						
			<html:input name="input1" value="Valor 0"/>
		
			<ajax:function name="dados" url="/app/ajax" executeOnDocumentLoad="true">
				<ajax:parameters>
					<ajax:parameter name="input1" src="input1" type="val" />
				</ajax:parameters>
			    <ajax:onSuccess>
			    	    /*Nesse trecho está disponivel as variaveis javascript ( Object data, String textStatus, jqXHR jqXHR )*/
			           alert(textStatus);
			           alert(data);
			           alert(jqXHR);
			    </ajax:onSuccess>
			    <ajax:onError>
			          
			    </ajax:onError>
			</ajax:function>
																									</html:tab>																									<html:tab label="{source}">																					<html:code>																										&lt;html:view&gt;
			&lt;html:input name="input1" value="Valor 0"/&gt;
		
			&lt;ajax:function name="dados" url="/app/ajax" executeOnDocumentLoad="true"&gt;
				&lt;ajax:parameters&gt;
					&lt;ajax:parameter name="input1" src="input1" type="val" /&gt;
				&lt;/ajax:parameters&gt;
			    &lt;ajax:onSuccess&gt;
			    	    /*Nesse trecho está disponivel as variaveis javascript ( Object data, String textStatus, jqXHR jqXHR )*/
			           alert(textStatus);
			           alert(data);
			           alert(jqXHR);
			    &lt;/ajax:onSuccess&gt;
			    &lt;ajax:onError&gt;
			          
			    &lt;/ajax:onError&gt;
			&lt;/ajax:function&gt;
		&lt;/html:view&gt;																					</html:code>																							</html:tab>																								</html:tabPanel>																						</html:panelBody>																						</html:panel>																							</html:view>																			