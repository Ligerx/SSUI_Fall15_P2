package edu.cmu.sauvikda.collage;

import android.graphics.Canvas;
import android.graphics.NinePatch;
import android.graphics.RectF;

public class NinePartImage extends ArtistBase {
    RectF rect;
    NinePatch patches;

    public NinePartImage(float x, float y, float w, float h, NinePatch patches) {
        super();

        setPosition(x, y);
        setSize(w, h);

        this.rect = new RectF(x, y, w, h); // check if this is right
        this.patches = patches;
    }

    @Override
    public void draw(Canvas onCanvas) {
        patches.draw(onCanvas, rect);

        super.draw(onCanvas);
    }
}
