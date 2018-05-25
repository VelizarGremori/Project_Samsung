package com.example.nata.project_samsung;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


public class HomeFragment extends Fragment implements GoogleMap.OnMarkerDragListener {

    View rootView;

    ArrayList<Showplace> showplaces;

    HomeFragmentAdapter adapter;

    RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.fragment_home, container, false);

        ShowplaceHelper sh=new ShowplaceHelper(getContext());

        showplaces = sh.getAll(0);


        adapter = new HomeFragmentAdapter(showplaces, rootView.getContext());

        recyclerView = rootView.findViewById(R.id.home_rv) ;




        recyclerView.setLayoutManager(new LinearLayoutManager(rootView.getContext()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);



        return rootView;
    }

    @Override
    public void onMarkerDragStart(Marker marker) {

    }

    @Override
    public void onMarkerDrag(Marker marker) {

    }

    @Override
    public void onMarkerDragEnd(Marker marker) {

    }

}

