package playground;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Map;
import java.util.Optional;
import java.util.WeakHashMap;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.DynamicAttributes;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.jslsolucoes.tagria.html.Script;
import com.jslsolucoes.tagria.lib.error.TagriaRuntimeException;
import com.jslsolucoes.tagria.lib.tag.html.MultipleFormGroupTag;
import com.jslsolucoes.tagria.lib.tag.html.ViewTag;

public abstract class AbstractSimpleTagSupport extends SimpleTagSupport implements DynamicAttributes {

	private Map<String, String> attributes = new WeakHashMap<String, String>();
	
	private void print() throws IOException {
		getJspContext().getOut().print(html());
	}

	@Override
	public void doTag() throws JspException, IOException {
		print();
		propagateJs();
	}

	private void propagateJs() {
		Script script = new Script();
		script.add(js());

		ViewTag viewTag = findAncestorWithClass(ViewTag.class)
				.orElseThrow(() -> new TagriaRuntimeException("View tag not found as ancestor"));
		viewTag.setScript(script);

		Optional<MultipleFormGroupTag> optionalMultipleFormGroupTag = findAncestorWithClass(MultipleFormGroupTag.class);
		if (optionalMultipleFormGroupTag.isPresent()) {
			MultipleFormGroupTag multipleFormGroupTag = optionalMultipleFormGroupTag.get();
			if (multipleFormGroupTag.getVarStatusObject().getIndex() == 0) {
				multipleFormGroupTag.setScript(script);
			}
		}

	}

	public Optional<String> body() {
		JspFragment jspFragment = getJspBody();
		if (jspFragment != null) {
			try (StringWriter body = new StringWriter()) {
				jspFragment.invoke(body);
				return Optional.of(body.toString().trim());
			} catch (Exception e) {
				throw new TagriaRuntimeException(e);
			}
		}
		return Optional.empty();
	}

	@SuppressWarnings("unchecked")
	public <T> Optional<T> findAncestorWithClass(Class<T> ancestorClass) {
		return (Optional<T>) Optional.ofNullable(SimpleTagSupport.findAncestorWithClass(this, ancestorClass));
	}

	@Override
	public void setDynamicAttribute(String uri, String localName, Object value) throws JspException {
		if (!localName.startsWith("data-")) {
			throw new TagriaRuntimeException(
					"Dynamic attributes must start with data- . Eg.  data-id=\"1\",data-url=\"/start\" ... ");
		}
		attributes.put(localName, value.toString());
	}

	public abstract String html();
	
	public String js() {
		return "";
	}
	
	public String css() {
		return "";
	}

}
