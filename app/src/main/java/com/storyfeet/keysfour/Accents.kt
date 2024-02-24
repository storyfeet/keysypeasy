package com.storyfeet.keysfour



fun accentChar(c:Char,a:Char):String{
    return when (c){
        'a'->when (a){
            'ç'->"a̧"
            else -> a.toString();

        }
        'e'->when (a){
            'á'->"é";
            'à'->"è";
            'â'->"ê";
            'ã'->"ẽ";
            'ä'->"ë";
            'ç'->"ȩ";
            else ->("e_");
        }
        'i'->when (a){
            'á'->"í";
            'à'->"ì";
            'â'->"î";
            'ã'->"ĩ";
            'ä'->"ï";
            'ç'->"i̧";
            else ->("i_");
        }
        'o'->when (a){
            'á'->"ó";
            'à'->"ò";
            'â'->"ô";
            'ã'->"õ";
            'ä'->"ö";
            'ç'->"o̧";
            else ->("o_");
        }
        'u'-> when (a){
            'á'->"ú";
            'à'->"ù";
            'â'->"û";
            'ã'->"ũ";
            'ä'->"ü";
            'ç'->"u̧";
            else ->("u_");
        }
        'n' -> when (a){
            'ã'->"ñ"
            else -> "n_"
        }
        'c' -> when (a){
              'ç'->"ç"
            else -> "c_"
        }
        else -> "${c}_"
    }

}
class Accents {
    companion object{
        fun lazyCaseAccent(c:Char, a:Char):String{
            val c2 = c.lowercaseChar();
            val res = accentChar(c2,a);
            return if (c2.equals(c)) res else res.uppercase()
        }
    }


}