import  java.awt.*;
import  java.awt.event.*;
import javax.swing.*;

public class SimpleChatBot extends JFrame{
	
	final String TITLE_OF_PROGRAM = "Chater: simple chatbot";
	final  int START_LOCATION = 200;
	final  int WINDOW_WIDTH = 350;
	final  int WINDOW_HEIGHT = 450;
	
	JTextArea dialogue;
	JCheckBox ai;
	JTextField message;
	SimpleChatBot sbot;
	
	public SimpleChatBot() {
		setTitle(TITLE_OF_PROGRAM);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(START_LOCATION, START_LOCATION, WINDOW_WIDTH, WINDOW_HEIGHT);
		
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new SimpleChatBot();
	}
	
	public SimpleChatBot(JTextArea dialogue, JCheckBox ai, JTextField message, SimpleChatBot sbot) throws HeadlessException {
		this.dialogue = dialogue;
		this.ai = ai;
		this.message = message;
		this.sbot = sbot;
	}
	
	public SimpleChatBot(GraphicsConfiguration gc, JTextArea dialogue, JCheckBox ai, JTextField message, SimpleChatBot sbot) {
		super(gc);
		this.dialogue = dialogue;
		this.ai = ai;
		this.message = message;
		this.sbot = sbot;
	}
	
	public SimpleChatBot(String title, JTextArea dialogue, JCheckBox ai, JTextField message, SimpleChatBot sbot) throws HeadlessException {
		super(title);
		this.dialogue = dialogue;
		this.ai = ai;
		this.message = message;
		this.sbot = sbot;
	}
	
	public SimpleChatBot(String title, GraphicsConfiguration gc, JTextArea dialogue, JCheckBox ai, JTextField message, SimpleChatBot sbot) {
		super(title, gc);
		this.dialogue = dialogue;
		this.ai = ai;
		this.message = message;
		this.sbot = sbot;
	}
}
