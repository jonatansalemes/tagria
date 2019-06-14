package com.jslsolucoes.tagria.library.servlet;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jslsolucoes.tagria.exporter.impl.CsvExporter;
import com.jslsolucoes.tagria.exporter.impl.ExcelExporter;
import com.jslsolucoes.tagria.exporter.impl.Exporter;
import com.jslsolucoes.tagria.exporter.impl.PdfExporter;
import com.jslsolucoes.tagria.exporter.impl.XmlExporter;

@SuppressWarnings("serial")
@WebServlet(name = "tagria-exporter", urlPatterns = "/tagria-exporter", loadOnStartup = 1)
public class TagriaExporter extends HttpServlet {

	private static Logger logger = LoggerFactory.getLogger(TagriaExporter.class);
	private static List<Exporter> exporters = Arrays.asList(new CsvExporter(), new ExcelExporter(), new PdfExporter(), new XmlExporter());

	@Override
	protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
			throws ServletException, IOException {
		OutputStream outputStream = httpServletResponse.getOutputStream();
		try {
			String json = httpServletRequest.getParameter("json");
			String type = httpServletRequest.getParameter("type");
			httpServletResponse.setHeader("Content-Disposition", "attachment; filename=data." + type);
			for (Exporter exporter : exporters) {
				if (exporter.accepts(type)) {
					httpServletResponse.setContentType(exporter.contentType());
					outputStream.write(exporter.export(json));
					outputStream.flush();
				}
			}
		} catch (Exception exception) {
			logger.error("Could not export data", exception);
			httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		}
	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		logger.debug("Tagria exporter is up ...");
	}
}
