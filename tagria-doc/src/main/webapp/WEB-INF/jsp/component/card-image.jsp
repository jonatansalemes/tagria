<%@include file="../app/taglibs.jsp"%>										<html:view title="{title}">																	<html:card>																									<html:cardHeader>															card-image							</html:cardHeader>																						<html:cardBody>																								<html:tabPanel>																									<html:tab label="{about}" active="true">																	<html:alert state="warning">																				     	Renders an card image																			</html:alert>																							</html:tab>																									<html:tab label="{attributes}">										<html:table stripe="true" hover="true"><html:tableHeader light="true"><html:tableLine><html:tableHead><fmt:message key="tag.attribute"/></html:tableHead><html:tableHead><fmt:message key="tag.required"/></html:tableHead><html:tableHead><fmt:message key="tag.type"/></html:tableHead><html:tableHead><fmt:message key="tag.description"/></html:tableHead></html:tableLine></html:tableHeader><html:tableBody><html:tableLine><html:tableColumn>rendered</html:tableColumn><html:tableColumn>false</html:tableColumn><html:tableColumn>java.lang.Boolean</html:tableColumn><html:tableColumn>It indicates if the component should be rendered. Default : true</html:tableColumn></html:tableLine><html:tableLine><html:tableColumn>responsive</html:tableColumn><html:tableColumn>false</html:tableColumn><html:tableColumn>java.lang.Boolean</html:tableColumn><html:tableColumn>It indicates if card-image is responsive. Default : false</html:tableColumn></html:tableLine><html:tableLine><html:tableColumn>height</html:tableColumn><html:tableColumn>true</html:tableColumn><html:tableColumn>java.lang.Integer</html:tableColumn><html:tableColumn>Indicates the height component</html:tableColumn></html:tableLine><html:tableLine><html:tableColumn>width</html:tableColumn><html:tableColumn>true</html:tableColumn><html:tableColumn>java.lang.Integer</html:tableColumn><html:tableColumn>Indicates the image width</html:tableColumn></html:tableLine><html:tableLine><html:tableColumn>alt</html:tableColumn><html:tableColumn>false</html:tableColumn><html:tableColumn>java.lang.String</html:tableColumn><html:tableColumn>It indicates the alt of image</html:tableColumn></html:tableLine><html:tableLine><html:tableColumn>altKey</html:tableColumn><html:tableColumn>false</html:tableColumn><html:tableColumn>java.lang.String</html:tableColumn><html:tableColumn>It indicates the alt key (i18n) of image</html:tableColumn></html:tableLine><html:tableLine><html:tableColumn>cdn</html:tableColumn><html:tableColumn>false</html:tableColumn><html:tableColumn>java.lang.Boolean</html:tableColumn><html:tableColumn>It indicates if the component must be loaded from cdn</html:tableColumn></html:tableLine><html:tableLine><html:tableColumn>url</html:tableColumn><html:tableColumn>true</html:tableColumn><html:tableColumn>java.lang.String</html:tableColumn><html:tableColumn>Indicates the image url</html:tableColumn></html:tableLine></html:tableBody></html:table>																																	</html:tab>																									<html:tab label="{demo}">																						
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