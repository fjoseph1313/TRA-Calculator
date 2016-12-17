package com.utopia.tracalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private Spinner yomSpinner, carMakeSpinner, engCapacitySpinner;
    private Button calcButton;
    private String[] years = {"1980","1981","1982","1983","1984","1985","1986","1987","1988","1989","1990","1991","1992","1993","1994","1995","1996","1997","1998",
            "1999","2000","2001","2002","2003","2004","2005","2006","2007","2008","2009","2010","2011","2012","2013","2014","2015","2016"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        populateSpinners();
        calculateTax();
    }

    public String[] checkNewYear(){
        //TODO : check now and compare with the first entry of the years.
        return null;
    }

    public void populateSpinners(){
        //TODO : populate all spinners here
        addYearsSpinner();
    }

    public void addYearsSpinner(){
        yomSpinner = (Spinner) this.findViewById(R.id.yomSpinner);
        ArrayAdapter<String> yearAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, years);
        yearAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        yomSpinner.setAdapter(yearAdapter);
    }

    public void calculateTax(){
        yomSpinner = (Spinner) this.findViewById(R.id.yomSpinner);
        carMakeSpinner = (Spinner) this.findViewById(R.id.carMakeSpinner);
        engCapacitySpinner = (Spinner) this.findViewById(R.id.engCapacitySpinner);
        calcButton = (Button) this.findViewById(R.id.calcButton);

        calcButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO : Real Computation here
                String tosted = String.format("OnClick item selected %s : %s : %s", yomSpinner.getSelectedItem().toString(),
                        carMakeSpinner.getSelectedItem().toString(), engCapacitySpinner.getSelectedItem().toString());
                Toast.makeText(MainActivity.this, tosted, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
