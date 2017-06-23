package boulderdash.model;

import java.util.Observable;

import boulderdash.model.element.IElement;

/**
 * <h1>The Interface IRoad.</h1>
 *
 * @author Jade
 * @version 0.1
 */
public interface IRoad {

    /**
     * Gets the width.
     *
     * @return the width
     */
    int getWidth();

    /**
     * Gets the height.
     *
     * @return the height
     */
    int getHeight();

    /**
     * Gets the on the road XY.
     *
     * @param x
     *            the x
     * @param y
     *            the y
     * @return the on the road XY
     */
    IElement getOnTheRoadXY(int x, int y);
    void setOnTheRoadXY(final IElement element, final int x, final int y);
    /**
     * Sets the mobile has changed.
     */
    void setMobileHasChanged();

    /**
     * Gets the observable.
     *
     * @return the observable
     */
    Observable getObservable();
}
