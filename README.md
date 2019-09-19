[![][travis img]][travis]
[![][maven img]][maven]
[![][sonar img]][sonar]
[![][bugs img]][bugs]
[![][coverage img]][coverage]
[![][lines img]][lines]
[![][vulnerabilities img]][vulnerabilities]
[![][code_smells img]][code_smells]
[![][paypal img]][paypal]

[travis]:https://travis-ci.org/jslsolucoes/tagria
[travis img]:https://travis-ci.org/jslsolucoes/tagria.svg?branch=master

[maven]:http://search.maven.org/#search|gav|1|g:"com.jslsolucoes"%20AND%20a:"tagria"
[maven img]:https://maven-badges.herokuapp.com/maven-central/com.jslsolucoes/tagria/badge.svg

[sonar]:https://sonarcloud.io/dashboard/index/com.jslsolucoes:tagria:master
[sonar img]:https://sonarcloud.io/api/badges/gate?key=com.jslsolucoes:tagria:master

[bugs]:https://sonarcloud.io/dashboard/index/com.jslsolucoes:tagria:master
[bugs img]:https://sonarcloud.io/api/badges/measure?key=com.jslsolucoes:tagria:master&metric=bugs

[coverage]:https://sonarcloud.io/dashboard/index/com.jslsolucoes:tagria:master
[coverage img]:https://sonarcloud.io/api/badges/measure?key=com.jslsolucoes:tagria:master&metric=coverage

[bugs]:https://sonarcloud.io/dashboard/index/com.jslsolucoes:tagria:master
[bugs img]:https://sonarcloud.io/api/badges/measure?key=com.jslsolucoes:tagria:master&metric=bugs

[lines]:https://sonarcloud.io/dashboard/index/com.jslsolucoes:tagria:master
[lines img]:https://sonarcloud.io/api/badges/measure?key=com.jslsolucoes:tagria:master&metric=lines

[vulnerabilities]:https://sonarcloud.io/dashboard/index/com.jslsolucoes:tagria:master
[vulnerabilities img]:https://sonarcloud.io/api/badges/measure?key=com.jslsolucoes:tagria:master&metric=vulnerabilities

[code_smells]:https://sonarcloud.io/dashboard/index/com.jslsolucoes:tagria:master
[code_smells img]:https://sonarcloud.io/api/badges/measure?key=com.jslsolucoes:tagria:master&metric=code_smells

[paypal]:https://www.paypal.com/cgi-bin/webscr?cmd=_s-xclick&hosted_button_id=PE25DPU3CNFH4
[paypal img]:https://www.paypalobjects.com/en_US/i/btn/btn_donateCC_LG.gif


# tagria
Tagria is an open source component suit framework that help build beautiful view in minutes. Tagria integrates perfectly with any action based mvc framework for java : 
Tagria it`s easy , fast and productive.

Tested at moment in MVC frameworks and specs :
<ul>
	<li>Spring MVC</li>
	<li>Vraptor</li>
	<li>Struts</li>
	<li>Servlet</li>
	<li>Mentawai</li>
</ul>

Tested at moment in applications servers :
<ul>
	<li>Tomcat</li>
	<li>Jetty</li>
	<li>Wildfly</li>
	<li>Jboss</li>
	<li>Websphere</li>
</ul>


Features :
<ul>
	<li>Full html5,css3 support</li>
	<li>Cross browser support components</li>
	<li>Responsive</li>
	<li>W3C compatible</li>
	<li>Support for i18n (internationalization)</li>
</ul>


<hr/>

The demo and documentation about components of tagria is hosted in : 
<a href='https://doc-tagrialib.jslsolucoes.com' target='_blank'>https://doc-tagrialib.jslsolucoes.com</a>

<hr/>
Quick start installation and configuration : 

Add latest maven dependency to your project : <a href='https://mvnrepository.com/artifact/com.jslsolucoes/tagria-lib-v4' target='_blank'>check for versions here</a>
<pre>
	<code>
&lt;dependency&gt;
	&lt;groupId&gt;com.jslsolucoes&lt;/groupId&gt;
	&lt;artifactId&gt;tagria-lib-v4&lt;/artifactId&gt;
	&lt;version&gt;latest-version&lt;/version&gt;
&lt;/dependency&gt;
	</code>
</pre>

Create an jsp for example index.jsp and import directives
<pre>
	<code>
	
&lt;%@ taglib  uri="http://v4.tagria.jslsolucoes.com/tags/html" prefix="html"%&gt;
&lt;%@ taglib  uri="http://v4.tagria.jslsolucoes.com/tags/ajax" prefix="ajax"%&gt;
&lt;%@ taglib  uri="http://v4.tagria.jslsolucoes.com/tags/x" prefix="x"%&gt;
&lt;%@ taglib uri="http://v4.tagria.jslsolucoes.com/tags/auth" prefix="auth"%&gt;
&lt;html:view title="My title"&gt;
	&lt;html:alert state="info"&gt;
		My firts view	
	&lt;/html:alert&gt;
&lt;/html:view&gt;
</code>
</pre>

Some configuration can be change by creating an tagrialib.xml file in source folder like, all options is optional by default :
<pre>
	<code>
	&lt;?xml version="1.0" encoding="ISO-8859-1" ?&gt;
	&lt;tagrialib&gt;
		&lt;templates&gt;
			&lt;template&gt;
				&lt;name&gt;master&lt;/name&gt;
				&lt;path&gt;/WEB-INF/jsp/app/template.jsp&lt;/path&gt;
			&lt;/template&gt;
		&lt;/templates&gt;
		&lt;formatters&gt;
			&lt;formatter&gt;
				&lt;name&gt;matriculaSap&lt;/name&gt;
				&lt;class&gt;com.package.YourFormatterThatImplementsFormatterInterface&lt;/class&gt;
			&lt;/formatter&gt;
		&lt;/formatters&gt;
		&lt;cdn&gt;
			&lt;enabled&gt;false&lt;/enabled&gt;
			&lt;url&gt;d35ckkxcy33ron.cloudfront.net&lt;/url&gt;
		&lt;/cdn&gt;
		&lt;encoding&gt;UTF-8&lt;/encoding&gt;
		&lt;skin&gt;default&lt;/skin&gt;
		&lt;locale&gt;en&lt;/locale&gt;
		&lt;auth&gt;
			&lt;class&gt;com.package.YourAuthorizerThatImplementsAuthorizerInterface&lt;/class&gt;
		&lt;/auth&gt;
	&lt;/tagrialib&gt; 
	</code>
</pre>

<h2>
	TagriaLib Framework has some official certification programs. Become an Tagria Library Framework Certified and demonstrate understanding of fundamental TagriaLib concepts needed to undertake any web java project using Tagria Library Framework as view framework.
</h2>

Authorized companies as TagriaLib Framework Certification Test Center:
<ul>
	<li>JSL Soluções LTDA (Brazil)  (https://jslsolucoes.com/certifications/)</li>
	<li>Extremnet LTDA    (Brazil)  (http://www.extremnet.com.br/contato)</li>
	<li>Codin Tech LTDA   (Brazil)  (http://codin.com.br/contato/)</li>
</ul>

If you want be a TagriaLib Framework Certification Test Center partner please contact us via issue request (https://github.com/jslsolucoes/tagria/issues)


