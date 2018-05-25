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





//        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager()
//                .findFragmentById(R.id.map_showplace_home);
////        LocationManager locationManager = (LocationManager)getActivity().
////                getSystemService(Context.LOCATION_SERVICE);
//        mapFragment.getMapAsync(new OnMapReadyCallback() {
//            @Override
//            public void onMapReady(GoogleMap googleMap) {
//                    googleMap.setOnMarkerDragListener(HomeFragment.this);
//                    googleMap.addMarker(new MarkerOptions()
//                            .title(showplace.title)
//                            .position(latLng)
//                            .draggable(true));
//                    googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 18));
//                }
//
//        });



        adapter = new HomeFragmentAdapter(getStar(), rootView.getContext());

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

    public ArrayList<Showplace> getStar(){
        SharedPreferences sp;
        sp = getActivity().getPreferences(Context.MODE_PRIVATE);

        Set<String> set;
        set = sp.getStringSet("Star", null);

        if (set==null){
            ArrayList<Showplace> s =new ArrayList<>();
            return s;
        }

        String[] st = (String[]) set.toArray();


        int[]star = new int[st.length];
        for(int i = 0; i<st.length;i++){
            star[i]=Integer.parseInt(st[i]);
        }

        ArrayList<Showplace> starSp = new ArrayList<>();
        for (Showplace v:showplaces){
            for(int va:star)
            if (v.id==va){
                starSp.add(v);
            }
        }
        return starSp;
    }

    @Override
    public void onResume() {
        super.onResume();
        adapter = new HomeFragmentAdapter(getStar(), rootView.getContext());
        recyclerView.setAdapter(adapter);
    }
}

