package com.utopia.tracalculator.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.TextView;

import com.utopia.tracalculator.R;

public class TaxDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tax_details);

        Intent intent = getIntent();
        String details = intent.getStringExtra(MainActivity.TAX_SUMMARY);
        TextView detailsView = new TextView(this);
        detailsView.setText(details);
        detailsView.setTextSize(32);

        ViewGroup layout = (ViewGroup) findViewById(R.id.activity_tax_details);
        layout.addView(detailsView);
    }
}
