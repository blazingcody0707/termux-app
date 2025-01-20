package com.termux.display;

import android.content.res.AssetManager;
import android.view.Surface;

public class Display {
    static native public void windowChanged(Surface surface, String name);

    static native public void startClient();

    static native public void setServerNativeAssetManager(AssetManager assetManager);

    static {
        System.loadLibrary("Display");
    }
}
