<%@include file="../app/taglibs.jsp"%>										<html:view title="{title}">																	<html:card>																									<html:cardHeader>															modal-header							</html:cardHeader>																						<html:cardBody>																								<html:tabPanel>																									<html:tab label="{about}" active="true">																	<html:alert state="warning">																				     	Renders a modal header																			</html:alert>																							</html:tab>																									<html:tab label="{attributes}">										<html:table stripe="true" hover="true"><html:tableHeader light="true"><html:tableLine><html:tableHead><fmt:message key="tag.attribute"/></html:tableHead><html:tableHead><fmt:message key="tag.required"/></html:tableHead><html:tableHead><fmt:message key="tag.type"/></html:tableHead><html:tableHead><fmt:message key="tag.description"/></html:tableHead></html:tableLine></html:tableHeader><html:tableBody><html:tableLine><html:tableColumn>label</html:tableColumn><html:tableColumn>false</html:tableColumn><html:tableColumn>java.lang.String</html:tableColumn><html:tableColumn>Indicates the label of the modal header</html:tableColumn></html:tableLine><html:tableLine><html:tableColumn>labelKey</html:tableColumn><html:tableColumn>false</html:tableColumn><html:tableColumn>java.lang.String</html:tableColumn><html:tableColumn>Indicates the label key (i18n) of the modal header</html:tableColumn></html:tableLine></html:tableBody></html:table>																																	</html:tab>																									<html:tab label="{demo}">																						
		    <html:button-group>
				<html:button label="My button" icon="search" id="btn1" />
			</html:button-group>
			
			<html:modal attachToSelector="#btn1">
				<html:modal-header label="My modal title"></html:modal-header>
				<html:modal-body>
					Here is my component
				</html:modal-body>
				<html:modal-footer>
					My footer
				</html:modal-footer>
			</html:modal>
																									</html:tab>																									<html:tab label="{source}">																					<html:code>																										&lt;html:view&gt;
		    &lt;html:button-group&gt;
				&lt;html:button label="My button" icon="search" id="btn1" /&gt;
			&lt;/html:button-group&gt;
			
			&lt;html:modal attachToSelector="#btn1"&gt;
				&lt;html:modal-header label="My modal title"&gt;&lt;/html:modal-header&gt;
				&lt;html:modal-body&gt;
					Here is my component
				&lt;/html:modal-body&gt;
				&lt;html:modal-footer&gt;
					My footer
				&lt;/html:modal-footer&gt;
			&lt;/html:modal&gt;
		&lt;/html:view&gt;																					</html:code>																							</html:tab>																								</html:tabPanel>																						</html:cardBody>																						</html:card>																							</html:view>																			