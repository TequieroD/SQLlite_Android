package com.example.c.sqllite;

import android.provider.BaseColumns;

/**
 * Created by C on 2015/10/19.
 */
public interface DbConstants extends BaseColumns {
    public static final String TABLE_NAME = "friends";
    public static final String NAME = "name";
    public static final String TEL = "tel";
    public static final String EMAIL = "email";
}