package com.dedytech.commandesservice.dao;

import com.dedytech.commandesservice.model.Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommandeDao extends JpaRepository<Commande, Integer> {
}
