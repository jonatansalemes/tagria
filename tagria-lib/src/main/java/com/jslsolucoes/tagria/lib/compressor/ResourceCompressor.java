
package com.jslsolucoes.tagria.lib.compressor;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

public class ResourceCompressor {

	private ResourceCompressor() {

	}

	public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException {

		Compressor compressor = new Compressor(args[0], args[1], Boolean.valueOf(args[2]));
		compressor.compressJs();
		compressor.compressCss();
		compressor.compressImage();
		compressor.compressFonts();
	}
}
