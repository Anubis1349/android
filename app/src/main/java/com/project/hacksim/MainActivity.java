package com.project.hacksim;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.*;
import android.app.*;
import android.content.*;
import android.widget.*;
import android.util.*;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Random;

import Data.Target;
import Data.Uporabnik;


public class MainActivity extends ActionBarActivity {

    public RunningApplication app;
    public ArrayList<Target> targetList = new ArrayList<Target>();
    public Target[] testList = new Target[10];
    public Uporabnik user = new Uporabnik("test", "nekaj", 1234);

    public void PopulateList(ArrayList<Target> list){
        Random rand = new Random();
        for(int i=0;i <10; i++){
            String name = rand.nextInt(256)+"."+rand.nextInt(256)+"."+rand.nextInt(256)+"."+rand.nextInt(256);
            Target tmp = new Target(rand.nextInt(200)+50, name, rand.nextInt(1000)+500, "Online");
            //testList[i] = tmp;
            targetList.add(tmp);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {




        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        app = (RunningApplication) this.getApplication();
        PopulateList(targetList);
        app.targets = targetList;
        app.usr = user;


        try {
            Gson gson = new Gson();
            File myFile = new File("/sdcard/" + RunningApplication.IME_DAT);
            FileInputStream fIn = new FileInputStream(myFile);
            BufferedReader myReader = new BufferedReader(new InputStreamReader(fIn));
            String aDataRow = "";
            String aBuffer = ""; //Holds the text
            while ((aDataRow = myReader.readLine()) != null) {
                aBuffer += aDataRow;
            }
            myReader.close();
            user = gson.fromJson(aBuffer, Uporabnik.class);
            //Toast.makeText(this, user.toString(), Toast.LENGTH_LONG).s
        }
        catch(IOException e){
            Toast.makeText(this, e.toString(), Toast.LENGTH_LONG).show();
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void Vnos(View v){
        //EditText et = (EditText)findViewById(R.id.editText1);
        //app.test = et.getText().toString();
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        startActivity(intent);
        //finish();
    }

    public void Exit(View v ) {
        Gson gson = new Gson();
        String s = gson.toJson(user);



        try {
            File myFile = new File("/sdcard/"+RunningApplication.IME_DAT);
            myFile.createNewFile();
            FileOutputStream fOut = new FileOutputStream(myFile);
            OutputStreamWriter myOutWriter =new OutputStreamWriter(fOut);
            myOutWriter.append(s);
            myOutWriter.close();
            fOut.close();
            this.finish();
        } catch (IOException e) {
            Toast.makeText(this, e.toString(), Toast.LENGTH_LONG).show();
        }




    }
}
