package com.zhuancheng.sanhedefence.presentation.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.zhuancheng.sanhedefence.R;
import com.zhuancheng.sanhedefence.domain.model.QualityBean;

import java.util.List;

/**
 * Created by cong on 2017/5/6.
 * 质监任务适配器
 */

public class QualityAdapter extends BaseAdapter {
    List<QualityBean> qualityBeanList;
    public QualityAdapter(List<QualityBean> qualityBeanList) {
        this.qualityBeanList = qualityBeanList;
    }
    @Override
    public int getCount() {
        return qualityBeanList.size();
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
        if (viewHolder == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_quality, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.item_title.setText(qualityBeanList.get(position).getQualityContent());
        viewHolder.item_pro_name.setText(qualityBeanList.get(position).getProjectName());
        viewHolder.item_pro_address.setText(qualityBeanList.get(position).getProjectAddress());
        viewHolder.item_pro_time.setText(qualityBeanList.get(position).getTime());
        return convertView;
    }

    private class ViewHolder{
        TextView item_title,item_pro_name,item_pro_address,item_pro_time;
        public ViewHolder(View view) {
            item_title = (TextView) view.findViewById(R.id.quality_item_title);
            item_pro_name = (TextView) view.findViewById(R.id.quality_item_pro_name);
            item_pro_address = (TextView) view.findViewById(R.id.quality_item_address);
            item_pro_time = (TextView) view.findViewById(R.id.quality_item_time);
        }


    }
}
