package com.amine.kids_learning;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.Button;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class Days extends AppCompatActivity {

    AlertDialog dialog;
    GridView grid_days;
    Button back,play;
    String name;
    MediaPlayer mp;
    Boolean is_clicked;
    int days[]={R.drawable.monday,R.drawable.tuesday,R.drawable.wednesday,R.drawable.thursday,R.drawable.friday,R.drawable.saturday,R.drawable.sunday};
    String day[]={"MONDAY","TUESDAY","WEDNESDAY","THURSDAY","FRIDAY","SATURDAY","SUNDAY"};
    int days_song = R.raw.daysoftheweeksong;
    public void init(){
        grid_days=findViewById(R.id.grid_days);
        back=findViewById(R.id.back_btn);
        play=findViewById(R.id.play_btn);
        Intent intent = getIntent();
        name=intent.getStringExtra("name");
        is_clicked = intent.getBooleanExtra("alert",false);
        if(!is_clicked){
            dialog= new AlertDialog.Builder(this).create();
            dialog.setTitle("DAYS OF THE WEEK!!");
            //
            dialog.setCancelable(false);
            dialog.setIcon(android.R.drawable.ic_dialog_info);
            dialog.setMessage("Click on each image to view the day's name then click the play button to play the DAYS OF THE WEEK SONG :)");
            dialog.setButton(AlertDialog.BUTTON_POSITIVE,"LET'S GOOO",(dialog,which)->{
                is_clicked=true;
            });
            dialog.show();
        }

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle("DAYS PARTY");
        setContentView(R.layout.activity_days);
        init();
        ///
        List<HashMap<String, String>> aList = new ArrayList<HashMap<String, String>>();
        for (int i = 0; i < days.length; i++) {
            HashMap<String, String> hm = new HashMap<String, String>();
            hm.put("days_img", Integer.toString(days[i]));
            hm.put("name",day[i]);
            aList.add(hm);
        }
        String[] from = {"days_img","name"};
        int[] to = {R.id.days_img};
        SimpleAdapter adapter = new SimpleAdapter(getApplicationContext(), aList, R.layout.days_list, from, to);
        grid_days.setAdapter(adapter);
        grid_days.setOnItemClickListener((parent, view, position, id)->{
               Toast t=Toast.makeText(this,"DAY : "+day[position],Toast.LENGTH_SHORT);
               t.show();
            System.out.println(day[position]);
        });
        play.setOnClickListener(v->{
            if (mp!=null)
                mp.stop();
            mp= MediaPlayer.create(getApplicationContext(), days_song);
            mp.start();
        });
        back.setOnClickListener(v->{
            Intent i1=new Intent(this,MainMenu.class);
            i1.putExtra("name", name);
            is_clicked=true;
            i1.putExtra("alert",is_clicked);
            startActivity(i1);
            if (mp!=null)
                mp.stop();
        });
    }
}