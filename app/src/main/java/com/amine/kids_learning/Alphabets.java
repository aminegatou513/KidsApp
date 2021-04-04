package com.amine.kids_learning;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.VideoView;

public class Alphabets extends AppCompatActivity {

    Boolean is_clicked;
    String name;
    GridView grid;
    AlertDialog dialog;
    int i;
    VideoView vd;
    ImageView mg,back_img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle("Alphabet Party ");
        setContentView(R.layout.activity_alphabets);
        Intent intent = getIntent();
        name=intent.getStringExtra("name");
        is_clicked = intent.getBooleanExtra("alert",false);
        if(!is_clicked){
            dialog= new AlertDialog.Builder(this).create();
            dialog.setTitle("Welcome to the Alphabet world!!");
            //
            dialog.setCancelable(false);
            dialog.setIcon(android.R.drawable.ic_dialog_info);
            dialog.setMessage("CLICK on each alphabet to view an exemple or play the video bellow  :) HAPPY LEARNING");
            dialog.setButton(AlertDialog.BUTTON_POSITIVE,"OK",(dialog,which)->{
                is_clicked=true;
            });
            dialog.show();
        }
        mg = findViewById(R.id.img);
        back_img=findViewById(R.id.back_img);
        vd = findViewById(R.id.vd);
        Uri uri = Uri.parse("android.resource://" + getPackageName() +"/raw/"+R.raw.alapha);
        vd.setVideoURI(uri);
        MediaController mediaController = new MediaController(this);
        vd.setMediaController(mediaController);


        grid = findViewById(R.id.gridview);
        String[] list = new String[26];
        int j = 65;
        for (i= 0; i<26;i++){
            list[i] = Character.toString((char) j);
            j++;
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, list);
        grid.setAdapter(adapter);
        grid.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent1 = new Intent(getApplicationContext(),alphab.class);
            intent1.putExtra( "alpha_name", list[position]);
            intent1.putExtra("name",name);
            is_clicked=true;
            intent1.putExtra("alert",is_clicked);
            startActivity(intent1);
        });
        back_img.setOnClickListener(v->{
            Intent i1=new Intent(this,MainMenu.class);

            i1.putExtra("name", name);
            is_clicked=true;
            i1.putExtra("alert",is_clicked);
            startActivity(i1);
        });
        /*
        *
        * in back button put this
        *   Intent i1=new Intent(this,MainMenu.class);
            i1.putExtra("name", name);
            is_clicked=true;
            i1.putExtra("alert",is_clicked);
            startActivity(i1);
        * */
    }
}