package com.api.MTGAPI.entities;

import io.magicthegathering.javasdk.api.CardAPI;
import io.magicthegathering.javasdk.resource.Card;

import java.util.Arrays;

public class Cards {
    public int id;
    public String img;
    public String name;
    public String artist;
    public String[] color;

    public Cards(int id) {
        Card card = CardAPI.getCard(id);
        this.id = id;
        this.img = card.getImageUrl();
        this.name = card.getName();
        this.artist = card.getArtist();
        this.color = card.getColors();
        System.out.println("\n");
        if(this.color == null){
            String[] nocolor = {"NON Color Card"};
            this.color = nocolor;
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String[] getColor() {
        return color;
    }

    public void setColor(String[] color) {
        this.color = color;
    }
}
