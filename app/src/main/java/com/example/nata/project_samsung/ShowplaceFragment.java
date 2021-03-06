package com.example.nata.project_samsung;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class ShowplaceFragment extends Fragment {

    RecyclerView recyclerView;

    View rootView;

    ShowplaceFragmentAdapter adapter;

    ArrayList<Showplace> showplaces;

    public ShowplaceFragment(){}


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.fragment_showplace, container, false);

        Log.d("FragmentTest", "ShowplaceFragment Instal");

        ShowplaceHelper sh=new ShowplaceHelper(getContext());

        showplaces = sh.getAll(3);

        ArrayList<Showplace> showplaces2 = new ArrayList<>();
        for(int i = 0; i < showplaces.size();i++){
            if (showplaces.get(i).getMarkPlace()==3){
                showplaces2.add(showplaces.get(i));
            }
        }

        adapter = new ShowplaceFragmentAdapter(showplaces2, rootView.getContext());

        recyclerView = rootView.findViewById(R.id.rv_showplace) ;



        recyclerView.setLayoutManager(new LinearLayoutManager(rootView.getContext()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);


        return rootView;
    }

}
