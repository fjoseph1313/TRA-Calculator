package com.utopia.tracalculator;

import com.utopia.tracalculator.service.VehicleService;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * Created by fjoseph1313 on 12/18/2016.
 */

public class VehicleServiceTest {

    private VehicleService vehicleService;

    @Before
    public void setup(){
        vehicleService = new VehicleService();
    }

//    @Test
//    public void testComputeExciseDuty() throws Exception{
//        BigDecimal amt = vehicleService.computeExciseDuty(new BigDecimal(1000), "2001cc - 2500cc");
//        Assert.assertNotNull(amt);
//        Assert.assertEquals("100", amt.toString());
//    }
}
