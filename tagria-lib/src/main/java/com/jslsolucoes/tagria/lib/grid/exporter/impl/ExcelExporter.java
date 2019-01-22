
package com.jslsolucoes.tagria.lib.grid.exporter.impl;

import java.io.IOException;
import java.io.OutputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import com.jslsolucoes.tagria.lib.grid.exporter.model.Column;
import com.jslsolucoes.tagria.lib.grid.exporter.model.Header;
import com.jslsolucoes.tagria.lib.grid.exporter.model.Table;

public class ExcelExporter {
	private Table table;

	public ExcelExporter(Table table) {
		this.table = table;

	}

	public void doExport(OutputStream out) throws IOException {
		Workbook workbook = new HSSFWorkbook();
		Sheet sheet = workbook.createSheet("data");
		header(sheet, workbook);
		body(sheet, workbook);
		workbook.write(out);
	}

	private void header(Sheet sheet, Workbook workbook) {
		Row sheetRow = sheet.createRow(0);
		int cell = 0;
		for (Header header : table.getHeaders()) {
			Cell sheetCel = sheetRow.createCell(cell);
			sheetCel.setCellValue(header.getContent());

			CellStyle cellStyle = workbook.createCellStyle();
			if ("center".equals(header.getAlign()))
				cellStyle.setAlignment(CellStyle.ALIGN_CENTER);
			else if ("left".equals(header.getAlign()))
				cellStyle.setAlignment(CellStyle.ALIGN_LEFT);
			else if ("right".equals(header.getAlign()))
				cellStyle.setAlignment(CellStyle.ALIGN_RIGHT);
			sheetCel.setCellStyle(cellStyle);

			cell++;
		}

	}

	private void body(Sheet sheet, Workbook workbook) {
		int line = 1;
		for (com.jslsolucoes.tagria.lib.grid.exporter.model.Row row : table.getRows()) {
			Row sheetRow = sheet.createRow(line);
			int cell = 0;
			for (Column column : row.getColumns()) {
				Cell sheetCel = sheetRow.createCell(cell);
				sheetCel.setCellValue(column.getContent());

				CellStyle cellStyle = workbook.createCellStyle();
				if ("center".equals(column.getAlign()))
					cellStyle.setAlignment(CellStyle.ALIGN_CENTER);
				else if ("left".equals(column.getAlign()))
					cellStyle.setAlignment(CellStyle.ALIGN_LEFT);
				else if ("right".equals(column.getAlign()))
					cellStyle.setAlignment(CellStyle.ALIGN_RIGHT);
				sheetCel.setCellStyle(cellStyle);
				cell++;
			}
			line++;
		}

	}
}
