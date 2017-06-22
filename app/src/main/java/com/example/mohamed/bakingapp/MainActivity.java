package com.example.mohamed.bakingapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private final static String API_KEY = "2017/May/59121517_baking/baking.json";
    static ArrayList arrayList = new ArrayList();
    static Recip currentRecip;
    Context context ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView =(RecyclerView) findViewById(R.id.rv);
        Data[] data = {new Data("Nutella Pie",R.drawable.np),
                new Data("Brownies",R.drawable.br),
                new Data("Yellow Cake",R.drawable.yk),
                new Data("Cheesecake",R.drawable.ck)};

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        MyAdapter adapter = new MyAdapter(data);
        recyclerView.setAdapter(adapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(context, recyclerView ,new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {
                        // do whatever
                        if(arrayList.size() == 4) {
                            currentRecip = (Recip) arrayList.get(position);
                            Intent in = new Intent((view.getContext()), SecoundActivity.class);
                            startActivity(in);
                        }
                        }

                    @Override public void onLongItemClick(View view, int position) {
                        // do whatever
                    }
                })
        );

        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);
        Call call = apiService.getRecip();
        call.enqueue(new Callback<Recip[]>() {
                         @Override
                         public void onResponse(Call<Recip[]> call, Response<Recip[]> response) {
                            Recip[] recips = response.body();
                             for (int i = 0 ;i< recips.length;i++){
                                 arrayList.add(recips[i]);

                             }


                         }

                         @Override
                         public void onFailure(Call<Recip[]> call, Throwable t) {
                            Toast.makeText(getApplicationContext(),t.toString(),Toast.LENGTH_LONG).show();
                             Log.i("error==================",t.toString());
                         }
                     });
   }

}
