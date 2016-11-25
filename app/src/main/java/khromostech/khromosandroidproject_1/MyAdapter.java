package khromostech.khromosandroidproject_1;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

import com.bumptech.glide.Glide;

import java.io.Serializable;
import java.util.ArrayList;

import static android.support.v4.content.ContextCompat.startActivity;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{

    private ArrayList<Constructor_media> constructor_media_list;
    private Context mContext;

    public MyAdapter(Context mContext, ArrayList<Constructor_media>  constructor_media_list) {
        this.constructor_media_list = constructor_media_list;
        this.mContext = mContext;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        public TextView title;
        public ImageView image_news;
        public Context context;
        private CardView cardviewFirstPage;


        public MyViewHolder(View itemView) {
            super(itemView);

            cardviewFirstPage = (CardView) itemView.findViewById(R.id.cardView_firstPage);
            title = (TextView) itemView.findViewById(R.id.title_news);
            image_news = (ImageView) itemView.findViewById(R.id.image_news);
        }
    }

    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView =LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_cardview_first_page, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyAdapter.MyViewHolder holder, int position) {

        Constructor_media media = constructor_media_list.get(position);
        final int THUMBSIZE = 128;

        Bitmap ThumbImage = ThumbnailUtils.extractThumbnail(
                BitmapFactory.decodeFile(Uri.parse(media.getImageUri()).getPath() ),
                THUMBSIZE,
                THUMBSIZE);

        holder.image_news.setImageBitmap(ThumbImage);
    }

    @Override
    public int getItemCount() {
        return constructor_media_list.size();
    }
}
