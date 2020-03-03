package com.example.getdatafaromdatabase;

import android.app.AlertDialog;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import retrofit.RestAdapter;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DatabaseAdapter extends  ArrayAdapter<MyGuest> {





    public String  Tag="DatabaseAdapter";

    private List<MyGuest> myGuestArrayList;
    Context mContext;

    //    SQLiteDatabase db = mydb.getWritableDatabase();
    ListView listView;



    // View lookup cache
    private static class ViewHolder {
        TextView listviewsampleitems;
        TextView listviewsampleitems2;
        TextView listviewsampleitems3;

    }

    public DatabaseAdapter(List<MyGuest> myGuestArrayList, Context context) {

        super(context, R.layout.listitemsample, myGuestArrayList);

        this.myGuestArrayList = myGuestArrayList;
        this.mContext=context;

    }


    public MyGuest getItem(int position) {
        return myGuestArrayList.get(position);
    }



    private int lastPosition = -1;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final MyGuest guest=getItem(position);
        final ViewHolder viewHolder;

        final View result;

        if (convertView == null) {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.listitemsample, parent, false);
            viewHolder.listviewsampleitems = convertView.findViewById(R.id.listviewsampleitem);
            viewHolder.listviewsampleitems2 = convertView.findViewById(R.id.listviewsampleitem2);
            viewHolder.listviewsampleitems3 = convertView.findViewById(R.id.listviewsampleitem3);



            result=convertView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result=convertView;
        }


        viewHolder.listviewsampleitems.setText(guest.getFirstname());
        viewHolder.listviewsampleitems2.setText(guest.getLastname());

        viewHolder.listviewsampleitems3.setText(guest.getEmail());


        // Return the completed view to render on screen
        return convertView;
    }

    }

