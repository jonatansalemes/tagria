<%@include file="../app/taglibs.jsp"%>										<html:view title="{title}">																	<html:card>																									<html:cardHeader label="datePickerOnSelect"/>												<html:cardBody>																								<html:tabPanel>																									<html:tab label="{about}" active="true">																	<html:alert state="warning">																				     	>Renders an event after datePicker select date for a input																			</html:alert>																							</html:tab>																									<html:tab label="{attributes}">										<html:alert state="info" label="{tag.empty.attributes}"></html:alert>																																	</html:tab>																									<html:tab label="{demo}">																						
			<html:input name="input1" placeholder="Date birth" />
			<html:datePicker attachTo="input1" min="0">
				<html:datePickerOnSelect>
					/* Available variables on select dateText,inst  */
					alert(dateText);
				</html:datePickerOnSelect>
			</html:datePicker> 																							</html:tab>																									<html:tab label="{source}">																					<html:code>																										&lt;html:view&gt;
			&lt;html:input name="input1" placeholder="Date birth" /&gt;
			&lt;html:datePicker attachTo="input1" min="0"&gt;
				&lt;html:datePickerOnSelect&gt;
					/* Available variables on select dateText,inst  */
					alert(dateText);
				&lt;/html:datePickerOnSelect&gt;
			&lt;/html:datePicker&gt; &lt;/html:view&gt;																					</html:code>																							</html:tab>																								</html:tabPanel>																						</html:cardBody>																						</html:card>																							</html:view>																			