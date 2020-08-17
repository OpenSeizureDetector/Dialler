package uk.org.openseizuredetector.dialler;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        OsdBroadcastReceiver br = new OsdBroadcastReceiver();
        IntentFilter filter = new IntentFilter("uk.org.openseizuredetector.dialler.ALARM");
        this.registerReceiver(br, filter);
    }
}