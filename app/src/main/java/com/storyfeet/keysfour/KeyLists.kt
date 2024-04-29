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

        val AND = LongKey("and")
        val ANG = LongKey("ang")
        val ANT = LongKey("ant")

        val ARE = LongKey("are")
        val BECAUSE = LongKey("because")
        val CAN = LongKey("can")
        val DAY = LongKey("day")
        val ENT = LongKey("ent")

        val FAR = LongKey("far")
        val FOR = LongKey("for")
        val FROM = LongKey("from")
        val GET = LongKey("get")
        val HAS = LongKey("has")
        val HAVE = LongKey("have")
        val HER = LongKey("her")
        val HIM = LongKey("him")
        val IGN = LongKey("ign")
        val ION = LongKey("ion")
        val ING = LongKey("ing")
        val ITE = LongKey("ite")
        val IGHT = LongKey("ight")
        val JUST = LongKey("just")
        val KNOW = LongKey("know")
        val LIKE = LongKey("like")

        val MAKE = LongKey("make")
        val NOT = LongKey("not")
        val NT = LongKey("n't")
        val OUGH = LongKey("ough")

        val PLEASE = LongKey("please")

        val QU = LongKey("qu")
        val SORRY = LongKey("sorry")
        val TER = LongKey("ter")
        val TEN = LongKey("ten")
        val THA = LongKey("tha")
        val THANK = LongKey("thank")
        val THE = LongKey("the")

        val THI = LongKey("thi")
        val THOU = LongKey("thou")

        val WAS = LongKey("was")
        val WERE = LongKey("were")
        val WITH = LongKey("with")

        val YES= LongKey("yes")
        val YOU = LongKey("you")
        val YOURE = LongKey("you're")





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

        val FIRST = CharPair("1st","0th")
        val SECOND = CharPair("2nd","}")
        val THIRD = CharPair("3rd","<")
        val FOURTH = CharPair("4th","{")
        val SIXTH = CharPair("6th","5th")
        val SEVENTH = CharPair("7th","]")
        val EIGHTH = CharPair("8th",">")
        val NINTH = CharPair("9th","[")

        val Dash = CharPair("-", "_")
        val FStop = CharPair(".", ",")
        val At = CharPair("@", "?")
        val Colons = CharPair(";",":")
        val Space = LockedPair(
                Invisible(" ", " "),
                SpecialKey(KeyEvent.KEYCODE_TAB, "↦")
        )
        val Quotes = CharPair("'","\"")

        //Arrows

        val ArrowUp = oneSpecialKey(KeyEvent.KEYCODE_DPAD_UP,"↑")
        val ArrowDown = oneSpecialKey(KeyEvent.KEYCODE_DPAD_DOWN,"↓")
        val ArrowLeft = oneSpecialKey(KeyEvent.KEYCODE_DPAD_LEFT,"←")
        val ArrowRight = oneSpecialKey(KeyEvent.KEYCODE_DPAD_RIGHT,"→")
        val ArrowCenter = oneSpecialKey(KeyEvent.KEYCODE_DPAD_CENTER,"⊙")
        val ArrowHome = oneSpecialKey(KeyEvent.KEYCODE_MOVE_HOME,"|<--")
        val ArrowEnd = oneSpecialKey(KeyEvent.KEYCODE_MOVE_END,"-->|")
        val PageUp = oneSpecialKey(KeyEvent.KEYCODE_PAGE_UP,"p_up")
        val PageDown = oneSpecialKey(KeyEvent.KEYCODE_PAGE_DOWN,"p_down")

        val LeftRight = LockedPair(ArrowLeft,ArrowRight)
        val HomeEnd = LockedPair(ArrowHome,ArrowEnd)
        val DownUp = LockedPair(ArrowDown,ArrowUp)
        val PageUpDown = LockedPair(PageDown,PageUp)


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
        val ZeroPad = arrayOf(_0, _1, _2, _3, _4,FIRST,SECOND,THIRD,FOURTH)
        val FivePad = arrayOf(_5, _6, _7, _8, _9,SIXTH,SEVENTH,EIGHTH,NINTH)
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


        val TallT = arrayOf(T,THA,W,Z,THE,THOU, WITH,THANK,THI)
        val TallH = arrayOf(H,HER,ITE,Y,X,HIM,IGHT,YES,SORRY)
        val TallE = arrayOf(E,TER,WAS,R,V,TEN,WERE,ARE,CPPaste)
        val TallA = arrayOf(A,P,L,F,AND,PLEASE,LIKE,FROM)
        val TallSpace = arrayOf(Space,At,FStop,Quotes, Colons,LeftRight,DownUp,HomeEnd,PageUpDown)
        val TallN = arrayOf(N,K,NOT,D,G,KNOW,NT,DAY,GET)
        val TallS = arrayOf(S,ENT,M,FOR,HAS,ANT,MAKE,FAR,HAVE)
        val TallO = arrayOf(O,U,B,ION,Q,OUGH,BECAUSE,IGN,QU)
        val TallI = arrayOf(I,C,YOU,ING,J,CAN,YOURE,ANG,JUST)
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


