package com.example.tech_titans.Repository;

import com.example.tech_titans.Entity.RentalContract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentalContractRepository extends JpaRepository<RentalContract,Long> {

}
