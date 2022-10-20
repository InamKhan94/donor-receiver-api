package com.example.donorreceiverapi.entity;

import com.example.donorreceiverapi.contants.InventoryStatus;
import com.example.donorreceiverapi.contants.ShippingMethod;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "inventory")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    private String medicineName;
    private String medicineFormula;
    private Integer quantity;
    private Date expiryDate;
    private ShippingMethod shippingMethod;
    private Date shippingDate;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="donor_receiver_id", nullable=false)
    private DonorReceiver donorReceiver;
    @Column(name = "image", unique = false)
    private byte[] prescription;
    private InventoryStatus status;
}
