package com.zhuancheng.sanhedefence.presentation.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.linearlistview.LinearListView;
import com.zhuancheng.sanhedefence.R;
import com.zhuancheng.sanhedefence.domain.http.response.QualityTaskDetailResponse;
import com.zhuancheng.sanhedefence.presentation.activity.EditPhotoActivity;
import com.zhuancheng.sanhedefence.presentation.activity.PhotoRequire;
import com.zhuancheng.sanhedefence.utils.ToastUtil;

import java.util.List;

/**
 * Created by cong on 2017/5/17.
 */

public class PhotoShowAdapter extends BaseAdapter {

    private PhotoViewAdapter mAdapter;
    private Context mContext;
    private List<QualityTaskDetailResponse.EprIdListBean> list;

    public PhotoShowAdapter(List<QualityTaskDetailResponse.EprIdListBean> list,Context mContext) {
        this.list = list;
        this.mContext = mContext;
        mAdapter = new PhotoViewAdapter();
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_horlist, parent, false);
        }
        TextView buwei = (TextView) convertView.findViewById(R.id.buwei);
        buwei.setText(list.get(position).getPartName());
        TextView yaoqiu = (TextView) convertView.findViewById(R.id.yaoqiu);
        yaoqiu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, PhotoRequire.class);
                mContext.startActivity(intent);
            }
        });
        LinearListView listView = (LinearListView)convertView.findViewById(R.id.horizontal_list_in);
        listView.setAdapter(mAdapter);
        listView.setOnItemClickListener(new LinearListView.OnItemClickListener() {
            @Override
            public void onItemClick(LinearListView parent, View view, int position, long id) {
                if (position == parent.getChildCount() - 1) {
//                takePicture();
                    ToastUtil.showToast("拍照");
                } else {
                    Intent intent = new Intent(mContext, EditPhotoActivity.class);
                    ToastUtil.showToast("" + list.get(position).getParentName());
                    mContext.startActivity(intent);
                }
            }
        });
        return convertView;
    }
}
