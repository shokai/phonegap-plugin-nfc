package org.shokai.phonegap.plugin.nfc;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import android.util.Log;
import com.phonegap.api.Plugin;
import com.phonegap.api.PluginResult;
import com.phonegap.api.PluginResult.Status;
import android.content.Intent;
import android.nfc.NfcAdapter;
import android.os.Parcelable;
import android.util.*;
import com.google.common.primitives.UnsignedBytes;
import java.lang.reflect.*;
import java.util.*;

public class NfcPlugin extends Plugin {
    public static final String ACTION = "id";
    
    @Override
    public PluginResult execute(String action, JSONArray data, String callbackId){
        PluginResult res = null;
        if(action.equals(ACTION)){
            try{
                String tag = parse_tag(ctx.getIntent());
                JSONObject json = new JSONObject();
                json.put("id", tag);
                Log.d("NfcPlugin", "Returning " + json.toString());
                return new PluginResult(Status.OK, json);
            }
            catch(JSONException e){
                Log.d("NfcPlugin", "Got JSON Exception "+e.getMessage());
                return new PluginResult(Status.JSON_EXCEPTION);
            }
        }
        else{
            Log.d("NfcPlugin", "Invalid action : " + action + " passed");
            return new PluginResult(Status.INVALID_ACTION);
        }
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
