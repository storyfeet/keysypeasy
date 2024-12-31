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

        val ABLE = LongKey("able")
        val AND = LongKey("and")
        val ANG = LongKey("ang")
        val ANT = LongKey("ant")

        val ARE = LongKey("are")
        val ATE = LongKey("ate")

        val BECAUSE = LongKey("because")
        val BUT = LongKey("but")
        val CAN = LongKey("can")
        val CANT = LongKey("can't")

        val DAY = LongKey("day")
        val DONT = LongKey("don't")
        val EMBER = LongKey("ember")
        val END = LongKey("end")
        val ENT = LongKey("ent")
        val EXIT = LongKey("exit")

        val FAR = LongKey("far")
        val FER = LongKey("fer")
        val FALL = LongKey("fall")
        val FOR = LongKey("for")
        val FROM = LongKey("from")
        val GET = LongKey("get")
        val GOT = LongKey("got")
        val HAD = LongKey("had")
        val HAS = LongKey("has")
        val HAVE = LongKey("have")
        val HER = LongKey("her")
        val HIM = LongKey("him")
        val IGN = LongKey("ign")
        val ION = LongKey("ion")
        val ING = LongKey("ing")
        val ITE = LongKey("ite")
        val IGHT = LongKey("ight")

        val JOIN = LongKey("join")
        val JUST = LongKey("just")

        val KING = LongKey("king")
        val KNOW = LongKey("know")
        val LIKE = LongKey("like")
        val LOVE = LongKey("love")

        val MADE = LongKey("made")
        val MAKE = LongKey("make")
        val NOT = LongKey("not")
        val NT = LongKey("n't")

        val OUGH = LongKey("ough")
        val OUT = LongKey("out")

        val PLE = LongKey("ple")
        val PLEASE = LongKey("please")

        val QU = LongKey("qu")
        val QUESTION = LongKey("question")
        val RED = LongKey("red")
        val SORRY = LongKey("sorry")
        val SOME = LongKey("some")
        val SHE = LongKey("she")
        val TER = LongKey("ter")
        val TEN = LongKey("ten")
        val THA = LongKey("tha")
        val THANK = LongKey("thank")
        val THE = LongKey("the")

        val THI = LongKey("thi")
        val THINK = LongKey("think")
        val THOU = LongKey("thou")
        val THOUSAND = LongKey("thousand")
        val TOR = LongKey("tor")
        val TODAY = LongKey("today")

        val UNG = LongKey("ung")
        val VERY = LongKey("very")

        val WAS = LongKey("was")
        val WERE = LongKey("were")
        val WENT = LongKey("went")
        val WHERE = LongKey("where")
        val WITH = LongKey("with")

        val YES= LongKey("yes")
        val YEAH= LongKey("yeah")
        val YOU = LongKey("you")
        val YOUR = LongKey("your")
        val YOURE = LongKey("you're")

        val ZED = LongKey("zed")





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

        val ZEROTH = CharPair("zero","none")
        val FIRST = CharPair("one","first")
        val SECOND = CharPair("two","second")
        val THIRD = CharPair("three","<")
        val FOURTH = CharPair("four","fourth")
        val FIFTH = CharPair("five","fifth")
        val SIXTH = CharPair("six","sixth")
        val SEVENTH = CharPair("seven","seventh")
        val EIGHTH = CharPair("eight","eighth")
        val NINTH = CharPair("nine","ninth")
        val BRACE_LEFT = CharPair("[","{")
        val BRACE_RIGHT = CharPair("]","}")
        val LESS_THAN = CharPair("<","≤")
        val GREATER_THAN = CharPair(">", "≥")


        val Dash = CharPair("-", "_")
        val FStop = CharPair(".", ",")
        val At = CharPair("@", "?")
        val Colons = CharPair(";",":")
        val Space = LockedPair(
                Invisible(" ", " "),
                SpecialKey(KeyEvent.KEYCODE_TAB, "↦")
        )
        val Quotes = CharPair("'","\"")
        val Slashes = CharPair ("/","\\");

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


        //TODO Add methods to make this useable
        val Unicoder = oneModeKey (KeyMode.UNICODE,"*U")

        val CapRotater = oneModeKey(KeyMode.ROTATE_CAPS,"cC")


        val Shift = LockedPair(
                oneModeKey(KeyMode.SET_SHIFT, "⇧"),
                oneModeKey(KeyMode.SET_VERY_SHIFT, "⇧")
        )

        val BackSpaceMain = LockedPair(
            oneModeKey(KeyMode.BACKSPACE_1,"↼"),
            oneModeKey(KeyMode.BACKSPACE_LINE,"↼↼")
        )

        val BackSpace = LockedPair(
                oneModeKey(KeyMode.BACKSPACE_WORD, "|↼"),
                oneModeKey(KeyMode.BACKSPACE_5, "5↼")
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
        val ZeroPad = arrayOf(_0, _1, _2, _3, _4,    FIRST,ZEROTH,   SECOND, GREATER_THAN,    Empty,THIRD,  LESS_THAN,FOURTH)
        val FivePad = arrayOf(_5, _6, _7, _8, _9,    SIXTH,FIFTH,    SEVENTH, BRACE_RIGHT,   Empty,EIGHTH,   BRACE_LEFT,NINTH)
        val RPad = arrayOf(R, G, Q, D, U)
        val EPad = arrayOf(E, Y, O, C, B)
        val APad = arrayOf(A, N, FStop, F, V, Empty,Empty,Empty, CPPaste)
        val TPad = arrayOf(T, X, H, J, At)
        val SPad = arrayOf(S, K, M, P, Colons)
        val SpacePad = arrayOf(Space,L,I, Z,W ,LeftRight, DownUp)
        val EnterPad = arrayOf(BackSpaceMain, Dash, Delete, Enter, BackSpace)
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

        val AccentPad : Array<out KeyPair> = arrayOf(
            accentPair("ã","ä"),
            accentPair("à","à"),
            accentPair("á","á"),
            accentPair("ç","â"),
            LockedPair(Unicoder,OneLetter("#")),
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


        val TallT = arrayOf(T,THA,W,Z,THE,  THOUSAND,THOU,  WENT,WITH,  ZED,THANK,   THI,THINK)
        val TallH = arrayOf(H,HER,ITE,Y,X,   HIM,SHE,   IGHT,ATE,   YEAH,YES,  EXIT,SORRY)
        val TallE = arrayOf(E,TER,WAS,R,V,   TOR,TEN,   WERE,WHERE,  RED,ARE,   VERY,CPPaste)
        val TallA = arrayOf(A,P,L,F,AND,     PLE,PLEASE,  LOVE,LIKE,    FALL,FROM,  ABLE,ANT)
        val TallSpace = arrayOf(Space,At,FStop,Quotes, Colons,
                             ArrowLeft,ArrowRight,   ArrowUp,ArrowDown,
                            ArrowEnd,ArrowHome,     PageDown,PageUp)
        val TallN = arrayOf(N,K,NOT,D,G,   KING,KNOW,  NT,DONT,  TODAY,DAY,    GET,GOT)
        val TallS = arrayOf(S,ENT,M,FOR,HAS,   SOME,END,   MAKE,MADE,   FER,FAR,  HAVE,HAD)
        val TallO = arrayOf(O,U,B,ION,Q,     OUT,OUGH,    BUT,BECAUSE,    EMBER,IGN,     QUESTION,QU)
        val TallI = arrayOf(I,C,YOU,ING,J,    CAN,CANT,  YOUR,YOURE,     UNG,ANG,    JUST,JOIN)
        val TallCom = arrayOf(D_COM,D_CO,D_UK,Slashes,D_GOV)


        val EN_TALL_PORTRAIT = arrayOf(
            AccentPad,TallT,TallH,TallE,TallCom,
            ZeroPad,TallA,TallSpace,TallN, EnterPad,
            FivePad,TallS,TallO,TallI,GoPad,
        )

        val EN_TALL_LANDSCAPE = arrayOf(
            EmptyPad, EmptyPad,EmptyPad, AccentPad, ZeroPad,TallT,TallH,TallE, TallA,EnterPad,
            EmptyPad, EmptyPad,EmptyPad, TallCom, TallN, TallS,TallSpace, TallO, TallI, GoPad,

        )



        fun pageByName(name: String,landscape:Boolean): Array<Array<out KeyPair>> {
            if (name == "symbol") return if (landscape) symbol_landscape else symbol_portrait;
            if (name == "english") return if (landscape) english_landscape else english_portrait;
            return  if(landscape) EN_TALL_LANDSCAPE else EN_TALL_PORTRAIT;

        }

    }



}


