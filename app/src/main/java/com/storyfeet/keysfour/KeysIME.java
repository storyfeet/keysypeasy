package com.storyfeet.keysfour;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.inputmethodservice.InputMethodService;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputConnection;

import com.storyfeet.keysfour.KeyMode;
import com.storyfeet.keysfour.KeyPad;
import com.storyfeet.keysfour.KeyResult;

import java.util.TimerTask;
import java.util.Timer;

public class KeysIME extends InputMethodService implements KeyPad.KeyPadListener {

    private KeyPad.KPData kpd = null;
    private Timer timer = null;
    private KeyTimerTask timertask = null;

    public KeysIME(){
        super();

        Log.d("MATT", "new KeysIME");
    }

    @Override
    public View onCreateInputView (){
        /**View kv = (View) getLayoutInflater().inflate(R.layout.keys_layout ,null);
        Button bt1 = (Button) kv.findViewById(R.id.button1);
        bt1.setOnClickListener(new BListener());**/


        Log.d("MATT", (kpd==null) ? "NO KPD" : kpd.toString());
        KeyPad kp = new KeyPad(getBaseContext());
        kp.setKeyPadListener(this);

        // Make sure timer task is pointing to correct view
        if (this.timer == null) this.timer = new Timer();
        if (timertask == null){
            this.timertask = new KeyTimerTask(kp);
            this.timer.schedule(this.timertask,300,300);
        }else {
            this.timertask.setKeyPad(kp);
        }

        return kp;
    }

    public void backspaceTo(InputConnection ic,String cList){
        String s = (String) ic.getTextBeforeCursor(40,0);
        if (s==null) return;
        for (int i = s.length() -1; i >= 0; i--){
            if (cList.indexOf(s.charAt(i)) >= 0){
                ic.deleteSurroundingText(s.length() -i , 0);
                return;
            }
        }
        ic.deleteSurroundingText(s.length(),0);
    }

    @Override
    public void onSlideKey(KeyResult key) {
        InputConnection ic = getCurrentInputConnection();

        KeyMode mode = key.getMode();
        switch (mode){
            case KEY:
                int kc = key.getKey();
                ic.sendKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN,kc));
                ic.sendKeyEvent(new KeyEvent(KeyEvent.ACTION_UP,kc));
                break;
            case ACCENT://TODO
                String s = (String) ic.getTextBeforeCursor(1,0);
                if  (s == null) return;
                if (s.length()== 0) return;
                String res = Accents.Companion.lazyCaseAccent(s.charAt(0),key.getStr().charAt(0));
                ic.deleteSurroundingText(1,0);
                ic.commitText(res,1);
                break;
            case DELETE:
                ic.deleteSurroundingText(0,1);
                break;
            case DELETE_MANY:
                ic.deleteSurroundingText(0,5);
            case BACKSPACE_1:
                ic.deleteSurroundingText(1, 0);
                break;
            case BACKSPACE_5:
                ic.deleteSurroundingText(5, 0);
                break;
            case BACKSPACE_LINE:
                backspaceTo(ic,"\n\r");
                break;
            case BACKSPACE_WORD:
                backspaceTo(ic,"\n\r\t ,.?@~%£$-_+=(){}[]<>`'\"");
                break;

            case STRING:
                ic.commitText(key.getStr(), 1);
                break;
            case CTRL:
                kc = key.getKey();
                ic.sendKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN,KeyEvent.KEYCODE_CTRL_LEFT));
                ic.sendKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN,kc));
                ic.sendKeyEvent(new KeyEvent(KeyEvent.ACTION_UP,kc));
                ic.sendKeyEvent(new KeyEvent(KeyEvent.ACTION_UP,KeyEvent.KEYCODE_CTRL_LEFT));
            case COPY:
                CharSequence cs = ic.getSelectedText(0);
                if (cs == null) return;
                ClipboardManager cm1 = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
                ClipData cdata1 = ClipData.newPlainText("K4", cs.toString());
                cm1.setPrimaryClip(cdata1);
                break;
            case PASTE:
                ClipboardManager cm2 = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
                ClipData cdata2 = cm2.getPrimaryClip();
                if (cdata2 == null) return;
                ic.commitText(cdata2.getItemAt(0).coerceToText(getBaseContext()),1);
                break;


        }

    }

    @Override
    public void saveKPData(KeyPad.KPData kpd) {
        this.kpd = kpd;
    }

    @Override
    public KeyPad.KPData restoreKPData() {
        return this.kpd;
    }


    private static class KeyTimerTask extends TimerTask {
        private KeyPad kp;
        protected KeyTimerTask(KeyPad kp){
            this.kp = kp;

        }

        public void setKeyPad(KeyPad kp){
            this.kp = kp;
        }
        @Override
        public void run() {
            kp.onTimer();
        }
    }

}
