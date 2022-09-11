package com.api.MTGAPI.beans;
import com.api.MTGAPI.models.CardModel;
import io.magicthegathering.javasdk.api.CardAPI;

import javax.persistence.Entity;

@Entity
public class Card extends CardModel {

//    public Card() {
//    }
//
//    public Card(int id) {
//        try {
//            io.magicthegathering.javasdk.resource.Card card = CardAPI.getCard(id);
//            this.id = id;
//            this.imgUrl = card.getImageUrl();
//            this.name = card.getName();
//            this.artist = card.getArtist();
//            this.colors = card.getColors();
//            this.power = card.getPower();
//            this.def = card.getToughness();
//            this.description = card.getText();
//            this.type = card.getType();
//            this.manaCost = card.getManaCost();
//            this.rarity = card.getRarity();
//            this.life = card.getLife();
//            this.cmc = card.getCmc();
//            this.set = card.getSet();
//            this.types = card.getTypes();
//            this.setName = card.getSetName();
//            this.pricelow = card.getPriceLow();
//            this.pricehigh = card.getPriceHigh();
//            this.pricemid = card.getPriceMid();
//
//            if (this.colors == null) {
//                this.colors = new String[]{"NON Color Card"};
//            }
//        }
//        catch (Exception e){
//
//        }
//    }


}
