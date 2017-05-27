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
public class TradeRecordCardFrq implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String bank_address;

    private int frequency;

    private String card_number;

    private int case_id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getFrequency() {
        return frequency;
    }

    public String getBank_address() {
        return bank_address;
    }

    public TradeRecordCardFrq() {
    }

    public TradeRecordCardFrq(int frequency, String bank_address, String card_number, int case_id) {
        this.frequency = frequency;
        this.bank_address = bank_address;
        this.card_number = card_number;
        this.case_id = case_id;
    }


    public String getCard_number() {
        return card_number;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public void setBank_address(String bank_address) {
        this.bank_address = bank_address;
    }

    public void setCard_number(String card_number) {
        this.card_number = card_number;
    }

    public void setCase_id(int case_id) {
        this.case_id = case_id;
    }

    public int getCase_id() {
        return case_id;

    }
}
