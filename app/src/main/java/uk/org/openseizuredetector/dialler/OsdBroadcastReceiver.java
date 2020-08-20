package uk.org.openseizuredetector.dialler;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.widget.Toast;

public class OsdBroadcastReceiver extends BroadcastReceiver {
    private final Context mContext;
    private String TAG = "OsdBroadcastReceiver";

    public OsdBroadcastReceiver(Context context) {
        mContext = context;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        /*
         Expects to receive an action uk.org.openseizuredetector.dialer.ALARM with extra data called NUMBERS which should be
          an array of strings, which are the phone numbers to dial.
          FIXME - at the moment this only dials the first number in the list, becasue this broadcast receiver exits
                  when the dialler app is opened - we really need to start a new activity that calls the dialler app for each number
                  in turn and checks if it is answered or not....and ideally plays a recorded message if successfully connected.
         */
        Log.v(TAG,"onReceive()");
        if ("uk.org.openseizuredetector.dialler.ALARM".equals(intent.getAction())) {
            Log.v(TAG,"Received ALARM broadcast");
            String[] NumbersArr = intent.getStringArrayExtra("NUMBERS");
            String receivedText = "";
            for (int i=0;i<NumbersArr.length;i++) {
                receivedText = receivedText + NumbersArr[i]+", ";
            }
            Log.v(TAG,"Numbers="+receivedText);

            for (int i=0;i<NumbersArr.length;i++) {
                Intent callIntent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + NumbersArr[i]));
                Log.v(TAG,"Calling "+NumbersArr[i]);
                mContext.startActivity(callIntent);
            }

        }
    }
}
