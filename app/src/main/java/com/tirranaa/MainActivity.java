package com.tirranaa;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/* My activity */
public class MainActivity extends AppCompatActivity {
    /* Using WebView to load websites into the application */
    private WebView webView;
    /* Override main activity with WebView */
    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Pass my activity through WebView
        CustomWebViewClient client = new CustomWebViewClient(this);

        webView = findViewById(R.id.webView);
        /* Use the client Above through WebView ! */
        webView.setWebViewClient(client);
        /* My js Enable ! */
        webView.getSettings().setJavaScriptEnabled(true);
        /* My java Loader */
        webView.loadUrl("https://tirranaa.github.io/");
    }
    /* Back event WebView for navigation */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event){
        if(keyCode == KeyEvent.KEYCODE_BACK && this.webView.canGoBack()){
            this.webView.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
/* No External Browser override, to stay navigating into the website within the app only !  */
class CustomWebViewClient extends WebViewClient{
    private Activity activity;
    /* Constructor pass through  */
    public CustomWebViewClient(Activity activity){
        this.activity = activity;
    }
    /* Override no external return URL ! */
    /* API level Less the 24 ! */
    @Override
    public boolean shouldOverrideUrlLoading(WebView webView, String url){
        return false;
    }
    /* Pass url through WebView, stay inside the app !  */
    /* API level >= 24 ! */
    @Override
    public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest request){
        return false;
    }
}