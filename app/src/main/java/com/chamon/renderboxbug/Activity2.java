package com.chamon.renderboxbug;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.widget.Toast;

import com.cardbookvr.renderbox.IRenderBox;
import com.cardbookvr.renderbox.RenderBox;
import com.cardbookvr.renderbox.Transform;
import com.cardbookvr.renderbox.components.Camera;
import com.cardbookvr.renderbox.components.Sphere;
import com.google.vr.sdk.base.GvrActivity;
import com.google.vr.sdk.base.GvrView;

public class Activity2 extends GvrActivity implements IRenderBox {
    GvrView gvrView;

    final int DEFAULT_BACKGROUND = R.drawable.bg;
    Sphere photosphere;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);

        gvrView = (GvrView) findViewById(R.id.gvr_view);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        gvrView.setRenderer(new RenderBox(this, this));
        setGvrView(gvrView);

        Toast.makeText(this,"Activity2",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setup() {

        photosphere = new Sphere(DEFAULT_BACKGROUND, false);
        new Transform().setLocalScale(Camera.Z_FAR * 0.99f, -Camera.Z_FAR * 0.99f, Camera.Z_FAR * 0.99f).addComponent(photosphere);

    }

    @Override
    public void preDraw() {

    }

    @Override
    public void postDraw() {

    }

    @Override
    public void onCardboardTrigger(){
        startActivity(new Intent(Activity2.this,Activity1.class));
    }
}
