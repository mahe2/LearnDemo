package com.learn.demo.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.android.arouter.launcher.ARouter;
import com.learn.demo.R;
import com.learn.demo.bean.CommenData;
import com.learn.demo.bean.EntryData;

/**
 * Created by mahe on 2017/9/1.
 */

public class EntryAdapter extends AbsCommenAdapter<EntryData> {
    public EntryAdapter(Context context) {
        super(context);
    }

    @Override
    public View bindView(CommenData data, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        final EntryData entryData = (EntryData) data;
        if (convertView == null) {
            convertView = View.inflate(mCtx, R.layout.adapter_entry_adapter_layout, null);
            viewHolder = createHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        bindData(entryData, viewHolder);
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ARouter.getInstance().build(entryData.routePath).navigation();
            }
        });
        return convertView;
    }

    private void bindData(EntryData entryData,ViewHolder viewHolder){
        viewHolder.entryName.setText(entryData.name);
    }

    private ViewHolder createHolder(View convertView){
        ViewHolder viewHolder = new ViewHolder();
        viewHolder.entryName = (TextView) convertView.findViewById(R.id.entry_name_textview);
        return viewHolder;
    }


    public class ViewHolder {
        public TextView entryName;
    }
}
