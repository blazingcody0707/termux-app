package com.termux.display;

import android.content.Context;
import android.graphics.PixelFormat;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class RenderSurface extends SurfaceView {
    public RenderSurface(Context context) {
        super(context);
    }

    public RenderSurface(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public RenderSurface(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public RenderSurface(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        SurfaceHolder holder = getHolder();
        holder.setFormat(PixelFormat.RGBA_8888);
    }

    protected SurfaceHolder.Callback callback;

}
