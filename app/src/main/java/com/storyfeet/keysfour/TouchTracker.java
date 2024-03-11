package com.storyfeet.keysfour;

public class TouchTracker {

    private final float minDist;
    private float currX ,currY;
    private int lastHit;

    public final static int DIR_NONE = 0;
    public final static int DIR_UP = 1;
    public final static int DIR_RIGHT = 2;
    public final static int DIR_DOWN = 3;
    public final static int DIR_LEFT = 4;

    public final static int ROUND_UP = 5;
    public final static int ROUND_RIGHT = 6;
    public final static int ROUND_DOWN = 7;
    public final static int ROUND_LEFT = 8;


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
        this.currX = x;
        this.currY = y;
        this.numHits = 0;
        this.hitDirections = 0;

        this.lastHit = DIR_NONE;
    }

    public void move(float x,float y){
        int newDir = calcDir(currX,currY,x,y);
        float moved = calcDist(currX,currY,x,y);

        if (newDir == lastHit) {
            currX = x;
            currY = y;
        }

        if (moved > minDist){
            hit(newDir);
        }

    }

    int calcDir(float ox,float oy, float nx, float ny){
        float abX = Math.abs(nx -ox);
        float abY = Math.abs(ny - oy);
        if (abX > abY){
            if (nx > ox) return DIR_RIGHT;
            return DIR_LEFT;
        }
        if (ny > oy) return DIR_DOWN;
        return DIR_UP;
    }

    float calcDist(float ox,float oy, float nx, float ny){
        float abX = Math.abs(nx -ox);
        float abY = Math.abs(ny - oy);
        return Math.max(abX,abY);

    }

    public void hit(int hitDir){
        if (numHits > 5) return;

        if (hitDir == lastHit){
            return;
        }
        lastHit = hitDir;

        int n = hitDir << ((numHits) * 3);
        this.hitDirections |= n;


        numHits ++;

    }

    public DirCap getDirCap(){
        if (numHits == 0) return dc(DIR_NONE,false);
        if (numHits == 1) return dc(hitDirections ,false);
        if (numHits >= 4) return dc(DIR_NONE,true);
        int hd = hitDirections & 63;

        if (hd == (DIR_UP | (DIR_DOWN << 3))) return dc(DIR_UP,true);
        if (hd == (DIR_DOWN | (DIR_UP << 3))) return dc(DIR_DOWN,true);
        if (hd == (DIR_LEFT | (DIR_RIGHT << 3))) return dc(DIR_LEFT,true);
        if (hd == (DIR_RIGHT | (DIR_LEFT << 3))) return dc(DIR_RIGHT,true);

        // On 3 we gotta check directions
        // UP RIGHT is TRUE, down left is false
        if (hd == (DIR_LEFT | (DIR_UP << 3 ))) return dc(ROUND_LEFT,true);
        if (hd == (DIR_LEFT | (DIR_DOWN << 3))) return dc(ROUND_LEFT,false);

        if (hd == (DIR_RIGHT | (DIR_UP << 3 ))) return dc(ROUND_RIGHT,true);
        if (hd == (DIR_RIGHT | (DIR_DOWN << 3))) return dc(ROUND_RIGHT,false);

        if (hd == (DIR_UP | (DIR_RIGHT << 3 ))) return dc(ROUND_UP,true);
        if (hd == (DIR_UP | (DIR_LEFT << 3))) return dc(ROUND_UP,false);

        if (hd == (DIR_DOWN | (DIR_RIGHT << 3 ))) return dc(ROUND_DOWN,true);
        if (hd == (DIR_DOWN | (DIR_LEFT << 3))) return dc(ROUND_DOWN,false);
        /*if (hitDirections == (DIR_LEFT | (HIT_NONE << 3))) return dc(DIR_LEFT,true);
        if (hitDirections == (DIR_RIGHT | (HIT_NONE << 3))) return dc(DIR_RIGHT,true);
        if (hitDirections == (DIR_DOWN | (HIT_NONE << 3))) return dc(DIR_DOWN,true);
        if (hitDirections == (DIR_UP | (HIT_NONE << 3))) return dc(DIR_UP,true);*/
        return null;
    }



}
