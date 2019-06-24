package rubiksCube;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class RubiksCube extends JFrame {

	private JPanel contentPane;
	private ArrayList<Face> faces = new ArrayList<>();
//	private ArrayList<Face> edges = new ArrayList<>();
	private int[] startLocationsX = { 306, 225, 306, 387, 468, 306 }; // G,R,W,O,Y,B
	private int[] startLocationsY = { 219, 300, 300, 300, 300, 381 }; // G,R,W,O,Y,B
	private JPanel pDisplay;
	private Movement mover = new Movement(this);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RubiksCube frame = new RubiksCube();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public RubiksCube() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Rubik's Cube");
		setBounds(100, 100, 1100, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel pControls = new JPanel();
		pControls.setBounds(841, 0, 253, 665);
		contentPane.add(pControls);
		pControls.setLayout(null);

		JButton btnR = new JButton("R");
		btnR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mover.rTurn(false);
				System.out.println(faces.get(19).correct());
			}
		});
		btnR.setBounds(12, 172, 97, 25);
		pControls.add(btnR);

		JButton btnRprime = new JButton("R'");
		btnRprime.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mover.rTurn(true);
			}
		});
		btnRprime.setBounds(144, 172, 97, 25);
		pControls.add(btnRprime);

		JButton btnL = new JButton("L");
		btnL.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mover.lTurn(false);
			}
		});
		btnL.setBounds(12, 210, 97, 25);
		pControls.add(btnL);

		JButton btnLprime = new JButton("L'");
		btnLprime.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mover.lTurn(true);
			}
		});
		btnLprime.setBounds(144, 210, 97, 25);
		pControls.add(btnLprime);

		JButton btnF = new JButton("F");
		btnF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mover.fTurn(false);
			}
		});
		btnF.setBounds(12, 248, 97, 25);
		pControls.add(btnF);

		JButton btnFprime = new JButton("F'");
		btnFprime.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mover.fTurn(true);
			}
		});
		btnFprime.setBounds(144, 248, 97, 25);
		pControls.add(btnFprime);

		JButton btnD = new JButton("D");
		btnD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mover.dTurn(false);
			}
		});
		btnD.setBounds(12, 286, 97, 25);
		pControls.add(btnD);

		JButton btnDprime = new JButton("D'");
		btnDprime.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mover.dTurn(true);
			}
		});
		btnDprime.setBounds(144, 286, 97, 25);
		pControls.add(btnDprime);

		JButton btnU = new JButton("U");
		btnU.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mover.uTurn(false);
			}
		});
		btnU.setBounds(12, 324, 97, 25);
		pControls.add(btnU);

		JButton btnUprime = new JButton("U'");
		btnUprime.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mover.uTurn(true);
			}
		});
		btnUprime.setBounds(144, 324, 97, 25);
		pControls.add(btnUprime);

		JButton btnB = new JButton("B");
		btnB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mover.bTurn(false);
			}
		});
		btnB.setBounds(12, 362, 97, 25);
		pControls.add(btnB);

		JButton btnBprime = new JButton("B'");
		btnBprime.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mover.bTurn(true);
			}
		});
		btnBprime.setBounds(144, 362, 97, 25);
		pControls.add(btnBprime);

		JButton btnScramble = new JButton("Scramble");
		btnScramble.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mover.scramble();
			}
		});
		btnScramble.setBounds(79, 33, 97, 25);
		pControls.add(btnScramble);

		JButton btnSolve = new JButton("Solve");
		btnSolve.setBounds(79, 71, 97, 25);
		pControls.add(btnSolve);

		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				for (Face p : faces)
					p.reset();
			}
		});
		btnReset.setBounds(79, 109, 97, 25);
		pControls.add(btnReset);

		pDisplay = new JPanel();
		pDisplay.setBackground(Color.WHITE);
		pDisplay.setBounds(0, 0, 843, 665);
		contentPane.add(pDisplay);
		pDisplay.setLayout(null);

		initializeDisplay2D();

	}
	
	public void colorChange(int face1, int face2, int face3, int face4, boolean clockwise) {
		Color temp = faces.get(face1).getColor();
		if (clockwise) {
			faces.get(face1).setColor(faces.get(face2).getColor());
			faces.get(face2).setColor(faces.get(face3).getColor());
			faces.get(face3).setColor(faces.get(face4).getColor());
			faces.get(face4).setColor(temp);
		}
		else {
			faces.get(face1).setColor(faces.get(face4).getColor());
			faces.get(face4).setColor(faces.get(face3).getColor());
			faces.get(face3).setColor(faces.get(face2).getColor());
			faces.get(face2).setColor(temp);
		}
	}

	public void initializeDisplay2D() {
		final Color white = Color.WHITE;
		final Color red = Color.RED;
		final Color orange = new Color(255, 140, 0);
		final Color blue = Color.BLUE;
		final Color green = Color.GREEN;
		final Color yellow = Color.YELLOW;
		final Color[] colors = {green,red,white,orange,yellow,blue};
		//int count = 0;

		for (int k = 0; k < 6; k++) { // faces
			for (int i = 0; i < 3; i++) { // columns
				Face pieceX = new Face(colors[k]);
				//pieceX.id(count);
				//count++;
				pieceX.setBounds(startLocationsX[k] + (i * 27),
						startLocationsY[k], 28, 28);
				faces.add(pieceX);
				for (int j = 1; j <= 2; j++) { // rows
					Face pieceY = new Face(colors[k]);
					//pieceY.id(count);
					//count++;
					pieceY.setBounds(startLocationsX[k] + (i * 27),
							startLocationsY[k] + (j * 27), 28, 28);
					faces.add(pieceY);
				}
			}
		}

		for (int i = 0; i < faces.size(); i++) {
			pDisplay.add(faces.get(i));
		}
	}
}









