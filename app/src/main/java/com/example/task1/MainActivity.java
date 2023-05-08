package com.example.task1;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    RecyclerView mRecyclerViewAdapter;
    @SuppressLint("UseSwitchCompatOrMaterialCode")
    Switch mswitch;
    SearchView msearchView;
    ArrayList<String> students = new ArrayList<>();

    private Object buttonView;

    public void generateDataInRecyclerView() {


        String[] studentsName = {"Rahaman","khaja moin","prany","shradha","charan tej","shubham","phani","yousef","thrinadh","nithisha","hemanth","namitha","siddhartha","anjali","shravani","shashi",
                "pavan","manoj","rohith","sharath","praveen","shailaja Reddy","sagar","sanveej","balaram","vishnu","manish","yaswanth","shivani krishna","yamini","sheeresha","deepak","suraj","shivani"
                ,"pojitha","bhargavi","mittu","gnanika","sunil" , "vinay","hafeez","nagraj","mahesh","suresh","ramesh","naveen","balaji","","manikanta", "vikram", "mahesh", "Priya", "manoj", "chandu", "umesh", "nitesh", "rohith", "Srikanth", "durga", "Sai"};
        students.addAll(0, Arrays.asList(studentsName));

        mRecyclerViewAdapter.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerViewAdapter.setAdapter(new RecyclerViewAdapter(students, this));


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mswitch = findViewById(R.id.permission);
        msearchView = findViewById(R.id.searchView2);






        msearchView.clearFocus();
        msearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                filterList(newText);

                return false;

            }
        });
        mRecyclerViewAdapter = findViewById(R.id.recyclerView);

        generateDataInRecyclerView();
        mswitch.setOnCheckedChangeListener(this);
    }

    private int filterList(String text) {
        List<String> filteredList = new ArrayList<>();
        for (String item : students) {
            if (item.contains(text)) {
                filteredList.add(item);
            }
        }
            if (filteredList.isEmpty()) {
                Toast.makeText(this, "no student with this name", Toast.LENGTH_SHORT).show();
                Log.i("results","no student found");

            } else {
                mRecyclerViewAdapter.setAdapter(new RecyclerViewAdapter(filteredList, this));
            }

            return 0;

        }


    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if(isChecked)
        {

           msearchView.setVisibility(View.VISIBLE);
        }
        else
        {
         msearchView.setVisibility(View.INVISIBLE);

        }
    }
}