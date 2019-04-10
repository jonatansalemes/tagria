<%@include file="../app/taglibs.jsp"%>
<html:view title="Playground">

	<html:form action="/app/playground/create">
		<html:formGroup label="Login" required="true">
			<html:input name="teste" required="true"></html:input>
		</html:formGroup>
		<html:formGroup label="Password" required="true">
			<html:input name="teste2" required="true"></html:input>
		</html:formGroup>
		<html:formGroup>
		
			<html:detailTable>
				
				
					<html:div>
						<html:formGroup label="Last name">
							<html:input name="lnames[]"></html:input>
						</html:formGroup>
						<html:formGroup label="First name">
							<html:input name="fnames[]"></html:input>
						</html:formGroup>
						<html:formGroup label="Ages">
							<html:input name="ages[]"></html:input>
						</html:formGroup>
					</html:div>
				
			</html:detailTable>
			
		</html:formGroup>
		<html:toolbar>
			<html:buttonGroup>
				<html:button label="teste" type="submit"></html:button>
			</html:buttonGroup>
		</html:toolbar>
	</html:form>

	

</html:view>