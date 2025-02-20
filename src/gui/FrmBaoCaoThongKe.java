/*
 *  Người làm: Nguyễn Đăng Dương
 * Chức năng : Báo cáo thống kê.
 * 
 * 
 * */
package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.print.PrinterException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.print.DocFlavor.URL;
import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import java.awt.Label;
import javax.swing.ScrollPaneConstants;
import java.awt.Toolkit;
import javax.swing.border.MatteBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JMonthChooser;
import com.toedter.calendar.JYearChooser;
import database.ConectDatabase;
import entities.ThongKeHDTheoNhanVien;
import entities.ThongKeBaoCaoTQ;
import entities.ThongKeTinhTrangThuoc;
import entities.Thuoc;
import dao.DSBaoCaoTKTongQuatDAO;
import dao.DSThongKeHDTheoNhanVienDAO;
import dao.DSThongKeTTThuocDAO;

import javax.swing.border.EtchedBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.UIManager;
import java.awt.Component;
import javax.swing.table.TableModel;

import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import javax.swing.SwingConstants;
import com.toedter.calendar.JCalendar;
import javax.swing.JPopupMenu;
import java.awt.event.MouseAdapter;
import javax.swing.JMenuItem;
import javax.swing.JRadioButton;

public class FrmBaoCaoThongKe extends JFrame implements ActionListener, MouseListener {

	static JTabbedPane tabbedPane;
	static JPanel pnlThongkeTTThuoc, pnlToanPhan, pnTab3, pnTab4, panel_2, pnlThongKeBaoCao, pnlThongTinChung, pnlTT,
			pnlThongKeChiTiet, pnlTKtrongCT;
	JLabel lblThongTinKhachHang, lblDiaChi, lblThngKTheo, lblTngSLng_1, lblTngTin, lblMaKH, lblTenKH, lblSDT, lblNN,
			lblMakh, lblNgay, lblMaNV, lblTenNv, lblDonthuoc, lblTngSHa;
	JTextField txtDiaChi, txtTenKH, txtMaKH, txtNN, txtSDT, txtMakn;
	JButton btnTim, btnThem, btnXoa, btnBaoCao, btnXemThuocConLai, btnXemThuocDaBan, btnXemThuocHetHan,	btnXemthuocConLaiTrongKho;
	JComboBox cmbMaNV, cmbNgay, cmbDonThuoc, cmbNgayTLTQ;
	ImageIcon background;
	JPanel jpanel;
	JScrollPane scrollPaneTKTTT, scrTKTQ;
	JMonthChooser monthChooser;
	JMonthChooser txtThang;
	

