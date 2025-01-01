package com.storyfeet.keyseypeasy

import android.content.Context
import android.graphics.Paint
import androidx.core.content.ContextCompat

class ColorSet() {
    private var shiftNone:Int = 0
    private var shiftOn:Int = 0
    private var shiftLock:Int = 0
    private var spaceBox:Int = 0;
    private lateinit var pShiftNone:Paint
    private lateinit var pShiftOn:Paint
    private lateinit var  pShiftLock:Paint

    private var txMain: Int = 0
    private var txSecond: Int = 0
    lateinit var pTxMain:Paint
    lateinit var pTxSecond:Paint
    lateinit var pTxSpecMain : Paint
    lateinit var pTxSpecSecond: Paint

    lateinit var pSpace:Paint
    lateinit var pRect:Paint
    
    constructor(ctx:Context) : this() {
        shiftNone = ContextCompat.getColor(ctx,R.color.bg_shift_none)
        shiftOn = ContextCompat.getColor(ctx,R.color.bg_shift_on)
        shiftLock = ContextCompat.getColor(ctx,R.color.bg_shift_lock)
        spaceBox = ContextCompat.getColor(ctx,R.color.light_gray)
        pShiftOn = makeBackground(shiftOn)
        pShiftNone = makeBackground(shiftNone)
        pShiftLock = makeBackground(shiftLock)
        pSpace = makeBackground(spaceBox)

        txMain = ContextCompat.getColor(ctx,R.color.tx_main)
        txSecond = ContextCompat.getColor(ctx,R.color.tx_second)
        pTxMain = makeText(txMain,Paint.Align.CENTER,20f)
        pTxSecond = makeText(txSecond,Paint.Align.CENTER,15f)
        pTxSpecMain = makeText(ContextCompat.getColor(ctx,R.color.black),Paint.Align.CENTER,4f)
        pTxSpecSecond = makeText(ContextCompat.getColor(ctx,R.color.dark_gray),Paint.Align.CENTER,4f)


        pRect = makeStroke(ContextCompat.getColor(ctx,R.color.teal_700),4f)
    }

    fun makeBackground(col:Int):Paint{
        val res = Paint()
        res.color = col
        return res
    }

    fun makeText(col:Int, align: Paint.Align, size:Float):Paint{
        val res =makeBackground(col)
        res.textAlign = align
        res.textSize = size
        return res;
    }

    fun makeStroke(col:Int, width:Float):Paint{
        val bp = Paint();
        bp.setColor(col);
        bp.setStyle(Paint.Style.STROKE);
        bp.setStrokeWidth(width);
        return bp;
    }


    fun getPText(pos:Int,tSize:Float):Paint{
        val res = if (pos == 0) pTxMain else pTxSecond
        res.textSize = tSize
        return res
    }


    fun getPBackground(shiftState: Int):Paint{
        return when (shiftState){
            0-> pShiftNone
            1-> pShiftOn
            else -> pShiftLock
        }
    }




}