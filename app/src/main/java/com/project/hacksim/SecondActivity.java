package com.project.hacksim;

import android.app.FragmentManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import Data.*;

import java.util.ArrayList;


public class SecondActivity extends ActionBarActivity implements MyDialog.Communicator {

    public RunningApplication app;
    public ArrayList<Target> targetList;
    public int itemPosition;
    public ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        app = (RunningApplication) this.getApplication();
        targetList = app.targets;
        populateListView();

        RegisterOnCLickCallback();
    }

    private void RegisterOnCLickCallback() {
        ListView listview = (ListView) findViewById(R.id.listView1);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                itemPosition = position;
                showDialog();
            }
        });
    }

    public void populateListView(){
        ArrayAdapter<Target> adapter = new MyListAdapter();

        listview = (ListView) findViewById(R.id.listView1);
        listview.setAdapter(adapter);
    }

    @Override
    public void onDialogMessage(int type) {
        if(type > 0){
            Toast.makeText(this, "Target offline", Toast.LENGTH_SHORT).show();
            Target currentTarget = targetList.get(itemPosition);
            currentTarget.setStatus("Offline");
            int tempScore = app.usr.getScore();
            app.usr.setScore(tempScore + currentTarget.getReward());
            listview.refreshDrawableState();
        }
        else
        Toast.makeText(this, "No attack method selected", Toast.LENGTH_SHORT).show();
    }

    private class MyListAdapter extends ArrayAdapter<Target>{
        public MyListAdapter() {
            super(SecondActivity.this, R.layout.list_layout, targetList);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View itemView = convertView;
            if(itemView == null){
                itemView = getLayoutInflater().inflate(R.layout.list_layout, parent, false);
            }
            Target currentTarget = targetList.get(position);

            TextView nameTV = (TextView) itemView.findViewById(R.id.serverName);
            nameTV.setText(currentTarget.getName());

            TextView reqTV = (TextView) itemView.findViewById(R.id.serverReq);
            reqTV.setText("Diff:" + String.valueOf(currentTarget.getReq()));

            TextView rewardTV = (TextView) itemView.findViewById(R.id.serverReward);
            rewardTV.setText("Reward:"+String.valueOf(currentTarget.getReward()));

            TextView statusTV = (TextView) itemView.findViewById(R.id.serverStatus);
            statusTV.setText("Status:" + currentTarget.getStatus());

            return itemView;
            //return super.getView(position, convertView, parent);
        }
    }

    public void showDialog(){
        FragmentManager manager = getFragmentManager();
        MyDialog myDialog = new MyDialog();
        myDialog.show(manager, "dialog");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_second, menu);
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
}
