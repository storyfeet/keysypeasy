package com.storyfeet.keysfour;

import static com.storyfeet.keysfour.R.*;

import android.content.Context;
import android.content.res.Configuration;
import android.view.MotionEvent;
import android.view.View;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.Log;

import androidx.annotation.NonNull;

public class KeyPad extends View implements View.OnTouchListener {

    public static class KPData{
        String chosen;
        private KPData(String chosen){
            this.chosen = chosen;

        }
        @NonNull
        @Override
        public String toString(){
            return chosen;
        }
    }



    public interface KeyPadListener{
        void onSlideKey(KeyResult key);
        void saveKPData(KPData kpd);
        KPData restoreKPData();
    }


    private int shiftState ;

    private ColorSet colorSet;

    private final Paint rectPaint;



    private final Paint txPaint;
    private final Paint txEdgePaint;


    private int chosenHeight;
    private int chosenWidth;
    private int chosenSquare = 0;


    private int isPressed = 0; //0 Not moved count to 4 before repeating action
    //private String timerString = null;

    private TouchTracker touchTracker = null;
    private KeyPair[][] keys = KeyLists.getLower_portrait();

    private KeyPadListener kpListener = null;

    private boolean isLandscape;
    public KeyPad(Context context) {
        super(context);
        this.colorSet = new ColorSet(context);
        Log.d("MATT", "new Keypad");


        Paint bp = new Paint();
        bp.setColor(getResources().getColor(color.teal_700));
        bp.setStyle(Paint.Style.STROKE);
        bp.setStrokeWidth(4.0f);
        rectPaint = bp;

        bp = new Paint();
        bp.setColor(getResources().getColor(color.tx_main));
        bp.setTextSize(20);
        bp.setTextAlign(Paint.Align.CENTER);
        txPaint = bp;

        bp = new Paint();
        bp.setTextAlign(Paint.Align.CENTER);
        bp.setColor(getResources().getColor(color.tx_second));
        bp.setTextSize(15);
        txEdgePaint = bp;

        chosenHeight = 2;
        chosenWidth = 2;
        int or = getResources().getConfiguration().orientation;
        isLandscape = (or ==Configuration.ORIENTATION_LANDSCAPE);
        shiftState = 0;
        keys = KeyLists.Companion.pageByName("lower",isLandscape);


        this.setOnTouchListener(this);
    }


    @Override
    public void onMeasure(int wspec, int hspec){
        int w = MeasureSpec.getSize(wspec);

        int or = getResources().getConfiguration().orientation;
        isLandscape = (or ==Configuration.ORIENTATION_LANDSCAPE);



        Log.d("MATT" , "on measure w =" + MeasureSpec.toString(wspec) + ", h = " + MeasureSpec.toString(hspec));

        chosenWidth = w;

        chosenHeight = isLandscape ? w/10 : (2*w) /5;

        setMeasuredDimension(chosenWidth,chosenHeight);
        Log.d("MATT" , "Chosen " + chosenWidth + "," + chosenHeight);


    }



