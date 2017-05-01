import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;




public class GUI extends Dictionary{

	private JFrame mainFrame;
	private JPanel languagePanel;
	private JPanel wordPanel;
	private JPanel translatePanel;
	private JPanel meanPanel;
	
	private JPanel cardStatistical;
	private JPanel cardTranslate;
	private JPanel cardFavorite;
	private JPanel fromdayPanel;
	private JPanel todayPanel;
	private JPanel StatisPanel;
	private JPanel notePanel;
	private JPanel listFavorite;
	private JList<String> wordList;
	private JList<Integer> frequencyList;
	private JList<String> fList;
	
	private static String fileName3 = "Favorite.xml";
	private static String fileName4 = "Statistic.xml";
	DefaultListModel<String> WORD = new DefaultListModel<>();
	DefaultListModel<Integer> COUNT = new DefaultListModel<>();
	DefaultListModel<String> FAVORITE = new DefaultListModel<>();
	final static String translatePANEL = "Translate";
    final static String statisticalPANEL = "Statistical";
    final static String favoritePANEL = "Favorite";
    final static int extraWindowWidth = 100;
    private ArrayList<Word> listWord;
    private ArrayList<Word> saveWordTranslated;
    private ArrayList<String> favorWordList;
    private ArrayList<String> favorMeanList;
    
    private JButton translateButton;
	public GUI()
	{
		
		saveWordTranslated = new ArrayList<Word>();
		listWord = new ArrayList<Word>();
		favorWordList = new ArrayList<String>();
		favorMeanList = new ArrayList<String>();
		readXMLFile(fileName4, listWord, saveWordTranslated);
		readFavoriteXML(fileName3, favorWordList, favorMeanList);
		for(int i = 0; i < listWord.size(); i++)
		{
			System.out.println(listWord.get(i).getWord() + " " + listWord.get(i).getCount());
			
		}
		for(int i = 0; i < favorWordList.size(); i++)
		{
			System.out.println(favorWordList.get(i));
			
		}
		
		prepareGUI();
	}
	
