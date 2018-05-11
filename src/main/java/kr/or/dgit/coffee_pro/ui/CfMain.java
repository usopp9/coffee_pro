package kr.or.dgit.coffee_pro.ui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import kr.or.dgit.coffee_pro.dto.Coffee;
import kr.or.dgit.coffee_pro.dto.CoffeeMng;
import kr.or.dgit.coffee_pro.service.CoffeeService;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class CfMain extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField tfName;
	private JTextField tfPrice;
	private JTextField tfCount;
	private JTextField tfMargin;
	private JButton btnInsert;
	private JButton btnTotal;
	private JButton btnMargin;
	private JTextField tfCode;
	
	private CoffeeService service;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CfMain frame = new CfMain();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public CfMain() {
		service = new CoffeeService();
		initComponents();
	}
	private void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 464, 225);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pNorth = new JPanel();
		pNorth.setBounds(5, 5, 443, 26);
		contentPane.add(pNorth);
		pNorth.setLayout(new GridLayout(1, 0, 10, 10));
		
		JLabel lblCode = new JLabel("제품코드");
		lblCode.setHorizontalAlignment(SwingConstants.CENTER);
		pNorth.add(lblCode);
		
		tfCode = new JTextField();
		tfCode.addActionListener(this);
		pNorth.add(tfCode);
		tfCode.setColumns(10);
		
		
		
		JLabel lblName = new JLabel("제품명");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		pNorth.add(lblName);
		
		tfName = new JTextField();
		tfName.setColumns(10);
		pNorth.add(tfName);
		
		JPanel pCenter = new JPanel();
		pCenter.setBounds(5, 36, 216, 103);
		contentPane.add(pCenter);
		pCenter.setLayout(new GridLayout(0, 2, 10, 10));
		
		JLabel lblPrice = new JLabel("제품단가");
		lblPrice.setHorizontalAlignment(SwingConstants.CENTER);
		pCenter.add(lblPrice);
		
		tfPrice = new JTextField();
		pCenter.add(tfPrice);
		tfPrice.setColumns(10);
		
		JLabel lblCount = new JLabel("판매수량");
		lblCount.setHorizontalAlignment(SwingConstants.CENTER);
		pCenter.add(lblCount);
		
		tfCount = new JTextField();
		tfCount.setColumns(10);
		pCenter.add(tfCount);
		
		JLabel lblMargin = new JLabel("마진율");
		lblMargin.setHorizontalAlignment(SwingConstants.CENTER);
		pCenter.add(lblMargin);
		
		tfMargin = new JTextField();
		tfMargin.setColumns(10);
		pCenter.add(tfMargin);
		
		JPanel pSouth = new JPanel();
		pSouth.setBounds(5, 149, 443, 33);
		contentPane.add(pSouth);
		pSouth.setLayout(new GridLayout(0, 3, 10, 10));
		
		btnInsert = new JButton("입력");
		btnInsert.addActionListener(this);
		btnInsert.setFont(new Font("굴림", Font.BOLD, 15));
		pSouth.add(btnInsert);
		
		btnTotal = new JButton("출력1");
		btnTotal.addActionListener(this);
		btnTotal.setFont(new Font("굴림", Font.BOLD | Font.ITALIC, 15));
		pSouth.add(btnTotal);
		
		btnMargin = new JButton("출력2");
		btnMargin.addActionListener(this);
		btnMargin.setFont(new Font("굴림", Font.BOLD | Font.ITALIC, 15));
		pSouth.add(btnMargin);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnMargin) {
			actionPerformedBtnMargin(e);
		}
		if (e.getSource() == btnTotal) {
			do_btnTotal_actionPerformed(e);
		}
		if (e.getSource() == tfCode) {
			do_tfCode_actionPerformed(e);
		}
		if (e.getSource() == btnInsert) {
			do_btnInsert_actionPerformed(e);
		}
	}
	protected void do_btnInsert_actionPerformed(ActionEvent e) {
		
		String price = tfPrice.getText();
		String count = tfCount.getText();
		String margin = tfMargin.getText();
		if(price.length()>8) {
			JOptionPane.showMessageDialog(null, "8자리 이내의 정수로 입력하세요.");
			tfPrice.setText("");
			return;
		}
		if(count.length()>8) {
			JOptionPane.showMessageDialog(null, "8자리 이내의 정수로 입력하세요.");
			tfCount.setText("");
			return;
		}
		if(margin.length()>2) {
			JOptionPane.showMessageDialog(null, "2자리 이내의 정수로 입력하세요.");
			tfMargin.setText("");
			return;
		}
		CoffeeMng cf = new CoffeeMng();
		cf.setcCode(new Coffee(tfCode.getText()));
		cf.setcPrice(Integer.parseInt(price));
		cf.setcCount(Integer.parseInt(count));
		cf.setcMargin(Integer.parseInt(margin));
		service.insertCoffee(cf);
		clearC();
	}
	public void clearC() {
		tfCode.setText("");
		tfName.setText("");
		tfCount.setText("");
		tfPrice.setText("");
		tfMargin.setText("");
	}
	protected void do_tfCode_actionPerformed(ActionEvent e) {
		String code = tfCode.getText();
		String name = service.selectCoffeeName(code);
		tfName.setText(name);
		tfCode.setEditable(false);
		tfName.setEditable(false);
		tfCode.setFocusable(false);
		tfName.setFocusable(false);
	
	}
	protected void do_btnTotal_actionPerformed(ActionEvent e) {
		TotalRank tr = new TotalRank();
		tr.setVisible(true);
	}
	protected void actionPerformedBtnMargin(ActionEvent e) {
		TotalMargin tm = new TotalMargin();
		tm.setVisible(true);
	}
}
