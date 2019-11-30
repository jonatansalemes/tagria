package com.jslsolucoes.tagria.tag.base.v4.tag;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletOutputStream;
import javax.servlet.WriteListener;

public class TagriaServletOutputStream extends ServletOutputStream {
    
    private OutputStream outputStream;

    public TagriaServletOutputStream(OutputStream outputStream) {
	this.outputStream = outputStream;
    }

    @Override
    public boolean isReady() {
	return false;
    }

    @Override
    public void setWriteListener(WriteListener writeListener) {
	
    }
    
    @Override
    public void flush() throws IOException {
	this.outputStream.flush();
    }

    @Override
    public void write(int b) throws IOException {
	this.outputStream.write(b);
    }
    
}
