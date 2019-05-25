<%@include file="../app/taglibs.jsp"%>
<html:view title="Playground">


	<html:dropDown label="List">
		<html:dropDownItem label="Item 1" url="/a/b?id=1" />
		<html:dropDownDivider />
		<html:dropDownItem label="Item 2" target="_blank" url="#" />
		<html:dropDownItem icon="trash" label="Item 3" url="/a" />
	</html:dropDown>




</html:view>