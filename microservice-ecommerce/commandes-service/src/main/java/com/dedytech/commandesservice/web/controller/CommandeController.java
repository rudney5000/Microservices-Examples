package com.dedytech.commandesservice.web.controller;

import com.dedytech.commandesservice.dao.CommandeDao;
import com.dedytech.commandesservice.model.Commande;
import com.dedytech.commandesservice.web.exceptions.CommandeNotFoundException;
import com.dedytech.commandesservice.web.exceptions.ImpossibleAjouterCommandeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class CommandeController {

    @Autowired
    CommandeDao commandeDao;

    @PostMapping(value = "/commandes")
    public ResponseEntity<Commande> ajouterCommande(@RequestBody Commande commande) {
        Commande nouvelleCommande = commandeDao.save(commande);

        if (nouvelleCommande == null) throw  new ImpossibleAjouterCommandeException("Impossible d'ajouter cette commande");

        return new ResponseEntity<Commande>(commande, HttpStatus.CREATED);
    }

    @GetMapping(value = "/commandes/{id}")
    public Optional<Commande> recupererUneCommande(@PathVariable int id) {
        Optional<Commande> commande = commandeDao.findById(id);

        if (!commande.isPresent()) throw new CommandeNotFoundException("Cette commande n'existe pas");

        return commande;
    }
}
