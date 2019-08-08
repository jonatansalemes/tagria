<%@include file="../app/taglibs.jsp"%>
<html:view title="Playground">

	<html:import url="/js/sb-admin-2.js" type="js"></html:import>
	<html:import url="/css/sb-admin-2.css" type="css"></html:import>

	<!-- Page Wrapper -->
	<div id="wrapper">

		<!-- Sidebar -->
		<ul
			class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion"
			id="accordionSidebar">

			<!-- Sidebar - Brand -->
			<a
				class="sidebar-brand d-flex align-items-center justify-content-center"
				href="index.html">
				<div class="sidebar-brand-icon rotate-n-15">
					<i class="fas fa-laugh-wink"></i>
				</div>
				<div class="sidebar-brand-text mx-3">
					SB Admin <sup>2</sup>
				</div>
			</a>

			<!-- Divider -->
			<hr class="sidebar-divider my-0">

			<!-- Nav Item - Dashboard -->
			<li class="nav-item active"><a class="nav-link"
				href="index.html"> <i class="fas fa-fw fa-tachometer-alt"></i> <span>Dashboard</span></a>
			</li>

			<!-- Divider -->
			<hr class="sidebar-divider">

			<!-- Heading -->
			<div class="sidebar-heading">Interface</div>

			<!-- Nav Item - Pages Collapse Menu -->
			<li class="nav-item"><a class="nav-link collapsed" href="#"
				data-toggle="collapse" data-target="#collapseTwo"
				aria-expanded="true" aria-controls="collapseTwo"> <i
					class="fas fa-fw fa-cog"></i> <span>Components</span>
			</a>
				<div id="collapseTwo" class="collapse" aria-labelledby="headingTwo"
					data-parent="#accordionSidebar">
					<div class="bg-white py-2 collapse-inner rounded">
						<h6 class="collapse-header">Custom Components:</h6>
						<a class="collapse-item" href="buttons.html">Buttons</a> <a
							class="collapse-item" href="cards.html">Cards</a>
					</div>
				</div></li>

			<!-- Nav Item - Utilities Collapse Menu -->
			<li class="nav-item"><a class="nav-link collapsed" href="#"
				data-toggle="collapse" data-target="#collapseUtilities"
				aria-expanded="true" aria-controls="collapseUtilities"> <i
					class="fas fa-fw fa-wrench"></i> <span>Utilities</span>
			</a>
				<div id="collapseUtilities" class="collapse"
					aria-labelledby="headingUtilities" data-parent="#accordionSidebar">
					<div class="bg-white py-2 collapse-inner rounded">
						<h6 class="collapse-header">Custom Utilities:</h6>
						<a class="collapse-item" href="utilities-color.html">Colors</a> <a
							class="collapse-item" href="utilities-border.html">Borders</a> <a
							class="collapse-item" href="utilities-animation.html">Animations</a>
						<a class="collapse-item" href="utilities-other.html">Other</a>
					</div>
				</div></li>

			<!-- Divider -->
			<hr class="sidebar-divider">

			<!-- Heading -->
			<div class="sidebar-heading">Addons</div>

			<!-- Nav Item - Pages Collapse Menu -->
			<li class="nav-item"><a class="nav-link collapsed" href="#"
				data-toggle="collapse" data-target="#collapsePages"
				aria-expanded="true" aria-controls="collapsePages"> <i
					class="fas fa-fw fa-folder"></i> <span>Pages</span>
			</a>
				<div id="collapsePages" class="collapse"
					aria-labelledby="headingPages" data-parent="#accordionSidebar">
					<div class="bg-white py-2 collapse-inner rounded">
						<h6 class="collapse-header">Login Screens:</h6>
						<a class="collapse-item" href="login.html">Login</a> <a
							class="collapse-item" href="register.html">Register</a> <a
							class="collapse-item" href="forgot-password.html">Forgot
							Password</a>
						<div class="collapse-divider"></div>
						<h6 class="collapse-header">Other Pages:</h6>
						<a class="collapse-item" href="404.html">404 Page</a> <a
							class="collapse-item" href="blank.html">Blank Page</a>
					</div>
				</div></li>

			<!-- Nav Item - Charts -->
			<li class="nav-item"><a class="nav-link" href="charts.html">
					<i class="fas fa-fw fa-chart-area"></i> <span>Charts</span>
			</a></li>

			<!-- Nav Item - Tables -->
			<li class="nav-item"><a class="nav-link" href="tables.html">
					<i class="fas fa-fw fa-table"></i> <span>Tables</span>
			</a></li>

			<!-- Divider -->
			<hr class="sidebar-divider d-none d-md-block">

			<!-- Sidebar Toggler (Sidebar) -->
			<div class="text-center d-none d-md-inline">
				<button class="rounded-circle border-0" id="sidebarToggle"></button>
			</div>

		</ul>
		<!-- End of Sidebar -->

		<!-- Content Wrapper -->
		<div id="content-wrapper" class="d-flex flex-column">

			<!-- Main Content -->
			<div id="content">

				<!-- Topbar -->
				<nav
					class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

					<!-- Sidebar Toggle (Topbar) -->
					<button id="sidebarToggleTop"
						class="btn btn-link d-md-none rounded-circle mr-3">
						<i class="fa fa-bars"></i>
					</button>

					<!-- Topbar Search -->
					<form
						class="d-none d-sm-inline-block form-inline mr-auto ml-md-3 my-2 my-md-0 mw-100 navbar-search">
						<div class="input-group">
							<input type="text" class="form-control bg-light border-0 small"
								placeholder="Search for..." aria-label="Search"
								aria-describedby="basic-addon2">
							<div class="input-group-append">
								<button class="btn btn-primary" type="button">
									<i class="fas fa-search fa-sm"></i>
								</button>
							</div>
						</div>
					</form>

					<!-- Topbar Navbar -->
					<ul class="navbar-nav ml-auto">

						<!-- Nav Item - Search Dropdown (Visible Only XS) -->
						<li class="nav-item dropdown no-arrow d-sm-none"><a
							class="nav-link dropdown-toggle" href="#" id="searchDropdown"
							role="button" data-toggle="dropdown" aria-haspopup="true"
							aria-expanded="false"> <i class="fas fa-search fa-fw"></i>
						</a> <!-- Dropdown - Messages -->
							<div
								class="dropdown-menu dropdown-menu-right p-3 shadow animated--grow-in"
								aria-labelledby="searchDropdown">
								<form class="form-inline mr-auto w-100 navbar-search">
									<div class="input-group">
										<input type="text"
											class="form-control bg-light border-0 small"
											placeholder="Search for..." aria-label="Search"
											aria-describedby="basic-addon2">
										<div class="input-group-append">
											<button class="btn btn-primary" type="button">
												<i class="fas fa-search fa-sm"></i>
											</button>
										</div>
									</div>
								</form>
							</div></li>

						<!-- Nav Item - Alerts -->
						<li class="nav-item dropdown no-arrow mx-1"><a
							class="nav-link dropdown-toggle" href="#" id="alertsDropdown"
							role="button" data-toggle="dropdown" aria-haspopup="true"
							aria-expanded="false"> <i class="fas fa-bell fa-fw"></i> <!-- Counter - Alerts -->
								<span class="badge badge-danger badge-counter">3+</span>
						</a> <!-- Dropdown - Alerts -->
							<div
								class="dropdown-list dropdown-menu dropdown-menu-right shadow animated--grow-in"
								aria-labelledby="alertsDropdown">
								<h6 class="dropdown-header">Alerts Center</h6>
								<a class="dropdown-item d-flex align-items-center" href="#">
									<div class="mr-3">
										<div class="icon-circle bg-primary">
											<i class="fas fa-file-alt text-white"></i>
										</div>
									</div>
									<div>
										<div class="small text-gray-500">December 12, 2019</div>
										<span class="font-weight-bold">A new monthly report is
											ready to download!</span>
									</div>
								</a> <a class="dropdown-item d-flex align-items-center" href="#">
									<div class="mr-3">
										<div class="icon-circle bg-success">
											<i class="fas fa-donate text-white"></i>
										</div>
									</div>
									<div>
										<div class="small text-gray-500">December 7, 2019</div>
										$290.29 has been deposited into your account!
									</div>
								</a> <a class="dropdown-item d-flex align-items-center" href="#">
									<div class="mr-3">
										<div class="icon-circle bg-warning">
											<i class="fas fa-exclamation-triangle text-white"></i>
										</div>
									</div>
									<div>
										<div class="small text-gray-500">December 2, 2019</div>
										Spending Alert: We've noticed unusually high spending for your
										account.
									</div>
								</a> <a class="dropdown-item text-center small text-gray-500"
									href="#">Show All Alerts</a>
							</div></li>

						<!-- Nav Item - Messages -->
						<li class="nav-item dropdown no-arrow mx-1"><a
							class="nav-link dropdown-toggle" href="#" id="messagesDropdown"
							role="button" data-toggle="dropdown" aria-haspopup="true"
							aria-expanded="false"> <i class="fas fa-envelope fa-fw"></i>
								<!-- Counter - Messages --> <span
								class="badge badge-danger badge-counter">7</span>
						</a> <!-- Dropdown - Messages -->
							<div
								class="dropdown-list dropdown-menu dropdown-menu-right shadow animated--grow-in"
								aria-labelledby="messagesDropdown">
								<h6 class="dropdown-header">Message Center</h6>
								<a class="dropdown-item d-flex align-items-center" href="#">
									<div class="dropdown-list-image mr-3">
										<img class="rounded-circle"
											src="https://source.unsplash.com/fn_BT9fwg_E/60x60" alt="">
										<div class="status-indicator bg-success"></div>
									</div>
									<div class="font-weight-bold">
										<div class="text-truncate">Hi there! I am wondering if
											you can help me with a problem I've been having.</div>
										<div class="small text-gray-500">Emily Fowler · 58m</div>
									</div>
								</a> <a class="dropdown-item d-flex align-items-center" href="#">
									<div class="dropdown-list-image mr-3">
										<img class="rounded-circle"
											src="https://source.unsplash.com/AU4VPcFN4LE/60x60" alt="">
										<div class="status-indicator"></div>
									</div>
									<div>
										<div class="text-truncate">I have the photos that you
											ordered last month, how would you like them sent to you?</div>
										<div class="small text-gray-500">Jae Chun · 1d</div>
									</div>
								</a> <a class="dropdown-item d-flex align-items-center" href="#">
									<div class="dropdown-list-image mr-3">
										<img class="rounded-circle"
											src="https://source.unsplash.com/CS2uCrpNzJY/60x60" alt="">
										<div class="status-indicator bg-warning"></div>
									</div>
									<div>
										<div class="text-truncate">Last month's report looks
											great, I am very happy with the progress so far, keep up the
											good work!</div>
										<div class="small text-gray-500">Morgan Alvarez · 2d</div>
									</div>
								</a> <a class="dropdown-item d-flex align-items-center" href="#">
									<div class="dropdown-list-image mr-3">
										<img class="rounded-circle"
											src="https://source.unsplash.com/Mv9hjnEUHR4/60x60" alt="">
										<div class="status-indicator bg-success"></div>
									</div>
									<div>
										<div class="text-truncate">Am I a good boy? The reason I
											ask is because someone told me that people say this to all
											dogs, even if they aren't good...</div>
										<div class="small text-gray-500">Chicken the Dog · 2w</div>
									</div>
								</a> <a class="dropdown-item text-center small text-gray-500"
									href="#">Read More Messages</a>
							</div></li>

						<div class="topbar-divider d-none d-sm-block"></div>

						<!-- Nav Item - User Information -->
						<li class="nav-item dropdown no-arrow"><a
							class="nav-link dropdown-toggle" href="#" id="userDropdown"
							role="button" data-toggle="dropdown" aria-haspopup="true"
							aria-expanded="false"> <span
								class="mr-2 d-none d-lg-inline text-gray-600 small">Valerie
									Luna</span> <img class="img-profile rounded-circle"
								src="https://source.unsplash.com/QAB-WJcbgJk/60x60">
						</a> <!-- Dropdown - User Information -->
							<div
								class="dropdown-menu dropdown-menu-right shadow animated--grow-in"
								aria-labelledby="userDropdown">
								<a class="dropdown-item" href="#"> <i
									class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i> Profile
								</a> <a class="dropdown-item" href="#"> <i
									class="fas fa-cogs fa-sm fa-fw mr-2 text-gray-400"></i>
									Settings
								</a> <a class="dropdown-item" href="#"> <i
									class="fas fa-list fa-sm fa-fw mr-2 text-gray-400"></i>
									Activity Log
								</a>
								<div class="dropdown-divider"></div>
								<a class="dropdown-item" href="#" data-toggle="modal"
									data-target="#logoutModal"> <i
									class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
									Logout
								</a>
							</div></li>

					</ul>

				</nav>
				<!-- End of Topbar -->

				<!-- Begin Page Content -->
				<div class="container-fluid">
					<html:input name="" type="date" min="1984-12-23" max="2000-01-01"></html:input>

					<ajax:function url="/app/ajax/list" name="ajaxPersons"
						execute="true">
						<ajax:parameters>
							<ajax:parameter name="param1" value="1"></ajax:parameter>
						</ajax:parameters>

						<ajax:on-success>
			console.log('success');
			<ajax:map-options value="id" target="ajaxSelect" text="name"></ajax:map-options>
						</ajax:on-success>
						<ajax:on-error>
			console.log('error');
		</ajax:on-error>
						<ajax:on-done>
			console.log('done');
		</ajax:on-done>
					</ajax:function>

					<html:select name="ajaxSelect">
						<html:option value="">---</html:option>
					</html:select>

					<html:css-code>
		.mystyle {
			background-color:   red;
		}
		.mystyle2 {
			color: white;
		}
	</html:css-code>

					<html:div cssClass="mystyle mystyle2">
		styled div ${ descriptions }
	</html:div>

					<html:grid var="person" data="${ persons }" label="My grid">

						<html:grid-export />
						<html:grid-paginate totalResults="${ totalResults }"></html:grid-paginate>
						<html:grid-search />

						<html:grid-toolbar>
							<html:alert state="danger">my toolbars</html:alert>
						</html:grid-toolbar>

						<html:grid-header>
							<html:grid-column label="Column 1" align="left" exportable="true"></html:grid-column>
							<html:grid-column label="Column 2" align="center"
								exportable="true"></html:grid-column>
							<html:grid-column label="Column 3" align="center"
								exportable="true"></html:grid-column>
						</html:grid-header>
						<html:grid-body>
							<html:grid-column-data align="right" exportable="true"
								cssClass="border border-danger">
				${ person.name }
			</html:grid-column-data>
							<html:grid-column-data align="center" exportable="true"
								booleanType="true" cssClass="border border-danger">
				${ person.likeChocolate }
			</html:grid-column-data>
							<html:grid-column-data align="center" exportable="true"
								collapsable="true" cssClass="border border-danger">
				${ person.cpf }
			</html:grid-column-data>
						</html:grid-body>
					</html:grid>





					<html:menu dark="true">
						<html:menu-brand label="my brand" url="/app/playground"></html:menu-brand>
						<html:menu-collapse attachToSelector="#block1" />
						<html:menu-collapsable id="block1">
							<html:menu-dropdown label="Menu">
								<html:menu-dropdown-item label="Item 1" url="#" />
								<html:menu-dropdown-divider />
								<html:menu-dropdown-item label="Item 2" target="_blank" url="#" />
								<html:menu-dropdown-item icon="trash" label="Item 3" url="#" />
							</html:menu-dropdown>
							<html:menu-link label="My link" url="#" />
						</html:menu-collapsable>
					</html:menu>


					<html:table dark="true" hover="true" stripe="true">
						<html:table-caption>
			Caption
		</html:table-caption>
						<html:table-header light="true">
							<html:table-row>
								<html:table-head>Head 1</html:table-head>
							</html:table-row>
						</html:table-header>
						<html:table-body>
							<html:table-row>
								<html:table-data>Column 1</html:table-data>
							</html:table-row>
							<html:table-row state="danger">
								<html:table-data>Value 1</html:table-data>
							</html:table-row>
						</html:table-body>
						<html:table-footer>
							<html:table-row>
								<html:table-data>Foot 1</html:table-data>
							</html:table-row>
							<html:table-row state="danger">
								<html:table-data>Foot value 1</html:table-data>
							</html:table-row>
						</html:table-footer>
					</html:table>


					<html:tabs afterShow="myFunction">
						<html:tabs-header>
							<html:tabs-tab data-id="mytabid" active="true" label="my tab 1"
								id="tab1"></html:tabs-tab>
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
						<html:button label="My button 2" icon="plus" id="btn2"
							state="danger" filled="true" />
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
						<html:card-image url="/image/person.png" width="32" height="32"
							responsive="false" alt="logo"></html:card-image>
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

					<html:listgroup>
						<html:listgroup-item>Item 1</html:listgroup-item>
						<html:listgroup-item>Item 2</html:listgroup-item>
						<html:listgroup-item>Item 3</html:listgroup-item>
					</html:listgroup>

					<html:js-code>
		console.log('js code as component');
		
		
		function myFunction(oldTab,newTab){
			console.log(oldTab);
			console.log(newTab);
		}
		
		function beforeSubmitMyForm() {
			console.log('before submit event canceled');
			return false;
		}
		
		function afterInsertMultipleFormGroup(idx,element) {
			console.log('after insert row ' + idx +  '=>' + element);
		}
		
		function afterRemoveMultipleFormGroup() {
			console.log('after remove row ');
		}
		
	</html:js-code>

					<html:js-event event="click" attachToSelector="#btn2">
		console.log('btn 2 clicked');
	</html:js-event>

					<html:carousel>
						<html:carousel-item active="true" label="Item 1"
							description="Description 1">
							<html:carousel-image
								url="https://solutionsreview.com/content-management/files/2017/08/Sungard-AS-Launches-Sovereign-Cloud-Consulting-and-Services.jpg"
								width="800" height="400" alt="logo" />
						</html:carousel-item>
						<html:carousel-item label="Item 2" description="Description 2">
							<html:carousel-image
								url="https://www.milesweb.com/blog/wp-content/uploads/2017/12/cloud-computing-in-iot-800x400.jpg"
								width="800" height="400" alt="logo" />
						</html:carousel-item>
					</html:carousel>

					<html:dropdown label="List">
						<html:dropdown-item label="Item 1" url="#" />
						<html:dropdown-divider />
						<html:dropdown-item label="Item 2" target="_blank" url="#" />
						<html:dropdown-item icon="trash" label="Item 3" url="#" />
					</html:dropdown>

					<html:form action="#" label="My title"
						beforeSubmit="beforeSubmitMyForm">

						<html:form-group label="Field 1" required="true"
							forElement="field1">
							<html:input required="true" name="field1" />
						</html:form-group>
						<html:form-group label="Field 2" forElement="field2">
							<html:input name="field2" />
						</html:form-group>
						<html:form-group-multiple label="Groups 1" data="${ persons }"
							var="person" atLeast="1"
							afterInsert="afterInsertMultipleFormGroup"
							afterRemove="afterRemoveMultipleFormGroup">
							<html:input name="fields3[]" required="true"
								value="${ person.name }" />
							<html:js-event event="blur" attachTo="fields3[]">
					console.log($(this).val());
				</html:js-event>
						</html:form-group-multiple>


						<html:form-toolbar>
							<html:button state="primary" type="submit"
								label="Label for submit" />
						</html:form-toolbar>
					</html:form>

					<html:img url="/image/person.png" alt="logo" responsive="true" />
					<html:icon icon="cog" />

					<html:div>
		Div tag
	</html:div>

					<html:block>
		Block tag
	</html:block>

					<html:data-block extraSmall="12" medium="4" small="4" large="4"
						data="${ persons }" var="person">
						<html:alert state="success">
			${ person.name }
		</html:alert>
					</html:data-block>


					<html:row>
						<html:col extraSmall="3">
							<html:input required="true" name="field4" />
							<html:mask mask="99/99/9999" attachTo="field4">
								<html:mask-on-keypress>
					 console.log($(field[0]).attr('id'));
				</html:mask-on-keypress>
							</html:mask>
						</html:col>
						<html:col extraSmall="9">
							<html:input name="field5" />
							<html:mask-currency attachTo="field5"></html:mask-currency>
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

					<html:small>
		small text
	</html:small>

					<html:p>
		Paragraph 
	</html:p>

					<html:code>
