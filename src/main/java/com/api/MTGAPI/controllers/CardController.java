package com.api.MTGAPI.controllers;

import com.api.MTGAPI.entities.Cards;
import com.api.MTGAPI.services.CardService;
import io.magicthegathering.javasdk.api.CardAPI;
import io.magicthegathering.javasdk.resource.Card;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/cards")
public class CardController {

    @GetMapping
    public ResponseEntity<List<Cards>> findAll(){
        List<Cards> list = new ArrayList<>();
        list.add(new Cards(2));
        list.add(new Cards(653));
        list.add(new Cards(953));
        return ResponseEntity.ok().body(list);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<Cards> findById(@PathVariable Long id){
        Cards card = new Cards(Math.toIntExact(id));
        return ResponseEntity.ok().body(card);
    }

}
