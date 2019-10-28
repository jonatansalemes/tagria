package com.jslsolucoes.tagria.tag.base.v4.tag;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import javax.servlet.ServletOutputStream;
import javax.servlet.WriteListener;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TagriaResponseWrapper extends HttpServletResponseWrapper implements AutoCloseable {

	private static final Logger logger = LoggerFactory.getLogger(TagriaResponseWrapper.class);
	private final ByteArrayOutputStream byteArrayOutputStream;
	private ServletOutputStream servletOutputStream;
	private PrintWriter printWriter;
	private String encoding;

	public TagriaResponseWrapper(HttpServletResponse response,String encoding) {
		super(response);
		this.encoding = encoding;
		logger.debug("Encoding to accepts {}",this.encoding);
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
			printWriter = new PrintWriter(new OutputStreamWriter(byteArrayOutputStream,encoding));
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
		flushBuffer();
		return byteArrayOutputStream.toByteArray();
	}

	public String asString() throws IOException {
		return new String(asBytes(), encoding);
	}

	public void close() {
		try {
			if(servletOutputStream != null ) {
				servletOutputStream.close();
			} else if(printWriter != null) {
				printWriter.close();
			}
			if(byteArrayOutputStream != null) {
				byteArrayOutputStream.close();
			}
		} catch (IOException e) {
			logger.error("Could not close resources",e);
		}
	}

}