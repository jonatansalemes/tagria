<%@include file="../app/taglibs.jsp"%>
<html:view title="Playground">


	<html:grid var="person" data="${ persons }" paginate="true" totalResults="210" url="/app/playground">
		<html:gridColumn label="Name">
			${ person.name }
		</html:gridColumn>
	</html:grid>





</html:view>