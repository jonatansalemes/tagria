<%@include file="taglibs.jsp"%>
<html:view>

	<html:div>
		My template
		<html:div>
			<html:template render="header">
				<html:alert state="info">
					My default header
					<html:input name="hd1"></html:input>
					<html:datePicker attachTo="hd1"></html:datePicker>
				</html:alert>
			</html:template>
		</html:div>
		<html:div>
			<html:template render="body">
				<html:alert state="success">
					My default body
				</html:alert>
			</html:template>
		</html:div>
		<html:div>
			<html:template render="footer">
				<html:alert state="danger">
					My default footer
				</html:alert>
			</html:template>
		</html:div>
	</html:div>

</html:view>
