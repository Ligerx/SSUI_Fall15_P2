package edu.cmu.sauvikda.collage;

public class Row extends ArtistBase {

    float verticalCenter;

    /**
     * Places all children in a horizontal row, vertically centered
     *
     * @param x xposition
     * @param y y position
     * @param w width
     * @param h height
     */
    public Row(float x, float y, float w, float h) {
        super();

        setPosition(x, y);
        setSize(w, h);

        // Find where the vertical center is
        // FIXME: how does this handle rounding? Are there any problems?
        this.verticalCenter = h / 2;
    }

    @Override
    public void doLayout() {
        float xPosition = 0;

        for (Artist child : mChildren) {
            // Place child in a row, vertically centered
            child.setPosition(xPosition, childTop(child));

            // increment x position for next artist
            xPosition += child.getW();

            child.doLayout();
        }
    }

    /**
     * Given the vertical center position of the Row,
     * the child needs to be placed so its own center line is equal to the row center.
     */
    private float childTop(Artist child) {
        float childHeight = child.getH();
        float childCenter = childHeight / 2;

        return verticalCenter - childCenter;
    }
}
