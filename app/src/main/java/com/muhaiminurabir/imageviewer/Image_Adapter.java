package com.muhaiminurabir.imageviewer;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.ceylonlabs.imageviewpopup.ImagePopup;
import com.github.chrisbanes.photoview.PhotoView;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;
import java.util.List;

public class Image_Adapter extends RecyclerView.Adapter<Image_Adapter.MyViewHolder> {

    private List<Integer>image_list=new ArrayList<>();

    ImageLoader imageLoader;
    Context context;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public PhotoView mb;

        //PhotoView photoView = (PhotoView) findViewById(R.id.photo_view);
        public MyViewHolder(View view) {
            super(view);
            mb=(PhotoView) view.findViewById(R.id.imageView);
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
    public void onBindViewHolder(MyViewHolder holder, int position) {
        int img = image_list.get(position);
        Log.d("image",img+"");
        /*final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = 8;
        Bitmap bm = BitmapFactory.decodeFile(img+"",options);
        holder.mb.setImageBitmap(bm);
        //holder.mb.setImageResource(img);
        if(bm!=null)
        {
            bm.recycle();
            bm=null;
        }*/
        //holder.mb.setImageResource(image_list.get(position));
        //Picasso.get().load(image_list.get(position)).into(holder.mb);
        final ImagePopup imagePopup = new ImagePopup((Activity)context);
        //imagePopup.initiatePopupWithGlide(image_list.get(position)+"");
        /*imagePopup.setWindowHeight(800); // Optional
        imagePopup.setWindowWidth(800); // Optional
        imagePopup.setBackgroundColor(Color.BLACK);  // Optional
        imagePopup.setFullScreen(true); // Optional
        imagePopup.setHideCloseIcon(true);  // Optional
        imagePopup.setImageOnClickClose(true);  // Optional*/
        Glide.with(context)
                .load(image_list.get(position))
                .thumbnail( 0.1f )
                .into(holder.mb);
        holder.mb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //imagePopup.viewPopup();
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

}