<%@include file="taglibs.jsp"%>
<html:view titleKey="title" template="master" attribute="body">

	<html:tabs>
		<html:tabs-header>
			<html:tabs-tab id="tab1" labelKey="title" active="true"></html:tabs-tab>
		</html:tabs-header>
		<html:tabs-body>
			<html:tabs-content contentOf="tab1" active="true">
				<html:alert state="info" labelKey="welcome"></html:alert>
			</html:tabs-content>
		</html:tabs-body>
	</html:tabs>

</html:view>