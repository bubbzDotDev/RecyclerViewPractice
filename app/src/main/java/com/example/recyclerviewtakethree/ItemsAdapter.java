package com.example.recyclerviewtakethree;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.AsyncDifferConfig;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

// Create the basic adapter extending from RecyclerView.Adapter
// Note that we specify the custom ViewHolder which gives us access to our views
public class ItemsAdapter extends ListAdapter<Item, ItemsAdapter.ViewHolder> {

    // Store a member variable for the items
    private ArrayList<Item> items;

    public ItemsAdapter(ArrayList<Item> itemsList) {
        super(DIFF_CALLBACK);
        this.items = itemsList;
    }

    public static final DiffUtil.ItemCallback<Item> DIFF_CALLBACK =
            new DiffUtil.ItemCallback<Item>() {
                @Override
                public boolean areItemsTheSame(Item oldItem, Item newItem) {
                    return oldItem.getId() == newItem.getId();
                }
                @Override
                public boolean areContentsTheSame(Item oldItem, Item newItem) {
                    return (oldItem.getItem().equalsIgnoreCase(newItem.getItem()));
                }
            };

    public void addMoreItems(List<Item> newItems) {
        items.addAll(newItems);
        submitList(items); // DiffUtil takes care of the check
    }

    // Usually involves inflating a layout from XML and returning the holder
    public ItemsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View itemView = inflater.inflate(R.layout.item_section, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(itemView);
        return viewHolder;
    }

    // Involves populating data into the item through holder
    public void onBindViewHolder(ItemsAdapter.ViewHolder holder, int position) {
        // Get the data model based on position
        Item item = getItem(position);

        // Set item views based on your views and data model
        TextView textView = holder.itemTextView;
        textView.setText(item.getItem());
    }

    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
    public class ViewHolder extends RecyclerView.ViewHolder {
        // Your holder should contain a member variable
        // for any view that will be set as you render a row
        public TextView itemTextView;

        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each subview
        public ViewHolder(View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);

            itemTextView = (TextView) itemView.findViewById(R.id.item_name);
        }
    }
}
