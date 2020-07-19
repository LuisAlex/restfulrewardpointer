package com.kforce.charter.restfulrewardpointer.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class RewardPointerServiceTest {
    @InjectMocks
    private RewardPointerService pointerService;

    @Test
    public void returnsValueOnGetPointsService() {
        assertEquals(90, pointerService.getPoints(120));
    }

    @Test
    public void returnsValueOnThreeMonthlyRecord() {
        Map<String, List<Integer>> testMap = new HashMap<String, List<Integer>>() {{
            put("First Month", new ArrayList<Integer>() {{ add(90); }});
            put("Second Month", new ArrayList<Integer>() {{ add(90); }});
            put("Third Month", new ArrayList<Integer>() {{ add(90); }});
        }};
        Map<String, Integer> resultMap = pointerService.getThreeMonthlyRecord(testMap);
        int month1 = resultMap.get("First Month");
        int month2 = resultMap.get("Second Month");
        int month3 = resultMap.get("Third Month");
        int total = resultMap.get("Total");
        assertEquals(40, month1);
        assertEquals(40, month2);
        assertEquals(40, month3);
        assertEquals(120, total);
    }
}
