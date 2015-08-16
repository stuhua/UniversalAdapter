package com.mt178.universal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * 继承了BaseAdapter，是一个通用的Adapter。。。。利用泛型T充当bean
 * Created by Administrator on 2015/8/16.
 */
public abstract class CommonAdapter<T> extends BaseAdapter {
    protected final int mItemLayoutId;
    private LayoutInflater mInflater;
    private Context mContext;
    private List<T> mDatas;

    public CommonAdapter(Context context, List<T> mDatas, int itemLayoutId) {
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

    /**
     * convertView的复用，使用setTag，getTag来实现findviewbyId等的重用
     *
     * @param position
     * @param convertView
     * @param parent
     * @return
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = ViewHolder.get(mContext, convertView, parent, mItemLayoutId, position);
        covert(holder, mDatas.get(position));
       /* TextView tv_title = holder.getView(R.id.tv_title);
        tv_title.setText(mDatas.get(position).toString());*/
        return holder.getConvertView();
    }

    public abstract void covert(ViewHolder holder, T item);
}
