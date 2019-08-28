package com.jslsolucoes.tagria.lib.servlet;

public class TemplateManager {

	private static TemplateDefinition templateDefinition = new TemplateDefinition();
	
	public static TemplateDefinition get() {
		return templateDefinition;
	}
	
	public static void template(String template,String attribute) {
		templateDefinition.setTemplate(template);
		templateDefinition.setAttribute(attribute);
	}
	
}
