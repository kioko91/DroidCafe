package com.example.droidcafe;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private String mOrderedMessage;
    public static final String EXTRA_ORDER_KEY="MY KEY FOR ORDER MESSAGE";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent intent=new Intent(MainActivity.this,OrderActivity.class);
               intent.putExtra(EXTRA_ORDER_KEY,mOrderedMessage);
               startActivity(intent);
            }
        });
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
        //int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        //if (id == R.id.action_settings) {
          //  return true;
       // }

        switch (item.getItemId()){
            case R.id.action_order:
                Intent intent=new Intent(MainActivity.this,OrderActivity.class);
                intent.putExtra(EXTRA_ORDER_KEY,mOrderedMessage);
                startActivity(intent);
                return true;

            case R.id.action_call:
                Uri myUri= Uri.parse("tel:0708767661");
                Intent myIntent=new Intent(Intent.ACTION_DIAL,myUri);
                startActivity(myIntent);
                return true;


        }


        return super.onOptionsItemSelected(item);
    }
    public void displayToast(String message){
        Toast.makeText(getApplicationContext(),message,Toast.LENGTH_SHORT).show();

    }

    public void showFroyoMessage(View view) {
        mOrderedMessage=getString(R.string.froyo_order);
        displayToast(mOrderedMessage);
    }

    public void showIcecreamMessage(View view) {
        mOrderedMessage=getString(R.string.ice_cream_order);
        displayToast(mOrderedMessage);
    }

    public void showDonutMessage(View view) {
        mOrderedMessage=getString(R.string.donut_order);
        displayToast(mOrderedMessage);
    }
}
