package com.amine.kids_learning;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.Button;
import android.widget.GridView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Numbers extends AppCompatActivity {

    GridView grid;
    MediaPlayer mp;
    Button btn;
    AlertDialog dialog;
    Boolean is_clicked;
    String[] num_lol ={"Zero"," one","two", "three","four", "five", "six", "Sep 7", "eight", "nine", "ten",
            "eleven","twelve", "thirteen","fourteen","fifteen","sixteen","seventeen","eighteen","nineteen","twenty"};
    String[] num = new String[num_lol.length];
    ////
    int num_img[]={R.drawable.a0,R.drawable.a1,R.drawable.a2,R.drawable.a3,R.drawable.a4,R.drawable.a5,R.drawable.a6,
            R.drawable.a7,R.drawable.a8,R.drawable.a9,R.drawable.a10,R.drawable.a11,R.drawable.a12,R.drawable.a13,
            R.drawable.a14,R.drawable.a15,R.drawable.a16,R.drawable.a17,R.drawable.a18,R.drawable.a19,R.drawable.a20};
    int num_sound[]={R.raw.b0,R.raw.b1,R.raw.b2,R.raw.b3,R.raw.b4,R.raw.b5,R.raw.b6,R.raw.b7,R.raw.b8,R.raw.b9,R.raw.b10,
            R.raw.b11,R.raw.b12,R.raw.b13,R.raw.b14,R.raw.b15,R.raw.b16,R.raw.b17,R.raw.b18,R.raw.b19,R.raw.b20};
    String name;
    public void init(){
        Intent intent = getIntent();
        name=intent.getStringExtra("name");
        grid=findViewById(R.id.grid);
        btn =findViewById(R.id.back_btn);
        for (int i = 0; i < num_lol.length; i++)
        {
            num[i]=num_lol[i].toUpperCase();
        }
        is_clicked = intent.getBooleanExtra("alert",false);
        if(!is_clicked){
            dialog= new AlertDialog.Builder(this).create();
            dialog.setTitle("NUMBERS!!");
            //
            dialog.setCancelable(false);
            dialog.setIcon(android.R.drawable.ic_dialog_info);
            dialog.setMessage("Just Click on the image and you will hear the numbers ! :)");
            dialog.setButton(AlertDialog.BUTTON_POSITIVE,"LET'S GOOO",(dialog,which)->{
                is_clicked=true;
            });
            dialog.show();
        }

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle("NUMBER ¨PARTY");
        setContentView(R.layout.activity_numbers);
        init();
        ///
        List<HashMap<String, String>> aList = new ArrayList<HashMap<String, String>>();
        for (int i = 0; i < num.length; i++) {
            HashMap<String, String> hm = new HashMap<String, String>();
            hm.put("num_img", Integer.toString(num_img[i]));
            hm.put("name",num[i]);
            aList.add(hm);
        }
        String[] from = {"num_img","name"};
        int[] to = {R.id.num_img,R.id.num_text};
        SimpleAdapter adapter = new SimpleAdapter(getApplicationContext(), aList, R.layout.list_numbers, from, to);
        grid.setAdapter(adapter);
        ///
        grid.setOnItemClickListener((parent, view, position, id) -> {
            if (mp!=null)
                mp.stop();
            mp= MediaPlayer.create(getApplicationContext(), num_sound[position]);
            mp.start();
        });
        //
        btn.setOnClickListener(v->{
            Intent i1=new Intent(this,MainMenu.class);
            i1.putExtra("name", name);
            is_clicked=true;
            i1.putExtra("alert",is_clicked);
            startActivity(i1);
        });
    }
}