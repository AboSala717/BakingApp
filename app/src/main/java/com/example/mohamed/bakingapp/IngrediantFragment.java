package com.example.mohamed.bakingapp;

import android.support.v4.app.Fragment;
import android.content.ContentValues;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;

import com.google.gson.Gson;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static android.R.id.list;

/**
 * Created by mohamed on 6/5/2017.
 */

public class IngrediantFragment extends Fragment  {




    Context con ;


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Nullable
    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.ingrediants, container, false);

        /*        ****trying to inflate gridView in fragment but it can't be****

       GridView gridView = (GridView) view.findViewById(R.id.gridview);
       gridView.setAdapter(new IngrediantFragmentAdapter(con,MainActivity.currentRecip));
       */
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        TextView textView = (TextView)getActivity().findViewById(R.id.textView3);
        List grediants = MainActivity.currentRecip.getIngredients();
        String text = "";
        for (int i =1; i<=grediants.size(); i++){
            text=text+"  "+i+": "+grediants.get(i-1)+"\n"+"\n";
        }
        textView.setText(text);



    }

    private class IngrediantFragmentAdapter extends BaseAdapter{
        Context context;
        Recip recip ;
        public IngrediantFragmentAdapter(Context context,Recip recip) {
            this.context = context;
            this.recip = recip ;

        }

        @Override
        public int getCount() {
            return 0;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {

            LayoutInflater inflater = (LayoutInflater) context.getSystemService( Context.LAYOUT_INFLATER_SERVICE );
            View item = inflater.inflate(R.layout.ingrediantttext,viewGroup,false);
            TextView text = (TextView) item.findViewById(R.id.textView2);
            text.setText("fuck all");
            return null;
        }
    }
}
