package hust.soict.dsai.aims.screen;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Track;
import hust.soict.dsai.aims.store.Store;

public class StoreScreen extends JFrame {
	private Store store;
	private Cart cart;
	private ControllerScreen c;
	JMenuBar createMenuBar() {
		JMenu menu = new JMenu("Option");
		JMenu smUpdateStore = new JMenu("Update Store");
		JMenuItem addBookMenu= new JMenuItem("Add Book");
		addBookMenu.addActionListener(e->{
			c.showAddBookScreen();
		});
		smUpdateStore.add(addBookMenu);
		JMenuItem addCDMenu=new JMenuItem("Add CD");
		addCDMenu.addActionListener(e->{
			c.showAddCDCreen();
		});
		smUpdateStore.add(addCDMenu);
		JMenuItem addDVDMenu= new JMenuItem("Add DVD");
		addDVDMenu.addActionListener(e->{
			c.showAddDVDScreen();
		});
		smUpdateStore.add(addDVDMenu);

		menu.add(smUpdateStore);
		JMenuItem viewStoreMenu= new JMenuItem("View store");
		viewStoreMenu.addActionListener(e->{
			c.showStoreScreen();
		});
		menu.add(viewStoreMenu);

		JMenuItem viewCartMenu= new JMenuItem("View cart");
		viewCartMenu.addActionListener(e->{
			c.showCartScreen();
		});
		menu.add(viewCartMenu);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
		menuBar.add(menu);

		return menuBar;
	}

	JPanel createHeader() {
		JPanel header = new JPanel();
		header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

		JLabel title = new JLabel("AIMS");
		title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
		title.setForeground(Color.CYAN);

		JButton btnCart = new JButton("View cart");

		btnCart.setPreferredSize(new Dimension(100, 50));
		btnCart.setMaximumSize(new Dimension(100, 50));
		btnCart.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					c.showCartScreen();
				}
		});


		header.add(Box.createRigidArea(new Dimension(10, 10)));
		header.add(title);
		header.add(Box.createHorizontalGlue());
		header.add(btnCart);
		header.add(Box.createRigidArea(new Dimension(10, 10)));

		return header;
	}

	JPanel createNorth() {
		JPanel north = new JPanel();
		north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
		north.add(createMenuBar());
		north.add(createHeader());
		return north;
	}

	JPanel createCenter() {

		JPanel center = new JPanel();
		center.setLayout(new GridLayout(3, 3, 2, 2));

		ArrayList<Media> mediaInStore = store.getItemsInStore();
		for (int i=0; i< mediaInStore.size(); i++) {
			MediaStore cell = new MediaStore(mediaInStore.get(i), cart);
			center.add(cell);
		}

		return center;
	}

	public StoreScreen(Store store) {
		this.store = store;

		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());

		cp.add(createNorth(), BorderLayout.NORTH);
		cp.add(createCenter(), BorderLayout.CENTER);

//		setVisible(true);
		setTitle("Store");
		setSize(1024, 768);

	}

	public static void main(String[] args) {
		Store cart= new Store();
		
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
		
		new StoreScreen(cart);
	}

}