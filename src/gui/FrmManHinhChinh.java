/*
 * Người làm : Nguyễn Văn Việt Toàn 
 * Chức năng : đăng nhập hệ thống cho chương trình
 * 
 * */
package gui;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import java.awt.Toolkit;
import javax.swing.event.MenuListener;
import javax.swing.event.MenuEvent;

public class FrmManHinhChinh extends JFrame implements ActionListener,MenuListener {

	private JPanel contentPane;
	private FrmLapHoaDon frmLapHoaDon;
	private FrmQuanLyHoaDon frmQuanLyHoaDon = new FrmQuanLyHoaDon();
	private FrmBaoCaoThongKe frmBaoCaoThongKe = new FrmBaoCaoThongKe();
	private FrmQuanLyNhanVien frmQuanLyNhanVien = new FrmQuanLyNhanVien();
	private FrmKhachHang frmKhachHang = new FrmKhachHang();
	private FrmXemThongTinCaNhan frmXemThongTinCaNhan = new FrmXemThongTinCaNhan();
	private JMenuItem mntmThemHoaDonMoi;
	private JMenuItem mntmHuyHoaDon;
	public static JTabbedPane tabbedPane;
	private JMenuBar menuBar;
	private JMenu mnExit;
	private JMenu mnXemHoaDon;
	public static JMenuItem mntmQuanLyThuoc;
	private JMenuItem mntmThongKeHoaDon;
	private JMenuItem mntmThongKeTinhTrangThuoc;
	private JMenuItem mntmThongKeDoanhThu;
	private JMenuItem mntmThongTinKhachHang;
	private JMenuItem mntmDangXuat;
	public static JMenu mnNhanVien ;
	public static JMenu mnThongKe;
	public static JMenuBar menuBar_LapHoaDon;
	public static JMenu mnLapHoaDon;
	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public FrmManHinhChinh() {
		setTitle("Quầy Thuốc");
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setSize(1361, 720);
		setLocationRelativeTo(null);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		menuBar = new JMenuBar();
		menuBar.setBackground(Color.WHITE);
		setJMenuBar(menuBar);
		
		
		
		mnExit = new JMenu("Thoát");
		mnExit.addMenuListener(new MenuListener() {
			public void menuCanceled(MenuEvent e) {
			}
			public void menuDeselected(MenuEvent e) {
			}
			public void menuSelected(MenuEvent e) {
				Object chon = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn thoát?");
				if(chon.equals(0)) {
					System.exit(0);
				}
			}
		});
		
		menuBar.add(mnExit);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setBackground(Color.WHITE);
		toolBar.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		toolBar.setFloatable(false);
		toolBar.setEnabled(false);
		contentPane.add(toolBar, BorderLayout.NORTH);
		
		menuBar_LapHoaDon = new JMenuBar();
		toolBar.add(menuBar_LapHoaDon);
		
		mnLapHoaDon = new JMenu("Tạo Hóa Đơn              ");
		mnLapHoaDon.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		mnLapHoaDon.setMnemonic(KeyEvent.VK_ENTER);
		menuBar_LapHoaDon.add(mnLapHoaDon);
		
		mntmThemHoaDonMoi = new JMenuItem("Lập hóa đơn mới");
		mntmThemHoaDonMoi.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		
		
		
		mnLapHoaDon.add(mntmThemHoaDonMoi);
		
		mntmHuyHoaDon = new JMenuItem("Thoát");
		mntmHuyHoaDon.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		
		mnLapHoaDon.add(mntmHuyHoaDon);
		
		
		JMenuBar menuBar_2 = new JMenuBar();
		toolBar.add(menuBar_2);
		
		mnXemHoaDon = new JMenu("Xem Hóa Đơn              ");
		mnXemHoaDon.addMenuListener(new MenuListener() {
			public void menuCanceled(MenuEvent e) {
			}
			public void menuDeselected(MenuEvent e) {
			}
			public void menuSelected(MenuEvent e) {
				tabbedPane.remove(tabbedPane.getSelectedComponent());
				tabbedPane.add(frmQuanLyHoaDon.contentPane);
				tabbedPane.setSelectedComponent(frmQuanLyHoaDon.contentPane);
			}
		});
		mnXemHoaDon.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		mnXemHoaDon.setMnemonic(KeyEvent.VK_F2);
		menuBar_2.add(mnXemHoaDon);
		
		JMenuBar menuThuoc = new JMenuBar();
		menuThuoc.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		toolBar.add(menuThuoc);
		
		JMenu mnThuoc = new JMenu("Danh mục thuốc              ");
		mnThuoc.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		menuThuoc.add(mnThuoc);
		mntmQuanLyThuoc = new JMenuItem("Quản lý danh sách thuốc");
		
		mntmQuanLyThuoc.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		
		mnThuoc.add(mntmQuanLyThuoc);
		
		JMenuBar menuThongKe = new JMenuBar();
		toolBar.add(menuThongKe);
		
		mnThongKe = new JMenu("Thống Kê              ");
		
		mnThongKe.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		menuThongKe.add(mnThongKe);
		
		mntmThongKeHoaDon = new JMenuItem("Thống kê hóa đơn theo nhân viên");
		mntmThongKeHoaDon.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		mnThongKe.add(mntmThongKeHoaDon);
		
		mntmThongKeTinhTrangThuoc = new JMenuItem("Thống kê tình trạng thuốc");

		mntmThongKeTinhTrangThuoc.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		
		
		mnThongKe.add(mntmThongKeTinhTrangThuoc);
		
		mntmThongKeDoanhThu = new JMenuItem("Thống kê doanh thu");
	
		mntmThongKeDoanhThu.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		
		
		mnThongKe.add(mntmThongKeDoanhThu);
		
		JMenuBar menuKhachHang = new JMenuBar();
		toolBar.add(menuKhachHang);
		
		JMenuBar menuNhanVien = new JMenuBar();
		menuKhachHang.add(menuNhanVien);
		
		mnNhanVien = new JMenu("Nhân Viên              ");
		mnNhanVien.addMenuListener(new MenuListener() {
			public void menuCanceled(MenuEvent e) {
			}
			public void menuDeselected(MenuEvent e) {
			}
			public void menuSelected(MenuEvent e) {
				tabbedPane.remove(tabbedPane.getSelectedComponent());
				tabbedPane.add(frmQuanLyNhanVien.pnlTabQLNV);
			}
		});
		
		mnNhanVien.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		menuNhanVien.add(mnNhanVien);
		
		JMenu mnKhachHang = new JMenu("Khách Hàng              ");
		
		mnKhachHang.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		mnKhachHang.setEnabled(true);
		menuKhachHang.add(mnKhachHang);
		
		mntmThongTinKhachHang = new JMenuItem("Thông tin khách hàng");
		
		
		
		
		
		mntmThongTinKhachHang.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		mnKhachHang.add(mntmThongTinKhachHang);
		
		JMenuBar menuThongTinCaNhan = new JMenuBar();
		toolBar.add(menuThongTinCaNhan);
		
		JMenu mnThongTinCaNhan = new JMenu("Thông Tin Cá Nhân              ");
		mnThongTinCaNhan.addMenuListener(new MenuListener() {
			public void menuCanceled(MenuEvent e) {
			}
			public void menuDeselected(MenuEvent e) {
			}
			public void menuSelected(MenuEvent e) {
				tabbedPane.remove(tabbedPane.getSelectedComponent());
				tabbedPane.add(frmXemThongTinCaNhan.pnlTabXemThongTinCaNhan);
			}
		});
		
		mnThongTinCaNhan.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		menuThongTinCaNhan.add(mnThongTinCaNhan);
		JMenuBar menuDangNhap = new JMenuBar();
		toolBar.add(menuDangNhap);
		
		JMenu mnDangNhap_DangXuat = new JMenu("");
		mnDangNhap_DangXuat.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		menuDangNhap.add(mnDangNhap_DangXuat);
		
		mntmDangXuat = new JMenuItem("Thoát");
		
		mntmDangXuat.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		
		
		mnDangNhap_DangXuat.add(mntmDangXuat);
		
		tabbedPane = new JTabbedPane(JTabbedPane.RIGHT);
		tabbedPane.setBackground(Color.WHITE);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		mntmThemHoaDonMoi.addActionListener(this);
		mntmHuyHoaDon.addActionListener(this);
		mnXemHoaDon.addActionListener(this);
		mnXemHoaDon.addMenuListener(this);
		mntmQuanLyThuoc.addActionListener(this);
		mntmThongKeHoaDon.addActionListener(this);
		mntmThongKeTinhTrangThuoc.addActionListener(this);
		mntmThongKeDoanhThu.addActionListener(this);
		mntmThongTinKhachHang.addActionListener(this);
		mntmDangXuat.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		if(obj.equals(mntmThemHoaDonMoi)) {
			try {
				FrmLapHoaDon.cboTimKiemThuoc.removeAllItems();
				
			} catch (Exception e2) {
				// TODO: handle exception
				
			}
			tabbedPane.remove(tabbedPane.getSelectedComponent());
			frmLapHoaDon = new FrmLapHoaDon();
			tabbedPane.add(frmLapHoaDon.jp1);
			
		}
		else if(obj.equals(mntmHuyHoaDon)) {
			tabbedPane.remove(frmLapHoaDon.jp1);
		}
		else if(obj.equals(mntmQuanLyThuoc)) {
			
			tabbedPane.remove(tabbedPane.getSelectedComponent());
			FrmThuoc frmThuoc = new FrmThuoc();
			tabbedPane.add(frmThuoc.contentPane);
		}
		else if(obj.equals(mntmThongKeHoaDon)) {
			tabbedPane.remove(tabbedPane.getSelectedComponent());
			tabbedPane.add(frmBaoCaoThongKe.pnlToanPhan);
		}
		else if(obj.equals(mntmThongKeTinhTrangThuoc)) {
			tabbedPane.remove(tabbedPane.getSelectedComponent());
			tabbedPane.add(frmBaoCaoThongKe.pnlThongkeTTThuoc);
		}
		else if(obj.equals(mntmThongKeDoanhThu)) {
			tabbedPane.remove(tabbedPane.getSelectedComponent());
			tabbedPane.add(frmBaoCaoThongKe.pnlThongKeBaoCao);
		}
		else if(obj.equals(mntmThongTinKhachHang)) {
			tabbedPane.remove(tabbedPane.getSelectedComponent());
			tabbedPane.add(frmKhachHang.contentPane);
		}
		else if(obj.equals(mntmDangXuat)) {
			this.setVisible(false);
			FrmDangNhap.TrangThaiDangNhapNhanVien = false;
			FrmDangNhap.TrangThaiDangNhapQuanLy = false;
			FrmDangNhap frmDangNhap = new FrmDangNhap();
			frmDangNhap.setVisible(true);
			
			
		}
	}

	@Override
	public void menuSelected(MenuEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void menuDeselected(MenuEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void menuCanceled(MenuEvent e) {
		// TODO Auto-generated method stub
		
	}
}