private class Java {
	private String id;
	private String name;
}
</html:code>

					<html:link label="My link" url="#" />

					<html:iframe url="/app/welcome" name="content"
						title="My iframe title" />

					<html:recaptcha siteKey="fdaf9dsj9j" />

					<html:input name="dl" list="myDatalist1" />
					<html:datalist id="myDatalist1" data="${ persons }" var="person">
						<html:datalist-option value="${ person.id }">
			${ person.name }
		</html:datalist-option>
					</html:datalist>

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

					My date
					<html:format type="datetime">${ dateTime}</html:format>

					<html:button id="btn3" label="Confirm that ?" url="#" />
					<html:confirm url="#" label="Confirm title"
						attachToSelector="#btn3" />

					<html:import url="/css/example.css" type="css"></html:import>
					<html:import url="/js/example.js" type="js"></html:import>
				</div>
				<!-- /.container-fluid -->

			</div>
			<!-- End of Main Content -->

			<!-- Footer -->
			<footer class="sticky-footer bg-white">
				<div class="container my-auto">
					<div class="copyright text-center my-auto">
						<span>Copyright &copy; Your Website 2019</span>
					</div>
				</div>
			</footer>
			<!-- End of Footer -->

		</div>
		<!-- End of Content Wrapper -->

	</div>
	<!-- End of Page Wrapper -->

	<!-- Scroll to Top Button-->
	<a class="scroll-to-top rounded" href="#page-top"> <i
		class="fas fa-angle-up"></i>
	</a>

	<!-- Logout Modal-->
	<div class="modal fade" id="logoutModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
					<button class="close" type="button" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">×</span>
					</button>
				</div>
				<div class="modal-body">Select "Logout" below if you are ready
					to end your current session.</div>
				<div class="modal-footer">
					<button class="btn btn-secondary" type="button"
						data-dismiss="modal">Cancel</button>
					<a class="btn btn-primary" href="login.html">Logout</a>
				</div>
			</div>
		</div>
	</div>



</html:view>