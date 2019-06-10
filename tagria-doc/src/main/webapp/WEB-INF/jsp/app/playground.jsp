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
	
	<html:button-group>
		<html:button label="My button" icon="search" id="btn1" />
		<html:button label="My button 2" icon="plus" id="btn2" state="danger" filled="true" />
	</html:button-group>
	
	<html:modal attachToSelector="#btn1">
		<html:modal-header label="My modal title"></html:modal-header>
		<html:modal-body>
			Here is my component
		</html:modal-body>
		<html:modal-footer>
			My footer
		</html:modal-footer>
	</html:modal>
	
	
	<html:card>
		<html:card-image url="/image/person.png" width="32" height="32" responsive="false"></html:card-image>
		<html:card-header>
			My header
		</html:card-header>
		<html:card-body>
			<html:card-title>My title</html:card-title>
			<html:card-sub-title>My subtitle</html:card-sub-title>
			<html:card-text>My text</html:card-text>
			<html:card-link label="My link 1" url="#"></html:card-link>
		</html:card-body>
		<html:card-footer>
			My footer
		</html:card-footer>
	</html:card>
	
	<html:list-group>
		<html:list-group-item>Item 1</html:list-group-item>
		<html:list-group-item>Item 2</html:list-group-item>
		<html:list-group-item>Item 3</html:list-group-item>
	</html:list-group>
	
	<html:js-code>
		console.log('js code as component');
	</html:js-code>
	
	<html:js-event event="click" attachToSelector="#btn2">
		console.log('btn 2 clicked');
	</html:js-event>
	
	
	

</html:view>