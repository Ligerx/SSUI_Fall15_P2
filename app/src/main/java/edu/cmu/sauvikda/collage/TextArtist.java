package edu.cmu.sauvikda.collage;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;

public class TextArtist extends ArtistBase {
    String text;
    Paint textPaint;

    private Rect bounds;

    public TextArtist(float x, float y, String text, Typeface face, float textSize) {
        super();

        setPosition(x, y);

        this.text = text;

        textPaint = new Paint();
        textPaint.setTypeface(face);
        textPaint.setTextSize(textSize);

        Rect bounds = new Rect();
        textPaint.getTextBounds(text, 0, text.length(), bounds);

        this.bounds = bounds;

        setSize(bounds.width(), bounds.height());

        // OVERRIDE THESE SO sizeIsIntrinsic FUNCTIONS CORRECTLY
        mWidth = bounds.width();
        mHeight = bounds.height();
    }


    @Override
    public void draw(Canvas onCanvas) {
        // This is annoying to deal with
        // Text is rendered with the origin at the bottom left (but above descenders like g)
        //
        // height moves it to the bottom, cutting off descenders,
        // and then moving it up by bottom shows the descenders
        onCanvas.drawText(text, 0, bounds.height() - bounds.bottom, textPaint);

        super.draw(onCanvas);
    }

    /**
     * Size set by text and style
     * @return true
     */
    @Override
    public boolean sizeIsIntrinsic() {
        return true;
    }
}
