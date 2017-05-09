package com.zhuancheng.sanhedefence.presentation.adapter;

import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.zhuancheng.sanhedefence.R;

import java.util.List;

/**
 * Created by cong on 2017/5/8.
 */

public class GridViewAdapter extends BaseAdapter {
    private static final String TAG = "GridViewAdapter";
    List<String> list;
    private ImageView mImageView;
    public GridViewAdapter(List<String> list) {
        this.list = list;
    }
    @Override
    public int getCount() {
        return list.size() + 1;
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_item, null);
        mImageView = (ImageView) convertView.findViewById(R.id.item);
        if (position < list.size()) {
            Glide.with(parent.getContext()).load(list.get(position)).centerCrop().into(mImageView);
        } else {
            mImageView.setImageBitmap(BitmapFactory.decodeResource(parent.getContext().getResources(),R.drawable.main_icon_add_picture));
        }
        return convertView;
    }

    public void notifyDataSetChanged(List<String> arrayList) {
        this.list = arrayList;
        super.notifyDataSetChanged();
    }


}
