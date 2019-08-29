package com.jslsolucoes.tagria.lib.servlet;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import javax.servlet.ServletOutputStream;
import javax.servlet.WriteListener;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

public class TagriaResponseWrapper extends HttpServletResponseWrapper implements AutoCloseable {

	private final ByteArrayOutputStream byteArrayOutputStream;
	private ServletOutputStream servletOutputStream;
	private PrintWriter printWriter;

	public TagriaResponseWrapper(HttpServletResponse response) {
		super(response);
		byteArrayOutputStream = new ByteArrayOutputStream(response.getBufferSize());
	}

	@Override
	public ServletOutputStream getOutputStream() {
		if (printWriter != null) {
			throw new IllegalStateException("getWriter() has already been called on this response.");
		}

		if (servletOutputStream == null) {
			servletOutputStream = new ServletOutputStream() {
				@Override
				public void write(int b) throws IOException {
					byteArrayOutputStream.write(b);
				}

				@Override
				public void flush() throws IOException {
					byteArrayOutputStream.flush();
				}

				@Override
				public void close() throws IOException {
					byteArrayOutputStream.close();
				}

				@Override
				public boolean isReady() {
					return false;
				}

				@Override
				public void setWriteListener(WriteListener arg0) {
				}
			};
		}

		return servletOutputStream;
	}

	@Override
	public PrintWriter getWriter() throws IOException {
		if (servletOutputStream != null) {
			throw new IllegalStateException("getOutputStream() has already been called on this response.");
		}

		if (printWriter == null) {
			printWriter = new PrintWriter(new OutputStreamWriter(byteArrayOutputStream, getCharacterEncoding()));
		}

		return printWriter;
	}

	@Override
	public void flushBuffer() throws IOException {
		super.flushBuffer();
		if (printWriter != null) {
			printWriter.flush();
		} else if (servletOutputStream != null) {
			servletOutputStream.flush();
		}
	}

	public byte[] asBytes() throws IOException {
		return byteArrayOutputStream.toByteArray();
	}

	public String asString() throws IOException {
		return new String(asBytes(), getCharacterEncoding());
	}

	public void close() {
		try {
			if(servletOutputStream != null ) {
				servletOutputStream.close();
			}
			if(byteArrayOutputStream != null) {
				byteArrayOutputStream.close();
			}
			if(printWriter != null) {
				printWriter.close();
			}
		} catch (IOException e) {

		}
	}

}