package com.api.MTGAPI.controllers;
import com.api.MTGAPI.models.CardModel;
import com.api.MTGAPI.repositories.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/")
public class CardController {
    @Autowired
    private CardRepository cardRepository;
    public Long id;

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
    public ModelAndView list(){
        ArrayList <CardModel> list = (ArrayList<CardModel>) cardRepository.findAll();
        ModelAndView view = new ModelAndView();
        view.setViewName("/list");
        view.addObject("cards", list);
        return view;
    }
    @GetMapping("delete")
    public ModelAndView delete(@RequestParam("id") Long id){
        cardRepository.deleteById(Math.toIntExact(id));
        return list();
    }

}
