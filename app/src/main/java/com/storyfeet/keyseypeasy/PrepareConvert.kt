package com.storyfeet.keyseypeasy

fun rest(s:String):String{
    return s.slice(1..<s.length)
}

fun convert(s:String):String{
    if (s.isEmpty()){
        return s
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
        '£' , '$'  -> currency(rest(s))

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
    return try {
        val hex = s.toInt(base)
        ""+ hex.toChar()
    }catch(e:NumberFormatException){
        s
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

fun currency(s:String):String{
    return when (s.uppercase()) {
        "ALL" -> "Lek"
        "AFN" -> "؋"
        "ARS" -> "$"
        "AWG" -> "ƒ"
        "AUD" -> "$"
        "AZN" -> "₼"
        "BSD" -> "$"
        "BBD" -> "$"
        "BYN" -> "Br"
        "BZD" -> "BZ$"
        "BMD" -> "$"
        "BOB" -> "\$\b"
        "BAM" -> "KM"
        "BWP" -> "P"
        "BGN" -> "лв"
        "BRL" -> "R$"
        "BND" -> "$"
        "KHR" -> "៛"
        "CAD" -> "$"
        "KYD" -> "$"
        "CLP" -> "$"
        "CNY" -> "¥"
        "COP" -> "$"
        "CRC" -> "₡"
        "CUP" -> "₱"
        "CZK" -> "Kč"
        "DKK" -> "kr"
        "DOP" -> "RD$"
        "XCD" -> "$"
        "EGP" -> "£"
        "SVC" -> "$"
        "EUR" -> "€"
        "FKP" -> "£"
        "FJD" -> "$"
        "GHS" -> "¢"
        "GIP" -> "£"
        "GTQ" -> "Q"
        "GGP" -> "£"
        "GYD" -> "$"
        "HNL" -> "L"
        "HKD" -> "$"
        "HUF" -> "Ft"
        "ISK" -> "kr"
        "INR" -> "₹"
        "IDR" -> "Rp"
        "IRR" ->"﷼"
        "IMP" -> "£"
        "ILS" -> "₪"
        "JMD" -> "J$"
        "JPY" -> "¥"
        "JEP" -> "£"
        "KZT" -> "лв"
        "KPW" -> "₩"
        "KRW" -> "₩"
        "KGS" -> "лв"
        "LAK" -> "₭"
        "LBP" -> "£"
        "LRD" -> "$"
        "MKD" -> "ден"
        "MYR" -> "RM"
        "MUR" -> "₨"
        "MXN" -> "$"
        "MNT" -> "₮"
        //"MNT" -> "د.إ"
        "MZN" -> "MT"
        "NAD" -> "$"
        "NPR" -> "₨"
        "ANG" -> "ƒ"
        "NZD" -> "$"
        "NIO" -> "C$"
        "NGN" -> "₦"
        "NOK" -> "kr"
        "OMR" -> "﷼"
        "PKR" -> "₨"
        "PAB" -> "B/."
        "PYG" -> "Gs"
        "PEN" -> "S/."
        "PHP" -> "₱"
        "PLN" -> "zł"
        "QAR" -> "﷼"
        "RON" -> "lei"
        "RUB" -> "₽"
        "SHP" -> "£"
        "SAR" -> "﷼"
        "RSD" -> "Дин."
        "SCR" -> "₨"
        "SGD" -> "$"
        "SBD" -> "$"
        "SOS" -> "S"
        //"KRW" -> "₩"
        "ZAR" -> "R"
        "LKR" -> "₨"
        "SEK" -> "kr"
        "CHF" -> "CHF"
        "SRD" -> "$"
        "SYP" -> "£"
        "TWD" -> "NT$"
        "THB" -> "฿"
        "TTD" -> "TT$"
        "TRY" -> "₺"
        "TVD" -> "$"
        "UAH" -> "₴"
        "AED" -> "د.إ"
        "GBP" -> "£"
        "USD" -> "$"
        "UYU" -> "\$U"
        "UZS" -> "лв"
        "VEF" -> "Bs"
        "VND" -> "₫"
        "YER" -> "﷼"
        "ZWD" -> "Z$"
        else -> s
    }


}