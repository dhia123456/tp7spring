package com.example.tech_titans.Service;

import com.example.tech_titans.Entity.Owner;
import com.example.tech_titans.Repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OwnerService {

    @Autowired
    private OwnerRepository ownerRepository;

    public Owner saveOwner(Owner owner) {
        return ownerRepository.save(owner);
    }

    public Owner getOwnerById(Integer ownerId) {
        return ownerRepository.findById(Long.valueOf(ownerId)).orElse(null);
    }

    public List<Owner> getAllOwners() {
        return ownerRepository.findAll();
    }

    public void deleteOwnerById(Integer ownerId) {
        ownerRepository.deleteById(Long.valueOf(ownerId));
    }

    public Owner updateOwner(Integer ownerId, Owner updatedOwner) {
        Optional<Owner> optionalOwner = ownerRepository.findById(Long.valueOf(ownerId));
        if (optionalOwner.isPresent()) {
            Owner existingOwner = optionalOwner.get();
            existingOwner.setName(updatedOwner.getName());
            existingOwner.setContactInformation(updatedOwner.getContactInformation());
            // You can update other fields as needed
            return ownerRepository.save(existingOwner);
        }
        return null;


    }
}
