var defaultOption = $(document.createElement('option')).attr('value','').text('- - -');
$('#${id}').html('').append(defaultOption);	
for(i=0;i < data.length; i++) {
	var text = new Array();
	<#list tokens as token>
		text.push(data[i].${token});
	</#list>
	var option= $(document.createElement('option')).attr('value',data[i].${value}).text(text.join(' - '));
	$('#${id}').append(option);
} 																											