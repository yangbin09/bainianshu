package com.atyang.administrator.xuexi.activity.message;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.atyang.administrator.xuexi.R;
import com.atyang.administrator.xuexi.Utlis.Time;
import com.atyang.administrator.xuexi.activity.BaseActivity;
import com.atyang.administrator.xuexi.activity.MainActivity;
import com.atyang.administrator.xuexi.data.Board;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

/**
 * Created by Administrator on 2016/7/18.
 */
public class xieliuyanActivity extends BaseActivity implements View.OnClickListener {
    //书写留言的输入框
    private EditText liuyan;
    //确认提交的按钮
    private Button submit;
    //返回按钮
    private TextView tv_xie_fanhui;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(1);
        setContentView(R.layout.activity_liuyan);
        iniv();

    }

    /**
     * 初始化控件
     */
    private void iniv() {
        liuyan = (EditText) findViewById(R.id.liuyan);
        submit = (Button) findViewById(R.id.submit);
        submit.setOnClickListener(this);
        tv_xie_fanhui = (TextView) findViewById(R.id.tv_xie_fanhui);
        tv_xie_fanhui.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            //长传留言
            case R.id.submit:

                uploading();
                break;
            //返回主页
            case R.id.tv_xie_fanhui:
                Intent intent=new Intent();
                intent.setClass(xieliuyanActivity.this, MessageMain.class);
                startActivity(intent);
                finish();
                break;
        }
    }

    /**
     * 上传留言
     */
    private void uploading() {
        Board db = new Board();
        //设置留言板内容
        db.setMdatacontent(liuyan.getText().toString());
        //设置留言的人
        db.setMperson("amdmin");
        //设置留言的时间
       db.setMtime(Time.getInstance().getPresentTime());
        //db.setMtime("2011-10-10 12:21");
        /**设置类别*/
        db.setLeibie("0000");
        db.save(new SaveListener<String>() {
            @Override
            public void done(String s, BmobException e) {
                if (e == null) {
                    Toast.makeText(xieliuyanActivity.this, "留言上传成功", Toast.LENGTH_SHORT).show();

                    finish();

                } else {
                    Toast.makeText(xieliuyanActivity.this, "留言长传失败，请检查网络", Toast.LENGTH_SHORT).show();

                }
            }

        });
    }

}
