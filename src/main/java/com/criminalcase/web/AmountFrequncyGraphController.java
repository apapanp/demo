package com.criminalcase.web;

import com.criminalcase.domain.TradeRecordCardAmtFrq;
import com.criminalcase.service.TradeRecordCardAmtFrqRepository;
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

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by apapan on 5/26/2017 AD.
 */

@RestController
@RequestMapping("/discoverFrqTxn/")
public class AmountFrequncyGraphController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("/")
    public String index() {
        logger.debug("This is a debug message");
        logger.info("This is a info message");
        logger.warn("This is a warn message");
        logger.error("This is a error message");
        return "Greetings from Spring Boot!";
    }

    @Autowired
    private TradeRecordCardAmtFrqRepository tradeRecordCardAmtFrqRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @RequestMapping(value = "/out", method = RequestMethod.GET)
    public ResponseEntity<Collection<TradeRecordCardAmtFrq>> findFrqAmtByFromCardID(@RequestParam Map<String, String> params, HttpServletResponse resp) {
        resp.setHeader("Access-Control-Allow-Origin", "*");
        Map<String, String> resultmap = new HashMap<>();
        resultmap = params;
        List<String> cardidList = Arrays.asList(resultmap.get("cardid").split(","));
        String json = "jsonResponse";
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<>(tradeRecordCardAmtFrqRepository.findByCard_numberAndFrequencyFrom(cardidList, resultmap.get("startdate"), resultmap.get("enddate")), HttpStatus.OK);

    }

    @RequestMapping(value = "/in", method = RequestMethod.GET)
    public ResponseEntity<Collection<TradeRecordCardAmtFrq>> findFrqAmtByToCardID(@RequestParam Map<String, String> params, HttpServletResponse resp) {
        resp.setHeader("Access-Control-Allow-Origin", "*");
        Map<String, String> resultmap = new HashMap<>();
        resultmap = params;
        List<String> cardidList = Arrays.asList(resultmap.get("cardid").split(","));
        String json = "jsonResponse";
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<>(tradeRecordCardAmtFrqRepository.findByCard_numberAndFrequencyTo(cardidList, resultmap.get("startdate"), resultmap.get("enddate")), HttpStatus.OK);
    }



    @RequestMapping(value = "/parameters" , method= RequestMethod.GET )
    public Map<String,String> test2(@RequestParam Map<String,String> params){
        Map<String,String> resultmap = new HashMap<>();
        resultmap = params;
        List<String> cardidList= Arrays.asList(resultmap.get("cardid").split(","));
        for (int i =0 ; i <cardidList.size();i++){
            System.out.println(cardidList.get(i));
        }
        return resultmap;
    }
}
