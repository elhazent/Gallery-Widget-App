package com.elhazent.picodiploma.stackwidgetapp;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.RemoteViews;
import android.widget.RemoteViewsService;

import java.util.ArrayList;
import java.util.List;

public class StackRemoteViewsFactory implements RemoteViewsService.RemoteViewsFactory{

    private final List<Bitmap> mWidgetItems = new ArrayList<>();
    private final Context mContext;

    StackRemoteViewsFactory(Context context) {
        mContext = context;
    }

    @Override
    public void onCreate() {

    }

    @Override
    public void onDataSetChanged() {
        mWidgetItems.add(BitmapFactory.decodeResource(mContext.getResources(), R.drawable.images));
        mWidgetItems.add(BitmapFactory.decodeResource(mContext.getResources(), R.drawable.images));
        mWidgetItems.add(BitmapFactory.decodeResource(mContext.getResources(), R.drawable.images));
        mWidgetItems.add(BitmapFactory.decodeResource(mContext.getResources(), R.drawable.images));
        mWidgetItems.add(BitmapFactory.decodeResource(mContext.getResources(), R.drawable.images));
    }

    @Override
    public void onDestroy() {

    }

    @Override
    public int getCount() {
        return mWidgetItems.size();
    }

    @Override
    public RemoteViews getViewAt(int position) {
        RemoteViews remote = new RemoteViews(mContext.getPackageName(), R.layout.widget_item);
        remote.setImageViewBitmap(R.id.imageView, mWidgetItems.get(position));

        Bundle extras = new Bundle();
        extras.putInt(ImageBannerWidget.EXTRA_ITEM, position);
        Intent fillInIntent = new Intent();
        fillInIntent.putExtras(extras);

        remote.setOnClickFillInIntent(R.id.imageView, fillInIntent);
        return remote;
    }

    @Override
    public RemoteViews getLoadingView() {
        return null;
    }

    @Override
    public int getViewTypeCount() {
        return 1;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }
}
