package com.example.flowrequest.PDF;
import com.example.flowrequest.DTO.StatusChainDTO;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


class CreatePDFTest {
    private static List<StatusChainDTO> chainListMaker(){
        StatusChainDTO status1 = new StatusChainDTO();
        status1.setId(1);
        status1.setApplicationId(1001);
        status1.setStatus("Submitted");
        status1.setUsername("JohnDoe");
        status1.setBranch("New York");
        status1.setDateTime(LocalDateTime.of(2024, 10, 21, 10, 0));

        StatusChainDTO status2 = new StatusChainDTO();
        status2.setId(2);
        status2.setApplicationId(1001);
        status2.setStatus("Reviewed");
        status2.setUsername("JaneSmith");
        status2.setBranch("Chicago");
        status2.setDateTime(LocalDateTime.of(2024, 10, 21, 12, 30));

        StatusChainDTO status3 = new StatusChainDTO();
        status3.setId(3);
        status3.setApplicationId(1001);
        status3.setStatus("Approved");
        status3.setUsername("AliceJohnson");
        status3.setBranch("Los Angeles");
        status3.setDateTime(LocalDateTime.of(2024, 10, 21, 15, 45));

        StatusChainDTO status4 = new StatusChainDTO();
        status4.setId(4);
        status4.setApplicationId(1001);
        status4.setStatus("Noted");
        status4.setUsername("New User");
        status4.setBranch("Gatthaghar");
        status4.setDateTime(LocalDateTime.of(2024, 10, 21, 15, 45));

        List<StatusChainDTO> statusChainList = new ArrayList<>();
        statusChainList.add(status1);
        statusChainList.add(status2);
        statusChainList.add(status3);
        statusChainList.add(status4);
        return statusChainList;
    }

    public static void main(String[] args) throws Exception {
        CreatePDF createPDF= new CreatePDF();
        CreatePDF.createStatusChainPdf(chainListMaker());
    }
}