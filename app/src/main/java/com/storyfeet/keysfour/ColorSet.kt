package com.storyfeet.keysfour

import android.content.Context
import android.graphics.Color
import android.graphics.Paint
import androidx.core.content.ContextCompat
import androidx.core.content.res.ComplexColorCompat

class ColorSet() {
    private var shiftNone:Int = 0
    private var shiftOn:Int = 0
    private var shiftLock:Int = 0
    private lateinit var pShiftNone:Paint
    private lateinit var pShiftOn:Paint
    private lateinit var  pShiftLock:Paint
    constructor(ctx:Context) : this() {
        shiftNone = ContextCompat.getColor(ctx,R.color.bg_shift_none)
        shiftOn = ContextCompat.getColor(ctx,R.color.bg_shift_on)
        shiftLock = ContextCompat.getColor(ctx,R.color.bg_shift_lock)
        pShiftOn = makeBackground(shiftOn)
        pShiftNone = makeBackground(shiftNone)
        pShiftLock = makeBackground(shiftLock)
    }

    fun makeBackground(col:Int):Paint{
        val res = Paint()
        res.color = col
        return res
    }



    fun getBackground(shiftState: Int):Paint{
        return when (shiftState){
            0-> pShiftNone
            1-> pShiftOn
            else -> pShiftLock
        }
    }




}