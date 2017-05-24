package com.criminalcase.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by apapan on 5/24/2017 AD.
 */
@Entity
@Table (name = "t_card")
public class TradeCard implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "card_number")
    private String card_number;

    @Column(nullable=true,name = "card_owner_name")
    private String card_owner_name;

    @Column(nullable=true,name = "person_id")
    private Integer person_id;

    @Column(nullable=true,name = "case_id")
    private int case_id;

    @Column(nullable=true,name = "init_bank")
    private  String init_bank;

    @Column(nullable=true,name = "is_invested")
    private  int is_invested;

    public int getId() {
        return id;
    }

    public String getCard_number() {
        return card_number;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCard_number(String card_number) {
        this.card_number = card_number;
    }

    public void setCard_owner_name(String card_owner_name) {
        this.card_owner_name = card_owner_name;
    }



    public void setCase_id(int case_id) {
        this.case_id = case_id;
    }

    public void setInit_bank(String init_bank) {
        this.init_bank = init_bank;
    }

    public void setIs_invested(int is_invested) {
        this.is_invested = is_invested;
    }

    public String getCard_owner_name() {
        return card_owner_name;
    }


    public void setPerson_id(Integer person_id) {
        this.person_id = person_id;
    }

    public Integer getPerson_id() {
        return person_id;

    }

    public int getCase_id() {
        return case_id;
    }

    public String getInit_bank() {
        return init_bank;
    }

    public int getIs_invested() {
        return is_invested;
    }
}
