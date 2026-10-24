package com.quint.kitchenquest;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class MainActivity extends Activity {
    private WebView web;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        web = new WebView(this);
        WebSettings s = web.getSettings();
        s.setJavaScriptEnabled(true);
        s.setDomStorageEnabled(true); // localStorage holds the career save
        web.addJavascriptInterface(new Bridge(), "AndroidBridge");
        web.loadUrl("file:///android_asset/index.html");
        setContentView(web);
    }

    /** JS bridge: the game calls AndroidBridge.exitApp() to quit. */
    private class Bridge {
        @JavascriptInterface
        public void exitApp() {
            runOnUiThread(new Runnable() {
                public void run() { finish(); }
            });
        }
    }

    /** Back button: quit the shift in play, otherwise exit the app. */
    @Override
    public void onBackPressed() {
        if (web != null) {
            web.evaluateJavascript(
                "if(typeof scene!=='undefined'&&scene==='play'){quitShift();}else{AndroidBridge.exitApp();}",
                null);
        } else {
            super.onBackPressed();
        }
    }
}
