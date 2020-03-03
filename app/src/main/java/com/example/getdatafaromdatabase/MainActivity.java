package com.example.getdatafaromdatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import retrofit.RestAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    MyGuest[] myGuests=new MyGuest[0];
    private ListView listitem;
    final String Tag = "MainActivity";
    Context context;

    ArrayList<MyGuest> myGuestArrayList = new ArrayList<>();
    List<MyGuest> posts=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listitem = findViewById(R.id.list_item);
        context = MainActivity.this;
        final Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://100.43.0.37/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        final Interface anInterface = retrofit.create(Interface.class);
        Call<List<MyGuest>>  call=anInterface.getPosts();
        call.enqueue(new Callback<List<MyGuest>>() {
            @Override
            public void onResponse(Call<List<MyGuest>> call, Response<List<MyGuest>> response) {
                if (!response.isSuccessful()) {
                    return;
                }
                posts = response.body();
                Log.i(Tag,"inside api listsize " + posts.size() );
                DatabaseAdapter databaseAdapter = new DatabaseAdapter(posts,context);
                listitem.setAdapter( databaseAdapter);
            }

            @Override
            public void onFailure(Call<List<MyGuest>> call, Throwable t) {
                Log.i(Tag,"" + t.getMessage());

            }
        });


 }
}