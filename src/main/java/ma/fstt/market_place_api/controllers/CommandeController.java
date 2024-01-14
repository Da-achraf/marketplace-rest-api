package ma.fstt.market_place_api.controllers;

import ma.fstt.market_place_api.entites.Commande;
import ma.fstt.market_place_api.entites.dto.SaveCommandeDto;
import ma.fstt.market_place_api.services.CommandeService;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/commandes")
public class CommandeController {


    private final CommandeService commandeService;

    public CommandeController(CommandeService commandeService) {
        this.commandeService = commandeService;
    }


    @GetMapping
    public List<Commande> findAllCommandes(){
        return commandeService.findAllCommandes();
    }



    @GetMapping("{id}")
    public Commande findCommandeById(@PathVariable("id") Long id){
        return commandeService.findCommandeById(id);
    }

    @PostAuthorize("hasAuthority('ROLE_CLIENT')")
    @PostMapping
    public void saveCommande(@RequestBody SaveCommandeDto saveCommandeDto){
        commandeService.saveCommande(saveCommandeDto);
    }


    @PostAuthorize("hasAuthority('ROLE_CLIENT')")
    @DeleteMapping("{id}")
    public void deleteCommandeById(@PathVariable("id") Long id){
        commandeService.deleteCommandeById(id);
    }

}
