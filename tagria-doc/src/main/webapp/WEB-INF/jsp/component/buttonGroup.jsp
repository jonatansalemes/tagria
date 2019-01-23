<%@include file="../app/taglibs.jsp"%>										<html:view title="{title}">																	<html:card>																									<html:cardHeader label="buttonGroup"/>												<html:cardBody>																								<html:tabPanel>																									<html:tab label="{about}" active="true">																	<html:alert state="warning">																				     	Renders a cluster of buttons																			</html:alert>																							</html:tab>																									<html:tab label="{attributes}">										<html:alert state="info" label="{tag.empty.attributes}"></html:alert>																																	</html:tab>																									<html:tab label="{demo}">																						
			<html:buttonGroup>
				<html:button label="Botao 1" state="primary" url="#"/>
				<html:button label="Botao 3" state="danger" url="#"/>
			</html:buttonGroup> 																							</html:tab>																									<html:tab label="{source}">																					<html:code>																										&lt;html:view&gt;
			&lt;html:buttonGroup&gt;
				&lt;html:button label="Botao 1" state="primary" url="#"/&gt;
				&lt;html:button label="Botao 3" state="danger" url="#"/&gt;
			&lt;/html:buttonGroup&gt; &lt;/html:view&gt;																					</html:code>																							</html:tab>																								</html:tabPanel>																						</html:cardBody>																						</html:card>																							</html:view>																			