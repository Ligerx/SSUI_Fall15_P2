package edu.cmu.sauvikda.collage;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;

public class Icon extends ArtistBase {
    Bitmap image;

    /**
     * Draw image in its original size
     *
     * @param x x location
     * @param y y location
     * @param image image to be displayed
     */
    public Icon(float x, float y, Bitmap image) {
        super();

        setPosition(x, y);

        // size is based on image size
        setSize(image.getWidth(), image.getHeight());

        this.image = image;

        // OVERRIDE THESE SO sizeIsIntrinsic FUNCTIONS CORRECTLY
        mWidth = image.getWidth();
        mHeight = image.getHeight();
    }

    @Override
    public void draw(Canvas onCanvas) {
        onCanvas.drawBitmap(image, 0, 0, new Paint());

        super.draw(onCanvas);
    }

    /**
     * Size set by image
     * @return true
     */
    @Override
    public boolean sizeIsIntrinsic() {
        return true;
    }
}
