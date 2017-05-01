import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;

public class Controller extends GUI {
	private GUI m_view;
	Controller(GUI view)
	{
		m_view = view;
		m_view.addLoginListener(new LoginListener());
		//m_view.addViewClassListener(new ViewClassListener());
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GUI view = new GUI();
		Controller con = new Controller(view);
		view.setVisible(true);
	}
	class LoginListener implements ActionListener {
        public void actionPerformed(ActionEvent e) { 	
        	String id = m_view.getUserTextArea().getText();
        	String password = m_view.getPasswordField().getText();
        	SinhVien sv;
        	int ID = Integer.parseInt(id);
        	sv = SinhVienDAO.layThongTinSinhVien(ID);
        	if(sv != null)
        	{
        		String userPassword = sv.getMatKhau();
        		if(password.hashCode()  == Integer.parseInt(userPassword))
        		{
        			m_view.studentView(ID);
        		}
        		else 
        		{
        			String matkhaucu = sv.getMatKhau();
        			if(id.equals(password) && matkhaucu.equals(password))
        			{
        				JPasswordField password1 = new JPasswordField();
        				JPasswordField password2 = new JPasswordField();
        				
    					JPanel result = new JPanel();
    					result.setLayout(new GridLayout(4, 1));
    					result.add(new JLabel("Nhập mật khẩu mới:"));
    					result.add(password1);
    					result.add(new JLabel("Nhập lại mật khẩu mới:"));
    					result.add(password2);
    					
    					
    					int i = JOptionPane.showConfirmDialog(null, result, "Thay đổi mật khẩu", JOptionPane.OK_CANCEL_OPTION);
    					if(i == JOptionPane.OK_OPTION)
    					{
    						String pass1 = password1.getText();
    						String pass2 = password2.getText();
    						if(pass1.equals(pass2))
            				{
    							int k = pass1.hashCode();
    							String newPassHash = String.valueOf(k);
    							sv.setMatKhau(newPassHash);
    							boolean kq = SinhVienDAO.capNhatThongTinSinhVien(sv);
    							if(kq == true)
    							{
    								JOptionPane.showConfirmDialog(null,"Đổi mật khẩu thành công!",
        		        				 	"Warning",
        		        				    JOptionPane.OK_CANCEL_OPTION);
    								m_view.studentView(ID);
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
            					JOptionPane.showConfirmDialog(null,"Hai mật khẩu không trùng khớp!",
    		        				 	"Warning",
    		        				    JOptionPane.OK_CANCEL_OPTION);
            				}
    						
    					}
    					
    					
        				
            			
            		}
            		else
            		{
            			Object[] options = {""};
    	        		 JOptionPane.showOptionDialog(m_view.getLoginFrame(),"Sai tài khoản hoặc mật khẩu!\n",
    	        				 	"Warning",
    	        				    JOptionPane.OK_CANCEL_OPTION,
    	        				    JOptionPane.WARNING_MESSAGE,
    	        				    null,
    	        				    null,
    	        				    options);
            			
            		}
        		}
        		
        		/**/
        	}
        	else
        	{
        		GiaoVien gv;
        		gv = GiaoVienDAO.layThongTinGiaoVien(ID);
        		String userPassword = gv.getMatKhau();
        		if(password.hashCode()  == Integer.parseInt(userPassword))
        		{
        			m_view.teacherView(ID);
        		}
        		else 
        		{
        			String matkhaucu = gv.getMatKhau();
        			if(id.equals(password) && matkhaucu.equals(password))
            		{
        				JPasswordField password1 = new JPasswordField();
        				JPasswordField password2 = new JPasswordField();
        				
    					JPanel result = new JPanel();
    					result.setLayout(new GridLayout(4, 1));
    					result.add(new JLabel("Nhập mật khẩu mới:"));
    					result.add(password1);
    					result.add(new JLabel("Nhập lại mật khẩu mới:"));
    					result.add(password2);
    					
    					int i = JOptionPane.showConfirmDialog(null, result, "Thay đổi mật khẩu", JOptionPane.OK_CANCEL_OPTION);
    					if(i == JOptionPane.OK_OPTION)
    					{
    						String pass1 = password1.getText();
    						String pass2 = password2.getText();
    						if(pass1.equals(pass2))
            				{
    							int k = pass1.hashCode();
    							String newPassHash = String.valueOf(k);
    							gv.setMatKhau(newPassHash);
    							boolean kq = GiaoVienDAO.capNhatThongTinGiaoVien(gv);
    							if(kq == true)
    							{
    								JOptionPane.showConfirmDialog(null,"Đổi mật khẩu thành công!",
        		        				 	"Warning",
        		        				    JOptionPane.OK_CANCEL_OPTION);
    								m_view.teacherView(ID);
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
            					JOptionPane.showConfirmDialog(null,"Hai mật khẩu không trùng khớp!",
    		        				 	"Warning",
    		        				    JOptionPane.OK_CANCEL_OPTION);
            				}
    						
    					}
    					
    					
        				
            			
            		}
            		else
            		{
            			Object[] options = {""};
    	        		 JOptionPane.showOptionDialog(m_view.getLoginFrame(),"Sai tài khoản hoặc mật khẩu!\n",
    	        				 	"Warning",
    	        				    JOptionPane.OK_CANCEL_OPTION,
    	        				    JOptionPane.WARNING_MESSAGE,
    	        				    null,
    	        				    null,
    	        				    options);
            			
            		}
        		}
        	}
        }
    }
	
}
