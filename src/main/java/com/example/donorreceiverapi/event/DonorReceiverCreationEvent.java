package com.example.donorreceiverapi.event;

import com.example.donorreceiverapi.dto.MedicineInfo;
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
public class DonorReceiverCreationEvent {
    private Long personId;
    private List<MedicineInfo> medicineInfo;
    private byte[] prescription;
}
