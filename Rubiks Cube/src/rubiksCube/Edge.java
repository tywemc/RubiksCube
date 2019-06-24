package rubiksCube;

import java.awt.Color;

public class Edge {
	
	private Color[] faces = new Color[2];
	
	public Edge (Color color0, Color color1) {
		
		this.faces[0] = color0;
		this.faces[1] = color1;
	}
	
}
