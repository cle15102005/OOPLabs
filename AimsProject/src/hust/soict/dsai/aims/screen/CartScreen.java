package hust.soict.dsai.aims.screen;

import java.awt.Dimension;
import java.io.IOException;
import java.util.ArrayList;

import javax.naming.LimitExceededException;
import javax.swing.JFrame;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Track;
import hust.soict.dsai.aims.store.Store;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class CartScreen extends JFrame {

	private Cart cart;
	private ControllerScreen controllerScreen;

	public CartScreen(Cart cart) {
		super();

		this.cart = cart;

		JFXPanel fxPanel = new JFXPanel();
		this.add(fxPanel);
		this.setTitle("Cart");
		// this.setVisible(true);
		this.setPreferredSize(new Dimension(1024, 768));
		pack();
		Platform.runLater(new Runnable() {

			@Override
			public void run() {
				try {
					FXMLLoader loader = new FXMLLoader(getClass()
							.getResource("/hust/soict/dsai/aims/screen/cart.fxml"));
					CartScreenController controller = new CartScreenController(cart);
					loader.setController(controller);
					Parent root = loader.load();
					fxPanel.setScene(new Scene(root, 1024, 768));
				} catch (IOException e) {
					e.printStackTrace();
				}

			}
		});
	}

	public static void main(String[] args) throws LimitExceededException {
		Cart cart= new Cart();
		
		ArrayList<String> authors= new ArrayList<String>();
		authors.add("Volvo");
	    authors.add("BMW");
	    authors.add("Ford");
	    
	    ArrayList<Track> CDs= new ArrayList<Track>();
		Track t1= new Track("Episode 1", 11);
		Track t2= new Track("Episode 2", 2);
		CDs.add(t1);
		CDs.add(t2);
		
		CompactDisc cd= new CompactDisc("Gaoranger", "Super Sentai", 30.15f, 0, "Kurosaki", "Ichigo", CDs);
		DigitalVideoDisc dvd= new DigitalVideoDisc("Star wars", "Science fiction", 24.95f, 87, "Geogre Lucas");
		Book book1= new Book("Murphy", "Psychology", 17.65f, authors);
		Book book2= new Book("OOP", "IT", 15.55f, authors);

		cart.addMedia(book2);
		cart.addMedia(book1);
		cart.addMedia(cd);
		cart.addMedia(dvd);
		
		new CartScreen(cart);
	}

}