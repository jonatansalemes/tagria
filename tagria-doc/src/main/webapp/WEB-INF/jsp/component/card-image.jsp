<%@include file="../app/taglibs.jsp"%>																							<html:view title="{title}">																													<html:card>																														<html:card-header>																				card-image							</html:card-header>																											<html:card-body>																												<html:tabs>																														<html:tabs-header>																												<html:tabs-tab active="true" labelKey="about" id="tab1"></html:tabs-tab> 												<html:tabs-tab labelKey="attributes" id="tab2"></html:tabs-tab> 														<html:tabs-tab labelKey="demo" id="tab3"></html:tabs-tab> 																<html:tabs-tab labelKey="source" id="tab4"></html:tabs-tab> 														</html:tabs-header> 																										<html:tabs-body> 																												<html:tabs-content active="true" contentOf="tab1">																			<html:alert state="warning">													Renders an card image											</html:alert>																											</html:tabs-content>																										<html:tabs-content contentOf="tab2">												<html:table stripe="true" hover="true"><html:thead light="true"><html:tr><html:th><fmt:message key="tag.attribute"/></html:th><html:th><fmt:message key="tag.required"/></html:th><html:th><fmt:message key="tag.type"/></html:th><html:th><fmt:message key="tag.description"/></html:th></html:tr></html:thead><html:tbody><html:tr><html:td>rendered</html:td><html:td>false</html:td><html:td>java.lang.Boolean</html:td><html:td>It indicates if the component should be rendered. Default : true</html:td></html:tr><html:tr><html:td>responsive</html:td><html:td>false</html:td><html:td>java.lang.Boolean</html:td><html:td>It indicates if card-image is responsive. Default : false</html:td></html:tr><html:tr><html:td>height</html:td><html:td>true</html:td><html:td>java.lang.Integer</html:td><html:td>Indicates the height component</html:td></html:tr><html:tr><html:td>width</html:td><html:td>true</html:td><html:td>java.lang.Integer</html:td><html:td>Indicates the image width</html:td></html:tr><html:tr><html:td>alt</html:td><html:td>false</html:td><html:td>java.lang.String</html:td><html:td>It indicates the alt of image</html:td></html:tr><html:tr><html:td>altKey</html:td><html:td>false</html:td><html:td>java.lang.String</html:td><html:td>It indicates the alt key (i18n) of image</html:td></html:tr><html:tr><html:td>cdn</html:td><html:td>false</html:td><html:td>java.lang.Boolean</html:td><html:td>It indicates if the component must be loaded from cdn</html:td></html:tr><html:tr><html:td>url</html:td><html:td>true</html:td><html:td>java.lang.String</html:td><html:td>Indicates the image url</html:td></html:tr></html:tbody></html:table>										</html:tabs-content>																								<html:tabs-content contentOf="tab3">										
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
												</html:tabs-content>																								<html:tabs-content contentOf="tab4">																					<html:code>																												&lt;html:view&gt;
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
		&lt;/html:view&gt;												</html:code>																									</html:tabs-content>																							</html:tabs-body> 																								</html:tabs>																									</html:card-body>																								</html:card>																									</html:view>																			