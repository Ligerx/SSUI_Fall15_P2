package edu.cmu.sauvikda.collage;

public class Pile extends ArtistBase {

    /**
     * Stack all children on the (0,0) of this artist
     *
     * @param x x position
     * @param y y position
     * @param w width
     * @param h height
     */
    public Pile(float x, float y, float w, float h) {
        super();

        setPosition(x, y);
        setSize(w, h);
    }

    @Override
    public void doLayout() {
        for (Artist child : mChildren) {
            // Override the position of the child
            child.setPosition(0, 0);

            child.doLayout();
        }
    }
}
