package kr.or.dgit.coffee_pro.ui;

import java.awt.EventQueue;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import kr.or.dgit.coffee_pro.dto.CoffeeMng;
import kr.or.dgit.coffee_pro.service.CoffeeService;


public class TotalMargin extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private List<CoffeeMng> cfmng = new ArrayList<>();
	private JTextField tfTPrice;
	private JTextField tfTTax;
	private JTextField tfTTotal;
	private JTextField tfTProfit;
	private int cPrice = 0;
	private int cTax = 0;
	private int cTotal = 0;
	private int cProfit = 0;
	private CoffeeService service;
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TotalMargin frame = new TotalMargin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TotalMargin() {
		service = new CoffeeService();
		initComponents();
	}

	private void initComponents() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(500, 500, 700, 283);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(5, 45, 674, 172);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(getObj(),
				new String[] { "순위", "제품코드", "제품명", "제품단가", "판매수량", "공급가액", "부가세액", "판매금액", "마진율", "마진액" }));
		scrollPane.setViewportView(table);

		JPanel pNorth = new JPanel();
		pNorth.setBounds(5, 5, 674, 40);
		contentPane.add(pNorth);

		JLabel lblNewLabel = new JLabel("마진액순위");
		lblNewLabel.setFont(new Font("궁서체", Font.BOLD, 25));
		pNorth.add(lblNewLabel);
		tableCellAlign(SwingConstants.CENTER, 0, 1, 2);
		tableCellAlign(SwingConstants.RIGHT, 3,4, 5, 6, 7,8, 9);
		tableCellWidth(50, 70, 100, 80, 70, 80, 80, 80, 50, 80);

		JPanel pSouth = new JPanel();
		pSouth.setBounds(5, 219, 674, 24);
		contentPane.add(pSouth);
		pSouth.setLayout(null);

		JLabel lblTotal = new JLabel("합계");
		lblTotal.setHorizontalAlignment(SwingConstants.CENTER);
		lblTotal.setBounds(0, 0, 98, 24);
		pSouth.add(lblTotal);
		lblTotal.setFont(new Font("굴림", Font.BOLD | Font.ITALIC, 20));

		tfTPrice = new JTextField();
		tfTPrice.setHorizontalAlignment(SwingConstants.RIGHT);
		tfTPrice.setBounds(327, 0, 75, 24);
		pSouth.add(tfTPrice);
		tfTPrice.setColumns(10);
		tfTPrice.setText(toString().format("%,3d", cPrice));

		tfTTax = new JTextField();
		tfTTax.setHorizontalAlignment(SwingConstants.RIGHT);
		tfTTax.setColumns(10);
		tfTTax.setBounds(400, 0, 75, 24);
		pSouth.add(tfTTax);
		tfTTax.setText(toString().format("%,3d", cTax));

		tfTTotal = new JTextField();
		tfTTotal.setHorizontalAlignment(SwingConstants.RIGHT);
		tfTTotal.setColumns(10);
		tfTTotal.setBounds(475, 0, 75, 24);
		pSouth.add(tfTTotal);
		tfTTotal.setText(toString().format("%,3d", cTotal));

		tfTProfit = new JTextField();
		tfTProfit.setHorizontalAlignment(SwingConstants.RIGHT);
		tfTProfit.setColumns(10);
		tfTProfit.setBounds(599, 0, 75, 24);
		pSouth.add(tfTProfit);
		tfTProfit.setText(toString().format("%,3d", cProfit));
	}

	protected void tableCellAlign(int align, int... idx) {
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
		dtcr.setHorizontalAlignment(align);

		TableColumnModel model = table.getColumnModel();
		for (int i = 0; i < idx.length; i++) {
			model.getColumn(idx[i]).setCellRenderer(dtcr);
		}
	}

	protected void tableCellWidth(int... width) {
		TableColumnModel model = table.getColumnModel();
		for (int i = 0; i < width.length; i++) {
			model.getColumn(i).setPreferredWidth(width[i]);
		}
	}

	private Object[][] getObj() {
		Object[][] rows = null;

		cfmng = service.selectCoffeeMargin();
		rows = new Object[cfmng.size()][];
		for (int i = 0; i < cfmng.size(); i++) {
			CoffeeMng cm = cfmng.get(i);
			cPrice += cm.getSupplyPrice();
			cTax += cm.getTax();
			cTotal += cm.getTotal();
			cProfit += cm.getProfit();
			rows[i] = cm.toArray();
		}
		return rows;

	}
}
