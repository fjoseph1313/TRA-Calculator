package com.utopia.tracalculator.service;

import com.utopia.tracalculator.Model.Depreciation;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;

/**
 * Created by fjoseph1313 on 12/17/2016.
 */

public class VehicleService {

    private static final BigDecimal IMPORT_DUTY = new BigDecimal(0.25);
    private static final BigDecimal EXCISE_DUTY_AGE = new BigDecimal(0.20);
    private static final BigDecimal VAT = new BigDecimal(0.18);
    private static final BigDecimal RAILWAY_LEVY_DEV = new BigDecimal(0.015);
    private static final BigDecimal CUSTOM_FEES = new BigDecimal(0.005);
    private static final List<Depreciation> depriciations = Arrays.asList(new Depreciation(0, 10), new Depreciation(1, 15), new Depreciation(2, 20), new Depreciation(3, 25),
            new Depreciation(4, 30), new Depreciation(5, 35), new Depreciation(6, 40), new Depreciation(7, 50), new Depreciation(8, 60), new Depreciation(9, 70),
            new Depreciation(10, 80));

    /**
     * CIF amount depends on depreciation of the car, from the original amount.
     * @return
     */
    public BigDecimal calculateCifAmount(){
        return null;
    }

    public BigDecimal computeImportDuty(BigDecimal cif){
        return cif.multiply(IMPORT_DUTY).setScale(2, RoundingMode.CEILING);
    }

    /**
     * This depends on the engineCapacity of the car
     * @param cifAndImp, a total of CIF and ImportDuty amount
     * @param engineCapacity, engine capacity for excise duty percentage
     * @return excise duty amount
     */
    public BigDecimal computeExciseDuty(BigDecimal cifAndImp, String engineCapacity){
        BigDecimal exduty;
        if(engineCapacity.equalsIgnoreCase(EngineCapacity.SMALLER.getValue())){
            exduty = new BigDecimal(0);
        } else if (engineCapacity.equalsIgnoreCase(EngineCapacity.SMALL.getValue())){
            exduty = new BigDecimal(cifAndImp.doubleValue() * 0.05);
        } else if (engineCapacity.equalsIgnoreCase(EngineCapacity.MEDIUM.getValue())){
            exduty = new BigDecimal(cifAndImp.doubleValue() * 0.05);
        } else if (engineCapacity.equalsIgnoreCase(EngineCapacity.BIG.getValue())){
            exduty = new BigDecimal(cifAndImp.doubleValue() * 0.1);
        } else if (engineCapacity.equalsIgnoreCase(EngineCapacity.BIGGER.getValue())){
            exduty = new BigDecimal(cifAndImp.doubleValue() * 0.1);
        } else {
            exduty = new BigDecimal(0);
        }
        return exduty.setScale(2, RoundingMode.CEILING);
    }

    public BigDecimal computeExciseDutyDueToAge(BigDecimal cifAmount, BigDecimal imdAmount, BigDecimal exdAmount){
        return EXCISE_DUTY_AGE.multiply(cifAmount.add(imdAmount)).add(exdAmount).setScale(2, RoundingMode.CEILING);
    }

    public BigDecimal computeCustomeProcessingFees(BigDecimal cifAmount){
        return cifAmount.multiply(CUSTOM_FEES).setScale(2, RoundingMode.CEILING);
    }

    public BigDecimal computeVAT(BigDecimal vatBase){
        return vatBase.multiply(VAT).setScale(2, RoundingMode.CEILING);
    }

    public BigDecimal computeRailwayDevLevy(BigDecimal cifAmount){
        return cifAmount.multiply(RAILWAY_LEVY_DEV).setScale(2, RoundingMode.CEILING);
    }
}
