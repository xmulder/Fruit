package com.jc.fruit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Steven on 2016/9/7.
 */
public class FruitAdapter extends BaseAdapter
{
    private ArrayList<Fruit> fruitList;
    Context context;

    //从构造函数中获取fruitList和Context对象.
    public FruitAdapter(ArrayList<Fruit> fruitList, Context context)
    {
        this.fruitList = fruitList;
        this.context = context;

    }

    public int getCount()
    {
        return fruitList.size();
    }

    public Object getItem(int position)
    {
        return null;
    }

    public long getItemId(int position)
    {
        return 0;
    }

    public View getView(int position, View convertView, ViewGroup parent)
    {
        final Fruit fruit = fruitList.get(position); 		//获取当前item的水果实例

        View v;
        ViewHolder holder;

        //滑入ListView中的item view没有缓存
        if(convertView == null)
        {
            v = LayoutInflater.from(context).inflate(R.layout.fruit_item, null);//动态加载滑入ListView的item的子布局文件，并绘制item view

            /*  缓存子布局文件中的控件对象*/
            holder = new ViewHolder();
            holder.fruitName = (TextView)v.findViewById(R.id.fruit_name);
            holder.fruitImage = (ImageView)v.findViewById(R.id.fruit_image);
            holder.fruitSubmit = (Button)v.findViewById(R.id.btn_submit);
            v.setTag(holder);
        }
        //滑入ListView中的item view有缓存
        else
        {
            v = convertView;					        //取出缓存的item View对象
            holder = (ViewHolder)v.getTag();	                        //重新获取ViewHolder对象
        }

        holder.fruitName.setText(fruit.getName());			//设置fruitName
        holder.fruitImage.setImageResource(fruit.getImageId());		//设置fruitImage

        //为Button对象添加监听器
        holder.fruitSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,"你已经订购" + fruit.getName(), Toast.LENGTH_SHORT).show();
            }
        });

        return v;
    }


    /*  定义ViewHolder用来缓存item view控件  */
    class ViewHolder
    {
        ImageView fruitImage;
        TextView fruitName;
        Button fruitSubmit;
    }

}