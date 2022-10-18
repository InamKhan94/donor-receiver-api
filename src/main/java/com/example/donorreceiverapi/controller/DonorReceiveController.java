package com.example.donorreceiverapi.controller;

import com.example.donorreceiverapi.dto.DonorReceiverDTO;
import com.example.donorreceiverapi.service.DonorReceiverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Access;

@RestController
@RequestMapping("/")
public class DonorReceiveController {

    @Autowired
    private DonorReceiverService donorReceiverService;

    @PostMapping(value = "/", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public DonorReceiverDTO createDonorReceiver(@RequestBody DonorReceiverDTO donorReceiverDTO, @RequestParam("Prescription") MultipartFile prescription) {
        return donorReceiverService.createDonorReceiver(donorReceiverDTO, prescription);
    }
}
