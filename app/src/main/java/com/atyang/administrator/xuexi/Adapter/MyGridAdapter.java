package com.atyang.administrator.xuexi.Adapter;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.atyang.administrator.xuexi.R;
import com.atyang.administrator.xuexi.Utlis.BaseViewHolder;

/**
 * @Description:gridview的Adapter
 * @author http://blog.csdn.net/finddreams
 */
public class MyGridAdapter extends BaseAdapter {
	private Context mContext;

	public String[] img_text = { "转账", "余额宝", "手机充值", "信用卡还款", "淘宝电影", "彩票",
			"当面付", "亲密付", "机票","当面付", "亲密付" };
	public int[] imgs = {R.mipmap.app_aapay, R.mipmap.app_aligame,R.mipmap.app_appcenter,
			R.mipmap.app_assign,R.mipmap.app_citycard,R.mipmap.app_close,R.mipmap.app_coupon,
			R.mipmap.app_creditcard, R.mipmap.app_donate,R.mipmap.app_essential,R.mipmap.app_exchange};

	public MyGridAdapter(Context mContext) {
		super();
		this.mContext = mContext;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return img_text.length;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if (convertView == null) {
			convertView = LayoutInflater.from(mContext).inflate(
					R.layout.grid_item, parent, false);
		}
		TextView tv = BaseViewHolder.get(convertView, R.id.tv_item);
		ImageView iv = BaseViewHolder.get(convertView, R.id.iv_item);
		iv.setBackgroundResource(imgs[position]);

		tv.setText(img_text[position]);
		return convertView;
	}

}
