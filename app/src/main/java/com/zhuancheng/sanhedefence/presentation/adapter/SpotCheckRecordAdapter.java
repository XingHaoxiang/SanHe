package com.zhuancheng.sanhedefence.presentation.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.zhuancheng.sanhedefence.R;
import com.zhuancheng.sanhedefence.domain.model.SpotCheckRecordBean;

import java.util.List;

/**
 * Created by cong on 2017/5/6.
 * 抽查记录适配器
 */

public class SpotCheckRecordAdapter extends BaseAdapter {
    List<SpotCheckRecordBean> spotCheckRecordBeen;
    public SpotCheckRecordAdapter(List<SpotCheckRecordBean> spotCheckRecordBeen) {
        this.spotCheckRecordBeen = spotCheckRecordBeen;
    }
    @Override
    public int getCount() {
        return spotCheckRecordBeen.size();
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
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_record, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.item_id.setText(spotCheckRecordBeen.get(position).getId());
        viewHolder.item_pro_name.setText(spotCheckRecordBeen.get(position).getProname());
        viewHolder.item_result.setText(spotCheckRecordBeen.get(position).getResult());
        viewHolder.item_time.setText(spotCheckRecordBeen.get(position).getTime());
        return convertView;
    }

    private class ViewHolder{
        TextView item_id,item_pro_name, item_result, item_time;
        public ViewHolder(View view) {
            item_id = (TextView) view.findViewById(R.id.record_item_id);
            item_pro_name = (TextView) view.findViewById(R.id.record_item_pro_name);
            item_result = (TextView) view.findViewById(R.id.record_item_result);
            item_time = (TextView) view.findViewById(R.id.record_item_time);
        }


    }
}
