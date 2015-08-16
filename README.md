# listview、girdview的万能适配器

## 预览

<img src width="320px" height="266.5px" />

## 用来做什么

在listView使用的时候会用Adapter，以前总会要写一个类去继承BaseAdapter，重写其中许多的方法，现在只需要用一个匿名的内部类就可以实现以前方法

## 如何使用

复制里面的ViewHolder和CommonAdapter，然后在你的主类中只要写如下几行代码就可以了

```
  mListView.setAdapter(mAdapter = new CommonAdapter<String>(this, mDatas, R.layout.item) {
            @Override
            public void covert(ViewHolder holder, String item) {
                //这里主要实现setText和setImagResou等方法，需要在ViewHolder里写与之对应的方法
               // holder.setText(R.id.tv_title, item.toString());
            }
        });
```

## 鸣谢

## 更多

## License
Copyright (c) 2015 tomhuahua
