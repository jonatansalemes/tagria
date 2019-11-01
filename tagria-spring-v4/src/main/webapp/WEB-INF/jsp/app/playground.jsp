<%@include file="taglibs.jsp"%>
<html:view titleKey="app.title" template="master">
	<html:template render="body">
		<html:alert id="wc" state="info">
			teste
		</html:alert>
		<html:form action="/app/playground/submit" >
			<html:formGroup>
				DateTime: ${now}
				<html:format formatter="date">${now}</html:format>
				<html:input name="myDate" value="${now}" formatter="datePicker"></html:input>
				<html:datePicker attachTo="myDate"></html:datePicker>
			</html:formGroup>
			<html:formGroup>
				<html:formGroupMultiple atLeast="1" labelKey="app.dev.by">
					<html:input name="testes[]"></html:input>
					<html:datePicker attachTo="testes[]"></html:datePicker>
				</html:formGroupMultiple>
			</html:formGroup>
			<html:formToolbar>
				<html:button type="submit" label="Send"></html:button>
			</html:formToolbar>
		</html:form>		
		
		<html:tabs>
				<html:tabsHeader>
					<html:tabsTab id="tab01" label="My tab" active="true" ></html:tabsTab>
				</html:tabsHeader>
				<html:tabsBody>
					<html:tabsContent contentOf="tab01" active="true" url="/app/another">
						
					</html:tabsContent>
				</html:tabsBody>
			</html:tabs>
		
	</html:template>
</html:view>