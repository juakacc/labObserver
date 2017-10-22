package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.Terminal;
import model.OnibusException;

/**
 * Classe responsável por representar o terminal de venda da rodoviária
 * @author juaka, Patrick
 *
 */
public class TerminalView {

	private JFrame janela;
	private JPanel painelPrincipal;
	private JButton btn_comprar, btn_reservar, btn_cancelar;
	private JTextField txt_index, txt_msg;
	
	private Terminal terminal;
	
	public TerminalView(Terminal terminal) {
		this.terminal = terminal;
	}

	public void montarTela() {
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
					txt_msg.setText("Seu acento é o: " + (acento+1));
				} catch (OnibusException e) {
					txt_msg.setText(e.getMessage());
				}
				
			}
		});
		
		btn_reservar = new JButton("Reservar");
		btn_reservar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg) {
				try {
					int acento = terminal.reservarPassagem();
					txt_msg.setText("Sua reserva é: " + (acento+1));
				} catch (OnibusException e) {
					txt_msg.setText(e.getMessage());
				}
			}
		});
		
		btn_cancelar = new JButton("Cancelar");
		btn_cancelar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					int in = Integer.parseInt(txt_index.getText());
					if (terminal.cancelarPassagem(in-1))
						txt_msg.setText("Cancelado...");	
				} catch (Exception ex) {}
			}
		});
		
		txt_index = new JTextField();
		
		painelBotoes.add(btn_comprar);
		painelBotoes.add(btn_reservar);
		painelBotoes.add(btn_cancelar);
		painelBotoes.add(txt_index);
		
		painelPrincipal.add(painelBotoes, BorderLayout.NORTH);
		
		txt_msg = new JTextField();
		txt_msg.setEditable(false);
		
		painelPrincipal.add(txt_msg, BorderLayout.SOUTH);
	}

	private void mostrarJanela() {
		janela.setSize(600, 150);
		janela.setLocation(0, 500);
		janela.setVisible(true);
	}

	private void prepararJanela() {
		janela = new JFrame("Terminal");
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		painelPrincipal = new JPanel(new BorderLayout());
		janela.setContentPane(painelPrincipal);
	}
}
