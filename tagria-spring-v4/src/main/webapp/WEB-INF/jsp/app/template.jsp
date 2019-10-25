<%@include file="taglibs.jsp"%>
<html:view title="Playground">

	
	<html:cssCode>
		.grid {
			display:grid;
			grid-template-columns: 20vw 80vw;
			grid-template-rows: 70px calc(100vh - 140px) 70px;
			grid-template-areas: "a h"
								 "a m"
								 "a f";
		}
		
		header {
			grid-area: h;
		}
		
		aside {
			grid-area: a;
		}
		
		main {
			grid-area: m;
		}
		
		footer {
			grid-area: f;
		}
		
		.bg-4e73df-gradient {
		    background-color: #4e73df;
		    background-image: -webkit-gradient(linear, left top, left bottom, color-stop(10%, #4e73df), to(#224abe));
		    background-image: linear-gradient(180deg, #4e73df 10%, #224abe 100%);
		    background-size: cover;
		}
		
		.bg-f8f9fc {
		    background-color: #f8f9fc;
		}
		
	</html:cssCode>

	<html:div cssClass="grid">
		<html:header>
			Header
		</html:header>
		<html:aside cssClass="p-2 bg-4e73df-gradient">
			Aside
		</html:aside>
		<html:main cssClass="p-2 border-top border">
			<html:template render="body">
				Default body
			</html:template>
		</html:main>
		<html:footer
			cssClass="bg-white border-top border p-2 d-flex align-items-center justify-content-center">
			<html:span labelKey="app.dev.by" />
		</html:footer>
	</html:div>
	

</html:view>