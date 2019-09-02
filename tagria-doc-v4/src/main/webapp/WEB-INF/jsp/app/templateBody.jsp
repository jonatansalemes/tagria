<%@include file="taglibs.jsp"%>
<html:view titleKey="title" template="master2">

	<html:template render="body">
		<html:alert state="danger">
			My body
		</html:alert>
	</html:template>
	<html:template render="header">
		<html:alert state="info">
			My header
		</html:alert>
	</html:template>
	<html:template render="footer">
		<html:alert state="success">
			My footer
		</html:alert>
	</html:template>

</html:view>