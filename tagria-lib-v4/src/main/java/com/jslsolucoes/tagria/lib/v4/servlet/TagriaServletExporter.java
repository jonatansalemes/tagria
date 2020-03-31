package com.jslsolucoes.tagria.lib.v4.servlet;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jslsolucoes.tagria.config.v4.ConfigurationParser;
import com.jslsolucoes.tagria.exporter.v4.impl.CsvExporter;
import com.jslsolucoes.tagria.exporter.v4.impl.ExcelExporter;
import com.jslsolucoes.tagria.exporter.v4.impl.Exporter;
import com.jslsolucoes.tagria.exporter.v4.impl.ExporterContext;
import com.jslsolucoes.tagria.exporter.v4.impl.PdfExporter;
import com.jslsolucoes.tagria.exporter.v4.impl.XmlExporter;
import com.jslsolucoes.tagria.exporter.v4.parser.TableParser;
import com.jslsolucoes.tagria.exporter.v4.parser.model.Table;

@SuppressWarnings("serial")
@WebServlet(name = "tagria-servlet-exporter-v4", urlPatterns = "/tagria-exporter/v4", loadOnStartup = 1)
public class TagriaServletExporter extends HttpServlet {

    private static Logger logger = LoggerFactory.getLogger(TagriaServletExporter.class);
    private static List<Exporter> exporters = Arrays.asList(new CsvExporter(), new ExcelExporter(), new PdfExporter(),
	    new XmlExporter());

    @Override
    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
	    throws ServletException, IOException {
	String encoding = ConfigurationParser.newParser().parse().getEncoding();
	httpServletRequest.setCharacterEncoding(encoding);
	ServletOutputStream servletOutputStream = httpServletResponse.getOutputStream();
	try {
	    String json = httpServletRequest.getParameter("json");
	    String type = httpServletRequest.getParameter("type");
	    String fileName = normalize(httpServletRequest.getParameter("fileName"));
	    logger.debug("exporting: json {},type {}", json, type);
	    Table table = TableParser.newParser().withJson(json).parse();
	    if (!CollectionUtils.isEmpty(table.getHeaders()) && !CollectionUtils.isEmpty(table.getRows())
		    && table.getRows().get(0).getColumns().size() == table.getHeaders().size()) {

		httpServletResponse.setStatus(HttpServletResponse.SC_OK);
		httpServletResponse.setHeader("Content-Disposition", "attachment; filename=" + fileName + "." + type);
		for (Exporter exporter : exporters) {
		    if (exporter.accepts(type)) {
			byte[] bytes = exporter.export(new ExporterContext(table, fileName, encoding));
			httpServletResponse.setContentType(exporter.contentType());
			httpServletResponse.setContentLength(bytes.length);
			servletOutputStream.write(bytes);
			servletOutputStream.flush();
		    }
		}
	    } else {
		httpServletResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		servletOutputStream.print(
			"{ \"errors\": [\"At least one column header and data must be set as exportable\",\"Number of columns and headers must match\"], \"debug\" : "
				+ json + " }");
	    }
	} catch (Exception exception) {
	    logger.error("Could not export data", exception);
	    httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
	}
    }

    private String normalize(String fileName) {
	return StringUtils.stripAccents(fileName).replaceAll(" ","_");
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
	logger.debug("Tagria exporter is up ...");
    }
}
