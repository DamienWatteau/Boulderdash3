package boulderdash.model.element.motionless;

/**
 * <h1>A factory to create MotionlessElements objects.</h1>
 *
 * @author Jade
 * @version 0.3
 */
public abstract class MotionlessElementsFactory {

    /** The Constant ditchRight. */
    private static final Golem          golem          = new Golem();

    /** The Constant ditchLeft. */
    private static final Diamond           diamond           = new Diamond();

    /** The Constant ditchLeftTurnLeft. */
    private static final End   end   = new End();

    /** The Constant ditchLeftTurnRight. */
    private static final Rock rock = new Rock();

    /** The Constant ditchRightTurnLeft. */
    private static final Monster2  monster2  = new Monster2();

    /** The Constant ditchRightTurnRight. */
    private static final Dig dig = new Dig();

    /** The Constant TREE. */
    private static final Limit                LIMIT                = new Limit();

    /** The Constant MACADAM. */
    private static final Way             WAY             = new Way();

    /** The Constant OBSTACLE. */
    private static final Monster            MONSTER            = new Monster();

    /**
     * The motionless elements is an array of all possible MotionlessElement.
     */
    private static MotionlessElement[]       motionlessElements  = {
        golem,
        diamond,
        end,
        rock,
        monster2,
        dig,
        WAY,
        MONSTER,
        LIMIT, };
    
    public static Diamond getDiamond(){
    	return diamond;
    }

    /**
     * Creates a new MotionlessElements object.
     *
     * @return the motionless element
     */
    public static MotionlessElement createGolem() {
        return golem;
    }

    /**
     * Creates a new MotionlessElements object.
     *
     * @return the motionless element
     */
    public static MotionlessElement createDiamond() {
        return diamond;
    }

    /**
     * Creates a new MotionlessElements object.
     *
     * @return the motionless element
     */
    public static MotionlessElement createEnd() {
        return end;
    }

    /**
     * Creates a new MotionlessElements object.
     *
     * @return the motionless element
     */
    public static MotionlessElement createRock() {
        return rock;
    }

    /**
     * Creates a new MotionlessElements object.
     *
     * @return the motionless element
     */
    public static MotionlessElement createMonster2() {
        return monster2;
    }

    /**
     * Creates a new MotionlessElements object.
     *
     * @return the motionless element
     */
    public static MotionlessElement createDig() {
        return dig;
    }

    /**
     * Creates a new macadam object.
     *
     * @return the motionless element
     */
    public static MotionlessElement createWay() {
        return WAY;
    }

    /**
     * Creates a new obstacle object.
     *
     * @return the motionless element
     */
    public static MotionlessElement createMonster() {
        return MONSTER;
    }

    /**
     * Creates a new MotionlessElements object.
     *
     * @return the motionless element
     */
    public static MotionlessElement createLimit() {
        return LIMIT;
    }

    /**
     * Gets the good MotionlessElement from file symbol.
     *
     * @param fileSymbol
     *            the file symbol
     * @return the from file symbol
     */
    public static MotionlessElement getFromFileSymbol(final char fileSymbol) {
        for (final MotionlessElement motionlessElement : motionlessElements) {
            if (motionlessElement.getSprite().getConsoleImage() == fileSymbol) {
                return motionlessElement;
            }
        }
        return WAY;
    }
}
