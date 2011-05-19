
package com.phonegap.NFC;

import android.app.Activity;
import android.os.Bundle;
import com.phonegap.*;
import android.content.Intent;


public class NFC extends DroidGap
{
    @Override
        public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        super.loadUrl("file:///android_asset/www/index.html");
    }
       
}
