
package com.jslsolucoes.tagria.exporter.v4.impl;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.jslsolucoes.tagria.exception.v4.TagriaRuntimeException;
import com.jslsolucoes.tagria.exporter.v4.parser.model.Column;
import com.jslsolucoes.tagria.exporter.v4.parser.model.Header;
import com.jslsolucoes.tagria.exporter.v4.parser.model.Table;

public class ExcelExporter implements Exporter {

    private Row createRow(Sheet sheet, int index) {
	return sheet.createRow(index);
    }

    private void createCell(Row row, String content, String align) {
	short cellIndex = row.getLastCellNum() == -1 ? 0 : row.getLastCellNum();
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

	int rowIndex = 0;
	Table table = exporterContext.getTable();
	String fileName = exporterContext.getFilename();
	try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()) {
	    try (Workbook workbook = new XSSFWorkbook()) {
		Sheet sheet = workbook.createSheet(fileName);
		Row headerRow = createRow(sheet, rowIndex++);
		for (Header header : table.getHeaders()) {
		    createCell(headerRow, header.getContent(), header.getAlign());
		}
		for (com.jslsolucoes.tagria.exporter.v4.parser.model.Row tableRow : table.getRows()) {
		    Row row = createRow(sheet, rowIndex++);
		    for (Column colum : tableRow.getColumns()) {
			createCell(row, colum.getContent(), colum.getAlign());
		    }
		}
		applyAutoSizeAndAutoFilter(sheet, headerRow.getLastCellNum());
		workbook.write(byteArrayOutputStream);
		return byteArrayOutputStream.toByteArray();
	    }
	} catch (IOException e) {
	    throw new TagriaRuntimeException(e);
	}
    }

    private void applyAutoSizeAndAutoFilter(Sheet sheet, short numberOfColumns) {
	for (int i = 0; i < numberOfColumns; i++) {
	    sheet.autoSizeColumn(i);
	    sheet.setColumnWidth(i, sheet.getColumnWidth(i) + 2000);
	}
	sheet.setAutoFilter(new CellRangeAddress(0, 0, 0, numberOfColumns - 1));
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
