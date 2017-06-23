package boulderdash.controller;

/**
 * <h1>The Interface IIinsaneVehiclesController.</h1>
 *
 * @author Jade
 * @version 0.1
 * @see IOrderPerformer
 */
public interface IBoulderdashController {

    /**
     * Play.
     *
     * @throws InterruptedException
     *             the interrupted exception
     */
    void play() throws InterruptedException;

    /**
     * Gets the order peformer.
     *
     * @return the order peformer
     */
    IOrderPerformer getOrderPeformer();
}
