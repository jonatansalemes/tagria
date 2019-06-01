<%@include file="../app/taglibs.jsp"%>
<html:view title="Playground">


	<html:form>
		<html:formGroup label="Meu label" forElement="myNumber">
			<html:input type="number" min="10" max="30" name="myNumber" data-id="1"/>
		</html:formGroup>
	</html:form>

</html:view>