    @Override
    public void onDraw(Canvas canvas) {
        canvas.drawRect(0,0,chosenWidth,chosenHeight,colorSet.getBackground(shiftState));

        int mod = isLandscape ? 10 : 5;
        int rw = isLandscape ? chosenWidth / 10 : chosenWidth / 5;
        int rh = isLandscape ? chosenHeight  : chosenHeight / 2;

        for (int i = 0; i < 10; i++){
            int x = rw * (i % mod) ;
            int y = rh * (i / mod);
            canvas.drawRect(x, y,rw,rh,rectPaint );

            //Log.d("MATT", "rect : " + x + "," + y + "," + rw + "," + rh);
            for (int j = 0; j < 5; j ++) {
                KeyPair key = getKey(i, j);
                if (key != null) {
                    String t = key.preview(shiftState);
                    Paint pt = txPaint;
                    int tSize = j == 0 ? rw / 3 : rw / 4;
                    pt.setTextSize(tSize);

                    canvas.drawText(t, x + 0.5f * rw + rotX(j, rw / 3), y + 0.6f * rh + rotY(j, rh / 3), pt);
                }
            }
        }

    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        //Log.d("MATT", "touch event happened: " + event.toString() );
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                float downX = event.getX();
                float downY = event.getY();
                this.chosenSquare = getSquare(downX,downY);
                isPressed = 1;
                this.touchTracker = new TouchTracker(this.isLandscape ? chosenWidth / 50.0f : chosenWidth / 25.0f , downX,downY);
                Log.d("MATT","touch_down : x = "+ downX + ", y = " + downY);
                break;
            case MotionEvent.ACTION_MOVE:
                if (this.touchTracker == null) return false;
                this.touchTracker.move(event.getX(),event.getY());
                break;
            case MotionEvent.ACTION_UP:
                if (this.touchTracker == null) return false;
                if (isPressed > 3){
                    this.touchTracker = null;
                    return true;
                }
                isPressed = 0;
                this.touchTracker.move(event.getX(),event.getY());
                int oldShift = shiftState;
                processKey();
                this.touchTracker = null;
                if (oldShift == shiftState && shiftState == 1){
                    shiftState = 0;
                    invalidate();
                }



        }
        return true;
    }

    public void processKey(){
        TouchTracker.DirCap dc = touchTracker.getDirCap();
        if (dc == null){
            return;
        }

        Log.d("MATT","processKey : x = "
                + ", dir = " + dc.dir
                + ", cap = " + dc.cap
                + ", sqr = " + chosenSquare);

        KeyPair kp = getKey(chosenSquare,dc.dir);
        if (kp == null) return;

        KeyResult key = kp.selectKey(shiftState,dc.cap);
        if (key == null) return;

        switch (key.getMode()){

            case SET_SHIFT:
                this.shiftState = (this.shiftState + 1) % 3;
                Log.d("KFMatt","Settging shift to : "+shiftState);

                invalidate();
                break;
            case SET_VERY_SHIFT:
                shiftState = (shiftState==0) ? 2 : 0;
                invalidate();
                break;
            case SET_PAGE:
                String s = key.getStr();
                this.keys = KeyLists.Companion.pageByName(s,isLandscape);
                this.kpListener.saveKPData(new KPData(s));
                invalidate();
                break;
            default:
                this.kpListener.onSlideKey(key);
                break;
        }
    }


    int getSquare(float dx, float dy){
        if (isLandscape){
            return (int) ((dx * 10) / chosenWidth);

        }
        int x = (int) ((dx * 5 )/chosenWidth);
        int y = (int) (dy * 2) / chosenHeight;
        return x + (5*y);
    }

    void setKeyPadListener(KeyPadListener kpl) {

        this.kpListener = kpl;

        KPData kd = kpl.restoreKPData();
        if (kd == null) return;
        this.keys = KeyLists.Companion.pageByName(kd.chosen, isLandscape);

    }

    KeyPair getKey(int n, int angle){
        if (n >= keys.length) return null;

        if (angle >= keys[n].length) return null;

        return keys[n][angle];
    }

    int rotX(int dir,int dist){
        switch (dir){
            case TouchTracker.DIR_LEFT: return -dist;
            case TouchTracker.DIR_RIGHT: return +dist;
            default: return 0;
        }
    }
    int rotY(int dir, int dist) {
        switch(dir){
            case TouchTracker.DIR_UP:return -dist;
            case TouchTracker.DIR_DOWN: return dist;
            default: return 0;
        }
    }

    void onTimer(){
        Log.d("KEYSTHREE", "Timer call ");

        if (touchTracker == null) return;
        Log.d("KEYSTHREE", "Timer, Key is pressed : n = " + isPressed);
        isPressed ++;
        if (isPressed < 4) {
            return;
        }

        processKey();






    }

}
