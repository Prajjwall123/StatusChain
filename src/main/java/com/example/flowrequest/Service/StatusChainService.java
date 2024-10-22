package com.example.flowrequest.Service;

import com.example.flowrequest.DTO.StatusChainDTO;
import com.example.flowrequest.Entity.StatusChain;

import java.util.List;

public interface StatusChainService {

    List<StatusChain> getAllStatusChains();
    StatusChain saveStatusChain(StatusChainDTO statusChainDTO);
}
