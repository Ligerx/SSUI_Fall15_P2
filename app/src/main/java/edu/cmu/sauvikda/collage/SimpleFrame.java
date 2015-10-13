package edu.cmu.sauvikda.collage;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class SimpleFrame extends ArtistBase {
    /**
     * SimpleFrame draws a black line rectangle (with no fill).
     *
     * @param x x position
     * @param y y position
     * @param w width
     * @param h height
     */
    public SimpleFrame(float x, float y, float w, float h) {
        super();

        setPosition(x, y);
        setSize(w, h);
    }

    /**
     * Draw black border rectangle, then draw all children
     *
     * @param onCanvas alrady translated and clipped canvas to draw on
     */
    @Override
    public void draw(Canvas onCanvas) {
        Paint border = new Paint();
        border.setColor(Color.BLACK);
        border.setStyle(Paint.Style.STROKE);
        border.setStrokeWidth(1);

        // -1 on width and height because the 1st pixel (0 index) is included
        // Java's placement on the border lines are really weird...
        //
        // It draws the top and left borders on the 0 pixel
        // BUT it draws the right and bottom ones PAST the last pixel
        // WHY U DO DIS
        onCanvas.drawRect(0, 0, getW() - 1, getH() - 1, border);

        super.draw(onCanvas);
    }
}
