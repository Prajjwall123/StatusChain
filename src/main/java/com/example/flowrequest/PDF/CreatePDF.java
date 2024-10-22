package com.example.flowrequest.PDF;

import com.example.flowrequest.DTO.StatusChainDTO;
import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.borders.SolidBorder;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.element.Div;
import com.itextpdf.layout.properties.BorderRadius;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class CreatePDF {

    public static void createStatusChainPdf(List<StatusChainDTO> statusChainList) throws Exception {
        PdfWriter writer = new PdfWriter("D://generated_pdfs/filename.pdf");

        PdfDocument pdfDoc = new PdfDocument(writer);
        Document document = new Document(pdfDoc);

        document.add(new Paragraph("Approval Status Chain"));

        float[] columnWidths = {200, 200, 200};

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        Table layoutTable = new Table(columnWidths);
        int cellCounter = 0;
        for (StatusChainDTO statusChain : statusChainList) {
            Table statusTable = new Table(new float[]{200});
            statusTable.setBorder(null);
            Cell cell = new Cell();
            Paragraph statusParagraph = new Paragraph(statusChain.getStatus());
            cell.setRotationAngle(120);
            Div statusDiv = new Div();
            statusDiv.add(statusParagraph);
            statusDiv.setBorderRadius(new BorderRadius(11));
            statusDiv.setMarginLeft(20);
//            statusDiv.setMarginTop(10);
            SolidBorder border = new SolidBorder(ColorConstants.GREEN, 2);
            statusDiv.setBorder(border);
            statusDiv.setPadding(5);
            cell.add(statusDiv);
            statusTable.addCell(cell);

            statusTable.addCell(new Cell().add(new Paragraph(statusChain.getUsername())));

            statusTable.addCell(new Cell().add(new Paragraph(statusChain.getBranch())));

            statusTable.addCell(new Cell().add(new Paragraph(statusChain.getDateTime().format(formatter))));

            layoutTable.addCell(new Cell().add(statusTable).setBorder(null));
            cellCounter++;

            if (cellCounter % 3 == 0) {
                layoutTable.startNewRow();
            }
        }

        while (cellCounter % 3 != 0) {
            layoutTable.addCell(new Cell().add(new Paragraph("")).setBorder(null));
            cellCounter++;
        }

        document.add(layoutTable);

        document.close();
        System.out.println("PDF Created\nD://generated_pdfs/filename.pdf");
    }
}
