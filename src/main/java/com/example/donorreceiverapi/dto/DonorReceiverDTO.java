package com.example.donorreceiverapi.dto;


import com.example.donorreceiverapi.contants.PersonType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DonorReceiverDTO{

    private Long id;
    private String personName;
    private String address;
    private PersonType personType;
    private List<MedicineInfo> medicineInfo;
}
