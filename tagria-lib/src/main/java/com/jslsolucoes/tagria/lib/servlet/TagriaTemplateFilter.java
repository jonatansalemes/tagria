package com.jslsolucoes.tagria.lib.servlet;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.WriteListener;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

import org.apache.commons.lang.StringUtils;

public class TagriaTemplateFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;
		HtmlResponseWrapper bodyResponse = new HtmlResponseWrapper(httpServletResponse);
		filterChain.doFilter(request, bodyResponse);
		TemplateDefinition templateDefinition = TemplateManager.get();
		if(!StringUtils.isEmpty(templateDefinition.getTemplate()) && !StringUtils.isEmpty(templateDefinition.getAttribute())) {
			String template = templateDefinition.getTemplate();
			String attribute = templateDefinition.getAttribute();
			HtmlResponseWrapper templateResponse = new HtmlResponseWrapper(httpServletResponse);
			request.getRequestDispatcher("/WEB-INF/jsp/app/"+templateDefinition.getTemplate()+"-template.jsp").include(request,templateResponse);
			System.out.println("user template engine template:"+ template + ",attribute:" + attribute);
			System.out.println("Template response " + templateResponse.getCaptureAsString());
			System.out.println("Body response " + bodyResponse.getCaptureAsString());
			String finalResponse = templateResponse.getCaptureAsString().trim().replace("<mytag definition=\""+attribute+"\"/>",bodyResponse.getCaptureAsString().trim());
			System.out.println("Final response " + finalResponse);
			response.getOutputStream().write(finalResponse.getBytes("UTF-8"));
		} else {
			System.out.println("not use template engine");
			response.getOutputStream().write(bodyResponse.getCaptureAsBytes());
		}
	}

	@Override
	public void destroy() {
		
	}
}

class HtmlResponseWrapper extends HttpServletResponseWrapper {

    private final ByteArrayOutputStream capture;
    private ServletOutputStream output;
    private PrintWriter writer;

    public HtmlResponseWrapper(HttpServletResponse response) {
        super(response);
        capture = new ByteArrayOutputStream(response.getBufferSize());
    }

    @Override
    public ServletOutputStream getOutputStream() {
        if (writer != null) {
            throw new IllegalStateException(
                    "getWriter() has already been called on this response.");
        }

        if (output == null) {
            output = new ServletOutputStream() {
                @Override
                public void write(int b) throws IOException {
                    capture.write(b);
                }

                @Override
                public void flush() throws IOException {
                    capture.flush();
                }

                @Override
                public void close() throws IOException {
                    capture.close();
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

        return output;
    }

    @Override
    public PrintWriter getWriter() throws IOException {
        if (output != null) {
            throw new IllegalStateException(
                    "getOutputStream() has already been called on this response.");
        }

        if (writer == null) {
            writer = new PrintWriter(new OutputStreamWriter(capture,
                    getCharacterEncoding()));
        }

        return writer;
    }

    @Override
    public void flushBuffer() throws IOException {
        super.flushBuffer();

        if (writer != null) {
            writer.flush();
        } else if (output != null) {
            output.flush();
        }
    }

    public byte[] getCaptureAsBytes() throws IOException {
        if (writer != null) {
            writer.close();
        } else if (output != null) {
            output.close();
        }

        return capture.toByteArray();
    }

    public String getCaptureAsString() throws IOException {
        return new String(getCaptureAsBytes(), getCharacterEncoding());
    }

}
