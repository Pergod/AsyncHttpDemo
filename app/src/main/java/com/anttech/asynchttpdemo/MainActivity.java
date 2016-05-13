package com.anttech.asynchttpdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import java.io.UnsupportedEncodingException;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity {
    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextView = (TextView) findViewById(R.id.text_view);

//        AsyncHttpGet();
        AsyncHttpPost();
    }

    public void AsyncHttpGet() {
        AsyncHttpClient client = new AsyncHttpClient();
        String url = "http://apis.juhe.cn/mobile/get?";
        client.get(url, new AsyncHttpResponseHandler() {

            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String result = null;
                try {
                    result = new String(responseBody, "UTF-8");
                    mTextView.setText(result);
                } catch (UnsupportedEncodingException e) {
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                String result = null;
                try {
                    result = new String(responseBody, "UTF-8");
                    mTextView.setText(result);
                } catch (UnsupportedEncodingException e) {
                }
            }
        });
    }

    public void AsyncHttpPost() {
        AsyncHttpClient client = new AsyncHttpClient();
        String url = "http://www.baidu.com";
        RequestParams param = new RequestParams();

        param.put("phone", "18370035337");
        param.put("key", "335adcc4e891ba4e4be6d7534fd54c5d");

        client.post(url, param, new AsyncHttpResponseHandler() {

            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String result = null;
                try {
                    result = new String(responseBody, "UTF-8");
                    mTextView.setText(result);
                } catch (UnsupportedEncodingException e) {
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                String result = null;
                try {
                    result = new String(responseBody, "UTF-8");
                    mTextView.setText(result);
                } catch (UnsupportedEncodingException e) {
                }
            }
        });
    }
}
