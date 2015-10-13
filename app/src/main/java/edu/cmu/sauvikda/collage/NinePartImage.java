package edu.cmu.sauvikda.collage;

import android.graphics.Canvas;
import android.graphics.NinePatch;
import android.graphics.RectF;

public class NinePartImage extends ArtistBase {
    RectF rect;
    NinePatch patches;

    /**
     * Draws a dynamically sized NinePatch image
     *
     * @param x x position
     * @param y y position
     * @param w width
     * @param h height
     * @param patches NinePatch image to draw
     */
    public NinePartImage(float x, float y, float w, float h, NinePatch patches) {
        super();

        setPosition(x, y);
        setSize(w, h);

        this.rect = new RectF(x, y, w, h);
        this.patches = patches;
    }

    @Override
    public void draw(Canvas onCanvas) {
        patches.draw(onCanvas, rect);

        super.draw(onCanvas);
    }
}
