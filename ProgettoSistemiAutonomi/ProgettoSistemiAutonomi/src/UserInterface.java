import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class UserInterface {
	
	private JFrame frame;
	private JPanel panel;           
	private JButton start_button;
	private JButton change_conditions_button;
	private JTextArea informations_area;
	private JTextArea message_area;
	private MyListener listener;
	private GridLayout layout;
	
	public UserInterface(){
		frame = new JFrame();
		frame.setBounds(500, 700, 700, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		layout = new GridLayout(0,1);
		
		start_button = new JButton("Start");
		start_button.setPreferredSize(new Dimension(1, 1));
		change_conditions_button = new JButton("Change Conditions");
		change_conditions_button.setPreferredSize(new Dimension(1, 1));
		change_conditions_button.setEnabled(false);
		informations_area = new JTextArea(30,20);
		message_area = new JTextArea(30,20);
		
		panel = new JPanel();
		panel.setLayout(layout);

		panel.add(start_button);
		panel.add(change_conditions_button);
		panel.add(new JLabel("General Informations tab"));
		panel.add(informations_area);
		panel.add(new JLabel("Motivational Message tab"));
		panel.add(message_area);
		frame.add(panel);
		frame.setVisible(true);
		listener = new MyListener(this);
		start_button.addActionListener(listener);
		change_conditions_button.addActionListener(listener);
	}
	
	public void shutdown() {
		frame.setVisible(false);
		System.exit(0);
	}
	
	public void writeGeneralInfo(String info, boolean clear){
		if(!clear){
			informations_area.setText(informations_area.getText() + "\n" + info);
		}
		else {
			informations_area.setText(info);
		}
	}
	
	public void writeMessageInfo(String message){
		message_area.setText(message);
	}
	
	public void enableChangeConditions(){
		change_conditions_button.setEnabled(true);
	}

	
}
