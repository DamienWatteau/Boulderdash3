package boulderdash.model.element.motionless;

import boulderdash.model.element.Permeability;
import boulderdash.model.element.Sprite;

/**
 * <h1>The DitchRight Class.</h1>
 *
 * @author Jade
 * @version 0.2
 */
class Golem extends MotionlessElement {

    /** The Constant SPRITE. */
    private static final Sprite SPRITE = new Sprite(']', "golem.png");

    /**
     * Instantiates a new ditchRight.
     */
    Golem() {
        super(SPRITE, Permeability.BLOCKING);
    }
}
