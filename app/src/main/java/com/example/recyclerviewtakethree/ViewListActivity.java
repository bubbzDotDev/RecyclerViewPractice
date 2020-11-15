package com.example.recyclerviewtakethree;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;

public class ViewListActivity extends AppCompatActivity {

    private static final String TAG = "ViewListActivity";
    ArrayList<Item> itemsList;
    String itemString;
    private Fragment AddAdditionalItemsFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_list);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        itemString = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        // Log it!
        Log.d(TAG, "Received intent with item: " + itemString);

        // Make it "of type Item"
        Item itemItem = new Item(itemString);

        // Lookup the RecyclerView in activity layout
        RecyclerView rvItems = findViewById(R.id.rvItems);

        // Initialize list and add the first item
        itemsList = Item.createItemsList(itemItem);

        // Add additional items to the list
        // (Going to try and use the code right below this line in AddAdditionalItemsFragment.java)
        // itemsList.addAll(Item.createItemsList(itemItem));

        // Create adapter passing in the item data
        ItemsAdapter adapter = new ItemsAdapter(itemsList);

        // Set layout manager to position the items
        rvItems.setLayoutManager(new LinearLayoutManager(this));

        // Attach the adapter to the RecyclerView to populate items
        rvItems.setAdapter(adapter);
    }

    public void addAdditionalItems(View view) {
        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.container, AddAdditionalItemsFragment, TAG);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}