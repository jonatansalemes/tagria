<%@include file="../app/taglibs.jsp"%>										<html:view title="{title}">																	<html:card>																									<html:cardHeader label="carouselItem"/>												<html:cardBody>																								<html:tabPanel>																									<html:tab label="{about}" active="true">																	<html:alert state="warning">																				     	Renders a carousel item																			</html:alert>																							</html:tab>																									<html:tab label="{attributes}">										<html:table stripe="true" hover="true"><html:tableHeader light="true"><html:tableLine><html:tableHead><fmt:message key="tag.attribute"/></html:tableHead><html:tableHead><fmt:message key="tag.required"/></html:tableHead><html:tableHead><fmt:message key="tag.type"/></html:tableHead><html:tableHead><fmt:message key="tag.description"/></html:tableHead></html:tableLine></html:tableHeader><html:tableBody><html:tableLine><html:tableColumn>label</html:tableColumn><html:tableColumn>false</html:tableColumn><html:tableColumn>java.lang.String</html:tableColumn><html:tableColumn>Indicates the label of carousel item</html:tableColumn></html:tableLine><html:tableLine><html:tableColumn>description</html:tableColumn><html:tableColumn>false</html:tableColumn><html:tableColumn>java.lang.String</html:tableColumn><html:tableColumn>Indicates the description of carousel item</html:tableColumn></html:tableLine><html:tableLine><html:tableColumn>active</html:tableColumn><html:tableColumn>false</html:tableColumn><html:tableColumn>java.lang.Boolean</html:tableColumn><html:tableColumn>It indicates whether the component must start activated. Default: false. Options: true,false</html:tableColumn></html:tableLine><html:tableLine><html:tableColumn>rendered</html:tableColumn><html:tableColumn>false</html:tableColumn><html:tableColumn>java.lang.Boolean</html:tableColumn><html:tableColumn>It indicates whether the component should be rendered. Default : true</html:tableColumn></html:tableLine></html:tableBody></html:table>																																	</html:tab>																									<html:tab label="{demo}">																						
			<html:carousel>
				<html:carouselItem active="true" label="Item 1" description="Description 1">
					<html:carouselImage url="https://jslsolucoes.com/wp-content/uploads/logo.png" width="200" height="200" alt="logo"/>
				</html:carouselItem>
				<html:carouselItem label="Item 2" description="Description 2">
					<html:carouselImage url="https://jslsolucoes.com/wp-content/uploads/logo.png" width="200" height="200" alt="logo"/>
				</html:carouselItem>
			</html:carousel> 
																									</html:tab>																									<html:tab label="{source}">																					<html:code>																										&lt;html:view&gt;
			&lt;html:carousel&gt;
				&lt;html:carouselItem active="true" label="Item 1" description="Description 1"&gt;
					&lt;html:carouselImage url="https://jslsolucoes.com/wp-content/uploads/logo.png" width="200" height="200" alt="logo"/&gt;
				&lt;/html:carouselItem&gt;
				&lt;html:carouselItem label="Item 2" description="Description 2"&gt;
					&lt;html:carouselImage url="https://jslsolucoes.com/wp-content/uploads/logo.png" width="200" height="200" alt="logo"/&gt;
				&lt;/html:carouselItem&gt;
			&lt;/html:carousel&gt; 
		&lt;/html:view&gt;																					</html:code>																							</html:tab>																								</html:tabPanel>																						</html:cardBody>																						</html:card>																							</html:view>																			