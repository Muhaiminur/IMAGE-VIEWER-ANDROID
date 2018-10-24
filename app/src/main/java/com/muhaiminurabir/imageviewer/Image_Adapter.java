package com.muhaiminurabir.imageviewer;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.ceylonlabs.imageviewpopup.ImagePopup;
import com.github.chrisbanes.photoview.PhotoView;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;
import java.util.List;

public class Image_Adapter extends RecyclerView.Adapter<Image_Adapter.MyViewHolder> {

    private List<Integer>image_list=new ArrayList<>();

    ImageLoader imageLoader;
    Context context;

    int scaleSize =1024;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public PhotoView mb;
        Button fullscreen;

        //PhotoView photoView = (PhotoView) findViewById(R.id.photo_view);
        public MyViewHolder(View view) {
            super(view);
            mb=(PhotoView) view.findViewById(R.id.imageView);
            fullscreen=view.findViewById(R.id.full_screen);
        }
    }


    public Image_Adapter(List<Integer> moviesList,Context c) {
        //this.image_list= moviesList;
        image_list=new ArrayList<Integer>();
        image_list.add(R.drawable.one1);
        image_list.add(R.drawable.one2);
        image_list.add(R.drawable.one3);
        image_list.add(R.drawable.one4);
        image_list.add(R.drawable.one5);
        image_list.add(R.drawable.one6);
        image_list.add(R.drawable.one7);
        image_list.add(R.drawable.one8);
        image_list.add(R.drawable.one9);
        image_list.add(R.drawable.one10);
        image_list.add(R.drawable.one11);
        image_list.add(R.drawable.one12);
        image_list.add(R.drawable.one13);
        image_list.add(R.drawable.one14);
        context=c;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.image_view, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder,final int position) {
        int img = image_list.get(position);

        /*Bitmap b=drawableToBitmap(context.getResources().getDrawable(image_list.get(position)));
        Bitmap bin=resizeImageForImageView(b);
        Drawable d = new BitmapDrawable(context.getResources(), bin);

        final ImagePopup imagePopup = new ImagePopup((Activity)context);
        //imagePopup.initiatePopup(context.getResources().getDrawable(image_list.get(position)));
        imagePopup.initiatePopup(d);*/
        /*imagePopup.setWindowHeight(800); // Optional
        imagePopup.setWindowWidth(800); // Optional
        imagePopup.setBackgroundColor(Color.BLACK);  // Optional
        imagePopup.setFullScreen(true); // Optional
        imagePopup.setHideCloseIcon(true);  // Optional
        imagePopup.setImageOnClickClose(true);  // Optional*/
        /*Glide.with(context)
                .load(image_list.get(position))
                .thumbnail( 0.1f )
                .into(holder.mb);*/

        /*Glide.with(context).load(image_list.get(position))
                .thumbnail(0.5f)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.mb);*/
        GlideApp.with(context)
                .load(image_list.get(position))
                .placeholder(R.mipmap.ic_launcher)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.mb);
        holder.mb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //imagePopup.viewPopup();
            }
        });
        holder.fullscreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(context,FullScreenImageActivity.class);
                i.putExtra("image_id",image_list.get(position));
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return image_list.size();
    }
    @Override
    public int getItemViewType(int position) {
        return position;
    }

    public static Bitmap drawableToBitmap (Drawable drawable) {
        Bitmap bitmap = null;

        if (drawable instanceof BitmapDrawable) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            if(bitmapDrawable.getBitmap() != null) {
                return bitmapDrawable.getBitmap();
            }
        }

        if(drawable.getIntrinsicWidth() <= 0 || drawable.getIntrinsicHeight() <= 0) {
            bitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888); // Single color bitmap will be created of 1x1 pixel
        } else {
            bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        }

        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return bitmap;
    }
    public Bitmap resizeImageForImageView(Bitmap bitmap) {
        Bitmap resizedBitmap = null;
        int originalWidth = bitmap.getWidth();
        int originalHeight = bitmap.getHeight();
        int newWidth = -1;
        int newHeight = -1;
        float multFactor = -1.0F;
        if(originalHeight > originalWidth) {
            newHeight = scaleSize ;
            multFactor = (float) originalWidth/(float) originalHeight;
            newWidth = (int) (newHeight*multFactor);
        } else if(originalWidth > originalHeight) {
            newWidth = scaleSize ;
            multFactor = (float) originalHeight/ (float)originalWidth;
            newHeight = (int) (newWidth*multFactor);
        } else if(originalHeight == originalWidth) {
            newHeight = scaleSize ;
            newWidth = scaleSize ;
        }
        resizedBitmap = Bitmap.createScaledBitmap(bitmap, newWidth, newHeight, false);
        return resizedBitmap;
    }

}