package com.example.nata.project_samsung;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;


public class ShowplaceFragment extends Fragment {

    String markPlace;

    RecyclerView recyclerView;

    View rootView;

    public ShowplaceFragment(){}

    @SuppressLint("ValidFragment")
    public ShowplaceFragment(String markPlace){
        this.markPlace=markPlace;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.fragment_showplace, container, false);

        List<Showplace> showplaces =new ArrayList<>();

        showplaces.add(new Showplace(1, "Title","Description!Description!Description!",
                "","",""));
        showplaces.add(new Showplace(2,"Title", "Description!Description!Description!",
                "","",""));


        recyclerView = rootView.findViewById(R.id.rv) ;

        recyclerView.setLayoutManager(new LinearLayoutManager(rootView.getContext()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(new RVAdapter(showplaces, rootView.getContext()));

        return rootView;
    }
}
