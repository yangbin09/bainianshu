package com.atyang.administrator.xuexi.activity.message;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.atyang.administrator.xuexi.Adapter.MyAdapter;
import com.atyang.administrator.xuexi.R;
import com.atyang.administrator.xuexi.activity.BaseActivity;
import com.atyang.administrator.xuexi.data.Board;

import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;

/**
 * Created by Administrator on 2016/8/8.
 */
public class MessageMain extends BaseActivity implements View.OnClickListener {

        //书写留言
        private TextView write;
        //留言表列表
        private ListView li_main_liuyan;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            getWindow().requestFeature(1);
            setContentView(R.layout.activity_massagemain);

            iniv();

            data();

        }
        /**获取数据*/
        private void data() {
            BmobQuery<Board> query = new BmobQuery<Board>();
            //查询playerName叫“比目”的数据
            query.addWhereEqualTo("leibie", "0000");
            //返回50条数据，如果不加上这条语句，默认返回10条数据
            query.setLimit(50);
            //执行查询方法
            query.findObjects(new FindListener<Board>() {
                @Override
                public void done(List<Board> listliuyan, BmobException e) {
                    if(e==null){
                        MyAdapter mAdapter = new MyAdapter(MessageMain.this,listliuyan);//得到一个MyAdapter对象
                        li_main_liuyan.setAdapter(mAdapter);//为ListView绑定Adapter
                        Log.i("bmob","成功："+e.getMessage()+","+e.getErrorCode());
                    }else{
                        Log.i("bmob","失败失败："+e.getMessage()+","+e.getErrorCode());

                    }
                }
            });
        }

        /**初始化控件*/
        private void iniv() {
            write = (TextView) findViewById(R.id.write);
            li_main_liuyan= (ListView) findViewById(R.id.li_main_liuyan);
            li_main_liuyan.setDivider(null);//去除listview的下划线

            write.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            switch (view.getId()){
                /**跳转到写留言的页面*/
                case R.id.write:
                    Intent intent=new Intent();
                    intent.setClass(MessageMain.this, xieliuyanActivity.class);
                    startActivity(intent);
                    break;
            }
        }

        //当前activity可见时调用这个方法
        @Override
        protected void onResume() {
            super.onResume();
            data();
        }
    /* private void ad(){

       Person p2 = new Person();
       p2.setName("lucky");
       p2.setAddress("北京海淀");
       p2.save(new SaveListener<String>() {
           @Override
           public void done(String s, BmobException e) {
               if(e==null){
                   Toast.makeText(MessageMain.this,"添加数据成功，返回objectId为",Toast.LENGTH_SHORT).show();

               }else{
                   Toast.makeText(MessageMain.this,"创建数据失败",Toast.LENGTH_SHORT).show();

               }
           }

       });
   }*/
    }


