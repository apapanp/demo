package com.criminalcase.domain;

/**
 * Created by apapan on 5/19/2017 AD.
 */
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by apapan on 5/19/2017 AD.
 */
@Entity
@Table (name = "t_trade_record")
public class TradeRecord implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name ="case_id")
    private int case_id;
    @Column(name = "from_card_id")
    private int from_card_id;
    @Column(name ="to_card_id")
    private int to_card_id;
    @Column(name="money_amount")
    private float money_amount;
    @Column(name = "date_time")
    private String date_time;
    @Column(name = "money_type")
    private String money_type;
    @Column(name = "bank_address")
    private String bank_address;
    @Column(name = "ip")
    private String ip;
    @Column (name = "abstract")
    private String abstracts;

    public TradeRecord(int case_id, int from_card_id, int to_card_id, float money_amount, String date_time, String money_type, String bank_address, String ip, String abstracts) {
        this.case_id = case_id;
        this.from_card_id = from_card_id;
        this.to_card_id = to_card_id;
        this.money_amount = money_amount;
        this.date_time = date_time;
        this.money_type = money_type;
        this.bank_address = bank_address;
        this.ip = ip;
        this.abstracts = abstracts;
    }

    protected TradeRecord(){

    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getId() {
        return id;
    }

    public int getCase_id() {
        return case_id;
    }

    public int getFrom_card_id() {
        return from_card_id;
    }

    public int getTo_card_id() {
        return to_card_id;
    }

    public float getMoney_amount() {
        return money_amount;
    }

    public String getDate_time() {
        return date_time;
    }

    public String getMoney_type() {
        return money_type;
    }

    public String getBank_address() {
        return bank_address;
    }

    public String getIp() {
        return ip;
    }

    public String getAbstracts() {
        return abstracts;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCase_id(int case_id) {
        this.case_id = case_id;
    }

    public void setFrom_card_id(int from_card_id) {
        this.from_card_id = from_card_id;
    }

    public void setTo_card_id(int to_card_id) {
        this.to_card_id = to_card_id;
    }

    public void setMoney_amount(float money_amount) {
        this.money_amount = money_amount;
    }

    public void setDate_time(String date_time) {
        this.date_time = date_time;
    }

    public void setMoney_type(String money_type) {
        this.money_type = money_type;
    }

    public void setBank_address(String bank_address) {
        this.bank_address = bank_address;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public void setAbstracts(String abstracts) {
        this.abstracts = abstracts;
    }
}
