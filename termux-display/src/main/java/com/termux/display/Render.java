package com.termux.display;

import android.view.SurfaceHolder;

public class Render implements SurfaceHolder.Callback {
    private SurfaceHolder sh;
    private RenderSurface sv;

    public interface Callback {
        void onChanged(SurfaceHolder holder, int format, int width,
                       int height);
    }

    private Callback mCallback;

    public void setCallback(Callback c) {
        mCallback = c;
    }

    public Render(RenderSurface sv, SurfaceHolder sh) {
        super();
        this.sv = sv;
        this.sh = sh;
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width,
                               int height) {
        if (mCallback != null) {
            mCallback.onChanged(holder, format, width, height);
        }
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }
}
