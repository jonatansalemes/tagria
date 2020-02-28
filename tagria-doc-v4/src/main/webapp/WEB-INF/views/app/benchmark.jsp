<%@include file="../app/taglibs.jsp"%>
<html:view title="Benchmark page">


	<html:div
		cssClass="d-flex align-items-center h-100 justify-content-center">
		<html:div cssClass="d-flex w-50 flex-column">

			<html:alert cssClass="mt-3 mb-3" id="invalidLogin" state="danger"
				rendered="${error}" label="Login invalido" />

			<html:alert cssClass="mt-3 mb-3" id="successLogout" state="success"
				rendered="${logout}" label="Successfully logout" />

			<html:div>
				<html:form action="/user/authenticate" label="Authentication">
					<html:formGroup label="Login" required="true">
						<html:input name="login" required="true"></html:input>
					</html:formGroup>
					<html:formGroup label="Paswword" required="true">
						<html:input name="password" type="password" required="true"></html:input>
					</html:formGroup>
					<html:formToolbar>
						<html:button id="auth" type="submit"
							label="Authenticate" cssClass="mr-30px"></html:button>
					</html:formToolbar>
				</html:form>
			</html:div>
		</html:div>
	</html:div>

	<html:animate animation="bounceIn" attachToSelector="#invalidLogin">

	</html:animate>

	<html:animate animation="bounceIn" attachToSelector="#successLogout">

	</html:animate>

	<ajax:function url="/app/version" name="versionOfApp" execute="true">
		<ajax:onSuccess>
			$('.text-secondary').append($(document.createElement('small')).text('(' + data.version + ')'));
		</ajax:onSuccess>
	</ajax:function>

</html:view>