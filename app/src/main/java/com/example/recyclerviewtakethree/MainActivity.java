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
    public static final String EXTRA_MESSAGE = "com.example.testingforgetmenot.MESSAGE";
    EditText item;
    String itemString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void addFirstItem(View view) {

        // Start the Intent
        Intent intent = new Intent(this, ViewListActivity.class);

        // Grab views by IDs
        item = findViewById(R.id.editItemEntry);

        // Turn it into a String
        itemString = item.getText().toString();

        // Log it!
        Log.d(TAG, "About to create intent with item: " + itemString);

        // Have the Intent go to work!
        intent.putExtra(EXTRA_MESSAGE, itemString);
        startActivity(intent);
    }
}