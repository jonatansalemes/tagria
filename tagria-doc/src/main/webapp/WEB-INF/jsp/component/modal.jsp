<%@include file="../app/taglibs.jsp"%>										<html:view title="{title}">																	<html:card>																									<html:cardHeader>															modal							</html:cardHeader>																						<html:cardBody>																								<html:tabPanel>																									<html:tab label="{about}" active="true">																	<html:alert state="warning">																				     	Renders a modal block																			</html:alert>																							</html:tab>																									<html:tab label="{attributes}">										<html:table stripe="true" hover="true"><html:tableHeader light="true"><html:tableLine><html:tableHead><fmt:message key="tag.attribute"/></html:tableHead><html:tableHead><fmt:message key="tag.required"/></html:tableHead><html:tableHead><fmt:message key="tag.type"/></html:tableHead><html:tableHead><fmt:message key="tag.description"/></html:tableHead></html:tableLine></html:tableHeader><html:tableBody><html:tableLine><html:tableColumn>size</html:tableColumn><html:tableColumn>false</html:tableColumn><html:tableColumn>java.lang.String</html:tableColumn><html:tableColumn>Indicates the size of modal. Default none. Options: xl,sm,lg</html:tableColumn></html:tableLine><html:tableLine><html:tableColumn>id</html:tableColumn><html:tableColumn>false</html:tableColumn><html:tableColumn>java.lang.String</html:tableColumn><html:tableColumn>Indicates the modal id for direct manipulation of events</html:tableColumn></html:tableLine><html:tableLine><html:tableColumn>attachTo</html:tableColumn><html:tableColumn>false</html:tableColumn><html:tableColumn>java.lang.String</html:tableColumn><html:tableColumn>Indicates the component name that triggers the modal screen</html:tableColumn></html:tableLine><html:tableLine><html:tableColumn>attachToSelector</html:tableColumn><html:tableColumn>false</html:tableColumn><html:tableColumn>java.lang.String</html:tableColumn><html:tableColumn>Indicates the component selector that triggers the modal screen</html:tableColumn></html:tableLine><html:tableLine><html:tableColumn>closeable</html:tableColumn><html:tableColumn>false</html:tableColumn><html:tableColumn>java.lang.Boolean</html:tableColumn><html:tableColumn>Indicates if modal can be closeable. Default : true. Options : true,false</html:tableColumn></html:tableLine><html:tableLine><html:tableColumn>centered</html:tableColumn><html:tableColumn>false</html:tableColumn><html:tableColumn>java.lang.Boolean</html:tableColumn><html:tableColumn>Indicates if modal is vertically centered. Default : false. Options : true,false</html:tableColumn></html:tableLine><html:tableLine><html:tableColumn>open</html:tableColumn><html:tableColumn>false</html:tableColumn><html:tableColumn>java.lang.Boolean</html:tableColumn><html:tableColumn>Indicates if component is opened on load. Default : false. Options : true,false</html:tableColumn></html:tableLine><html:tableLine><html:tableColumn>rendered</html:tableColumn><html:tableColumn>false</html:tableColumn><html:tableColumn>java.lang.Boolean</html:tableColumn><html:tableColumn>It indicates whether the component should be rendered</html:tableColumn></html:tableLine></html:tableBody></html:table>																																	</html:tab>																									<html:tab label="{demo}">																						
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