package boulderdash.model.element.motionless;

import boulderdash.model.element.Permeability;
import boulderdash.model.element.Sprite;

/**
 * <h1>The Macadam Class.</h1>
 *
 * @author Jade
 * @version 0.2
 */
class Way extends MotionlessElement {

    /** The Constant SPRITE. */
    private static final Sprite SPRITE = new Sprite(' ', "Background.png");

    /**
     * Instantiates a new macadam.
     */
    Way() {
        super(SPRITE, Permeability.DISAPPEAR);
    }
}
