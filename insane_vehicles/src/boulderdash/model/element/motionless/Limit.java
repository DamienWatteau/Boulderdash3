package boulderdash.model.element.motionless;

import boulderdash.model.element.Permeability;
import boulderdash.model.element.Sprite;

/**
 * <h1>The Tree Class.</h1>
 *
 * @author Jade
 * @version 0.2
 */
class Limit extends MotionlessElement {

    /** The Constant SPRITE. */
    private static final Sprite SPRITE = new Sprite('X', "LimitBlock.png");

    /**
     * Instantiates a new tree.
     */
    Limit() {
        super(SPRITE, Permeability.BLOCKING);
    }
}
