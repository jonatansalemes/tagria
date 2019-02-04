<%@include file="../app/taglibs.jsp"%>										<html:view title="{title}">																	<html:card>																									<html:cardHeader label="cardText"/>												<html:cardBody>																								<html:tabPanel>																									<html:tab label="{about}" active="true">																	<html:alert state="warning">																				     	Renders a text on the card																			</html:alert>																							</html:tab>																									<html:tab label="{attributes}">										<html:alert state="info" label="{tag.empty.attributes}"></html:alert>																																	</html:tab>																									<html:tab label="{demo}">																						
			<html:card>
				<html:cardBody>
					<html:cardText>
						Text
					</html:cardText>
				</html:cardBody>
			</html:card>
																									</html:tab>																									<html:tab label="{source}">																					<html:code>																										&lt;html:view&gt;
			&lt;html:card&gt;
				&lt;html:cardBody&gt;
					&lt;html:cardText&gt;
						Text
					&lt;/html:cardText&gt;
				&lt;/html:cardBody&gt;
			&lt;/html:card&gt;
		&lt;/html:view&gt;																					</html:code>																							</html:tab>																								</html:tabPanel>																						</html:cardBody>																						</html:card>																							</html:view>																			