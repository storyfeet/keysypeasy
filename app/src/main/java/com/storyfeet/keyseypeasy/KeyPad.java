package com.storyfeet.keyseypeasy;

import static com.storyfeet.keyseypeasy.R.*;

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

    private final ColorSet colorSet;
    private int numRows;
    private int numCols;
    private int chosenHeight;
    private int chosenWidth;
    private int chosenSquare = 0;


    private int isPressed = 0; //0 Not moved count to 4 before repeating action
    //private String timerString = null;

    private TouchTracker touchTracker = null;
    private KeyPair[][] keys = KeyLists.getEnglish_portrait();

    private KeyPadListener kpListener = null;

    private boolean isLandscape;
    public KeyPad(Context context) {
        super(context);
        this.colorSet = new ColorSet(context);
        Log.d("MATT", "new Keypad");


        chosenHeight = 2;
        chosenWidth = 2;
        numRows = 2;
        numCols = 5;
        int or = getResources().getConfiguration().orientation;
        isLandscape = (or ==Configuration.ORIENTATION_LANDSCAPE);
        shiftState = 0;
        keys = KeyLists.Companion.pageByName("tall",isLandscape);


        this.setOnTouchListener(this);
    }


    @Override
    public void onMeasure(int wspec, int hspec){
        int w = MeasureSpec.getSize(wspec);

        int or = getResources().getConfiguration().orientation;
        isLandscape = (or ==Configuration.ORIENTATION_LANDSCAPE);

        numCols = isLandscape ? 10: 5;
        numRows = 1 + (keys.length -1 )/numCols;

        Log.d("Keysfive" , "on measure w =" + MeasureSpec.toString(wspec) + ", h = " + MeasureSpec.toString(hspec));
        Log.d("keysfive", "measured num rows = " + Integer.toString(numRows) + ", cols = " + Integer.toString(numCols));

        chosenWidth = w;

        chosenHeight =  (numRows * w)/numCols;

        setMeasuredDimension(chosenWidth,chosenHeight);
        Log.d("MATT" , "Chosen " + chosenWidth + "," + chosenHeight);


    }


    public boolean isSpecial(KeyPair kp) {
        if (kp == null) return false;
        KeyResult kres =  kp.selectKey(0,false);
        KeyMode mode = kres.getMode();
        if (mode == KeyMode.STRING) {
            if (kres.getStr().equals(" ")){
                return true;
            }
        }
        if (mode == KeyMode.BACKSPACE_1) return true;
        if (mode == KeyMode.SET_PAGE ) return true;
        if (mode == KeyMode.ACCENT ) return true;
        return false;
    }

    @Override
    public void onDraw(Canvas canvas) {
        //canvas.drawRect(0,0,chosenWidth,chosenHeight,colorSet.getPBackground(shiftState));
        canvas.drawRect(0,0,chosenWidth,chosenHeight,colorSet.getPBackground(shiftState));
        int rw = chosenWidth / numCols;
        int rh = chosenHeight / numRows;


        for (int i = 0; i < keys.length; i++){
            int x = rw * (i % (numCols));
            int y = rh * (i / (numCols) );


            Log.d("RECT", "rect : " + x + ", " + y + ", " + rw + ", " + rh);
            boolean special = isSpecial(getKey(i,0));
            if (special) {
                canvas.drawRect(x, y, x + rw, y + rh, colorSet.pSpace);
            }
            Paint pCenter = special? colorSet.pTxSpecMain: colorSet.pTxMain;
            Paint pEdge = special? colorSet.pTxSpecSecond : colorSet.pTxSecond;

            canvas.drawRect(x,y,x+rw,y+rh,colorSet.pRect);


            for (int j = 0; j < 5; j ++) {
                KeyPair key = getKey(i, j);
                if (key != null) {
                    String t = key.preview(shiftState);

                    float tSize = j == 0 ? (float) rw / (t.length() + 2) : (float) rw / (t.length()+3);

                    Paint pt = (j == 0)? pCenter : pEdge;
                    pt.setTextSize(tSize);

                    canvas.drawText(t, x + 0.5f * rw + rotX(j, rw / 3), y + 0.5f * rh  + (tSize / 3)  + rotY(j, rh / 3), pt);
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
                this.touchTracker = new TouchTracker(this.isLandscape ? chosenWidth / 30.0f : chosenWidth / 15.0f , downX,downY);
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
                Log.d("KFMatt","Setting shift to : "+shiftState);

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
                requestLayout();
                break;
            default:
                this.kpListener.onSlideKey(key);
                break;
        }
    }


    int getSquare(float dx, float dy){
        int x = (int) (dx * numCols) / chosenWidth;
        int y = (int) (dy * numRows) / chosenHeight;
        return x + (numCols*y);
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
