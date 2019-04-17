<%@include file="../app/taglibs.jsp"%>
<html:view title="Playground">

	<html:form action="/app/playground/create">
		<html:formGroup label="Login" required="true">
			<html:input name="teste" required="true"></html:input>
		</html:formGroup>
		<html:formGroup label="Password" required="true">
			<html:input name="teste2" required="true"></html:input>
		</html:formGroup>
		<html:formGroup label="Radio" required="true">
			<html:input type="radio" name="rdb" value="true"
				checked="${ booleanValue }"></html:input>
			<html:input type="radio" name="rdb" value="false"
				checked="${ !booleanValue }"></html:input>
		</html:formGroup>
		<html:multipleFormGroup label="Minha divisao" varStatus="status"
			data="${ persons }" var="person" afterInsert="newPerson"
			afterRemove="removePerson">
			<html:formGroup label="Last name">
				<html:select name="lnames[]" fixed="true">
					<html:option value="1">Teste 1</html:option>
					<html:option value="2">Teste 2</html:option>
					<html:option value="3">Teste 3</html:option>
				</html:select>
				<html:jsEvent event="change" attachTo="lnames[]">
					var id = $(object).attr('id');
					var line = id.split("__")[1];
					$('#par_first_name__' + line).val(id);
				</html:jsEvent>
			</html:formGroup>
			<html:formGroup label="First name">
				<html:input name="fnames[]"></html:input>
			</html:formGroup>
			<html:formGroup label="Ages">
				<html:input name="ages[]"></html:input>
			</html:formGroup>
		</html:multipleFormGroup>
		<html:multipleFormGroup label="Minha table">
			<html:table>
				<html:tableHeader dark="true">
					<html:tableLine state="info">
						<html:tableHead label="Head 1" />
						<html:tableHead label="Head 2" />
						<html:tableHead label="Head 3" />
						<html:tableHead label="Head 4" />
					</html:tableLine>
				</html:tableHeader>
				<html:tableBody>
					<html:tableLine>
						<html:tableColumn>
							<html:input name="chocolates[]"></html:input>
						</html:tableColumn>
						<html:tableColumn>
							<html:input name="chocolates1[]"></html:input>
						</html:tableColumn>
						<html:tableColumn>
							<html:input name="chocolates2[]"></html:input>
						</html:tableColumn>
						<html:tableColumn>
							<html:input name="chocolates3[]"></html:input>
						</html:tableColumn>
					</html:tableLine>
				</html:tableBody>
			</html:table>
		</html:multipleFormGroup>
		<html:toolbar>
			<html:buttonGroup>
				<html:button label="teste" type="submit"></html:button>
			</html:buttonGroup>
		</html:toolbar>
	</html:form>




	<html:jsCode>
		
		
		function removePerson() {
			console.log('removed');
		}
		
		function newPerson(idx,object) {
			console.log(idx);
		}
	</html:jsCode>



</html:view>