<%@include file="../app/taglibs.jsp"%>										<html:view title="{title}">																	<html:card>																									<html:cardHeader>															carousel							</html:cardHeader>																						<html:cardBody>																								<html:tabPanel>																									<html:tab label="{about}" active="true">																	<html:alert state="warning">																				     	Renders a carousel																			</html:alert>																							</html:tab>																									<html:tab label="{attributes}">										<html:table stripe="true" hover="true"><html:tableHeader light="true"><html:tableLine><html:tableHead><fmt:message key="tag.attribute"/></html:tableHead><html:tableHead><fmt:message key="tag.required"/></html:tableHead><html:tableHead><fmt:message key="tag.type"/></html:tableHead><html:tableHead><fmt:message key="tag.description"/></html:tableHead></html:tableLine></html:tableHeader><html:tableBody><html:tableLine><html:tableColumn>id</html:tableColumn><html:tableColumn>false</html:tableColumn><html:tableColumn>java.lang.String</html:tableColumn><html:tableColumn>Indicates the id for carousel</html:tableColumn></html:tableLine></html:tableBody></html:table>																																	</html:tab>																									<html:tab label="{demo}">																						
			<html:carousel>
				<html:carouselItem active="true" label="Item 1" description="Description 1">
					<html:carouselImage url="https://jslsolucoes.com/wp-content/uploads/logo.png" width="200" height="200" alt="logo"/>
				</html:carouselItem>
				<html:carouselItem label="Item 2" description="Description 2">
					<html:carouselImage url="https://jslsolucoes.com/wp-content/uploads/logo.png" width="200" height="200" alt="logo"/>
				</html:carouselItem>
			</html:carousel> 																							</html:tab>																									<html:tab label="{source}">																					<html:code>																										&lt;html:view&gt;
			&lt;html:carousel&gt;
				&lt;html:carouselItem active="true" label="Item 1" description="Description 1"&gt;
					&lt;html:carouselImage url="https://jslsolucoes.com/wp-content/uploads/logo.png" width="200" height="200" alt="logo"/&gt;
				&lt;/html:carouselItem&gt;
				&lt;html:carouselItem label="Item 2" description="Description 2"&gt;
					&lt;html:carouselImage url="https://jslsolucoes.com/wp-content/uploads/logo.png" width="200" height="200" alt="logo"/&gt;
				&lt;/html:carouselItem&gt;
			&lt;/html:carousel&gt; &lt;/html:view&gt;																					</html:code>																							</html:tab>																								</html:tabPanel>																						</html:cardBody>																						</html:card>																							</html:view>																			