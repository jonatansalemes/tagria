<%@include file="../app/taglibs.jsp"%>										<html:view title="{title}">																	<html:card>																									<html:cardHeader>															button-group							</html:cardHeader>																						<html:cardBody>																								<html:tabPanel>																									<html:tab label="{about}" active="true">																	<html:alert state="warning">																				     	Renders a set of buttons																			</html:alert>																							</html:tab>																									<html:tab label="{attributes}">										<html:alert state="info" label="{tag.empty.attributes}"></html:alert>																																	</html:tab>																									<html:tab label="{demo}">																						
		    <html:button-group>
				<html:button label="My button 1" icon="search" id="btn1" />
				<html:button label="My button 2" icon="plus" state="danger" filled="true"  />
			</html:button-group>
																									</html:tab>																									<html:tab label="{source}">																					<html:code>																										&lt;html:view&gt;
		    &lt;html:button-group&gt;
				&lt;html:button label="My button 1" icon="search" id="btn1" /&gt;
				&lt;html:button label="My button 2" icon="plus" state="danger" filled="true"  /&gt;
			&lt;/html:button-group&gt;
		&lt;/html:view&gt;																					</html:code>																							</html:tab>																								</html:tabPanel>																						</html:cardBody>																						</html:card>																							</html:view>																			