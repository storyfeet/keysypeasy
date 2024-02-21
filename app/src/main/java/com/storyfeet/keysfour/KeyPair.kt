package com.storyfeet.keysfour

interface KeyPair {
    fun preview(ss:Int): String;
    fun selectKey(ss:Int, cap:Boolean): KeyResult;
}

fun isUpper(ss: Int, cap:Boolean):Boolean{
    return ( ss > 0) != cap;
}

class OneKey (val mode_: KeyMode, val s:String, val key_ :Int) : KeyPair, KeyResult {
    override fun preview(ss: Int): String {
        return this.s;
    }

    override fun selectKey(ss: Int, cap: Boolean): OneKey {
        return this;
    }

    override fun getMode(): KeyMode {
        return this.mode_;
    }

    override fun getStr(): String {
        return this.s
    }

    override fun getKey(): Int {
        return this.key_;
    }

    override fun getPreview(): String {
        return this.s;
    }
}



class CapLetter(val s:String): KeyPair {
    override fun preview(ss: Int): String {
        return if (ss > 0) return s.uppercase() else s;
    }

    override fun selectKey(ss: Int, cap: Boolean): KeyResult {
        return OneLetter(if (isUpper(ss,cap)) s.uppercase() else s);
    }

}

class CharPair(val l:String, val u:String): KeyPair {
    override fun preview(ss: Int): String {
        return if (ss > 0) u else l;
    }

    override fun selectKey(ss: Int, cap: Boolean): KeyResult {
        return OneLetter(if (isUpper(ss,cap) ) u else l);
    }

}


class Twofer(private val lower: KeyResult, private val upper: KeyResult) : KeyPair {
    override fun selectKey(ss: Int, cap: Boolean): KeyResult {
        return if (isUpper(ss, cap)) upper else lower;
    }

    override fun preview(ss: Int): String {
        return if (ss > 0) upper.getPreview() else lower.getPreview();
    }
}

class LockedPair (private val lower: KeyResult, private val upper: KeyResult) : KeyPair {
    override fun preview(ss: Int): String {
        return lower.getPreview();
    }

    override fun selectKey(ss: Int, cap: Boolean): KeyResult {
        return if (cap) upper else lower;
    }

}
