<%@include file="../app/taglibs.jsp"%>
<html:view title="Playground">


	<html:form>
		<html:formGroup label="Meu label">
			<html:select name="teste" data="${ persons }" var="person">
				<html:option value="${ person.id }">${ person.name }</html:option>
			</html:select>
		</html:formGroup>
		<html:multipleFormGroup label="Grupo" atLeast="1">
			<html:formGroup label="Meu label 2" required="true">
				<html:select name="teste2[]" data="${ persons }" var="person" required="true">
					<html:option value="${ person.id }">${ person.name }</html:option>
				</html:select>
			</html:formGroup>
		</html:multipleFormGroup>

	</html:form>






</html:view>