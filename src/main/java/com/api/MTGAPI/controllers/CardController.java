package com.api.MTGAPI.controllers;
import com.api.MTGAPI.beans.Card;
import com.api.MTGAPI.models.CardModel;
import com.api.MTGAPI.repositories.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/")
public class CardController {
    @Autowired
    private CardRepository cardRepository;
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
        view.addObject("cards", card);
        view.addObject("colors", card.getColors());
        cardRepository.save(card);
        return view;
    }
    @PostMapping(value = "salvar")
    @ResponseBody
    public ResponseEntity<CardModel> salvar(@RequestBody CardModel card){
        CardModel c = cardRepository.save(card);
        return new ResponseEntity<CardModel>(c, HttpStatus.CREATED);
    }

}
