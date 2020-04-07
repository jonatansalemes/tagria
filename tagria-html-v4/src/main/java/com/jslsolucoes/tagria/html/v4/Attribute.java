
package com.jslsolucoes.tagria.html.v4;

public enum Attribute {

    ACTION("action"), ACCEPT("accept"), ALT("alt"), AUTOFOCUS("autofocus"), AUTOCOMPLETE("autocomplete"),
    CLASS("class"), CONTENT("content"), CHECKED("checked"), COLSPAN("colspan"), DATA_DISMISS("data-dismiss"),
    DATA_TOGGLE("data-toggle"), DATA_TARGET("data-target"), DATA_TYPE("data-type"), DATA_URL("data-url"),
    DATA_KEYBOARD("data-keyboard"), DATA_BACKDROP("data-backdrop"), DATA_PARENT("data-parent"), DISABLED("disabled"),
    ENCTYPE("enctype"), FOR("for"), HREF("href"), HTTP_EQUIV("http-equiv"), HEIGHT("height"), ID("id"), LANG("lang"),
    METHOD("method"), MAXLENGTH("maxlength"), MULTIPLE("multiple"), MAX("max"), MIN("min"), NAME("name"),
    NOVALIDATE("novalidate"), ONSUBMIT("onsubmit"), PLACEHOLDER("placeholder"), PATTERN("pattern"), REL("rel"),
    ROLE("role"), REQUIRED("required"), ROWS("rows"), SRC("src"), SELECTED("selected"), STYLE("style"), TYPE("type"),
    TITLE("title"), TARGET("target"), VALUE("value"), XMLNS("xmlns"), WIDTH("width"), DATA_SITEKEY("data-sitekey"),
    DATA_RIDE("data-ride"), LIST("list"), DATA_SLIDE("data-slide"), STEP("step"), DATA_SRC("data-src"),
    DATA_SHOW("data-show"), ARIA_LABEL("aria-label"), DATA_VALUE("data-value"), DATA_TEXT("data-text"),
    TABINDEX("tabIndex"), DATA_RENDER("data-render"), DATA_PLACEMENT("data-placement"), DATA_CALLBACK("data-callback"),
    DATA_EXPIRED_CALLBACK("data-expired-callback"), DATA_ON_TEXT("data-on-text"), DATA_OFF_TEXT("data-off-text");

    private String name;

    private Attribute(String name) {
	this.name = name;
    }

    public String getName() {
	return name;
    }

}
