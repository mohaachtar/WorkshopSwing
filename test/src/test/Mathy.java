package test;
import java.awt.*;
import java.util.*;
import javax.swing.*;
public class Mathy {
	private JFrame frame;
	
	private JPanel mainpanel;
	private JPanel bottompanel;
	
	private BorderLayout mainlayout;
	private GridLayout bottomlayout;
	
	private JTextField txtfield;
	
	private JButton lessthan;
	private JButton equalwith;
	private JButton biggerthan;
	
	private Random random = new Random();
	private int questionID;
	
	public Mathy()
	{
		frame = new JFrame();
		
		mainpanel = new JPanel();
		bottompanel = new JPanel();
		
		txtfield = new JTextField();
		
		biggerthan = new JButton(">");
		lessthan = new JButton("<");
		equalwith = new JButton("=");
		
		mainlayout = new BorderLayout();
		bottomlayout = new GridLayout(1,3);
		
		
		frame.setSize(500,150);
		
		//Add buttons to bottom panel
		bottompanel.add(lessthan);
		bottompanel.add(equalwith);
		bottompanel.add(biggerthan);
		bottompanel.setLayout(bottomlayout); //set bottom pannel layout to a grid layout
		
		//add bottom panel and textfield to main panel
		mainpanel.setLayout(mainlayout);
		mainpanel.add("North",txtfield);
		mainpanel.add("Center",bottompanel);
		
		//set main panel as frame content pane
		frame.setContentPane(mainpanel);
	
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void makeVisible()
	{
		frame.setVisible(true);
	}
	
	public void makeInvisible()
	{
		frame.setVisible(false);
	}
	
	public void NextQuestion()
	{
		questionID = random.nextInt();
	}

}
