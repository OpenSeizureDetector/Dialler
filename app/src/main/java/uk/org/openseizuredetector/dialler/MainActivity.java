package uk.org.openseizuredetector.dialler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private String TAG = "Dialler.MainActivity";
    private boolean mPermissionsRequested = false;
    private Button uninstallBtn;

    private final String[] REQUIRED_PERMISSIONS = {
            Manifest.permission.CALL_PHONE,
            Manifest.permission.READ_PHONE_STATE,
            Manifest.permission.READ_CALL_LOG
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        uninstallBtn = (Button)findViewById(R.id.uninstall_button);
        uninstallBtn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Log.v(TAG, "Uninstall button clicked");
                        try {
                            Intent intent = new Intent(Intent.ACTION_DELETE);
                            intent.setData(Uri.parse("package:uk.org.openseizuredetector.dialler"));
                            startActivity(intent);
                        } catch (Exception ex) {
                            Log.v(TAG, "exception starting uninstall activity " + ex.toString());
                        }

                    }
                }
        );

        OsdBroadcastReceiver br = new OsdBroadcastReceiver(this);
        IntentFilter filter = new IntentFilter("uk.org.openseizuredetector.dialler.ALARM");
        this.registerReceiver(br, filter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        requestPermissions();
    }


    public void requestPermissions() {
        if (mPermissionsRequested) {
            Log.i(TAG,"requestPermissions() - request already sent - not doing anything");
        } else {
            Log.i(TAG, "requestPermissions() - requesting permissions");
            for (int i = 0; i < REQUIRED_PERMISSIONS.length; i++) {
                if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                        REQUIRED_PERMISSIONS[i])) {
                    Log.i(TAG, "shouldShowRationale for permission" + REQUIRED_PERMISSIONS[i]);
                }
            }
            ActivityCompat.requestPermissions(this,
                    REQUIRED_PERMISSIONS,
                    42);
            mPermissionsRequested = true;
        }
    }


}