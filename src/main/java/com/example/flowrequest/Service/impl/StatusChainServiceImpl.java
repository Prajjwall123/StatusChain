package com.example.flowrequest.Service.impl;

import com.example.flowrequest.DTO.StatusChainDTO;
import com.example.flowrequest.Entity.StatusChain;
import com.example.flowrequest.Repository.StatusChainRepository;
import com.example.flowrequest.Service.StatusChainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatusChainServiceImpl implements StatusChainService {
    @Autowired
    private StatusChainRepository statusChainRepository;

    @Override
    public StatusChain saveStatusChain(StatusChainDTO statusChainDto){

        StatusChain statusChain = new StatusChain();
        statusChain.setStatus(statusChainDto.getStatus());
        statusChain.setUsername(statusChainDto.getUsername());
        statusChain.setBranch(statusChainDto.getBranch());
        statusChain.setDateTime(statusChainDto.getDateTime());
        return statusChainRepository.save(statusChain);
    }

    @Override
    public List<StatusChain> getAllStatusChains(){
        return statusChainRepository.findAll();
    }
}
