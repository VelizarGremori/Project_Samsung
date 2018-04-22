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

    Context context;

    RecyclerView recyclerView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }
    public ShowplaceFragment(){}

    @SuppressLint("ValidFragment")
    public ShowplaceFragment(String markPlace, Context context){
        this.markPlace=markPlace; this.context=context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        List<Showplace> showplaces =new ArrayList<>();

        showplaces.add(new Showplace(1, "Description!Description!Description!",
                "Title","","",""));

        View rootView = inflater.inflate(R.layout.fragment_showplace, container, false);

        recyclerView = rootView.findViewById(R.id.rv) ;

        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(new RVAdapter(showplaces, context));
        return rootView;
    }
}
