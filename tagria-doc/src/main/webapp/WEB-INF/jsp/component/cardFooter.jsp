<%@include file="../app/taglibs.jsp"%>										<html:view title="{title}">																	<html:card>																									<html:cardHeader label="cardFooter"/>												<html:cardBody>																								<html:tabPanel>																									<html:tab label="{about}" active="true">																	<html:alert state="warning">																				     	Renders the footer card																			</html:alert>																							</html:tab>																									<html:tab label="{attributes}">										<html:alert state="info" label="{tag.empty.attributes}"></html:alert>																																	</html:tab>																									<html:tab label="{demo}">																						
			<html:card>
				<html:cardHeader>
					Title
				</html:cardHeader>
				<html:cardBody>
					Components
				</html:cardBody>
				<html:cardFooter>
					Components
				</html:cardFooter>
			</html:card>
																									</html:tab>																									<html:tab label="{source}">																					<html:code>																										&lt;html:view&gt;
			&lt;html:card&gt;
				&lt;html:cardHeader&gt;
					Title
				&lt;/html:cardHeader&gt;
				&lt;html:cardBody&gt;
					Components
				&lt;/html:cardBody&gt;
				&lt;html:cardFooter&gt;
					Components
				&lt;/html:cardFooter&gt;
			&lt;/html:card&gt;
		&lt;/html:view&gt;																					</html:code>																							</html:tab>																								</html:tabPanel>																						</html:cardBody>																						</html:card>																							</html:view>																			