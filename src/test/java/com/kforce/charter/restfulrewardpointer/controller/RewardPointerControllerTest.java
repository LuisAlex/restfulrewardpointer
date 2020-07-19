package com.kforce.charter.restfulrewardpointer.controller;

import com.kforce.charter.restfulrewardpointer.service.RewardPointerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;
import java.util.Map;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.mock;

@RunWith(MockitoJUnitRunner.class)
public class RewardPointerControllerTest {
    @InjectMocks
    private RewardPointerController rewardPointerController;
    @Mock
    private RewardPointerService pointerService;

    @Test
    public void returnsValueOnGetPointsService() {
        when(pointerService.getPoints(anyInt())).thenReturn(0);
        assertNotNull(rewardPointerController.getPoints(100));
    }

    @Test
    public void returnsValueOnThreeMonthlyRecord() {
        when(pointerService.getThreeMonthlyRecord(any(Map.class))).thenReturn(mock(Map.class));
        assertNotNull(rewardPointerController.getThreeMonthlyRecord(mock(List.class), mock(List.class), mock(List.class)));
    }
}
