package com.example.donorreceiverapi.entity;

import com.example.donorreceiverapi.contants.PersonType;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "donor_receiver")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class DonorReceiver {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    private String personName;
    private String address;
    private PersonType personType;
    @OneToMany(mappedBy="donorReceiver", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Inventory> inventoryList;
}
