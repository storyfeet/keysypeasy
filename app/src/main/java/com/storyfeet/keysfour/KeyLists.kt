package com.storyfeet.keysfour

import android.view.KeyEvent

class KeyLists {

    companion object {
        val A = CapLetter("a")
        val B = CapLetter("b")
        val C = CapLetter("c")
        val D = CapLetter("d")
        val E = CapLetter("e")
        val F = CapLetter("f")
        val G = CapLetter("g")
        val H = CapLetter("h")
        val I = CapLetter("i")
        val J = CapLetter("j")
        val K = CapLetter("k")
        val L = CapLetter("l")
        val M = CapLetter("m")
        val N = CapLetter("n")
        val O = CapLetter("o")
        val P = CapLetter("p")
        val Q = CapLetter("q")
        val R = CapLetter("r")
        val S = CapLetter("s")
        val T = CapLetter("t")
        val U = CapLetter("u")
        val V = CapLetter("v")
        val W = CapLetter("w")
        val X = CapLetter("x")
        val Y = CapLetter("y")
        val Z = CapLetter("z")

        val _0 = CharPair("0", "&")
        val _1 = CharPair("1", "!")
        val _2 = CharPair("2", "\"")
        val _3 = CharPair("3", "£")
        val _4 = CharPair("4", "$")
        val _5 = CharPair("5", "%")
        val _6 = CharPair("6", "^")
        val _7 = CharPair("7", ")")
        val _8 = CharPair("8", "*")
        val _9 = CharPair("9", "(")

        val Dash = CharPair("-", "_")
        val Comma = CharPair(",", ".")
        val At = CharPair("@", "~")
        val Colons = CharPair(";",":")
        val Space = LockedPair(
                Invisible(" ", "' '"),
                SpecialKey(KeyEvent.KEYCODE_TAB, "↦")
        )

        //Arrows

        val ArrowUp = oneSpecialKey(KeyEvent.KEYCODE_DPAD_UP,"↑")
        val ArrowDown = oneSpecialKey(KeyEvent.KEYCODE_DPAD_DOWN,"↓")
        val ArrowLeft = oneSpecialKey(KeyEvent.KEYCODE_DPAD_LEFT,"←")
        val ArrowRight = oneSpecialKey(KeyEvent.KEYCODE_DPAD_RIGHT,"→")
        val ArrowCenter = oneSpecialKey(KeyEvent.KEYCODE_DPAD_CENTER,"⊙")

        val ArrowPad :Array<out KeyPair> = arrayOf(ArrowCenter, ArrowUp, ArrowRight,ArrowDown, ArrowLeft)


        //Links Go Page
        val GoSym = goKey("symbol","_S")
        val GoHome = goKey("lower","EN")




        val Shift = LockedPair(
                oneModeKey(KeyMode.SET_SHIFT, "⇧"),
                oneModeKey(KeyMode.SET_VERY_SHIFT, "⇧")
        )

        val BackSpace = LockedPair(
                oneModeKey(KeyMode.BACKSPACE, "↼"),
                oneModeKey(KeyMode.BACKSPACE_MANY, "↼")
        )

        val Delete = LockedPair(
            oneModeKey(KeyMode.DELETE, "↼"),
            oneModeKey(KeyMode.DELETE_MANY, "↼")
        )

        val Enter = oneSpecialKey(  KeyEvent.KEYCODE_ENTER,"↲")

        val Empty = CapLetter("")

        //Squares
        val ZeroPad = arrayOf(_0, _1, _2, _3, _4)
        val FivePad = arrayOf(_5, _6, _7, _8, _9)
        val RPad = arrayOf(R, L, M, C, N)
        val EPad = arrayOf(E, W, I, O, U)
        val APad = arrayOf(A, V, X, Y, B)
        val TPad = arrayOf(T, F, J, H, K)
        val BPad = arrayOf(S, P, D, Q, G)
        val SpacePad = arrayOf(Space, Z, Comma, Colons, At)
        val EnterPad = arrayOf(Empty, Dash, Delete, Enter, BackSpace)
        val GoPad = arrayOf(GoHome, Shift, GoSym, Empty, Empty)

        @JvmStatic
        val lower_portrait = arrayOf(
                ZeroPad, RPad, APad, EPad, EnterPad,
                FivePad, TPad, SpacePad, BPad, GoPad
        )

        @JvmStatic
        val lower_landscape = arrayOf(
                ZeroPad, FivePad, RPad, TPad, APad, SpacePad, BPad, EPad, EnterPad, GoPad
        )

        @JvmStatic
        val symbol_portrait = arrayOf(
            ArrowPad,SpacePad,GoPad
        )





        fun pageByName(name: String,landscape:Boolean): Array<Array<out KeyPair>> {
            if (name == "lower") return if (landscape) lower_landscape else lower_portrait;
            if (name == "symbol") return symbol_portrait;
            //TODO add more classes and items
            return if (landscape) lower_landscape else lower_portrait;

        }

    }



}


