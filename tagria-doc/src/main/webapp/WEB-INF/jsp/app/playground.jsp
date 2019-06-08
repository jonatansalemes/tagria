<%@include file="../app/taglibs.jsp"%>
<html:view title="Playground">


	<html:table dark="true" hover="true" stripe="true">
		<html:tableHeader light="dark">
			<html:tableLine>
				<html:tableHead label="My label"></html:tableHead>
			</html:tableLine>
		</html:tableHeader>
		<html:tableBody>
			<html:tableLine>
				<html:tableColumn state="info"> hello </html:tableColumn>
			</html:tableLine>
		</html:tableBody>
	</html:table>
	
</html:view>