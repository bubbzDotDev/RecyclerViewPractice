package com.example.recyclerviewtakethree;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import java.util.ArrayList;

public class ViewListActivity extends AppCompatActivity {

    private static final String TAG = "ViewListActivity";
    ArrayList<Item> itemsList;
    String nameString;
    String dateString;
    String categoryString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_list);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        nameString = intent.getStringExtra(MainActivity.EXTRA_MESSAGE_NAME);
        dateString = intent.getStringExtra(MainActivity.EXTRA_MESSAGE_DATE);
        categoryString = intent.getStringExtra(MainActivity.EXTRA_MESSAGE_CATEGORY);

        // Log it!
        Log.d(TAG, "Received intent with item: " + nameString + " and " + dateString + " and " + categoryString);

        // Make it "of type Item"
        Item itemItem = new Item(nameString, dateString, categoryString);

        // Lookup the RecyclerView in activity layout
        RecyclerView rvItems = findViewById(R.id.rvItems);

        // Initialize list and add the first item
        itemsList = Item.createItemsList(itemItem);

        // Add additional items to the list
        // (Going to try and use the code right below this line in AddAdditionalItemsFragment.java)
        // itemsList.addAll(Item.createItemsList(itemItem));

        // Create adapter passing in the item data
        ItemsAdapter adapter = new ItemsAdapter(itemsList);

        // This makes the program work but it adds the same item twice:
        adapter.addMoreItems(itemsList);

        // Set layout manager to position the items
        rvItems.setLayoutManager(new LinearLayoutManager(this));

        // Attach the adapter to the RecyclerView to populate items
        rvItems.setAdapter(adapter);
    }
}