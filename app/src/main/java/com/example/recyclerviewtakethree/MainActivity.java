package com.example.recyclerviewtakethree;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    private static final String TAG = "MainActivity";
    public static final String EXTRA_MESSAGE_NAME = "Item Name";
    public static final String EXTRA_MESSAGE_DATE = "Item Date";
    public static final String EXTRA_MESSAGE_CATEGORY = "Item Category";
    EditText name;
    EditText date;
    int id;
    String nameString;
    String dateString;
    String categoryString;
    Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Spinner spinner = (Spinner)findViewById(R.id.spinner);
        button = (Button)findViewById(R.id.buttonAddItem);
        spinner.setOnItemSelectedListener(this);
        List<String> category=new ArrayList<>();
        category.add("Dairy");
        category.add("Vegetable");
        category.add("Fruit");
        category.add("Grains/Dry Goods");
        category.add("Canned");
        category.add("Meats");
        category.add("Other");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, category);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Start the Intent
                Intent intent= new Intent(MainActivity.this, ViewListActivity.class);

                // Grab views by IDs
                name = findViewById(R.id.editItemEntry);
                date = findViewById(R.id.editExpirationDate);

                // Turn them into Strings
                nameString = name.getText().toString();
                dateString = date.getText().toString();
                categoryString = String.valueOf(spinner.getSelectedItem());

                // Log it!
                Log.d(TAG, "About to create intent with item: " + nameString + " and " + dateString + " and " + categoryString);

                // Have the Intent go to work!
                intent.putExtra(EXTRA_MESSAGE_NAME, nameString);
                intent.putExtra(EXTRA_MESSAGE_DATE, dateString);
                intent.putExtra(EXTRA_MESSAGE_CATEGORY, categoryString);
                startActivity(intent);
             }
         }
        );
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
        // On selecting a spinner item
        String item = parent.getItemAtPosition(pos).toString();

        // Showing selected spinner item
        Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
    }
    public void onNothingSelected(AdapterView<?> adapterView) {
        // TODO Auto-generated method stub
    }
}