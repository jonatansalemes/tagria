
package com.jslsolucoes.tagria.lib.tag.html;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.jslsolucoes.tagria.lib.html.Attribute;
import com.jslsolucoes.tagria.lib.html.Div;
import com.jslsolucoes.tagria.lib.util.TagUtil;

@SuppressWarnings({ "rawtypes" })
public class DataBlockTag extends SimpleTagSupport {

	private String var;
	private Collection data;
	private Integer limit = 4;
	private Integer extraSmall;
	private Integer small;
	private Integer medium;
	private Integer large;
	
	@Override
	public void doTag() throws JspException, IOException {
		List<List<Object>> dataBlocks = dataBlocks(data,limit);
		JspContext jspContext = getJspContext();
		Div div = new Div();
		for(List<Object> objects : dataBlocks){
			Div row = new Div();
			row.add(Attribute.CLASS,"row");
			for(Object object : objects) {
				jspContext.setAttribute(var, object);
				Div col = new Div();
				col.add(Attribute.CLASS, "col-xs-" + extraSmall);
				
				if(small != null){
					col.add(Attribute.CLASS, "col-sm-" + small);
				}
				if(medium != null){
					col.add(Attribute.CLASS, "col-md-" + medium);
				}
				if(large != null){
					col.add(Attribute.CLASS, "col-lg-" + large);
				}
				col.add(TagUtil.getBody(getJspBody()));
				row.add(col);
			}
			jspContext.setAttribute(var,null);
			div.add(row);
		}
		TagUtil.out(getJspContext(), div);
	}
	
	private List<List<Object>> dataBlocks(Collection data,Integer limit) {
		List<List<Object>> dataBlocks = new ArrayList<List<Object>>();
		List<Object> block = block(limit);
		for(Object object : data){
			block.add(object);
			if(block.size() == limit){
				dataBlocks.add(block);
				block = block(limit);
			}
		}
		if(!block.isEmpty()) {
			dataBlocks.add(block);
		}
		return dataBlocks;
	}
	
	private List<Object> block(Integer limit) {
		return new ArrayList<>(limit);
	}

	public String getVar() {
		return var;
	}

	public void setVar(String var) {
		this.var = var;
	}

	public Collection getData() {
		return data;
	}

	public void setData(Collection data) {
		this.data = data;
	}

	public Integer getLimit() {
		return limit;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}
	
	public Integer getExtraSmall() {
		return extraSmall;
	}

	public void setExtraSmall(Integer extraSmall) {
		this.extraSmall = extraSmall;
	}

	public Integer getSmall() {
		return small;
	}

	public void setSmall(Integer small) {
		this.small = small;
	}

	public Integer getMedium() {
		return medium;
	}

	public void setMedium(Integer medium) {
		this.medium = medium;
	}

	public Integer getLarge() {
		return large;
	}

	public void setLarge(Integer large) {
		this.large = large;
	}
}
