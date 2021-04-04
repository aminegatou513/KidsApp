package com.amine.kids_learning;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainMenu extends AppCompatActivity {

    TextView text;
    ImageView chiff,alpha,days,animals;
    String name;
    AlertDialog dialog;
    boolean is_clicked = false;
    public void init(){
        text=findViewById(R.id.textView);
        Intent intent=getIntent();
        intent.getExtras();
        name = intent.getStringExtra("name");
        is_clicked = intent.getBooleanExtra("alert",false);
        text.setText("Welcome "+name+ " TO\nEducating children    تربية الأطفال\nChoose what do you want to learn TODAY ");
        chiff=findViewById(R.id.num);
        alpha=findViewById(R.id.alpha);
        days=findViewById(R.id.days);
        animals=findViewById(R.id.animals);
        ///////////
        if(!is_clicked){
            dialog= new AlertDialog.Builder(this).create();
            dialog.setTitle("ARE YOU READY ?");
            //
            dialog.setCancelable(false);
            dialog.setIcon(android.R.drawable.ic_dialog_info);
            dialog.setMessage("Start by choosing what do you want to learn down BELLOW");
            dialog.setButton(AlertDialog.BUTTON_POSITIVE,"LET'S GOOO",(dialog,which)->{
                is_clicked=true;
            });
            dialog.show();
        }

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main_menu);
        init();
        animals.setOnClickListener(v->{
            Intent i1=new Intent(this,jungle.class);
            i1.putExtra("name", name);
            is_clicked=false;
            i1.putExtra("alert",is_clicked);
            startActivity(i1);
        });
        chiff.setOnClickListener(v->{
            Intent i1=new Intent(this,Numbers.class);
            i1.putExtra("name", name);
            is_clicked=false;
            i1.putExtra("alert",is_clicked);
            startActivity(i1);
        });
        days.setOnClickListener(v->{
            Intent i1=new Intent(this,Days.class);
            i1.putExtra("name", name);
            is_clicked=false;
            i1.putExtra("alert",is_clicked);
            startActivity(i1);
        });
        alpha.setOnClickListener(v->{
            Intent i1=new Intent(this,Alphabets.class);
            i1.putExtra("name", name);
            is_clicked=false;
            i1.putExtra("alert",is_clicked);
            startActivity(i1);
        });
    }
}