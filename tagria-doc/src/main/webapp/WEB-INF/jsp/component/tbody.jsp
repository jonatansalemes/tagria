<%@include file="../app/taglibs.jsp"%>										<html:view title="{title}">																	<html:card>																									<html:cardHeader>															tbody							</html:cardHeader>																						<html:cardBody>																								<html:tabPanel>																									<html:tab label="{about}" active="true">																	<html:alert state="warning">																				     	Renders a table body																			</html:alert>																							</html:tab>																									<html:tab label="{attributes}">										<html:alert state="info" label="{tag.empty.attributes}"></html:alert>																																	</html:tab>																									<html:tab label="{demo}">																						
			<html:table dark="true" hover="true" stripe="true>
				<html:caption>
					Caption
				</html:caption>
				<html:thead light="true">
					<html:tr>
						<html:th>Head 1</html:th>
					</html:tr>
				</html:thead>
				<html:tbody>
					<html:tr>
						<html:td>Column 1</html:td>
					</html:tr>
					<html:tr state="danger">
						<html:td>Value 1</html:td>
					</html:tr>
				</html:tbody>
			</html:table> 
																									</html:tab>																									<html:tab label="{source}">																					<html:code>																										&lt;html:view&gt;
			&lt;html:table dark="true" hover="true" stripe="true&gt;
				&lt;html:caption&gt;
					Caption
				&lt;/html:caption&gt;
				&lt;html:thead light="true"&gt;
					&lt;html:tr&gt;
						&lt;html:th&gt;Head 1&lt;/html:th&gt;
					&lt;/html:tr&gt;
				&lt;/html:thead&gt;
				&lt;html:tbody&gt;
					&lt;html:tr&gt;
						&lt;html:td&gt;Column 1&lt;/html:td&gt;
					&lt;/html:tr&gt;
					&lt;html:tr state="danger"&gt;
						&lt;html:td&gt;Value 1&lt;/html:td&gt;
					&lt;/html:tr&gt;
				&lt;/html:tbody&gt;
			&lt;/html:table&gt; 
		&lt;/html:view&gt;																					</html:code>																							</html:tab>																								</html:tabPanel>																						</html:cardBody>																						</html:card>																							</html:view>																			