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

	public TagriaResponseWrapper(HttpServletResponse response) {
		super(response);
		logger.debug("initiate response wrapper with buffer size {}",response.getBufferSize());
		byteArrayOutputStream = new ByteArrayOutputStream(response.getBufferSize());
		logger.debug("byteArrayOutputStream size on init {}",byteArrayOutputStream.toByteArray().length);
	}

	@Override
	public ServletOutputStream getOutputStream() {
		
		
		logger.debug("getting outputStream for something");
		
		if (printWriter != null) {
			throw new IllegalStateException("getWriter() has already been called on this response.");
		}
		if (servletOutputStream == null) {
			servletOutputStream = new ServletOutputStream() {
				@Override
				public void write(int b) throws IOException {
					logger.debug("write single byte on outputStream");
					byteArrayOutputStream.write(b);
				}

				@Override
				public void flush() throws IOException {
					logger.debug("flush outputStream");
					byteArrayOutputStream.flush();
				}

				@Override
				public void close() throws IOException {
					logger.debug("close outputStream");
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
		
		logger.debug("getting writer for something");
		
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
		logger.debug("flushing buffer");
		super.flushBuffer();
		if (printWriter != null) {
			printWriter.flush();
		} else if (servletOutputStream != null) {
			servletOutputStream.flush();
		}
	}

	public byte[] asBytes() throws IOException {
		byte[] data = byteArrayOutputStream.toByteArray();
		logger.debug("byteArrayOutputStream size on get {}",data.length);
		return data;
	}

	public String asString() throws IOException {
		return new String(asBytes(), getCharacterEncoding());
	}

	public void close() {
		logger.debug("close everything");
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

		}
	}

}