package com.mt178.universal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Administrator on 2015/8/16.
 */
public abstract class CommonAdapter<T> extends BaseAdapter {
    private LayoutInflater mInflater;
    private Context mContext;
    private List<T> mDatas;
    protected final int mItemLayoutId;

    public CommonAdapter(Context context, List<T> mDatas,int itemLayoutId) {
        mInflater = LayoutInflater.from(context);
        this.mContext = context;
        this.mDatas = mDatas;
        this.mItemLayoutId = itemLayoutId;
    }

    @Override
    public int getCount() {
        return mDatas.size();
    }

    @Override
    public Object getItem(int position) {
        return mDatas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = ViewHolder.get(mContext, convertView, parent, mItemLayoutId, position);
        covert(holder,mDatas.get(position));
       /* TextView tv_title = holder.getView(R.id.tv_title);
        tv_title.setText(mDatas.get(position).toString());*/
        return holder.getConvertView();
    }
    public abstract void covert(ViewHolder holder,T item);
}
