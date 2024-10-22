package com.example.flowrequest.Controller;

import com.example.flowrequest.DTO.StatusChainDTO;
import com.example.flowrequest.Entity.StatusChain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.flowrequest.Service.StatusChainService;
import java.util.List;

@RestController
@RequestMapping("/statuschains")
public class StatusChainController {
    @Autowired
    private StatusChainService statusChainService;

    @GetMapping("/getAll")
    public List<StatusChain> getAllStatusChains(){return statusChainService.getAllStatusChains();}

    @PostMapping("/save")
    public StatusChain saveStatusChain(@RequestBody StatusChainDTO statusChainDTO){return statusChainService.saveStatusChain(statusChainDTO);}
}
