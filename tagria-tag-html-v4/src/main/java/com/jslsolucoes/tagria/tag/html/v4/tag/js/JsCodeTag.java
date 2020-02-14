
package com.jslsolucoes.tagria.tag.html.v4.tag.js;

import com.jslsolucoes.tagria.tag.base.v4.tag.AbstractSimpleTagSupport;

public class JsCodeTag extends AbstractSimpleTagSupport {

    @Override
    public void renderOnVoid() {
	appendJsCode(bodyContent());
    }
}
