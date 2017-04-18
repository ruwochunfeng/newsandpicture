package com.zhoubing.newsandpicture.Adater;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.zhoubing.newsandpicture.R;
import com.zhoubing.newsandpicture.News;

import java.util.List;

/**
 * Created by dell on 2017/4/18.
 */

public class newsAdapter  extends RecyclerView.Adapter<newsAdapter.ViewHolder>{


    private Context mContext;
    private List<News> mList;

    public newsAdapter(List<News> mList) {
        this.mList = mList;
    }




    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(mContext ==null){
            mContext = parent.getContext();
        }
        View view = LayoutInflater.from(mContext).inflate(R.layout.recycler_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(newsAdapter.ViewHolder holder, int position) {
          News news = mList.get(position);
          holder.imageView.setImageResource(news.getImageId());
          holder.tv1.setText(news.getTitle());
          holder.tv2.setText(news.getContent());
    }


    @Override
    public int getItemCount() {
        return mList.size();
    }

    static  class ViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView tv1,tv2;

        public ViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.image_recycler);
            tv1 = (TextView) itemView.findViewById(R.id.title);
            tv2 = (TextView) itemView.findViewById(R.id.content);
        }
    }
}
