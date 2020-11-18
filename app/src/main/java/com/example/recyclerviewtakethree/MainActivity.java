package com.example.recyclerviewtakethree;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    public static final String EXTRA_MESSAGE_NAME = "Item Name";
    public static final String EXTRA_MESSAGE_DATE = "Item Date";
    EditText name;
    EditText date;
    int id;
    String nameString;
    String dateString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void addFirstItem(View view) {

        // Start the Intent
        Intent intent = new Intent(this, ViewListActivity.class);

        // Grab views by IDs
        name = findViewById(R.id.editItemEntry);
        date = findViewById(R.id.editExpirationDate);

        // Turn them into Strings
        nameString = name.getText().toString();
        dateString = date.getText().toString();

        // Log it!
        Log.d(TAG, "About to create intent with item: " + nameString + " and " + dateString);

        // Have the Intent go to work!
        intent.putExtra(EXTRA_MESSAGE_NAME, nameString);
        intent.putExtra(EXTRA_MESSAGE_DATE, dateString);
        startActivity(intent);
    }
}