package com.zhuancheng.sanhedefence.utils;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;

import java.io.Serializable;

public final class Bundler {

    private final Bundle bundle;

    public Bundler() {
        this(new Bundle());
    }

    private Bundler(Bundle bundle) {
        this.bundle = bundle;
    }

    public static Bundler of(Bundle bundle) {
        return new Bundler(bundle);
    }

    public Bundle get() {
        return bundle;
    }

    public <T extends Fragment> T into(T fragment) {
        fragment.setArguments(bundle);
        return fragment;
    }

    public <T> Bundler put(String key, T value) {
        if (value instanceof Integer) {
            bundle.putInt(key, (Integer) value);
        } else if (value instanceof Long) {
            bundle.putLong(key, (Long) value);
        } else if (value instanceof Short) {
            bundle.putShort(key, (Short) value);
        } else if (value instanceof Float) {
            bundle.putFloat(key, (Float) value);
        } else if (value instanceof Double) {
            bundle.putDouble(key, (Double) value);
        } else if (value instanceof Boolean) {
            bundle.putBoolean(key, (Boolean) value);
        } else if (value instanceof String) {
            bundle.putString(key, (String) value);
        } else if (value instanceof Serializable) {
            bundle.putSerializable(key, (Serializable) value);
        } else if (value instanceof Parcelable) {
            bundle.putParcelable(key, (Parcelable) value);
        }
        return this;
    }
}
