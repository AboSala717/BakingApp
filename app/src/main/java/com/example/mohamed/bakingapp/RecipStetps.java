package com.example.mohamed.bakingapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class RecipStetps extends AppCompatActivity {

    List steps ;
    ArrayList<String> descriptions = new ArrayList<String>();
    ArrayList<String> videoUrls = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recip_stetps);
        GridView gridView = (GridView)findViewById(R.id.stepsgridview);
        steps = MainActivity.currentRecip.getSteps();
        gridView.setAdapter(new StepsAdapter(this,steps) );

        for (int i = 0 ; i< steps.size() ; i++){
            String step = steps.get(i).toString();
            String description =step.substring(step.indexOf("description="),((step.indexOf("videoURL"))-2));
            String rightDescription = description.substring(12);
            String videoUrl = step.substring(step.indexOf("videoURL="),((step.indexOf("thumbnailURL"))-2));
            String rightVideoUrl = videoUrl.substring(9);
            videoUrls.add(rightVideoUrl);
            descriptions.add(rightDescription);

        }



    }
    public class StepsAdapter extends BaseAdapter{
        Context context ;
        List steps ;

        public StepsAdapter(Context context, List steps) {
            this.context = context;
            this.steps = steps;
        }

        @Override
        public int getCount() {
            return steps.size();
        }

        @Override
        public Object getItem(int i) {
            return steps.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(final int i, View view, ViewGroup viewGroup) {
            LayoutInflater inflater =getLayoutInflater();
            View item = inflater.inflate(R.layout.stepsbuttons,viewGroup,false);
            Button step = (Button)item.findViewById(R.id.button3);
            step.setText("step "+(i+1));
            step.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getApplicationContext(),RecipStepsDetails.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("description",descriptions.get(i));
                    bundle.putString("videoUrl",videoUrls.get(i));
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
            });
            return item;
        }
    }
}