	public static DefaultTableModel tablemodel = new DefaultTableModel();
	public static DefaultTableModel tablemodel1 = new DefaultTableModel();
	DefaultTableModel tablemodel2 = new DefaultTableModel();
	private JLabel lblNgayy;
	public static  JTextField txtTongSoLuongThuoc;
	public static  JTextField txtTongSoLoaiThuoc;
	private JTextField txtTenNV;
	public static JTextField txtTongSLTDB;
	public static JTextField txtTongTienDaBan;
	public static JTextField txtTongSoHD;
	private JTable table_1;
	private JTextField txtLoiNhuan;
	String s;
	private JTable table2;
	private JTextField txtTongTienThuocDaNhap;
	private JTextField txtTongTienBanDuocTKTq;
	private JTextField txtLoiNhuanThuDkTQ;
	private JButton btnXemBCAoTKTQ;
	private JTable tblThongKeTongQuat;
	private JPanel panel_12;
	private JTextField txtNam;
	private JComboBox comboBox;
	private JPopupMenu popupMenu;
	private JDateChooser txtChonNgay;
	private JDateChooser txtChonNgayThongKeThuoc;
	private JMenuItem mntmXemChiTiet;
	private JRadioButton radioButton_2;
	private JRadioButton radioButton_3;
	private JRadioButton radioButton_4;
	private JRadioButton radioButton_5;
	private JRadioButton radioButton_6;
	private JRadioButton radioButton_7;
	public static FrmXuatHD frmXuatHD = new FrmXuatHD();

	
	public FrmBaoCaoThongKe() {

		setBackground(new Color(255, 255, 255));
		
		setTitle("QUẢN LÍ QUẦY THUỐC BỆNH VIỆN TÂY NAM");
		setSize(1354, 733);
		setLocationRelativeTo(null);
		setResizable(false);
		panel_2 = new JPanel();
		pnlThongTinChung = new JPanel();
		pnlTT = new JPanel();
		pnlTT.setBounds(20, 60, 525, 89);
		pnlThongKeChiTiet = new JPanel();
		pnlTKtrongCT = new JPanel();
		txtTongSoHD = new JTextField();
		txtTongSoHD.setForeground(Color.BLUE);
		txtTongSLTDB = new JTextField();
		txtTongSLTDB.setForeground(Color.BLUE);
		txtTongTienDaBan = new JTextField();
		txtTongTienDaBan.setForeground(Color.BLUE);
		txtTongTienDaBan.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		txtTongTienDaBan.setText("                            ");
		txtTenNV = new JTextField();
		cmbMaNV = new JComboBox();
		cmbDonThuoc = new JComboBox();
		String ngay1;
		AbstractButton datePicker = null;
		Date today=new Date(System.currentTimeMillis()); // lấy thời gian thực
		SimpleDateFormat timeFormat = new SimpleDateFormat("yyyy-MM-dd");   // định dạng kiểu ngày	
		ngay1=timeFormat.format(today.getTime());
		pnlThongTinChung.setLayout(null);
		tabbedPane=new JTabbedPane();
		tabbedPane.setForeground(new Color(128, 128, 128));
		tabbedPane.setBounds(0, 0, 1338, 693);
		tabbedPane.setBorder(null);
		
		pnlToanPhan=new JPanel();
		pnlToanPhan.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		pnlToanPhan.setBackground(new Color(255, 255, 255));
		
		JPanel pnlTieuDeTKHDTHV = new JPanel();
		pnlTieuDeTKHDTHV.setBackground(new Color(255, 255, 255));
		pnlTieuDeTKHDTHV.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		pnlTieuDeTKHDTHV.setBounds(10, 11, 1313, 71);
		pnlToanPhan.add(pnlTieuDeTKHDTHV);
		pnlTieuDeTKHDTHV.setLayout(null);
		
		
		
		JLabel lblTieuDeTKHDTNV = new JLabel("THỐNG KÊ NHÂN VIÊN LẬP HÓA ĐƠN THEO NGÀY");
		lblTieuDeTKHDTNV.setHorizontalAlignment(SwingConstants.CENTER);
		lblTieuDeTKHDTNV.setForeground(Color.blue);
		lblTieuDeTKHDTNV.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		lblTieuDeTKHDTNV.setBounds(438, 11, 538, 37);
		pnlTieuDeTKHDTHV.add(lblTieuDeTKHDTNV);

		tabbedPane.addTab("Thống kê hóa đơn theo nhân viên",pnlToanPhan);
		tabbedPane.setForeground(Color.blue);
		pnlToanPhan.setLayout(null);
		
		
		pnlThongTinChung.setBackground(new Color(255, 255, 255));
		pnlThongTinChung.setBounds(10, 93, 555, 157);
		pnlToanPhan.add(pnlThongTinChung);
		
		lblNgay = new JLabel("Ngày:");
		lblNgay.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNgay.setBounds(23, 29, 48, 20);
		lblMaNV = new JLabel("Mã Nhân viên:");
		lblMaNV.setFont(new Font("Times New Roman", Font.PLAIN, 15));
	    lblTenNv = new JLabel("Tên Nhân viên:");
	    lblTenNv.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblDonthuoc = new JLabel("Đơn thuốc");
		lblDonthuoc.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblTngSHa = new JLabel("Tổng số hóa đơn:");
		lblTngSHa.setFont(new Font("Times New Roman", Font.PLAIN, 15));
	    lblTngSLng_1 = new JLabel("Tổng số lượng thuốc đã bán:");
	    lblTngSLng_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
	    lblTngTin = new JLabel("Tổng tiền đã bán:");
	    lblTngTin.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		
		lblTenNv.setBounds(7, 41, 107, 14);
		lblMaNV.setBounds(7, 8, 107, 14);
		lblDonthuoc.setBounds(285, 10, 79, 14);
		lblTngSHa.setBounds(43, 72, 150, 20);
		lblTngSLng_1.setBounds(43, 14, 200, 20);
		lblTngTin.setBounds(43, 42, 150, 22);
		
		
		txtTenNV.setBounds(124, 38, 130, 20);
		txtTongSLTDB.setBounds(253, 11, 124, 20);
		txtTongTienDaBan.setBounds(253, 38, 124, 20);
		txtTongSoHD.setBounds(253, 69, 124, 20);
		txtTenNV.setEditable(false);
		txtTongSLTDB.setEditable(false);
		txtTongTienDaBan.setEditable(false);
		txtTongSoHD.setEditable(false);
		txtTongSLTDB.setColumns(10);
		txtTenNV.setColumns(10);
		txtTongTienDaBan.setColumns(10);
		txtTongSoHD.setColumns(10);
	
	
		
		cmbMaNV.setBounds(124, 5, 130, 20);
		cmbDonThuoc.setBounds(380, 7, 135, 20);
		
		
			
		pnlTKtrongCT.add(lblTngTin);
		pnlTKtrongCT.add(lblTngSLng_1);
		pnlTKtrongCT.add(txtTongTienDaBan);
		pnlTKtrongCT.add(lblTngSHa);
		pnlTKtrongCT.add(txtTongSoHD);
		pnlTT.add(lblMaNV);
		pnlTT.add(lblTenNv);
		pnlTT.add(lblDonthuoc);
		pnlThongTinChung.add(lblNgay);
		pnlTT.add(cmbMaNV);
		cmbMaNV.addItem("Tất cả");
		
		chonMaNhanVien();
		
		pnlTT.add(txtTenNV);
		
		cmbDonThuoc.addItem("Tất cả");
		cmbDonThuoc.addItem("Thuốc kê đơn");
		cmbDonThuoc.addItem("Không kê đơn");
		pnlTT.add(cmbDonThuoc);
		
		
		pnlTKtrongCT.add(txtTongSLTDB);
		
		javax.swing.border.Border southborder4=BorderFactory.createLineBorder(Color.blue,Font.BOLD);
		TitledBorder southTitleBorder4=new TitledBorder(southborder4,"Thông tin chung");
		southTitleBorder4.setTitleColor(Color.blue);
		pnlThongTinChung.setBorder(new TitledBorder(null, "Thông tin chung", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlToanPhan.add(pnlThongTinChung);
		
		
		pnlTT.setBackground(new Color(255, 255, 255));
		pnlTT.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		pnlThongTinChung.add(pnlTT);
		pnlTT.setLayout(null);
		
		
		
		pnlThongKeChiTiet.setBackground(new Color(255, 255, 255));
		pnlThongKeChiTiet.setBounds(575, 93, 748, 157);
		pnlToanPhan.add(pnlThongKeChiTiet);
		pnlThongKeChiTiet.setLayout(null);
		
		javax.swing.border.Border southborder5=BorderFactory.createLineBorder(Color.red,Font.BOLD);
		TitledBorder southTitleBorder5=new TitledBorder(southborder5,"Chi tiết thống kê");
		 southTitleBorder5.setTitleColor(Color.red);
		pnlThongKeChiTiet.setBorder(new TitledBorder(null, "Thống kê chi tiết", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlToanPhan.add(pnlThongKeChiTiet);
		
	
		pnlTKtrongCT.setBackground(new Color(255, 255, 255));
		pnlTKtrongCT.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		pnlTKtrongCT.setBounds(10, 24, 728, 126);
		pnlThongKeChiTiet.add(pnlTKtrongCT);
		pnlTKtrongCT.setLayout(null);
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(406, 0, 312, 124);
		pnlTKtrongCT.add(label_1);
		
		radioButton_5 = new JRadioButton("");
		radioButton_5.setSelected(true);
		radioButton_5.setBackground(new Color(255, 255, 255));
		radioButton_5.setBounds(9, 14, 28, 19);
		pnlTKtrongCT.add(radioButton_5);
		
		radioButton_6 = new JRadioButton("");
		radioButton_6.setSelected(true);
		radioButton_6.setBackground(new Color(255, 255, 255));
		radioButton_6.setBounds(9, 42, 28, 19);
		pnlTKtrongCT.add(radioButton_6);
		
		radioButton_7 = new JRadioButton("");
		radioButton_7.setSelected(true);
		radioButton_7.setBackground(new Color(255, 255, 255));
		radioButton_7.setBounds(9, 67, 28, 22);
		pnlTKtrongCT.add(radioButton_7);

		javax.swing.border.Border southborder=BorderFactory.createLineBorder(Color.red,Font.BOLD);
		TitledBorder southTitleBorder=new TitledBorder(southborder,"Hình thức thống kê");
		 southTitleBorder.setTitleColor(Color.red);
		javax.swing.border.Border southborder1=BorderFactory.createLineBorder(Color.blue,Font.BOLD);
		TitledBorder southTitleBorder1=new TitledBorder(southborder1,"Báo cáo sau thống kê");
		southTitleBorder1.setTitleColor(Color.red);
		getContentPane().setLayout(null);
		
		
		getContentPane().add(tabbedPane);
		
		cmbDonThuoc.addActionListener(this);
//		cmbNgay.addActionListener(this);
		cmbMaNV.addActionListener(this);
		
		javax.swing.border.Border southborder2=BorderFactory.createLineBorder(Color.blue);
		TitledBorder southTitleBorder2=new TitledBorder(southborder2,"Danh sách thuốc sau thống kê");
		southTitleBorder2.setTitleColor(Color.red);
		
		JScrollPane scrDSTK;
		String[] tb1 = new String[] {"STT","Mã Hóa Đơn","Mã Nhân viên","Ca Làm Việc","Ngày Lập","Tổng Tiền","Loại Hóa Đơn","Số Lượng"};
		tablemodel = new DefaultTableModel(tb1, 0);
		table_1 = new JTable(tablemodel);

		table_1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		table_1.setBackground(new Color(255, 255, 255));
		table_1.setForeground(new Color(0,0,255));
		getContentPane().add(scrDSTK=new JScrollPane(table_1,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS),BorderLayout.CENTER);
		
		popupMenu = new JPopupMenu();
		addPopup(table_1, popupMenu);
		mntmXemChiTiet = new JMenuItem("Xem Chi Tiết Hóa Đơn");
		popupMenu.add(mntmXemChiTiet);
		table_1.setRowHeight(20);
		txtChonNgay = new JDateChooser();
		txtChonNgay.setForeground(Color.blue);
		txtChonNgay.getCalendarButton().setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtChonNgay.setLocale(new Locale("vi", "VN"));
		txtChonNgay.setDateFormatString("dd/MM/yyyy");
		txtChonNgay.setDate(new Date(System.currentTimeMillis()));
		txtChonNgay.setBounds(81, 29, 142, 20);
	
		
		pnlThongTinChung.add(txtChonNgay);
	
		javax.swing.border.Border southbordert=BorderFactory.createLineBorder(Color.red);
		TitledBorder southTitleBordert=new TitledBorder(southbordert,"Thông tin chung về thuốc");
		southTitleBordert.setTitleColor(Color.red);
		scrDSTK.setBorder(new TitledBorder(null, "Danh sách thống kê", TitledBorder.LEADING, TitledBorder.TOP, null, null));
	
		pnlToanPhan.add(scrDSTK);
		scrDSTK.setPreferredSize(new Dimension(0,250));
		pnlToanPhan.setLayout(null);
	
		scrDSTK.setBounds(10, 248, 1313, 292);
		
		JPanel panel_8 = new JPanel();
		scrDSTK.setColumnHeaderView(panel_8);
		panel_8.setBackground(new Color(255, 255, 255));
		panel_8.setLayout(null);
		getContentPane().add(tabbedPane);
		getContentPane().add(tabbedPane);
		javax.swing.border.Border southborder6=BorderFactory.createLineBorder(Color.blue,Font.BOLD);
		TitledBorder southTitleBorder6=new TitledBorder(southborder6,"Chức năng");
		southTitleBorder6.setTitleColor(Color.red);
		
		panel_12 = new JPanel();
		panel_12.setBackground(new Color(255, 255, 255));
		panel_12.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_12.setBounds(10, 545, 1313, 91);
		pnlToanPhan.add(panel_12);
		panel_12.setLayout(null);
		
		
		
		btnBaoCao = new JButton("Xem Báo Cáo");
		btnBaoCao.setBounds(508, 22, 255, 52);
		panel_12.add(btnBaoCao);
		btnBaoCao.addActionListener(this);
		
		btnBaoCao.setForeground(Color.blue);
		btnBaoCao.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnBaoCao.setBackground(new Color(255, 255, 255));
		
		pnlThongkeTTThuoc=new JPanel();
		pnlThongkeTTThuoc.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		pnlThongkeTTThuoc.setBackground(new Color(255, 255, 255));
		
		tabbedPane.addTab("Thống kê tình trạng thuốc",pnlThongkeTTThuoc);
		tabbedPane.setBackgroundAt(1, new Color(255, 255, 255));
		tabbedPane.setForegroundAt(1, new Color(0, 0, 255));
		
		pnlThongkeTTThuoc.setBounds(0, 50, 900, 240);
		pnlThongkeTTThuoc.setPreferredSize(new Dimension(0,240));
		pnlThongkeTTThuoc.setLayout(null);
		pnlThongkeTTThuoc.setLayout(null);
		tabbedPane.setBackgroundAt(1, new Color(255, 255, 255));
		tabbedPane.setForegroundAt(1, new Color(0, 0, 255));
		
		
		JPanel jp2 = new JPanel();
		jp2.setBounds(10, 107, 688, 239);
		jp2.setBackground(new Color(255, 255, 255));
		pnlThongkeTTThuoc.add(jp2);
		jp2.setLayout(null);
		jp2.setBorder(new TitledBorder(null, "Hình thức thống kê", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		lblNgayy = new JLabel("Ngày:");
		lblNgayy.setFont(new Font("Times New Roman ", Font.PLAIN, 15));
		lblNgayy.setForeground(new Color(0, 0, 0));
		lblNgayy.setBounds(10, 33, 46, 20);
		jp2.add(lblNgayy);
		//////////////////////////////
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_3.setBackground(new Color(255, 255, 255));
		panel_3.setBounds(10, 77, 668, 145);
		jp2.add(panel_3);
		panel_3.setLayout(null);
		
		btnXemThuocHetHan = new JButton("Xem thuốc hết hạng");
		btnXemThuocHetHan.setHorizontalAlignment(SwingConstants.LEFT);
		btnXemThuocHetHan.setBounds(6, 11, 297, 54);
		panel_3.add(btnXemThuocHetHan);
		btnXemThuocHetHan.setBackground(new Color(255, 255, 255));
		btnXemThuocHetHan.setForeground(new Color(0, 0, 255));
		btnXemThuocHetHan.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		btnXemThuocDaBan = new JButton(" Xem thuốc đã bán");
		btnXemThuocDaBan.setHorizontalAlignment(SwingConstants.LEFT);
		btnXemThuocDaBan.setBounds(6, 76, 297, 54);
		panel_3.add(btnXemThuocDaBan);
		btnXemThuocDaBan.setBackground(new Color(255, 255, 255));
		btnXemThuocDaBan.setForeground(new Color(0, 0, 255));
		btnXemThuocDaBan.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		btnXemThuocConLai = new JButton("  Xem thuốc còn hạn sử dụng");
		btnXemThuocConLai.setHorizontalAlignment(SwingConstants.LEFT);
		btnXemThuocConLai.setBounds(335, 13, 323, 51);
		panel_3.add(btnXemThuocConLai);
		btnXemThuocConLai.setBackground(new Color(255, 255, 255));
		btnXemThuocConLai.setForeground(new Color(0, 0, 255));
		btnXemThuocConLai.setFont(new Font("Times New Roman", Font.BOLD, 16));

		
		btnXemthuocConLaiTrongKho = new JButton("Xem thuốc còn lại trong kho");
		btnXemthuocConLaiTrongKho.setHorizontalAlignment(SwingConstants.LEFT);
		btnXemthuocConLaiTrongKho.setBounds(335, 76, 323, 55);
		panel_3.add(btnXemthuocConLaiTrongKho);
		btnXemthuocConLaiTrongKho.setForeground(new Color(0, 0, 255));
		btnXemthuocConLaiTrongKho.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnXemthuocConLaiTrongKho.setBackground(new Color(255, 255,255));
		
		txtChonNgayThongKeThuoc = new JDateChooser();
		txtChonNgayThongKeThuoc.getCalendarButton().setForeground(new Color(255, 255, 255));
		txtChonNgayThongKeThuoc.getCalendarButton().setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtChonNgayThongKeThuoc.setLocale(new Locale("vi", "VN"));
		txtChonNgayThongKeThuoc.setDateFormatString("dd/MM/yyyy");
		txtChonNgayThongKeThuoc.setBounds(77, 33, 153, 20);
		txtChonNgayThongKeThuoc.setDate(new Date(System.currentTimeMillis()));
		
		jp2.add(txtChonNgayThongKeThuoc);
		
		String ngay2;
		AbstractButton datePicker1 = null;
		Date today1=new Date(System.currentTimeMillis()); 
		SimpleDateFormat timeFormat1 = new SimpleDateFormat("yyyy-MM-dd");  
		ngay2=timeFormat1.format(today.getTime());

	
		btnXemThuocConLai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JPanel jp3 = new JPanel();
		jp3.setBounds(708, 107, 615, 239);
		jp3.setBackground(new Color(255, 255, 255));
		jp3.setBorder(new TitledBorder(null, "Báo cáo sau thống kê", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlThongkeTTThuoc.add(jp3);
		jp3.setLayout(null);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(255, 255, 255));
		panel_4.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_4.setBounds(23, 45, 582, 177);
		jp3.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblTongSoLuongThuoc = new JLabel("Tổng số lượng thuốc");
		lblTongSoLuongThuoc.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblTongSoLuongThuoc.setBounds(30, 32, 145, 28);
		panel_4.add(lblTongSoLuongThuoc);
		lblTongSoLuongThuoc.setForeground(new Color(0, 0, 0));
		
		txtTongSoLuongThuoc = new JTextField();
		txtTongSoLuongThuoc.setEditable(false);
		txtTongSoLuongThuoc.setForeground(Color.BLUE);
		txtTongSoLuongThuoc.setBounds(185, 38, 86, 20);
		panel_4.add(txtTongSoLuongThuoc);
		txtTongSoLuongThuoc.setColumns(10);
		
		JLabel lblTongSoLoaiThuoc = new JLabel("Tổng số loại thuốc");
		lblTongSoLoaiThuoc.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblTongSoLoaiThuoc.setBounds(30, 81, 135, 17);
		panel_4.add(lblTongSoLoaiThuoc);
		lblTongSoLoaiThuoc.setForeground(new Color(0, 0, 0));
		
		txtTongSoLoaiThuoc = new JTextField();
		txtTongSoLoaiThuoc.setForeground(Color.BLUE);
		txtTongSoLoaiThuoc.setBounds(185, 81, 86, 20);
		panel_4.add(txtTongSoLoaiThuoc);
		txtTongSoLoaiThuoc.setEditable(false);
		txtTongSoLoaiThuoc.setColumns(10);
		
		JRadioButton radioButton = new JRadioButton("");
		radioButton.setSelected(true);
		radioButton.setBackground(new Color(255, 255, 255));
		radioButton.setBounds(6, 35, 28, 20);
		panel_4.add(radioButton);
		
		JRadioButton radioButton_1 = new JRadioButton("");
		radioButton_1.setSelected(true);
		radioButton_1.setBackground(new Color(255, 255, 255));
		radioButton_1.setBounds(6, 81, 28, 17);
		panel_4.add(radioButton_1);
		
		
				
		scrollPaneTKTTT = new JScrollPane();
		scrollPaneTKTTT.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPaneTKTTT.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPaneTKTTT.setBounds(10, 355, 1323, 269);
		pnlThongkeTTThuoc.add(scrollPaneTKTTT);
				
		
		
		String[] tb2 = new String[] {"STT", "Mã Thuốc", "Tên Thuốc", "Phân Loại", "Số lượng", "Ngày Sản Xuất", "Hạn Sử dụng","Ngày Lập"};
		tablemodel1 = new DefaultTableModel(tb2, 0);
		table2 = new JTable(tablemodel1);
		table2.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		table2.setBackground(new Color(255, 255, 255));
		table2.setForeground(Color.BLUE);
		table2.getColumnModel().getColumn(3).setPreferredWidth(95);
		table2.getColumnModel().getColumn(5).setPreferredWidth(110);
		table2.getColumnModel().getColumn(6).setPreferredWidth(121);
		scrollPaneTKTTT.setViewportView(table2);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(10, 6, 1313, 71);
		pnlThongkeTTThuoc.add(panel);
		
		JLabel lblT = new JLabel("THỐNG KÊ TÌNH TRẠNG THUỐC");
		lblT.setHorizontalAlignment(SwingConstants.CENTER);
		lblT.setForeground(Color.blue);
		lblT.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		lblT.setBounds(445, 11, 362, 49);
		panel.add(lblT);
		
		
		
		

		pnlThongKeBaoCao=new JPanel();
		pnlThongKeBaoCao.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		pnlThongKeBaoCao.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("Thống kê báo cáo\r\n",pnlThongKeBaoCao);
		
		
		pnlThongKeBaoCao.setBounds(0, 50, 900, 240);
		pnlThongKeBaoCao.setPreferredSize(new Dimension(0,240));
		pnlThongKeBaoCao.setLayout(null);
		pnlThongKeBaoCao.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(30, 11, 1293, 265);
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		pnlThongKeBaoCao.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(10, 89, 367, 164);
		panel_5.setBackground(new Color(255, 255, 255));
		panel_5.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel lblNgayTKTQ = new JLabel("Tháng:");
		lblNgayTKTQ.setFont(new Font("Times New Ronam", Font.PLAIN, 15));
		lblNgayTKTQ.setBounds(10, 23, 59, 31);
		panel_5.add(lblNgayTKTQ);
		

		
		btnXemBCAoTKTQ = new JButton("Xem Báo Cáo");
		btnXemBCAoTKTQ.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnXemBCAoTKTQ.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					DSBaoCaoTKTongQuatDAO DS=new DSBaoCaoTKTongQuatDAO();

					int thang=Integer.parseInt(comboBox.getSelectedItem().toString());
					int nam=Integer.parseInt(txtNam.getText());
					DecimalFormat tien = new DecimalFormat("###,###,### VND");
					double tienBan=0;
					double tienNhap=0;
					double tienLai=0;
					double tienBanSetText =0;
					for(ThongKeBaoCaoTQ thongKeBaoCaoTQ : DS.thongKeThuocDaBan_DoanhThu_TheoThang(thang, nam)) {
						tienBanSetText += thongKeBaoCaoTQ.getDonGia() * thongKeBaoCaoTQ.getSoLuongBan();
						
					}
					int checkNull=0;
					tblThongKeTongQuat.setDefaultEditor(Object.class, null);
					txtTongTienBanDuocTKTq.setText(tien.format(tienBanSetText));
					
					txtTongTienThuocDaNhap.setText(tien.format(DS.tinhTongTienThuocDaNhapTheoThang(thang, nam)));
					
					tienBan=tienBanSetText;
					tienNhap +=DS.tinhTongTienThuocDaNhapTheoThang(thang, nam);
				
					tienLai=tienBan-tienNhap;
					txtLoiNhuanThuDkTQ.setText(tien.format(tienLai));
					
					
					int i=0;
					int  check=0;
					xoaBanggTKTQ();
					double tienBanDuoc =0;
					for(ThongKeBaoCaoTQ thongKeBaoCaoTQ : DS.thongKeThuocDaBan_DoanhThu_TheoThang(thang, nam)) {
						tienBanDuoc = thongKeBaoCaoTQ.getDonGia() * thongKeBaoCaoTQ.getSoLuongBan();
						tablemodel2.addRow(new Object[] {
								
								++i,thongKeBaoCaoTQ.getMaThuoc(),thongKeBaoCaoTQ.getTenThuoc(),tien.format(thongKeBaoCaoTQ.getDonGia()),tien.format(thongKeBaoCaoTQ.getDonGiaNhap()),thongKeBaoCaoTQ.getSoLuongNhap(),thongKeBaoCaoTQ.getSoLuongBan(),tien.format(thongKeBaoCaoTQ.getLoiNhuan()),thongKeBaoCaoTQ.getNgay(),thongKeBaoCaoTQ.getSoDK(),tien.format(tienBanDuoc)
						});
						check ++;
					}
					if(check==0) {
						JOptionPane.showMessageDialog(null,"Không có dữ liệu của tháng:"+thang+"/"+nam+"");
					}
					
				
				} catch (Exception e) {
					// TODO: handle exception
				}
				
				
			}
				
		});
		btnXemBCAoTKTQ.setBackground(new Color(255, 255, 255));
		btnXemBCAoTKTQ.setBounds(74, 85, 205, 46);
		btnXemBCAoTKTQ.setForeground(Color.blue);
		panel_5.add(btnXemBCAoTKTQ);
		
		comboBox = new JComboBox();
		comboBox.setForeground(new Color(0, 0, 255));
		comboBox.setBounds(79, 23, 85, 31);
		comboBox.addItem("1");
		comboBox.addItem("2");
		comboBox.addItem("3");
		comboBox.addItem("4");
		comboBox.addItem("5");
		comboBox.addItem("6");
		comboBox.addItem("7");
		comboBox.addItem("8");
		comboBox.addItem("9");
		comboBox.addItem("10");
		comboBox.addItem("11");
		comboBox.addItem("12");
		panel_5.add(comboBox);
		
		JLabel lblNm = new JLabel("Năm:");
		lblNm.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNm.setBounds(177, 26, 59, 28);
		panel_5.add(lblNm);
		
		txtNam = new JTextField();
		txtNam.setForeground(new Color(0, 0, 255));
		txtNam.setBounds(245, 23, 85, 31);
		panel_5.add(txtNam);
		txtNam.setColumns(10);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBounds(400, 89, 883, 164);
		panel_7.setBackground(new Color(255, 255, 255));
		panel_7.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1.add(panel_7);
		panel_7.setLayout(null);
		
		JPanel pnlThongtinThongKeTQ = new JPanel();
		pnlThongtinThongKeTQ.setBackground(new Color(255, 255, 255));
		pnlThongtinThongKeTQ.setBorder(new TitledBorder(null, "Thông tin thống kê ", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlThongtinThongKeTQ.setBounds(10, 29, 495, 124);
		panel_7.add(pnlThongtinThongKeTQ);
		pnlThongtinThongKeTQ.setLayout(null);
		
		JLabel lblTongSoLuongDaNhap = new JLabel("Tổng tiền thuốc đã nhập:");
		lblTongSoLuongDaNhap.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblTongSoLuongDaNhap.setBounds(53, 50, 178, 20);
		pnlThongtinThongKeTQ.add(lblTongSoLuongDaNhap);
		
		txtTongTienThuocDaNhap = new JTextField();
		txtTongTienThuocDaNhap.setForeground(new Color(0, 0, 255));
		txtTongTienThuocDaNhap.setEditable(false);
		txtTongTienThuocDaNhap.setBounds(228, 49, 241, 20);
		pnlThongtinThongKeTQ.add(txtTongTienThuocDaNhap);
		txtTongTienThuocDaNhap.setColumns(10);
		
		txtTongTienBanDuocTKTq = new JTextField();
		txtTongTienBanDuocTKTq.setForeground(new Color(0, 0, 255));
		txtTongTienBanDuocTKTq.setEditable(false);
		txtTongTienBanDuocTKTq.setColumns(10);
		txtTongTienBanDuocTKTq.setBounds(228, 19, 241, 20);
		pnlThongtinThongKeTQ.add(txtTongTienBanDuocTKTq);
		
		JLabel lblLoiNhuanThuDuoc = new JLabel("Lợi nhuận thu được:");
		lblLoiNhuanThuDuoc.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblLoiNhuanThuDuoc.setBounds(53, 75, 134, 19);
		pnlThongtinThongKeTQ.add(lblLoiNhuanThuDuoc);
		
		txtLoiNhuanThuDkTQ = new JTextField();
		txtLoiNhuanThuDkTQ.setForeground(new Color(0, 0, 255));
		txtLoiNhuanThuDkTQ.setEditable(false);
		txtLoiNhuanThuDkTQ.setColumns(10);
		txtLoiNhuanThuDkTQ.setBounds(353, 74, 116, 20);
		pnlThongtinThongKeTQ.add(txtLoiNhuanThuDkTQ);
		
		JLabel lblTongSoTienBanDuoc = new JLabel("Tổng tiền bán được:");
		lblTongSoTienBanDuoc.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblTongSoTienBanDuoc.setBounds(53, 25, 156, 20);
		pnlThongtinThongKeTQ.add(lblTongSoTienBanDuoc);
		
		radioButton_2 = new JRadioButton("");
		radioButton_2.setSelected(true);
		radioButton_2.setBackground(new Color(255, 255, 255));
		radioButton_2.setBounds(19, 30, 28, 11);
		pnlThongtinThongKeTQ.add(radioButton_2);
		
		radioButton_3 = new JRadioButton("");
		radioButton_3.setSelected(true);
		radioButton_3.setBackground(new Color(255, 255, 255));
		radioButton_3.setBounds(19, 50, 28, 16);
		pnlThongtinThongKeTQ.add(radioButton_3);
		
		radioButton_4 = new JRadioButton("");
		radioButton_4.setSelected(true);
		radioButton_4.setBackground(new Color(255, 255, 255));
		radioButton_4.setBounds(19, 74, 28, 20);
		pnlThongtinThongKeTQ.add(radioButton_4);
		
		JLabel label = new JLabel("");
		label.setBounds(515, 29, 320, 124);
		panel_7.add(label);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBounds(10, 11, 1273, 71);
		panel_6.setLayout(null);
		panel_6.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_6.setBackground(new Color(255, 255, 255));
		panel_1.add(panel_6);
		
		JLabel lblThngKTheo_1 = new JLabel("THỐNG KÊ DOANH THU THEO THÁNG");
		lblThngKTheo_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblThngKTheo_1.setForeground(Color.blue);
		lblThngKTheo_1.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		lblThngKTheo_1.setBounds(438, 11, 500, 37);
		panel_6.add(lblThngKTheo_1);
		
		JScrollPane scrThongKeTongQuat = new JScrollPane();
		scrThongKeTongQuat.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrThongKeTongQuat.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrThongKeTongQuat.setBounds(30, 275, 1293, 338);
		pnlThongKeBaoCao.add(scrThongKeTongQuat);	
		
		JScrollPane scrTKTQ;
		String[] tq = new String[] {"STT","Mã Thuốc","Tên Thuốc","Đơn Giá Bán","Đơn Giá Nhập","Số Lượng Nhập","Số Lượng Bán","Tiền Nhập Thuốc","Ngày Hết Hạn","Số Đăng Kí","Tiền Bán Được"};
		tablemodel2 = new DefaultTableModel(tq, 0);
		tblThongKeTongQuat = new JTable(tablemodel2);
		tblThongKeTongQuat.setForeground(new Color(0, 0, 255));
		tblThongKeTongQuat.setBackground(new Color(255, 255, 255));
		tblThongKeTongQuat.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));

		tblThongKeTongQuat.getColumnModel().getColumn(0).setPreferredWidth(37);
		tblThongKeTongQuat.getColumnModel().getColumn(1).setPreferredWidth(65);
		tblThongKeTongQuat.getColumnModel().getColumn(3).setPreferredWidth(92);
		tblThongKeTongQuat.getColumnModel().getColumn(4).setPreferredWidth(79);
		tblThongKeTongQuat.getColumnModel().getColumn(5).setPreferredWidth(133);
		tblThongKeTongQuat.getColumnModel().getColumn(6).setPreferredWidth(83);
		tblThongKeTongQuat.getColumnModel().getColumn(7).setPreferredWidth(77);
		tblThongKeTongQuat.getColumnModel().getColumn(8).setPreferredWidth(90);
		tblThongKeTongQuat.getColumnModel().getColumn(9).setPreferredWidth(105);
		scrThongKeTongQuat.setViewportView(tblThongKeTongQuat);
		
		btnXemThuocConLai.addActionListener(this);
		btnXemThuocDaBan.addActionListener(this);
		btnXemThuocHetHan.addActionListener(this);
		btnXemBCAoTKTQ.addActionListener(this);
		mntmXemChiTiet.addActionListener(this);


	}

	@Override

	public void actionPerformed(ActionEvent e) {
		int checkNull=0;

		Object obj = e.getSource();
		String chonDon = this.cmbDonThuoc.getSelectedItem().toString();
		String chonMaNhanVien = this.cmbMaNV.getSelectedItem().toString();
		AbstractButton datePicker = null;
		Date today = new Date(System.currentTimeMillis()); 
		SimpleDateFormat timeFormat = new SimpleDateFormat("dd-MM-yyyy"); 
		s = timeFormat.format(today.getTime());
		DecimalFormat df = new DecimalFormat();
		if (obj.equals(btnXemThuocHetHan)) {
			{
				scrollPaneTKTTT.setBorder(BorderFactory.createTitledBorder("Danh Sách Thuốc Hết Hạn Sử Dụng"));
				DSThongKeTTThuocDAO dsThongKeTTThuoc = new DSThongKeTTThuocDAO();
				xoaBang();
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
				String ngayChon = simpleDateFormat.format(txtChonNgayThongKeThuoc.getDate());
				
				java.sql.Date ngayHetHan = java.sql.Date.valueOf(ngayChon);
				int i=0;
				int check=0;
				int tongSoLuongThuoc = 0;
				for(Thuoc thuoc : dsThongKeTTThuoc.danhSachThuocHetHan(ngayHetHan)) {
					
					tablemodel1.addRow(new Object[] {
						++i,thuoc.getMaThuoc(),thuoc.getTenThuoc(),thuoc.getPhanLoai(),thuoc.getSoLuongNhap(),thuoc.getNgaySanXuat(),thuoc.getHanSuDung()	
					});
					tongSoLuongThuoc += thuoc.getSoLuongNhap();
					check++;
				}
				if(check==0) {
					JOptionPane.showMessageDialog(null,"Không có thuốc hết hạn trong ngày:"+ngayHetHan);
				}		
				txtTongSoLuongThuoc.setText(tongSoLuongThuoc +"");
				txtTongSoLoaiThuoc.setText(i+"");
			}
		}
		else if (obj.equals(btnXemThuocConLai)) {
			//xoaBang();
			scrollPaneTKTTT.setBorder(BorderFactory.createTitledBorder("Danh Sách Thuốc Còn Hạn Sử Dụng"));
			DSThongKeTTThuocDAO dsThongKeTTThuoc = new DSThongKeTTThuocDAO();
			xoaBang();
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			String ngayChon = simpleDateFormat.format(txtChonNgayThongKeThuoc.getDate());
			
			java.sql.Date ngay = java.sql.Date.valueOf(ngayChon);
			int i=0;
			int check=0;
			int tongSoLuongThuoc = 0;
			for(Thuoc thuoc : dsThongKeTTThuoc.danhSachThuocConLai(ngay)){
				
				tablemodel1.addRow(new Object[] {
					++i,thuoc.getMaThuoc(),thuoc.getTenThuoc(),thuoc.getPhanLoai(),thuoc.getSoLuongNhap(),thuoc.getNgaySanXuat(),thuoc.getHanSuDung()	
				});
				tongSoLuongThuoc += thuoc.getSoLuongNhap();
				check++;
			}
			if(check==0) {
				JOptionPane.showMessageDialog(null,"Không có dữ liệu của ngày:"+ngay);
			}
			table2.setModel(tablemodel1);
			txtTongSoLuongThuoc.setText(tongSoLuongThuoc +"");
			txtTongSoLoaiThuoc.setText(i+"");
		}
		else if(obj.equals(mntmXemChiTiet)) {
			DSThongKeHDTheoNhanVienDAO dsThongKeHDTheoNhanVien = new DSThongKeHDTheoNhanVienDAO();
		
			int row = table_1.getSelectedRow();
			
			String maHoaDon =tablemodel.getValueAt(row, 1).toString();
			
			dsThongKeHDTheoNhanVien.XemThongtinCTHoaDon(maHoaDon);
			dsThongKeHDTheoNhanVien.XemThongtinCTHoaDonn(maHoaDon);
			
			dsThongKeHDTheoNhanVien.XemThongtinCTHoaDonnn(maHoaDon);
			frmXuatHD.setVisible(true);	
		}	
		else if (obj.equals(btnXemThuocDaBan)) {		
			xoaBang();
			scrollPaneTKTTT.setBorder(BorderFactory.createTitledBorder("Danh sách thuốc đã bán trong ngày"));
         	DSThongKeTTThuocDAO dsThongKeThuoc = new DSThongKeTTThuocDAO();
			Calendar ngayCld = Calendar.getInstance();
			
			ngayCld.setTime(txtChonNgayThongKeThuoc.getDate());
			int ngay = ngayCld.get(Calendar.DATE);
			int thang = ngayCld.get(Calendar.MONTH)+1;
			int nam = ngayCld.get(Calendar.YEAR);
			
			
			dsThongKeThuoc.danhsachThuocDaBan(ngay, thang, nam);
			String tongSoLoaiThuoc = null;
			try {
				tongSoLoaiThuoc = dsThongKeThuoc.tinhTongLoaiThuocDaBan(ngay, thang, nam)+"";
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			txtTongSoLoaiThuoc.setText(tongSoLoaiThuoc);	
		}
		else	if (obj.equals(btnXemthuocConLaiTrongKho)) {
			

			xoaBang();
			scrollPaneTKTTT.setBorder(BorderFactory.createTitledBorder("Danh Sách Thuốc Trong Kho"));
         	DSThongKeTTThuocDAO dsThongKeThuoc = new DSThongKeTTThuocDAO();
			dsThongKeThuoc.danhsachThuocConLaiTrongKho();		
		}

		if (chonMaNhanVien.equalsIgnoreCase("Tất Cả")) {
			txtTenNV.setText("");
		} else {
			chonTenNhanVien(chonMaNhanVien);
		}
		if (obj.equals(btnBaoCao)) {
			int stt = 1;

			xoaBangg();

			if(chonMaNhanVien.equalsIgnoreCase("Tất cả")==false && chonDon.equalsIgnoreCase("Thuốc kê đơn")==true) {
				xoaBangg();
				Calendar ngayCld = Calendar.getInstance();
				ngayCld.setTime(txtChonNgay.getDate());
				int ngay = ngayCld.get(Calendar.DATE);
				int thang = ngayCld.get(Calendar.MONTH)+1;
				int nam = ngayCld.get(Calendar.YEAR);
				DSThongKeHDTheoNhanVienDAO dsThongKeHDTheoNhanVien = new DSThongKeHDTheoNhanVienDAO();
				dsThongKeHDTheoNhanVien.thongKeNhanVienLapHoaDonKeDon_TheoNgay_TheoMa(ngay, thang, nam, Integer.parseInt(cmbMaNV.getSelectedItem().toString()));
				
			}
			
			else if(chonMaNhanVien.equalsIgnoreCase("Tất cả")==false && chonDon.equalsIgnoreCase("Không kê đơn")==true) {
				xoaBangg();
				Calendar ngayCld = Calendar.getInstance();
				ngayCld.setTime(txtChonNgay.getDate());
				int ngay = ngayCld.get(Calendar.DATE);
				int thang = ngayCld.get(Calendar.MONTH)+1;
				int nam = ngayCld.get(Calendar.YEAR);
				DSThongKeHDTheoNhanVienDAO dsThongKeHDTheoNhanVien = new DSThongKeHDTheoNhanVienDAO();
				dsThongKeHDTheoNhanVien.thongKeNhanVienLapHoaDonKeDon_TheoNgay_TheoMaKeDonKKeDon(ngay, thang, nam, Integer.parseInt(cmbMaNV.getSelectedItem().toString()));
				
			}
			
			else if(chonMaNhanVien.equalsIgnoreCase("Tất cả")==false && chonDon.equalsIgnoreCase("Tất cả")==true) {
				xoaBangg();
				Calendar ngayCld = Calendar.getInstance();
				ngayCld.setTime(txtChonNgay.getDate());
				int ngay = ngayCld.get(Calendar.DATE);
				int thang = ngayCld.get(Calendar.MONTH)+1;
				int nam = ngayCld.get(Calendar.YEAR);
				DSThongKeHDTheoNhanVienDAO dsThongKeHDTheoNhanVien = new DSThongKeHDTheoNhanVienDAO();
				dsThongKeHDTheoNhanVien.thongKeNhanVienLapHoaDon_TheoNgay_TheoMaTatCa(ngay, thang, nam, Integer.parseInt(cmbMaNV.getSelectedItem().toString()));
				
			}
			
			else if (chonMaNhanVien.equalsIgnoreCase("Tất cả")) {
				xoaBangg();
				txtTenNV.setText("");
				DSThongKeHDTheoNhanVienDAO dsThongKeHDTheoNhanVien = new DSThongKeHDTheoNhanVienDAO();
				Calendar ngayCld = Calendar.getInstance();
				
				ngayCld.setTime(txtChonNgay.getDate());
				int ngay = ngayCld.get(Calendar.DATE);
				int thang = ngayCld.get(Calendar.MONTH)+1;
				int nam = ngayCld.get(Calendar.YEAR);		
				dsThongKeHDTheoNhanVien.thongKeNhanVienLapHoaDonTheoNgay(ngay, thang, nam);
			} else {
				chonTenNhanVien(chonMaNhanVien);
			}
		}
	}

	// Hiện dữ liệu lên Text
	public void hienDuLieuTrenText(Double tongtien, int tonghoadon, int tongthuoc) {
		DecimalFormat tien = new DecimalFormat("#,##0.00 VND");
		String tongHoaDon = String.valueOf(tonghoadon);
		String tongsoluongthuoc = String.valueOf(tongthuoc);
		String tongtienban = tien.format(tongtien);
	
		txtTongSoHD.setText(tongHoaDon);
		txtTongSLTDB.setText(tongsoluongthuoc);
		txtTongTienDaBan.setText(tongtienban+"");
		
	}

	
	// Lấy mã nhân viên
	private void chonMaNhanVien() {
		DSThongKeHDTheoNhanVienDAO ql = new DSThongKeHDTheoNhanVienDAO();
		ArrayList<ThongKeHDTheoNhanVien> list = ql.chonMaNhanVien();
		for (ThongKeHDTheoNhanVien t : list) {
			cmbMaNV.addItem(t.getMaNhanVien());
		}
	}

	// Hàm lấy tên nhân viên
	private void chonTenNhanVien(String ngay) {
		DSThongKeHDTheoNhanVienDAO ql = new DSThongKeHDTheoNhanVienDAO();
		ArrayList<ThongKeHDTheoNhanVien> list = ql.chonTenNhanVien(ngay);
		for (ThongKeHDTheoNhanVien t : list) {
			txtTenNV.setText(t.getTenNhanVien());
		}
	}


	

	
	

	// Xoa Bang Thong Ke hoa don theo nhan vien
	private void xoaBang() {
		while (table2.getRowCount() != 0) {
			tablemodel1.removeRow(0);
		}
	}

	//// Xóa bảng TKTTThuoc
	private void xoaBangg() {
		while (table_1.getRowCount() != 0) {
			tablemodel.removeRow(0);
		}
	}

	// Xoa Bang TKTQ
	private void xoaBanggTKTQ() {
		tablemodel2.addRow(new Object[] {

		});
		tablemodel2 = (DefaultTableModel) tblThongKeTongQuat.getModel();
		tablemodel2.getDataVector().removeAllElements();
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		int row = table_1.getSelectedRow();

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	public JButton createButton(Icon inconlink, String text, String command, String toolTip) {
		JButton btn = new JButton();
		btn.setToolTipText(toolTip);
		btn.setIcon(inconlink);
		btn.setActionCommand(command);
		return btn;

	}

	public void hienDuLieuTrenText(Double tongmua, Double tongban, Double loinhuan) {

		DecimalFormat tien = new DecimalFormat("#,##0.00 VND");
		String tongtienmua = tien.format(tongmua);
		String tongtienban = tien.format(tongban);
		String tongLoiNhuan = tien.format(loinhuan);
		txtTongTienThuocDaNhap.setText(tongtienmua);
		txtTongTienBanDuocTKTq.setText(tongtienban);
		txtLoiNhuanThuDkTQ.setText(tongLoiNhuan);
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
	
}
