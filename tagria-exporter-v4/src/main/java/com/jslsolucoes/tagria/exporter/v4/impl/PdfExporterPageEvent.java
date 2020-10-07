package com.jslsolucoes.tagria.exporter.v4.impl;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfWriter;
import com.jslsolucoes.tagria.exception.v4.TagriaRuntimeException;

public class PdfExporterPageEvent extends PdfPageEventHelper {

    private Font font;

    public PdfExporterPageEvent(Font font) {
	this.font = font;
    }

    @Override
    public void onEndPage(PdfWriter pdfWriter, Document document) {
	try {
	    PdfContentByte pdfContentByte = pdfWriter.getDirectContent();
	    ColumnText.showTextAligned(pdfContentByte, Element.ALIGN_CENTER,
		    new Phrase(String.format("%d", pdfWriter.getPageNumber()), font),
		    (document.right() - document.left()) / 2 + document.leftMargin(), document.bottom() - 10, 0);
	} catch (Exception e) {
	    throw new TagriaRuntimeException(e);
	}
    }

}
