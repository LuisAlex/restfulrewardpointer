package com.kforce.charter.restfulrewardpointer.controller;

import com.kforce.charter.restfulrewardpointer.service.RewardPointerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class RewardPointerController {
    @Autowired
    public RewardPointerService pointerService;

    @GetMapping(path = "/point/{spending}")
    public ResponseEntity<String> getPoints(@PathVariable int spending) {
        return ResponseEntity.ok("Total reward: " + pointerService.getPoints(spending));
    }

    @GetMapping(path = "/point/{month1}/{month2}/{month3}")
    public ResponseEntity<String> getThreeMonthlyRecord(@PathVariable List<Integer> month1, @PathVariable List<Integer> month2, @PathVariable List<Integer> month3) {
        Map<String, List<Integer>> threeMonthlyRecord = new HashMap<String, List<Integer>>() {{
            put("First Month", month1);
            put("Second Month", month2);
            put("Third Month", month3);
        }};
        return ResponseEntity.ok("Total reward: " + pointerService.getThreeMonthlyRecord(threeMonthlyRecord));
    }
}
