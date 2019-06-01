package playground;

import com.jslsolucoes.tagria.html.HtmlFactory;

public class MyDivTag extends AbstractSimpleTagSupport {

	@Override
	public String html() {
		return HtmlFactory.newDiv().html();
	}

}
