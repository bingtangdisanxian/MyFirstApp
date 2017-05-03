package com.project.mine.wedgit.pop;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.project.mine.R;

import java.util.ArrayList;

/**
 * @author 钟教授
 * @time 2017/4/28  0:13
 * @desc ${TODD}
 */

public class MyAdapter extends BaseAdapter {
    private ArrayList<Integer> pics;
    private ArrayList<String> titles;

    public MyAdapter(ArrayList<Integer> pic, ArrayList<String> title) {
        pics = pic;
        titles = title;
    }

    @Override
    public int getCount() {
        return pics.size();
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
    public View getView(int position, View convertView, ViewGroup container) {
        ViewHolder holder=null;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = View.inflate(container.getContext(), R.layout.item_fenlei_pop, null);
            holder.imageView = (ImageView) convertView.findViewById(R.id.iv_tuo);
            holder.textView = (TextView) convertView.findViewById(R.id.tv_title);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.imageView.setImageResource(pics.get(position));
        holder.textView.setText(titles.get(position));
        return convertView;
    }


    class ViewHolder {
        ImageView imageView;
        TextView textView;
    }
}
