package boulderdash.model.element.motionless;

import boulderdash.model.element.Permeability;
import boulderdash.model.element.Sprite;

/**
 * <h1>The Class Ditch.</h1>
 *
 * @author Jade
 * @version 0.2
 */
class Monster2 extends MotionlessElement {

    /** The Constant SPRITE. */
    private static final Sprite SPRITE = new Sprite('}', "poule.png");

    /**
     * Instantiates a new ditch.
     */
    Monster2() {
        super(SPRITE, Permeability.BLOCKING);
    }
}
