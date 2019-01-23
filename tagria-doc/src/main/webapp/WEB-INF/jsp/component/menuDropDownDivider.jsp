<%@include file="../app/taglibs.jsp"%>										<html:view title="{title}">																	<html:card>																									<html:cardHeader label="menuDropDownDivider"/>												<html:cardBody>																								<html:tabPanel>																									<html:tab label="{about}" active="true">																	<html:alert state="warning">																				     	Renders a menu dropdown divider																			</html:alert>																							</html:tab>																									<html:tab label="{attributes}">										<html:alert state="info" label="{tag.empty.attributes}"></html:alert>																																	</html:tab>																									<html:tab label="{demo}">																						
			<html:menu>
				<html:menuButton icon="cog" align="right">
					<html:menuItem label="Item 1" url="#"/>
					<html:menuSeparator/>
					<html:menuItem label="Item 2" url="#"/>
					<html:menuItem label="Item 3" url="#"/>
				</html:menuButton>
			</html:menu> 																							</html:tab>																									<html:tab label="{source}">																					<html:code>																										&lt;html:view&gt;
			&lt;html:menu&gt;
				&lt;html:menuButton icon="cog" align="right"&gt;
					&lt;html:menuItem label="Item 1" url="#"/&gt;
					&lt;html:menuSeparator/&gt;
					&lt;html:menuItem label="Item 2" url="#"/&gt;
					&lt;html:menuItem label="Item 3" url="#"/&gt;
				&lt;/html:menuButton&gt;
			&lt;/html:menu&gt; &lt;/html:view&gt;																					</html:code>																							</html:tab>																								</html:tabPanel>																						</html:cardBody>																						</html:card>																							</html:view>																			