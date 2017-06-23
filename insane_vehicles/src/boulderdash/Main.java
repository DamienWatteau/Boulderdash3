package boulderdash;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import boulderdash.controller.BoulderdashController;
import boulderdash.controller.IBoulderdashController;
import boulderdash.model.BoulderdashModel;
import boulderdash.model.IBoulderdashModel;
import boulderdash.view.BoulderdashView;
import boulderdash.view.Menu;
import modele.dao.BddRequete;

/**
 * <h1>The InsaneVehicles Class.</h1>
 *
 * @author Jade
 * @version 0.2
 */
public abstract class Main {

    /** The Constant startX. */
    private static final int startX = 2;

	/** The Constant startX. */
	private static final int startY = 2;


	/**
	 * The main method.
	 *
	 * @param args
	 *            the arguments
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 * @throws InterruptedException
	 *             the interrupted exception
	 */
	public static void main(final String[] args) throws IOException, InterruptedException {
		
		
//		Menu menu = new Menu();
//		BddRequete requete = new BddRequete();
//		requete.user(menu.menuPseudo());
//  	   	requete.selectTable(menu.menuLevel());
  	   	
  	   	
		final IBoulderdashModel model = new BoulderdashModel("road.txt", startX, startY);
		final BoulderdashView view = new BoulderdashView(model.getRoad(), model.getMyVehicle());
		final IBoulderdashController controller = new BoulderdashController(view, model);
		view.setOrderPerformer(controller.getOrderPeformer());
		
		controller.play();
	}
}
