package com.atyang.administrator.xuexi.activity;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.atyang.administrator.xuexi.R;
import com.atyang.administrator.xuexi.Utlis.Time;
import com.atyang.administrator.xuexi.data.Board;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

/**
 * Created by Administrator on 2016/7/18.
 */
public class xieliuyanActivity extends BaseActivity implements View.OnClickListener {

    private EditText liuyan;
    private Button submit;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(1);
        setContentView(R.layout.activity_liuyan);
        iniv();
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    /**
     * 初始化控件
     */
    private void iniv() {
        liuyan = (EditText) findViewById(R.id.liuyan);
        submit = (Button) findViewById(R.id.submit);
        submit.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.submit:

                uploading();
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
        db.setMtime(Time.getInstance().getTime());
        /**设置类别*/
        db.setLeibie("第一版");
        db.save(new SaveListener<String>() {
            @Override
            public void done(String s, BmobException e) {
                if (e == null) {
                    Toast.makeText(xieliuyanActivity.this, "添加数据成功，返回objectId为", Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(xieliuyanActivity.this, "创建数据失败", Toast.LENGTH_SHORT).show();

                }
            }

        });
    }

}
