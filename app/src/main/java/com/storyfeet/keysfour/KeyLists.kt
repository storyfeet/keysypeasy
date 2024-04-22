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

        val THA = LongKey("tha")
        val HER = LongKey("her")
        val TER = LongKey("ter")
        val THE = LongKey("the")
        val WAS = LongKey("was")
        val AND = LongKey("and")
        val NOT = LongKey("not")
        val ENT = LongKey("ent")
        val HAT = LongKey("hat")
        val FOR = LongKey("for")
        val ION = LongKey("ion")
        val ING = LongKey("ing")
        val YOU = LongKey("you")
        val QU = LongKey("qu")

        val D_COM = LongKey(".com")
        val D_CO = LongKey(".co")
        val D_UK = LongKey(".uk")
        val D_ORG = LongKey(".org")
        val D_GOV = LongKey(".gov")

        val _0 = CharPair("0", "&")
        val _1 = CharPair("1", "!")
        val _2 = CharPair("2", "~")
        val _3 = CharPair("3", "£")
        val _4 = CharPair("4", "$")
        val _5 = CharPair("5", "%")
        val _6 = CharPair("6", "^")
        val _7 = CharPair("7", ")")
        val _8 = CharPair("8", "*")
        val _9 = CharPair("9", "(")

        val Dash = CharPair("-", "_")
        val FStop = CharPair(".", ",")
        val At = CharPair("@", "?")
        val Colons = CharPair(";",":")
        val Space = LockedPair(
                Invisible(" ", "' '"),
                SpecialKey(KeyEvent.KEYCODE_TAB, "↦")
        )
        val Quotes = CharPair("'","\"",)

        //Arrows

        val ArrowUp = oneSpecialKey(KeyEvent.KEYCODE_DPAD_UP,"↑")
        val ArrowDown = oneSpecialKey(KeyEvent.KEYCODE_DPAD_DOWN,"↓")
        val ArrowLeft = oneSpecialKey(KeyEvent.KEYCODE_DPAD_LEFT,"←")
        val ArrowRight = oneSpecialKey(KeyEvent.KEYCODE_DPAD_RIGHT,"→")
        val ArrowCenter = oneSpecialKey(KeyEvent.KEYCODE_DPAD_CENTER,"⊙")

        val LeftRight = LockedPair(ArrowLeft,ArrowRight)
        val DownUp = LockedPair(ArrowDown,ArrowUp)


        val ArrowPad :Array<out KeyPair> = arrayOf(ArrowCenter, ArrowUp, ArrowRight,ArrowDown, ArrowLeft)


        //Links Go Page
        val GoSym = goKey("symbol","_S")

        val GoHome = goKey("tall","EN")
        val GoSmall = goKey("english", "SML")





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

        val CPPaste = LockedPair(
            OneKey(KeyMode.PASTE,"","_V",KeyEvent.KEYCODE_V),
            OneKey(KeyMode.COPY,"","_C",KeyEvent.KEYCODE_C),
        )

        val Enter = oneSpecialKey(  KeyEvent.KEYCODE_ENTER,"↲")

        val Empty = CapLetter("")

        //Squares
        val ZeroPad = arrayOf(_0, _1, _2, _3, _4)
        val FivePad = arrayOf(_5, _6, _7, _8, _9)
        val RPad = arrayOf(R, G, Q, D, U)
        val EPad = arrayOf(E, Y, O, C, B)
        val APad = arrayOf(A, N, FStop, F, V, Empty,Empty,Empty, CPPaste)
        val TPad = arrayOf(T, X, H, J, At)
        val SPad = arrayOf(S, K, M, P, Colons)
        val SpacePad = arrayOf(Space,L,I, Z,W ,LeftRight, DownUp)
        val EnterPad = arrayOf(Quotes, Dash, Delete, Enter, BackSpace)
        val GoPad = arrayOf(GoHome, Shift, GoSym, GoSmall, Empty)

        @JvmStatic
        val english_portrait = arrayOf(
                ZeroPad, TPad, EPad, RPad, EnterPad,
                FivePad, SPad, SpacePad, APad, GoPad
        )
        @JvmStatic
        val english_landscape = arrayOf(
            ZeroPad, FivePad, SPad, TPad, EPad, SpacePad, APad, RPad, EnterPad, GoPad
        )

        val ParenOne = arrayOf(
            CharPair("#","~"),
            CharPair("?","¿"),
            CharPair(")",">"),
            CharPair("!","¡"),
            CharPair("(","<")
        )


        val ParenTwo = arrayOf(
            CharPair("%","`"),
            CharPair("•","☰"),
            CharPair("]","}"),
            CharPair("|","¬"),
            CharPair("[","{"),
        )

        val MathOne = arrayOf(
            CharPair("=","≠"),
            CharPair("+","_"),
            CharPair("/","\\"),
            CharPair("*","^"),
            CharPair("-","—"),

        )

        val MoneyOne = arrayOf(
            CharPair("$","₹",),
            CharPair("£","₽"),
            CharPair("€","₩"),
            CharPair("₿","₭"),
            CharPair("¥","₡"),
        )

        val AccentPad = arrayOf(
            accentPair("ã","ä"),
            accentPair("à","à"),
            accentPair("á","á"),
            accentPair("ç","ç"),
            accentPair("â","â"),

        )

        val EmptyPad:Array<out KeyPair> = arrayOf()

        @JvmStatic
        val symbol_portrait = arrayOf(
            AccentPad,ParenOne,ParenTwo,MathOne,EnterPad,
            EmptyPad,ArrowPad,SpacePad,MoneyOne,GoPad
        )

        val symbol_landscape = arrayOf(
            AccentPad, EmptyPad,ParenOne, ParenTwo,ArrowPad, MathOne,SpacePad,MoneyOne, EnterPad,GoPad,
        )


        val TallT = arrayOf(T,THA,W,Z,THE)
        val TallH = arrayOf(H,HER,QU,Y,X)
        val TallE = arrayOf(E,TER,WAS,R,V)
        val TallA = arrayOf(A,P,L,F,AND)
        val TallSpace = arrayOf(Space,At,FStop,Quotes, Colons)
        val TallN = arrayOf(N,K,NOT,D,G)
        val TallS = arrayOf(S,ENT,M,FOR,HAT)
        val TallO = arrayOf(O,U,B,ION,Q)
        val TallI = arrayOf(I,C,YOU,ING,J)
        val TallCom = arrayOf(D_COM,D_CO,D_UK,D_ORG,D_GOV)


        val EN_TALL_PORTRAIT = arrayOf(
            AccentPad,TallT,TallH,TallE,TallCom,
            ZeroPad,TallA,TallSpace,TallN, EnterPad,
            FivePad,TallS,TallO,TallI,GoPad,
        )



        fun pageByName(name: String,landscape:Boolean): Array<Array<out KeyPair>> {
            if (name == "symbol") return if (landscape) symbol_landscape else symbol_portrait;
            if (name == "english") return if (landscape) english_landscape else english_portrait;
            return EN_TALL_PORTRAIT;

        }

    }



}


