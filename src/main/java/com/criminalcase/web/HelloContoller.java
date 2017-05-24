package com.criminalcase.web;

import com.criminalcase.domain.TradeRecord;
import com.criminalcase.service.TradeRecordRepository;
import com.criminalcase.service.TradeRecordService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by apapan on 5/19/2017 AD.
 */
@RestController
@RequestMapping("/test/")
public class HelloContoller {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    @Autowired
    private TradeRecordService tradeRecordService;
    @Autowired
    private TradeRecordRepository tradeRecordRepository;

    @RequestMapping("/")
    public String index(){
        logger.debug("This is a debug message");
        logger.info("This is a info message");
        logger.warn("This is a warn message");
        logger.error("This is a error message");
        return "Greetings from Spring Boot!";
    }



    @RequestMapping(method=RequestMethod.GET,params = {"cardid"})
    public ResponseEntity<Collection<TradeRecord>> findTradeRecordByFrom_card_idIswhat(@RequestParam(value ="cardid") List<Integer> cardid){
        return new ResponseEntity<>(tradeRecordRepository.findTradeRecordByTo_card_idContains(cardid), HttpStatus.OK);
    }

    /*@RequestMapping(value = "/to" , method=RequestMethod.GET  )
    public ResponseEntity<Collection<TradeRecord>> findByAllTo(@RequestParam Map<String,String> params,HttpServletResponse resp){
        resp.setHeader("Access-Control-Allow-Origin", "*");
        Map<String,String> resultmap = new HashMap<>();
        resultmap = params;
        String json = "jsonResponse";
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setContentType(MediaType.APPLICATION_JSON);
            return new ResponseEntity<>(tradeRecordRepository.findTradeRecordByTo_card_idIs(Integer.parseInt(resultmap.get("cardid")),resultmap.get("startdate"),resultmap.get("enddate")), HttpStatus.OK);
    }*/

   /* @RequestMapping(value = "/from" , method=RequestMethod.GET  )
    public ResponseEntity<Collection<TradeRecord>> findByAllFrom(@RequestParam Map<String,String> params,HttpServletResponse resp){
        resp.setHeader("Access-Control-Allow-Origin", "*");
        Map<String,String> resultmap = new HashMap<>();
        resultmap = params;
        String json = "jsonResponse";
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<>(tradeRecordRepository.findTradeRecordByFrom_card_idIs(Integer.parseInt(resultmap.get("cardid")),resultmap.get("startdate"),resultmap.get("enddate")), HttpStatus.OK);
    }*/

    @RequestMapping(value = "/in" , method = RequestMethod.GET)
    public ResponseEntity<Collection<TradeRecord>> findByAllTo(@RequestParam Map<String,String> params, HttpServletResponse resp){
        resp.setHeader("Access-Control-Allow-Origin", "*");
        Map<String,String> resultmap = new HashMap<>();
        resultmap = params;
        List<Integer> cardidList= Arrays.asList(resultmap.get("cardid").split(",")).stream().map(s -> Integer.parseInt(s.trim())).collect(Collectors.toList());
        String json = "jsonResponse";
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<>(tradeRecordRepository.findTradeRecordByTo_card_idContainsAndDate_time(cardidList,resultmap.get("startdate"),resultmap.get("enddate")), HttpStatus.OK);
    }

    @RequestMapping(value = "/out" , method = RequestMethod.GET)
    public ResponseEntity<Collection<TradeRecord>> findByAllFrom(@RequestParam Map<String,String> params, HttpServletResponse resp){
        resp.setHeader("Access-Control-Allow-Origin", "*");
        Map<String,String> resultmap = new HashMap<>();
        resultmap = params;
        List<Integer> cardidList= Arrays.asList(resultmap.get("cardid").split(",")).stream().map(s -> Integer.parseInt(s.trim())).collect(Collectors.toList());
        String json = "jsonResponse";
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<>(tradeRecordRepository.findTradeRecordByFrom_card_idContainsAndDate_time(cardidList,resultmap.get("startdate"),resultmap.get("enddate")), HttpStatus.OK);
    }

   /* @GetMapping(path="/all")
    public @ResponseBody Iterable<TradeRecord> getAllUsers() {
        // This returns a JSON or XML with the users
        return tradeRecordService.getAll();
    }
    */
    @RequestMapping(value = "/parameters" , method= RequestMethod.GET )
    public Map<String,String> test2(@RequestParam Map<String,String> params){
        Map<String,String> resultmap = new HashMap<>();
        resultmap = params;
        List<Integer> cardidList= Arrays.asList(resultmap.get("cardid").split(",")).stream().map(s -> Integer.parseInt(s.trim())).collect(Collectors.toList());
        for (int i =0 ; i <cardidList.size();i++){
            System.out.println(cardidList.get(i));
        }
        return resultmap;
    }

}
