
package com.jslsolucoes.tagria.exporter.v4.impl;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.jslsolucoes.tagria.exception.v4.TagriaRuntimeException;
import com.jslsolucoes.tagria.exporter.v4.parser.model.Column;
import com.jslsolucoes.tagria.exporter.v4.parser.model.Header;
import com.jslsolucoes.tagria.exporter.v4.parser.model.Table;

public class ExcelExporter implements Exporter {

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    private Row createRow(Sheet sheet) {
	return sheet.createRow(atomicInteger.getAndIncrement());
    }

    private void createCell(Row row, String content, String align) {
	Integer cellIndex = row.getLastCellNum() == -1 ? 0 : row.getLastCellNum() + 1;
	CellStyle cellStyle = cellStyle(align, row.getSheet().getWorkbook());
	Cell cell = row.createCell(cellIndex);
	cell.setCellValue(content);
	cell.setCellStyle(cellStyle);
    }

    private CellStyle cellStyle(String align, Workbook workbook) {
	CellStyle cellStyle = workbook.createCellStyle();
	if ("center".equals(align)) {
	    cellStyle.setAlignment(HorizontalAlignment.CENTER);
	} else if ("left".equals(align)) {
	    cellStyle.setAlignment(HorizontalAlignment.LEFT);
	} else if ("right".equals(align)) {
	    cellStyle.setAlignment(HorizontalAlignment.RIGHT);
	}
	return cellStyle;
    }

    @Override
    public byte[] export(ExporterContext exporterContext) {
	Table table = exporterContext.getTable();
	String fileName = exporterContext.getFileName();
	try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()) {
	    try (Workbook workbook = new XSSFWorkbook()) {
		Sheet sheet = workbook.createSheet(fileName);
		Row headerRow = createRow(sheet);
		for (Header header : table.getHeaders()) {
		    createCell(headerRow, header.getContent(), header.getAlign());
		}
		for (com.jslsolucoes.tagria.exporter.v4.parser.model.Row tableRow : table.getRows()) {
		    Row row = createRow(sheet);
		    for (Column colum : tableRow.getColumns()) {
			createCell(row, colum.getContent(), colum.getAlign());
		    }
		}
		workbook.write(byteArrayOutputStream);
		return byteArrayOutputStream.toByteArray();
	    }
	} catch (IOException e) {
	    throw new TagriaRuntimeException(e);
	}
    }

    @Override
    public String contentType(String encoding) {
	return "application/vnd.ms-excel";
    }

    @Override
    public Boolean accepts(String mediaType) {
	return "xlsx".equals(mediaType);
    }
}
