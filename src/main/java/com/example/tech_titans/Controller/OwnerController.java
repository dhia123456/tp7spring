package com.example.tech_titans.Controller;

import com.example.tech_titans.Entity.Owner;
import com.example.tech_titans.Service.OwnerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/owners")
@Tag(name = "Owner")
public class OwnerController {

    private final OwnerService ownerService;

    @Autowired
    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }
   @Operation(description = "createOwner")
    @PostMapping
    public ResponseEntity<Owner> createOwner(@RequestBody Owner owner) {
        Owner createdOwner = ownerService.saveOwner(owner);
        return new ResponseEntity<>(createdOwner, HttpStatus.CREATED);
    }
    @Operation(description = "getOwner")

    @GetMapping("/{id}")
    public ResponseEntity<Owner> getOwnerById(@PathVariable("id") Integer ownerId) {
        Owner owner = ownerService.getOwnerById(ownerId);
        if (owner != null) {
            return new ResponseEntity<>(owner, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @Operation(description = "allOwner")

    @GetMapping
    public ResponseEntity<List<Owner>> getAllOwners() {
        List<Owner> owners = ownerService.getAllOwners();
        return new ResponseEntity<>(owners, HttpStatus.OK);
    }
    @Operation(description = "updateOwner")

    @PutMapping("/{id}")
    public ResponseEntity<Owner> updateOwner(@PathVariable("id") Integer ownerId, @RequestBody Owner updatedOwner) {
        Owner owner = ownerService.updateOwner(ownerId, updatedOwner);
        if (owner != null) {
            return new ResponseEntity<>(owner, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @Operation(description = "deleteOwner")

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOwner(@PathVariable("id") Integer ownerId) {
        ownerService.deleteOwnerById(ownerId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
