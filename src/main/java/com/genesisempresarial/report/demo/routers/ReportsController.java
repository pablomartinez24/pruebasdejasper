/*package com.genesisempresarial.report.demo.routers;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.ArrayList;

import java.util.List;

import java.util.Map;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;

import net.sf.jasperreports.engine.JRBeanCollectionDataSource;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ReportsController {

    @GetMapping("/generate-pdf")
    public ResponseEntity<InputStreamResource> generateReport() throws IOException, JRException {

        List<String> nombreClientes = new ArrayList<>();
        nombreClientes.add("Walfred Daniel Donis Montenegro");
        nombreClientes.add("ARmando Jose Marin Lorenzana");
        nombreClientes.add("Yarol Abraham Deleon Perez");


        Map<String, Object> parameters = new HashMap<>();
        parameters.put("SUCURSAL_RAIZ", "Valor del campo sucursalRaiz");
        parameters.put("FechaDesembolso", "24/05/2023");
        parameters.put("Numerocompdomrep", "1");
        parameters.put("Coordinador", "Jose Fernando Amaya");
        parameters.put("CodCoordinador", "001");
        parameters.put("Promotor", "Pelsar doniss");
        parameters.put("CodPromotor", "001");
        parameters.put("NombredelGrupo", "Grupo Genesis");
        parameters.put("IdGrupo", "001");
        parameters.put("IdPgrupal", "001");
        parameters.put("Nbanco", "BANRURAL");
        parameters.put("Plazo", "2 meses");
        parameters.put("MontoT", "Q200.00");
        parameters.put("NombreCliente", nombreClientes);
        //JasperPrint jasperPrint = JasperFillManager.fillReport("C:\\Users\\Usuario\\Documents\\proyectos\\fge-app\\java\\fge\\demo\\src\\main\\java\\com\\genesisempresarial\\report\\demo\\jasper\\Reporte.jasper", parameters, new JREmptyDataSource());
        JasperReport jasperReport = JasperCompileManager.compileReport("C:\\Users\\demol\\JaspersoftWorkspace\\MyReports\\ReporteJ.jrxml");
       
        //JasperReport jasperReport = JasperCompileManager.compileReport("C:\\Users\\demol\\OneDrive\\Escritorio\\SpringBoot para informes\\fge-springboot-service\\src\\main\\java\\com\\java\\com\\genesisempresarial\\report\\demo\\jrxml\\Reporte.jrxml");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, new JREmptyDataSource());
        
        byte[] reportBytes = JasperExportManager.exportReportToPdf(jasperPrint);

        InputStreamResource resource = new InputStreamResource(new ByteArrayInputStream(reportBytes));

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=reporte.pdf")
                .contentType(MediaType.APPLICATION_PDF)
                .body(resource);

                
    }
}
*/

package com.genesisempresarial.report.demo.routers;

import java.io.ByteArrayInputStream;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

@RestController
@RequestMapping("/p")
public class ReportsController {

    Map<String, Object> parameters = new HashMap<>();

    private void CargarEncabezado() {
        parameters.put("SUCURSAL_RAIZ", "GENESIS EMPRESARIAL CENTRAL");
        parameters.put("FechaDesembolso", "24/05/2023");
        parameters.put("Numerocompdomrep", "1");
        parameters.put("Coordinador", "Jose Fernando Amaya");
        parameters.put("CodCoordinador", "001");
        parameters.put("Promotor", "Pelsar doniss");
        parameters.put("CodPromotor", "001");
        parameters.put("NombredelGrupo", "Grupo Genesis");
        parameters.put("IdGrupo", "001");
        parameters.put("IdPgrupal", "001");
        parameters.put("Nbanco", "BANRURAL");
        parameters.put("Plazo", "2 meses");
        parameters.put("MontoT", "Q200.00");
    }


    





