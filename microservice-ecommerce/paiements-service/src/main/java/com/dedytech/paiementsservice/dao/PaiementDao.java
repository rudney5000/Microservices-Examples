package com.dedytech.paiementsservice.dao;

import com.dedytech.paiementsservice.model.Paiement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaiementDao extends JpaRepository<Paiement, Integer> {

    Paiement findByIdCommande(int idCommande);
}
