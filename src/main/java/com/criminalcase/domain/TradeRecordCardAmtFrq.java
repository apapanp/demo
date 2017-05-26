package com.criminalcase.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by apapan on 5/26/2017 AD.
 */
@Entity
public class TradeRecordCardAmtFrq implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)


    private String card_number;

    private int frequency;

    private float money_amount;



    private int card_id;


    public int getFrequency() {
        return frequency;
    }

    public float getMoney_amount() {
        return money_amount;
    }

    public String getCard_number() {
        return card_number;
    }

    public TradeRecordCardAmtFrq(float money_amount, String card_number, int card_id) {
        this.money_amount = money_amount;
        this.card_number = card_number;
        this.card_id = card_id;
    }

    public TradeRecordCardAmtFrq() {
    }

    public int getCard_id() {


        return card_id;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
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
}
