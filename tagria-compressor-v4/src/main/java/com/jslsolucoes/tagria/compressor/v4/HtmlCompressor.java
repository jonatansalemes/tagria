package com.jslsolucoes.tagria.compressor.v4;

public class HtmlCompressor {

    private HtmlCompressor() {

    }

    public static HtmlCompressor newCompressor() {
	return new HtmlCompressor();
    }

    public String compress(String htmlCode) {
	return htmlCode.replaceAll("(<.*?>)(\n|\r|\t|\\s)+(<.*?>)", "$1$3");
    }
}
