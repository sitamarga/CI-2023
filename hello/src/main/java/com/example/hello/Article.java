package com.example.hello;

import org.springframework.stereotype.Component;

/**
 * @création 17/06/2023
 * @projet hello
 * @auteur tsyta.diallo
 * @package com.example.hello
 */


public class Article {

    private String libelle;
    private String desc;


    public Article(String libelle, String desc) {
        this.libelle = libelle;
        this.desc = desc;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
