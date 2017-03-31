package com.example.farazsherwani.samplewebview;

import android.annotation.SuppressLint;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class FullscreenActivity extends AppCompatActivity {
  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_fullscreen);

    WebView mainWebView = (WebView) findViewById(R.id.webview);

    WebSettings webSettings = mainWebView.getSettings();
    webSettings.setJavaScriptEnabled(true);

    mainWebView.setWebViewClient(new WebViewClient() {
      @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
      @Override
      public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
        view.loadUrl(request.getUrl().toString());
        return true;
      }

      @Override
      public boolean shouldOverrideUrlLoading(WebView view, String url) {
        view.loadUrl(url);
        return true;
      }
    });

    mainWebView.setWebContentsDebuggingEnabled(true);
    mainWebView.loadUrl("https://www.w3schools.com/html/html_forms.asp");
  }

}
