
package com.phonegap.NFC;

import android.app.Activity;
import android.os.Bundle;
import com.phonegap.*;
import android.content.Intent;
import android.nfc.NfcAdapter;
import android.os.Parcelable;
import android.util.*;
import com.google.common.primitives.UnsignedBytes;
import java.lang.reflect.*;
import java.util.*;

public class NFC extends DroidGap
{
    @Override
        public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        String tag = parse_tag(getIntent());
        super.loadUrl("file:///android_asset/www/index.html?nfc_tag="+tag);
    }

    String parse_tag(Intent intent) {
        if (NfcAdapter.ACTION_TAG_DISCOVERED.equals(intent.getAction())) {
            try{
                Parcelable tag = intent.getParcelableExtra("android.nfc.extra.TAG");
                Field f = tag.getClass().getDeclaredField("mId");
                f.setAccessible(true);

                byte[] mId = (byte[]) f.get(tag);
                StringBuilder sb = new StringBuilder();

                for (byte id : mId) {
                    String hexString = Integer.toHexString(UnsignedBytes.toInt(id));
                    if (hexString.length() == 1) sb.append("0");
                    sb.append(hexString);
                }
                
                return sb.toString();
            }

            catch(Exception e){
                e.printStackTrace();
            }
        }
        return "";
    }
        
}
