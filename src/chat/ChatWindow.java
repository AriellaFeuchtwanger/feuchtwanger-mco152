package chat;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.eclipse.jetty.server.Server;

public class ChatWindow extends JFrame {
	private JTextField field;
	private JTextArea textArea;

	public ChatWindow() {
		setSize(600, 800);
		setTitle("Chat");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		textArea = new JTextArea(100, 100);
		//textArea.setText(" ");
		textArea.setBackground(new Color(255, 187, 255));
		field = new JTextField();
		JButton sendButton = setButton();
		
		JScrollPane scroll = new JScrollPane(textArea);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scroll.setPreferredSize(new Dimension(600, 700));
		
		
		Container container = getContentPane();
		setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
		setBackground(new Color(255, 187, 255));
		add(scroll);
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		panel.setBackground(new Color(255, 187, 255));

		panel.add(field);
		panel.add(sendButton);
		add(panel);

		Server server = new Server(8080);
		server.setHandler(new ChatP2PHandler(textArea));
		try {
			server.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		ChatWindow window = new ChatWindow();
		window.setVisible(true);
	}

	private JButton setButton() {
		JButton button = new JButton("Send");

		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				URL url;
				try {
					url = new URL("http://192.168.117.111:8080");
					HttpURLConnection connection = (HttpURLConnection) url.openConnection();
					connection.setDoOutput(true);
					OutputStream out = connection.getOutputStream();
					PrintWriter writer = new PrintWriter(out);
					textArea.append("\n" + "Ariella: " + field.getText());
					writer.println("Ariella: " + field.getText() + "\n");
					writer.flush();
					field.setText("");
					connection.getInputStream();
				} catch (IOException e1) {
					e1.printStackTrace();
				}

			}

		});

		return button;
	}
}
