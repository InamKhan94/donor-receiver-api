package com.example.donorreceiverapi.service;


import com.example.donorreceiverapi.dto.DonorReceiverDTO;
import com.example.donorreceiverapi.entity.DonorReceiver;
import com.example.donorreceiverapi.event.DonorReceiverCreationEvent;
import com.example.donorreceiverapi.repository.DonorReceiverRepository;
import com.example.donorreceiverapi.util.ImageUtility;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class DonorReceiverService {

    @Autowired
    private DonorReceiverRepository donorReceiverRepository;
    private ModelMapper modelMapper;

    public DonorReceiverDTO createDonorReceiver(DonorReceiverDTO donorReceiverDTO, MultipartFile prescription){

       // DonorReceiver donorReceiver = modelMapper.map(donorReceiverDTO, DonorReceiver.class);
//        try {
//            if(!prescription.isEmpty()) {
//                donorReceiver.setPrescription(ImageUtility.compressImage(prescription.getBytes()));
//            }
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        DonorReceiver donorReceiver = DonorReceiver.builder()
                                                    .id(donorReceiverDTO.getId())
                                                    .address(donorReceiverDTO.getAddress())
                                                    .personType(donorReceiverDTO.getPersonType())
                                                    .build();
        donorReceiver = donorReceiverRepository.save(donorReceiver);
        donorReceiverDTO.setId(donorReceiver.getId());
        DonorReceiverCreationEvent donorReceiverCreationEvent = DonorReceiverCreationEvent.builder()
                .personId(donorReceiverDTO.getId()).medicineInfo(donorReceiverDTO.getMedicineInfo())
                .(ImageUtility.compressImage(prescription.getBytes()))
                .build();

        return donorReceiverDTO;

    }
}
