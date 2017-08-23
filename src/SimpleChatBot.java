import  java.awt.*;
import  java.awt.event.*;
import javax.swing.*;

public class SimpleChatBot extends JFrame implements ActionListener{
	
	final String TITLE_OF_PROGRAM = "Chater: simple chatbot";
	final  int START_LOCATION = 200;
	final  int WINDOW_WIDTH = 350;
	final  int WINDOW_HEIGHT = 450;
	
	JTextArea dialogue;         // area for dialog
	JCheckBox ai;              //enale/disable AI
	JTextField message;     //field for entering messages
	SimpleBot sbot;     //chat-bot class
	
	public SimpleChatBot() {
		setTitle(TITLE_OF_PROGRAM);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(START_LOCATION, START_LOCATION, WINDOW_WIDTH, WINDOW_HEIGHT);
		
		//area for dialog
		dialogue = new JTextArea();
		dialogue.setLineWrap(true);
		JScrollPane scrollBAr = new JScrollPane(dialogue);
		
		add(BorderLayout.CENTER, scrollBAr);
		JPanel bp = new JPanel();
		bp.setLayout(new BoxLayout(bp, BoxLayout.X_AXIS));
		ai = new JCheckBox("AI");
		//ai.doClick();
		message = new JTextField();
		message.addActionListener(this);
		JButton enter = new JButton("Enter");
		enter.addActionListener(this);
//		adding all elements to the window
		bp.add(ai);
		bp.add(message);
		bp.add(enter);
		add(BorderLayout.CENTER, scrollBAr);
		add(BorderLayout.SOUTH, bp);
		setVisible(true);
		sbot = new SimpleBot();
	}
	
	public static void main(String[] args) {
		new SimpleChatBot();
	}
	
	public SimpleChatBot(JTextArea dialogue, JCheckBox ai, JTextField message, SimpleBot sbot) throws HeadlessException {
		this.dialogue = dialogue;
		this.ai = ai;
		this.message = message;
		this.sbot = sbot;
	}
	
	public SimpleChatBot(GraphicsConfiguration gc, JTextArea dialogue, JCheckBox ai, JTextField message, SimpleBot sbot) {
		super(gc);
		this.dialogue = dialogue;
		this.ai = ai;
		this.message = message;
		this.sbot = sbot;
	}
	
	public SimpleChatBot(String title, JTextArea dialogue, JCheckBox ai, JTextField message, SimpleBot sbot) throws HeadlessException {
		super(title);
		this.dialogue = dialogue;
		this.ai = ai;
		this.message = message;
		this.sbot = sbot;
	}
	
	public SimpleChatBot(String title, GraphicsConfiguration gc, JTextArea dialogue, JCheckBox ai, JTextField message, SimpleBot sbot) {
		super(title, gc);
		this.dialogue = dialogue;
		this.ai = ai;
		this.message = message;
		this.sbot = sbot;
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		if (message.getText().trim().length() > 0) {
			dialogue.append(message.getText() + "\n");
			dialogue.append(TITLE_OF_PROGRAM.substring(0, 9) +
			sbot.sayInReturn(message.getText(), ai.isSelected()) + "\n");
		}
		message.setText("");
		message.requestFocusInWindow();
	}
}
