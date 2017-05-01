import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;
import javax.swing.plaf.basic.BasicTextFieldUI;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableRowSorter;
import javax.swing.text.JTextComponent;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

import java.util.Vector;
import java.util.List;
import java.util.Scanner;

import javax.swing.event.*;

public class GUI {
	//main frame ////////////////////////////////////
	private JFrame loginFrame;
	// panel
	private JPanel loginPanel;
	private JPanel userPanel;
	private JPanel passPanel;
	private JPanel loginButtonPanel;
	
	// Input
	private JLabel loginLabel;
	private JTextArea userTextArea;
	private JPasswordField  passwordField;
	private JButton loginButton;
	
	///////////////////////////////////////////////////
	
	private JFrame teacherFrame;

	
	// panel
	private JPanel classPanel;
	private JPanel infoPanel;
	private JPanel dayPanel;
	private JPanel hourPanel;
	private JPanel dayOfWeekAndRoomPanel;
	private JPanel searchStudentPanel;
	private JPanel addSubStudentPanel;
	// Item
	private JComboBox<String> classComboBox;
	private JButton viewClassButton;
	private JTextArea fromdayTextArea;
	private JTextArea todayTextArea;
	private JTextArea fromhourTextArea;
	private JTextArea tohourTextArea;
	private JTextArea dayOfWeekTextArea;
	private JTextArea roomTextArea;
	private JTextArea searchStudentTextArea;
	private JButton searchStudentButton;
	private JButton addButton;
	private JButton subButton;
	private String maLopHocCombobox;
	private JComboBox<String> choiceAddStudentJoinClass;
	// table
	private tableListStudentOfClass tableStudentInClass;
	
	private DefaultTableModel tableModelExits;
	private DefaultTableModel tableModelNotExist;
	int count;
///////////////////////////////////////////////////
	private JFrame addStudentTableFrame;
	private tableListStudentNotInClass tableStudentNotInClass;
	
	
///////////////////////////////////////////////////
	
	private JFrame studentFrame;
	
	private tableAttendanceStudentOfClass tableAttendance;
	private DefaultTableModel modelAttendance;
	private Date ngaybatdau;
	private int magiaovien;
	private TableRowSorter<AbstractTableModel> sorter;
	private JPanel attendancePanel;
	public GUI()
	{
		
		loginView();
		
	}
	
	public void loginView()
	{
		loginFrame = new JFrame("Quan Ly Hoc Sinh");
		loginFrame.setLocation(500, 200);
		loginFrame.setSize(350, 330);
		loginFrame.setLayout(new BoxLayout(loginFrame.getContentPane(), BoxLayout.Y_AXIS));
		ImageIcon imgMain = new ImageIcon("Images\\Notes.png");
		loginFrame.setIconImage(imgMain.getImage());;
		//m_LoginPanel = new JPanel();
		//m_LoginPanel.setLayout(new BoxLayout(m_LoginPanel, BoxLayout.Y_AXIS)); // new BoxLayout(m_LoginPanel, BoxLayout.Y_AXIS)
		loginFrame.addWindowListener(new WindowAdapter() 
	      {
	         public void windowClosing(WindowEvent windowEvent)
	         {
				
	            System.exit(0);
	         }        
	      });
		
		
		loginPanel = new JPanel();
		loginPanel.setLayout(new FlowLayout());
		
		loginLabel = new JLabel("");
		ImageIcon img1 = new ImageIcon("Images\\hcmus.png");
		loginLabel.setIcon(img1);
		//loginLabel.setFont(new Font("Verdana", Font.BOLD, 17));
		
		loginPanel.add(loginLabel);
		
		
		
		JLabel tempLabel = new JLabel("");
		loginPanel.add(tempLabel);
		JPanel tempPanel = new JPanel();
		tempPanel.setLayout(new FlowLayout());
		tempPanel.add(tempLabel);
		
		
		
		Border border = BorderFactory.createLineBorder(Color.BLUE);
		
		
		
		userPanel = new JPanel();
		userPanel.setLayout(new FlowLayout());
		
		JLabel idLabel = new JLabel("  ID:         ");

		userTextArea = new JTextArea("", 2, 15);
		userTextArea.setBorder(border);
		userTextArea.setFont(new Font("Verdana", Font.BOLD, 12));
		userTextArea.setUI(new HintTextFieldUI("Nhập tài khoản hoặc MSSV", true));
		
		JLabel temp1 = new JLabel("                ");
		
		userPanel.add(idLabel);
		userPanel.add(userTextArea);
		userPanel.add(temp1);
		
		
		passPanel = new JPanel();
		passPanel.setLayout(new FlowLayout());
		
		JLabel passLabel = new JLabel("Password:");
		
		passwordField = new JPasswordField(15);
		passwordField.setPreferredSize(new Dimension(50, 35));
		passwordField.setBorder(border);
		passwordField.setFont(new Font("Verdana", Font.BOLD, 12));
		//passwordField.setUI(new HintTextFieldUI("Mật khẩu", true));
				
		JLabel temp2 = new JLabel("                    ");
		
		passPanel.add(passLabel);
		passPanel.add(passwordField);
		passPanel.add(temp2);
		
		
		
		loginButtonPanel = new JPanel();
		loginButtonPanel.setLayout(new FlowLayout());
		
		loginButton = new JButton("");
		loginButton.setPreferredSize(new Dimension(120, 32));
		ImageIcon img2 = new ImageIcon("Images\\loginbutton.png");
		loginButton.setIcon(img2);
		loginButtonPanel.add(loginButton);
		
		
		
		loginFrame.add(tempPanel);
		loginFrame.add(loginPanel);
		loginFrame.add(userPanel);
		loginFrame.add(passPanel);
		loginFrame.add(loginButtonPanel);
		
		//mainFrame.setVisible(true);
		//mainFrame.pack();

		
	}
	
