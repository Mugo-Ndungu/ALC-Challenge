package com.example.alcchall;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    public WebView myWebView;



    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        myWebView = findViewById(R.id.webview);

        myWebView.loadUrl("http://www.andela.com/alc/");

        myWebView.setWebViewClient(new MyWebViewClient());

        WebSettings webSettings = myWebView.getSettings();

        webSettings.setJavaScriptEnabled(true);
    }

    // Use When the user clicks a link from a web page in your WebView
    private class MyWebViewClient extends WebViewClient {

        @Override

        public boolean shouldOverrideUrlLoading(WebView view, String url) {

            if (Objects.equals(Uri.parse(url).getHost(), "www.andela.com/alc/")) {

                return false;

            }


            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));

            startActivity(intent);

            return true;
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(event.getAction() == KeyEvent.ACTION_DOWN){
            if (keyCode == KeyEvent.KEYCODE_BACK) {
                if (myWebView.canGoBack()) {
                    myWebView.goBack();
                    return true;
                }
            }

        }
        return super.onKeyDown(keyCode, event);
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            this.finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


}

