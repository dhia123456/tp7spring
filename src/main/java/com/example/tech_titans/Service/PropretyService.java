package com.example.tech_titans.Service;

import com.example.tech_titans.Entity.Proprety;
import com.example.tech_titans.Repository.PropretyRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PropretyService {
    private final PropretyRepository propertyRepository;

    public PropretyService(PropretyRepository propertyRepository) {
        this.propertyRepository = propertyRepository;
    }
    public Proprety saveProperty(Proprety property) {
        return propertyRepository.save(property);
    }

    public Proprety getPropertyById(Integer propertyId) {
        Optional<Proprety> property = propertyRepository.findById(Long.valueOf(propertyId));
        return property.orElse(null);
    }

    public List<Proprety> getAllProperties() {
        return propertyRepository.findAll();
    }

    public void deletePropertyById(Integer propertyId) {
        propertyRepository.deleteById(Long.valueOf(propertyId));
    }

    public Proprety updateProperty(Integer propertyId, Proprety updatedProperty) {
        Optional<Proprety> optionalProperty = propertyRepository.findById(Long.valueOf(propertyId));
        if (optionalProperty.isPresent()) {
            Proprety existingProperty = optionalProperty.get();
            existingProperty.setAddress(updatedProperty.getAddress());
            existingProperty.setPrice(updatedProperty.getPrice());
            // You can update other fields as needed
            return propertyRepository.save(existingProperty);
        }
        return null;
    }
}
