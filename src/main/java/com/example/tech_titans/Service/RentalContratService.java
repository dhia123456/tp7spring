package com.example.tech_titans.Service;

import com.example.tech_titans.Entity.RentalContract;
import com.example.tech_titans.Repository.RentalContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RentalContratService {
    private final RentalContractRepository rentalContractRepository;

    @Autowired
    public RentalContratService(RentalContractRepository rentalContractRepository) {
        this.rentalContractRepository = rentalContractRepository;
    }

    public RentalContract saveRentalContract(RentalContract rentalContract) {
        return rentalContractRepository.save(rentalContract);
    }

    public RentalContract getRentalContractById(Integer rentalContractId) {
        Optional<RentalContract> rentalContract = rentalContractRepository.findById(Long.valueOf(rentalContractId));
        return rentalContract.orElse(null);
    }

    public List<RentalContract> getAllRentalContracts() {
        return rentalContractRepository.findAll();
    }

    public void deleteRentalContractById(Integer rentalContractId) {
        rentalContractRepository.deleteById(Long.valueOf(rentalContractId));
    }

    public RentalContract updateRentalContract(Integer rentalContractId, RentalContract updatedRentalContract) {
        Optional<RentalContract> optionalRentalContract = rentalContractRepository.findById(Long.valueOf(rentalContractId));
        if (optionalRentalContract.isPresent()) {
            RentalContract existingRentalContract = optionalRentalContract.get();
            existingRentalContract.setTenant(updatedRentalContract.getTenant());
            existingRentalContract.setMonthlyRent(updatedRentalContract.getMonthlyRent());
            // Update other fields as needed
            return rentalContractRepository.save(existingRentalContract);
        }
        return null;
    }
}
