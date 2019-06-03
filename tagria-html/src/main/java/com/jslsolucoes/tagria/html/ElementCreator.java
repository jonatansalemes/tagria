package com.jslsolucoes.tagria.html;

public class ElementCreator {

	public static Html newHtml() {
		return new Html();
	}

	public static Body newBody() {
		return new Body();
	}

	public static Input newInput() {
		return new Input();
	}

	public static Div newDiv() {
		return new Div();
	}

	public static Button newButton() {
		return new Button();
	}

	public static Script newScript() {
		return new Script();
	}

	public static Img newImg() {
		return new Img();
	}

	public static Meta newMeta() {
		return new Meta();
	}

	public static Link newLink() {
		return new Link();
	}

	public static Head newHead() {
		return new Head();
	}

	public static Title newTitle() {
		return new Title();
	}

	public static NoScript newNoScript() {
		return new NoScript();
	}

	public static String newDocTypeHtml5() {
		return DocType.HTML5.definition();
	}
}
