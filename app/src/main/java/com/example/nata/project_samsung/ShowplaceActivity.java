package com.example.nata.project_samsung;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.lang.reflect.Array;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;

public class ShowplaceActivity extends AppCompatActivity implements GoogleMap.OnMarkerDragListener {

    Toolbar toolbar;

    long id;
    Showplace showplace;
    ArrayList<Showplace> showplaces;

    TextView txtTitle, txtAddress, txtUrl, txtDescription;
    ImageView imgPoster;

    Button star;

    private Marker mMarker;

    LatLng latLng;

    Context context;

    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showplace);
        context=this;

        id=(long)getIntent().getSerializableExtra("id");
        id--;

        ShowplaceHelper sh = new ShowplaceHelper(getApplicationContext());

        showplaces = sh.getAll("");
        showplace = showplaces.get((int)id);

        latLng = new LatLng(showplace.lat, showplace.lng);


        toolbar = (Toolbar) findViewById(R.id.toolbarShowplace);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(showplace.title);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        setContent();


    }



    void setContent(){

        txtTitle = findViewById(R.id.title_showplace_activity);
        txtAddress = findViewById(R.id.address_showplace_activity);
        txtUrl = findViewById(R.id.url_showplace_activity);
        txtDescription = findViewById(R.id.description_showplace_activity);
        imgPoster = findViewById(R.id.img_showplace_activity);
        star = findViewById(R.id.star);

        txtTitle.setText(showplace.getTitle());
        txtAddress.setText(showplace.getAddress());
        txtUrl.setText(showplace.getUrl());
        txtDescription.setText(showplace.getDescription());
        if(showplace.getImage()!=null){
            int resID = ((Activity)context).getResources().getIdentifier(showplace.getImage() , "drawable", "com.example.nata.project_samsung");
            imgPoster.setImageResource(resID);}

        txtUrl.setClickable(true);
        txtUrl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri address= Uri.parse("http://"+showplace.getUrl());
                Intent browser= new Intent(Intent.ACTION_VIEW, address);
                Log.d("IntentDebug", "Link is "+address.toString());
                startActivity(browser);
            }
        });

        SupportMapFragment mapFragment = (SupportMapFragment)
                getSupportFragmentManager().findFragmentById(R.id.map_showplace_activity);
        mapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                googleMap.setOnMarkerDragListener(ShowplaceActivity.this);
                mMarker = googleMap.addMarker(new MarkerOptions()
                        .title(showplace.title)
                        .position(latLng)
                        .draggable(true));
                googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 18));
            }
        });

        star.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int s = (int)showplace.id;
                try {
                    sp = getPreferences(MODE_PRIVATE);
                    String[] star = sp.getString("Star", "").split(" ");
                    int[] starInt=new int[star.length+1];
                    for (int i = 0; i<star.length;i++) {
                        starInt[i] = Integer.parseInt(star[i]);
                        if (starInt[i] == s) {
                            throw new Exception();
                        }
                    }
                    starInt[starInt.length-1] =s;
                    Arrays.sort(starInt);
                    SharedPreferences.Editor editor = sp.edit();
                    String edit="";
                    for (int v:
                         starInt) {
                        edit=edit+" "+v;
                    }
                    editor.putString("Star", edit);
                    editor.commit();
                }catch (Exception e){}
            }
        });
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
