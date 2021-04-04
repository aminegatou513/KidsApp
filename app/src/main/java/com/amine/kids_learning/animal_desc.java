package com.amine.kids_learning;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class animal_desc extends AppCompatActivity {
    String animals[] = {"BEAR","ELEPHANT","KOALA","LION","MONKEY","TIGER"};
    Boolean is_clicked;
    int img[]= new int[]{
            R.drawable.bear,
            R.drawable.elephant,
            R.drawable.koala,
            R.drawable.lion,
            R.drawable.monkey,
            R.drawable.tiger
    };
    int sounds[]= new int[]{
            R.raw.bear,
            R.raw.elephant,
            R.raw.koala,
            R.raw.lion,
            R.raw.monkey,
            R.raw.tiger
    };
    String desc[] = new String[]{
        "Bears have large bodies, stocky legs, a long snout, shaggy hair, paws with claws, and a short tail. Even though bears are big and heavy, they can run very fast and are also good at climbing and swimming. Bears have a large brain and are one of the more intelligent mammals.",
        "Elephants belong to the mammal family, which means that they have hair, give birth to live young, and feed their babies milk. They have large, thin ears that are used to help cool them down, and have long, powerful trunks. ... Only the male Asian elephant has tusks. They also use their tusks to help dig for water.",
        "Koalas have thick, soft fur. Their ears have long, white hairs on the tips. They have a large, dark, leathery nose and beady eyes. They have a small mouth that can open very wide.",
        "Lions are large carnivorous mammals that belong to the family of felines. The have a tawny coat with a long tufted tail. Male lions have a large mane of darker colored fur surrounding its head and neck. Lions are the only cats that have this obvious difference between the males and the females.",
        "Monkeys are clever, social animals. They are known for running and leaping through trees with ease. Like apes and humans, monkeys belong to the group of mammals called primates. Monkeys look somewhat like apes such as chimpanzees, orangutans, and gorillas.",
        "A Tiger is a powerful carnivore, a hunter with sharp teeth, strong jaws, and a very agile body. They are the largest naturally occurring species of cat, of which the Siberian tiger is the largest, weighing up to 800 pounds and measuring up to 11 feet head to tail."
    };
    TextView text;
    ImageView image,back,play;
    MediaPlayer mp;
    public void init(){
        text=findViewById(R.id.details);
        image=findViewById(R.id.img);
        back=findViewById(R.id.back);
        play=findViewById(R.id.play);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String name = getIntent().getStringExtra("name");
        int ID= getIntent().getIntExtra("animalIndex",1);
        is_clicked = getIntent().getBooleanExtra("alert",false);
        getSupportActionBar().setTitle(animals[ID]);
        setContentView(R.layout.activity_animal_desc);
        init();

        text.setText(desc[ID]);
        image.setImageResource(img[ID]);
        ////
        play.setOnClickListener(v->{
            if (mp!=null)
                mp.stop();
            mp= MediaPlayer.create(getApplicationContext(), sounds[ID]);
            mp.start();
        });
        ///
        back.setOnClickListener(v->{
            if (mp!=null)
                mp.stop();
            Intent i1=new Intent(this,jungle.class);
            i1.putExtra("name", name);
            is_clicked=true;
            i1.putExtra("alert",is_clicked);
            startActivity(i1);
        });
    }
}