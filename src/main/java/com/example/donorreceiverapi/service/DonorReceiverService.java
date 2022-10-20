package com.example.donorreceiverapi.service;


import com.example.donorreceiverapi.contants.InventoryStatus;
import com.example.donorreceiverapi.dto.DonorReceiverDTO;
import com.example.donorreceiverapi.entity.DonorReceiver;
import com.example.donorreceiverapi.event.DonorReceiverCreationEvent;
import com.example.donorreceiverapi.repository.DonorReceiverRepository;
import com.example.donorreceiverapi.util.ImageUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class DonorReceiverService {

    @Autowired
    private DonorReceiverRepository donorReceiverRepository;
    @Autowired
    RabbitMQSender rabbitMQSender;
//, MultipartFile prescription
    public DonorReceiverDTO createDonorReceiver(DonorReceiverDTO donorReceiverDTO){

        DonorReceiverCreationEvent donorReceiverCreationEvent = new DonorReceiverCreationEvent();
//        try {
//            if(prescription != null) {
//                 donorReceiverCreationEvent.setPrescription(ImageUtility.compressImage(prescription.getBytes()));
//            }
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        DonorReceiver donorReceiver = DonorReceiver.builder()
                                                    .id(donorReceiverDTO.getId())
                                                    .personName(donorReceiverDTO.getPersonName())
                                                    .address(donorReceiverDTO.getAddress())
                                                    .personType(donorReceiverDTO.getPersonType())
                                                    .email(donorReceiverDTO.getEmail())
                                                    .build();
        donorReceiverDTO.getMedicineInfo().setInventoryStatus(InventoryStatus.PENDING);
        donorReceiver = donorReceiverRepository.save(donorReceiver);
        donorReceiverDTO.setId(donorReceiver.getId());
        donorReceiverCreationEvent = DonorReceiverCreationEvent.builder()
                .personId(donorReceiverDTO.getId()).medicineInfo(donorReceiverDTO.getMedicineInfo())
                .email(donorReceiverDTO.getEmail())
                .build();

        rabbitMQSender.send(donorReceiverCreationEvent);
        return donorReceiverDTO;

    }
}
