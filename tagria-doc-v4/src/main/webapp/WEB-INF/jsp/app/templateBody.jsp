<%@include file="taglibs.jsp"%>
<html:view titleKey="title" template="master2">


	<html:cssCode>
		.myclass {
			border: 1px solid black;
		}
	</html:cssCode>

	<html:template render="body">
		<html:alert state="danger">
			My body
		</html:alert>
	</html:template>
	<html:template render="header">
		<html:alert state="info">
			My header
			<html:input name="hd2"></html:input>
			<html:datePicker attachTo="hd2"></html:datePicker>
		</html:alert>
	</html:template>
	<html:template render="footer">
		<html:alert state="light">
			My footer
		</html:alert>
	</html:template>

</html:view>