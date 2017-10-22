package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.OnibusCheioException;
import model.Terminal;

public class TerminalView {

	private JFrame janela;
	private JPanel painelPrincipal;
	private JButton btn_comprar;
	private JButton btn_reservar;
	private JTextField index;
	private JButton btn_cancelar;
	private JTextField msg;
	
	private Terminal terminal;
	
	public TerminalView(Terminal terminal) {
		montarJanela();
		this.terminal = terminal;
	}

	private void montarJanela() {
		prepararJanela();
		prepararBotoes();
		mostrarJanela();
	}

	private void prepararBotoes() {
		JPanel painelBotoes = new JPanel(new GridLayout(2, 2));
		
		btn_comprar = new JButton("Comprar");
		btn_comprar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					int acento = terminal.venderPassagem();
					msg.setText("Seu acento é o: " + (acento+1));
				} catch (OnibusCheioException e) {
					msg.setText("Ônibus cheio... :(");
				}
				
			}
		});
		
		btn_reservar = new JButton("Reservar");
		btn_reservar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					int acento = terminal.reservarPassagem();
					msg.setText("Sua reserva é: " + (acento+1));
				} catch (OnibusCheioException e1) {
					msg.setText("Õnibus cheio... :(");
				}
			}
		});
		
		btn_cancelar = new JButton("Cancelar");
		btn_cancelar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					int in = Integer.parseInt(index.getText());
					terminal.cancelarPassagem(in-1);
					msg.setText("Cancelado...");
				} catch (Exception ex) {}
			}
		});
		
		index = new JTextField();
		
		painelBotoes.add(btn_comprar);
		painelBotoes.add(btn_reservar);
		painelBotoes.add(btn_cancelar);
		painelBotoes.add(index);
		
		painelPrincipal.add(painelBotoes, BorderLayout.NORTH);
		
		msg = new JTextField();
		msg.setEditable(false);
		
		painelPrincipal.add(msg, BorderLayout.SOUTH);
	}

	private void mostrarJanela() {
		janela.setSize(600, 150);
		janela.setLocation(0, 600);
		janela.setVisible(true);
	}

	private void prepararJanela() {
		janela = new JFrame("Terminal");
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		painelPrincipal = new JPanel(new BorderLayout());
		janela.setContentPane(painelPrincipal);
	}
}
