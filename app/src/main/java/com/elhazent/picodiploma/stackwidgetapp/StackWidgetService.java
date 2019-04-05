package com.elhazent.picodiploma.stackwidgetapp;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.RemoteViewsService;

public class StackWidgetService extends RemoteViewsService {


    @Override
    public RemoteViewsFactory onGetViewFactory(Intent intent) {
        return new StackRemoteViewsFactory(this.getApplicationContext());
    }
}
