
package com.jslsolucoes.tagria.exporter.impl;

import java.io.ByteArrayOutputStream;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.Row;

import com.jslsolucoes.tagria.exporter.parser.TableParser;
import com.jslsolucoes.tagria.exporter.parser.model.Column;
import com.jslsolucoes.tagria.exporter.parser.model.Header;
import com.jslsolucoes.tagria.exporter.parser.model.Table;

public class ExcelExporter implements Exporter {

	private AtomicInteger atomicInteger = new AtomicInteger(0);

	private Row createRow(Sheet sheet) {
		return sheet.createRow(atomicInteger.getAndIncrement());
	}

	private void createCell(Row row, String content, String align) {
		CellStyle cellStyle = cellStyle(align, row.getSheet().getWorkbook());
		Cell cell = row.createCell(row.getLastCellNum());
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
	public byte[] export(String json) {
		Table table = TableParser.newParser().withJson(json).parse();
		try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()) {
			try (Workbook workbook = new HSSFWorkbook()) {
				Sheet sheet = workbook.createSheet("data");
				Row headerRow = createRow(sheet);
				for (Header header : table.getHeaders()) {
					createCell(headerRow, header.getContent(), header.getAlign());
				}
				for (com.jslsolucoes.tagria.exporter.parser.model.Row tableRow : table.getRows()) {
					Row row = createRow(sheet);
					for (Column colum : tableRow.getColumns()) {
						createCell(row, colum.getContent(), colum.getAlign());
					}
				}
				workbook.write(byteArrayOutputStream);
				return byteArrayOutputStream.toByteArray();
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public String contentType() {
		return "application/vnd.ms-excel";
	}

	@Override
	public Boolean accepts(String mediaType) {
		return "xls".equals(mediaType);
	}
}
