<%@include file="../app/taglibs.jsp"%>
<html:view title="Playground">


	<ajax:function url="/app/ajax/list" name="works" execute="true">
		<ajax:parameters>
			<ajax:parameter name="p1" value="v1"></ajax:parameter>
		</ajax:parameters>
		<ajax:onSuccess>
			alert('On Success');
			<ajax:mapOptions value="id" target="t1" text="name"/>
			<ajax:target type="html" target="t2" value="1"></ajax:target>
		</ajax:onSuccess>
		<ajax:onError>
			alert('On Error');
		</ajax:onError>
		<ajax:onDone>
			alert('On Done');
		</ajax:onDone>
		<ajax:beforeSend>
			alert('Before Send');
		</ajax:beforeSend>
	</ajax:function>

	<html:alert state="success">Works</html:alert>
	
	<html:block>
		Block component
	</html:block>
	
	<html:buttonGroup>
		<html:button label="label"></html:button>
	</html:buttonGroup>
	
	<html:card>
		<html:cardImage url="/image/person.png" alt="logo" height="50" width="50"></html:cardImage>
		<html:cardHeader>
			Card header
		</html:cardHeader>
		<html:cardBody>
			<html:cardTitle>
				My title
			</html:cardTitle>
			<html:cardText>
				My text
			</html:cardText>
		</html:cardBody>
		<html:cardFooter>
			Card Footer
		</html:cardFooter>
	</html:card>
	
	<html:carousel>
		<html:carouselItem active="true" description="Description 1" label="Label 1">
			<html:carouselImage url="/image/person.png" alt="logo" width="50" height="50"></html:carouselImage>
		</html:carouselItem>
	</html:carousel>
	
	<html:code>
		public class MyClass {
			private String name;
		}
		<table>
			<header>
				test
			</header>
		</table>
	</html:code>
	
	<html:collapsable label="My collapsable">
		Components
	</html:collapsable>
	
	<html:container>
		<html:row>
			<html:col extraSmall="12">
				One col
			</html:col>
		</html:row>
	</html:container>
	
	<html:dataBlock var="person" data="${ persons }" extraSmall="12" small="12" medium="12" large="12">
		${ person.name }
	</html:dataBlock>
	
	<html:div>
		Component
	</html:div>
	
	<html:dropDown label="My dropdown">
		<html:dropDownItem label="Item 1" url="#"></html:dropDownItem>
		<html:dropDownDivider></html:dropDownDivider>
		<html:dropDownItem label="Item 2" url="#"></html:dropDownItem>
	</html:dropDown>
	
	<html:h1>h1</html:h1>
	<html:h2>h2</html:h2>
	<html:h3>h3</html:h3>
	<html:hr></html:hr>
	
	<html:icon icon="search"></html:icon>
	
	<html:iframe url="/app/welcome" name="ifr1"></html:iframe>
	
	
</html:view>