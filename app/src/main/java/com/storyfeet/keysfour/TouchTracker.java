package com.storyfeet.keysfour;

/**
 * The touch tracker recieves a list of mouse positions, from movement events, and builds up a picture of the kind of movement the user has done,
 * Every time a cursor event happens, call "move".
 * Then, when the cursor is raised, call "calcDir"
 * it will return a DirCap Objectc containing  a .dir : DIR_... and .cap, whether this should be capitalized.
 */
public class TouchTracker {

    // The minimum distance to be counted as a swipe
    private final float minDist;
    // The most recent position of the cursor, when a hit was logged.
    private float currX ,currY;
    // The direction the cursor is considered to be moving.
    private int lastHit;

    // Did not go anywhere.  Or if cap did a full circle
    public final static int DIR_NONE = 0;

    // Went in that direction and did not turn.
    // To capitalize return in the returned in the direction it came
    public final static int DIR_UP = 1;
    public final static int DIR_RIGHT = 2;
    public final static int DIR_DOWN = 3;
    public final static int DIR_LEFT = 4;

    // Went in that direction, and then turned
    // turning left or down is lower case, 
    // turning right or up is capital
    public final static int ROUND_UL = 5;
    public final static int ROUND_UR = 6;
    public final static int ROUND_RU = 7;
    public final static int ROUND_RD = 8;
    public final static int ROUND_DR = 9;
    public final static int ROUND_DL = 10;

    public final static int ROUND_LD = 11;
    public final static int ROUND_LU = 12;


    // This is the result of a touch action.
    // Every swipe direction can be capitalized. 
    public static class DirCap{
        public int dir;
        public boolean cap;
        public DirCap(int dir,boolean cap){
            this.dir = dir;
            this.cap = cap;
        }
    }

    /**
     * Shortcut method for a function that will be called many times
     */
    private DirCap dc(int dir,boolean cap){
        return new DirCap(dir, cap);
    }

    // The list of directions the cursor has moved. Stored as a single number
    private int hitDirections = 0;
    // How many times has the cursor changed direction
    private int numHits = 0;

    /**
     * Create a new touch tracker, with an initial x, y, and mindist to count as a swipe
     * @param minDist The minimum distand required to count as a swipe in pixels
     * @param x the current cursor x position
     * @param y the current cursor y position
     */
    public TouchTracker(float minDist, float x,float y) {
        this.minDist = minDist;
        this.currX = x;
        this.currY = y;
        this.numHits = 0;
        this.hitDirections = 0;

        this.lastHit = DIR_NONE;
    }

    /**
     * Calcluate if this movement changes the status of the tracker, and if any swipes have been completed
     * @param x The new X position
     * @param y The new Y position
     */
    public void move(float x,float y){
        // Get the direcion and distance since the last time we checked
        int newDir = calcDir(currX,currY,x,y);
        float moved = calcDist(currX,currY,x,y);

        //If we moved in the same direction, make the new position our current position
        // Otherwise we don't do this, so movement in another direction can increase to reach minDist
        // This makes sure turning right, is not done measured from the start point
        if (newDir == lastHit) {
            currX = x;
            currY = y;
        }

        if (moved > minDist){
            hit(newDir);
        }

    }

    /** 
     * Returns the direction between two points o, and n
     * @param ox the x value of the Original point
     * @param oy the y value of the Original point
     * @param nx the x value of the New point
     * @param ny the y value of the New point
     * @return a DIR_... constant for the direction the cursor has moved
     */ 
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

    /**
     * Calculate the whichever distance is greater up/down or sideways,
     * and return that total distance
     * @param ox the x value of the Original point
     * @param oy the y value of the Original point
     * @param nx the x value of the New point
     * @param ny the y value of the New point
     * @return a positive int representing that distance.
     */
    float calcDist(float ox,float oy, float nx, float ny){
        float abX = Math.abs(nx -ox);
        float abY = Math.abs(ny - oy);
        return Math.max(abX,abY);

    }

    /** 
     * Mark that we have moved far enough in the new direction and add it to the current direction
     * @param   hitDir    The direction that needs to be logged as a movement
     */
    public void hit(int hitDir){
        // Any more than 5 direction changes is irrelevant
        if (numHits > 5) return;

        // If we are not changing direction don't do anything
        if (hitDir == lastHit){
            return;
        }
        lastHit = hitDir;

        // 3 bits per direction.  
        // The new direction is added on the front
        int n = hitDir << ((numHits) * 3);
        this.hitDirections |= n;


        numHits ++;

    }


    /**
     * Calculate the mode of movement that was completed by the user, and whether or not that should be capitalized.
     * @return a DirCap object, with 
     *      .dir as the DIR_... the cursor have moved, including turns, 
     *      .cap, as a boolean as to whether or not to capitalize the result
     */
    public DirCap getDirCap(){
        if (numHits == 0) return dc(DIR_NONE,false);
        if (numHits == 1) return dc(hitDirections ,false);
        if (numHits >= 4) return dc(DIR_NONE,true);

        // drop direction 3 
        // by masking against 000111111
        int hd = hitDirections & 63;

        // If the first three bits are DIR_DOWN, and the second three are DIR_UP, then we have gone UP then DOWN. That is a Capital UP
        // and so-on through the group
        if (hd == (DIR_UP | (DIR_DOWN << 3))) return dc(DIR_UP,true);
        if (hd == (DIR_DOWN | (DIR_UP << 3))) return dc(DIR_DOWN,true);
        if (hd == (DIR_LEFT | (DIR_RIGHT << 3))) return dc(DIR_LEFT,true);
        if (hd == (DIR_RIGHT | (DIR_LEFT << 3))) return dc(DIR_RIGHT,true);

        boolean cap3 = numHits == 3;
        // On 3 we gotta check directions
        // UP RIGHT is TRUE, down left is false
        // LEFT then UP is capital, LEFT then DOWN is lower case
        if (hd == (DIR_LEFT | (DIR_UP << 3 ))) return dc(ROUND_LU,cap3);
        if (hd == (DIR_LEFT | (DIR_DOWN << 3))) return dc(ROUND_LD,cap3);

        if (hd == (DIR_RIGHT | (DIR_UP << 3 ))) return dc(ROUND_RU,cap3);
        if (hd == (DIR_RIGHT | (DIR_DOWN << 3))) return dc(ROUND_RD,cap3);

        if (hd == (DIR_UP | (DIR_RIGHT << 3 ))) return dc(ROUND_UR,cap3);
        if (hd == (DIR_UP | (DIR_LEFT << 3))) return dc(ROUND_UL,cap3);

        if (hd == (DIR_DOWN | (DIR_RIGHT << 3 ))) return dc(ROUND_DR,cap3);
        if (hd == (DIR_DOWN | (DIR_LEFT << 3))) return dc(ROUND_DL,cap3);

        // No other combination makes sense.
        return null;
    }

}
