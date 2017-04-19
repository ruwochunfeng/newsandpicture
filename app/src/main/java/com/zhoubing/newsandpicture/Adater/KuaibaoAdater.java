package com.zhoubing.newsandpicture.Adater;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.zhoubing.newsandpicture.Fruit;
import com.zhoubing.newsandpicture.Kuaibao;
import com.zhoubing.newsandpicture.R;

import java.util.List;

/**
 * Created by dell on 2017/4/16.
 */

public class KuaibaoAdater extends RecyclerView.Adapter<KuaibaoAdater.ViewHolder> implements View.OnClickListener{
    public static final String URL_TUPIAN = "https://ruwochunfeng.github.io/beautiful/";

    private Context mContext;

    private onRecyclerViewItemClickListener onItemClickListener = null;


    private List<Kuaibao> mList;

    public KuaibaoAdater(List<Kuaibao> mList) {
        this.mList = mList;
    }



    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(mContext ==null){
            mContext = parent.getContext();
        }
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_kuaibao,parent,false);
        view.setOnClickListener(this);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(KuaibaoAdater.ViewHolder holder, int position) {
             Kuaibao kuaibao = mList.get(position);
             holder.tv1.setText(kuaibao.getContent());
             holder.itemView.setTag(mList.get(position).getContent());
             Glide.with(mContext).load(URL_TUPIAN+"dd.jpg").into(holder.ima1);
             Glide.with(mContext).load(URL_TUPIAN+"t0155dbd3cc4a682b7d.jpg").into(holder.ima2);
             Glide.with(mContext).load(URL_TUPIAN+"t01b33f82a6acf43f00.jpg").into(holder.ima3);
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    @Override
    public void onClick(View v) {
        if(onItemClickListener != null){
            onItemClickListener.onItemClick(v, (String) v.getTag());
        }
    }

    public void setOnItemClickListener(onRecyclerViewItemClickListener onItemClickListener){
        this.onItemClickListener = onItemClickListener;
    }


    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView tv1;
        ImageView ima1,ima2,ima3;

        public ViewHolder(View itemView) {
            super(itemView);
            tv1 = (TextView) itemView.findViewById(R.id.text_kuaibao);
            ima1 = (ImageView) itemView.findViewById(R.id.image_1);
            ima2 = (ImageView) itemView.findViewById(R.id.image_2);
            ima3 = (ImageView) itemView.findViewById(R.id.image_3);
        }
    }

    public static interface onRecyclerViewItemClickListener{
        void onItemClick(View view,String data);
    }

}
