<%@include file="taglibs.jsp"%>
<html:view titleKey="title" template="master" attribute="body">

	<html:tabs>
		<html:tabsHeader>
			<html:tabsTab id="tab1" labelKey="title" active="true"></html:tabsTab>
		</html:tabsHeader>
		<html:tabsBody>
			<html:tabsContent contentOf="tab1" active="true">
				<html:alert state="info" labelKey="welcome"></html:alert>
			</html:tabsContent>
		</html:tabsBody>
	</html:tabs>

</html:view>