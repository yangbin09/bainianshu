package com.atyang.administrator.xuexi.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.atyang.administrator.xuexi.BaseActivity;
import com.atyang.administrator.xuexi.R;
import com.atyang.administrator.xuexi.data.Board;

import java.util.ArrayList;
import java.util.List;

/**
 * 展现留言板数据的一个adapter
 * Created by Administrator on 2016/7/18.
 */
public class MyAdapter extends BaseAdapter {
    Context activity;
    List<Board> list=new ArrayList<>();

    public MyAdapter(Context context, List<Board> list) {
        this.activity=context;
        this.list=list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        ViewHolder holder = null;
                if (convertView == null) {
                    convertView = View.inflate(activity,R.layout.iteml,null);
                    holder = new ViewHolder();
                          holder.textView = (TextView)convertView.findViewById(R.id.text);
                          convertView.setTag(holder);
                } else {
                            holder = (ViewHolder)convertView.getTag();
                        }
                   holder.textView.setText( list.get(position).getMdatacontent());
        return convertView;
    }
}

class  ViewHolder{
     TextView textView;
}