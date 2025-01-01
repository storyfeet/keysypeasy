package com.storyfeet.keyseypeasy

fun ConvertUnicode(s:String):String{
    var pre = "";
    var temp = "";
    var num = 0;
    for (c in s){
        if (c.equals('#')){
            pre+= temp;
            temp = "#";
            num = 0;
            continue
        }
        if (c.isDigit()){
            num = num*10 + c.digitToInt();
            temp += c;
            continue;
        }
        pre += c;
    }
    if (num >0){
        return pre + num.toChar()
    }
    return pre

}