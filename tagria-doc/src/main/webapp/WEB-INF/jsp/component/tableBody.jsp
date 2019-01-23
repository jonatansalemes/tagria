<%@include file="../app/taglibs.jsp"%>										<html:view title="{title}">																	<html:card>																									<html:cardHeader label="tableBody"/>												<html:cardBody>																								<html:tabPanel>																									<html:tab label="{about}" active="true">																	<html:alert state="warning">																				     	Renders a table body																			</html:alert>																							</html:tab>																									<html:tab label="{attributes}">										<html:alert state="info" label="{tag.empty.attributes}"></html:alert>																																	</html:tab>																									<html:tab label="{demo}">																						
			<html:table>
				<html:tableCaption>
					Caption
				</html:tableCaption>
				<html:tableBody>
					<html:tableLine>
						<html:tableColumn>Column 1</html:tableColumn>
					</html:tableLine>
					<html:tableLine state="danger">
						<html:tableColumn>Value 1</html:tableColumn>
					</html:tableLine>
				</html:tableBody>
			</html:table>
																									</html:tab>																									<html:tab label="{source}">																					<html:code>																										&lt;html:view&gt;
			&lt;html:table&gt;
				&lt;html:tableCaption&gt;
					Caption
				&lt;/html:tableCaption&gt;
				&lt;html:tableBody&gt;
					&lt;html:tableLine&gt;
						&lt;html:tableColumn&gt;Column 1&lt;/html:tableColumn&gt;
					&lt;/html:tableLine&gt;
					&lt;html:tableLine state="danger"&gt;
						&lt;html:tableColumn&gt;Value 1&lt;/html:tableColumn&gt;
					&lt;/html:tableLine&gt;
				&lt;/html:tableBody&gt;
			&lt;/html:table&gt;
		&lt;/html:view&gt;																					</html:code>																							</html:tab>																								</html:tabPanel>																						</html:cardBody>																						</html:card>																							</html:view>																			