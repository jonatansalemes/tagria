function ${name}(){
	var data = new Array(); 
	$.ajax({
		type:'post',
		processData:false,
		dataType:'${dataType}',
		beforeSend: function(jqXHR, settings) {
			var data = {};
			for (var property in settings.data) {
				data[property] = settings.data[property].value;									
				if(settings.data[property].required && settings.data[property].value == ''){
					return false;
				}
			}
			settings.data = $.param(data);
			<#if beforeSend??>
				${beforeSend}
			</#if>
			return true;
		},
		url: '${url}',
		async:true,
		data: {
			<#list data as dataItem>
			    '${dataItem.name}' : { required : ${dataItem.required?c}, value : ${dataItem.value} },
			</#list>
			'ajax' : { required: true, value : true }
		},
		error:function(jqXHR,textStatus,errorThrown){
			<#if onError??>
				${onError}
			</#if>
		},
		success:function(data,textStatus,jqXHR){
			<#list onSuccess as onSuccessCode>
				${onSuccessCode}
			</#list>
		}
	})
	.done(function(){
		<#if onDone??>
			${onDone}
		</#if>
	});
}