/**
 * Người làm: Nguyễn Thanh Nghiem
 */
package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.NhaCungCapDAO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;

public class FrmThemNhaCungCap extends JFrame  {

	private JPanel contentPane;
	public static JTextField txtTen;
	public static JTextField txtSDT;
	public static JTextField txtEmail;
	private JButton btnThem;
	private NhaCungCapDAO dao = new NhaCungCapDAO();
	private List<String> listDiaChi= new ArrayList<String>();
	private DefaultComboBoxModel cboModleDiaChi= new DefaultComboBoxModel();
	private JTextField txtSoNha;
	private JTextField txtTenDuong;
	private JTextField txtPhuong;
	private JTextField txtQuan;
	private JTextField txtThanhPho;
	private JTextField txtQuocGia;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmThemNhaCungCap frame = new FrmThemNhaCungCap();
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
	public FrmThemNhaCungCap() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 439, 622);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
//		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 10, 434, 50);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("NHÀ CUNG CẤP");
		lblNewLabel.setForeground(new Color(0, 0, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 32));
		panel.add(lblNewLabel);
		
		JLabel lblTen = new JLabel("Tên nhà cung cấp :");
		lblTen.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblTen.setBounds(10, 70, 140, 30);
		contentPane.add(lblTen);
		
		JLabel lblSDT = new JLabel("Số điện thoại:");
		lblSDT.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblSDT.setBounds(10, 120, 138, 28);
		contentPane.add(lblSDT);
		
		JLabel lblEmail = new JLabel("Email :");
		lblEmail.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblEmail.setBounds(10, 170, 91, 28);
		contentPane.add(lblEmail);
		
		JLabel lblDiaChi = new JLabel("Đia chỉ:");
		lblDiaChi.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblDiaChi.setBounds(10, 220, 91, 28);
		contentPane.add(lblDiaChi);
		
		txtTen = new JTextField();
		txtTen.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtTen.setBounds(160, 75, 230, 22);
		contentPane.add(txtTen);
		txtTen.setColumns(10);
		
		txtSDT = new JTextField();
		txtSDT.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtSDT.setColumns(10);
		txtSDT.setBounds(160, 125, 230, 22);
		contentPane.add(txtSDT);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtEmail.setColumns(10);
		txtEmail.setBounds(160, 175, 230, 22);
		contentPane.add(txtEmail);
		
		btnThem = new JButton("Thêm");
		
		btnThem.setBackground(Color.WHITE);
		btnThem.setForeground(Color.BLACK);
		btnThem.setBounds(114, 531, 89, 35);
		contentPane.add(btnThem);
		
		JLabel lblSoNha = new JLabel("Số Nhà :");
		lblSoNha.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblSoNha.setBounds(40, 260, 90, 28);
		contentPane.add(lblSoNha);
		
		txtSoNha = new JTextField();
		txtSoNha.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtSoNha.setColumns(10);
		txtSoNha.setBounds(160, 265, 230, 22);
		contentPane.add(txtSoNha);
		
		JLabel lblTenDuong = new JLabel("Tên đường :");
		lblTenDuong.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblTenDuong.setBounds(40, 305, 90, 28);
		contentPane.add(lblTenDuong);
		
		txtTenDuong = new JTextField();
		txtTenDuong.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtTenDuong.setColumns(10);
		txtTenDuong.setBounds(160, 310, 230, 22);
		contentPane.add(txtTenDuong);
		
		JLabel lblPhuong = new JLabel("Phường :");
		lblPhuong.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblPhuong.setBounds(40, 350, 90, 28);
		contentPane.add(lblPhuong);
		
		txtPhuong = new JTextField();
		txtPhuong.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtPhuong.setColumns(10);
		txtPhuong.setBounds(160, 355, 230, 22);
		contentPane.add(txtPhuong);
		
		JLabel lblQuan = new JLabel("Quận :");
		lblQuan.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblQuan.setBounds(40, 395, 91, 28);
		contentPane.add(lblQuan);
		
		txtQuan = new JTextField();
		txtQuan.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtQuan.setColumns(10);
		txtQuan.setBounds(160, 400, 230, 22);
		contentPane.add(txtQuan);
		
		JLabel lblThanhPho = new JLabel("Thành phố :");
		lblThanhPho.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblThanhPho.setBounds(40, 440, 91, 28);
		contentPane.add(lblThanhPho);
		
		txtThanhPho = new JTextField();
		txtThanhPho.setText("Hồ Chí Minh");
		txtThanhPho.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtThanhPho.setColumns(10);
		txtThanhPho.setBounds(160, 445, 230, 22);
		contentPane.add(txtThanhPho);
		
		JLabel lblQuocGia = new JLabel("Quốc gia :");
		lblQuocGia.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblQuocGia.setBounds(40, 485, 91, 28);
		contentPane.add(lblQuocGia);
		
		txtQuocGia = new JTextField();
		txtQuocGia.setText("Việt Nam");
		txtQuocGia.setHorizontalAlignment(SwingConstants.LEFT);
		txtQuocGia.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtQuocGia.setColumns(10);
		txtQuocGia.setBounds(160, 490, 230, 22);
		contentPane.add(txtQuocGia);
		
		JButton btnThoat = new JButton("Thoát");
		btnThoat.setForeground(Color.BLACK);
		btnThoat.setBackground(Color.WHITE);
		btnThoat.setBounds(215, 531, 89, 35);
		contentPane.add(btnThoat);
		btnThem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				them();
			}
		});
		btnThoat.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setVisible(false);
			}
		});
	}
	/**
	 * Dùng để lấy dự liệu vào thêm vào cơ sở dữ liệu
	 */
	public void them() {
		if(kiemTra()==true) {
			String soNha =txtSoNha.getText();
			
			String tenDuong = txtTenDuong.getText();
			
			String phuong =txtPhuong.getText();
			String quan =txtQuan.getText();
			String thanhPho =txtQuan.getText();
			String quocGia =txtQuocGia.getText();
			dao.themDiaChi(soNha, tenDuong, phuong, quan, thanhPho, quocGia);
			List<Integer> maDC= dao.getMaDiaChi(soNha, tenDuong, phuong, quan, thanhPho, quocGia);
			String ten=txtTen.getText();
			String soDienThoai = txtSDT.getText();
			String email= txtEmail.getText();
			
			
			dao.them(ten, soDienThoai, email, maDC.get(0));
			JOptionPane.showMessageDialog(this , "Thêm nhà cung cấp thành công");
			setVisible(false);
			FrmThuoc.cmbNCC.setSelectedItem(ten);
		}
		else 
			return;
	}
	/**
	 * Kiểm tra các dữ liệu
	 * @return true nếu dữ liệu nhập đúng
	 * @return false nếu dữ liệu sai
	 */
	public boolean kiemTra() {
		if (txtTen.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "Vui lòng nhập tên nhà cung cấp !", "Thông báo !", JOptionPane.ERROR_MESSAGE);
			txtTen.requestFocus();
			txtTen.selectAll();
			return false;
		}
		else if (txtSDT.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "Vui lòng nhập số điện thoại nhà cung cấp !", "Thông báo !", JOptionPane.ERROR_MESSAGE);
			txtSDT.requestFocus();
			txtSDT.selectAll();
			return false;
		}
		else if (txtSDT.getText().matches("^[0]\\d{9}$") == false) {
			JOptionPane.showMessageDialog(this, "Vui lòng nhập số điện thoại nhà cung cấp bằng số và gồm 10 chữ số bất đầu bằng số 0 !", "Thông báo !", JOptionPane.ERROR_MESSAGE);
			txtSDT.requestFocus();
			txtSDT.selectAll();
			return false;
		}
		else if (txtEmail.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "Vui lòng nhập email nhà cung cấp ! ", "Thông báo !", JOptionPane.ERROR_MESSAGE);
			txtEmail.requestFocus();
			txtEmail.selectAll();
			return false;
		}
        else if (txtEmail.getText().matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$") == false) {
			JOptionPane.showMessageDialog(this, "Vui lòng nhập đúng email nhà cung cấp !\\n ví dụ:quoc@gmail.com ", "Thông báo !", JOptionPane.ERROR_MESSAGE);
			txtEmail.requestFocus();
			txtEmail.selectAll();
			return false;
		}
		else if (txtSoNha.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "Vui lòng nhập địa chỉ nhà cung cấp !", "Thông báo !", JOptionPane.ERROR_MESSAGE);
			txtSoNha.requestFocus();
			txtSoNha.selectAll();
			return false;
		}
		else if (txtTenDuong.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "Vui lòng nhập địa chỉ nhà cung cấp !", "Thông báo !", JOptionPane.ERROR_MESSAGE);
			txtTenDuong.requestFocus();
			txtTenDuong.selectAll();
			return false;
		}
		else if (txtPhuong.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "Vui lòng nhập địa chỉ nhà cung cấp !", "Thông báo !", JOptionPane.ERROR_MESSAGE);
			txtPhuong.requestFocus();
			txtPhuong.selectAll();
			return false;
		}
		
		else if (txtQuan.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "Vui lòng nhập địa chỉ nhà cung cấp !", "Thông báo !", JOptionPane.ERROR_MESSAGE);
			txtQuan.requestFocus();
			txtQuan.selectAll();
			return false;
		}
		else if (txtThanhPho.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "Vui lòng nhập địa chỉ nhà cung cấp !", "Thông báo !", JOptionPane.ERROR_MESSAGE);
			txtQuan.requestFocus();
			txtQuan.selectAll();
			return false;
		}
		else if (txtQuocGia.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "Vui lòng nhập địa chỉ nhà cung cấp !", "Thông báo !", JOptionPane.ERROR_MESSAGE);
			txtQuan.requestFocus();
			txtQuan.selectAll();
			return false;
		}
		return true;
	}
}
