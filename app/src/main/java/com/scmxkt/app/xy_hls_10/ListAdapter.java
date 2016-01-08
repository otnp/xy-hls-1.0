package com.scmxkt.app.xy_hls_10;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * xy-hls-1.0
 * Created by renpeng on 2016/1/7.
 * desc:
 */
public class ListAdapter extends BaseAdapter {

    private LayoutInflater mInflater = null;
    private Context mycontent = null;
    private ArrayList<HashMap<String, Object>> data;

    public ListAdapter(Context context,ArrayList<HashMap<String, Object>> mydata) {
        //根据context上下文加载布局，这里的是MainActivity本身，即this
        this.mycontent=context;
        this.mInflater = LayoutInflater.from(context);
        this.data=mydata;
    }


    //ViewHolder静态类
    static class ViewHolder
    {
        public ImageView img;
        public TextView title;
        public TextView info;
    }

    /**
     * 资源数据
     */
    public static String[] eatFoodyImages = {
            "http://182.150.2.245:7070/AuspiciousCloudsFile//MoonBox/Cover/Lesson/a8d51408c4284ec2a0dc42ebb8e6b4c3.jpg",
            "http://182.150.2.245:7070/AuspiciousCloudsFile//MoonBox/Cover/Lesson/1426f3b01a7a431b85e85014176c80c9.jpg",
            "http://182.150.2.245:7070/AuspiciousCloudsFile//MoonBox/Cover/Lesson/439924d4fb0b410d9f16692c84cdf8cd.jpg",
            "http://182.150.2.245:7070/AuspiciousCloudsFile//MoonBox/Cover/Lesson/50b279ef447e4670821185ff09f4525d.jpg",
            "http://182.150.2.245:7070/AuspiciousCloudsFile//MoonBox/Cover/Lesson/19d3692cb695494bbb5babc2cfd41639.jpg",
            "http://182.150.2.245:7070/AuspiciousCloudsFile//MoonBox/Cover/Lesson/4dad7c67bdae410faa59d77f03067800.jpg",
            "http://182.150.2.245:7070/AuspiciousCloudsFile//MoonBox/Cover/Lesson/5882359460104a6ea5a6e476cc08f734.jpg",
            "http://182.150.2.245:7070/AuspiciousCloudsFile//MoonBox/Avatar/cut_c4fc3ba4cd3c45e8a8cac0c5a172b7d1.JPG",
            "http://i.imgur.com/aC9OjaM.jpg",
            "http://i.imgur.com/76Jfv9b.jpg",
            "http://i.imgur.com/fUX7EIB.jpg",
            "http://i.imgur.com/syELajx.jpg",
            "http://i.imgur.com/COzBnru.jpg",
            "http://i.imgur.com/Z3QjilA.jpg",
    };


    @Override
    public int getCount() {
        //How many items are in the data set represented by this Adapter.
        //在此适配器中所代表的数据集中的条目数
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        // Get the data item associated with the specified position in the data set.
        //获取数据集中与指定索引对应的数据项
        //return position;
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        //Get the row id associated with the specified position in the list.
        //获取在列表中与指定索引对应的行id
        return position;
    }

    //Get a View that displays the data at the specified position in the data set.
    //获取一个在数据集中指定索引的视图来显示数据
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        //如果缓存convertView为空，则需要创建View
        if (convertView == null) {
            holder = new ViewHolder();
            //根据自定义的Item布局加载布局
            convertView = mInflater.inflate(R.layout.list_raw, null);
            holder.img = (ImageView) convertView.findViewById(R.id.list_image);
            holder.title = (TextView) convertView.findViewById(R.id.list_title);
            holder.info = (TextView) convertView.findViewById(R.id.list_info);
            //将设置好的布局保存到缓存中，并将其设置在Tag里，以便后面方便取出Tag
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        //holder.img.setBackgroundResource((Integer) data.get(position).get("img"));


        Glide.with(mycontent)
                //.load("http://inthecheesefactory.com/uploads/source/glidepicasso/cover.jpg")
                .load(eatFoodyImages[position])
                .into(holder.img);
        holder.title.setText((String) data.get(position).get("title"));
        holder.info.setText((String) data.get(position).get("info"));

        return convertView;
    }


}
