package boulderdash.view;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import boulderdash.controller.IOrderPerformer;
import boulderdash.controller.UserOrder;
import boulderdash.model.IRoad;
import boulderdash.model.element.mobile.IMobile;
import fr.exia.showboard.BoardFrame;

/**
 * <h1>The InsaneVehiclesView Class.</h1>
 *
 * @author Jade
 * @version 0.4
 */
public class BoulderdashView implements Runnable, KeyListener, IBoulderdashView {

	/** The Constant roadView. */
	private static final int roadView = 20;

	/** The Constant squareSize. */
	private static final int squareSize = 30;

	/** The Constant closeView. */
	private Rectangle closeView;

	/** The road. */
	private IRoad road;

	/** My vehicle. */
	private IMobile myVehicle;

	/** The view. */
	private int view;

	/** The order performer. */
	private IOrderPerformer orderPerformer;

	/**
	 * Instantiates a new insane vehicles View.
	 *
	 * @param road
	 *            the road
	 * @param myVehicle
	 *            the my vehicle
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public BoulderdashView(final IRoad road, final IMobile myVehicle) throws IOException {
		this.setView(roadView);
		this.setRoad(road);
		this.setMyVehicle(myVehicle);
		this.getMyVehicle().getSprite().loadImage();
		this.setCloseView(new Rectangle(0, this.getMyVehicle().getY(), this.getRoad().getWidth(), roadView));
		SwingUtilities.invokeLater(this);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.exia.insanevehicles.view.IInsaneVehiclesView#displayMessage(java.lang.
	 * String)
	 */
	@Override
	public final void displayMessage(final String message) {
		JOptionPane.showMessageDialog(null, message);
	}
/**
 * create a window of name BoulderDash
 * 	
 */
	@Override
	public final void run() {
		final BoardFrame boardFrame = new BoardFrame("BoulderDash");
		
		boardFrame.setDimension(new Dimension(this.getRoad().getWidth(), this.getRoad().getHeight()));
		boardFrame.setDisplayFrame(this.closeView);
		boardFrame.setSize(this.closeView.width * squareSize, this.closeView.height * squareSize);
		boardFrame.setLocationRelativeTo(null);
		
		Image icone = Toolkit.getDefaultToolkit().getImage("./images/app_icon.png");
        boardFrame.setIconImage(icone);

		boardFrame.setBackground(null);
		boardFrame.addKeyListener(this);
		boardFrame.setFocusable(true);
		boardFrame.setFocusTraversalKeysEnabled(false);

		for (int x = 0; x < this.getRoad().getWidth(); x++) {
			for (int y = 0; y < this.getRoad().getHeight(); y++) {
				boardFrame.addSquare(this.road.getOnTheRoadXY(x, y), x, y);
			}
		}
		boardFrame.addPawn(this.getMyVehicle());

		this.getRoad().getObservable().addObserver(boardFrame.getObserver());
		this.followMyVehicle();

		boardFrame.setVisible(true);
		
		
	}

	/**
	 * Prints the road and the player's vehicle in the console.
	 *
	 * @param yStart
	 *            the y start
	 */
	public final void show(final int yStart) {
		int y = yStart % this.getRoad().getHeight();
		for (int view = 0; view < this.getView(); view++) {
			for (int x = 0; x < this.getRoad().getWidth(); x++) {
				if ((x == this.getMyVehicle().getX()) && (y == yStart)) {
					System.out.print(this.getMyVehicle().getSprite().getConsoleImage());
				} else {
					System.out.print(this.getRoad().getOnTheRoadXY(x, y).getSprite().getConsoleImage());
				}
			}
			y = (y + 1) % this.getRoad().getHeight();
			System.out.print("\n");
		}
	}

	/**
	 * Key code to user order.
	 *
	 * @param keyCode
	 *            the key code
	 * @return the user order
	 */
	private static UserOrder keyCodeToUserOrder(final int keyCode) {
		UserOrder userOrder;
		switch (keyCode) {
		case KeyEvent.VK_RIGHT:
			userOrder = UserOrder.RIGHT;
			break;
		case KeyEvent.VK_LEFT:
			userOrder = UserOrder.LEFT;
			break;
		case KeyEvent.VK_UP:
			userOrder = UserOrder.UP;
			break;
		case KeyEvent.VK_DOWN:
			userOrder = UserOrder.DOWN;
			break;
		default:
			userOrder = UserOrder.NOP;
			break;
		}
		return userOrder;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.awt.event.KeyListener#keyTyped(java.awt.event.KeyEvent)
	 */
	@Override
	public void keyTyped(final KeyEvent keyEvent) {
		// Nop
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.awt.event.KeyListener#keyPressed(java.awt.event.KeyEvent)
	 */
	@Override
	public final void keyPressed(final KeyEvent keyEvent) {
		try {
			this.getOrderPerformer().orderPerform(keyCodeToUserOrder(keyEvent.getKeyCode()));
		} catch (final IOException exception) {
			exception.printStackTrace();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.awt.event.KeyListener#keyReleased(java.awt.event.KeyEvent)
	 */
	@Override
	public void keyReleased(final KeyEvent keyEvent) {
		// Nop
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.exia.insanevehicles.view.IInsaneVehiclesView#followMyvehicle()
	 */
	@Override
	public final void followMyVehicle() {
		this.getCloseView().y = this.getMyVehicle().getY() - 3;
	}

	/**
	 * Gets the road.
	 *
	 * @return the road
	 */
	private IRoad getRoad() {
		return this.road;
	}

	/**
	 * Sets the road.
	 *
	 * @param road
	 *            the new road
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	private void setRoad(final IRoad road) throws IOException {
		this.road = road;
		for (int x = 0; x < this.getRoad().getWidth(); x++) {
			for (int y = 0; y < this.getRoad().getHeight(); y++) {
				this.getRoad().getOnTheRoadXY(x, y).getSprite().loadImage();
			}
		}
	}

	/**
	 * Gets my vehicle.
	 *
	 * @return my vehicle
	 */
	private IMobile getMyVehicle() {
		return this.myVehicle;
	}

	/**
	 * Sets my vehicle.
	 *
	 * @param myVehicle
	 *            my new vehicle
	 */
	private void setMyVehicle(final IMobile myVehicle) {
		this.myVehicle = myVehicle;
	}

	/**
	 * Gets the view.
	 *
	 * @return the view
	 */
	private int getView() {
		return this.view;
	}

	/**
	 * Sets the view.
	 *
	 * @param view
	 *            the new view
	 */
	private void setView(final int view) {
		this.view = view;
	}

	/**
	 * Gets the close view.
	 *
	 * @return the close view
	 */
	private Rectangle getCloseView() {
		return this.closeView;
	}

	/**
	 * Sets the close view.
	 *
	 * @param closeView
	 *            the new close view
	 */
	private void setCloseView(final Rectangle closeView) {
		this.closeView = closeView;
	}

	/**
	 * Gets the order performer.
	 *
	 * @return the order performer
	 */
	private IOrderPerformer getOrderPerformer() {
		return this.orderPerformer;
	}

	/**
	 * Sets the order performer.
	 *
	 * @param orderPerformer
	 *            the new order performer
	 */
	public final void setOrderPerformer(final IOrderPerformer orderPerformer) {
		this.orderPerformer = orderPerformer;
	}
}
