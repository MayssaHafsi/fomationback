package com.projet.formationCertification.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.projet.formationCertification.entities.Devis;

public interface DevisRepository extends JpaRepository<Devis, Long> {
	
	@Query("SELECT u FROM Devis u WHERE u.id = :status")
	Devis find(@Param("status") Long id);
}
