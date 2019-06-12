<%@include file="../app/taglibs.jsp"%>										<html:view title="{title}">																	<html:card>																									<html:cardHeader>															tabs-content							</html:cardHeader>																						<html:cardBody>																								<html:tabPanel>																									<html:tab label="{about}" active="true">																	<html:alert state="warning">																				     	Renders a tab content																			</html:alert>																							</html:tab>																									<html:tab label="{attributes}">										<html:table stripe="true" hover="true"><html:tableHeader light="true"><html:tableLine><html:tableHead><fmt:message key="tag.attribute"/></html:tableHead><html:tableHead><fmt:message key="tag.required"/></html:tableHead><html:tableHead><fmt:message key="tag.type"/></html:tableHead><html:tableHead><fmt:message key="tag.description"/></html:tableHead></html:tableLine></html:tableHeader><html:tableBody><html:tableLine><html:tableColumn>active</html:tableColumn><html:tableColumn>false</html:tableColumn><html:tableColumn>java.lang.Boolean</html:tableColumn><html:tableColumn>It indicates whether the tab should be initiated selected</html:tableColumn></html:tableLine><html:tableLine><html:tableColumn>contentOf</html:tableColumn><html:tableColumn>true</html:tableColumn><html:tableColumn>java.lang.String</html:tableColumn><html:tableColumn>Indicates the link between tab head and content</html:tableColumn></html:tableLine><html:tableLine><html:tableColumn>url</html:tableColumn><html:tableColumn>false</html:tableColumn><html:tableColumn>java.lang.String</html:tableColumn><html:tableColumn>Indicates the url to be incorporated into the tab. If not indicated it renders content in the component body.</html:tableColumn></html:tableLine></html:tableBody></html:table>																																	</html:tab>																									<html:tab label="{demo}">																						
			<html:tabs>
				<html:tabs-header>
					<html:tabs-tab active="true" label="my tab 1" id="tab1"></html:tabs-tab>
					<html:tabs-tab label="my tab 2" id="tab2"></html:tabs-tab>
					<html:tabs-tab label="my tab 3" id="tab3"></html:tabs-tab>
				</html:tabs-header>
				<html:tabs-body>
					<html:tabs-content active="true" contentOf="tab1"> My content 1</html:tabs-content>
					<html:tabs-content contentOf="tab2"> My content 2</html:tabs-content>
					<html:tabs-content contentOf="tab3"> My content 3</html:tabs-content>
				</html:tabs-body>
			</html:tabs>
																									</html:tab>																									<html:tab label="{source}">																					<html:code>																										&lt;html:view&gt;
			&lt;html:tabs&gt;
				&lt;html:tabs-header&gt;
					&lt;html:tabs-tab active="true" label="my tab 1" id="tab1"&gt;&lt;/html:tabs-tab&gt;
					&lt;html:tabs-tab label="my tab 2" id="tab2"&gt;&lt;/html:tabs-tab&gt;
					&lt;html:tabs-tab label="my tab 3" id="tab3"&gt;&lt;/html:tabs-tab&gt;
				&lt;/html:tabs-header&gt;
				&lt;html:tabs-body&gt;
					&lt;html:tabs-content active="true" contentOf="tab1"&gt; My content 1&lt;/html:tabs-content&gt;
					&lt;html:tabs-content contentOf="tab2"&gt; My content 2&lt;/html:tabs-content&gt;
					&lt;html:tabs-content contentOf="tab3"&gt; My content 3&lt;/html:tabs-content&gt;
				&lt;/html:tabs-body&gt;
			&lt;/html:tabs&gt;
		&lt;/html:view&gt;																					</html:code>																							</html:tab>																								</html:tabPanel>																						</html:cardBody>																						</html:card>																							</html:view>																			