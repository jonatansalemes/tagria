package playground;

import com.jslsolucoes.tagria.html.HtmlAttribute;
import com.jslsolucoes.tagria.html.HtmlFactory;

public class MyComponentTag extends AbstractSimpleTagSupport {

	@Override
	public String html() {
		return HtmlFactory.newInput().attribute(HtmlAttribute.TYPE, "text").html();
	}

}
