<%@include file="../app/taglibs.jsp"%>										<html:view title="{title}">																	<html:card>																									<html:cardHeader>															tabPanel							</html:cardHeader>																						<html:cardBody>																								<html:tabPanel>																									<html:tab label="{about}" active="true">																	<html:alert state="warning">																				     	Renders a panel tabs																			</html:alert>																							</html:tab>																									<html:tab label="{attributes}">										<html:table stripe="true" hover="true"><html:tableHeader light="true"><html:tableLine><html:tableHead><fmt:message key="tag.attribute"/></html:tableHead><html:tableHead><fmt:message key="tag.required"/></html:tableHead><html:tableHead><fmt:message key="tag.type"/></html:tableHead><html:tableHead><fmt:message key="tag.description"/></html:tableHead></html:tableLine></html:tableHeader><html:tableBody><html:tableLine><html:tableColumn>afterShow</html:tableColumn><html:tableColumn>false</html:tableColumn><html:tableColumn>java.lang.String</html:tableColumn><html:tableColumn>Indicates a javascript function to be performed after show a tab. function signature is f(oldTab,newTab). oldTab: previous active tab, newTab: newly activated tab  </html:tableColumn></html:tableLine></html:tableBody></html:table>																																	</html:tab>																									<html:tab label="{demo}">																						
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