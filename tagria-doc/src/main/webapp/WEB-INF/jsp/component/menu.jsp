<%@include file="../app/taglibs.jsp"%>										<html:view title="{title}">																	<html:card>																									<html:cardHeader label="menu"/>												<html:cardBody>																								<html:tabPanel>																									<html:tab label="{about}" active="true">																	<html:alert state="warning">																				     	Renders a horizontal menu																			</html:alert>																							</html:tab>																									<html:tab label="{attributes}">										<html:table stripe="true" hover="true"><html:tableHeader light="true"><html:tableLine><html:tableHead><fmt:message key="tag.attribute"/></html:tableHead><html:tableHead><fmt:message key="tag.required"/></html:tableHead><html:tableHead><fmt:message key="tag.type"/></html:tableHead><html:tableHead><fmt:message key="tag.description"/></html:tableHead></html:tableLine></html:tableHeader><html:tableBody><html:tableLine><html:tableColumn>fixed</html:tableColumn><html:tableColumn>false</html:tableColumn><html:tableColumn>java.lang.String</html:tableColumn><html:tableColumn>It indicates whether the component should be fixed. Default none. Options : top,bottom</html:tableColumn></html:tableLine></html:tableBody></html:table>																																	</html:tab>																									<html:tab label="{demo}">																						
			<html:menu>
				<html:menuButton icon="cog" align="right">
					<html:menuDropDownItem label="Item 1" url="#"/>
					<html:menuDropDownDivider/>
					<html:menuDropDownItem label="Item 2" url="#"/>
					<html:menuDropDownItem label="Item 3" url="#"/>
				</html:menuButton>
			</html:menu> 																							</html:tab>																									<html:tab label="{source}">																					<html:code>																										&lt;html:view&gt;
			&lt;html:menu&gt;
				&lt;html:menuButton icon="cog" align="right"&gt;
					&lt;html:menuDropDownItem label="Item 1" url="#"/&gt;
					&lt;html:menuDropDownDivider/&gt;
					&lt;html:menuDropDownItem label="Item 2" url="#"/&gt;
					&lt;html:menuDropDownItem label="Item 3" url="#"/&gt;
				&lt;/html:menuButton&gt;
			&lt;/html:menu&gt; &lt;/html:view&gt;																					</html:code>																							</html:tab>																								</html:tabPanel>																						</html:cardBody>																						</html:card>																							</html:view>																			