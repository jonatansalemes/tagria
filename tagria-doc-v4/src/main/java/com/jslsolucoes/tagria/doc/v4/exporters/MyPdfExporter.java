package com.jslsolucoes.tagria.doc.v4.exporters;

import java.io.ByteArrayOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.jslsolucoes.tagria.exception.v4.TagriaRuntimeException;
import com.jslsolucoes.tagria.exporter.v4.impl.Exporter;
import com.jslsolucoes.tagria.exporter.v4.impl.ExporterContext;
import com.jslsolucoes.tagria.exporter.v4.parser.model.Table;

public class MyPdfExporter implements Exporter {

    @Override
    public String contentType(String encoding) {
	return "application/pdf";
    }

    @Override
    public Boolean accepts(String mediaType) {
	return "pdf".equals(mediaType);
    }

    @Override
    public byte[] export(ExporterContext exporterContext) {
	Table table = exporterContext.getTable();
	try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()) {
	    Document document = new Document();
	    PdfWriter pdfWriter = PdfWriter.getInstance(document, byteArrayOutputStream);
	    document.open();
	    document.add(pdfTable(table));
	    document.close();
	    pdfWriter.close();
	    return byteArrayOutputStream.toByteArray();
	} catch (Exception e) {
	    throw new TagriaRuntimeException(e);
	}
    }

    private PdfPTable pdfTable(Table table) {
	Integer numColumns = table.getHeaders().size();
	PdfPTable pdfPTable = new PdfPTable(numColumns);
	pdfPTable.setWidthPercentage(100);
	pdfPTable.addCell(createCell("Titulo customizado", "center", numColumns));
	return pdfPTable;
    }

    private PdfPCell createCell(String content, String align, Integer colspan) {
	Font font = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);
	PdfPCell pdfPCell = new PdfPCell(new Phrase(content, font));
	pdfPCell.setHorizontalAlignment(Element.ALIGN_CENTER);
	if (colspan != null) {
	    pdfPCell.setColspan(colspan);
	}
	return pdfPCell;
    }

}
