package com.example.donorreceiverapi.repository;

import com.example.donorreceiverapi.entity.DonorReceiver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DonorReceiverRepository extends JpaRepository<DonorReceiver, Long> {
}
