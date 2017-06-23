package boulderdash.model.element.motionless;

import boulderdash.model.element.Permeability;
import boulderdash.model.element.Sprite;

/**
 * <h1>The Ditch Class.</h1>
 *
 * @author Jade
 * @version 0.2
 */
class End extends MotionlessElement {

    /** The Constant SPRITE. */
    private static final Sprite SPRITE = new Sprite('(', "Door.png");

    /**
     * Instantiates a new ditch.
     */
    End() {
        super(SPRITE, Permeability.WIN);
    }
}
