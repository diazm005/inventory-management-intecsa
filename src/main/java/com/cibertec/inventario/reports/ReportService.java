package com.cibertec.inventario.reports;

import com.cibertec.inventario.model.Herramienta;
import com.cibertec.inventario.model.Movimiento;
import com.cibertec.inventario.service.HerramientaService;
import com.cibertec.inventario.service.MovimientoService;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import lombok.RequiredArgsConstructor;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import java.io.*;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReportService {

    private final HerramientaService herramientaService;
    private final MovimientoService movimientoService;

    //EXCEL HERRAMIENTAS
    public byte[] exportarHerramientasExcel() throws IOException {
        List<Herramienta> lista = herramientaService.listarTodas();
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Herramientas");

        //ENCABEZADO
        Row header = sheet.createRow(0);
        CellStyle style = workbook.createCellStyle();
        Font font = workbook.createFont();
        font.setBold(true);
        style.setFont(font);

        String[] cols = {"ID", "Código", "Nombre", "Categoría",
                         "Stock Actual", "Stock Mínimo", "Estado", "Ubicación"};
        for (int i = 0; i < cols.length; i++) {
            Cell cell = header.createCell(i);
            cell.setCellValue(cols[i]);
            cell.setCellStyle(style);
        }
        //DATOS
        int rowNum = 1;
        for (Herramienta h : lista) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(h.getId());
            row.createCell(1).setCellValue(h.getCodigo());
            row.createCell(2).setCellValue(h.getNombre());
            row.createCell(3).setCellValue(h.getCategoria());
            row.createCell(4).setCellValue(h.getStockActual());
            row.createCell(5).setCellValue(h.getStockMinimo());
            row.createCell(6).setCellValue(h.getEstado());
            row.createCell(7).setCellValue(h.getUbicacion());
        }

        for (int i = 0; i < cols.length; i++) sheet.autoSizeColumn(i);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        workbook.write(out);
        workbook.close();
        return out.toByteArray();
    }

    //EXCEL MOVIMIENTOS
    public byte[] exportarMovimientosExcel() throws IOException {
        List<Movimiento> lista = movimientoService.listarTodos();
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Movimientos");

        Row header = sheet.createRow(0);
        CellStyle style = workbook.createCellStyle();
        Font font = workbook.createFont();
        font.setBold(true);
        style.setFont(font);

        String[] cols = {"ID", "Herramienta", "Usuario", "Tipo",
                         "Cantidad", "Motivo", "Fecha"};
        for (int i = 0; i < cols.length; i++) {
            Cell cell = header.createCell(i);
            cell.setCellValue(cols[i]);
            cell.setCellStyle(style);
        }

        int rowNum = 1;
        for (Movimiento m : lista) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(m.getId());
            row.createCell(1).setCellValue(m.getHerramienta().getNombre());
            row.createCell(2).setCellValue(m.getUsuario().getNombre());
            row.createCell(3).setCellValue(m.getTipo());
            row.createCell(4).setCellValue(m.getCantidad());
            row.createCell(5).setCellValue(m.getMotivo());
            row.createCell(6).setCellValue(m.getFecha().toString());
        }

        for (int i = 0; i < cols.length; i++) sheet.autoSizeColumn(i);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        workbook.write(out);
        workbook.close();
        return out.toByteArray();
    }

    //PDF HERRAMIENTAS
    public byte[] exportarHerramientasPdf() throws IOException {
        List<Herramienta> lista = herramientaService.listarTodas();
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        try {
            Document document = new Document(PageSize.A4.rotate());
            PdfWriter.getInstance(document, out);
            document.open();

            //TITULO
            com.itextpdf.text.Font titleFont = new com.itextpdf.text.Font(
                    com.itextpdf.text.Font.FontFamily.HELVETICA, 16, 
                    com.itextpdf.text.Font.BOLD);
            Paragraph title = new Paragraph("Reporte de Inventario", titleFont);
            title.setAlignment(Element.ALIGN_CENTER);
            document.add(title);
            document.add(Chunk.NEWLINE);

            //TABLA
            PdfPTable table = new PdfPTable(7);
            table.setWidthPercentage(100);

            String[] headers = {"Código", "Nombre", "Categoría",
                                 "Stock Actual", "Stock Mínimo", "Estado", "Ubicación"};
            for (String h : headers) {
                PdfPCell cell = new PdfPCell(new Phrase(h,
                        new com.itextpdf.text.Font(
                                com.itextpdf.text.Font.FontFamily.HELVETICA,
                                10, com.itextpdf.text.Font.BOLD,
                                BaseColor.WHITE)));
                cell.setBackgroundColor(new BaseColor(41, 128, 185));
                cell.setPadding(5);
                table.addCell(cell);
            }

            for (Herramienta h : lista) {
                table.addCell(h.getCodigo());
                table.addCell(h.getNombre());
                table.addCell(h.getCategoria());
                table.addCell(String.valueOf(h.getStockActual()));
                table.addCell(String.valueOf(h.getStockMinimo()));
                table.addCell(h.getEstado());
                table.addCell(h.getUbicacion() != null ? h.getUbicacion() : "-");
            }

            document.add(table);
            document.close();

        } catch (DocumentException e) {
            throw new IOException("Error generando PDF", e);
        }

        return out.toByteArray();
    }
}