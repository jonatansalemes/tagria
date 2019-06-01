<%@include file="../app/taglibs.jsp"%>
<html:view title="Playground">


	<html:form>
		<html:formGroup label="Meu label" forElement="myNumber">
			<html:input type="number" min="10" max="30" name="myNumber" data-id="1"/>
		</html:formGroup>
		<html:multipleFormGroup label="Title" data="${persons}" var="person">
			<html:formGroup label="Cpfs">
				<html:input name="cpfs[]" value="${ person.cpf }">
					<html:format type="cpf"></html:format>
				</html:input>
				<html:mask mask="999.999.999-99" attachTo="cpfs[]"></html:mask>
			</html:formGroup>
			<html:formGroup label="Ceps">
				<html:input name="ceps[]" value="${ person.cep }">
					<html:format type="cep"></html:format>
				</html:input>
				<html:mask mask="99999-999" attachTo="ceps[]"></html:mask>
			</html:formGroup>						
		</html:multipleFormGroup>
	</html:form>

</html:view>