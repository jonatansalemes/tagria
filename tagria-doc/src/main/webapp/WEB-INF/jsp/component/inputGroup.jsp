<%@include file="../app/taglibs.jsp"%>										<html:view title="{title}">																	<html:card>																									<html:cardHeader>															inputGroup							</html:cardHeader>																						<html:cardBody>																								<html:tabPanel>																									<html:tab label="{about}" active="true">																	<html:alert state="warning">																				     	Renders a input group																			</html:alert>																							</html:tab>																									<html:tab label="{attributes}">										<html:table stripe="true" hover="true"><html:tableHeader light="true"><html:tableLine><html:tableHead><fmt:message key="tag.attribute"/></html:tableHead><html:tableHead><fmt:message key="tag.required"/></html:tableHead><html:tableHead><fmt:message key="tag.type"/></html:tableHead><html:tableHead><fmt:message key="tag.description"/></html:tableHead></html:tableLine></html:tableHeader><html:tableBody><html:tableLine><html:tableColumn>append</html:tableColumn><html:tableColumn>false</html:tableColumn><html:tableColumn>java.lang.Boolean</html:tableColumn><html:tableColumn>It indicates whether the input group should append another component. Default:false</html:tableColumn></html:tableLine><html:tableLine><html:tableColumn>prepend</html:tableColumn><html:tableColumn>false</html:tableColumn><html:tableColumn>java.lang.Boolean</html:tableColumn><html:tableColumn>It indicates whether the input group should prepend another component. Default:false</html:tableColumn></html:tableLine></html:tableBody></html:table>																																	</html:tab>																									<html:tab label="{demo}">																						
			<html:inputGroup>
				<html:input type="search" name="search"
							placeholder="{app.index.search.employee}" cssClass="w-40"/>
				<html:inputGroup append="true">
					<html:button icon="search" title="Search"/>
				</html:inputGroup>
			</html:inputGroup> 
																									</html:tab>																									<html:tab label="{source}">																					<html:code>																										&lt;html:view&gt;
			&lt;html:inputGroup&gt;
				&lt;html:input type="search" name="search"
							placeholder="{app.index.search.employee}" cssClass="w-40"/&gt;
				&lt;html:inputGroup append="true"&gt;
					&lt;html:button icon="search" title="Search"/&gt;
				&lt;/html:inputGroup&gt;
			&lt;/html:inputGroup&gt; 
		&lt;/html:view&gt;																					</html:code>																							</html:tab>																								</html:tabPanel>																						</html:cardBody>																						</html:card>																							</html:view>																			