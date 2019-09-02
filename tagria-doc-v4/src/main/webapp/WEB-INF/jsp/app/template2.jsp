<%@include file="taglibs.jsp"%>
<html:view>

	<html:div>
		My template
		<html:div>
			Will render my header
			<html:template render="header" />
		</html:div>
		<html:div>
			Will render my body
			<html:template render="body" />
		</html:div>
		<html:div>
			Will render my footer
			<html:template render="footer" />
		</html:div>
	</html:div>

</html:view>
