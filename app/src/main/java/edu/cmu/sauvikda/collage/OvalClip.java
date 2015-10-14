package edu.cmu.sauvikda.collage;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;

public class OvalClip extends ArtistBase {

    float w;
    float h;

    /**
     * Creates an oval shaped clipping mask for its children
     *
     * NOTE: This seems not to work
     *
     * @param x x position
     * @param y y position
     * @param w width
     * @param h height
     */
    public OvalClip(float x, float y, float w, float h) {
        super();

        setPosition(x, y);
        setSize(w, h);

        this.w = w;
        this.h = h;
    }

    @Override
    public void draw(Canvas onCanvas) {
        // Oval path that will be used to clip the canvas
        Path oval = new Path();
        oval.addOval(new RectF(0, 0, w, h), Path.Direction.CW);

        for (Artist child : mChildren) {
            onCanvas.save();

            onCanvas.clipPath(oval); // Oval clip here
            onCanvas.translate(child.getX(), child.getY());

            child.draw(onCanvas);
            onCanvas.restore();
        }
    }
}
