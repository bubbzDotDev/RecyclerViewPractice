package com.example.recyclerviewtakethree;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class AddAdditionalItemsFragment extends Fragment {

    private static final String TAG = "AddAdditionalItemsFragment";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_additional_items, container, false);
    }

    public void addItem(View view) {
        
    }
}