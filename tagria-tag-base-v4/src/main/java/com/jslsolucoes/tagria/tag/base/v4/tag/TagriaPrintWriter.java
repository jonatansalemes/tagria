package com.jslsolucoes.tagria.tag.base.v4.tag;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class TagriaPrintWriter extends PrintWriter {

    public TagriaPrintWriter(OutputStream outputStream, String encoding) throws IOException {
	super(new OutputStreamWriter(outputStream, encoding));
    }

}
