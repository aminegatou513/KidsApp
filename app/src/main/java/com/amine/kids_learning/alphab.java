package com.amine.kids_learning;


import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class alphab extends AppCompatActivity {
    int id ;
    ImageView mg,back;
    Boolean is_clicked;
    String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alpha);
        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        name=intent.getStringExtra("name");
        String message = intent.getStringExtra("alpha_name").toLowerCase();
        is_clicked = getIntent().getBooleanExtra("alert",false);
        Toast.makeText(getApplicationContext(),message, Toast.LENGTH_SHORT).show();
        mg = findViewById(R.id.imageView2);
        back=findViewById(R.id.imageView);
        id = alphab.this.getResources().getIdentifier(message,"drawable",alphab.this.getPackageName());
        mg.setImageResource(id);
        back.setImageResource(R.drawable.back);
        //
        back.setOnClickListener(v->{
            Intent i1=new Intent(this,Alphabets.class);
            i1.putExtra("name", name);
            is_clicked=true;
            i1.putExtra("alert",is_clicked);
            startActivity(i1);
        });
    }
}
