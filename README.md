# OpenSeizureDetector Dialler
An Emergency Dialller App that is called from the main OpenSeizureDetector Android App to raise phone based alarms.

Version 3.5 of the [OpenSeizureDetector Android App](https://github.com/OpenSeizureDetector/Android_Pebble_SD/tree/V3.5) introduces Phone call alerts 
when a seizure is detected in addition to the existing alerts using SMS text messages or wifi.

The OpenSeizureDetector Android app does not in itself generate the phone call alerts - it sends a message to this app, OpenSeizueDetector Dialler, requesting it
to generate the phone call alerts.

OpenSeizureDetector Dialler is a simple app that listens for a broadcast from the main OpenSeizureDetector app and dials the specified telephone numbers when
requested by that app.

NOTE:  It just dials the number, opening an audio communications channel between the user's phone and whoever is in the contacts list.

There are obvious privacy issues with this approach, so the App displays a warning when it is started and offers the user the option of uninstalling the app to avoid 
the possibility of it initiating phone calls on the user's behalf.
