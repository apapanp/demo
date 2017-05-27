package com.criminalcase.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by apapan on 5/26/2017 AD.
 */
@Entity
public class TradeRecordCardAmtFrq implements Serializable
{   private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(name = "id")
    private long id;
    @Column(name = "card_number")
    private String card_number;
    @Column(name = "money_amount")
    private float money_amount;
    @Column(name = "frequency")
    private int frequency;



    public int getFrequency() {

        return frequency;
    }



    public float getMoney_amount() {

        return money_amount;
    }

    public String getCard_number() {
        return card_number;
    }



    public TradeRecordCardAmtFrq(String card_number, float money_amount, int frequency) {
        this.card_number = card_number;
        this.money_amount = money_amount;

        this.frequency = frequency;
    }

    public TradeRecordCardAmtFrq() {
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

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;

    }
}
