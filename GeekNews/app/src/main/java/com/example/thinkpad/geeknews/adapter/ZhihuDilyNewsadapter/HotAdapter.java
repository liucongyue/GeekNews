package com.example.thinkpad.geeknews.adapter.ZhihuDilyNewsadapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.thinkpad.geeknews.R;
import com.example.thinkpad.geeknews.bean.geekbean.HotBean;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;


public class HotAdapter extends RecyclerView.Adapter {


    private Context mcontext;
    private ArrayList<HotBean.RecentBean> mlist;

    public HotAdapter(Context context, ArrayList<HotBean.RecentBean> list) {

        mcontext = context;
        mlist = list;
    }

    public void setMlist(ArrayList<HotBean.RecentBean> mlist) {
        this.mlist = mlist;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(mcontext).inflate(R.layout.hotitem, null);
        return new ListViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ListViewHolder holder1 = (ListViewHolder) holder;
        holder1.mTv1.setText(mlist.get(position).getTitle());

        Glide.with(mcontext).load(mlist.get(position).getThumbnail()).into(holder1.mPic);


    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }

    class ListViewHolder extends XRecyclerView.ViewHolder {
            ImageView mPic;
            TextView mTv1;

            public ListViewHolder(View itemView) {
                super(itemView);
                this.mPic = (ImageView) itemView.findViewById(R.id.pic);
                this.mTv1 = (TextView) itemView.findViewById(R.id.tv1);

            }
        }
}
