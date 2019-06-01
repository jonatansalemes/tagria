package com.jslsolucoes.tagria.exporter.servlet;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.List;

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

	private List<Exporter> exporters() {
		return Arrays.asList(new CsvExporter(), new ExcelExporter(), new PdfExporter(), new XmlExporter());
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		OutputStream outputStream = response.getOutputStream();
		try {
			String json = request.getParameter("json");
			String type = request.getParameter("type");
			response.setHeader("Content-Disposition", "attachment; filename=data." + type);
			for (Exporter exporter : exporters()) {
				if (exporter.accepts(type)) {
					response.setContentType(exporter.contentType());
					outputStream.write(exporter.export(json));
					outputStream.flush();
				}
			}
		} catch (Exception exception) {
			logger.error("Could not export data", exception);
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		}
	}
}
