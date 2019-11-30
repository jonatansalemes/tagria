package com.jslsolucoes.tagria.tag.base.v4.tag;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

public class TagriaServletResponseWrapper extends HttpServletResponseWrapper implements AutoCloseable {

    private OutputStream outputStream;
    private ServletOutputStream servletOutputStream;
    private PrintWriter printWriter;
    private String encoding;

    public TagriaServletResponseWrapper(HttpServletResponse httpServletResponse, String encoding) {
	super(httpServletResponse);
	this.encoding = encoding;
	this.outputStream = new ByteArrayOutputStream();
    }

    @Override
    public ServletOutputStream getOutputStream() throws IOException {
	if (servletOutputStream == null) {
	    servletOutputStream = new TagriaServletOutputStream(outputStream);
	}
	return servletOutputStream;
    }

    @Override
    public PrintWriter getWriter() throws IOException {
	if (printWriter == null) {
	    printWriter = new TagriaPrintWriter(outputStream, encoding);
	}
	return printWriter;
    }

    public TagriaServletResponseWrapper flush() throws IOException {
	flushBuffer();
	if (printWriter != null) {
	    printWriter.flush();
	} else if (servletOutputStream != null) {
	    servletOutputStream.flush();
	}
	return this;
    }

    public String asString() throws IOException {
	return new String(asByteArray(), encoding);
    }

    public byte[] asByteArray() throws IOException {
	return ((ByteArrayOutputStream) outputStream).toByteArray();
    }

    @Override
    public void close() throws IOException {

	if (servletOutputStream != null) {
	    servletOutputStream.close();
	}

	if (printWriter != null) {
	    printWriter.close();
	}

	if (outputStream != null) {
	    outputStream.close();
	}

    }

}
