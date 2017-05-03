package com.project.mine.listener;

import android.content.Context;
import android.view.View;

public interface IPopupWindowListener {

	public void initUI(Context c);
	
	public void onShow(View anchor);
	
	public void onDismiss();
}
