package com.api.MTGAPI;

import com.api.MTGAPI.controllers.CardController;
import io.magicthegathering.javasdk.api.CardAPI;
import io.magicthegathering.javasdk.resource.Card;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
public class MtgApiApplication {

	public static void main(String[] args) {SpringApplication.run(MtgApiApplication.class, args);}


	public Object index(){
		return new CardController().findAll();
	}

}
