<%@include file="../app/taglibs.jsp"%>
<html:view title="{title}">	
	<html:tabPanel>
		<html:tab label="{title}" active="true">
			<html:alert state="info" label="{welcome}"></html:alert>
		</html:tab>
	</html:tabPanel>
	
</html:view>