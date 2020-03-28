<%@include file="taglibs.jsp"%>
<html:view title="Playground">

	<html:form action="#" label="My title"
		validation="/app/form/validation">


		<html:formOnBeforeSubmit>
			console.log('before submit event canceled');
			return false;
		</html:formOnBeforeSubmit>

		<html:formGroupRow>
			<html:col extraSmall="4">
				<html:formGroup label="Field 1 with an huge label of this one"
					required="true" forElement="field1">
					<html:input required="true" name="field1" />
				</html:formGroup>
				<html:jsEvent event="blur" attachTo="field1">
					console.log('hello ' + new Date());
				</html:jsEvent>
			</html:col>
			<html:col extraSmall="4">
				<html:formGroup label="Field 3 with an huge label of this one"
					required="true" forElement="field3">
					<html:input required="true" name="field3" />
				</html:formGroup>
			</html:col>
			<html:col extraSmall="4">
				<html:formGroup label="Field 19" required="true"
					forElement="field19">
					<html:select name="select1" data="${ persons }" var="person" required="true">
						<html:option value="${ person.id }">
							${ person.name }
						</html:option>
					</html:select>
				</html:formGroup>
			</html:col>
		</html:formGroupRow>
		<html:formGroup label="Field 17" required="true">
			<html:textarea name="textarea17" required="true"></html:textarea>
		</html:formGroup>
		<html:formGroup label="Field 18" required="true">
			<html:select name="filed18" data="${ persons }" var="person"
				required="true">
				<html:option value="${ person.id }">${ person.name }</html:option>
			</html:select>
		</html:formGroup>
		<html:formGroup label="One label">
			<html:icon icon="plus"></html:icon>
		</html:formGroup>
		<html:formGroup>
			<html:card>
				<html:cardBody>
					<html:formGroupRow>
						<html:col extraSmall="6">
							<html:formGroup label="Field 15" forElement="field15">
								<html:input name="field15" disabled="true"
									placeHolder="holder15" value="value15" />
							</html:formGroup>
						</html:col>
						<html:col extraSmall="6">
							<html:formGroup label="Field 16" forElement="field16">
								<html:input name="field16" disabled="true"
									placeHolder="holder16" value="value16" />
							</html:formGroup>
						</html:col>
					</html:formGroupRow>
				</html:cardBody>
			</html:card>
		</html:formGroup>
		<html:formGroup label="Field 2" forElement="field2">
			<html:input name="field2" disabled="true" placeHolder="holder2"
				value="value1" />
		</html:formGroup>
		<html:formGroup label="Field 14" forElement="field14">
			<html:input name="field14" disabled="true" placeHolder="holder14"
				value="value14" />
		</html:formGroup>

		<html:formGroupMultiple label="Groups 1" data="${ persons }"
			var="person" atLeast="1">


			<html:formGroupMultipleOnAfterInsert>
				console.log('after insert row ' + idx +  '=>' + element);
			</html:formGroupMultipleOnAfterInsert>

			<html:formGroupMultipleOnAfterRemove>
				console.log('after remove row ');
			</html:formGroupMultipleOnAfterRemove>

			<html:input name="fields3[]" required="true" value="${ person.name }" />
			<html:jsEvent event="blur" attachTo="fields3[]">
					console.log($(this).val());
				</html:jsEvent>
		</html:formGroupMultiple>


		<html:formToolbar>
			<html:button state="primary" type="submit" label="Label for submit" />
		</html:formToolbar>
	</html:form>

</html:view>