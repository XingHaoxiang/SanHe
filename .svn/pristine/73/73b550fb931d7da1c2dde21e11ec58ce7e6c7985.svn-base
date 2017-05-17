package com.zhuancheng.sanhedefence.presentation.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zhuancheng.sanhedefence.R;
import com.zhuancheng.sanhedefence.domain.model.EngineerBean;

import java.util.List;

/**
 * Created by cong on 2017/5/6.
 */

public class EngineerAdapter extends BaseAdapter {
    List<EngineerBean> engineerBeen;
    public EngineerAdapter(List<EngineerBean> engineerBeen) {
        this.engineerBeen = engineerBeen;
    }
    @Override
    public int getCount() {
        return engineerBeen.size();
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
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_engineering, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        if (position % 2 != 0) {
            viewHolder.item_ll.setBackgroundColor(parent.getContext().getResources()
                    .getColor(R.color.engineering_bg));
        }
        viewHolder.item_id.setText(engineerBeen.get(position).getId());
        viewHolder.item_pro_name.setText(engineerBeen.get(position).getPro_name());
        viewHolder.item_state.setText(engineerBeen.get(position).getState());
        viewHolder.item_operation.setText("详情");
        return convertView;
    }

    private class ViewHolder{
        LinearLayout item_ll;
        TextView item_id,item_pro_name, item_state,item_operation;
        public ViewHolder(View view) {
            item_ll = (LinearLayout) view.findViewById(R.id.item_engineer_ll);
            item_id = (TextView) view.findViewById(R.id.item_engineer_id);
            item_pro_name = (TextView) view.findViewById(R.id.item_engineer_prjo_name);
            item_state = (TextView) view.findViewById(R.id.item_engineer_state);
            item_operation = (TextView) view.findViewById(R.id.item_engineer_operate);
        }


    }
}
