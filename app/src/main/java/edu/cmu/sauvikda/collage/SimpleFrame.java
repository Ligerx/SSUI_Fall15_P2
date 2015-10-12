package edu.cmu.sauvikda.collage;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class SimpleFrame extends ArtistBase {
    public SimpleFrame(float x, float y, float w, float h) {
        // TODO
        super();

        setPosition(x, y);
        setSize(w, h);
    }

    @Override
    public void draw(Canvas onCanvas) {
        Paint border = new Paint();
        border.setColor(Color.BLACK);
        border.setStyle(Paint.Style.STROKE);
        border.setStrokeWidth(1);

        onCanvas.drawRect(getX(), getY(), getW(), getH(), border);

        super.draw(onCanvas);
    }
}
