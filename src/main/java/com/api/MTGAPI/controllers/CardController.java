package com.api.MTGAPI.controllers;
import com.api.MTGAPI.models.CardModel;
import com.api.MTGAPI.repositories.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/")
public class CardController {
    @Autowired
    private CardRepository cardRepository;
    public Long id;
//    @GetMapping
//    public ResponseEntity<List<Card>> findAll(){
//        List<Card> list = new ArrayList<>();
//        list.add(new Card(2));
//        list.add(new Card(65));
//        list.add(new Card(95));
//        return ResponseEntity.ok().body(list);
//    }
	@RequestMapping("/")
	public ModelAndView index(){
		return new ModelAndView("index");
	}
    @GetMapping(value = "/{id}")
    public ResponseEntity<CardModel> findById(@PathVariable Integer id){
        CardModel card = new CardModel(Math.toIntExact(id));
        return ResponseEntity.ok().body(card);
    }
    @PostMapping(value = "searchById")
    public ModelAndView idsearch(@RequestParam(value = "id",required = false)Long id){
        ModelAndView view = new ModelAndView("/index");
        CardModel card = new CardModel(Math.toIntExact(id));
        this.id = id;
        view.addObject("cards", card);
        view.addObject("colors", card.getColors());
        return view;
    }
    @PostMapping(value = "save")
    public ModelAndView save(){
        Long id = this.id;
        CardModel card = new CardModel(Math.toIntExact(id));
        cardRepository.save(card);
        return new ModelAndView("/index");
    }
    @PostMapping(value = "list")
    public ModelAndView listar(){
        ArrayList <CardModel> list = (ArrayList<CardModel>) cardRepository.findAll();
        ModelAndView view = new ModelAndView();
        view.addObject("cards", list);
        return view;
    }
    @GetMapping("/delete/{id}")
    public RedirectView delete(@PathVariable("id") Integer id){
        cardRepository.deleteById(id);
        return new RedirectView("/");
    }

}
