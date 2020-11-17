package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import database.DB;
import models.Receipt;

public class ReceiptPage extends JFrame implements MouseListener,ActionListener{
	
	DB db=new DB();
	Vector v;
	Vector cols;
	DefaultTableModel model;
	JTable jTable;
	JScrollPane pane;
	JPanel pbtn;
	JButton btn;
//	String m_id="김영빈";
	
	public ReceiptPage() {
		// TODO Auto-generated constructor stub
		super("결제가 완료되었습니다. 인증번호를 확인하세요.");
		initialize();

	}
	public void initialize() {
		Receipt receipt=new Receipt();
		v=db.print_receipt();
		System.out.println("v="+v);
		cols=getColumn();
		
		model=new DefaultTableModel(v,cols);
		
		jTable =new JTable(model);
		pane=new JScrollPane(jTable);
		add(pane);
		
		setSize(800,100);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
	}
	
	
//		public static void main(String[] args) {
//			new ReceiptPage();
//		}
//	
	
	

	private Vector getColumn() {
		// TODO Auto-generated method stub
		Vector col=new Vector();
		col.add("이름");
		col.add("결제일");
		col.add("충전 시간");
		col.add("남은 시간");
		col.add("인증번호");
		col.add("가격");
		
		return col;
	}





	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
