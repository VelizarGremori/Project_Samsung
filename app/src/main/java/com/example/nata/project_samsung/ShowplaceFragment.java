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
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;


public class ShowplaceFragment extends Fragment {

    String markPlace;

    RecyclerView recyclerView;

    View rootView;

    ShowplaceFragmentAdapter adapter;

    ArrayList<Showplace> showplaces;

    public ShowplaceFragment(){}

    @SuppressLint("ValidFragment")
    public ShowplaceFragment(String markPlace){
        this.markPlace=markPlace;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.fragment_showplace, container, false);

        ShowplaceHelper sh=new ShowplaceHelper(getContext());

        showplaces = sh.getAll(markPlace);

        adapter = new ShowplaceFragmentAdapter(showplaces, rootView.getContext());

        recyclerView = rootView.findViewById(R.id.rv) ;


        recyclerView.setLayoutManager(new LinearLayoutManager(rootView.getContext()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

        return rootView;
    }

}
