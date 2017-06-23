package boulderdash.model.element.motionless;

import boulderdash.model.element.Permeability;
import boulderdash.model.element.Sprite;

/**
 * <h1>The DitchLeft Class.</h1>
 *
 * @author Jade
 * @version 0.2
 */
public class Diamond extends MotionlessElement {

    /** The Constant SPRITE. */
    private static final Sprite SPRITE = new Sprite('[', "Diamond.png");

    /**
     * Instantiates a new ditchLeft.
     */
    public Diamond() {
        super(SPRITE, Permeability.LOOTABLE);
    }
}
