<%@include file="taglibs.jsp"%>
<html:view titleKey="title">
	<html:alert state="info">
		Header
	</html:alert>
	<html:template render="body"/>
	<html:alert state="info">
		Footer
	</html:alert>
</html:view> 