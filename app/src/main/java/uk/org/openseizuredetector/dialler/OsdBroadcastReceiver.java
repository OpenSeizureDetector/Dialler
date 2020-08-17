package uk.org.openseizuredetector.dialler;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class OsdBroadcastReceiver extends BroadcastReceiver {
    private String TAG = "OsdBroadcastReceiver";
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.v(TAG,"onReceive()");
        if ("uk.org.openseizuredetector.dialler.ALARM".equals(intent.getAction())) {
            Log.v(TAG,"Received ALARM broadcast");
            String[] NumbersArr = intent.getStringArrayExtra("NUMBERS");
            String receivedText = "";
            for (int i=0;i<NumbersArr.length;i++) {
                receivedText = receivedText + NumbersArr[i]+", ";
            }
            Log.v(TAG,"Numbers="+receivedText);

            context.getSystemService()
        }
    }
}
