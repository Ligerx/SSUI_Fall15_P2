package edu.cmu.sauvikda.collage;

import android.graphics.Canvas;
import android.graphics.Paint;

public class SolidBackDrop extends ArtistBase {

    int color; // int value of the box color

    /**
     * SolidBackDrop draws a filled rectangle.
     *
     * @param x x position
     * @param y y position
     * @param w width
     * @param h height
     * @param color int color of box
     */
    public SolidBackDrop(float x, float y, float w, float h, int color) {
        super();

        setPosition(x, y);
        setSize(w, h);

        this.color = color;
    }

    /**
     * Draw black border rectangle, then draw all children
     *
     * @param onCanvas alrady translated and clipped canvas to draw on
     */
    @Override
    public void draw(Canvas onCanvas) {
        Paint fill = new Paint();
        fill.setColor(color);
        fill.setStyle(Paint.Style.FILL);

        // For this, it goes to the full width and height value
        // the last value is exclusive, which is what we want to fill up the whole box.
        onCanvas.drawRect(0, 0, getW(), getH(), fill);

        super.draw(onCanvas);
    }
}
