package com.example.tech_titans.Controller;

import com.example.tech_titans.Entity.RentalContract;
import com.example.tech_titans.Service.RentalContratService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rental-contracts")
@Tag(name = "Rental")
public class RentalContractController {

    private final RentalContratService rentalContractService;

    @Autowired
    public RentalContractController(RentalContratService rentalContractService) {
        this.rentalContractService = rentalContractService;
    }
    @Operation(description = "createRental")
    @PostMapping
    public ResponseEntity<RentalContract> createRentalContract(@RequestBody RentalContract rentalContract) {
        RentalContract createdRentalContract = rentalContractService.saveRentalContract(rentalContract);
        return new ResponseEntity<>(createdRentalContract, HttpStatus.CREATED);
    }
    @Operation(description = "getRental")
    @GetMapping("/{id}")
    public ResponseEntity<RentalContract> getRentalContractById(@PathVariable("id") Integer rentalContractId) {
        RentalContract rentalContract = rentalContractService.getRentalContractById(rentalContractId);
        if (rentalContract != null) {
            return new ResponseEntity<>(rentalContract, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @Operation(description = "allRental")
    @GetMapping
    public ResponseEntity<List<RentalContract>> getAllRentalContracts() {
        List<RentalContract> rentalContracts = rentalContractService.getAllRentalContracts();
        return new ResponseEntity<>(rentalContracts, HttpStatus.OK);
    }
    @Operation(description = "updateRental")
    @PutMapping("/{id}")
    public ResponseEntity<RentalContract> updateRentalContract(@PathVariable("id") Integer rentalContractId, @RequestBody RentalContract updatedRentalContract) {
        RentalContract rentalContract = rentalContractService.updateRentalContract(rentalContractId, updatedRentalContract);
        if (rentalContract != null) {
            return new ResponseEntity<>(rentalContract, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @Operation(description = "deleteRental")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRentalContract(@PathVariable("id") Integer rentalContractId) {
        rentalContractService.deleteRentalContractById(rentalContractId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
