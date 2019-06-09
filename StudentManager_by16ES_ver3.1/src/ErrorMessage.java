package studentManager1;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ErrorMessage extends JFrame implements ActionListener{
	private JButton okeBut; 
	public ErrorMessage(String message) {
		// TODO Auto-generated constructor stub
		super(message);
		Container con = this.getContentPane();
		this.setLayout(new GridLayout(2, 1));
		this.setSize(250, 100);
		okeBut = new JButton("Ok");
		okeBut.addActionListener(this);
		JPanel 	pn1, pn2;
		pn1 = new JPanel();
		pn1.setLayout(new FlowLayout());
		pn2 = new JPanel();
		pn2.setLayout(new FlowLayout());
		JTextField errorTxt = new JTextField(message);
		errorTxt.setEditable(false);
		
		pn1.add(errorTxt);
		
		pn2.add(okeBut);
		con.add(pn1);
		con.add(pn2,"South");
//		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
//		this.show();
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				// TODO Auto-generated method stub
				//super.windowClosing(arg0);
				dispose();
			}
		});
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == okeBut )
		{
			dispose();
		}
	}
	
}