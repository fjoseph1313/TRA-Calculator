package com.utopia.tracalculator.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.utopia.tracalculator.Model.Vehicle;
import com.utopia.tracalculator.Model.VehicleUtil;
import com.utopia.tracalculator.R;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private VehicleUtil vehicleUtil;

    public static final String TAX_SUMMARY = "TAX_SUMMARY";
    public static final String VEHICLE = "VEHICLE";
    private Spinner carMakeSpinner, engCapacitySpinner, carModelSpinner;
    private RadioButton radioGas, radioDiesel;
    private EditText yomText;
    private String fuelType;
    private Button calcButton;
    private String[] years = {"1980","1981","1982","1983","1984","1985","1986","1987","1988","1989","1990","1991","1992","1993","1994","1995","1996","1997","1998",
            "1999","2000","2001","2002","2003","2004","2005","2006","2007","2008","2009","2010","2011","2012","2013","2014","2015","2016"
    };
    private String[] models = {"A4", "A6", "AMG SLS", "AMG SLK", "C-Class", "E-Class", "M3", "X6"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //TODO : Dynamically populate models associated with the selected make
        carMakeSpinner = (Spinner) this.findViewById(R.id.carMakeSpinner);
        carMakeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String selectedMake = carMakeSpinner.getSelectedItem().toString();
                populateModelSpinner(getCarModels(selectedMake));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                addModelSpinner();
            }
        });

        radioGas = (RadioButton) this.findViewById(R.id.radioGas);
        radioDiesel = (RadioButton) this.findViewById(R.id.radioDiesel);
        radioGas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                radioGas.setChecked(Boolean.TRUE);
                radioDiesel.setChecked(Boolean.FALSE);
            }
        });
        radioDiesel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                radioDiesel.setChecked(Boolean.TRUE);
                radioGas.setChecked(Boolean.FALSE);
            }
        });

        populateSpinners();
        calculateTax();
    }

    public void populateSpinners(){
        addMakeSpinner();
    }

    public void addMakeSpinner(){
        carMakeSpinner = (Spinner) this.findViewById(R.id.carMakeSpinner);
        vehicleUtil = new VehicleUtil();
        List<String> makes = vehicleUtil.getVehicleMakes();
        ArrayAdapter<String> makeAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, makes);
        makeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        carMakeSpinner.setAdapter(makeAdapter);
    }

    public void addModelSpinner(){
        carModelSpinner = (Spinner) this.findViewById(R.id.carModelspinner);
        ArrayAdapter<String> modelAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, models);
        modelAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        carModelSpinner.setAdapter(modelAdapter);
    }

    public void populateModelSpinner(List<String> models){
        carModelSpinner = (Spinner) this.findViewById(R.id.carModelspinner);
        ArrayAdapter<String> modelAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, models);
        modelAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        carModelSpinner.setAdapter(modelAdapter);
    }

    public List<String> getCarModels(String make){
        vehicleUtil = new VehicleUtil();
        List<String> models = vehicleUtil.findModels(make);
        return models;
    }

    public void calculateTax(){
        carMakeSpinner = (Spinner) this.findViewById(R.id.carMakeSpinner);
        carModelSpinner = (Spinner) this.findViewById(R.id.carModelspinner);
        engCapacitySpinner = (Spinner) this.findViewById(R.id.engCapacitySpinner);
        yomText = (EditText) this.findViewById(R.id.yomTxt);
        calcButton = (Button) this.findViewById(R.id.calcButton);

        fuelType = (radioGas.getText().toString() == null) ? radioDiesel.getText().toString() : "Petrol";
        if(!radioGas.isChecked()){
            fuelType = radioDiesel.getText().toString();
        }

       calcButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO : Real Computation here
                Vehicle vehicle = Vehicle.builder().withMake(carMakeSpinner.getSelectedItem().toString())
                        .withModel(carModelSpinner.getSelectedItem().toString())
                        .withYearOfManufacture(new Long(yomText.getText().toString()))
                        .withEngineCapacity(engCapacitySpinner.getSelectedItem().toString())
                        .withFuel(fuelType).build();
                String tosted = String.format("make:%s,model:%s,yom:%s,capacity:%s,fuel:%s",
                        carMakeSpinner.getSelectedItem().toString(), carModelSpinner.getSelectedItem().toString(),
                        yomText.getText().toString(),
                        engCapacitySpinner.getSelectedItem().toString(),
                        fuelType);
                Toast.makeText(MainActivity.this, tosted, Toast.LENGTH_SHORT).show();
                //Launch Details activity
                Intent intent = new Intent(getApplicationContext(), TaxDetailsActivity.class);
                intent.putExtra(TAX_SUMMARY, tosted);
                intent.putExtra(VEHICLE, vehicle);
                startActivity(intent);
            }
        });
    }
}
