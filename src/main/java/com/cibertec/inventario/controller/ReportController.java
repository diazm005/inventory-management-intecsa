package com.cibertec.inventario.controller;

import com.cibertec.inventario.reports.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;

@Controller
@RequestMapping("/reports")
@RequiredArgsConstructor
public class ReportController {

    private final ReportService reportService;

    @GetMapping("/herramientas/excel")
    public ResponseEntity<byte[]> exportarHerramientasExcel() throws IOException {
        byte[] data = reportService.exportarHerramientasExcel();
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=herramientas.xlsx")
                .contentType(MediaType.parseMediaType(
                        "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"))
                .body(data);
    }

    @GetMapping("/movimientos/excel")
    public ResponseEntity<byte[]> exportarMovimientosExcel() throws IOException {
        byte[] data = reportService.exportarMovimientosExcel();
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=movimientos.xlsx")
                .contentType(MediaType.parseMediaType(
                        "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"))
                .body(data);
    }

    @GetMapping("/herramientas/pdf")
    public ResponseEntity<byte[]> exportarHerramientasPdf() throws IOException {
        byte[] data = reportService.exportarHerramientasPdf();
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=herramientas.pdf")
                .contentType(MediaType.APPLICATION_PDF)
                .body(data);
    }
}