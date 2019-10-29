<%@include file="taglibs.jsp"%>
<html:view title="Playground">


	

	<html:form action="#" label="My title">


		<html:formOnBeforeSubmit>
			console.log('before submit event canceled');
			return false;
		</html:formOnBeforeSubmit>

		<html:formGroup>
			<html:row>
				<html:col extraSmall="6">
					<html:formGroup label="Field 1" required="true" forElement="field1">
						<html:input required="true" name="field1" placeHolder="holder1"/>
					</html:formGroup>
				</html:col>
				<html:col extraSmall="6">
					<html:formGroup label="Field 3" required="true" forElement="field3">
						<html:input required="true" name="field3" placeHolder="holder3"/>
					</html:formGroup>
				</html:col>
			</html:row>
		</html:formGroup>
		
		<html:formGroup label="Field 2" forElement="field2">
			<html:input name="field2" disabled="true" placeHolder="holder2" value="value1"/>
		</html:formGroup>
		<html:formGroupMultiple label="Groups 1" data="${ persons }"
			var="person" atLeast="1">


			<html:formGroupMultipleOnAfterInsert>
				console.log('after insert row ' + idx +  '=>' + element);
			</html:formGroupMultipleOnAfterInsert>

			<html:formGroupMultipleOnAfterRemove>
				console.log('after remove row ');
			</html:formGroupMultipleOnAfterRemove>
			
			<html:input name="fields3[]" required="true" value="${ person.name }" />
			<html:jsEvent event="blur" attachTo="fields3[]">
					console.log($(this).val());
				</html:jsEvent>
		</html:formGroupMultiple>


		<html:formToolbar>
			<html:button state="primary" type="submit" label="Label for submit" />
		</html:formToolbar>
	</html:form>


	<auth:rule uri="/pessoa3" httpMethod="get">
		<html:button label="This button will not render" icon="search"
			id="btn3" url="/pessoa" />
	</auth:rule>

	<html:input name="ipt1" formatter="cpf" value="${ cpf }"/>
	
	My date <html:format formatter="datetime">${ dateTime }</html:format>
	My cpf <html:format formatter="cpf">${ cpf }</html:format>
	My custom formatter  <html:format formatter="matriculaSap">${ cpf }</html:format>

	<html:autoComplete url="/app/autoComplete" name="myautoComplete">
		<html:autoCompleteOnSelect>
			console.log(value);
			console.log(text);
		</html:autoCompleteOnSelect>
	</html:autoComplete>


	<html:input name="mydate"></html:input>
	<html:datePicker attachTo="mydate" min="1" max="2"></html:datePicker>
	<html:tooltip attachTo="mydate">My tooltip</html:tooltip>

	<ajax:function url="/app/ajax/list" name="ajaxPersons" execute="true">
		<ajax:parameters>
			<ajax:parameter name="param1" value="1"></ajax:parameter>
		</ajax:parameters>

		<ajax:onSuccess>
			console.log('success');
			<ajax:mapOptions value="id" target="ajaxSelect" text="name"></ajax:mapOptions>
		</ajax:onSuccess>
		<ajax:onError>
			console.log('error');
		</ajax:onError>
		<ajax:onDone>
			console.log('done');
		</ajax:onDone>
	</ajax:function>

	<html:select name="ajaxSelect" searchable="true">
		<html:option value="">---</html:option>
	</html:select>

	<html:cssCode>
		.mystyle {
			background-color:   red;
		}
		.mystyle2 {
			color: white;
		}
	</html:cssCode>

	<html:div cssClass="mystyle mystyle2">
		styled div ${ descriptions }
	</html:div>

	<html:grid var="person" data="${ persons }" label="My grid"
		url="/app/playground/v4">

		<html:gridExport />
		<html:gridPaginate totalResults="200" />
		<html:gridSearch />

		<html:gridToolbar>
			<html:alert state="danger">my toolbars</html:alert>
		</html:gridToolbar>

		<html:gridHeader>
			<html:gridColumn label="Column 1" align="left" exportable="true"></html:gridColumn>
			<html:gridColumn label="Column 2" align="center" exportable="true"></html:gridColumn>
			<html:gridColumn label="Column 3" align="center" exportable="true"></html:gridColumn>
		</html:gridHeader>
		<html:gridBody>
			<html:gridColumnData align="right" exportable="true"
				cssClass="border border-danger" formatter="datetime">
				${ person.name }
			</html:gridColumnData>
			<html:gridColumnData align="center" exportable="true" cssClass="border border-danger" collapsable="true">
				${ person.likeChocolate }
			</html:gridColumnData>
			<html:gridColumnData align="center" exportable="true"
				collapsable="true" cssClass="border border-danger">
				${ person.cpf }
			</html:gridColumnData>
		</html:gridBody>
	</html:grid>





	<html:menu dark="true">
		<html:menuBrand label="my brand" url="/app/playground"></html:menuBrand>
		<html:menuCollapse attachToSelector="#block1" />
		<html:menuCollapsable id="block1">
			<html:menuDropdown label="Menu">
				<html:menuDropdownItem label="Item 1" url="#" />
				<html:menuDropdownDivider />
				<html:menuDropdownItem label="Item 2" target="_blank" url="#" />
				<html:menuDropdownItem icon="trash" label="Item 3" url="#" />
			</html:menuDropdown>
			<html:menuLink label="My link" url="#" />
		</html:menuCollapsable>
	</html:menu>


	<html:table dark="true" hover="true" stripe="true">
		<html:tableCaption>
			Caption
		</html:tableCaption>
		<html:tableHeader light="true">
			<html:tableRow>
				<html:tableHead>Head 1</html:tableHead>
			</html:tableRow>
		</html:tableHeader>
		<html:tableBody>
			<html:tableRow>
				<html:tableData>Column 1</html:tableData>
			</html:tableRow>
			<html:tableRow state="danger">
				<html:tableData>Value 1</html:tableData>
			</html:tableRow>
		</html:tableBody>
		<html:tableFooter>
			<html:tableRow>
				<html:tableData>Foot 1</html:tableData>
			</html:tableRow>
			<html:tableRow state="danger">
				<html:tableData>Foot value 1</html:tableData>
			</html:tableRow>
		</html:tableFooter>
	</html:table>


	<html:tabs>

		<html:tabsOnAfterShow>
			console.log(oldTab);
			console.log(newTab);
		</html:tabsOnAfterShow>

		<html:tabsHeader>
			<html:tabsTab data-id="mytabid" active="true" label="my tab 1"
				id="tab1"></html:tabsTab>
			<html:tabsTab label="my tab 2" id="tab2"></html:tabsTab>
			<html:tabsTab label="my tab 3" id="tab3"></html:tabsTab>
		</html:tabsHeader>
		<html:tabsBody>
			<html:tabsContent active="true" contentOf="tab1"> My content 1</html:tabsContent>
			<html:tabsContent contentOf="tab2"> My content 2</html:tabsContent>
			<html:tabsContent contentOf="tab3"> My content 3</html:tabsContent>
		</html:tabsBody>
	</html:tabs>

	<html:buttonGroup>
		<html:button label="My button" icon="search" id="btn1" />
		<html:button label="My button 2" icon="plus" id="btn2" state="danger"
			filled="true" />
	</html:buttonGroup>

	<html:modal attachToSelector="#btn1">
		<html:modalHeader label="My modal title"></html:modalHeader>
		<html:modalBody>
			Here is my component
		</html:modalBody>
		<html:modalFooter>
			My footer
		</html:modalFooter>
	</html:modal>


	<html:card>
		<html:cardImage url="/image/person.png" width="32" height="32"
			responsive="false" alt="logo"></html:cardImage>
		<html:cardHeader>
			My header
		</html:cardHeader>
		<html:cardBody>
			<html:cardTitle>My title</html:cardTitle>
			<html:cardSubTitle>My subtitle</html:cardSubTitle>
			<html:cardText>My text</html:cardText>
			<html:cardLink label="My link 1" url="#"></html:cardLink>
		</html:cardBody>
		<html:cardFooter>
			My footer
		</html:cardFooter>
	</html:card>

	<html:listGroup>
		<html:listGroupItem>Item 1</html:listGroupItem>
		<html:listGroupItem>Item 2</html:listGroupItem>
		<html:listGroupItem>Item 3</html:listGroupItem>
	</html:listGroup>

	<html:jsCode>
		console.log('js code as component');
	</html:jsCode>

	<html:jsEvent event="click" attachToSelector="#btn2">
		console.log('btn 2 clicked');
	</html:jsEvent>

	<html:carousel>
		<html:carouselItem active="true" label="Item 1"
			description="Description 1">
			<html:carouselImage
				url="https://solutionsreview.com/content-management/files/2017/08/Sungard-AS-Launches-Sovereign-Cloud-Consulting-and-Services.jpg"
				width="800" height="400" alt="logo" />
		</html:carouselItem>
		<html:carouselItem label="Item 2" description="Description 2">
			<html:carouselImage
				url="https://www.milesweb.com/blog/wp-content/uploads/2017/12/cloud-computing-in-iot-800x400.jpg"
				width="800" height="400" alt="logo" />
		</html:carouselItem>
	</html:carousel>

	<html:dropDown label="List">
		<html:dropDownItem label="Item 1" url="#" />
		<html:dropDownDivider />
		<html:dropDownItem label="Item 2" target="_blank" url="#" />
		<html:dropDownItem icon="trash" label="Item 3" url="#" />
	</html:dropDown>

	

	<html:img url="/image/person.png" alt="logo" responsive="true" />
	<html:icon icon="cog" />

	<html:div>
		Div tag
	</html:div>

	<html:block>
		Block tag
	</html:block>

	<html:dataBlock extraSmall="12" medium="4" small="4" large="4"
		data="${ persons }" var="person">
		<html:alert state="success">
			${ person.name }
		</html:alert>
	</html:dataBlock>


	<html:row>
		<html:col extraSmall="3">
			<html:input required="true" name="field4" />
			<html:mask mask="99/99/9999" attachTo="field4">
				<html:maskOnKeypress>
					 console.log($(field[0]).attr('id'));
				</html:maskOnKeypress>
			</html:mask>
		</html:col>
		<html:col extraSmall="9">
			<html:input name="field5" />
			<html:maskCurrency attachTo="field5"></html:maskCurrency>
		</html:col>
	</html:row>

	<html:container>
		<html:alert state="info">
			Component inside container
		</html:alert>
	</html:container>

	<html:h1>
		H1 header
	</html:h1>

	<html:h2>
		H2 header 
	</html:h2>

	<html:h3>
		H3 header 
	</html:h3>

	<html:h4>
		H3 header 
	</html:h4>

	<html:small>
		small text
	</html:small>

	<html:p>
		Paragraph 
	</html:p>

	<html:span>Span</html:span>

	<html:code>
private class Java {
	private String id;
	private String name;
}
</html:code>

	<html:link label="My link" url="#" />

	

	<html:recaptcha siteKey="fdaf9dsj9j" />

	<html:input name="dl" list="myDatalist1" />
	<html:dataList id="myDatalist1" data="${ persons }" var="person">
		<html:dataListOption value="${ person.id }">
			${ person.name }
		</html:dataListOption>
	</html:dataList>

	<html:select name="select1" data="${ persons }" var="person">
		<html:option value="${ person.id }">
			${ person.name }
		</html:option>
	</html:select>

	<html:textarea name="textarea1" rows="3">
		My textarea
		with
		new
		line
	</html:textarea>

	<html:jumbotron>
		<html:h1>
			Header
		</html:h1>
	</html:jumbotron>

	<html:collapsable label="Label 1">
		Components
	</html:collapsable>

	

	<html:button id="btn3" label="Confirm that ?" url="#" />
	<html:confirm url="#" label="Confirm title" attachToSelector="#btn3" />

	<html:import url="/css/example.css" type="css"></html:import>
	<html:import url="/js/example.js" type="js"></html:import>
	
	<html:iframe url="/" name="content" title="My iframe title" />
	



</html:view>