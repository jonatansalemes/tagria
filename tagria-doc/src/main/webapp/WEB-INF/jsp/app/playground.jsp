<%@include file="../app/taglibs.jsp"%>
<html:view title="Playground">
	Its works
	
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
	
</html:view>