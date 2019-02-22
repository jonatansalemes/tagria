<%@include file="../app/taglibs.jsp"%>										<html:view title="{title}">																	<html:card>																									<html:cardHeader>															tabPanel							</html:cardHeader>																						<html:cardBody>																								<html:tabPanel>																									<html:tab label="{about}" active="true">																	<html:alert state="warning">																				     	Renders a panel tabs																			</html:alert>																							</html:tab>																									<html:tab label="{attributes}">										<html:alert state="info" label="{tag.empty.attributes}"></html:alert>																																	</html:tab>																									<html:tab label="{demo}">																						
			<html:tabPanel>
				<html:tab label="Tab 1" active="true">
					Tab content
				</html:tab>
				<html:tab label="Tab 2" url="/app/welcome"/>
			</html:tabPanel> 																							</html:tab>																									<html:tab label="{source}">																					<html:code>																										&lt;html:view&gt;
			&lt;html:tabPanel&gt;
				&lt;html:tab label="Tab 1" active="true"&gt;
					Tab content
				&lt;/html:tab&gt;
				&lt;html:tab label="Tab 2" url="/app/welcome"/&gt;
			&lt;/html:tabPanel&gt; &lt;/html:view&gt;																					</html:code>																							</html:tab>																								</html:tabPanel>																						</html:cardBody>																						</html:card>																							</html:view>																			