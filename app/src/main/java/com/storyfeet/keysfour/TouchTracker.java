package com.storyfeet.keysfour;

public class TouchTracker {

    private final float minDist, startX ,startY;
    private int currHit;
    public final static int DIR_NONE = 0;
    public final static int DIR_UP = 1;
    public final static int DIR_RIGHT = 2;
    public final static int DIR_DOWN = 3;
    public final static int DIR_LEFT = 4;

    public static final int HIT_NONE = 5;


    public static class DirCap{
        public int dir;
        public boolean cap;
        public DirCap(int dir,boolean cap){
            this.dir = dir;
            this.cap = cap;
        }
    }
    private DirCap dc(int dir,boolean cap){
        return new DirCap(dir, cap);
    }

    private int hitDirections = 0;
    private int numHits = 0;
    public TouchTracker(float minDist, float x,float y) {
        this.minDist = minDist;
        this.startX = x;
        this.startY = y;
        this.currHit = HIT_NONE;
        this.numHits = 0;
        this.hitDirections = 0;
    }

    public void move(float x,float y){
        int newDir = getHit(x,y);
        if (newDir == currHit) return;
        if (numHits > 5) return;
        currHit = newDir;

        int n = currHit << ((numHits) * 3);
        this.hitDirections |= n;

        numHits ++;
    }

    int getHit(float x, float y){

        float abX = Math.abs(x -startX);
        float abY = Math.abs(y - startY);
        if (abX < minDist && abY < minDist) return HIT_NONE;
        if (abX > abY) {
            if (x > startX) return DIR_RIGHT;
            return DIR_LEFT;
        }
        if (y > startY) return DIR_DOWN;
        return DIR_UP;
    }

    public DirCap getDirCap(){
        if (numHits > 5) return null;
        if (numHits >= 3) return dc(DIR_NONE,true); //shortcur may fix later
        if (numHits == 0) return dc(DIR_NONE,false);
        if (numHits == 1) return dc(hitDirections ,false);
        if (numHits == 2) return dc(hitDirections & 7, true);
        /*if (hitDirections == (DIR_LEFT | (HIT_NONE << 3))) return dc(DIR_LEFT,true);
        if (hitDirections == (DIR_RIGHT | (HIT_NONE << 3))) return dc(DIR_RIGHT,true);
        if (hitDirections == (DIR_DOWN | (HIT_NONE << 3))) return dc(DIR_DOWN,true);
        if (hitDirections == (DIR_UP | (HIT_NONE << 3))) return dc(DIR_UP,true);*/
        return null;
    }



}
