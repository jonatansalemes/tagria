package com.jslsolucoes.tagria.exporter.v4.impl;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import com.jslsolucoes.tagria.exporter.v4.parser.TableParser;
import com.jslsolucoes.tagria.exporter.v4.parser.model.Table;

public class PdfExporterTest {

    @Test
    public void export() throws FileNotFoundException, IOException {
	String json = "{\"id\":\"myGridId\",\"title\":\"My grid\",\"headers\":[{\"align\":\"left\",\"content\":\"Developed by JSL Soluções LTDA\"},{\"align\":\"center\",\"content\":\"Ãáôões\"}],\"rows\":[{\"columns\":[{\"align\":\"right\",\"content\":\"MzfyVVGpWQ\"},{\"align\":\"center\",\"content\":\"Não\"}]},{\"columns\":[{\"align\":\"right\",\"content\":\"ashrmdStxn\"},{\"align\":\"center\",\"content\":\"Sim\"}]},{\"columns\":[{\"align\":\"right\",\"content\":\"vaRbRhcRSn\"},{\"align\":\"center\",\"content\":\"Não\"}]}]}";
	Table table = TableParser.newParser().withJson(json).parse();
	ExporterContext exporterContext = new ExporterContext(table, "aaa", "utf-8");
	PdfExporter pdfExporter = new PdfExporter();
	byte[] pdf1 = pdfExporter.export(exporterContext);
	pdfExporter.export(exporterContext);
	pdfExporter.export(exporterContext);
	byte[] pdf2 = pdfExporter.export(exporterContext);
	Assert.assertEquals(pdf1.length, pdf2.length);
    }

}
