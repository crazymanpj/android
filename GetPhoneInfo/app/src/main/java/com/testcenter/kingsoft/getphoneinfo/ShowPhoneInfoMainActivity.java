package com.testcenter.kingsoft.getphoneinfo;
import android.graphics.Point;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.telephony.TelephonyManager;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;


public class ShowPhoneInfoMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_phone_info_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        Util util = new Util();
        String systemverion = util.getsystemversion();
        TextView textview1 = (TextView)findViewById(R.id.TEXTVEIW1);
        textview1.setText("android系统版本为：" + systemverion);
        String phonemodel = util.getPhoneType();
        TextView textview2 = (TextView)findViewById(R.id.TEXTVEIW2);
        textview2.setText("手机型号为：" + phonemodel);

        WindowManager windowManager = getWindowManager();
        Display display = windowManager.getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x;
        int height = size.y;
        TextView textview3 = (TextView)findViewById(R.id.TEXTVEIW3);
        textview3.setText("手机分辨率为：" + height + "*" + width);

        String brand = util.getBrand();
        TextView textview4 = (TextView)findViewById(R.id.TEXTVEIW4);
        textview4.setText("系统定制商为：" + brand);

        String manufacturer = util.getManufacturer();
        TextView textview5 = (TextView)findViewById(R.id.TEXTVEIW5);
        textview5.setText("硬件制造商为：" + manufacturer);

        TelephonyManager tm = (TelephonyManager)this.getSystemService(TELEPHONY_SERVICE);
        String imei = tm.getDeviceId();
        TextView textview6 = (TextView)findViewById(R.id.TEXTVEIW6);
        textview6.setText("IMEI号为：" + imei);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_show_phone_info_main, menu);
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
