<%@include file="../app/taglibs.jsp"%>
<html:view title="Playground">


	<html:table dark="true" hover="true" stripe="true">
		<html:thead light="dark">
			<html:tr>
				<html:th label="My label"></html:th>
			</html:tr>
		</html:thead>
		<html:tbody>
			<html:tr>
				<html:td state="info"> hello </html:td>
			</html:tr>
		</html:tbody>
	</html:table>


	<html:tabs>
		<html:tabs-header>
			<html:tabs-tab active="true" label="my tab 1" id="tab1"></html:tabs-tab>
			<html:tabs-tab label="my tab 2" id="tab2"></html:tabs-tab>
			<html:tabs-tab label="my tab 3" id="tab3"></html:tabs-tab>
		</html:tabs-header>
		<html:tabs-body>
			<html:tabs-content active="true" contentOf="tab1"> My content 1</html:tabs-content>
			<html:tabs-content contentOf="tab2"> My content 2</html:tabs-content>
			<html:tabs-content contentOf="tab3"> My content 3</html:tabs-content>
		</html:tabs-body>
	</html:tabs>

</html:view>