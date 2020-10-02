package interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import negocio.Monitor;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

import excepciones.JuegoTerminadoException;
import excepciones.NumeroIngresadoInvalidoException;

import javax.swing.UIManager;
import java.awt.Color;

public class Interfaz extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField textFieldNumeroProbar;
	private JButton btnNuevoJuego;
	private JTextArea textAreaEstado;
	private JTextArea textAreaIntentos;
	private JButton btnProbar;
	private Monitor monitor = new Monitor();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interfaz frame = new Interfaz();
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
	public Interfaz() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 498, 285);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(3, 0, 0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(new GridLayout(0, 3, 0, 0));
		
		JPanel panel_3 = new JPanel();
		panel.add(panel_3);
		
		JPanel panel_4 = new JPanel();
		panel.add(panel_4);
		
		JPanel panel_5 = new JPanel();
		panel.add(panel_5);
		
		JPanel panel_6 = new JPanel();
		panel.add(panel_6);
		
		btnNuevoJuego = new JButton("Inicializar Juego");
		btnNuevoJuego.addActionListener(this);
		panel.add(btnNuevoJuego);
		
		JPanel panel_9 = new JPanel();
		panel.add(panel_9);
		
		JPanel panel_11 = new JPanel();
		panel.add(panel_11);
		
		JPanel panel_8 = new JPanel();
		panel.add(panel_8);
		
		JPanel panel_10 = new JPanel();
		panel.add(panel_10);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1);
		panel_1.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panel_7 = new JPanel();
		panel_1.add(panel_7);
		panel_7.setLayout(new GridLayout(3, 0, 0, 0));
		
		JPanel panel_25 = new JPanel();
		panel_7.add(panel_25);
		
		textAreaEstado = new JTextArea();
		textAreaEstado.setBorder(new TitledBorder(null, "Estado", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_7.add(textAreaEstado);
		
		JPanel panel_26 = new JPanel();
		panel_7.add(panel_26);
		
		JPanel panel_12 = new JPanel();
		panel_1.add(panel_12);
		panel_12.setLayout(new GridLayout(3, 0, 0, 0));
		
		JPanel panel_27 = new JPanel();
		panel_12.add(panel_27);
		
		textAreaIntentos = new JTextArea();
		textAreaIntentos.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "N\u00FAmero de intentos", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_12.add(textAreaIntentos);
		
		JPanel panel_28 = new JPanel();
		panel_12.add(panel_28);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2);
		panel_2.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panel_13 = new JPanel();
		panel_2.add(panel_13);
		panel_13.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_15 = new JPanel();
		panel_13.add(panel_15);
		
		JPanel panel_17 = new JPanel();
		panel_13.add(panel_17);
		panel_17.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panel_18 = new JPanel();
		panel_17.add(panel_18);
		
		JLabel lblNewLabel = new JLabel("N\u00FAmero a probar");
		panel_18.add(lblNewLabel);
		
		JPanel panel_19 = new JPanel();
		panel_17.add(panel_19);
		
		textFieldNumeroProbar = new JTextField();
		panel_19.add(textFieldNumeroProbar);
		textFieldNumeroProbar.setColumns(10);
		
		JPanel panel_16 = new JPanel();
		panel_13.add(panel_16);
		
		JPanel panel_14 = new JPanel();
		panel_2.add(panel_14);
		panel_14.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_20 = new JPanel();
		panel_14.add(panel_20);
		
		JPanel panel_21 = new JPanel();
		panel_14.add(panel_21);
		panel_21.setLayout(new GridLayout(0, 3, 0, 0));
		
		JPanel panel_23 = new JPanel();
		panel_21.add(panel_23);
		
		btnProbar = new JButton("Probar");
		btnProbar.addActionListener(this);
		panel_21.add(btnProbar);
		
		JPanel panel_24 = new JPanel();
		panel_21.add(panel_24);
		
		JPanel panel_22 = new JPanel();
		panel_14.add(panel_22);
	}

    public void inicializarJuego(){
        verificarInvariantes();
        monitor.inicializarJuego();
        this.mostrarEstado();
        this.mostrarIntentos();
        verificarInvariantes();
    }

    public void probarNumero(){
        verificarInvariantes();
        try {
			monitor.probarNumero(Integer.parseInt(this.textFieldNumeroProbar.getText()));
			this.mostrarEstado();
	        this.mostrarIntentos();
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this,"No se ingreso un numero");
		} catch (NumeroIngresadoInvalidoException e) {
			JOptionPane.showMessageDialog(this,e.getMessage());
		} catch (JuegoTerminadoException e) {
			JOptionPane.showMessageDialog(this,e.getMessage());
		}
        this.textFieldNumeroProbar.setText("");
        verificarInvariantes();
    }

    public void mostrarEstado(){
        verificarInvariantes();
        this.textAreaEstado.setText(monitor.traerEstado());
        verificarInvariantes();
    }

    public void mostrarIntentos(){
        verificarInvariantes();
        this.textAreaIntentos.setText(monitor.traerIntentos().toString());
        verificarInvariantes();
    }

    private void verificarInvariantes(){
        assert monitor != null : "El monitor no existe";
    }

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Inicializar Juego"))
			this.inicializarJuego();
		else
			this.probarNumero();
	}
}
