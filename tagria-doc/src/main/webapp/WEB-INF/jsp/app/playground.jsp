<%@include file="../app/taglibs.jsp"%>
<html:view title="Playground">
	
	
	<html:container>
		<html:form action="/app/playground2">
			<html:formGroup label="Auto" required="true">
				<html:autocomplete url="/autocomplete/query" name="mysearch" required="true">
					<html:autocompleteOnSelect>
						alert(item.attr('data-text'));
						alert(item.attr('data-value'));
					</html:autocompleteOnSelect>
				</html:autocomplete>
			</html:formGroup>
			<html:toolbar>
				<html:button type="submit" label="Save"></html:button>
			</html:toolbar>
		</html:form>
	</html:container>
	

</html:view>