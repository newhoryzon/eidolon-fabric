package com.nhoryzon.mc.eidolon.util;

@SuppressWarnings("unused")
public class CompoundTagUtils {

    public static final int TAG_END         = 0;
    public static final int TAG_BYTE        = 1;
    public static final int TAG_SHORT       = 2;
    public static final int TAG_INT         = 3;
    public static final int TAG_LONG        = 4;
    public static final int TAG_FLOAT       = 5;
    public static final int TAG_DOUBLE      = 6;
    public static final int TAG_BYTE_ARRAY  = 7;
    public static final int TAG_STRING      = 8;
    public static final int TAG_LIST        = 9;
    public static final int TAG_COMPOUND    = 10;
    public static final int TAG_INT_ARRAY   = 11;
    public static final int TAG_LONG_ARRAY  = 12;
    public static final int TAG_ANY_NUMERIC = 99;

    public static final String TAG_KEY_SLOT = "Slot";
    public static final String TAG_KEY_SIZE = "Size";
    public static final String TAG_KEY_ITEM_LIST = "Items";
    public static final String TAG_KEY_COOK_TIME = "CookTime";
    public static final String TAG_KEY_COOK_TIME_TOTAL = "CookTimeTotal";
    public static final String TAG_KEY_INVENTORY = "Inventory";
    public static final String TAG_KEY_CONTAINER = "Container";
    public static final String TAG_KEY_CUSTOM_NAME = "CustomName";

    private CompoundTagUtils() {
    }
    
}