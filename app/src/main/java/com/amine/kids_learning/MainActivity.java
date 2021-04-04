package com.amine.kids_learning;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
TextView wlcm_txt ;
Button start;
AlertDialog dialog;
public void init(){
    wlcm_txt = findViewById(R.id.welcome_text);
    wlcm_txt.setText("Welcome to our App\n Start Learning today with an enjoyable environnement.\nHappy To See You Around.\n\nAlright Then! LET'S GET STARTED");
    wlcm_txt.setPadding(0, 500, 0, 30);
    //
    start= findViewById(R.id.start);

}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
        init();
        start.setOnClickListener(v->{
            dialog= new AlertDialog.Builder(this).create();
            dialog.setTitle("Confirm your name?");
            //EDIT TEXT CONFIGURATION
            final EditText text = new EditText(this);
            text.setInputType(InputType.TYPE_CLASS_TEXT);
            text.setHint("Your name here");
            //
            dialog.setView(text);
            dialog.setCancelable(false);
            dialog.setIcon(android.R.drawable.ic_dialog_info);
            dialog.setMessage("Write your name here");
            dialog.setButton(AlertDialog.BUTTON_POSITIVE,"Confirm ", (dialog, which) -> {
                //System.out.println("NAAAAAAAAAME: "+text.getText().toString());
                if (text.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(),"Provide your name please",Toast.LENGTH_SHORT).show();
                }else{
                    String name=text.getText().toString();
                    Intent i1= new Intent(getApplicationContext(),MainMenu.class);
                    i1.putExtra("name",name);
                    startActivity(i1);
                }
            });
            dialog.setButton(AlertDialog.BUTTON_NEGATIVE,"Cancel",(dialog, which)-> {});
            dialog.setButton(AlertDialog.BUTTON_NEUTRAL,"DISMISS",(dialog, which)-> {});
            dialog.show();
        });

            /*Intent i1= new Intent(getApplicationContext(),Activity.class);
            startActivity(i1);*/
    }
}