package test;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;
public class Mathy extends JFrame{
	private JFrame frame;
		
	private JPanel mainpanel;
	private JPanel middlepanel;
	private JPanel bottompanel;
	
	private BorderLayout mainlayout;
	private GridLayout middlelayout;
	
	private JTextField txtfield;
	
	private JButton lessthan;
	private JButton equalwith;
	private JButton biggerthan;
	private JButton newquestion;
	
	private Random random = new Random();
	
	private int number1;
	private int number2;
	private int correctanswer;
	private int questionID;
	
	
	public Mathy()
	{
		frame = new JFrame();
		frame.setTitle("Power of Friendship");
		
		mainpanel = new JPanel();
		middlepanel = new JPanel();
		bottompanel = new JPanel();
		
		txtfield = new JTextField();
		
		biggerthan = new JButton();
		biggerthan.addActionListener(new ActionListener()	{
			
					@Override
					public void actionPerformed(ActionEvent e)
					{
						switch(questionID)
						{
						case 0:
							if(number1 > number2)
							{
								txtfield.setText("Correct!");
							}
							else
							{
								txtfield.setText("Incorrect!");
							}
							break;
						default :
							if(Integer.parseInt(biggerthan.getText()) == correctanswer)
							{
								txtfield.setText("Correct!");
							}
							else
							{
								txtfield.setText("Incorrect");
							}
							break;
						}
					}
				});
		
		lessthan = new JButton();
		lessthan.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				switch(questionID)
				{
				case 0:
					if(number1 < number2)
					{
						txtfield.setText("Correct!");
					}
					else
					{
						txtfield.setText("Incorrect!");
					}
					break;
				default :
					if(Integer.parseInt(lessthan.getText()) == correctanswer)
					{
						txtfield.setText("Correct!");
					}
					else
					{
						txtfield.setText("Incorrect");
					}
					break;
				}
			}
		});
		
		equalwith = new JButton();
		equalwith.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				switch(questionID)
				{
				case 0:
					if(number1 > number2)
					{
						txtfield.setText("Correct!");
					}
					else
					{
						txtfield.setText("Incorrect!");
					}
					break;
				default :
					if(Integer.parseInt(equalwith.getText()) == correctanswer)
					{
						txtfield.setText("Correct!");
					}
					else
					{
						txtfield.setText("Incorrect");
					}
					break;
				}
			}
		});
		
		newquestion = new JButton("Gimme a question!");
		newquestion.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				number1 = random.nextInt()%100;
				number2 = random.nextInt()%100;
				
				questionID = random.nextInt()%4;
				
				//Generate question based on randomized questionID
				switch(questionID)
				{
				//is number1 bigger than,smaller than or equal with number2
				case 0:
					txtfield.setText(number1 + " and " + number2);
					lessthan.setText("<");
					biggerthan.setText(">");
					equalwith.setText("=");
					break;
					
				case 1:
					correctanswer = number1 + number2;
					
					txtfield.setText(number1 + " + " + number2);
					lessthan.setText(String.valueOf(number1 + number2));
					equalwith.setText(String.valueOf(random.nextInt()%10001));
					biggerthan.setText(String.valueOf(random.nextInt()%201));
					break;
					
				case 2:
					correctanswer = number1 * number2;
					
					txtfield.setText(number1 + " * " + number2);
					lessthan.setText(String.valueOf(number1 * number2));
					equalwith.setText(String.valueOf(random.nextInt()%10001));
					biggerthan.setText(String.valueOf(random.nextInt()%201));
					break;
					
				case 3:
					correctanswer = number1 - number2;
					
					txtfield.setText(number1 + " - " + number2);
					lessthan.setText(String.valueOf(number1-number2));
					equalwith.setText(String.valueOf(random.nextInt()%10001));
					biggerthan.setText(String.valueOf(random.nextInt()%201));
					break;
				}
				
				//randomize answers
				int shuffle = random.nextInt()%3;
				for(int i=0;i<shuffle;i++)
				{
					String temp1 = lessthan.getText();
					String temp2 = biggerthan.getText();
					lessthan.setText(equalwith.getText());
					biggerthan.setText(temp1);
					equalwith.setText(temp2);
				}
			}
		});
		
		mainlayout = new BorderLayout();
		middlelayout = new GridLayout(1,3);
		
		
		frame.setSize(500,150);
		
		//Add buttons to middle panel
		middlepanel.add(lessthan);
		middlepanel.add(equalwith);
		middlepanel.add(biggerthan);
		middlepanel.setLayout(middlelayout); //set middle pannel layout to a grid layout
		
		bottompanel.setLayout(new BorderLayout());
		bottompanel.add("Center",newquestion); //set bottom panel layout to border layout so button is automatically resized
		
		//add bottom panel,middle panel and textfield to main panel
		mainpanel.setLayout(mainlayout);
		mainpanel.add("North",txtfield);
		mainpanel.add("Center",middlepanel);
		mainpanel.add("South",bottompanel);
		
		//set main panel as frame content panes
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
}
