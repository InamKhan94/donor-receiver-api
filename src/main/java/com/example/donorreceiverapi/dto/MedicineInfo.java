package com.example.donorreceiverapi.dto;

import com.example.donorreceiverapi.contants.ShippingMethod;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MedicineInfo {
    private String medicineName;
    private String medicineFormula;
    private Integer quantity;
    private Date expiryDate;
    private ShippingMethod shippingMethod;
    private Date shippingDate;
}
