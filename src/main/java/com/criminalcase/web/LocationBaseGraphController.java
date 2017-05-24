package com.criminalcase.web;

import com.criminalcase.domain.TradeCardAccount;
import com.criminalcase.domain.TradeRecordCardFrq;
import com.criminalcase.service.TradeRecordCardFrqRepository;
import com.criminalcase.service.TradeRecordRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * Created by apapan on 5/24/2017 AD.
 */
@RestController
@RequestMapping("/locationbd/")
public class LocationBaseGraphController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private TradeRecordCardFrqRepository tradeRecordCardFrqRepository;

    @RequestMapping(value = "/out", method = RequestMethod.GET)
    public ResponseEntity<Collection<TradeRecordCardFrq>> findByFromCardID(@RequestParam Map<String, String> params, HttpServletResponse resp) {
        resp.setHeader("Access-Control-Allow-Origin", "*");
        Map<String, String> resultmap = new HashMap<>();
        resultmap = params;
        List<String> cardidList = Arrays.asList(resultmap.get("cardid").split(","));
        String json = "jsonResponse";
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<>(tradeRecordCardFrqRepository.findFrqByFromCard_number(cardidList, resultmap.get("startdate"), resultmap.get("enddate")), HttpStatus.OK);

    }


}
