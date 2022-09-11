package com.api.MTGAPI.models;

import io.magicthegathering.javasdk.api.CardAPI;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "TB_CARD")
public class CardModel implements Serializable {

    @Id
    protected int id;
    @Column(length = 200)
    protected String[] colors;
    @Column(length = 200)
    protected String[] colorIdentity;
    @Column(length = 200)
    protected String name;
    @Column(length = 200)
    protected String artist;
    @Column(length = 200)
    protected String type;
    @Column(length = 200)
    protected String[] types;
    @Column(length = 200)
    protected String[] subtypes;
    @Column(length = 200)
    protected String imgUrl;
    @Column(length = 200)
    protected String set;
    @Column(length = 200)
    protected String setName;
    @Column(length = 200)
    protected String power;
    @Column(length = 200)
    protected String def;
    @Column(length = 200)
    protected String description;
    @Column(length = 200)
    protected String manaCost;
    @Column(length = 200)
    protected Double cmc;
    @Column(length = 200)
    protected String rarity;
    @Column(length = 200)
    protected int life;
    @Column(length = 200)
    protected BigDecimal pricehigh;
    @Column(length = 200)
    protected BigDecimal pricelow;
    @Column(length = 200)
    protected BigDecimal pricemid;
    public CardModel() {
    }

    public CardModel(int id) {
        try {
            io.magicthegathering.javasdk.resource.Card card = CardAPI.getCard(id);
            this.id = id;
            this.imgUrl = card.getImageUrl();
            this.name = card.getName();
            this.artist = card.getArtist();
            this.colors = card.getColors();
            this.power = card.getPower();
            this.def = card.getToughness();
            this.description = card.getText();
            this.type = card.getType();
            this.manaCost = card.getManaCost();
            this.rarity = card.getRarity();
            this.life = card.getLife();
            this.cmc = card.getCmc();
            this.set = card.getSet();
            this.types = card.getTypes();
            this.setName = card.getSetName();
            this.pricelow = card.getPriceLow();
            this.pricehigh = card.getPriceHigh();
            this.pricemid = card.getPriceMid();

            if (this.colors == null) {
                this.colors = new String[]{"NON Color Card"};
            }
        }
        catch (Exception e){

        }
    }
    public String[] getColorIdentity() {
        return colorIdentity;
    }

    public void setColorIdentity(String[] colorIdentity) {
        this.colorIdentity = colorIdentity;
    }

    public String[] getTypes() {
        return types;
    }

    public void setTypes(String[] types) {
        this.types = types;
    }

    public String[] getSubtypes() {
        return subtypes;
    }

    public void setSubtypes(String[] subtypes) {
        this.subtypes = subtypes;
    }

    public String getSet() {
        return set;
    }

    public void setSet(String set) {
        this.set = set;
    }

    public String getSetName() {
        return setName;
    }

    public void setSetName(String setName) {
        this.setName = setName;
    }

    public Double getCmc() {
        return cmc;
    }

    public void setCmc(Double cmc) {
        this.cmc = cmc;
    }

    public BigDecimal getPricehigh() {
        return pricehigh;
    }

    public void setPricehigh(BigDecimal pricehigh) {
        this.pricehigh = pricehigh;
    }

    public BigDecimal getPricelow() {
        return pricelow;
    }

    public void setPricelow(BigDecimal pricelow) {
        this.pricelow = pricelow;
    }

    public BigDecimal getPricemid() {
        return pricemid;
    }

    public void setPricemid(BigDecimal pricemid) {
        this.pricemid = pricemid;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public String getManaCost() {
        return manaCost;
    }

    public void setManaCost(String manaCost) {
        this.manaCost = manaCost;
    }

    public String getRarity() {
        return rarity;
    }

    public void setRarity(String rarity) {
        this.rarity = rarity;
    }

    public int getId() {
        return id;
    }

    public void setId() {
        this.id = id;
    }


    public String[] getColors() {
        return colors;
    }

    public void setColors(String[] colors) {
        this.colors = colors;
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

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public String getDef() {
        return def;
    }

    public void setDef(String def) {
        this.def = def;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setType(String type) {
        this.type = type;
    }
}
