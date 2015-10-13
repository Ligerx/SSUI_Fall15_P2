package edu.cmu.sauvikda.collage;

public class Circle extends ArtistBase {

    float x;
    float y;
    float radius;

    /**
     * Lays out all children in a circle at equal angles.
     * This assumes 0 degrees is normal, at the middle right
     *
     * @param x x position of the clipping box
     * @param y y position of the clipping box
     * @param w width of the clipping box
     * @param h height of the clipping box
     * @param layoutCenterX circle's x position
     * @param layoutCenterY circle's y position
     * @param layoutRadius circle's radius
     */
    public Circle(float x, float y, float w, float h,
                  float layoutCenterX, float layoutCenterY,
                  float layoutRadius) {
        super();

        setPosition(x, y);
        setSize(w, h);

        // Ignore the passed in x, y
        // My x, y is the actual layout/circle's dimensions
        this.x = layoutCenterX;
        this.y = layoutCenterY;
        this.radius = layoutRadius;
    }

    @Override
    public void doLayout() {
        int numChildren = mChildren.size();
        float angleDeg = 360f / numChildren;
        float currentAngleDeg = 0;

        for (Artist child : mChildren) {
            setChildPosition(child, currentAngleDeg);

            // Increment the angle
            currentAngleDeg += angleDeg;

            child.doLayout();
        }
    }

    private void setChildPosition(Artist child, float angleDeg) {
        // Find the correct position
        // NOTE: this is currently starting at 0 degrees center right.
        float xPos = radius * (float) Math.cos(Math.toRadians(angleDeg)) + x;
        float yPos = radius * (float) Math.sin(Math.toRadians(angleDeg)) + y;

        // Also position them based on the center of the child
        float centeredXPos = xPos - (child.getW() / 2);
        float centeredYPos = yPos - (child.getH() / 2);

        child.setPosition(centeredXPos, centeredYPos);
    }
}
