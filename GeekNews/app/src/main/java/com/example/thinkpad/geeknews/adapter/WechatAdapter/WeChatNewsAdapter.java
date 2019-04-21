package com.example.thinkpad.geeknews.adapter.WechatAdapter;

import android.content.Context;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.thinkpad.geeknews.R;
import com.example.thinkpad.geeknews.bean.WeChatBean.WechatBean;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * 高山仰止,景行行止.虽不能至,心向往之
 **/
public class WeChatNewsAdapter extends RecyclerView.Adapter {
    private Context context;
    private ArrayList<WechatBean.NewslistBean> wechatlist;

    public WeChatNewsAdapter(Context context, ArrayList<WechatBean.NewslistBean> wechatlist) {
        this.context = context;
        this.wechatlist = wechatlist;
    }

    public void setWechatlist(ArrayList<WechatBean.NewslistBean> wechatlist) {
        this.wechatlist = wechatlist;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.wechat_item, null);
        return new WeChatVH(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        WeChatVH weChatVH = (WeChatVH) viewHolder;
        WechatBean.NewslistBean wechatbean = wechatlist.get(i);
        weChatVH.mWechat_txt.setText(wechatbean.getTitle());
        weChatVH.mWechat_txt1.setText(wechatbean.getDescription());
        weChatVH.mWechat_txt2.setText(wechatbean.getCtime());

        Glide.with(context).load(wechatbean.getPicUrl()).into(weChatVH.mWechat_image);
    }

    @Override
    public int getItemCount() {
        return wechatlist.size();
    }

    class WeChatVH extends RecyclerView.ViewHolder {

        private final ImageView mWechat_image;
        private final TextView mWechat_txt;
        private final TextView mWechat_txt1;
        private final TextView mWechat_txt2;

        public WeChatVH(@NonNull View itemView) {
            super(itemView);
            mWechat_image = itemView.findViewById(R.id.wechat_image);
            mWechat_txt = itemView.findViewById(R.id.wechat_txt);
            mWechat_txt1 = itemView.findViewById(R.id.wechat_txt1);
            mWechat_txt2 = itemView.findViewById(R.id.wechat_txt2);
        }
    }
}
