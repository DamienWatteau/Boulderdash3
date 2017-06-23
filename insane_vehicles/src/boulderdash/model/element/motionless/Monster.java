package boulderdash.model.element.motionless;

import boulderdash.model.element.Permeability;
import boulderdash.model.element.Sprite;

/**
 * <h1>The Obstacle Class.</h1>
 *
 * @author Jade
 * @version 0.2
 */
class Monster extends MotionlessElement {

    /** The Constant SPRITE. */
    private static final Sprite SPRITE = new Sprite('^', "Monster.png");

    /**
     * Instantiates a new obstacle.
     */
    Monster() {
        super(SPRITE, Permeability.KILLING);
    }
}
