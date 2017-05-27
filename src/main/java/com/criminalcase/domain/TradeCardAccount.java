package com.criminalcase.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by apapan on 5/24/2017 AD.
 */
@Entity
public class TradeCardAccount implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;

    private float money_amount;

    private String card_number;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private int card_id;

    private String date_time;



    public float getMoney_amount() {
        return money_amount;
    }

    public String getCard_number() {
        return card_number;
    }

    public TradeCardAccount(){}

    public TradeCardAccount(float money_amount, String card_number, int card_id, String date_time) {
        this.money_amount = money_amount;
        this.card_number = card_number;
        this.card_id = card_id;
        this.date_time = date_time;
    }



    public void setMoney_amount(float money_amount) {
        this.money_amount = money_amount;
    }

    public void setCard_number(String card_number) {
        this.card_number = card_number;
    }

    public void setCard_id(int card_id) {
        this.card_id = card_id;
    }

    public void setDate_time(String date_time) {
        this.date_time = date_time;
    }

    public int getCard_id() {
        return card_id;
    }

    public String getDate_time() {
        return date_time;
    }
}
