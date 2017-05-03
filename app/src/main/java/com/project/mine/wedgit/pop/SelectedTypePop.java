package com.project.mine.wedgit.pop;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.PopupWindow;

import com.project.mine.R;
import com.project.mine.listener.IPopupWindowListener;
import com.project.mine.listener.ITitleChangeListener;

import java.util.ArrayList;


public class SelectedTypePop implements IPopupWindowListener {


    private PopupWindow popupWindow;


    private Context mContext;
    private ListView mLv;


    public SelectedTypePop(Context c) {
        mContext = c;
        initUI(c);

    }


    private ITitleChangeListener mListener;

    public void setITitleChangeListener(ITitleChangeListener listener) {
        mListener = listener;
    }

    @Override
    public void initUI(Context c) {

        View contentView = LayoutInflater.from(c)
                .inflate(R.layout.custom_fenlei, null, false);
        mLv = (ListView) contentView.findViewById(R.id.lv_xuanzhe);

        ArrayList<Integer> pic = new ArrayList<>();
        pic.add(R.drawable.home_title_all);
        pic.add(R.drawable.home_title_ios);
        pic.add(R.drawable.home_title_app);
        pic.add(R.drawable.home_title_qian);
        pic.add(R.drawable.home_title_movie);
        pic.add(R.drawable.home_title_source);
        final ArrayList<String> title = new ArrayList<>();
        title.add("全部");
        title.add("iOS");
        title.add("App");
        title.add("前端");
        title.add("休息视频");
        title.add("拓展资源");
        MyAdapter myAdapter = new MyAdapter(pic, title);
        mLv.setAdapter(myAdapter);
        mLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                mListener.onChangListener(title, i);
                onDismiss();
            }
        });
        popupWindow = new PopupWindow(contentView,
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);
        popupWindow.setFocusable(true);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        popupWindow.update();
    }


    @Override
    public void onShow(View anchor) {
        if (popupWindow != null && !popupWindow.isShowing()) {
            //popupWindow.showAtLocation(anchor, Gravity.CENTER, 0, 0);
            popupWindow.showAsDropDown(anchor, 0, 0);
        }
    }

    @Override
    public void onDismiss() {
        if (popupWindow != null && popupWindow.isShowing()) {
            popupWindow.dismiss();
        }
    }

}
