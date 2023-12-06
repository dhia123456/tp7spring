package com.example.tech_titans.Controller;

import com.example.tech_titans.Entity.Proprety;
import com.example.tech_titans.Service.PropretyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/properties")
public class PropretyController {
    private final PropretyService propertyService;

    public PropretyController(PropretyService propertyService) {
        this.propertyService = propertyService;
    }
    @PostMapping
    public ResponseEntity<Proprety> createProperty(@RequestBody Proprety property) {
        Proprety createdProperty = propertyService.saveProperty(property);
        return new ResponseEntity<>(createdProperty, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Proprety> getPropertyById(@PathVariable("id") Integer propertyId) {
        Proprety property = propertyService.getPropertyById(propertyId);
        if (property != null) {
            return new ResponseEntity<>(property, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<Proprety>> getAllProperties() {
        List<Proprety> properties = propertyService.getAllProperties();
        return new ResponseEntity<>(properties, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Proprety> updateProperty(@PathVariable("id") Integer propertyId, @RequestBody Proprety updatedProperty) {
        Proprety property = propertyService.updateProperty(propertyId, updatedProperty);
        if (property != null) {
            return new ResponseEntity<>(property, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProperty(@PathVariable("id") Integer propertyId) {
        propertyService.deletePropertyById(propertyId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
