package rubiksCube;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class Face extends JPanel {

	private Color color;
	private Color defaultColor;
	private JLabel id;
	
	public Face(Color color) {
		this.setBackground(color);
		this.color = this.getBackground();
		this.defaultColor = color;
		this.setBorder(new LineBorder(Color.BLACK, 2));
	}
	
	public void setColor(Color color) {
		this.setBackground(color);
		this.color = this.getBackground();
	}
	
	public Color getColor() {
		return this.color;
	}
	
	public void reset() {
		this.setColor(defaultColor);
	}
	
	public boolean correct() {
		if (!equals(this.defaultColor))
			return true;
		else
			return false;
	}
	
	public boolean equal(Face comparing) {
		Color a = this.getColor();
		Color b = comparing.getColor();
		return a.equals(b);
	}
	
	public void id(int i) {
		String s = Integer.toString(i);
		id = new JLabel(s);
		this.add(id);
	}
	
	
}
