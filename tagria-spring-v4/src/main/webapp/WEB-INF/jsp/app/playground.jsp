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
					<%@include file="another.jsp" %>		
				</html:formGroupMultiple>
			</html:formGroup>
			<html:formToolbar>
				<html:button type="submit" label="Send"></html:button>
			</html:formToolbar>
		</html:form>		
		
	</html:template>
</html:view>