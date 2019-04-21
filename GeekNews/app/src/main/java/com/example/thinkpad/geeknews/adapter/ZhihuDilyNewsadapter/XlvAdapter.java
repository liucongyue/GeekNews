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
import com.example.thinkpad.geeknews.bean.geekbean.DayNewsBean;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;


public class XlvAdapter extends RecyclerView.Adapter {
    private Context mcontext;
    private ArrayList<DayNewsBean.StoriesBean> mlist;
    private ArrayList<DayNewsBean.TopStoriesBean> mbanners;
    String mdata = "liuhaha";

    public XlvAdapter(Context context, ArrayList<DayNewsBean.StoriesBean> list, ArrayList<DayNewsBean.TopStoriesBean> banners) {

        mcontext = context;
        mlist = list;
        mbanners = banners;
    }

    @Override
    public int getItemViewType(int position) {
        if (mbanners.size() > 0) {
            if (position == 0) {
                return 1;
            } else if (position == 1) {
                return 2;
            } else {
                return 3;
            }
        } else {
            if (position == 0) {
                return 2;
            } else {
                return 3;
            }
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mcontext);
        if (viewType == 1) {
            View inflate = inflater.inflate(R.layout.banners, null);
            return new BannerViewHolder(inflate);
        } else if (viewType == 2) {
            View inflate = inflater.inflate(R.layout.texts, null);
            return new TextViewHolder(inflate);
        } else {
            View inflate = inflater.inflate(R.layout.geeklist, null);
            return new ListViewHolder(inflate);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        int viewType = getItemViewType(position);
        if (viewType == 1) {
            final BannerViewHolder holder1 = (BannerViewHolder) holder;
            holder1.mBannerss.setImages(mbanners).setImageLoader(new ImageLoader() {
                @Override
                public void displayImage(Context context, Object path, ImageView imageView) {
                    DayNewsBean.TopStoriesBean bean = (DayNewsBean.TopStoriesBean) path;
                    Glide.with(context).load(bean.getImage()).into(imageView);
                }
            }).start();
        } else if (viewType == 2) {
            TextViewHolder holder1 = (TextViewHolder) holder;
            holder1.mTv.setText(mdata);
        } else {
            int newposition = position - 1;
            if (mbanners.size() > 0) {
                newposition -= 1;

            }
            ListViewHolder holder1 = (ListViewHolder) holder;
            holder1.mTv.setText(mlist.get(newposition).getTitle());

            Glide.with(mcontext).load(mlist.get(newposition).getImages().get(0)).into(holder1.mPic);
        }
    }

    @Override
    public int getItemCount() {
        if (mbanners.size() > 0) {
            return mlist.size() + 1 + 1;
        } else {
            return mlist.size() + 1;
        }
    }
    public void setData(DayNewsBean bean) {
        mdata = bean.getDate();

        mbanners.clear();
        if (bean.getTop_stories() != null && bean.getTop_stories().size()>0){
            mbanners.addAll(bean.getTop_stories());
        }

        mlist.clear();
        if (bean.getStories() != null && bean.getStories().size()>0){
            mlist.addAll(bean.getStories());
        }
        notifyDataSetChanged();
    }

    class BannerViewHolder extends RecyclerView.ViewHolder {

        private Banner mBannerss;

        public BannerViewHolder(@NonNull View itemView) {
            super(itemView);
            mBannerss = itemView.findViewById(R.id.bannerss);
        }
    }

    class TextViewHolder extends RecyclerView.ViewHolder {

        private TextView mTv;

        public TextViewHolder(@NonNull View itemView) {
            super(itemView);
            mTv = itemView.findViewById(R.id.tv);
        }
    }

    class ListViewHolder extends RecyclerView.ViewHolder {

        private final ImageView mPic;
        private final TextView mTv;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            mPic = itemView.findViewById(R.id.pic);
            mTv = itemView.findViewById(R.id.tv);
        }
    }

}
