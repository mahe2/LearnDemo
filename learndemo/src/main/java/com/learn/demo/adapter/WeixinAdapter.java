package com.learn.demo.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.learn.demo.R;
import com.learn.demo.bean.CommenData;
import com.learn.demo.bean.Joke;
import com.learn.demo.bean.Weixin;

/**
 * Created by mahe on 2017/9/1.
 */

public class WeixinAdapter extends AbsCommenAdapter<Joke> {
    public WeixinAdapter(Context context) {
        super(context);
    }

    @Override
    public View bindView(CommenData data, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        final Weixin weixinData = (Weixin) data;
        if (convertView == null) {
            convertView = View.inflate(mCtx, R.layout.adapter_weixin_adapter_layout, null);
            viewHolder = createHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        bindData(weixinData, viewHolder);
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
        return convertView;
    }

    private void bindData(Weixin data,ViewHolder viewHolder){
        viewHolder.entryName.setText(data.title);
    }

    private ViewHolder createHolder(View convertView){
        ViewHolder viewHolder = new ViewHolder();
        viewHolder.entryName = convertView.findViewById(R.id.text);
        return viewHolder;
    }


    public class ViewHolder {
        public TextView entryName;
    }
}
