package com.muhaiminurabir.imageviewer;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.nostra13.universalimageloader.cache.memory.impl.WeakMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity{
    RecyclerView mRecyclerView;
    List<Integer>imaList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // UNIVERSAL IMAGE LOADER SETUP
        DisplayImageOptions defaultOptions = new DisplayImageOptions.Builder()
                .resetViewBeforeLoading(true)
                .cacheOnDisk(true)
                .cacheInMemory(true)
                .imageScaleType(ImageScaleType.EXACTLY)
                .displayer(new FadeInBitmapDisplayer(300))
                .build();

        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(getApplicationContext())
                .defaultDisplayImageOptions(defaultOptions)
                .memoryCache(new WeakMemoryCache())
                .diskCacheSize(100 * 1024 * 1024)
                .build();

        ImageLoader.getInstance().init(config);
        // END - UNIVERSAL IMAGE LOADER SETUP

        mRecyclerView = findViewById(R.id.recyclerView);
        imaList=new ArrayList<Integer>();
        imaList.add(R.drawable.one1);
        imaList.add(R.drawable.one2);
        imaList.add(R.drawable.one3);
        imaList.add(R.drawable.one4);
        imaList.add(R.drawable.one5);
        imaList.add(R.drawable.one6);
        imaList.add(R.drawable.one7);
        imaList.add(R.drawable.one8);
        imaList.add(R.drawable.one9);
        imaList.add(R.drawable.one10);
        imaList.add(R.drawable.one11);
        imaList.add(R.drawable.one12);
        imaList.add(R.drawable.one13);
        imaList.add(R.drawable.one14);
        Image_Adapter adapter = new Image_Adapter(imaList,MainActivity.this);
        mRecyclerView.setAdapter(adapter);
        GridLayoutManager manager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(manager);
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Unregister the adapter.
        // Because the RecyclerView won't unregister the adapter, the
        // ViewHolders are very likely leaked.
        mRecyclerView.setAdapter(null);
    }
}
