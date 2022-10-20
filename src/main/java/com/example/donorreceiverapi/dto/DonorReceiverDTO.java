package com.example.donorreceiverapi.dto;


import com.example.donorreceiverapi.contants.PersonType;
import com.example.donorreceiverapi.contants.ShippingMethod;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DonorReceiverDTO implements Serializable {

    private Long id;
    private String personName;
    private String address;
    private PersonType personType;
    private String email;
    private MedicineInfo medicineInfo;

    public String getMedicineName() {
        return medicineInfo.getMedicineName();
    }

    public void setMedicineName(String medicineName) {
        medicineInfo.setMedicineName(medicineName);
    }

    public String getMedicineFormula() {
        return medicineInfo.getMedicineFormula();
    }

    public void setMedicineFormula(String medicineFormula) {
        medicineInfo.setMedicineFormula(medicineFormula);
    }

    public Integer getQuantity() {
        return medicineInfo.getQuantity();
    }

    public void setQuantity(Integer quantity) {
        medicineInfo.setQuantity(quantity);
    }

    public Date getExpiryDate() {
        return medicineInfo.getExpiryDate();
    }

    public void setExpiryDate(Date expiryDate) {
        medicineInfo.setExpiryDate(expiryDate);
    }

    public ShippingMethod getShippingMethod() {
        return medicineInfo.getShippingMethod();
    }

    public void setShippingMethod(ShippingMethod shippingMethod) {
        medicineInfo.setShippingMethod(shippingMethod);
    }

    public Date getShippingDate() {
        return medicineInfo.getShippingDate();
    }

    public void setShippingDate(Date shippingDate) {
        medicineInfo.setShippingDate(shippingDate);
    }
}
