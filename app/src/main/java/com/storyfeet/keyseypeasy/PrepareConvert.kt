package com.storyfeet.keyseypeasy

fun rest(s:String):String{
    return s.slice(1..<s.length)
}

fun convert(s:String):String{
    if (s.length == 0){
        return s;
    }
    return when (s[0]){
        in '0'..'9'-> unicode(s,10)
        'x' -> unicode(rest(s),16)
        '/' -> acuteAccent(rest(s))
        '\\' -> graveAccent(rest(s))
        'c' -> cedillaAccent(rest(s))
        '^' -> circumflexAccent(rest(s))

        ':' -> umlautAccent(rest(s))
        '~' -> tildeAccent(rest(s))

        else -> ligature(s)

    }
}
fun acuteAccent(s:String):String{
    return when (s){
        "a" -> "á"
        "e" -> "é"
        "i" -> "í"
        "o" -> "ó"
        "u" -> "ú"
        else -> s
    }
}
fun graveAccent(s:String):String{
    return when (s){
        "a" -> "à"
        "e" -> "è"
        "i" -> "ì"
        "o" -> "ò"
        "u" -> "ù"
        else -> s
    }
}

fun cedillaAccent(s:String):String{
    return when (s){
        "c" -> "ç"
        "s" -> "ş"
        "e" -> "ȩ"
        " " -> "¸"
        else -> s
    }
}

fun circumflexAccent(s:String):String{
    return when (s){
        "a" -> "â"
        "e" -> "ê"
        "i" -> "î"
        "o" -> "ô"
        "u" -> "û"
        else -> s
    }
}
fun umlautAccent(s:String):String{
    return when (s){
        "a" -> "ä"
        "e" -> "ë"
        "i" -> "ï"
        "o" -> "ö"
        "u" -> "ü"
        else -> s
    }
}
fun tildeAccent(s:String):String{
    return when (s){
        "a" -> "ã"
        "e" -> "ẽ"
        "i" -> "ĩ"
        "o" -> "õ"
        "u" -> "ũ"
        "n" -> "ñ"
        else -> s
    }
}

fun unicode(s:String,base:Int):String{
    try {
        val hex = s.toInt(base) ?: return s;
        return ""+ hex.toChar();
    }catch(e:NumberFormatException){
        return s;
    }

}

fun ligature(s:String):String {
    return when (s){
        "ae" -> "æ"
        "AE" -> "Æ"
        "oe" -> "œ"
        "OE" -> "Œ"
        "ss" -> "ß"
        "SS" -> "ß"
        "dz" -> "ʣ"
        "d3" -> "ʤ"
        "dze" -> "ʥ"
        "ts" -> "ʦ"
        "tf" -> "ʧ"
        "t6" -> "ʨ"
        "fn" -> "ʩ"
        "ls" -> "ʪ"
        "lz" -> "ʫ"
        "i-" -> "ɨ"
        "u-" -> "ʉ"
        "wm" -> "ɯ"
        "o/" -> "ø"



        else -> s
    }
}