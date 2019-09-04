<%@include file="taglibs.jsp"%>
<html:view title="Playground">
	
	
	
	<html:cssCode>
	
		.gg {
			display:grid;
			grid-template-columns: 1fr 3fr;
			grid-template-rows: 70px 1fr 70px;
			grid-template-areas: "a h"
								 "a m"
								 "a f";
		}
		
		.toggled {
		    grid-template-columns: 6.5rem 3fr;
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
		
		#sidebarToggle {
		    width: 2.5rem;
		    height: 2.5rem;
		    text-align: center;
		    margin-bottom: 1rem;
		    cursor: pointer;
		    background-color: rgba(255,255,255,.2);
		}
		
		#sidebarToggle:hover {
		    background-color: rgba(255,255,255,.25);
		}
		
		#sidebarToggle:focus {
    		outline: 0;
		}
		
		#sidebarToggle::after {
		    color: rgba(255,255,255,.5);
		}

		#sidebarToggle::after {
		    font-weight: 900;
		    content: '\f104';
		    font-family: 'Font Awesome 5 Free';
		    margin-right: .1rem;
		}
		
		.gg.toggled #sidebarToggle::after {
    		content: '\f105';
		}
		
	</html:cssCode>
	
	<html:div cssClass="gg">
		<header class="p-2 d-flex align-items-center justify-content-between shadow">
				<html:autoComplete url="/app/autoComplete" name="employee"></html:autoComplete>
		</header>
		<aside class="p-2 bg-4e73df-gradient">
			Menu
			<html:div cssClass="d-flex align-items-center justify-content-center">
				<button class="rounded-circle border-0" id="sidebarToggle">
				
				</button>
			</html:div>
		</aside>
		<main class="p-2">
			Content<br/>Content<br/>Content<br/>Content<br/>Content<br/>Content<br/>Content<br/>Content<br/>Content<br/>Content<br/>Content<br/>Content<br/>Content
					    <br/>Content<br/>Content<br/>Content<br/>Content<br/>Content<br/>Content<br/>Content<br/>Content<br/>Content<br/>Content<br/>Content<br/>Content<br/>Content
					    <br/>Content<br/>Content<br/>Content<br/>Content<br/>Content<br/>Content<br/>Content<br/>Content<br/>Content<br/>Content<br/>Content<br/>Content<br/>Content
					    <br/>Content<br/>Content<br/>Content<br/>Content<br/>Content<br/>Content<br/>Content<br/>Content<br/>Content<br/>Content<br/>Content<br/>Content<br/>Content
		</main>
		<footer class="bg-white border-top border p-2 d-flex align-items-center justify-content-center">
			<html:div>
				Developed by JSL
			</html:div>
		</footer>
	</html:div>
	
	
	<html:jsEvent event="click" attachToSelector="#sidebarToggle">
		if($('.gg').hasClass('toggled')) {
			$('.gg').removeClass('toggled');
		} else {
			$('.gg').addClass('toggled'); 
		}
		
	</html:jsEvent>
	
</html:view>