package com.example.mohamed.bakingapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class SecoundActivity extends AppCompatActivity {
    static final String fragment1Tag = "Fragment1Tag";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ing_desc);
        Button ingrediants = (Button)findViewById(R.id.button);
        Button steps = (Button)findViewById(R.id.button2);
        steps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(view.getContext(),RecipStetps.class);
                startActivity(in);
                            }
        });
       ingrediants.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // android.app.FragmentTransaction fragmentTransaction = new android.app.FragmentTransaction();
                //fragmentTransaction.addToBackStack(fragment1Tag);

                    Fragment fragment1 = getSupportFragmentManager().findFragmentByTag(fragment1Tag);
                if(fragment1 == null) {
                    fragment1 = new IngrediantFragment();
                    getSupportFragmentManager().beginTransaction()
                            .add(R.id.fram1, fragment1,fragment1Tag)
                            .commit();
                }
                else
                    Toast.makeText(getApplicationContext(),"fragment = null",Toast.LENGTH_LONG).show();
            }
        });


    }
    }