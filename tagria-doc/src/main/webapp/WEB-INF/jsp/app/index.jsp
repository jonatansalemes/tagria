<%@include file="../app/taglibs.jsp"%>
<html:view title="{title}">

	<html:import type="css" url="/css/app.css"></html:import>



	<html:body cssClass="mt-60px">

		<html:menu fixed="top">
			<html:container>
				<html:menuBrand url="/" label="{title}"></html:menuBrand>
			</html:container>
		</html:menu>

		<html:container>
			<html:div cssClass="left float-left">
				<html:div cssClass="menu"><html:listGroup><html:listGroupItem><html:collapsable label="Ajax"><html:listGroup><html:listGroupItem><html:link label="BeforeSend" target="conteudo" url="/component/beforeSend"></html:link></html:listGroupItem><html:listGroupItem><html:link label="Function" target="conteudo" url="/component/function"></html:link></html:listGroupItem><html:listGroupItem><html:link label="MapOptions" target="conteudo" url="/component/mapOptions"></html:link></html:listGroupItem><html:listGroupItem><html:link label="OnDone" target="conteudo" url="/component/onDone"></html:link></html:listGroupItem><html:listGroupItem><html:link label="OnError" target="conteudo" url="/component/onError"></html:link></html:listGroupItem><html:listGroupItem><html:link label="OnSuccess" target="conteudo" url="/component/onSuccess"></html:link></html:listGroupItem><html:listGroupItem><html:link label="Parameter" target="conteudo" url="/component/parameter"></html:link></html:listGroupItem><html:listGroupItem><html:link label="Parameters" target="conteudo" url="/component/parameters"></html:link></html:listGroupItem><html:listGroupItem><html:link label="Target" target="conteudo" url="/component/target"></html:link></html:listGroupItem></html:listGroup></html:collapsable></html:listGroupItem><html:listGroupItem><html:collapsable label="Misc"><html:listGroup><html:listGroupItem><html:link label="View" target="conteudo" url="/component/view"></html:link></html:listGroupItem></html:listGroup></html:collapsable></html:listGroupItem><html:listGroupItem><html:collapsable label="Table"><html:listGroup><html:listGroupItem><html:link label="Table" target="conteudo" url="/component/table"></html:link></html:listGroupItem><html:listGroupItem><html:link label="TableBody" target="conteudo" url="/component/tableBody"></html:link></html:listGroupItem><html:listGroupItem><html:link label="TableCaption" target="conteudo" url="/component/tableCaption"></html:link></html:listGroupItem><html:listGroupItem><html:link label="TableColumn" target="conteudo" url="/component/tableColumn"></html:link></html:listGroupItem><html:listGroupItem><html:link label="TableHead" target="conteudo" url="/component/tableHead"></html:link></html:listGroupItem><html:listGroupItem><html:link label="TableHeader" target="conteudo" url="/component/tableHeader"></html:link></html:listGroupItem><html:listGroupItem><html:link label="TableLine" target="conteudo" url="/component/tableLine"></html:link></html:listGroupItem></html:listGroup></html:collapsable></html:listGroupItem></html:listGroup></html:div>
			</html:div>
			<html:div cssClass="right float-left">
				<html:iframe name="conteudo" url="/app/welcome"></html:iframe>
			</html:div>
		</html:container>

	</html:body>
</html:view>