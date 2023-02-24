package com.example.rollingdicegame;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.webkit.JsResult;
import android.webkit.WebBackForwardList;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        WebView mywebview = findViewById(R.id.webview);
        mywebview.getSettings().setJavaScriptEnabled(true);
        mywebview.getSettings().setAllowContentAccess(true);
        mywebview.getSettings().setAllowFileAccess(true);
        mywebview.loadUrl("file:///android_asset/dicegame.html");

        mywebview.setWebChromeClient(new WebChromeClient() {
            public boolean onJsAlert(WebView view, String url, String message, final JsResult result) {
                AlertDialog dialog = new AlertDialog.Builder(view.getContext()).
                        setTitle("Wrong number of dice!").
                        setMessage(message).
                        setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                //do nothing
                            }
                        }).create();
                dialog.show();
                result.confirm();
                return true;
            }
        });
    }
}