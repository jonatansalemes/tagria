<%@include file="../app/taglibs.jsp"%>										<html:view title="{title}">																	<html:panel>																									<html:panelHead label="preCode"></html:panelHead>												<html:panelBody>																								<html:tabPanel>																									<html:tab label="{about}" active="true">																	<html:alert state="warning">																				     	Renders block on begin of ajax request																			</html:alert>																							</html:tab>																									<html:tab label="{attributes}">										<html:alert state="info" label="{tag.empty.attributes}"></html:alert>																																	</html:tab>																									<html:tab label="{demo}">																						
				<ajax:function name="data" url="/app/ajax" executeOnDocumentLoad="true">
			    	<ajax:preCode>
			    	   alert('block declared as first instructions of ajax function');
			    	</ajax:preCode>
				</ajax:function>
																									</html:tab>																									<html:tab label="{source}">																					<html:code>																										&lt;html:view&gt;
				&lt;ajax:function name="data" url="/app/ajax" executeOnDocumentLoad="true"&gt;
			    	&lt;ajax:preCode&gt;
			    	   alert('block declared as first instructions of ajax function');
			    	&lt;/ajax:preCode&gt;
				&lt;/ajax:function&gt;
		&lt;/html:view&gt;																					</html:code>																							</html:tab>																								</html:tabPanel>																						</html:panelBody>																						</html:panel>																							</html:view>																			