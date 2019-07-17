package com.example.googlecodelabs;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private String mOrder=null;
    public static final String ORDER_KEY="orderKey";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.main_toolbar);
        setSupportActionBar(toolbar);

        final FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent fabIntent=new Intent(MainActivity.this,OrderActivity.class);
                fabIntent.putExtra(ORDER_KEY,mOrder);
                startActivity(fabIntent);
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
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        switch (id){
            case R.id.info:
                Toast.makeText(this,"Displaying Information",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.m_new_service:
                Toast.makeText(this,"Starting new Service",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.m_service_tasks:
                Toast.makeText(this,"Service Tasks",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.m_sign_out:
                Toast.makeText(this,"Signing out",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.m_new_project:
                Toast.makeText(this,"Starting new project",Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    public void displayToast(String message){
        Toast.makeText(getApplicationContext(),message,Toast.LENGTH_SHORT).show();
    }

    public void showFroyoOrder(View view) {
        displayToast(getResources().getString(R.string.froyo_order_message));
        mOrder=getResources().getString(R.string.froyo_order_message);
    }

    public void showIceCreamOrder(View view) {
        displayToast(getResources().getString(R.string.ice_cream_order_message));
        mOrder=getResources().getString(R.string.ice_cream_order_message);
    }

    public void showDonutOrder(View view) {
        displayToast(getResources().getString(R.string.donut_order_message));
        mOrder=getResources().getString(R.string.donut_order_message);
    }
}
