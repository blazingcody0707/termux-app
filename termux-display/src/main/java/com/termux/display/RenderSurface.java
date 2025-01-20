package com.termux.display;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.PixelFormat;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * sv=findViewById(R.id.render_surface);
 *         sh = sv.getHolder();
 *         Render render = new Render(sv,sh);
 *         render.setCallback(new Render.Callback() {
 *             @Override
 *             public void onChanged(SurfaceHolder holder, int format, int width, int height) {
 *                 sv.windowChanged(holder.getSurface(), "screen");
 *                 sv.startClient();
 *             }
 *         });
 *         sh.addCallback(render);
 *         sv.setServerNativeAssetManager(getAssets());
 */
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

    private SurfaceHolder.Callback callback;

    public native void windowChanged(Surface surface, String name);

    public native void startClient();

    public native void setServerNativeAssetManager(AssetManager assetManager);
    static {
        System.loadLibrary("Display");
    }
}

class Render implements SurfaceHolder.Callback {
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
