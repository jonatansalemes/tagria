package com.jslsolucoes.tagria.lib.v4.servlet;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

import com.google.common.collect.Lists;
import com.jslsolucoes.tagria.config.v4.ConfigurationParser;
import com.jslsolucoes.tagria.exception.v4.TagriaRuntimeException;
import com.jslsolucoes.tagria.exporter.v4.impl.CsvExporter;
import com.jslsolucoes.tagria.exporter.v4.impl.ExcelExporter;
import com.jslsolucoes.tagria.exporter.v4.impl.Exporter;
import com.jslsolucoes.tagria.exporter.v4.impl.ExporterContext;
import com.jslsolucoes.tagria.exporter.v4.impl.PdfExporter;
import com.jslsolucoes.tagria.exporter.v4.impl.XmlExporter;
import com.jslsolucoes.tagria.exporter.v4.parser.TableParser;
import com.jslsolucoes.tagria.exporter.v4.parser.model.Header;
import com.jslsolucoes.tagria.exporter.v4.parser.model.Row;
import com.jslsolucoes.tagria.exporter.v4.parser.model.Table;

@SuppressWarnings("serial")
@WebServlet(name = "tagria-servlet-exporter-v4", urlPatterns = "/tagria-exporter/v4", loadOnStartup = 1)
public class TagriaServletExporter extends HttpServlet {

    private static Logger logger = LoggerFactory.getLogger(TagriaServletExporter.class);
    private List<Exporter> exporters = Lists.newArrayList();

    @Override
    public void init(ServletConfig config) throws ServletException {
	logger.debug("Tagria exporter is up ...");
	exporters = exporters();
    }

    private List<Exporter> exporters() {
	return Stream.of(customExporters(), defaultExporters()).flatMap(List::stream).collect(Collectors.toList());
    }

    private List<Exporter> defaultExporters() {
	return Arrays.asList(new CsvExporter(), new ExcelExporter(), new PdfExporter(), new XmlExporter());
    }

    private List<Exporter> customExporters() {
	List<Exporter> exporters = new ArrayList<>();
	List<com.jslsolucoes.tagria.config.v4.xml.Exporter> customExporters = ConfigurationParser.newParser().parse()
		.getExporters();
	if (!CollectionUtils.isEmpty(customExporters)) {
	    for (com.jslsolucoes.tagria.config.v4.xml.Exporter customExporter : customExporters) {
		try {
		    exporters.add((Exporter) Class.forName(customExporter.getClazz()).newInstance());
		} catch (Exception e) {
		    throw new TagriaRuntimeException(e);
		}
	    }
	} else {
	    logger.debug("Customs formatters not found on xml...");
	}
	return exporters;
    }

    @Override
    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
	    throws ServletException, IOException {
	ServletOutputStream servletOutputStream = httpServletResponse.getOutputStream();

	try {
	    String encoding = ConfigurationParser.newParser().parse().getEncoding();
	    httpServletRequest.setCharacterEncoding(encoding);
	    String json = httpServletRequest.getParameter("json");
	    String type = httpServletRequest.getParameter("type");
	    Boolean timestamp = Boolean.valueOf(httpServletRequest.getParameter("timestamp"));
	    String pattern = httpServletRequest.getParameter("pattern");
	    String filename = normalize(httpServletRequest.getParameter("filename")
		    + (timestamp ? "_" + LocalDateTime.now().format(DateTimeFormatter.ofPattern(pattern)) : ""));

	    logger.debug("exporting: json {},type {}", json, type);
	    Table table = TableParser.newParser().withJson(json).parse();
	    logger.debug("table: {}", table);

	    Optional<String> error = checkPreconditions(table);
	    if (error.isPresent()) {
		httpServletResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		servletOutputStream.print("{ \"error\": \"" + error.get() + "\"], \"debug\" : " + json + " }");
	    } else {
		httpServletResponse.setStatus(HttpServletResponse.SC_OK);
		httpServletResponse.setHeader("Content-Disposition", "attachment; filename=" + filename + "." + type);
		for (Exporter exporter : exporters) {
		    if (exporter.accepts(type)) {
			byte[] bytes = exporter.export(new ExporterContext(table, filename, encoding));
			httpServletResponse.setContentType(exporter.contentType(encoding));
			httpServletResponse.setContentLength(bytes.length);
			servletOutputStream.write(bytes);
		    }
		}
	    }
	} catch (Exception exception) {
	    logger.error("Could not export data", exception);
	    httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
	    servletOutputStream.print("{ \"error\": \"exception\"], \"debug\" : " + exception.getMessage() + " }");
	}
	servletOutputStream.flush();
	logger.debug("Successfully exported");
    }

    private Optional<String> checkPreconditions(Table table) {

	List<Header> headers = table.getHeaders();
	List<Row> rows = table.getRows();

	if (CollectionUtils.isEmpty(headers)) {
	    return Optional.of("At least one column header and data must be set as exportable");
	}
	
	if (CollectionUtils.isEmpty(rows)) logger.warn("Exported table has no rows..");

	if (!CollectionUtils.isEmpty(rows)
		&& rows.stream().anyMatch(row -> row.getColumns().size() != headers.size())) {
	    return Optional.of("Number of columns and headers must match");
	}

	return Optional.empty();
    }

    private String normalize(String fileName) {
	return StringUtils.stripAccents(fileName).replaceAll("( |\\/|:|!|\\.)", "_").toLowerCase();
    }

}
