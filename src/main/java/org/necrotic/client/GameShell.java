package org.necrotic.client;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.net.URL;

import javax.swing.JFrame;
import javax.swing.JMenuBar;

import org.necrotic.Configuration;

final class GameShell extends JFrame {

	private static final long serialVersionUID = 1L;

	private final GameRenderer applet;

	public GameShell(GameRenderer applet, int width, int height, boolean undecorative, boolean resizable) {
		this.applet = applet;
		setTitle(""+Configuration.CLIENT_NAME+" Client");
		setFocusTraversalKeysEnabled(false);
		setUndecorated(undecorative);
		JMenuBar bar = new JMenuBar();
		add(BorderLayout.NORTH, bar);
		setResizable(resizable);
		setVisible(true);
		Insets insets = getInsets();
		setSize(width + insets.left + insets.right, height + insets.top + insets.bottom);
		setLocationRelativeTo(null);
		requestFocus();
		toFront();
		setBackground(Color.BLACK);
		setClientIcon();
	}
	
	public void setClientIcon() {
		try {
			URL url = new URL	/*("http://necrotic.org/forums/favicon.ico");*/ ("http://necrotic.org/downloads/client/n-32x32.png");
			Toolkit kit = Toolkit.getDefaultToolkit();
			Image img = kit.createImage(url);
			setIconImage(img);
		} catch (Exception e) {
			e.printStackTrace();
		}
		/*
		Image img =  Toolkit.getDefaultToolkit().getImage(Signlink.getCacheDirectory().toString() + "/icon.png");
		if(img == null)
			return;
		setIconImage(img);
		*/
	}

	@Override
	public Graphics getGraphics() {
		Graphics g = super.getGraphics();
		Insets insets = getInsets();
		g.translate(insets.left, insets.top);
		return g;
	}

	@Override
	public void paint(Graphics g) {
		applet.paint(g);
	}

	@Override
	public void update(Graphics g) {
		applet.update(g);
	}

}