	public void studentView(int id)
	{
		SinhVien sv;
		sv = SinhVienDAO.layThongTinSinhVien(id);
		

		// ẩn mainframe
		loginFrame.setVisible(false);
		Border border = BorderFactory.createLineBorder(Color.BLUE);
		
		
		studentFrame = new JFrame("Điểm danh");
		studentFrame.setLocation(120, 250);
		studentFrame.setSize(1200, 500);
		studentFrame.setLayout(new BoxLayout(studentFrame.getContentPane(), BoxLayout.Y_AXIS));
		ImageIcon imgMain = new ImageIcon("Images\\Notes.png");
		studentFrame.setIconImage(imgMain.getImage());;
		studentFrame.addWindowListener(new WindowAdapter() 
	      {
	         public void windowClosing(WindowEvent windowEvent)
	         {
	            System.exit(0);
	            
	         }        
	      });
		classPanel = new JPanel();
		classPanel.setLayout(new FlowLayout());
		
		JLabel choiceClass = new JLabel("Chọn lớp:         ");
		
		Iterator<LopHoc> lopHocs = sv.getLopHocs().iterator();
		ArrayList<String> classList = new ArrayList<String>();
		
		while(lopHocs.hasNext()) {
    		LopHoc lh = lopHocs.next();
    		classList.add(lh.getMaLopHoc());
    	}
		String[] array = classList.toArray(new String[classList.size()]);
		classComboBox = new JComboBox<String>(array);
		classComboBox.setPreferredSize(new Dimension(152, 26));
		
		viewClassButton = new JButton("Xem");
		viewClassButton.setPreferredSize(new Dimension(100,26));
		ImageIcon imgViewButton = new ImageIcon("Images\\Visible-26.png");
		viewClassButton.setIcon(imgViewButton);
		
		String MALOPHOC = (String) classComboBox.getSelectedItem();
		LopHoc lh = LopHocDAO.layThongTinLopHoc(MALOPHOC);
		ngaybatdau = lh.getNgayBatDau();
		
		JButton changePassword = new JButton("Đổi mật khẩu");
		changePassword.setPreferredSize(new Dimension(130,16));
		changePassword.setToolTipText("Đổi mật khẩu");
		ImageIcon changePasswordImg = new ImageIcon("Images\\Administrator Male-16.png");
		changePassword.setIcon(changePasswordImg);
		
		changePassword.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JPanel changepass = new JPanel ();
				changepass.setLayout(new GridLayout(6, 1));
				JPasswordField matkhaucu = new JPasswordField();
				JPasswordField matkhaumoi = new JPasswordField();
				JPasswordField nhaplaimatkhaumoi = new JPasswordField();
				
				changepass.add(new JLabel("Nhập mật khẩu cũ:"));
				changepass.add(matkhaucu);
				changepass.add(new JLabel("Nhập mật khẩu mới:"));
				changepass.add(matkhaumoi);
				changepass.add(new JLabel("Nhập lại mật khẩu mới:"));
				changepass.add(nhaplaimatkhaumoi);
				
				int flag = JOptionPane.showConfirmDialog(null, changepass, "Đổi mật khẩu", JOptionPane.OK_CANCEL_OPTION);
				if(flag == JOptionPane.OK_OPTION)
				{
					String matKhauCu = matkhaucu.getText();
					String matKhauMoi = matkhaumoi.getText();
					String matKhauMoiNhapLai = nhaplaimatkhaumoi.getText();
					
					if(matKhauCu.hashCode() == Integer.parseInt(sv.getMatKhau()))
					{
						if(matKhauMoi.equals(matKhauMoiNhapLai))
						{
							int k = matKhauMoi.hashCode();
							String newPassHash = String.valueOf(k);
							sv.setMatKhau(newPassHash);
							boolean kq = SinhVienDAO.capNhatThongTinSinhVien(sv);
							if(kq == true)
							{
								JOptionPane.showConfirmDialog(null,"Đổi mật khẩu thành công!",
    		        				 	"Warning",
    		        				    JOptionPane.OK_CANCEL_OPTION);
							}
							else
							{
								JOptionPane.showConfirmDialog(null,"Xảy ra lỗi khi đổi mật khẩu !",
    		        				 	"Warning",
    		        				    JOptionPane.OK_CANCEL_OPTION);
							}
						}
						else 
	    				{
	    					JOptionPane.showConfirmDialog(null,"Mật khẩu mới không trùng khớp!",
		        				 	"Warning",
		        				    JOptionPane.OK_CANCEL_OPTION);
	    				}
					}
					else 
    				{
    					JOptionPane.showConfirmDialog(null,"Nhập sai mật khẩu cũ!",
	        				 	"Warning",
	        				    JOptionPane.OK_CANCEL_OPTION);
    				}
				}
			}
		});
		JPanel name = new JPanel();
		name.setLayout(new GridLayout(2, 1));
		name.add(new JLabel("Hi, " + sv.getHoVaTen()));
		name.add(changePassword);
		
		classPanel.add(new JLabel("                                          "
				+ "                                          "
				+ "                         "));
		
		classPanel.add(choiceClass);
		classPanel.add(classComboBox);
		classPanel.add(viewClassButton);
		classPanel.add(new JLabel("                                            "
				+ "                                                       "));
		classPanel.add(name);
		studentFrame.add(classPanel);
		
		///////////////////////////
		infoPanel = new JPanel();
		infoPanel.setLayout(new FlowLayout());
		///////////////////////////
		
		
		dayPanel = new JPanel();
		dayPanel.setLayout(new GridLayout(2, 1));
		
		JLabel fromday = new JLabel("Từ ngày:  ");
		JLabel today = new JLabel("Đến ngày:");
		
		
		fromdayTextArea = new JTextArea("", 1, 10);
		fromdayTextArea.setBorder(border);
		fromdayTextArea.setFont(new Font("Verdana", Font.BOLD, 12));
		fromdayTextArea.setEditable(false);
		
		todayTextArea = new JTextArea("", 1, 10);
		todayTextArea.setBorder(border);
		todayTextArea.setFont(new Font("Verdana", Font.BOLD, 12));
		todayTextArea.setEditable(false);
		
		JPanel colum1 = new JPanel();
		colum1.add(fromday);
		colum1.add(fromdayTextArea);
		
		JPanel colum2 = new JPanel();
		colum2.add(today);
		colum2.add(todayTextArea);
		
		dayPanel.add(colum1);
		dayPanel.add(colum2);
		
		///////////////////////////
		hourPanel = new JPanel();
		hourPanel.setLayout(new GridLayout(2, 1));
		
		JLabel fromhour = new JLabel("  Giờ bắt đầu:     ");
		JLabel tohour = new JLabel("  Giờ kết thúc:    ");
		
		fromhourTextArea = new JTextArea("", 1, 10);
		fromhourTextArea.setBorder(border);
		fromhourTextArea.setFont(new Font("Verdana", Font.BOLD, 12));
		fromhourTextArea.setEditable(false);
		
		tohourTextArea = new JTextArea("", 1, 10);
		tohourTextArea.setBorder(border);
		tohourTextArea.setFont(new Font("Verdana", Font.BOLD, 12));
		tohourTextArea.setEditable(false);
		
		JPanel colum3 = new JPanel();
		colum3.add(fromhour);
		colum3.add(fromhourTextArea);
		
		JPanel colum4 = new JPanel();
		colum4.add(tohour);
		colum4.add(tohourTextArea);
		
		hourPanel.add(colum3);
		hourPanel.add(colum4);
		///////////////////////////
		
		dayOfWeekAndRoomPanel = new JPanel();
		dayOfWeekAndRoomPanel.setLayout(new GridLayout(2, 1));
		
		JLabel dayOfWeek = new JLabel("    Thứ:       ");
		JLabel room = new JLabel("    Phòng:   ");
		
		dayOfWeekTextArea = new JTextArea("", 1, 10);
		dayOfWeekTextArea.setBorder(border);
		dayOfWeekTextArea.setFont(new Font("Verdana", Font.BOLD, 12));
		dayOfWeekTextArea.setEditable(false);
		
		roomTextArea = new JTextArea("", 1, 10);
		roomTextArea.setBorder(border);
		roomTextArea.setFont(new Font("Verdana", Font.BOLD, 12));
		roomTextArea.setEditable(false);
		
		JPanel colum5 = new JPanel();
		colum5.add(dayOfWeek);
		colum5.add(dayOfWeekTextArea);
		
		JPanel colum6 = new JPanel();
		colum6.add(room);
		colum6.add(roomTextArea);
		
		dayOfWeekAndRoomPanel.add(colum5);
		dayOfWeekAndRoomPanel.add(colum6);
		
		
		infoPanel.add(dayPanel);
		infoPanel.add(hourPanel);
		infoPanel.add(dayOfWeekAndRoomPanel);
		
		studentFrame.add(infoPanel);
		///////////////////////////////////////////
		
		
		tableAttendance = new tableAttendanceStudentOfClass(studentFrame);
		JPanel atttenButtonPanel;
		atttenButtonPanel = new JPanel();
		atttenButtonPanel.setLayout(new FlowLayout());
		JButton attenButton;
		attenButton = new JButton("Điểm danh");
		attenButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("ngay bat dau: " + ngaybatdau);
				Calendar calBegin = Calendar.getInstance();
				calBegin.setTime(ngaybatdau);
				Calendar cal  = Calendar.getInstance();
				
				int subday =   cal.get(Calendar.DAY_OF_YEAR)  - calBegin.get(Calendar.DAY_OF_YEAR);
				System.out.println("hien tai : " + cal.get(Calendar.DAY_OF_YEAR));
				System.out.println("bat dau: " + calBegin.get(Calendar.DAY_OF_YEAR));
				int week = subday / 7;
				System.out.println("Tuan la: " + week);
				sinhvien_lophocID pk = new sinhvien_lophocID(id, MALOPHOC);
				sinhvien_lophoc svlh = sinhvien_lophocDAO.layThongTinSinhVienLopHoc(pk);
				if(week < 0)
				{
					JOptionPane.showConfirmDialog(null,"Lớp học đã kết thúc hoặc ngày tháng sai!!",
        				 	"Warning",
        				    JOptionPane.OK_CANCEL_OPTION);
					return;
				}
				if(week == 1)
				{
					tableAttendance.table.setValueAt(true, 0, 3);
					svlh.setTuan1(1);
					boolean ketqua = sinhvien_lophocDAO.capNhatThongTinSinhVienLopHoc(svlh);
					if(ketqua == true)
					{
						JOptionPane.showConfirmDialog(null,"Điểm danh thành công!!",
	        				 	"Điểm danh",
	        				    JOptionPane.OK_CANCEL_OPTION);
					}
					else
					{
						JOptionPane.showConfirmDialog(null,"Điểm danh thất bại!!",
	        				 	"Điểm danh",
	        				    JOptionPane.OK_CANCEL_OPTION);
					}
				}
				if(week == 2)
				{
					tableAttendance.table.setValueAt(true, 0, 4);
					svlh.setTuan2(1);
					boolean ketqua = sinhvien_lophocDAO.capNhatThongTinSinhVienLopHoc(svlh);
					if(ketqua == true)
					{
						JOptionPane.showConfirmDialog(null,"Điểm danh thành công!!",
	        				 	"Điểm danh",
	        				    JOptionPane.OK_CANCEL_OPTION);
					}
					else
					{
						JOptionPane.showConfirmDialog(null,"Điểm danh thất bại!!",
	        				 	"Điểm danh",
	        				    JOptionPane.OK_CANCEL_OPTION);
					}
				}
				if(week == 3)
				{
					tableAttendance.table.setValueAt(true, 0, 5);
					svlh.setTuan3(1);
					boolean ketqua = sinhvien_lophocDAO.capNhatThongTinSinhVienLopHoc(svlh);
					if(ketqua == true)
					{
						JOptionPane.showConfirmDialog(null,"Điểm danh thành công!!",
	        				 	"Điểm danh",
	        				    JOptionPane.OK_CANCEL_OPTION);
					}
					else
					{
						JOptionPane.showConfirmDialog(null,"Điểm danh thất bại!!",
	        				 	"Điểm danh",
	        				    JOptionPane.OK_CANCEL_OPTION);
					}
				}
				if(week == 4)
				{
					tableAttendance.table.setValueAt(true, 0, 6);
					svlh.setTuan4(1);
					boolean ketqua = sinhvien_lophocDAO.capNhatThongTinSinhVienLopHoc(svlh);
					if(ketqua == true)
					{
						JOptionPane.showConfirmDialog(null,"Điểm danh thành công!!",
	        				 	"Điểm danh",
	        				    JOptionPane.OK_CANCEL_OPTION);
					}
					else
					{
						JOptionPane.showConfirmDialog(null,"Điểm danh thất bại!!",
	        				 	"Điểm danh",
	        				    JOptionPane.OK_CANCEL_OPTION);
					}
				}
				if(week == 5)
				{
					tableAttendance.table.setValueAt(true, 0, 7);
					svlh.setTuan5(1);
					boolean ketqua = sinhvien_lophocDAO.capNhatThongTinSinhVienLopHoc(svlh);
					if(ketqua == true)
					{
						JOptionPane.showConfirmDialog(null,"Điểm danh thành công!!",
	        				 	"Điểm danh",
	        				    JOptionPane.OK_CANCEL_OPTION);
					}
					else
					{
						JOptionPane.showConfirmDialog(null,"Điểm danh thất bại!!",
	        				 	"Điểm danh",
	        				    JOptionPane.OK_CANCEL_OPTION);
					}
				}
				if(week == 6)
				{
					tableAttendance.table.setValueAt(true, 0, 8);
					svlh.setTuan6(1);
					boolean ketqua = sinhvien_lophocDAO.capNhatThongTinSinhVienLopHoc(svlh);
					if(ketqua == true)
					{
						JOptionPane.showConfirmDialog(null,"Điểm danh thành công!!",
	        				 	"Điểm danh",
	        				    JOptionPane.OK_CANCEL_OPTION);
					}
					else
					{
						JOptionPane.showConfirmDialog(null,"Điểm danh thất bại!!",
	        				 	"Điểm danh",
	        				    JOptionPane.OK_CANCEL_OPTION);
					}
				}
				if(week == 7)
				{
					tableAttendance.table.setValueAt(true, 0, 9);
					svlh.setTuan7(1);
					boolean ketqua = sinhvien_lophocDAO.capNhatThongTinSinhVienLopHoc(svlh);
					if(ketqua == true)
					{
						JOptionPane.showConfirmDialog(null,"Điểm danh thành công!!",
	        				 	"Điểm danh",
	        				    JOptionPane.OK_CANCEL_OPTION);
					}
					else
					{
						JOptionPane.showConfirmDialog(null,"Điểm danh thất bại!!",
	        				 	"Điểm danh",
	        				    JOptionPane.OK_CANCEL_OPTION);
					}
				}
				if(week == 8)
				{
					tableAttendance.table.setValueAt(true, 0, 10);
					svlh.setTuan8(1);
					boolean ketqua = sinhvien_lophocDAO.capNhatThongTinSinhVienLopHoc(svlh);
					if(ketqua == true)
					{
						JOptionPane.showConfirmDialog(null,"Điểm danh thành công!!",
	        				 	"Điểm danh",
	        				    JOptionPane.OK_CANCEL_OPTION);
					}
					else
					{
						JOptionPane.showConfirmDialog(null,"Điểm danh thất bại!!",
	        				 	"Điểm danh",
	        				    JOptionPane.OK_CANCEL_OPTION);
					}
				}
				if(week == 9)
				{
					tableAttendance.table.setValueAt(true, 0, 11);
					svlh.setTuan9(1);
					boolean ketqua = sinhvien_lophocDAO.capNhatThongTinSinhVienLopHoc(svlh);
					if(ketqua == true)
					{
						JOptionPane.showConfirmDialog(null,"Điểm danh thành công!!",
	        				 	"Điểm danh",
	        				    JOptionPane.OK_CANCEL_OPTION);
					}
					else
					{
						JOptionPane.showConfirmDialog(null,"Điểm danh thất bại!!",
	        				 	"Điểm danh",
	        				    JOptionPane.OK_CANCEL_OPTION);
					}
				}
				if(week == 10)
				{
					tableAttendance.table.setValueAt(true, 0, 12);
					svlh.setTuan10(1);
					boolean ketqua = sinhvien_lophocDAO.capNhatThongTinSinhVienLopHoc(svlh);
					if(ketqua == true)
					{
						JOptionPane.showConfirmDialog(null,"Điểm danh thành công!!",
	        				 	"Điểm danh",
	        				    JOptionPane.OK_CANCEL_OPTION);
					}
					else
					{
						JOptionPane.showConfirmDialog(null,"Điểm danh thất bại!!",
	        				 	"Điểm danh",
	        				    JOptionPane.OK_CANCEL_OPTION);
					}
				}
				if(week == 11)
				{
					tableAttendance.table.setValueAt(true, 0, 13);
					svlh.setTuan11(1);
					boolean ketqua = sinhvien_lophocDAO.capNhatThongTinSinhVienLopHoc(svlh);
					if(ketqua == true)
					{
						JOptionPane.showConfirmDialog(null,"Điểm danh thành công!!",
	        				 	"Điểm danh",
	        				    JOptionPane.OK_CANCEL_OPTION);
					}
					else
					{
						JOptionPane.showConfirmDialog(null,"Điểm danh thất bại!!",
	        				 	"Điểm danh",
	        				    JOptionPane.OK_CANCEL_OPTION);
					}
				}
				if(week == 12)
				{
					tableAttendance.table.setValueAt(true, 0, 14);
					svlh.setTuan12(1);
					boolean ketqua = sinhvien_lophocDAO.capNhatThongTinSinhVienLopHoc(svlh);
					if(ketqua == true)
					{
						JOptionPane.showConfirmDialog(null,"Điểm danh thành công!!",
	        				 	"Điểm danh",
	        				    JOptionPane.OK_CANCEL_OPTION);
					}
					else
					{
						JOptionPane.showConfirmDialog(null,"Điểm danh thất bại!!",
	        				 	"Điểm danh",
	        				    JOptionPane.OK_CANCEL_OPTION);
					}
				}
				if(week == 13)
				{
					tableAttendance.table.setValueAt(true, 0, 15);
					svlh.setTuan13(1);
					boolean ketqua = sinhvien_lophocDAO.capNhatThongTinSinhVienLopHoc(svlh);
					if(ketqua == true)
					{
						JOptionPane.showConfirmDialog(null,"Điểm danh thành công!!",
	        				 	"Điểm danh",
	        				    JOptionPane.OK_CANCEL_OPTION);
					}
					else
					{
						JOptionPane.showConfirmDialog(null,"Điểm danh thất bại!!",
	        				 	"Điểm danh",
	        				    JOptionPane.OK_CANCEL_OPTION);
					}
				}
				if(week == 14)
				{
					tableAttendance.table.setValueAt(true, 0, 16);
					svlh.setTuan14(1);
					boolean ketqua = sinhvien_lophocDAO.capNhatThongTinSinhVienLopHoc(svlh);
					if(ketqua == true)
					{
						JOptionPane.showConfirmDialog(null,"Điểm danh thành công!!",
	        				 	"Điểm danh",
	        				    JOptionPane.OK_CANCEL_OPTION);
					}
					else
					{
						JOptionPane.showConfirmDialog(null,"Điểm danh thất bại!!",
	        				 	"Điểm danh",
	        				    JOptionPane.OK_CANCEL_OPTION);
					}
				}
				if(week == 15)
				{
					tableAttendance.table.setValueAt(true, 0, 17);
					svlh.setTuan15(1);
					boolean ketqua = sinhvien_lophocDAO.capNhatThongTinSinhVienLopHoc(svlh);
					if(ketqua == true)
					{
						JOptionPane.showConfirmDialog(null,"Điểm danh thành công!!",
	        				 	"Điểm danh",
	        				    JOptionPane.OK_CANCEL_OPTION);
					}
					else
					{
						JOptionPane.showConfirmDialog(null,"Điểm danh thất bại!!",
	        				 	"Điểm danh",
	        				    JOptionPane.OK_CANCEL_OPTION);
					}
				}
				
			}
		});
		
		JButton exitButton;
		exitButton = new JButton("Thoát");
		
		exitButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
		
		atttenButtonPanel.add(attenButton);
		atttenButtonPanel.add(exitButton);
		
		viewClassButton.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	        	 maLopHocCombobox = (String) classComboBox.getSelectedItem();
	        	 System.out.println(maLopHocCombobox);
	        	 //int idLopHoc = Integer.parseInt(maLopHocCombobox);
	        	 count = 1;
	        	 LopHoc lh = LopHocDAO.layThongTinLopHoc(maLopHocCombobox);
	        	 modelAttendance.setRowCount(0);
	        	 ngaybatdau = lh.getNgayBatDau();
	        	// update ngay gio thu phong
          		fromdayTextArea.setText(lh.getNgayBatDau().toString());
          		todayTextArea.setText(lh.getNgayKetThuc().toString());
          		fromhourTextArea.setText(lh.getGioBatDau().toString());
          		tohourTextArea.setText(lh.getGioKetThuc().toString());
          		roomTextArea.setText(lh.getPhongHoc());
          		dayOfWeekTextArea.setText(lh.getThu());
          		
          		
	             		sinhvien_lophocID pk = new sinhvien_lophocID(sv.getMaSinhVien(), maLopHocCombobox);
	             		sinhvien_lophoc svlh = sinhvien_lophocDAO.layThongTinSinhVienLopHoc(pk);
	             		if(svlh != null)
	             		{
	             			boolean[] array = new boolean[15];
	             			int i = 0;
	             			if(svlh.getTuan1() == 1)
	             			{
	             				array[i++] = true;
	             			}
	             			else
	             			{
	             				array[i++] = false;
	             			}
	             			if(svlh.getTuan2() == 1)
	             			{
	             				array[i++] = true;
	             			}
	             			else
	             			{
	             				array[i++] = false;
	             			}
	             			if(svlh.getTuan3() == 1)
	             			{
	             				array[i++] = true;
	             			}
	             			else
	             			{
	             				array[i++] = false;
	             			}
	             			if(svlh.getTuan4() == 1)
	             			{
	             				array[i++] = true;
	             			}
	             			else
	             			{
	             				array[i++] = false;
	             			}
	             			if(svlh.getTuan5() == 1)
	             			{
	             				array[i++] = true;
	             			}
	             			else
	             			{
	             				array[i++] = false;
	             			}
	             			if(svlh.getTuan6() == 1)
	             			{
	             				array[i++] = true;
	             			}
	             			else
	             			{
	             				array[i++] = false;
	             			}
	             			if(svlh.getTuan7() == 1)
	             			{
	             				array[i++] = true;
	             			}
	             			else
	             			{
	             				array[i++] = false;
	             			}
	             			if(svlh.getTuan8() == 1)
	             			{
	             				array[i++] = true;
	             			}
	             			else
	             			{
	             				array[i++] = false;
	             			}
	             			if(svlh.getTuan9() == 1)
	             			{
	             				array[i++] = true;
	             			}
	             			else
	             			{
	             				array[i++] = false;
	             			}
	             			if(svlh.getTuan10() == 1)
	             			{
	             				array[i++] = true;
	             			}
	             			else
	             			{
	             				array[i++] = false;
	             			}
	             			if(svlh.getTuan11() == 1)
	             			{
	             				array[i++] = true;
	             			}
	             			else
	             			{
	             				array[i++] = false;
	             			}
	             			if(svlh.getTuan12() == 1)
	             			{
	             				array[i++] = true;
	             			}
	             			else
	             			{
	             				array[i++] = false;
	             			}
	             			if(svlh.getTuan13() == 1)
	             			{
	             				array[i++] = true;
	             			}
	             			else
	             			{
	             				array[i++] = false;
	             			}
	             			if(svlh.getTuan14() == 1)
	             			{
	             				array[i++] = true;
	             			}
	             			else
	             			{
	             				array[i++] = false;
	             			}
	             			if(svlh.getTuan15() == 1)
	             			{
	             				array[i++] = true;
	             			}
	             			else
	             			{
	             				array[i++] = false;
	             			}
	             			
	             			Object[] data = {count, sv.getMaSinhVien(), sv.getHoVaTen(), 
	             					array[0], array[1], array[2], array[3], array[4], 
	             					array[5], array[6], array[7], array[8], array[9], 
	             					array[10], array[11], array[12], array[13], array[14]};	
	             			count++;
	             			modelAttendance.addRow(data);
	             		}
	             		tableAttendance.table.setModel(modelAttendance);
	             		modelAttendance.fireTableDataChanged();

	         }
	      }); 
		
		studentFrame.add(atttenButtonPanel);
		studentFrame.pack();
		studentFrame.setVisible(true);
	}
	
	public void teacherView(int id)
	{
		// lấy thông tin giáo viên
		GiaoVien gv;
		gv = GiaoVienDAO.layThongTinGiaoVien(id);
		
		magiaovien = id;
		// ẩn mainframe
		loginFrame.setVisible(false);
		Border border = BorderFactory.createLineBorder(Color.BLUE);
		
		
		teacherFrame = new JFrame("Quan Ly Hoc Sinh");
		teacherFrame.setLocation(100, 100);
		teacherFrame.setSize(1200, 500);
		teacherFrame.setLayout(new BoxLayout(teacherFrame.getContentPane(), BoxLayout.Y_AXIS));
		ImageIcon imgMain = new ImageIcon("Images\\Notes.png");
		teacherFrame.setIconImage(imgMain.getImage());;
		teacherFrame.addWindowListener(new WindowAdapter() 
	      {
	         public void windowClosing(WindowEvent windowEvent)
	         {
	            System.exit(0);
	            
	         }        
	      });
		
		//create
		
		classPanel = new JPanel();
		classPanel.setLayout(new FlowLayout());
		
		JLabel choiceClass = new JLabel("Chọn lớp:         ");
		
		Iterator<LopHoc> lopHocs = gv.getLopHocs().iterator();
		ArrayList<String> classList = new ArrayList<String>();
		
		while(lopHocs.hasNext()) {
    		LopHoc lh = lopHocs.next();
    		classList.add(lh.getMaLopHoc());
    	}
		String[] array = classList.toArray(new String[classList.size()]);
		
		classComboBox = new JComboBox<String>(array);
		classComboBox.setPreferredSize(new Dimension(152, 26));
		
		viewClassButton = new JButton("Xem");
		viewClassButton.setPreferredSize(new Dimension(100,26));
		ImageIcon imgViewButton = new ImageIcon("Images\\Visible-26.png");
		viewClassButton.setIcon(imgViewButton);
		
		
		JButton themLopButton = new JButton("");
		themLopButton.setPreferredSize(new Dimension(26,26));
		themLopButton.setToolTipText("Thêm lớp mới");
		ImageIcon themLopImg = new ImageIcon("Images\\Plus 2 Math-26.png");
		themLopButton.setIcon(themLopImg);
		
		JButton changePassword = new JButton("Đổi mật khẩu");
		changePassword.setPreferredSize(new Dimension(130,16));
		changePassword.setToolTipText("Đổi mật khẩu");
		ImageIcon changePasswordImg = new ImageIcon("Images\\Administrator Male-16.png");
		changePassword.setIcon(changePasswordImg);
		
		changePassword.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JPanel changepass = new JPanel ();
				changepass.setLayout(new GridLayout(6, 1));
				JPasswordField matkhaucu = new JPasswordField();
				JPasswordField matkhaumoi = new JPasswordField();
				JPasswordField nhaplaimatkhaumoi = new JPasswordField();
				
				changepass.add(new JLabel("Nhập mật khẩu cũ:"));
				changepass.add(matkhaucu);
				changepass.add(new JLabel("Nhập mật khẩu mới:"));
				changepass.add(matkhaumoi);
				changepass.add(new JLabel("Nhập lại mật khẩu mới:"));
				changepass.add(nhaplaimatkhaumoi);
				
				int flag = JOptionPane.showConfirmDialog(null, changepass, "Đổi mật khẩu", JOptionPane.OK_CANCEL_OPTION);
				if(flag == JOptionPane.OK_OPTION)
				{
					String matKhauCu = matkhaucu.getText();
					String matKhauMoi = matkhaumoi.getText();
					String matKhauMoiNhapLai = nhaplaimatkhaumoi.getText();
					
					if(matKhauCu.hashCode() == Integer.parseInt(gv.getMatKhau()))
					{
						if(matKhauMoi.equals(matKhauMoiNhapLai))
						{
							int k = matKhauMoi.hashCode();
							String newPassHash = String.valueOf(k);
							gv.setMatKhau(newPassHash);
							boolean kq = GiaoVienDAO.capNhatThongTinGiaoVien(gv);
							if(kq == true)
							{
								JOptionPane.showConfirmDialog(null,"Đổi mật khẩu thành công!",
    		        				 	"Warning",
    		        				    JOptionPane.OK_CANCEL_OPTION);
							}
							else
							{
								JOptionPane.showConfirmDialog(null,"Xảy ra lỗi khi đổi mật khẩu !",
    		        				 	"Warning",
    		        				    JOptionPane.OK_CANCEL_OPTION);
							}
						}
						else 
	    				{
	    					JOptionPane.showConfirmDialog(null,"Mật khẩu mới không trùng khớp!",
		        				 	"Warning",
		        				    JOptionPane.OK_CANCEL_OPTION);
	    				}
					}
					else 
    				{
    					JOptionPane.showConfirmDialog(null,"Nhập sai mật khẩu cũ!",
	        				 	"Warning",
	        				    JOptionPane.OK_CANCEL_OPTION);
    				}
				}
			}
		});
		
		JPanel name = new JPanel();
		name.setLayout(new GridLayout(2, 1));
		name.add(new JLabel("Hi, " + gv.getHoVaTen()));
		name.add(changePassword);
		
		classPanel.add(new JLabel("                                          "
				+ "                                          "
				+ "                         "));
		classPanel.add(choiceClass);
		classPanel.add(classComboBox);
		classPanel.add(viewClassButton);
		classPanel.add(themLopButton);
		classPanel.add(new JLabel("                                            "
				+ "                                         "));
		classPanel.add(name);
		///////////////////////////
		infoPanel = new JPanel();
		infoPanel.setLayout(new FlowLayout());
		///////////////////////////
		
		
		dayPanel = new JPanel();
		dayPanel.setLayout(new GridLayout(2, 1));
		
		JLabel fromday = new JLabel("Từ ngày:  ");
		JLabel today = new JLabel("Đến ngày:");
		
		
		fromdayTextArea = new JTextArea("", 1, 10);
		fromdayTextArea.setBorder(border);
		fromdayTextArea.setFont(new Font("Verdana", Font.BOLD, 12));
		fromdayTextArea.setEditable(false);
		
		todayTextArea = new JTextArea("", 1, 10);
		todayTextArea.setBorder(border);
		todayTextArea.setFont(new Font("Verdana", Font.BOLD, 12));
		todayTextArea.setEditable(false);
		
		JPanel colum1 = new JPanel();
		colum1.add(fromday);
		colum1.add(fromdayTextArea);
		
		JPanel colum2 = new JPanel();
		colum2.add(today);
		colum2.add(todayTextArea);
		
		dayPanel.add(colum1);
		dayPanel.add(colum2);
		
		///////////////////////////
		hourPanel = new JPanel();
		hourPanel.setLayout(new GridLayout(2, 1));
		
		JLabel fromhour = new JLabel("  Giờ bắt đầu:     ");
		JLabel tohour = new JLabel("  Giờ kết thúc:    ");
		
		fromhourTextArea = new JTextArea("", 1, 10);
		fromhourTextArea.setBorder(border);
		fromhourTextArea.setFont(new Font("Verdana", Font.BOLD, 12));
		fromhourTextArea.setEditable(false);
		
		tohourTextArea = new JTextArea("", 1, 10);
		tohourTextArea.setBorder(border);
		tohourTextArea.setFont(new Font("Verdana", Font.BOLD, 12));
		tohourTextArea.setEditable(false);
		
		JPanel colum3 = new JPanel();
		colum3.add(fromhour);
		colum3.add(fromhourTextArea);
		
		JPanel colum4 = new JPanel();
		colum4.add(tohour);
		colum4.add(tohourTextArea);
		
		hourPanel.add(colum3);
		hourPanel.add(colum4);
		///////////////////////////
		
		dayOfWeekAndRoomPanel = new JPanel();
		dayOfWeekAndRoomPanel.setLayout(new GridLayout(2, 1));
		
		JLabel dayOfWeek = new JLabel("    Thứ:       ");
		JLabel room = new JLabel("    Phòng:   ");
		
		dayOfWeekTextArea = new JTextArea("", 1, 10);
		dayOfWeekTextArea.setBorder(border);
		dayOfWeekTextArea.setFont(new Font("Verdana", Font.BOLD, 12));
		dayOfWeekTextArea.setEditable(false);
		
		roomTextArea = new JTextArea("", 1, 10);
		roomTextArea.setBorder(border);
		roomTextArea.setFont(new Font("Verdana", Font.BOLD, 12));
		roomTextArea.setEditable(false);
		
		JPanel colum5 = new JPanel();
		colum5.add(dayOfWeek);
		colum5.add(dayOfWeekTextArea);
		
		JPanel colum6 = new JPanel();
		colum6.add(room);
		colum6.add(roomTextArea);
		
		dayOfWeekAndRoomPanel.add(colum5);
		dayOfWeekAndRoomPanel.add(colum6);
		
		
		///////////////////////////
		JLabel temp1 = new JLabel("           ");
		JLabel temp2 = new JLabel("           ");
		///////////////////////////
		searchStudentPanel = new JPanel();
		searchStudentPanel.setLayout(new FlowLayout());
		
		
		searchStudentTextArea = new JTextArea("", 2, 15);
		searchStudentTextArea.setBorder(border);
		searchStudentTextArea.setFont(new Font("Verdana", Font.BOLD, 12));
		searchStudentTextArea.setUI(new HintTextFieldUI("Nhập MSSV để tìm kiếm", true));
		
		
		searchStudentButton = new JButton("Tìm");
		searchStudentButton.setPreferredSize(new Dimension(90,34));
		ImageIcon imgSearchButton = new ImageIcon("Images\\Search-26.png");
		searchStudentButton.setIcon(imgSearchButton);
		
		searchStudentPanel.add(searchStudentTextArea);
		searchStudentPanel.add(searchStudentButton);
		///////////////////////////
		addSubStudentPanel  = new JPanel();
		addSubStudentPanel.setLayout(new GridLayout(2, 1));
		
		
		JPanel addPanel = new JPanel();
		
		addButton = new JButton("Thêm sinh viên");
		addButton.setPreferredSize(new Dimension(150, 19));
		ImageIcon imgAddButton = new ImageIcon("Images\\Plus-16.png");
		addButton.setIcon(imgAddButton);
		addPanel.add(addButton);
		
		
		JPanel subPanel = new JPanel();
		
		subButton = new JButton("   Xóa sinh viên");
		subButton.setPreferredSize(new Dimension(150, 19));
		ImageIcon imgSubButton = new ImageIcon("Images\\Minus-16.png");
		subButton.setIcon(imgSubButton);
		subPanel.add(subButton);
		
		addSubStudentPanel.add(addPanel);
		addSubStudentPanel.add(subPanel);
		///////////////////////////
		infoPanel.add(dayPanel);
		infoPanel.add(hourPanel);
		infoPanel.add(dayOfWeekAndRoomPanel);
		infoPanel.add(temp1);
		infoPanel.add(addSubStudentPanel);
		infoPanel.add(temp2);
		infoPanel.add(searchStudentPanel);
		