    @GetMapping("/informaciongrupal")
    public ResponseEntity<InputStreamResource> generateReport() throws IOException, JRException {

        CargarEncabezado();
        // lista de datos para tabla
        List<String> listaClientes = new ArrayList<>();
        float n = 0;
        for (int y = 0; y <= 27; y++) {
            listaClientes.add("Cliente No" + y + ". ");
            n = y;
        }
        float cdi = (float) n / 15;
        int cdient = (int) Math.ceil(cdi);

        int i = 1;
        int limite = 16;
        System.out.println("cantidad de informes a generar es: " + cdient);

        // for (String item : listaClientes) {
        for (int q = 0; i < Math.min(limite, listaClientes.size()); i++) {
            String item = listaClientes.get(i);
            System.out.println("data es " + item + i);
            parameters.put("NombreCliente" + i, item);
        }

        int j = i;

        if (j <= 15) {
            for (i = i; i < 16; i++) {
                System.out.println(i);
                parameters.put("NombreCliente" + i, " ");
            }
        }

        int B = 4;
        int C = 0;

        while (B > C) {
            C++;
        

                ptinter();
                   
                    
        }

        JasperReport jasperReport = JasperCompileManager
                .compileReport("C:\\Users\\demol\\JaspersoftWorkspace\\MyReports\\ReporteJ.jrxml");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, new JREmptyDataSource());
        byte[] reportBytes = JasperExportManager.exportReportToPdf(jasperPrint);
        InputStreamResource resource = new InputStreamResource(new ByteArrayInputStream(reportBytes));

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=reporte.pdf")
                .contentType(MediaType.APPLICATION_PDF)
                .body(resource);

    }


    public ResponseEntity<InputStreamResource> ptinter() throws IOException, JRException {

        JasperReport jasperReport = JasperCompileManager
                .compileReport("C:\\Users\\demol\\JaspersoftWorkspace\\MyReports\\ReporteJ.jrxml");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, new JREmptyDataSource());
        byte[] reportBytes = JasperExportManager.exportReportToPdf(jasperPrint);
        InputStreamResource resource = new InputStreamResource(new ByteArrayInputStream(reportBytes));

       ResponseEntity<InputStreamResource> response = ResponseEntity.ok()
        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=reporte.pdf")
        .contentType(MediaType.APPLICATION_PDF)
        .body(resource);
    return response;

    }





    @GetMapping("/clausulasambientales")
    public ResponseEntity<InputStreamResource> generateReportclausulas() throws IOException, JRException {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("NombreCliente", "Tomas Agusto Aguas del Rio");

        JasperReport jasperReport = JasperCompileManager
                .compileReport("C:\\Users\\demol\\JaspersoftWorkspace\\MyReports\\BoletaR.jrxml");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, new JREmptyDataSource());

        byte[] reportBytes = JasperExportManager.exportReportToPdf(jasperPrint);

        InputStreamResource resource = new InputStreamResource(new ByteArrayInputStream(reportBytes));

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=reporte.pdf")
                .contentType(MediaType.APPLICATION_PDF)
                .body(resource);
    }

    @GetMapping("/boletadepago")
    public ResponseEntity<InputStreamResource> generateReportboletadepago() throws IOException, JRException {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("NombredelGrupo", "Grupo los tres");
        parameters.put("IdPagoGrupal", "001");
        parameters.put("MontoGrupal", "Q200.00");
        parameters.put("Presidente", "Alan Torres");
        parameters.put("Secretario", "Beto Sierra");
        parameters.put("NombreTesorera", "Sara Medrano");
        parameters.put("NombrePromotor", "Angel Reyes");
        parameters.put("NumerodeExigibilidad", "3");

        parameters.put("No", "1");
        parameters.put("Nombre", "GENESIS EMPRESARIAL");
        parameters.put("IDprestamo", "1234");
        parameters.put("MontoExigible", "Q200.00");
        parameters.put("MontoRealPagado", "Q200.00");
        parameters.put("TotalMontoExigible", "Q200.00");

        JasperReport jasperReport = JasperCompileManager.compileReport(
                "C:\\Users\\demol\\JaspersoftWorkspace\\MyReports\\Diseño de Boleta de Pago Grupal.jrxml");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, new JREmptyDataSource());

        byte[] reportBytes = JasperExportManager.exportReportToPdf(jasperPrint);

        InputStreamResource resource = new InputStreamResource(new ByteArrayInputStream(reportBytes));

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=reporte.pdf")
                .contentType(MediaType.APPLICATION_PDF)
                .body(resource);
    }

}
