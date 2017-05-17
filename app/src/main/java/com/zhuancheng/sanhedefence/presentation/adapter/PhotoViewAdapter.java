package com.zhuancheng.sanhedefence.presentation.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.zhuancheng.sanhedefence.R;

import java.util.ArrayList;
import java.util.List;

import static com.zhuancheng.sanhedefence.R.id.item;

/**
 * Created by cong on 2017/5/17.
 */

public class PhotoViewAdapter extends BaseAdapter {

    List<String> list;

    public PhotoViewAdapter() {
        list = new ArrayList<>();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder = null;
        if (viewHolder == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();

        }
        if (position < list.size()) {
            Glide.with(parent.getContext()).load(list.get(position)).into(viewHolder.iv);
        } else {
            Glide.with(parent.getContext()).load(R.drawable.main_icon_add_picture).into(viewHolder.iv);
            viewHolder.tv.setVisibility(View.INVISIBLE);
        }

        return convertView;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public int getCount() {
        return list.size() + 1;
    }

    class ViewHolder {
        private ImageView iv;
        private ImageView tv;

        public ViewHolder(View v) {
            iv = (ImageView) v.findViewById(item);
            tv = (ImageView) v.findViewById(R.id.item_tv);
        }
    }
}
