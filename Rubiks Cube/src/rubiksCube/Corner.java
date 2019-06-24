package rubiksCube;

import java.awt.Color;

public class Corner {

private Color[] faces = new Color[3];
	
	public Corner (Color color0, Color color1, Color color2) {
		
		this.faces[0] = color0;
		this.faces[1] = color1;
		this.faces[2] = color2;
	}

}
