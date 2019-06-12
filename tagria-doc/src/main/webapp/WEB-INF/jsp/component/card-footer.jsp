<%@include file="../app/taglibs.jsp"%>										<html:view title="{title}">																	<html:card>																									<html:cardHeader>															card-footer							</html:cardHeader>																						<html:cardBody>																								<html:tabPanel>																									<html:tab label="{about}" active="true">																	<html:alert state="warning">																				     	Renders card footer																			</html:alert>																							</html:tab>																									<html:tab label="{attributes}">										<html:alert state="info" label="{tag.empty.attributes}"></html:alert>																																	</html:tab>																									<html:tab label="{demo}">																						
			<html:card>
				<html:card-image url="/image/person.png" width="32" height="32" responsive="false"></html:card-image>
				<html:card-header>
					My header
				</html:card-header>
				<html:card-body>
					<html:card-title>My title</html:card-title>
					<html:card-sub-title>My subtitle</html:card-sub-title>
					<html:card-text>My text</html:card-text>
					<html:card-link label="My link 1" url="#"></html:card-link>
				</html:card-body>
				<html:card-footer>
					My footer
				</html:card-footer>
			</html:card>
																									</html:tab>																									<html:tab label="{source}">																					<html:code>																										&lt;html:view&gt;
			&lt;html:card&gt;
				&lt;html:card-image url="/image/person.png" width="32" height="32" responsive="false"&gt;&lt;/html:card-image&gt;
				&lt;html:card-header&gt;
					My header
				&lt;/html:card-header&gt;
				&lt;html:card-body&gt;
					&lt;html:card-title&gt;My title&lt;/html:card-title&gt;
					&lt;html:card-sub-title&gt;My subtitle&lt;/html:card-sub-title&gt;
					&lt;html:card-text&gt;My text&lt;/html:card-text&gt;
					&lt;html:card-link label="My link 1" url="#"&gt;&lt;/html:card-link&gt;
				&lt;/html:card-body&gt;
				&lt;html:card-footer&gt;
					My footer
				&lt;/html:card-footer&gt;
			&lt;/html:card&gt;
		&lt;/html:view&gt;																					</html:code>																							</html:tab>																								</html:tabPanel>																						</html:cardBody>																						</html:card>																							</html:view>																			