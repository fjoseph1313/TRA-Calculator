package com.utopia.tracalculator.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.TextView;

import com.utopia.tracalculator.Model.Vehicle;
import com.utopia.tracalculator.R;
import com.utopia.tracalculator.service.VehicleService;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class TaxDetailsActivity extends AppCompatActivity {

    private static final BigDecimal CIF_AMOUNT = new BigDecimal(1732.50);
    private static final double EXCHANGE_RATE = 2100.00;

    private VehicleService vehicleService = new VehicleService();
    private TextView cifView;
    private TextView impdView;
    private TextView excdView;
    private TextView excessdView;
    private TextView vatView;
    private TextView customFeeView;
    private TextView railwayView;
    private TextView totalUsdView;
    private TextView totalTzsView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tax_details);

        Intent intent = getIntent();
        String details = intent.getStringExtra(MainActivity.TAX_SUMMARY);
        TextView detailsView = new TextView(this);
        detailsView.setText(details);
        detailsView.setTextSize(32);

        Vehicle vehicle = (Vehicle) intent.getSerializableExtra(MainActivity.VEHICLE);

        //TODO : Populate the TaxDetails Display activity
        populateVehicleDetailsView(vehicle);
        getTaxDetailsViews();

        BigDecimal cif_amount = getCifAmount();
        BigDecimal import_duty = getImportDuty(CIF_AMOUNT);
        BigDecimal excise_duty = getExciseDuty(CIF_AMOUNT.add(import_duty), vehicle.getEngineCapacity());
        BigDecimal excess_duty = getExcessExciseDuty(CIF_AMOUNT, import_duty, excise_duty);
        BigDecimal vat = getVat(cif_amount.add(import_duty).add(excise_duty).add(excess_duty));
        BigDecimal custom_fees = getCustomFees(CIF_AMOUNT);
        BigDecimal railway_fee = getRailwayFees(CIF_AMOUNT);
        BigDecimal totalUsd = import_duty
                .add(excise_duty)
                .add(excess_duty)
                .add(vat)
                .add(custom_fees)
                .add(railway_fee);
        BigDecimal totalTzs = totalUsd.multiply(new BigDecimal(EXCHANGE_RATE)).setScale(2, RoundingMode.CEILING);

        cifView.setText("$"+CIF_AMOUNT.toString());
        impdView.setText("$"+import_duty.toString());
        excdView.setText("$"+excise_duty.toString());
        excessdView.setText("$"+excess_duty.toString());
        vatView.setText("$"+vat.toString());
        customFeeView.setText("$"+custom_fees.toString());
        railwayView.setText("$"+railway_fee.toString());
        totalUsdView.setText("$"+totalUsd.toString());
        totalTzsView.setText("TZS "+totalTzs.toString());
    }

    public BigDecimal getCifAmount(){
        //TODO : Calculate the initial CIF
        return CIF_AMOUNT;
    }

    public BigDecimal getImportDuty(BigDecimal cifAmount){
        return vehicleService.computeImportDuty(cifAmount);
    }

    public BigDecimal getExciseDuty(BigDecimal amt, String capacity){
        return vehicleService.computeExciseDuty(amt, capacity);
    }

    public BigDecimal getExcessExciseDuty(BigDecimal cifamt, BigDecimal imdamt, BigDecimal exdamt){
        return vehicleService.computeExciseDutyDueToAge(cifamt, imdamt, exdamt);
    }

    public BigDecimal getVat(BigDecimal amt){
        return vehicleService.computeVAT(amt);
    }

    public BigDecimal getCustomFees(BigDecimal amt){
        return vehicleService.computeCustomeProcessingFees(amt);
    }

    public BigDecimal getRailwayFees(BigDecimal amt){
        return vehicleService.computeRailwayDevLevy(amt);
    }

    public void populateVehicleDetailsView(Vehicle vehicle){
        TextView modelView = (TextView) this.findViewById(R.id.modelView);
        TextView makeView = (TextView) this.findViewById(R.id.makeView);
        TextView yomview = (TextView) this.findViewById(R.id.yomView);
        TextView capacityView = (TextView) this.findViewById(R.id.engCapacityView);
        TextView fuelView = (TextView) this.findViewById(R.id.fuelView);

        makeView.setText(vehicle.getMake());
        modelView.setText(vehicle.getModel());
        yomview.setText(vehicle.getYearOfManufacture().toString());
        capacityView.setText(vehicle.getEngineCapacity());
        fuelView.setText(vehicle.getFuel());
    }

    public void getTaxDetailsViews(){
        cifView = (TextView) this.findViewById(R.id.cifView);
        impdView = (TextView) this.findViewById(R.id.impdView);
        excdView = (TextView) this.findViewById(R.id.excdView);
        excessdView = (TextView) this.findViewById(R.id.excessdView);
        vatView = (TextView) this.findViewById(R.id.vatView);
        customFeeView = (TextView) this.findViewById(R.id.customFeeView);
        railwayView = (TextView) this.findViewById(R.id.railwayView);
        totalUsdView = (TextView) this.findViewById(R.id.totalUsdView);
        totalTzsView = (TextView) this.findViewById(R.id.totalTzsView);
    }

    public void getExchangeRateFromCloud(){
        //TODO : Get current rates from cloud
    }

}
