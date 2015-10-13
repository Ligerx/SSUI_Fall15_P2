package edu.cmu.sauvikda.collage;

public class Column extends ArtistBase {

    float horizontalCenter;

    /**
     * Places all children in a vertical column, horizontally centered
     *
     * @param x x position
     * @param y y position
     * @param w width
     * @param h height
     */
    public Column(float x, float y, float w, float h) {
        super();

        setPosition(x, y);
        setSize(w, h);

        // Find where the horizontal center is
        // FIXME: same as Row - how does this handle rounding? Are there any problems?
        this.horizontalCenter = w / 2;
    }

    @Override
    public void doLayout() {
        float yPosition = 0;

        for (Artist child : mChildren) {
            // Place child in a row, vertically centered
            child.setPosition(childLeft(child), yPosition);

            // increment x position for next artist
            yPosition += child.getH();

            child.doLayout();
        }
    }

    /**
     * Given the horizontal center position of the Column,
     * the child needs to be placed so its own center line is equal to the column center.
     */
    private float childLeft(Artist child) {
        float childWidth = child.getW();
        float childCenter = childWidth / 2;

        return horizontalCenter - childCenter;
    }
}
