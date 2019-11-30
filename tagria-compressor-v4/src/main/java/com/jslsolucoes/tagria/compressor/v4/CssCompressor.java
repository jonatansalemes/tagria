package com.jslsolucoes.tagria.compressor.v4;

public class CssCompressor {

    private CssCompressor() {

    }

    public static CssCompressor newCompressor() {
	return new CssCompressor();
    }

    public String compress(String cssCode) {
	return cssCode.replaceAll("(\n|\r|\t|\\s{2,})", "").replaceAll(" \\{", "{").replaceAll(" ,", ",")
		.replaceAll(": ", ":").replaceAll(", ", ",");
    }
}
