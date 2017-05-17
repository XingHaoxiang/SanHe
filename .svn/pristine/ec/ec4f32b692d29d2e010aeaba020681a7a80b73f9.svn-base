package com.zhuancheng.sanhedefence.presentation.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.zhuancheng.sanhedefence.R;
import com.zhuancheng.sanhedefence.domain.model.Site_QualityBean;

import java.util.List;

/**
 * Created by cong on 2017/5/6.
 */

public class SiteQualityAdapter extends BaseAdapter {
    private List<Site_QualityBean> mSiteQualityBeen;
    public SiteQualityAdapter(List<Site_QualityBean> mSiteQualityBeen) {
        this.mSiteQualityBeen = mSiteQualityBeen;
    }

    @Override
    public int getCount() {
        return mSiteQualityBeen.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        Context context = parent.getContext();
        if (viewHolder == null) {
            convertView = LayoutInflater.from(context)
                    .inflate(R.layout.item_site_quality, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }
        viewHolder = (ViewHolder) convertView.getTag();
        viewHolder.item_site_title.setText(mSiteQualityBeen.get(position).getSite_title());
        viewHolder.item_site_prjo.setText(mSiteQualityBeen.get(position).getSite_prjo_name());
        viewHolder.item_site_time.setText(mSiteQualityBeen.get(position).getSite_time());
        String imgUrl1 = mSiteQualityBeen.get(position).getSite_img1();
        String imgUrl2 = mSiteQualityBeen.get(position).getSite_img2();
        String imgUrl3 = mSiteQualityBeen.get(position).getSite_img3();
        String imgUrl4 = mSiteQualityBeen.get(position).getSite_img4();

        if (!TextUtils.isEmpty(imgUrl1)) {
            Glide.with(context).load(imgUrl1).placeholder(R.mipmap.login_icon_logo).centerCrop().into(viewHolder.item_img1);
        }
        if (!TextUtils.isEmpty(imgUrl2)) {
            Glide.with(context).load(imgUrl2).placeholder(R.mipmap.login_icon_logo).into(viewHolder.item_img2);
        }
        if (!TextUtils.isEmpty(imgUrl3)) {
            Glide.with(context).load(imgUrl3).placeholder(R.mipmap.login_icon_logo).into(viewHolder.item_img3);
        }
        if (!TextUtils.isEmpty(imgUrl4)) {
            Glide.with(context).load(imgUrl4).placeholder(R.mipmap.login_icon_logo).into(viewHolder.item_img4);
        }

        return convertView;
    }

    private class ViewHolder {
        private TextView item_site_title,item_site_prjo,item_site_time;
        private ImageView item_img1,item_img2,item_img3,item_img4;
        public ViewHolder(View view){
            item_site_title = (TextView) view.findViewById(R.id.item_site_title);
            item_site_prjo = (TextView) view.findViewById(R.id.item_site_pro_name);
            item_site_time = (TextView) view.findViewById(R.id.site_time);
            item_img1 = (ImageView) view.findViewById(R.id.site_iv1);
            item_img2 = (ImageView) view.findViewById(R.id.site_iv2);
            item_img3 = (ImageView) view.findViewById(R.id.site_iv3);
            item_img4 = (ImageView) view.findViewById(R.id.site_iv4);
        }

    }
}
