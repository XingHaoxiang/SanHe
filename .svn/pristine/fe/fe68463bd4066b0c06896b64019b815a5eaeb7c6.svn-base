package com.zhuancheng.sanhedefence.presentation.adapter;

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
    private List<String> imgNameList;
    List<String> list;
    private ImageView mImageView;
    public GridViewAdapter(List<String> list) {
        this.list = list;
    }

    public GridViewAdapter(List<String> imgList, List<String> imgNameList) {
        this.list = imgList;
        this.imgNameList = imgNameList;
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
        ViewHolder viewHolder = null;
        if (viewHolder == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_item, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        mImageView = (ImageView) convertView.findViewById(R.id.item);
        if (position < list.size()) {
            Glide.with(parent.getContext()).load(list.get(position)).centerCrop().into(viewHolder.iv);
        } else {
//            mImageView.setImageBitmap(BitmapFactory.decodeResource(parent.getContext().getResources(),R.drawable.main_icon_add_picture));
            //尝试用Glide修改
            Glide.with(parent.getContext()).load(R.drawable.main_icon_add_picture).into(viewHolder.iv);
            viewHolder.tv.setVisibility(View.INVISIBLE);
        }
        return convertView;
    }

    public void notifyDataSetChanged(List<String> arrayList) {
        this.list = arrayList;
        super.notifyDataSetChanged();
    }

    public void notifyDataSetChanged(List<String> arrayList, List<String> imgNameList) {
        this.list = arrayList;
        this.imgNameList = imgNameList;
        super.notifyDataSetChanged();
    }

    class ViewHolder {
        private ImageView iv;
        private ImageView tv;
        public ViewHolder(View v) {
            iv = (ImageView) v.findViewById(R.id.item);
            tv = (ImageView) v.findViewById(R.id.item_tv);
        }
    }
}
