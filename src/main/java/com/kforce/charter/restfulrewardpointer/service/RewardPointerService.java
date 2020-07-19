package com.kforce.charter.restfulrewardpointer.service;

import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class RewardPointerService {

    public int getPoints(int spending) {
        if (spending >= 50 && spending <= 100) {
            return spending - 50;
        } else if (spending > 100) {
            return (2 * (spending - 100) + 50);
        }
        return 0;
    }

    public Map<String, Integer> getThreeMonthlyRecord(Map<String, List<Integer>> threeMonthlyRecord) {
        Map<String, Integer> totalRecord = new HashMap<>();
        threeMonthlyRecord.forEach((k, v) -> {
            AtomicInteger totalMonthly = new AtomicInteger();
            v.forEach(spending -> {
                totalMonthly.set(totalMonthly.get() + getPoints(spending));
            });
            totalRecord.put(k, totalMonthly.intValue());
        });
        totalRecord.put("Total", totalRecord.values().stream().reduce(0, Integer::sum));
        return totalRecord;
    }
}
