package com.dedytech.paiementsservice.web.controller;

import com.dedytech.paiementsservice.dao.PaiementDao;
import com.dedytech.paiementsservice.model.Paiement;
import com.dedytech.paiementsservice.web.exceptions.PaiementExistantException;
import com.dedytech.paiementsservice.web.exceptions.PaiementImpossibleException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaiementController {

    @Autowired
    PaiementDao paiementDao;

    @PostMapping(value = "/paiements")
    public ResponseEntity<Paiement> payerUneCommande(@RequestBody Paiement paiement) {

        Paiement paiementExistant = paiementDao.findByIdCommande(paiement.getIdCommande());

        if (paiementExistant != null) throw new PaiementExistantException("Cette commande est deja paye");

        Paiement nouveauPaiement = paiementDao.save(paiement);

        if (nouveauPaiement == null) throw new PaiementImpossibleException("Erreur, impossible d'etablir le paiement, reessayer plus tard");

        return new ResponseEntity<Paiement>(nouveauPaiement, HttpStatus.CREATED);
    }
}
