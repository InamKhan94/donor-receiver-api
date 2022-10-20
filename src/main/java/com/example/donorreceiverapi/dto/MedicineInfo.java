package com.example.donorreceiverapi.dto;

import com.example.donorreceiverapi.contants.InventoryStatus;
import com.example.donorreceiverapi.contants.ShippingMethod;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MedicineInfo {
    private String medicineName;
    private String medicineFormula;
    private Integer quantity;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date expiryDate;
    private ShippingMethod shippingMethod;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date shippingDate;
    private InventoryStatus inventoryStatus;
}
