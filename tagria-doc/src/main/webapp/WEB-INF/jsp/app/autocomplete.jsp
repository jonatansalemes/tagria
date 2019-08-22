<%@include file="../app/taglibs.jsp"%>
<html:view title="Playground">

	<c:forEach var="person" items="${ persons }">
		<html:autocompleteItem value="${ person.id }" text="${ person.name }">
			${ person.name }
		</html:autocompleteItem>
	</c:forEach>


</html:view>