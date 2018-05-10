package com.example.nata.project_samsung;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;

public class ShowplaceActivity extends AppCompatActivity {

    Toolbar toolbar;

    long id;
    Showplace showplace;
    ArrayList<Showplace> showplaces;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showplace);

        id=(long)getIntent().getSerializableExtra("id");

        ShowplaceHelper sh = new ShowplaceHelper(getApplicationContext());

        showplaces = sh.getAll("");
        showplace = showplaces.get((int)id);

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
    }
}
