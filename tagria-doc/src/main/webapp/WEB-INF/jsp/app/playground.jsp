<%@include file="../app/taglibs.jsp"%>
<html:view title="Playground">

	<html:form action="/app/playground/create">
		<html:formGroup label="Login" required="true">
			<html:input name="teste" required="true"  value="${ dateTime }">
				<html:format type="date"></html:format>
				<html:mask mask="99/99/9999" attachTo="teste"></html:mask>
			</html:input>
		</html:formGroup>
		<html:toolbar>
			<html:buttonGroup>
				<html:button label="teste" type="submit"></html:button>
			</html:buttonGroup>
		</html:toolbar>
	</html:form>
	
	

</html:view>