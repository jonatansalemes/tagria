
package com.jslsolucoes.tagria.lib.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.jstl.core.Config;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.io.IOUtils;
import org.joda.time.DateTime;
import org.joda.time.Seconds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jslsolucoes.tagria.lib.grid.exporter.impl.CsvExporter;
import com.jslsolucoes.tagria.lib.grid.exporter.impl.ExcelExporter;
import com.jslsolucoes.tagria.lib.grid.exporter.impl.PdfExporter;
import com.jslsolucoes.tagria.lib.grid.exporter.impl.XmlExporter;
import com.jslsolucoes.tagria.lib.grid.exporter.model.Table;
import com.jslsolucoes.tagria.lib.util.TagUtil;

@SuppressWarnings("serial")
@WebServlet(name = "tagria", urlPatterns = "/tagria/*", loadOnStartup = 1)
public class Tagria extends HttpServlet {

	private static final Integer CACHE_EXPIRES_DAY = 365;
	private static Logger logger = LoggerFactory.getLogger(Tagria.class);

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String uri = request.getRequestURI().replaceAll(";jsessionid=.*", "");
		String etag = DigestUtils.sha256Hex(uri);

		if (uri.endsWith("blank")) {
			response.setStatus(HttpServletResponse.SC_OK);
			return;
		}

		if (uri.endsWith("locale")) {
			Config.set(request.getSession(), Config.FMT_LOCALE, Locale.forLanguageTag(request.getParameter("locale")));
			response.setStatus(HttpServletResponse.SC_OK);
			return;
		}

		if (request.getHeader("If-None-Match") != null && etag.equals(request.getHeader("If-None-Match"))) {
			response.setStatus(HttpServletResponse.SC_NOT_MODIFIED);
			return;
		}

		String charset = "utf-8";
		if (TagUtil.getInitParam(TagriaConfigParameter.ENCODING) != null) {
			charset = TagUtil.getInitParam(TagriaConfigParameter.ENCODING);
		}
		response.setCharacterEncoding(charset);
		try {

			DateTime today = new DateTime();
			DateTime expires = new DateTime().plusDays(CACHE_EXPIRES_DAY);

			if (uri.endsWith(".css")) {
				response.setContentType("text/css");
			} else if (uri.endsWith(".js")) {
				response.setContentType("text/javascript");
			} else if (uri.endsWith(".png")) {
				response.setContentType("image/png");
			}

			SimpleDateFormat sdf = new SimpleDateFormat("E, dd MMM yyyy HH:mm:ss 'GMT'", Locale.ENGLISH);

			if (Boolean.valueOf(TagUtil.getInitParam(TagriaConfigParameter.CDN_ENABLED))) {
				response.setHeader(HttpHeaderParameter.ACCESS_CONTROL_ALLOW_ORIGIN.getName(), "*");
			}

			response.setHeader(HttpHeaderParameter.ETAG.getName(), etag);
			response.setHeader(HttpHeaderParameter.EXPIRES.getName(), sdf.format(expires.toDate()));
			response.setHeader(HttpHeaderParameter.CACHE_CONTROL.getName(),
					"public,max-age=" + Seconds.secondsBetween(today, expires).getSeconds());

			String url = "/com/jslsolucoes"
					+ uri.replaceFirst(request.getContextPath(), "").replaceAll(";jsessionid=.*", "");
			InputStream in = getClass().getResourceAsStream(url);
			IOUtils.copy(in, response.getOutputStream());
			in.close();

		} catch (Exception exception) {
			logger.error("Could not load resource", exception);
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			Gson gson = new GsonBuilder().create();
			String json = request.getParameter("json");
			String type = request.getParameter("type");
			Table table = gson.fromJson(json, Table.class);
			response.setHeader("Content-Disposition", "attachment; filename=grid." + type);
			if ("pdf".equals(type)) {
				response.setContentType("application/pdf");
				PdfExporter exporter = new PdfExporter(table);
				exporter.doExport(response.getOutputStream());
			} else if ("csv".equals(type)) {
				response.setContentType("text/csv");
				CsvExporter exporter = new CsvExporter(table);
				exporter.doExport(response.getOutputStream());
			} else if ("xml".equals(type)) {
				response.setContentType("text/xml");
				XmlExporter exporter = new XmlExporter(table);
				exporter.doExport(response.getOutputStream());
			} else if ("xls".equals(type)) {
				response.setContentType("application/vnd.ms-excel");
				ExcelExporter exporter = new ExcelExporter(table);
				exporter.doExport(response.getOutputStream());
			}
		} catch (Exception exception) {
			logger.error("Could not export data", exception);
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		}
	}
}
