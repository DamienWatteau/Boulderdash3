package boulderdash.model.element.motionless;

import boulderdash.model.element.Permeability;
import boulderdash.model.element.Sprite;

/**
 * <h1>The Class Ditch.</h1>
 *
 * @author Jade
 * @version 0.2
 */
class Rock extends MotionlessElement {

    /** The Constant SPRITE. */
    private static final Sprite SPRITE = new Sprite('{', "Rock.png");

    /**
     * Instantiates a new ditch.
     */
    Rock() {
        super(SPRITE, Permeability.BLOCKING);
    }
}
