package com.criminalcase.domain;


import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by apapan on 5/27/2017 AD.
 */
@Entity
public class TransactionClassification implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String card_number;
    private float money_amount;
    @Column(nullable=true)
    private Integer role_id;
    private String classification;
    private String date_time;

    public TransactionClassification(String card_number, float money_amount, int role_id, String classification, String date_time) {
        this.card_number = card_number;
        this.money_amount = money_amount;
        this.role_id = role_id;
        this.classification = classification;
        this.date_time = date_time;
    }

    public TransactionClassification() {
    }

    public Long getId() {

        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCard_number() {
        return card_number;
    }

    public void setCard_number(String card_number) {
        this.card_number = card_number;
    }

    public float getMoney_amount() {
        return money_amount;
    }

    public void setMoney_amount(float money_amount) {
        this.money_amount = money_amount;
    }

    public Integer getRole_id() {
        return role_id;
    }

    public void setRole_id(Integer role_id) {
        this.role_id = role_id;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public String getDate_time() {
        return date_time;
    }

    public void setDate_time(String date_time) {
        this.date_time = date_time;
    }
}
