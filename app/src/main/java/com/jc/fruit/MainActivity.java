package com.jc.fruit;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends Activity
{
    private ArrayList<Fruit> fruitList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fruitList = new ArrayList<>();		                                //创建一个存放水果信息的ArrayList对象
        initFruit();							        //初始化水果数据

        ListView listView = (ListView)findViewById(R.id.list_view);	        //获取布局文件中的ListView控件对象
        listView.setAdapter(new FruitAdapter(fruitList, MainActivity.this));	//为listView设定adapter


        //为listView绑定事件监听
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(
                    AdapterView<?> parent,
                    View view,
                    int position,
                    long id) {

                //获得用户点击到的item上的水果实例
                Fruit fruit = fruitList.get(position);

                //Toast显示点击该水果的信息
                Toast.makeText(MainActivity.this, fruit.getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void initFruit()
    {
        //创建水果对象
        Fruit fruit1 = new Fruit("苹果", R.drawable.apple_pic);
        Fruit fruit2 = new Fruit("香蕉", R.drawable.banana_pic);
        Fruit fruit3 = new Fruit("樱桃", R.drawable.cherry_pic);
        Fruit fruit4 = new Fruit("葡萄", R.drawable.grape_pic);
        Fruit fruit5 = new Fruit("芒果", R.drawable.mango_pic);
        Fruit fruit6 = new Fruit("桔子", R.drawable.orange_pic);
        Fruit fruit7 = new Fruit("梨", R.drawable.pear_pic);
        Fruit fruit8 = new Fruit("菠萝", R.drawable.pineapple_pic);
        Fruit fruit9 = new Fruit("草莓", R.drawable.strawberry_pic);
        Fruit fruit10 = new Fruit("西瓜", R.drawable.watermelon_pic);

        //将水果对象添加到集合中
        fruitList.add(fruit1);
        fruitList.add(fruit2);
        fruitList.add(fruit3);
        fruitList.add(fruit4);
        fruitList.add(fruit5);
        fruitList.add(fruit6);
        fruitList.add(fruit7);
        fruitList.add(fruit8);
        fruitList.add(fruit9);
        fruitList.add(fruit10);
    }
}