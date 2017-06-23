package boulderdash.controller;

import java.io.IOException;

import boulderdash.model.IBoulderdashModel;
import boulderdash.view.IBoulderdashView;
import boulderdash.model.element.IElement;
import boulderdash.model.element.mobile.*;
import boulderdash.model.element.motionless.MotionlessElementsFactory;

/**
 * <h1>The Class InsaneVehiclesController.</h1>
 *
 * @author Jade
 * @version 0.1
 * @see IOrderPerformer
 */
public class BoulderdashController implements IBoulderdashController, IOrderPerformer {

    /** The Constant speed. */
    private static final int     speed = 200;

    /** The view. */
    private IBoulderdashView  view;

    /** The model. */
    private IBoulderdashModel model;

    /** The stack order. */
    private UserOrder            stackOrder;

    /**
     * Instantiates a new insane vehicles controller.
     *
     * @param view
     *            the view
     * @param model
     *            the model
     */
    public BoulderdashController(final IBoulderdashView view, final IBoulderdashModel model) {
        this.setView(view);
        this.setModel(model);
        this.clearStackOrder();
    }
    

    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.controller.IIinsaneVehiclesController#play()
     */
    @Override
    public final void play() throws InterruptedException {
        int score = 0;
        while (this.getModel().getMyVehicle().isAlive()) {
            Thread.sleep(speed);
            switch (this.getStackOrder()) {
            case RIGHT:
                this.getModel().getMyVehicle().moveRight();
                if (this.getModel().getMyVehicle().isBlocked() == true) {
                    this.getModel().getMyVehicle().moveLeft();
                }
                break;
            case LEFT:
                this.getModel().getMyVehicle().moveLeft();
                if (this.getModel().getMyVehicle().isBlocked() == true) {
                    this.getModel().getMyVehicle().moveRight();
                }
                break;
            case UP:
                this.getModel().getMyVehicle().moveUp();
                if (this.getModel().getMyVehicle().isBlocked() == true) {
                    this.getModel().getMyVehicle().moveDown();
                }
                break;
            case DOWN:
                this.getModel().getMyVehicle().moveDown();
                if (this.getModel().getMyVehicle().isBlocked() == true) {
                    this.getModel().getMyVehicle().moveUp();
                }
                break;
            case NOP:
            default:
                this.getModel().getMyVehicle().doNothing();
                break;
            }
            this.clearStackOrder();

//            this.getView().followMyVehicle();

            if (this.getModel().getMyVehicle().isWon() == true) {

                this.getView().displayMessage("YOU WIN");
                System.exit(0);

            } else if (this.getModel().getMyVehicle().isLootable() == true) {
                score++;
                System.out.println(score);

            }
            
//            if (this.getModel().getMyVehicle().isDesappear() == true){
//            	IElement test = this.get
//            	setOnTheRoadXY(,this.getModel().getMyVehicle().getX(),this.getModel().getMyVehicle().getY());
//            }

        }
        this.getView().displayMessage("GAME OVER");
        System.exit(0);

    }
    
    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.controller.IOrderPerformed#orderPerform(fr.exia.insanevehicles.
     * controller.UserOrder)
     */
    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.controller.IIinsaneVehiclesController#orderPerform(fr.exia.
     * insanevehicles.controller.UserOrder)
     */
    @Override
    public final void orderPerform(final UserOrder userOrder) throws IOException {
        this.setStackOrder(userOrder);
    }

    /**
     * Gets the view.
     *
     * @return the view
     */
    private IBoulderdashView getView() {
        return this.view;
    }

    /**
     * Sets the view.
     *
     * @param view
     *            the view to set
     */
    private void setView(final IBoulderdashView view) {
        this.view = view;
    }

    /**
     * Gets the model.
     *
     * @return the model
     */
    private IBoulderdashModel getModel() {
        return this.model;
    }

    /**
     * Sets the model.
     *
     * @param model
     *            the model to set
     */
    private void setModel(final IBoulderdashModel model) {
        this.model = model;
    }

    /**
     * Gets the stack order.
     *
     * @return the stack order
     */
    private UserOrder getStackOrder() {
        return this.stackOrder;
    }

    /**
     * Sets the stack order.
     *
     * @param stackOrder
     *            the new stack order
     */
    private void setStackOrder(final UserOrder stackOrder) {
        this.stackOrder = stackOrder;
    }

    /**
     * Clear stack order.
     */
    private void clearStackOrder() {
        this.stackOrder = UserOrder.NOP;
    }

    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.controller.IIinsaneVehiclesController#getOrderPeformer()
     */
    @Override
    public IOrderPerformer getOrderPeformer() {
        return this;
    }

}
