package GUI.GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Stack;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Buttons implements KeyListener, ActionListener {
	boolean hasStarted = false;
	boolean bLeft = false;
	boolean bRight = false;
	boolean bUp = false;
	boolean bDown = false;
	int left = 0;
	int right = 0;
	int up = 0;
	int down = 0;
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	ArrayList<JButton> buttons = new ArrayList<JButton>();
	Stack<String> words = new Stack<String>();
	Stack<String> wordsArray = new Stack<String>();

	public Buttons() {
		frame.add(panel);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setSize(300, 150);
		buttons.add(new JButton("startButton"));
		buttons.add(new JButton("stopButton"));
		buttons.add(new JButton("leftButton"));
		buttons.add(new JButton("rightButton"));
		buttons.add(new JButton("upButton"));
		buttons.add(new JButton("downButton"));
		for (JButton jButton : buttons) {
			jButton.addActionListener(this);
			panel.add(jButton);
		}
		frame.addKeyListener(this);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		if (e.getSource().equals(buttons.get(0))) {
			hasStarted = true;
			System.out.println("start");
		}
		if (e.getSource().equals(buttons.get(1))) {
			hasStarted = false;
			System.out.println("stop");
			System.out.println("backwards:");
			int size = words.size();
			for (int i = 0; i < size; i++) {
				System.out.print(words.peek() + " / ");
				wordsArray.add(words.pop());
			}
			System.out.println("forwards:");
			for (String x : wordsArray) {
				System.out.println(x);
			}
			System.out.println("\n");
			words.removeAll(words);
		}
		if (hasStarted = true) {
			if (e.getKeyCode() == e.VK_LEFT && bLeft == false) {
				words.add("left");
				bLeft = true;
				bRight = false;
				bUp = false;
				bDown = false;
			}
			if (e.getKeyCode() == e.VK_RIGHT && bRight == false) {
				words.add("right");
				bLeft = false;
				bRight = true;
				bUp = false;
				bDown = false;
			}
			if (e.getKeyCode() == e.VK_UP && bUp == false) {
				words.add("up");
				bLeft = false;
				bRight = false;
				bUp = true;
				bDown = false;
			}
			if (e.getKeyCode() == e.VK_DOWN && bDown == false) {
				words.add("down");
				bLeft = false;
				bRight = false;
				bUp = false;
				bDown = true;
			}
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(buttons.get(0))) {
			hasStarted = true;
			System.out.println("-start");
		}
		if (e.getSource().equals(buttons.get(1))) {
			hasStarted = false;
			System.out.println("-stop");
			System.out.println("backwards:");
			int size = words.size();
			for (int i = 0; i < size; i++) {
				System.out.print(words.peek() + " / ");
				wordsArray.add(words.pop());
			}
			System.out.println("\n");
			System.out.println("forwards:");
			int size2 = wordsArray.size();
			for (int i = 0; i < size2; i++) {
				System.out.print(wordsArray.pop() + " / ");
			}
			System.out.println("\n");
			words.removeAll(words);
			wordsArray.removeAll(wordsArray);
			bLeft = false;
			bRight = false;
			bUp = false;
			bDown = false;
		}
		if (hasStarted == true) {
			if (e.getSource().equals(buttons.get(2)) && bLeft == false) {
				System.out.println("left");
				words.add("left");
				bLeft = true;
				bRight = false;
				bUp = false;
				bDown = false;
			}
			if (e.getSource().equals(buttons.get(3)) && bRight == false) {
				System.out.println("right");
				words.add("right");
				bLeft = false;
				bRight = true;
				bUp = false;
				bDown = false;
			}
			if (e.getSource().equals(buttons.get(4)) && bUp == false) {
				System.out.println("up");
				words.add("up");
				bLeft = false;
				bRight = false;
				bUp = true;
				bDown = false;
			}
			if (e.getSource().equals(buttons.get(5)) && bDown == false) {
				System.out.println("down");
				words.add("down");
				bLeft = false;
				bRight = false;
				bUp = false;
				bDown = true;
			}
		}
	}
}
