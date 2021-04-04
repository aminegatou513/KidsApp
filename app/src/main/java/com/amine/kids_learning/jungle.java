package com.amine.kids_learning;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class jungle extends AppCompatActivity {

    AlertDialog dialog;
    Button back;
    String name;
    GridView grid;
    Boolean is_clicked;
    int img[]= new int[]{
            R.drawable.bear,
            R.drawable.elephant,
            R.drawable.koala,
            R.drawable.lion,
            R.drawable.monkey,
            R.drawable.tiger
    };
    public void init(){
        back=findViewById(R.id.btn3);
        grid=findViewById(R.id.grid2);
        Intent intent = getIntent();
        name=intent.getStringExtra("name");
        is_clicked = intent.getBooleanExtra("alert",false);
        if(!is_clicked){
            dialog= new AlertDialog.Builder(this).create();
            dialog.setTitle("Welcome to the JUNGLE!!");
            //
            dialog.setCancelable(false);
            dialog.setIcon(android.R.drawable.ic_dialog_info);
            dialog.setMessage("CLICK on each animal to view it's description and hear it sound. :)");
            dialog.setButton(AlertDialog.BUTTON_POSITIVE,"LET'S GOOO",(dialog,which)->{
                is_clicked=true;
            });
            dialog.show();
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle("Welcome to the jungle");
        setContentView(R.layout.activity_jungle);
        init();
        List<HashMap<String, String>> aList = new ArrayList<HashMap<String, String>>();
        for (int i = 0; i < img.length; i++) {
            HashMap<String, String> hm = new HashMap<String, String>();
            hm.put("flag", Integer.toString(img[i]));
            aList.add(hm);
        }
        String[] from = {"flag"};
        int[] to = {R.id.flag};
        SimpleAdapter adapter = new SimpleAdapter(getApplicationContext(), aList, R.layout.animal_list, from, to);
        grid.setAdapter(adapter);
        grid.setOnItemClickListener((parent, view, position, id) -> {
            Intent i= new Intent(getApplicationContext(),animal_desc.class);
            i.putExtra("animalIndex",position);
            i.putExtra("name",name);
            is_clicked=true;
            i.putExtra("alert",is_clicked);
            startActivity(i);
        });
        ///
        back.setOnClickListener(v->{
            Intent i1=new Intent(this,MainMenu.class);
            i1.putExtra("name", name);
            is_clicked=true;
            i1.putExtra("alert",is_clicked);
            startActivity(i1);
        });
    }
}