package com.termux.display;

import android.os.Bundle;
import android.view.SurfaceHolder;

import androidx.appcompat.app.AppCompatActivity;

public class RenderActivity extends AppCompatActivity {
    private RenderSurface sv;
    private SurfaceHolder sh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //得到控制器
        sv=findViewById(R.id.render_surface);
        sh = sv.getHolder();
        Render render = new Render(sv,sh);
        render.setCallback(new Render.Callback() {
            @Override
            public void onChanged(SurfaceHolder holder, int format, int width, int height) {
                Display.initDisplayWindow(holder.getSurface(), "screen");
                Display.startClient();
            }
        });
        sh.addCallback(render);
        Display.setServerNativeAssetManager(getAssets());
    }
}
