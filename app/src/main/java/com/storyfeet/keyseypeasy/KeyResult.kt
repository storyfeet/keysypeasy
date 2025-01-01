package com.storyfeet.keyseypeasy

enum class KeyMode{
        STRING,
        KEY,
        BACKSPACE_1,
        BACKSPACE_5,
        BACKSPACE_WORD,
        BACKSPACE_LINE,
        DELETE,
        DELETE_MANY,
        CTRL,
        COPY,
        PASTE,

        ACCENT,
        SET_PAGE,
        SET_SHIFT,
        SET_VERY_SHIFT,
        ROTATE_CAPS,
        UNICODE,

}

interface KeyResult {
        fun getMode(): KeyMode;
        fun getStr(): String;
        fun getKey() : Int;
        fun getPreview(): String;
}

class Invisible(private val s:String,private val prev: String): KeyResult {
        override fun getMode(): KeyMode {
                return KeyMode.STRING;
        }

        override fun getStr(): String {
                return s;
        }

        override fun getKey(): Int {
                return 0;
        }

        override fun getPreview(): String {
                return prev;
        }

}

class OneLetter(private val letter:String): KeyResult {
        override fun getMode(): KeyMode {
                return KeyMode.STRING;
        }

        override fun getStr(): String {
                return this.letter;
        }

        override fun getKey(): Int {
                return 0;
        }

        override fun getPreview(): String {
                return this.letter;
        }

}


class SpecialKey(private val keycode: Int, private val prev:String): KeyResult {
        override fun getMode(): KeyMode {
                return KeyMode.KEY;
        }

        override fun getStr(): String {
                return "";
        }

        override fun getKey(): Int {
                return keycode;
        }

        override fun getPreview(): String {
                return prev;
        }

}

