package com.jslsolucoes.tagria.tag.html.v4;

import java.io.File;
import java.io.IOException;
import java.util.stream.Collectors;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.TrueFileFilter;

public class MetaDataBuilder {

	public static void main(String[] args) throws IOException {
		String charset = "UTF-8";
		File metadataFolder = new File(args[0]);
		File templateFile = new File(args[1]);
		File templateOutputFile = new File(args[2]);

		String data = FileUtils.readFileToString(templateFile, charset);
		String metaData = FileUtils.listFiles(metadataFolder, TrueFileFilter.TRUE, TrueFileFilter.TRUE).stream()
				.map(file -> {
					try {
						return FileUtils.readFileToString(file, charset).replaceAll("<\\/?fragment>","");
					} catch (IOException e) {
						throw new RuntimeException(e);
					}
				}).collect(Collectors.joining(""));
		String newData = data.replace("<!-- <template/> -->", metaData);
		FileUtils.writeStringToFile(templateOutputFile, newData, charset);
	}

}
