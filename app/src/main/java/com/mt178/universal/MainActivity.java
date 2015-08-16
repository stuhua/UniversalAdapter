package com.mt178.universal;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView mListView;
    private CommonAdapter mAdapter;
    private List<String> mDatas = new ArrayList<String>(Arrays.asList("刘", "连", "华",
            "到", "此", "一",
            "游", "！", "！",
            "", "", ""));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListView = (ListView) findViewById(R.id.lv_main);
//        mAdapter = new MyAdapter(this, mDatas);
        mListView.setAdapter(mAdapter = new CommonAdapter<String>(this, mDatas, R.layout.item) {
            @Override
            public void covert(ViewHolder holder, String item) {
                holder.setText(R.id.tv_title, item.toString());
            }
        });
    }

}