/////////////////////////////////////////////////////////////////////////////////
		
		
		
		teacherFrame.add(classPanel);
		teacherFrame.add(infoPanel);
		//teacherFrame.add(scrollPane);
		
		tableStudentInClass = new tableListStudentOfClass(teacherFrame);
		sorter = new TableRowSorter<AbstractTableModel>((AbstractTableModel) tableModelExits);
		tableStudentInClass.table.setRowSorter(sorter);
		searchStudentTextArea.getDocument().addDocumentListener(
                new DocumentListener() {
                    public void changedUpdate(DocumentEvent e) {
                        newFilter();
                    }
                    public void insertUpdate(DocumentEvent e) {
                        newFilter();
                    }
                    public void removeUpdate(DocumentEvent e) {
                        newFilter();
                    }
                });
		
		viewClassButton.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	        	 maLopHocCombobox = (String) classComboBox.getSelectedItem();
	        	 System.out.println(maLopHocCombobox);
	        	 //int idLopHoc = Integer.parseInt(maLopHocCombobox);
	        	 count = 1;
	        	 LopHoc lh = LopHocDAO.layThongTinLopHoc(maLopHocCombobox);
	        	 tableModelExits.setRowCount(0);
	        	 
	        	 if(lh != null)
	        	 {
	        		 Iterator<SinhVien> svs = lh.getSinhViens().iterator();
	        		 
	        		 while(svs.hasNext()) {
	             		SinhVien sv = svs.next();
	             		System.out.println(sv.getMaSinhVien());
	             		sinhvien_lophocID pk = new sinhvien_lophocID(sv.getMaSinhVien(), maLopHocCombobox);
	             		sinhvien_lophoc svlh = sinhvien_lophocDAO.layThongTinSinhVienLopHoc(pk);
	             		if(svlh != null)
	             		{
	             			boolean[] array = new boolean[15];
	             			int i = 0;
	             			if(svlh.getTuan1() == 1)
	             			{
	             				array[i++] = true;
	             			}
	             			else
	             			{
	             				array[i++] = false;
	             			}
	             			if(svlh.getTuan2() == 1)
	             			{
	             				array[i++] = true;
	             			}
	             			else
	             			{
	             				array[i++] = false;
	             			}
	             			if(svlh.getTuan3() == 1)
	             			{
	             				array[i++] = true;
	             			}
	             			else
	             			{
	             				array[i++] = false;
	             			}
	             			if(svlh.getTuan4() == 1)
	             			{
	             				array[i++] = true;
	             			}
	             			else
	             			{
	             				array[i++] = false;
	             			}
	             			if(svlh.getTuan5() == 1)
	             			{
	             				array[i++] = true;
	             			}
	             			else
	             			{
	             				array[i++] = false;
	             			}
	             			if(svlh.getTuan6() == 1)
	             			{
	             				array[i++] = true;
	             			}
	             			else
	             			{
	             				array[i++] = false;
	             			}
	             			if(svlh.getTuan7() == 1)
	             			{
	             				array[i++] = true;
	             			}
	             			else
	             			{
	             				array[i++] = false;
	             			}
	             			if(svlh.getTuan8() == 1)
	             			{
	             				array[i++] = true;
	             			}
	             			else
	             			{
	             				array[i++] = false;
	             			}
	             			if(svlh.getTuan9() == 1)
	             			{
	             				array[i++] = true;
	             			}
	             			else
	             			{
	             				array[i++] = false;
	             			}
	             			if(svlh.getTuan10() == 1)
	             			{
	             				array[i++] = true;
	             			}
	             			else
	             			{
	             				array[i++] = false;
	             			}
	             			if(svlh.getTuan11() == 1)
	             			{
	             				array[i++] = true;
	             			}
	             			else
	             			{
	             				array[i++] = false;
	             			}
	             			if(svlh.getTuan12() == 1)
	             			{
	             				array[i++] = true;
	             			}
	             			else
	             			{
	             				array[i++] = false;
	             			}
	             			if(svlh.getTuan13() == 1)
	             			{
	             				array[i++] = true;
	             			}
	             			else
	             			{
	             				array[i++] = false;
	             			}
	             			if(svlh.getTuan14() == 1)
	             			{
	             				array[i++] = true;
	             			}
	             			else
	             			{
	             				array[i++] = false;
	             			}
	             			if(svlh.getTuan15() == 1)
	             			{
	             				array[i++] = true;
	             			}
	             			else
	             			{
	             				array[i++] = false;
	             			}
	             			
	             			Object[] data = {count, sv.getMaSinhVien(), sv.getHoVaTen(), 
	             					array[0], array[1], array[2], array[3], array[4], 
	             					array[5], array[6], array[7], array[8], array[9], 
	             					array[10], array[11], array[12], array[13], array[14]};	
	             			count++;
	             			tableModelExits.addRow(data);
	             		}
	             		tableStudentInClass.table.setModel(tableModelExits);
	             		tableModelExits.fireTableDataChanged();
	             		
	             		
	             		
	             		// update ngay gio thu phong
	             		fromdayTextArea.setText(lh.getNgayBatDau().toString());
	             		todayTextArea.setText(lh.getNgayKetThuc().toString());
	             		fromhourTextArea.setText(lh.getGioBatDau().toString());
	             		tohourTextArea.setText(lh.getGioKetThuc().toString());
	             		roomTextArea.setText(lh.getPhongHoc());
	             		dayOfWeekTextArea.setText(lh.getThu());
	             	}
	        	 }
	         }
	      }); 

		tableStudentInClass.table.getModel().addTableModelListener(new TableModelListener() {

		      public void tableChanged(TableModelEvent e) {
		         System.out.println(e);
		         if(tableStudentInClass.table.isEditing())
		         {
		        	 int numofrow = tableStudentInClass.table.getSelectedRow();
		        	 int numofcolumn = tableStudentInClass.table.getSelectedColumn();
		        	 boolean str = (boolean) tableStudentInClass.table.getValueAt(numofrow, numofcolumn);
			         System.out.println("Row: " + tableStudentInClass.table.getSelectedRow() + ", column " + tableStudentInClass.table.getSelectedColumn() + " : " + str);
			         if(numofcolumn == 3) {
			        	 int mssv = (int) tableStudentInClass.table.getValueAt(numofrow, 1);
			        	 sinhvien_lophocID pk = new sinhvien_lophocID(mssv, maLopHocCombobox);
			        	 sinhvien_lophoc svlh = sinhvien_lophocDAO.layThongTinSinhVienLopHoc(pk);
			        	 if(svlh != null) {
			        		 if(str == true)
			        			 svlh.setTuan1(1);
			        		 else
			        			 svlh.setTuan1(0);
			        		 boolean result = sinhvien_lophocDAO.capNhatThongTinSinhVienLopHoc(svlh);
				        	 if(result == true)
				        	 {
				        		 System.out.println("Update successful!");
				        	 }
				        	 else 
				        	 {
				        		 System.out.println("Update failed!");
				        	 }
			        	 }
			         }
			         if(numofcolumn == 4) {
			        	 int mssv = (int) tableStudentInClass.table.getValueAt(numofrow, 1);
			        	 sinhvien_lophocID pk = new sinhvien_lophocID(mssv, maLopHocCombobox);
			        	 sinhvien_lophoc svlh = sinhvien_lophocDAO.layThongTinSinhVienLopHoc(pk);
			        	 if(svlh != null) {
			        		 if(str == true)
			        			 svlh.setTuan2(1);
			        		 else
			        			 svlh.setTuan2(0);
			        		 boolean result = sinhvien_lophocDAO.capNhatThongTinSinhVienLopHoc(svlh);
				        	 if(result == true)
				        	 {
				        		 System.out.println("Update successful!");
				        	 }
				        	 else 
				        	 {
				        		 System.out.println("Update failed!");
				        	 }
			        	 }
			         }
			         if(numofcolumn == 5) {
			        	 int mssv = (int) tableStudentInClass.table.getValueAt(numofrow, 1);
			        	 sinhvien_lophocID pk = new sinhvien_lophocID(mssv, maLopHocCombobox);
			        	 sinhvien_lophoc svlh = sinhvien_lophocDAO.layThongTinSinhVienLopHoc(pk);
			        	 if(svlh != null) {
			        		 if(str == true)
			        			 svlh.setTuan3(1);
			        		 else
			        			 svlh.setTuan3(0);
			        		 boolean result = sinhvien_lophocDAO.capNhatThongTinSinhVienLopHoc(svlh);
				        	 if(result == true)
				        	 {
				        		 System.out.println("Update successful!");
				        	 }
				        	 else 
				        	 {
				        		 System.out.println("Update failed!");
				        	 }
			        	 }
			         }
			         if(numofcolumn == 6) {
			        	 int mssv = (int) tableStudentInClass.table.getValueAt(numofrow, 1);
			        	 sinhvien_lophocID pk = new sinhvien_lophocID(mssv, maLopHocCombobox);
			        	 sinhvien_lophoc svlh = sinhvien_lophocDAO.layThongTinSinhVienLopHoc(pk);
			        	 if(svlh != null) {
			        		 if(str == true)
			        			 svlh.setTuan4(1);
			        		 else
			        			 svlh.setTuan4(0);
			        		 boolean result = sinhvien_lophocDAO.capNhatThongTinSinhVienLopHoc(svlh);
				        	 if(result == true)
				        	 {
				        		 System.out.println("Update successful!");
				        	 }
				        	 else 
				        	 {
				        		 System.out.println("Update failed!");
				        	 }
			        	 }
			         }
			         if(numofcolumn == 7) {
			        	 int mssv = (int) tableStudentInClass.table.getValueAt(numofrow, 1);
			        	 sinhvien_lophocID pk = new sinhvien_lophocID(mssv, maLopHocCombobox);
			        	 sinhvien_lophoc svlh = sinhvien_lophocDAO.layThongTinSinhVienLopHoc(pk);
			        	 if(svlh != null) {
			        		 if(str == true)
			        			 svlh.setTuan5(1);
			        		 else
			        			 svlh.setTuan5(0);
			        		 boolean result = sinhvien_lophocDAO.capNhatThongTinSinhVienLopHoc(svlh);
				        	 if(result == true)
				        	 {
				        		 System.out.println("Update successful!");
				        	 }
				        	 else 
				        	 {
				        		 System.out.println("Update failed!");
				        	 }
			        	 }
			         }
			         if(numofcolumn == 8) {
			        	 int mssv = (int) tableStudentInClass.table.getValueAt(numofrow, 1);
			        	 sinhvien_lophocID pk = new sinhvien_lophocID(mssv, maLopHocCombobox);
			        	 sinhvien_lophoc svlh = sinhvien_lophocDAO.layThongTinSinhVienLopHoc(pk);
			        	 if(svlh != null) {
			        		 if(str == true)
			        			 svlh.setTuan6(1);
			        		 else
			        			 svlh.setTuan6(0);
			        		 boolean result = sinhvien_lophocDAO.capNhatThongTinSinhVienLopHoc(svlh);
				        	 if(result == true)
				        	 {
				        		 System.out.println("Update successful!");
				        	 }
				        	 else 
				        	 {
				        		 System.out.println("Update failed!");
				        	 }
			        	 }
			         }
			         if(numofcolumn == 9) {
			        	 int mssv = (int) tableStudentInClass.table.getValueAt(numofrow, 1);
			        	 sinhvien_lophocID pk = new sinhvien_lophocID(mssv, maLopHocCombobox);
			        	 sinhvien_lophoc svlh = sinhvien_lophocDAO.layThongTinSinhVienLopHoc(pk);
			        	 if(svlh != null) {
			        		 if(str == true)
			        			 svlh.setTuan7(1);
			        		 else
			        			 svlh.setTuan7(0);
			        		 boolean result = sinhvien_lophocDAO.capNhatThongTinSinhVienLopHoc(svlh);
				        	 if(result == true)
				        	 {
				        		 System.out.println("Update successful!");
				        	 }
				        	 else 
				        	 {
				        		 System.out.println("Update failed!");
				        	 }
			        	 }
			         }
			         if(numofcolumn == 10) {
			        	 int mssv = (int) tableStudentInClass.table.getValueAt(numofrow, 1);
			        	 sinhvien_lophocID pk = new sinhvien_lophocID(mssv, maLopHocCombobox);
			        	 sinhvien_lophoc svlh = sinhvien_lophocDAO.layThongTinSinhVienLopHoc(pk);
			        	 if(svlh != null) {
			        		 if(str == true)
			        			 svlh.setTuan8(1);
			        		 else
			        			 svlh.setTuan8(0);
			        		 boolean result = sinhvien_lophocDAO.capNhatThongTinSinhVienLopHoc(svlh);
				        	 if(result == true)
				        	 {
				        		 System.out.println("Update successful!");
				        	 }
				        	 else 
				        	 {
				        		 System.out.println("Update failed!");
				        	 }
			        	 }
			         }
			         if(numofcolumn == 11) {
			        	 int mssv = (int) tableStudentInClass.table.getValueAt(numofrow, 1);
			        	 sinhvien_lophocID pk = new sinhvien_lophocID(mssv, maLopHocCombobox);
			        	 sinhvien_lophoc svlh = sinhvien_lophocDAO.layThongTinSinhVienLopHoc(pk);
			        	 if(svlh != null) {
			        		 if(str == true)
			        			 svlh.setTuan9(1);
			        		 else
			        			 svlh.setTuan9(0);
			        		 boolean result = sinhvien_lophocDAO.capNhatThongTinSinhVienLopHoc(svlh);
				        	 if(result == true)
				        	 {
				        		 System.out.println("Update successful!");
				        	 }
				        	 else 
				        	 {
				        		 System.out.println("Update failed!");
				        	 }
			        	 }
			         }
			         if(numofcolumn == 12) {
			        	 int mssv = (int) tableStudentInClass.table.getValueAt(numofrow, 1);
			        	 sinhvien_lophocID pk = new sinhvien_lophocID(mssv, maLopHocCombobox);
			        	 sinhvien_lophoc svlh = sinhvien_lophocDAO.layThongTinSinhVienLopHoc(pk);
			        	 if(svlh != null) {
			        		 if(str == true)
			        			 svlh.setTuan10(1);
			        		 else
			        			 svlh.setTuan10(0);
			        		 boolean result = sinhvien_lophocDAO.capNhatThongTinSinhVienLopHoc(svlh);
				        	 if(result == true)
				        	 {
				        		 System.out.println("Update successful!");
				        	 }
				        	 else 
				        	 {
				        		 System.out.println("Update failed!");
				        	 }
			        	 }
			         }
			         if(numofcolumn == 13) {
			        	 int mssv = (int) tableStudentInClass.table.getValueAt(numofrow, 1);
			        	 sinhvien_lophocID pk = new sinhvien_lophocID(mssv, maLopHocCombobox);
			        	 sinhvien_lophoc svlh = sinhvien_lophocDAO.layThongTinSinhVienLopHoc(pk);
			        	 if(svlh != null) {
			        		 if(str == true)
			        			 svlh.setTuan11(1);
			        		 else
			        			 svlh.setTuan11(0);
			        		 boolean result = sinhvien_lophocDAO.capNhatThongTinSinhVienLopHoc(svlh);
				        	 if(result == true)
				        	 {
				        		 System.out.println("Update successful!");
				        	 }
				        	 else 
				        	 {
				        		 System.out.println("Update failed!");
				        	 }
			        	 }
			         }
			         if(numofcolumn == 14) {
			        	 int mssv = (int) tableStudentInClass.table.getValueAt(numofrow, 1);
			        	 sinhvien_lophocID pk = new sinhvien_lophocID(mssv, maLopHocCombobox);
			        	 sinhvien_lophoc svlh = sinhvien_lophocDAO.layThongTinSinhVienLopHoc(pk);
			        	 if(svlh != null) {
			        		 if(str == true)
			        			 svlh.setTuan12(1);
			        		 else
			        			 svlh.setTuan12(0);
			        		 boolean result = sinhvien_lophocDAO.capNhatThongTinSinhVienLopHoc(svlh);
				        	 if(result == true)
				        	 {
				        		 System.out.println("Update successful!");
				        	 }
				        	 else 
				        	 {
				        		 System.out.println("Update failed!");
				        	 }
			        	 }
			         }
			         if(numofcolumn == 15) {
			        	 int mssv = (int) tableStudentInClass.table.getValueAt(numofrow, 1);
			        	 sinhvien_lophocID pk = new sinhvien_lophocID(mssv, maLopHocCombobox);
			        	 sinhvien_lophoc svlh = sinhvien_lophocDAO.layThongTinSinhVienLopHoc(pk);
			        	 if(svlh != null) {
			        		 if(str == true)
			        			 svlh.setTuan13(1);
			        		 else
			        			 svlh.setTuan13(0);
			        		 boolean result = sinhvien_lophocDAO.capNhatThongTinSinhVienLopHoc(svlh);
				        	 if(result == true)
				        	 {
				        		 System.out.println("Update successful!");
				        	 }
				        	 else 
				        	 {
				        		 System.out.println("Update failed!");
				        	 }
			        	 }
			         }
			         if(numofcolumn == 16) {
			        	 int mssv = (int) tableStudentInClass.table.getValueAt(numofrow, 1);
			        	 sinhvien_lophocID pk = new sinhvien_lophocID(mssv, maLopHocCombobox);
			        	 sinhvien_lophoc svlh = sinhvien_lophocDAO.layThongTinSinhVienLopHoc(pk);
			        	 if(svlh != null) {
			        		 if(str == true)
			        			 svlh.setTuan14(1);
			        		 else
			        			 svlh.setTuan14(0);
			        		 boolean result = sinhvien_lophocDAO.capNhatThongTinSinhVienLopHoc(svlh);
				        	 if(result == true)
				        	 {
				        		 System.out.println("Update successful!");
				        	 }
				        	 else 
				        	 {
				        		 System.out.println("Update failed!");
				        	 }
			        	 }
			         }
			         if(numofcolumn == 17) {
			        	 int mssv = (int) tableStudentInClass.table.getValueAt(numofrow, 1);
			        	 sinhvien_lophocID pk = new sinhvien_lophocID(mssv, maLopHocCombobox);
			        	 sinhvien_lophoc svlh = sinhvien_lophocDAO.layThongTinSinhVienLopHoc(pk);
			        	 if(svlh != null) {
			        		 if(str == true)
			        			 svlh.setTuan15(1);
			        		 else
			        			 svlh.setTuan15(0);
			        		 boolean result = sinhvien_lophocDAO.capNhatThongTinSinhVienLopHoc(svlh);
				        	 if(result == true)
				        	 {
				        		 System.out.println("Update successful!");
				        	 }
				        	 else 
				        	 {
				        		 System.out.println("Update failed!");
				        	 }
			        	 }
			         }
		         }
		      }
		    });
		subButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int row = tableStudentInClass.table.getSelectedRow();
				int column = tableStudentInClass.table.getSelectedColumn();
				System.out.println("Dong " + row + "cot: " + column);
				if(row == -1 && column == -1)
				{
					Object[] options = {""};
	        		 JOptionPane.showOptionDialog(teacherFrame,"Vui lòng chọn sinh viên cần xóa!\n",
	        				 	"Warning",
	        				    JOptionPane.OK_CANCEL_OPTION,
	        				    JOptionPane.WARNING_MESSAGE,
	        				    null,
	        				    null,
	        				    options);
				}
				else {
					
					int mssv = (int) tableStudentInClass.table.getValueAt(row, 1);
	        		int n = JOptionPane.showConfirmDialog(teacherFrame,"Bạn có chắc muốn xóa sinh viên " + mssv +" ra khỏi lớp học?",
	        				 	"Warning",
	        				    JOptionPane.OK_CANCEL_OPTION);
	        		if(n == JOptionPane.OK_OPTION)
	        		{
	        			sinhvien_lophocID pk = new sinhvien_lophocID(mssv, maLopHocCombobox);
						boolean result = sinhvien_lophocDAO.xoaSinhVienLopHoc(pk);
						if(result == true)
						{
							System.out.println("Delete successful!");
							//int modelIndex = tableStudentInClass.table.convertRowIndexToModel(row);
							tableModelExits.removeRow(row);
							tableStudentInClass.table.addNotify();
						}
						else
						{
							
							System.out.println("Delete failed!");
						}
	        		}
					
				}
			}
		});
		
		themLopButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JTextField id = new JTextField();
				JTextField Name = new JTextField();
				JTextField Room = new JTextField();
				
				Vector<Integer> day = new Vector<>();
				Vector<Integer> month = new Vector<>();
				Vector<Integer> year = new Vector<>();
				Vector<Integer> hour = new Vector<>();
				Vector<Integer> minute = new Vector<>();
				
				Calendar cal = Calendar.getInstance();
				for (int i = 1; i <= 31; i++)
				{
					if (i <= 12)
					{
						month.addElement(i);
					}
					
					if (i <= 31)
					{
						day.addElement(i);
					}
					
					year.addElement(cal.get(Calendar.YEAR) + i - 1);
				}
				
				for (int i = 0; i < 60; i++)
				{
					if (i <= 23)
						hour.addElement(i);
					minute.addElement(i);
					
				}
				
				JComboBox<Integer> dayBegin = new JComboBox<>(day);
				JComboBox<Integer> monthBegin = new JComboBox<>(month);
				JComboBox<Integer> yearBegin = new JComboBox<>(year);

				JComboBox<Integer> dayEnd = new JComboBox<>(day);
				JComboBox<Integer> monthEnd = new JComboBox<>(month);
				JComboBox<Integer> yearEnd = new JComboBox<>(year);
				
				JComboBox<Integer> hourBegin = new JComboBox<>(hour);
				JComboBox<Integer> minuteBegin = new JComboBox<>(minute);
				JComboBox<Integer> hourEnd = new JComboBox<>(hour);
				JComboBox<Integer> minuteEnd = new JComboBox<>(minute);
				
			
				Vector<String> dayMonth = new Vector<String>();
				dayMonth.addElement("Monday");
				dayMonth.addElement("Tuesday");
				dayMonth.addElement("Wednesday");
				dayMonth.addElement("Thursday");
				dayMonth.addElement("Friday");
				dayMonth.addElement("Saturday");
				dayMonth.addElement("Sunday");
				
				JComboBox<String> dayinMonth = new JComboBox<String>(dayMonth);
				
				JPanel result = createClass(id, Name, Room, dayBegin, monthBegin, yearBegin, dayEnd, monthEnd, yearEnd, hourBegin, minuteBegin, hourEnd, minuteEnd, dayinMonth);
				int flag = JOptionPane.showConfirmDialog(null, result, "Tạo lớp mới", JOptionPane.OK_CANCEL_OPTION);
				if(flag == JOptionPane.OK_OPTION)
				{
					String malophoc = id.getText();
					String tenlophoc = Name.getText();
					String phonghoc = Room.getText();
					@SuppressWarnings("deprecation")
					Date ngaybatdau = new Date((Integer)yearBegin.getSelectedItem() - 1900, (Integer)(monthBegin.getSelectedItem()) ,(Integer)(dayBegin.getSelectedItem()) ) ;
					//Date ngaykethuc = new Date(Integer.parseInt(yearEnd.toString()),Integer.parseInt(monthEnd.toString()) ,Integer.parseInt(dayEnd.toString()) ) ;
					Time giobatdau = new Time((Integer)hourBegin.getSelectedItem() , (Integer)minuteBegin.getSelectedItem(), 0);
					Time gioketthuc = new Time((Integer)hourEnd.getSelectedItem() , (Integer)minuteEnd.getSelectedItem(), 0);
					String thu = dayinMonth.getSelectedItem().toString();
					
					LopHoc lh = new LopHoc();
					lh.setMaLopHoc(malophoc);
					lh.setTenLopHoc(tenlophoc);
					lh.setPhongHoc(phonghoc);
					lh.setNgayBatDau(ngaybatdau);
					
					
					Calendar calendar = Calendar.getInstance();
					calendar.setTime(ngaybatdau);
					
					calendar.add(Calendar.DAY_OF_YEAR, 105);
					Date ngayketthuc = calendar.getTime();

					
					lh.setNgayKetThuc(ngayketthuc);
					lh.setGioBatDau(giobatdau);
					lh.setGioKetThuc(gioketthuc);
					lh.setThu(thu);
					
					boolean kq = LopHocDAO.themLopHoc(lh);
					if(kq == true) {
						System.out.println("Add lop hoc thanh cong!");
						giaovien_lophocID pk = new giaovien_lophocID(magiaovien, malophoc);
						giaovien_lophoc gvlh = new giaovien_lophoc();
						gvlh.setPk(pk);
						
						boolean kqthemgiaovienvaolophoc = giaovien_lophocDAO.themGiaoVienVaoLopHoc(gvlh);
						if(kqthemgiaovienvaolophoc == true)
						{
								JOptionPane.showConfirmDialog(null,"Thêm thành công, sẽ cập nhật vào lần đăng nhập tới!!",
			        				 	"Thêm lớp học",
			        				    JOptionPane.OK_CANCEL_OPTION);
							System.out.println("Them giao vien vao lop hoc thanh cong!");
						}
					}
				}
			}
		});
		
		addButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JPanel panel = new JPanel();
		        
		        //Create and set up the content pane.
		        CardLayoutDemo demo = new CardLayoutDemo();
		        demo.addComponentToPane(panel);
				
				int flag = JOptionPane.showConfirmDialog(null, panel, "Thêm sinh viên", JOptionPane.OK_CANCEL_OPTION);
				if(flag == JOptionPane.OK_OPTION && choiceAddStudentJoinClass.getSelectedIndex() == 0)
				{
					System.out.println("them moi");
					JTextField ID = new JTextField();
					JTextField Name = new JTextField();
					JPanel result = addNewStudentJoinClass(ID, Name);
					int i = JOptionPane.showConfirmDialog(null, result, "Thêm sinh viên mới", JOptionPane.OK_CANCEL_OPTION);
					if(i == JOptionPane.OK_OPTION)
					{
						int id = Integer.parseInt(ID.getText());
						String name = Name.getText();
						String password = String.valueOf(id);
						SinhVien sv = new SinhVien();
						sv.setMaSinhVien(id);
						sv.setHoVaTen(name);
						sv.setMatKhau(password);
						
						boolean kq = SinhVienDAO.themSinhVien(sv);
						if(kq == true)
						{
							System.out.println("Them sv thanh cong");
							System.out.println(id);
							//sv.setMaSinhVien(1231231);
							sinhvien_lophocID pk = new sinhvien_lophocID(id, maLopHocCombobox);
							System.out.println("Ma lop hoc la: " + maLopHocCombobox);
							sinhvien_lophoc svlh = new sinhvien_lophoc();
							svlh.setPk(pk);
							svlh.setTuan1(0);
							svlh.setTuan2(0);
							svlh.setTuan3(0);
							svlh.setTuan4(0);
							svlh.setTuan5(0);
							svlh.setTuan6(0);
							svlh.setTuan7(0);
							svlh.setTuan8(0);
							svlh.setTuan9(0);
							svlh.setTuan10(0);
							svlh.setTuan11(0);
							svlh.setTuan12(0);
							svlh.setTuan13(0);
							svlh.setTuan14(0);
							svlh.setTuan15(0);
							
							boolean joinclass = sinhvien_lophocDAO.themSinhVienVaoLopHoc(svlh);
							
							if(joinclass == true)
							{ 			
								System.out.println("Them svlh dc");
								boolean[] array = new boolean[15];
		             			int k = 0;
		             			if(svlh.getTuan1() == 1)
		             			{
		             				array[k++] = true;
		             			}
		             			else
		             			{
		             				array[k++] = false;
		             			}
		             			if(svlh.getTuan2() == 1)
		             			{
		             				array[k++] = true;
		             			}
		             			else
		             			{
		             				array[k++] = false;
		             			}
		             			if(svlh.getTuan3() == 1)
		             			{
		             				array[k++] = true;
		             			}
		             			else
		             			{
		             				array[k++] = false;
		             			}
		             			if(svlh.getTuan4() == 1)
		             			{
		             				array[k++] = true;
		             			}
		             			else
		             			{
		             				array[k++] = false;
		             			}
		             			if(svlh.getTuan5() == 1)
		             			{
		             				array[k++] = true;
		             			}
		             			else
		             			{
		             				array[k++] = false;
		             			}
		             			if(svlh.getTuan6() == 1)
		             			{
		             				array[k++] = true;
		             			}
		             			else
		             			{
		             				array[k++] = false;
		             			}
		             			if(svlh.getTuan7() == 1)
		             			{
		             				array[k++] = true;
		             			}
		             			else
		             			{
		             				array[k++] = false;
		             			}
		             			if(svlh.getTuan8() == 1)
		             			{
		             				array[k++] = true;
		             			}
		             			else
		             			{
		             				array[k++] = false;
		             			}
		             			if(svlh.getTuan9() == 1)
		             			{
		             				array[k++] = true;
		             			}
		             			else
		             			{
		             				array[k++] = false;
		             			}
		             			if(svlh.getTuan10() == 1)
		             			{
		             				array[k++] = true;
		             			}
		             			else
		             			{
		             				array[k++] = false;
		             			}
		             			if(svlh.getTuan11() == 1)
		             			{
		             				array[k++] = true;
		             			}
		             			else
		             			{
		             				array[k++] = false;
		             			}
		             			if(svlh.getTuan12() == 1)
		             			{
		             				array[k++] = true;
		             			}
		             			else
		             			{
		             				array[k++] = false;
		             			}
		             			if(svlh.getTuan13() == 1)
		             			{
		             				array[k++] = true;
		             			}
		             			else
		             			{
		             				array[k++] = false;
		             			}
		             			if(svlh.getTuan14() == 1)
		             			{
		             				array[k++] = true;
		             			}
		             			else
		             			{
		             				array[k++] = false;
		             			}
		             			if(svlh.getTuan15() == 1)
		             			{
		             				array[k++] = true;
		             			}
		             			else
		             			{
		             				array[k++] = false;
		             			}
		             			Object[] data = {count, sv.getMaSinhVien(), sv.getHoVaTen(), 
		             					array[0], array[1], array[2], array[3], array[4], 
		             					array[5], array[6], array[7], array[8], array[9], 
		             					array[10], array[11], array[12], array[13], array[14]};	
		             			count++;
		             			((DefaultTableModel) tableStudentInClass.table.getModel()).addRow(data);
		             			tableStudentInClass.table.addNotify();
							}
							else
							{
								JOptionPane.showConfirmDialog(null,"Xảy ra lỗi khi thêm!",
			        				 	"Warning",
			        				    JOptionPane.OK_CANCEL_OPTION);
							}
						}
						else
						{
							JOptionPane.showConfirmDialog(null,"Xảy ra lỗi khi thêm!",
		        				 	"Warning",
		        				    JOptionPane.OK_CANCEL_OPTION);
						}

						
					}
				}
				if(flag == JOptionPane.OK_OPTION && choiceAddStudentJoinClass.getSelectedIndex() == 1)
				{
					System.out.println("Chon");
					teacherFrame.setVisible(false);
					
					addStudentTableFrame = new JFrame("Thêm sinh viên");
					addStudentTableFrame.setLocation(500, 250);
					//addStudentTableFrame.setLayout(new FlowLayout());
					addStudentTableFrame.setLayout(new BoxLayout(addStudentTableFrame.getContentPane(), BoxLayout.Y_AXIS));
					ImageIcon imgMain = new ImageIcon("Images\\Notes.png");
					addStudentTableFrame.setIconImage(imgMain.getImage());;
					addStudentTableFrame.addWindowListener(new WindowAdapter() 
				      {
				         public void windowClosing(WindowEvent windowEvent)
				         {
				            System.exit(0);
				            
				         }        
				      });
					tableStudentNotInClass = new tableListStudentNotInClass(addStudentTableFrame);
					
					String maLopHoc = (String) classComboBox.getSelectedItem();
		        	 System.out.println(maLopHoc);
					count = 1;
		        	 LopHoc lh = LopHocDAO.layThongTinLopHoc(maLopHoc);
		        	 ((DefaultTableModel) tableStudentNotInClass.table.getModel()).setRowCount(0);
		        	 
		        	 List<SinhVien> dssv = SinhVienDAO.layDanhSachSinhVien();
		        	 
		        	 if(lh != null)
		        	 {
		        		 sinhvien_lophoc svlh = null;
		        		 Iterator<SinhVien> svs = lh.getSinhViens().iterator();
		        		 ArrayList<SinhVien> dssvtl = new ArrayList<SinhVien>();
		        		 while(svs.hasNext()) {
		             		SinhVien sv = svs.next();
		             		dssvtl.add(sv);
		        		 }
		        		 for(int i = 0 ; i < dssv.size(); i++)
		        		 {
		        			 if(dssvtl.contains(dssv.get(i)) == false)
		        			 {
		        				 sinhvien_lophocID pk = new sinhvien_lophocID(dssv.get(i).getMaSinhVien(), maLopHoc);
		             				svlh = sinhvien_lophocDAO.layThongTinSinhVienLopHoc(pk);
			             			if(svlh == null) {
			             				//sinhvien_lophocID pk = new sinhvien_lophocID(sv.getMaSinhVien(), maLopHoc);
			             				//svlh = sinhvien_lophocDAO.layThongTinSinhVienLopHoc(pk);
			             				//if(svlh != null)
					             		//{
					             			
					             			Object[] data = {count, dssv.get(i).getMaSinhVien(), dssv.get(i).getHoVaTen(), 
					             					false};	
					             			count++;
					             			((DefaultTableModel) tableStudentNotInClass.table.getModel()).addRow(data);
					             		//}
			             			}
		        			 }
		        		 }
		        		 tableStudentNotInClass.table.setModel(tableModelNotExist);
		             		((AbstractTableModel) tableStudentNotInClass.table.getModel()).fireTableDataChanged();
		        	 }
					
					
					/////////////////////////////////////////////////////////////////
					JPanel okcancel = new JPanel();
					okcancel.setLayout(new FlowLayout());
					JButton ok = new JButton("Thêm");
					JButton cancel = new JButton("Thoát");
					okcancel.add(ok);
					okcancel.add(cancel);
					
					ok.addActionListener(new ActionListener() {
						
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							int j = JOptionPane.showConfirmDialog(null,"Bạn có chắc chắn muốn thêm những sinh viên này!",
		        				 	"Warning",
		        				    JOptionPane.OK_CANCEL_OPTION);
							if(j == JOptionPane.OK_OPTION) {
							for(int i = 0; i < count - 1; i++) 
							{
								boolean a = (boolean) tableStudentNotInClass.table.getValueAt(i, 3);
								if(a == true)
								{
									int mssv = (int) tableStudentNotInClass.table.getValueAt(i, 1);
									sinhvien_lophocID pk = new sinhvien_lophocID(mssv, maLopHoc);
									sinhvien_lophoc svlh = new sinhvien_lophoc();
									svlh.setPk(pk);
									svlh.setTuan1(0);
									svlh.setTuan2(0);
									svlh.setTuan3(0);
									svlh.setTuan4(0);
									svlh.setTuan5(0);
									svlh.setTuan6(0);
									svlh.setTuan7(0);
									svlh.setTuan8(0);
									svlh.setTuan9(0);
									svlh.setTuan10(0);
									svlh.setTuan11(0);
									svlh.setTuan12(0);
									svlh.setTuan13(0);
									svlh.setTuan14(0);
									svlh.setTuan15(0);
									
									boolean kq = sinhvien_lophocDAO.themSinhVienVaoLopHoc(svlh);
									if(kq == true)
									{ 			
										SinhVien sv = SinhVienDAO.layThongTinSinhVien(mssv);
										boolean[] array = new boolean[15];
				             			int k = 0;
				             			if(svlh.getTuan1() == 1)
				             			{
				             				array[k++] = true;
				             			}
				             			else
				             			{
				             				array[k++] = false;
				             			}
				             			if(svlh.getTuan2() == 1)
				             			{
				             				array[k++] = true;
				             			}
				             			else
				             			{
				             				array[k++] = false;
				             			}
				             			if(svlh.getTuan3() == 1)
				             			{
				             				array[k++] = true;
				             			}
				             			else
				             			{
				             				array[k++] = false;
				             			}
				             			if(svlh.getTuan4() == 1)
				             			{
				             				array[k++] = true;
				             			}
				             			else
				             			{
				             				array[k++] = false;
				             			}
				             			if(svlh.getTuan5() == 1)
				             			{
				             				array[k++] = true;
				             			}
				             			else
				             			{
				             				array[k++] = false;
				             			}
				             			if(svlh.getTuan6() == 1)
				             			{
				             				array[k++] = true;
				             			}
				             			else
				             			{
				             				array[k++] = false;
				             			}
				             			if(svlh.getTuan7() == 1)
				             			{
				             				array[k++] = true;
				             			}
				             			else
				             			{
				             				array[k++] = false;
				             			}
				             			if(svlh.getTuan8() == 1)
				             			{
				             				array[k++] = true;
				             			}
				             			else
				             			{
				             				array[k++] = false;
				             			}
				             			if(svlh.getTuan9() == 1)
				             			{
				             				array[k++] = true;
				             			}
				             			else
				             			{
				             				array[k++] = false;
				             			}
				             			if(svlh.getTuan10() == 1)
				             			{
				             				array[k++] = true;
				             			}
				             			else
				             			{
				             				array[k++] = false;
				             			}
				             			if(svlh.getTuan11() == 1)
				             			{
				             				array[k++] = true;
				             			}
				             			else
				             			{
				             				array[k++] = false;
				             			}
				             			if(svlh.getTuan12() == 1)
				             			{
				             				array[k++] = true;
				             			}
				             			else
				             			{
				             				array[k++] = false;
				             			}
				             			if(svlh.getTuan13() == 1)
				             			{
				             				array[k++] = true;
				             			}
				             			else
				             			{
				             				array[k++] = false;
				             			}
				             			if(svlh.getTuan14() == 1)
				             			{
				             				array[k++] = true;
				             			}
				             			else
				             			{
				             				array[k++] = false;
				             			}
				             			if(svlh.getTuan15() == 1)
				             			{
				             				array[k++] = true;
				             			}
				             			else
				             			{
				             				array[k++] = false;
				             			}
				             			Object[] data = {count, sv.getMaSinhVien(), sv.getHoVaTen(), 
				             					array[0], array[1], array[2], array[3], array[4], 
				             					array[5], array[6], array[7], array[8], array[9], 
				             					array[10], array[11], array[12], array[13], array[14]};	
				             			count++;
				             			((DefaultTableModel) tableStudentInClass.table.getModel()).addRow(data);
				             			tableStudentInClass.table.addNotify();
				             		} 	 
									else {
										JOptionPane.showConfirmDialog(null,"Xảy ra lỗi khi thêm!",
					        				 	"Warning",
					        				    JOptionPane.OK_CANCEL_OPTION);
									}
								}
								
							
							
								
							
							tableStudentInClass.table.setModel(tableModelExits);
							tableModelExits.fireTableDataChanged();
		             		addStudentTableFrame.dispose();
		             		teacherFrame.setVisible(true);
							}
							}
						}
						
							
					});
					
					cancel.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							addStudentTableFrame.dispose();
							teacherFrame.setVisible(true);
						}
					});
					
					addStudentTableFrame.add(okcancel);
					addStudentTableFrame.pack();
					addStudentTableFrame.setVisible(true);
					/*int i = JOptionPane.showConfirmDialog(null, addStudentTableFrame, "Chọn sinh viên đã có", JOptionPane.OK_CANCEL_OPTION);
					if(i == JOptionPane.OK_OPTION)
					{
						
					}*/
				}
				if(flag == JOptionPane.OK_OPTION && choiceAddStudentJoinClass.getSelectedIndex() == 2)
				{
					System.out.println("Import");
					JTextArea filename = new JTextArea("", 2, 15);
					filename.setUI(new HintTextFieldUI("Nhập tên file", true));
					JPanel result = new JPanel();
					result.add(filename);
					
					int i = JOptionPane.showConfirmDialog(null, result, "Import danh sách sinh viên", JOptionPane.OK_CANCEL_OPTION);
					if(i == JOptionPane.OK_OPTION)
					{
						String fname = filename.getText();
						System.out.println(fname);
						readfile(fname);
					}
				}
			}
		});
		
		
		
		teacherFrame.pack();
		teacherFrame.setVisible(true);
	}
	private void newFilter() {
        RowFilter<AbstractTableModel, Object> rf = null;
        //If current expression doesn't parse, don't update.
        try {
            rf = RowFilter.regexFilter(searchStudentTextArea.getText(), 1);
        } catch (java.util.regex.PatternSyntaxException e) {
            return;
        }
        sorter.setRowFilter(rf);
    }
	public class CardLayoutDemo implements ItemListener {
	    JPanel cards; //a panel that uses CardLayout
	    final static String ADDNEWSTUDENT = "Thêm mới sinh viên";
	    final static String ADDEXISTSTUDENT = "Chọn sinh viên đã có";
	    final static String ADDIMPORTSTUDENT = "Import danh sách sinh viên";
	    public void addComponentToPane(JPanel pane) {
	    	//pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
	        //Put the JComboBox in a JPanel to get a nicer look.
	        JPanel comboBoxPane = new JPanel(); //use FlowLayout
	        String comboBoxItems[] = { ADDNEWSTUDENT, ADDEXISTSTUDENT, ADDIMPORTSTUDENT};
	        choiceAddStudentJoinClass = new JComboBox<String>(comboBoxItems);
	        choiceAddStudentJoinClass.setEditable(false);
	        choiceAddStudentJoinClass.addItemListener(this);
	        comboBoxPane.add(choiceAddStudentJoinClass);
	        
	        //Create the "cards".
	        JPanel card1 = new JPanel();
	        
	        JPanel card2 = new JPanel();
	        
	        JPanel card3 = new JPanel();
	        
	        //Create the panel that contains the "cards".
	        cards = new JPanel(new CardLayout());
	        cards.add(card1, ADDNEWSTUDENT);
	        cards.add(card2, ADDEXISTSTUDENT);
	        cards.add(card3, ADDIMPORTSTUDENT);
	        
	        pane.add(comboBoxPane);
	        pane.add(cards);
	    }
	    
	    public void itemStateChanged(ItemEvent evt) {
	        CardLayout cl = (CardLayout)(cards.getLayout());
	        cl.show(cards, (String)evt.getItem());
	    }
	    
	    /**
	     * Create the GUI and show it.  For thread safety,
	     * this method should be invoked from the
	     * event dispatch thread.
	     */
	}
	public void setVisible(boolean a)
	{
		loginFrame.setVisible(a);
	}
	public void addLoginListener(ActionListener login) {
		loginButton.addActionListener(login);
    }
	/*public void getListStudentOfClass(String maLopHoc, ArrayList<String> listStudentOfClass)
	{
		
		LopHoc lh = LopHocDAO.layThongTinLopHoc(maLopHoc);
		Iterator<SinhVien> svs = lh.getSinhViens().iterator();
		while(svs.hasNext()) {
    		SinhVien sv = svs.next();
    		listStudentOfClass.add(sv.getMaSinhVien());
    	}
	}*/
	class tableListStudentNotInClass extends JFrame {

	    private static final long serialVersionUID = 1L;
	    private JTable table;

	    @SuppressWarnings("serial")
		public tableListStudentNotInClass(JFrame teacherFrame) {
	        Object[] columnNames = {"STT",
			        "MSSV",
			        "Họ và tên",
			        "Chọn"};
	        
	        tableModelNotExist = new DefaultTableModel(columnNames, 10){

	            boolean[] canEdit = new boolean[]{
	                    false, false,
	                    false, true
	            };

	            public boolean isCellEditable(int rowIndex, int columnIndex) {
	                return canEdit[columnIndex];
	            }
	};
	        this.table = new JTable(tableModelNotExist) {

	            private static final long serialVersionUID = 1L;

	            /*@Override
	            public Class getColumnClass(int column) {
	            return getValueAt(0, column).getClass();
	            }*/
	            public Class getColumnClass(int column) {
	                switch (column) {
	                    case 0:
	                        return Integer.class;
	                    case 1:
	                        return String.class;
	                    case 2:
	                        return String.class;
	                    default:
	                        return Boolean.class;
	                }
	            }
	            public Component prepareRenderer(
	                    TableCellRenderer renderer, int row, int column)
	                {
	                    Component c = super.prepareRenderer(renderer, row, column);
	                    JComponent jc = (JComponent)c;

	                    //  Color row based on a cell value
	                    //  Alternate row color

	                    if (!isRowSelected(row))
	                        c.setBackground(row % 2 == 0 ? Color.getHSBColor((float) 0.3, (float) 0.5, 1) : getBackground());
	                    else
	                        jc.setBorder(new MatteBorder(1, 0, 1, 0, Color.gray) );

	                    
	                    //  Use bold font on selected row

	                    return c;
	                }
	        };
	        TableColumn column = null;
			for (int i = 0; i < 4; i++) {
			    column = table.getColumnModel().getColumn(i);
			    if (i == 2) 
			    {
			        column.setPreferredWidth(150); //third column is bigger
			    } 
			    else 
			    {
			    	if(i == 0)
			    	{
			    		column.setPreferredWidth(50);
			    	}
			    	else
			    	{
			    		 column.setPreferredWidth(75);
			    	}
			       
			    }
			}
			JTableHeader header = table.getTableHeader();
			header.setPreferredSize(new Dimension(100, 70));
			header.setBackground(Color.WHITE);
			table.getTableHeader().setFont( new Font( "Arial" , Font.BOLD, 13 ));
	        table.setPreferredScrollableViewportSize(table.getPreferredSize());
	        table.changeSelection(0, 0, false, false);
	        JScrollPane scrollPane = new JScrollPane(table);
	        teacherFrame.add(scrollPane);
	    }
	}
	class tableAttendanceStudentOfClass extends JFrame {

	    private static final long serialVersionUID = 1L;
	    private JTable table;

	    @SuppressWarnings("serial")
		public tableAttendanceStudentOfClass(JFrame teacherFrame) {
	        Object[] columnNames = {"STT",
			        "MSSV",
			        "Họ và tên",
			        "Tuần 1", "Tuần 2", "Tuần 3", "Tuần 4", "Tuần 5",
			        "Tuần 6", "Tuần 7", "Tuần 8", "Tuần 9", "Tuần 10",
			        "Tuần 11", "Tuần 12", "Tuần 13", "Tuần 14", "Tuần 15"};
	       
	        
	        modelAttendance = new DefaultTableModel(columnNames, 1){

	            boolean[] canEdit = new boolean[]{
	                    false, false, false,
	                    false, false, false, false, false,
	                    false, false, false, false, false,
	                    false, false, false, false, false
	            };

	            public boolean isCellEditable(int rowIndex, int columnIndex) {
	                return canEdit[columnIndex];
	            }
	};
	        this.table = new JTable(modelAttendance) {

	            private static final long serialVersionUID = 1L;

	            /*@Override
	            public Class getColumnClass(int column) {
	            return getValueAt(0, column).getClass();
	            }*/
	            public Class getColumnClass(int column) {
	                switch (column) {
	                    case 0:
	                        return Integer.class;
	                    case 1:
	                        return String.class;
	                    case 2:
	                        return String.class;
	                    default:
	                        return Boolean.class;
	                }
	            }
	            public Component prepareRenderer(
	                    TableCellRenderer renderer, int row, int column)
	                {
	                    Component c = super.prepareRenderer(renderer, row, column);
	                    JComponent jc = (JComponent)c;

	                    //  Color row based on a cell value
	                    //  Alternate row color

	                    if (!isRowSelected(row))
	                        c.setBackground(row % 2 == 0 ? Color.getHSBColor((float) 0.3, (float) 0.5, 1) : getBackground());
	                    else
	                        jc.setBorder(new MatteBorder(1, 0, 1, 0, Color.gray) );

	                    
	                    //  Use bold font on selected row

	                    return c;
	                }
	        };
	        TableColumn column = null;
			for (int i = 0; i < 18; i++) {
			    column = table.getColumnModel().getColumn(i);
			    if (i == 2) 
			    {
			        column.setPreferredWidth(150); //third column is bigger
			    } 
			    else 
			    {
			    	if(i == 0)
			    	{
			    		column.setPreferredWidth(35);
			    	}
			    	else
			    	{
			    		 column.setPreferredWidth(60);
			    	}
			       
			    }
			}
			JTableHeader header = table.getTableHeader();
			header.setPreferredSize(new Dimension(100, 70));
			header.setBackground(Color.WHITE);
			table.getTableHeader().setFont( new Font( "Arial" , Font.BOLD, 13 ));
	        table.setPreferredScrollableViewportSize(table.getPreferredSize());
	        table.changeSelection(0, 0, false, false);
	        JScrollPane scrollPane = new JScrollPane(table);
	        teacherFrame.add(scrollPane);
	    }
	}
	class tableListStudentOfClass extends JFrame {

	    private static final long serialVersionUID = 1L;
	    private JTable table;

	    @SuppressWarnings("serial")
		public tableListStudentOfClass(JFrame teacherFrame) {
	        Object[] columnNames = {"STT",
			        "MSSV",
			        "Họ và tên",
			        "Tuần 1", "Tuần 2", "Tuần 3", "Tuần 4", "Tuần 5",
			        "Tuần 6", "Tuần 7", "Tuần 8", "Tuần 9", "Tuần 10",
			        "Tuần 11", "Tuần 12", "Tuần 13", "Tuần 14", "Tuần 15"};
	       
	        
	        tableModelExits = new DefaultTableModel(columnNames, 10){

	            boolean[] canEdit = new boolean[]{
	                    false, false, false,
	                    true, true, true, true, true,
	                    true, true, true, true, true,
	                    true, true, true, true, true
	            };

	            public boolean isCellEditable(int rowIndex, int columnIndex) {
	                return canEdit[columnIndex];
	            }
	};
	        this.table = new JTable(tableModelExits) {

	            private static final long serialVersionUID = 1L;

	            /*@Override
	            public Class getColumnClass(int column) {
	            return getValueAt(0, column).getClass();
	            }*/
	            public Class getColumnClass(int column) {
	                switch (column) {
	                    case 0:
	                        return Integer.class;
	                    case 1:
	                        return String.class;
	                    case 2:
	                        return String.class;
	                    default:
	                        return Boolean.class;
	                }
	            }
	            public Component prepareRenderer(
	                    TableCellRenderer renderer, int row, int column)
	                {
	                    Component c = super.prepareRenderer(renderer, row, column);
	                    JComponent jc = (JComponent)c;

	                    //  Color row based on a cell value
	                    //  Alternate row color

	                    if (!isRowSelected(row))
	                        c.setBackground(row % 2 == 0 ? Color.getHSBColor((float) 0.3, (float) 0.5, 1) : getBackground());
	                    else
	                        jc.setBorder(new MatteBorder(1, 0, 1, 0, Color.green) );

	                    
	                    //  Use bold font on selected row

	                    return c;
	                }
	        };
	        TableColumn column = null;
			for (int i = 0; i < 18; i++) {
			    column = table.getColumnModel().getColumn(i);
			    if (i == 2) 
			    {
			        column.setPreferredWidth(150); //third column is bigger
			    } 
			    else 
			    {
			    	if(i == 0)
			    	{
			    		column.setPreferredWidth(35);
			    	}
			    	else
			    	{
			    		 column.setPreferredWidth(60);
			    	}
			       
			    }
			}
			JTableHeader header = table.getTableHeader();
			header.setPreferredSize(new Dimension(100, 70));
			header.setBackground(Color.WHITE);
			table.getTableHeader().setFont( new Font( "Arial" , Font.BOLD, 13 ));
	        table.setPreferredScrollableViewportSize(table.getPreferredSize());
	        table.changeSelection(0, 0, false, false);
	        JScrollPane scrollPane = new JScrollPane(table);
	        teacherFrame.add(scrollPane);
	    }
	}
	public JPanel createClass(JTextField ID, JTextField Name, JTextField Room
			, JComboBox<Integer> dayBegin, JComboBox<Integer> monthBegin, JComboBox<Integer> yearBegin
			, JComboBox<Integer> dayEnd, JComboBox<Integer> monthEnd, JComboBox<Integer> yearEnd
			, JComboBox<Integer> hourBegin, JComboBox<Integer> minuteBegin
			, JComboBox<Integer> hourEnd, JComboBox<Integer> minuteEnd
			, JComboBox<String> dayMonth)
	{
		JPanel jp = new JPanel(new GridLayout(8, 2));
		jp.add(new JLabel("Mã lớp học:"));
		jp.add(ID);
		
		jp.add(new JLabel("Tên lớp học:"));
		jp.add(Name);
		
		jp.add(new JLabel("Phòng học:"));
		jp.add(Room);
		
		jp.add(new JLabel("Ngày bắt đầu (Năm - Tháng - Ngày):"));
		JPanel dateBegin = new JPanel();
		dateBegin.add(yearBegin);
		dateBegin.add(monthBegin);
		dateBegin.add(dayBegin);
		jp.add(dateBegin);
		
		
		jp.add(new JLabel("Giờ bắt đầu (Giờ : Phút):"));
		JPanel timeBegin = new JPanel();
		timeBegin.add(hourBegin);
		timeBegin.add(minuteBegin);
		jp.add(timeBegin);
		
		jp.add(new JLabel("Giờ kết thúc (Giờ : Phút):"));
		JPanel timeEnd = new JPanel();
		timeEnd.add(hourEnd);
		timeEnd.add(minuteEnd);
		jp.add(timeEnd);
		
		jp.add(new JLabel("Thứ:"));
		jp.add(dayMonth);
		
		return jp;
	}
	public void readfile(String filename)
    {
		try {
			System.out.println("đọc file");
			File fileDir = new File(filename);

			BufferedReader in = new BufferedReader(
			   new InputStreamReader(
	                      new FileInputStream(fileDir), "UTF8"));

			String str;

			while ((str = in.readLine()) != null) {
				String[] info = str.split(",");
			    System.out.println(info[0]);
			    System.out.println(info[1]);
			    System.out.println(info[2]);
			    SinhVien sv = new SinhVien();
			    sv.setMaSinhVien(Integer.parseInt(info[0]));
			    sv.setHoVaTen(info[1]);
			    sv.setMatKhau(info[2]);
			    
			    boolean kq = SinhVienDAO.themSinhVien(sv);
			    if(kq == true) {
			    	System.out.println("Them sv thanh cong!");
			    	sinhvien_lophocID pk = new sinhvien_lophocID(Integer.parseInt(info[0]), classComboBox.getSelectedItem().toString());
			    	sinhvien_lophoc svlh = new sinhvien_lophoc();
			    	svlh.setPk(pk);
			    	svlh.setTuan1(0);
			    	svlh.setTuan2(0);
			    	svlh.setTuan3(0);
			    	svlh.setTuan4(0);
			    	svlh.setTuan5(0);
			    	svlh.setTuan6(0);
			    	svlh.setTuan7(0);
			    	svlh.setTuan8(0);
			    	svlh.setTuan9(0);
			    	svlh.setTuan10(0);
			    	svlh.setTuan11(0);
			    	svlh.setTuan12(0);
			    	svlh.setTuan13(0);
			    	svlh.setTuan14(0);
			    	svlh.setTuan15(0);
			    	
			    	boolean result = sinhvien_lophocDAO.themSinhVienVaoLopHoc(svlh);
			    	if(result == true)
			    	{
			    		System.out.println("then sinh vien vao lop hoc thanh cong!");
			    		
			    	}
			    }
			}
				
			JOptionPane.showConfirmDialog(null,"Import sinh viên thành công\nNhấn xem để cập nhật!!",
				 	"Warning",
				    JOptionPane.OK_CANCEL_OPTION);
	                in.close();
		    }
		    catch (UnsupportedEncodingException e)
		    {
				System.out.println(e.getMessage());
		    }
		    catch (IOException e)
		    {
				System.out.println(e.getMessage());
		    }
		    catch (Exception e)
		    {
				System.out.println(e.getMessage());
		    }
		}
		
				//System.out.println(id);
				//String[] info = id.split(",");
				//System.out.println(info[0]);
				//System.out.println(info[1]);
				//System.out.println(info[2]);
    	// while (br.hasline)
    	//{}
    	// String file lay dc r
    	// String []  = file.split(",");
    	// Id = 

	public JPanel addNewStudentJoinClass(JTextField ID, JTextField Name)
	{
		JPanel jp = new JPanel(new GridLayout(4, 2));
		jp.add(new JLabel("Mã sinh viên:"));
		jp.add(ID);
		
		jp.add(new JLabel("Họ và tên:"));
		jp.add(Name);
		return jp;
	}

	
	
	public JTextArea getUserTextArea() {
		return userTextArea;
	}

	public void setUserTextArea(JTextArea userTextArea) {
		this.userTextArea = userTextArea;
	}

	public JPasswordField getPasswordField() {
		return passwordField;
	}

	public void setPasswordField(JPasswordField passwordField) {
		this.passwordField = passwordField;
	}

	public JButton getLoginButton() {
		return loginButton;
	}

	public void setLoginButton(JButton loginButton) {
		this.loginButton = loginButton;
	}

	public JComboBox<String> getClassComboBox() {
		return classComboBox;
	}

	public void setClassComboBox(JComboBox<String> classComboBox) {
		this.classComboBox = classComboBox;
	}

	public JButton getViewClassButton() {
		return viewClassButton;
	}

	public void setViewClassButton(JButton viewClassButton) {
		this.viewClassButton = viewClassButton;
	}

	public JTextArea getFromdayTextArea() {
		return fromdayTextArea;
	}

	public void setFromdayTextArea(JTextArea fromdayTextArea) {
		this.fromdayTextArea = fromdayTextArea;
	}

	public JTextArea getTodayTextArea() {
		return todayTextArea;
	}

	public void setTodayTextArea(JTextArea todayTextArea) {
		this.todayTextArea = todayTextArea;
	}

	public JTextArea getFromhourTextArea() {
		return fromhourTextArea;
	}

	public void setFromhourTextArea(JTextArea fromhourTextArea) {
		this.fromhourTextArea = fromhourTextArea;
	}

	public JTextArea getTohourTextArea() {
		return tohourTextArea;
	}

	public void setTohourTextArea(JTextArea tohourTextArea) {
		this.tohourTextArea = tohourTextArea;
	}

	public JTextArea getDayOfWeekTextArea() {
		return dayOfWeekTextArea;
	}

	public void setDayOfWeekTextArea(JTextArea dayOfWeekTextArea) {
		this.dayOfWeekTextArea = dayOfWeekTextArea;
	}

	public JTextArea getRoomTextArea() {
		return roomTextArea;
	}

	public void setRoomTextArea(JTextArea roomTextArea) {
		this.roomTextArea = roomTextArea;
	}

	public JTextArea getSearchStudentTextArea() {
		return searchStudentTextArea;
	}

	public void setSearchStudentTextArea(JTextArea searchStudentTextArea) {
		this.searchStudentTextArea = searchStudentTextArea;
	}

	public JButton getSearchStudentButton() {
		return searchStudentButton;
	}

	public void setSearchStudentButton(JButton searchStudentButton) {
		this.searchStudentButton = searchStudentButton;
	}

	public JButton getAddButton() {
		return addButton;
	}

	public void setAddButton(JButton addButton) {
		this.addButton = addButton;
	}

	public JButton getSubButton() {
		return subButton;
	}

	public void setSubButton(JButton subButton) {
		this.subButton = subButton;
	}

	public JFrame getTeacherFrame() {
		return teacherFrame;
	}

	public void setTeacherFrame(JFrame teacherFrame) {
		this.teacherFrame = teacherFrame;
	}

	public JFrame getLoginFrame() {
		return loginFrame;
	}

	public void setLoginFrame(JFrame loginFrame) {
		this.loginFrame = loginFrame;
	}
}


