Phonegap Plugin NFC
===================

Install NFC Plugin
------------------

    % cd Android
    % mkdir -p /yourapp/src/org/shokai/phonegap/plugin/nfc/
    % cp NfcPlugin.java /yourapp/src/org/shokai/phonegap/plugin/nfc/
    % cp phonegap.nfc.js /yourapp/assets/www/


Install [guava-lib](http://code.google.com/p/guava-libraries/)
--------------------------------------------------------------

    % cp guava-r09.jar /yourapp/libs/


fix AndroidManifest.xml
-----------------------

add permission

    <uses-feature android:name="android.hardware.nfc" android:required="true" />
    <uses-permission android:name="android.permission.NFC" />

add intent-filter

    <intent-filter>
      <action android:name="android.intent.action.MAIN" />
      <category android:name="android.intent.category.LAUNCHER" />
    </intent-filter>
    <intent-filter>
      <action android:name="android.nfc.action.TAG_DISCOVERED" />
      <category android:name="android.intent.category.DEFAULT" />
    </intent-filter>



Use
---

index.html

    <script src='./phonegap.nfc.js' type='text/javascript' />


    document.addEventListener('deviceready', function(){
        window.plugins.nfc.id(
            function(tag){
                var id = tag.id; // get Tag ID;
            },
            function(e){
                log(e);
            });
        
    }, true);
    