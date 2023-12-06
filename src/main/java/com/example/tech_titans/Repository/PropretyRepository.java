package com.example.tech_titans.Repository;

import com.example.tech_titans.Entity.Proprety;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropretyRepository extends JpaRepository<Proprety,Long> {
}