class HintTextFieldUI extends BasicTextFieldUI implements FocusListener {

    private String hint;
    private boolean hideOnFocus;
    private Color color;
    private boolean firstSelect;
    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
        repaint();
    }

    private void repaint() {
        if(getComponent() != null) {
            getComponent().repaint();           
        }
    }

    public boolean isHideOnFocus() {
        return hideOnFocus;
    }

    public void setHideOnFocus(boolean hideOnFocus) {
        this.hideOnFocus = hideOnFocus;
        repaint();
    }

    public String getHint() {
        return hint;
    }

    public void setHint(String hint) {
        this.hint = hint;
        repaint();
    }
    public HintTextFieldUI(String hint) {
        this(hint,false);
    }

    public HintTextFieldUI(String hint, boolean hideOnFocus) {
        this(hint,hideOnFocus, null);
    }

    public HintTextFieldUI(String hint, boolean hideOnFocus, Color color) {
        this.hint = hint;
        this.hideOnFocus = hideOnFocus;
        this.color = color;
        this.firstSelect = false;
    }

    @Override
    protected void paintSafely(Graphics g) {
        super.paintSafely(g);
        JTextComponent comp = getComponent();
        if(hint!=null && comp.getText().length() == 0 && (!(hideOnFocus && comp.hasFocus() && firstSelect == false))){
        	
            if(color != null) {
                g.setColor(color);
            } else {
                g.setColor(comp.getForeground().brighter().brighter().brighter());              
            }
            int padding = (comp.getHeight() - comp.getFont().getSize())/2;
            g.drawString(hint, 2, comp.getHeight()-padding-1);     
            
        }
        /*else
        {
        	char[] str = new char[100];
        	int i;
        	for(i = 0; i < comp.getText().length(); i++)
        	{
        		str[i] = '*';
        	}
        	str[i] = '\0';
        	comp.setText(str.toString());
        }*/
        if(firstSelect == false)
    	{
    		firstSelect = true;
    	}
    }

    @Override
    public void focusGained(FocusEvent e) {
        if(hideOnFocus) repaint();

    }

    @Override
    public void focusLost(FocusEvent e) {
        if(hideOnFocus) repaint();
    }
    @Override
    protected void installListeners() {
        super.installListeners();
        getComponent().addFocusListener(this);
    }
    @Override
    protected void uninstallListeners() {
        super.uninstallListeners();
        getComponent().removeFocusListener(this);
    }
    
    // -------0--
    
    
    
}