	 public void prepareGUI()
	 {
	      mainFrame = new JFrame("Dictionary");
	      mainFrame.setLocation(500, 200);
	      mainFrame.setSize(400,370);
	      mainFrame.setLayout(new BoxLayout(mainFrame.getContentPane(), BoxLayout.Y_AXIS)); // GridLayout(4, 0)
	      
	      mainFrame.addWindowListener(new WindowAdapter() 
	      {
	         public void windowClosing(WindowEvent windowEvent)
	         {
	        	try {
	        		
	        		writeXMLFile(fileName4,saveWordTranslated);
	        		writeFavoriteXMLFile(fileName3, favorWordList, favorMeanList);
	        		saveWordTranslated.clear();
	        		listWord.clear();
	        		favorWordList.clear();
	        		favorMeanList.clear();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
	            System.exit(0);
	         }        
	      });
	      
	      JTabbedPane tabbedPane = new JTabbedPane();
	      
	      cardTranslate = new JPanel() {
	            public Dimension getPreferredSize() {
	                Dimension size = super.getPreferredSize();
	                size.width += extraWindowWidth;
	                return size;
	            }
	        };
	      cardTranslate.setLayout(new BoxLayout(cardTranslate, BoxLayout.Y_AXIS));
	      
	      languagePanel = new JPanel();
	      languagePanel.setLayout(new FlowLayout());
	      
	      wordPanel = new JPanel();
	      wordPanel.setLayout(new FlowLayout());
	      
	      translatePanel = new JPanel();
	      translatePanel.setLayout(new FlowLayout());
	      
	      meanPanel = new JPanel();
	      meanPanel.setLayout(new FlowLayout());
	      
	      cardTranslate.add(languagePanel);
	      cardTranslate.add(wordPanel);
	      cardTranslate.add(translatePanel);
	      cardTranslate.add(meanPanel);
	      
	      
	      cardStatistical = new JPanel();
	      cardStatistical.setLayout(new BoxLayout(cardStatistical, BoxLayout.Y_AXIS));
	      fromdayPanel = new JPanel();
	      fromdayPanel.setLayout(new FlowLayout());
	      
	      todayPanel = new JPanel();
	      todayPanel.setLayout(new FlowLayout());
	      
	      notePanel = new JPanel();
	      notePanel.setLayout(new GridLayout(1, 3));
	      
	      StatisPanel = new JPanel();
	      StatisPanel.setLayout(new GridLayout(1,3));
	      
	      
	      
	      cardStatistical.add(fromdayPanel);
	      cardStatistical.add(todayPanel);
	      cardStatistical.add(notePanel);
	      cardStatistical.add(StatisPanel);
	      
	      cardFavorite = new JPanel();
	      cardFavorite.setLayout(new GridLayout(1,1));
	      listFavorite = new JPanel();
	      listFavorite.setLayout(new GridLayout(1,1));
	      cardFavorite.add(listFavorite);
	      
	      
	      tabbedPane.addTab(translatePANEL, cardTranslate);
	      tabbedPane.addTab(statisticalPANEL, cardStatistical);
	      tabbedPane.addTab(favoritePANEL, cardFavorite);
	      mainFrame.getContentPane().add(tabbedPane, BorderLayout.CENTER);
	 }
	 public void showTranslate()
	 {
		 String language[]={"English", "Vietnamese"};
		 
		 JComboBox<String> cbox1 = new JComboBox<String>(language);
		 cbox1.setPreferredSize(new Dimension(152, 26));
		 JComboBox<String> cbox2 = new JComboBox<String>(language);
		 cbox2.setPreferredSize(new Dimension(150, 26));
		 Border border = BorderFactory.createLineBorder(Color.BLUE);

		 JButton tranferButton = new JButton("");
		 tranferButton.setPreferredSize(new Dimension(26, 26));
		 ImageIcon img1 = new ImageIcon("Images\\swap-horizontal-orientation-arrows.png");
		 tranferButton.setIcon(img1);
		 
		 translateButton = new JButton();
		 translateButton.setPreferredSize(new Dimension(94, 32));
		 ImageIcon img2 = new ImageIcon("Images\\translate.png");
		 translateButton.setIcon(img2);
		 
		 JButton cleanButton = new JButton();
		 cleanButton.setPreferredSize(new Dimension(73, 32));
		 ImageIcon img3 = new ImageIcon("Images\\clean.png");
		 cleanButton.setIcon(img3);
		 
		 JButton favoriteButton = new JButton();
		 favoriteButton.setPreferredSize(new Dimension(32, 32));
		 ImageIcon img4 = new ImageIcon("Images\\1490297648_star.png");
		 favoriteButton.setIcon(img4);
		 
		 final JTextArea wordTextArea = new JTextArea("", 3, 28);
		 wordTextArea.setLocation(20, 5);
		 wordTextArea.setBorder(border);
		 wordTextArea.setFont(new Font("Verdana", Font.BOLD, 12));
		 
		 JScrollPane scrollPaneWord = 
				 new JScrollPane(wordTextArea, 
						 JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
						 JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		 
		 
		 final JTextArea meaningTextArea = new JTextArea("",7,28);
		 meaningTextArea.setBorder(border);
		 meaningTextArea.setEditable(false);
		 meaningTextArea.setFont(new Font("Verdana", Font.BOLD, 12));
		 
		 JScrollPane scrollPaneMean = 
				 new JScrollPane(meaningTextArea, 
						 JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
						 JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		 
		 tranferButton.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	        	 int i = cbox1.getSelectedIndex();
	        	 int j = cbox2.getSelectedIndex();
	        	 cbox2.setSelectedIndex(i);
	        	 cbox1.setSelectedIndex(j);
	         }
	      }); 
		 
		 favoriteButton.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {     
	        	 String str = wordTextArea.getText();
	        	 if(hmapAnh_Viet.get(wordTextArea.getText()) != null)
				 {
	        		 favorWordList.add(str);
	        		 favorMeanList.add(hmapAnh_Viet.get(wordTextArea.getText()));
				 }
	        	 else
	        	 {
	        		 if(hmapViet_Anh.get(wordTextArea.getText()) != null)
					 {
		        		 favorWordList.add(str);
		        		 favorMeanList.add(hmapAnh_Viet.get(wordTextArea.getText()));
					 }
	        	 }
	         }
	      }); 
		 
		 cleanButton.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {     
	        	 wordTextArea.setText("");
	        	 meaningTextArea.setText("");
	         }
	      }); 

		 wordTextArea.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub

			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				 int key = e.getKeyCode();

				    if (key == KeyEvent.VK_ENTER) {
				        System.out.println("enter");
				        
			        	 // Nếu người dùng nhập Enter sau khi nhập từ
			        	 if(wordTextArea.getText().contains("\n"))
			        	 {
			        		 wordTextArea.setText(wordTextArea.getText().replace("\n", ""));
			        	 }
			        	 
			        	 // Kiểm tra ngôn ngữ sẽ Translate
			        	 if(cbox1.getSelectedItem().toString() == cbox2.getSelectedItem().toString())
			        	 {
			        		 meaningTextArea.setText(wordTextArea.getText());
			        	 }
			        	 else
			        	 {
			        		 if(cbox1.getSelectedItem().toString().equals("English"))
			        		 {
			        			 if(hmapAnh_Viet.get(wordTextArea.getText()) != null)
		        				 {
			        				 String word = hmapAnh_Viet.get(wordTextArea.getText());
			        				 meaningTextArea.setText(word);
			        				 //Thêm vào list để lưu từ đã tra
			        				 Word w = new Word(wordTextArea.getText());
			        				 
			        				 Date d = new Date();
			        				 w.setCurrentDay(d.getDate(), d.getMonth()+1, d.getYear()+1900);
			        				 saveWordTranslated.add(w);
			        				 
			        				 
		        				 }
		        				 else
		        				 {
		        					 meaningTextArea.setText(wordTextArea.getText());
		        				 }
			        			 
			        		 }
			        		 else
			        		 {
			        			 if(cbox1.getSelectedItem().toString() == "Vietnamese")
			        			 {
			        				 if(hmapViet_Anh.get(wordTextArea.getText()) != null)
			        				 {
			        					 String word = hmapViet_Anh.get(wordTextArea.getText());
			        					 meaningTextArea.setText(word);
			        					//Thêm vào list để lưu từ đã tra
			        					 Word w = new Word(wordTextArea.getText());
				        				 
			        					 Date d = new Date();
				        				 w.setCurrentDay(d.getDate(), d.getMonth()+1, d.getYear()+1900);
				        				 saveWordTranslated.add(w);
				        				 
			        				 }
			        				 else
			        				 {
			        					 meaningTextArea.setText(wordTextArea.getText());
			        				 }
			        			 }
			        			 else
			        			 {
			        				 meaningTextArea.setText("Somethong wrong!!!");
			        			 }
			        		 }
			        	 }
				    }
			}
		});
		 translateButton.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {     
	        	 // Nếu người dùng nhập Enter sau khi nhập từ
	        	 if(wordTextArea.getText().contains("\n"))
	        	 {
	        		 wordTextArea.setText(wordTextArea.getText().replace("\n", ""));
	        	 }
	        	 
	        	 // Kiểm tra ngôn ngữ sẽ Translate
	        	 if(cbox1.getSelectedItem().toString() == cbox2.getSelectedItem().toString())
	        	 {
	        		 meaningTextArea.setText(wordTextArea.getText());
	        	 }
	        	 else
	        	 {
	        		 if(cbox1.getSelectedItem().toString().equals("English"))
	        		 {
	        			 if(hmapAnh_Viet.get(wordTextArea.getText()) != null)
        				 {
	        				 String word = hmapAnh_Viet.get(wordTextArea.getText());
	        				 meaningTextArea.setText(word);
	        				 //Thêm vào list để lưu từ đã tra
	        				 Word w = new Word(wordTextArea.getText());
	        				 
	        				 Date d = new Date();
	        				 w.setCurrentDay(d.getDate(), d.getMonth()+1, d.getYear()+1900);
	        				 saveWordTranslated.add(w);
	        				 
	        				 
        				 }
        				 else
        				 {
        					 meaningTextArea.setText(wordTextArea.getText());
        				 }
	        			 
	        		 }
	        		 else
	        		 {
	        			 if(cbox1.getSelectedItem().toString() == "Vietnamese")
	        			 {
	        				 if(hmapViet_Anh.get(wordTextArea.getText()) != null)
	        				 {
	        					 String word = hmapViet_Anh.get(wordTextArea.getText());
	        					 meaningTextArea.setText(word);
	        					//Thêm vào list để lưu từ đã tra
	        					 Word w = new Word(wordTextArea.getText());
		        				 
	        					 Date d = new Date();
		        				 w.setCurrentDay(d.getDate(), d.getMonth()+1, d.getYear()+1900);
		        				 saveWordTranslated.add(w);
		        				 
	        				 }
	        				 else
	        				 {
	        					 meaningTextArea.setText(wordTextArea.getText());
	        				 }
	        			 }
	        			 else
	        			 {
	        				 meaningTextArea.setText("Somethong wrong!!!");
	        			 }
	        		 }
	        	 }
	        	 
	        	 
	         }
	      }); 
		 
		 
		 
		 languagePanel.add(cbox1);
		 languagePanel.add(tranferButton);
		 languagePanel.add(cbox2);
		 
		 wordPanel.add(scrollPaneWord);
		 
		 translatePanel.add(translateButton);
		 translatePanel.add(cleanButton);
		 translatePanel.add(favoriteButton);
		 meanPanel.add(scrollPaneMean);
		 
		 
	 }
	 public void showStatistical()
	 {
		 String day[]={"Day", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"
				 , "11", "12", "13", "14", "15", "16", "17", "18", "19", "20"
				 , "21", "22", "23", "24", "25", "26", "27", "28", "29", "30"};
		 String month[] = {"Month", "1", "2", "3", "4", "5", "6", "7", "8", "9"
				 , "10", "11", "12"};
		 String year[] = {"Year", "2017", "2018", "2019", "2020"};
		 JLabel fromday = new JLabel("From: ");

		 JComboBox<String> cboxDay1 = new JComboBox<String>(day);
		 JComboBox<String> cboxMonth1 = new JComboBox<String>(month);
		 JComboBox<String> cboxYear1 = new JComboBox<String>(year);
		 
		 fromdayPanel.add(fromday);
		 fromdayPanel.add(cboxDay1);
		 fromdayPanel.add(cboxMonth1);
		 fromdayPanel.add(cboxYear1);
		 
		 JLabel today = new JLabel("     To: ");

		 JComboBox<String> cboxDay2 = new JComboBox<String>(day);
		 JComboBox<String> cboxMonth2 = new JComboBox<String>(month);
		 JComboBox<String> cboxYear2 = new JComboBox<String>(year);
		 
		 todayPanel.add(today);
		 todayPanel.add(cboxDay2);
		 todayPanel.add(cboxMonth2);
		 todayPanel.add(cboxYear2);
		 
		 
		 JLabel nullLabel = new JLabel("");
		 JLabel wordLabel = new JLabel("                 Word");
		 JLabel frequencyLabel = new JLabel("            Frequency");
		 notePanel.add(nullLabel);
		 notePanel.add(wordLabel);
		 notePanel.add(frequencyLabel);
		 
		 
		 JPanel twoButton = new JPanel();
		 twoButton.setLayout(new GridLayout(2, 1));
		 JButton buttonClean = new JButton("Clean");
		 JButton buttonStatis = new JButton("Statistic");
		 //buttonStatis.setPreferredSize(new Dimension(100, 50));
		 twoButton.add(buttonStatis);
		 twoButton.add(buttonClean);
		 buttonStatis.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	        	 WORD.clear();
	        	 COUNT.clear();
	        	 if(cboxDay1.getSelectedIndex() == 0 || cboxMonth1.getSelectedIndex() == 0 ||cboxYear1.getSelectedIndex() == 0 ||
	        			 cboxDay2.getSelectedIndex() == 0 || cboxMonth2.getSelectedIndex() == 0 || cboxYear2.getSelectedIndex() == 0)
	        	 {
	        		 Object[] options = {"OK"};
	        		 JOptionPane.showOptionDialog(mainFrame,"Don't select Day, Month, Year!!!\n",
	        				 	"Warning",
	        				    JOptionPane.CANCEL_OPTION,
	        				    JOptionPane.WARNING_MESSAGE,
	        				    null,
	        				    null,
	        				    options);
	        	 }
	        	 	String time1 = cboxDay1.getSelectedItem().toString() + "/"  
        	 				+ cboxMonth1.getSelectedItem().toString() + "/"  
        	 			+ cboxYear1.getSelectedItem().toString();
	        	 	Date d1 = new Date(time1);
	        	 	System.out.println(time1);
	        	 	String time2 = cboxDay2.getSelectedItem().toString() + "/"  
        	 				+ cboxMonth2.getSelectedItem().toString() + "/"  
        	 			+ cboxYear2.getSelectedItem().toString();
	        	 	Date d2 = new Date(time2);
	        	 	System.out.println(time2);
					
					
					
					for (int i = 0; i < listWord.size(); i++)
					{
						Date dtemp = new Date(listWord.get(i).getDate());
						System.out.println(listWord.get(i).getDate());
						
						if(!d1.after(dtemp) && !d2.before(dtemp)) {
							if(d1.getYear() <= d2.getYear() && d1.getMonth() <= d2.getMonth())
							{
								WORD.addElement(listWord.get(i).getWord());
								COUNT.addElement(listWord.get(i).getCount());
							}
							 
						}
						
						
						/*if(dtemp.after(d1) && dtemp.before(d2)) {
						    System.out.println("year");
						    WORD.addElement(listWord.get(i).getWord());
							COUNT.addElement(listWord.get(i).getCount());
						}*/
					}
	         }
	      }); 
		 
		 buttonClean.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	        	 WORD.clear();
	        	 COUNT.clear();
	         }
	      }); 
		 
		 
		 StatisPanel.add(twoButton);
		 
		 
	     //create the list
		 wordList = new JList<>(WORD);
		 wordList.setPreferredSize(new Dimension(100, 100));
		 wordList.addListSelectionListener(new ListSelectionListener() {
	    	 	@Override
	     		public void valueChanged(ListSelectionEvent e) {
	                if (!e.getValueIsAdjusting()) {
	                    final List selectedValuesList1 = (List) wordList.getSelectedValuesList();
	                   
	                }
	            }
	        });
		 wordList.setPreferredSize(new Dimension(100, 50));
     	 JScrollPane scrollPaneWord1 = 
				 new JScrollPane(wordList, 
						 JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
						 JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
     	
     	StatisPanel.add(scrollPaneWord1);
     	
     	 
		 
		 frequencyList = new JList<>(COUNT);
		 frequencyList.addListSelectionListener(new ListSelectionListener() {
	    	 	@Override
	     		public void valueChanged(ListSelectionEvent e) {
	                if (!e.getValueIsAdjusting()) {
	                    final List selectedValuesList = (List) frequencyList.getSelectedValuesList();
	                    
	                }
	            }
	        });
	     	JScrollPane scrollPaneWord2 = 
					 new JScrollPane(frequencyList, 
							 JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
							 JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	     	StatisPanel.add(scrollPaneWord2);
	 }
	 public void showFavorite()
	 {
		 for(int i = 0; i < favorWordList.size(); i++)
		 {
			 FAVORITE.addElement(favorWordList.get(i));
		 }
		 
		 fList = new JList<>(FAVORITE);
		 fList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		 fList.addListSelectionListener(new ListSelectionListener() {
				
				@Override
				public void valueChanged(ListSelectionEvent e) {
					// TODO Auto-generated method stub
					if (e.getValueIsAdjusting() == false)
					{
						int i = fList.getSelectedIndex();
						Object[] options = {"OK"};
			int n = JOptionPane.showOptionDialog(mainFrame,
			    "Word: " + favorWordList.get(i)
			    + "\nMeaning: " + favorMeanList.get(i),
			    "Meaning",
			    JOptionPane.CANCEL_OPTION,
			    JOptionPane.INFORMATION_MESSAGE,
			    null,
			    null,
			    options);
						//jop.showMessageDialog(dialog, favorWordList.get(i) + "\n" + favorMeanList.get(i));
					}
				}
			});
		 JScrollPane scrollPaneWord = 
				 new JScrollPane(fList, 
						 JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
						 JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
     	listFavorite.add(scrollPaneWord);
	 }
	 public void visible(boolean a)
	 {
		 mainFrame.setVisible(a);
	 }
	 
	 
}
/*String[] columnNames = {"STT",
        "MSSV",
        "Họ và tên",
        "Tuần 1", "Tuần 2", "Tuần 3", "Tuần 4", "Tuần 5",
        "Tuần 6", "Tuần 7", "Tuần 8", "Tuần 9", "Tuần 10",
        "Tuần 11", "Tuần 12", "Tuần 13", "Tuần 14", "Tuần 15"};
Object[][] data = {
	    {"Kathy", "Smith",
	     "Snowboarding", 
	     new Integer(5), new Boolean(false), new Integer(5), new Boolean(false), new Integer(5),
	     new Integer(5), new Boolean(false), new Integer(5), new Boolean(false), new Integer(5),
	     new Integer(5), new Boolean(false), new Integer(5), new Boolean(false), new Integer(5)},
	    {"John", "Doe",
	     "Rowing",
	     new Integer(5), new Boolean(false), new Integer(5), new Boolean(false), new Integer(5),
	     new Integer(5), new Boolean(false), new Integer(5), new Boolean(false), new Integer(5),
	     new Integer(5), new Boolean(false), new Integer(5), new Boolean(false), new Integer(5)},
	    {"Sue", "Black",
	     "Knitting", 
	     new Integer(5), new Boolean(false), new Integer(5), new Boolean(false), new Integer(5),
	     new Integer(5), new Boolean(false), new Integer(5), new Boolean(false), new Integer(5),
	     new Integer(5), new Boolean(false), new Integer(5), new Boolean(false), new Integer(5)},
	    {"Jane", "White",
	     "Speed reading", 
	     new Integer(5), new Boolean(false), new Integer(5), new Boolean(false), new Integer(5),
	     new Integer(5), new Boolean(false), new Integer(5), new Boolean(false), new Integer(5),
	     new Integer(5), new Boolean(false), new Integer(5), new Boolean(false), new Integer(5)},
	    {"Joe", "Brown",
	     "Pool", 
	     new Integer(5), new Boolean(false), new Integer(5), new Boolean(false), new Integer(5),
	     new Integer(5), new Boolean(false), new Integer(5), new Boolean(false), new Integer(5),
	     new Integer(5), new Boolean(false), new Integer(5), new Boolean(false), new Integer(5)}
	};*/
