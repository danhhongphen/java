import java.io.*;
import java.sql.Savepoint;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.w3c.dom.Node;

public class Dictionary {

	public static HashMap<String, String> hmapAnh_Viet;
	public static HashMap<String, String> hmapViet_Anh;
	
	private static String fileName1 = "Anh_Viet.xml";
	private static String fileName2 = "Viet_Anh.xml";
	protected static GUI swingGUI;
	
	//protected static ArrayList<Word> saveWordTranslated;
	//protected static ArrayList<Word> listWord;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//install hook
		Hook hook = new Hook();
		Thread t1 = new Thread(hook);
		t1.start();
		//hook.HookOpenCloseApp(null);

		swingGUI = new GUI();
		swingGUI.showTranslate();
		swingGUI.showStatistical();
		swingGUI.showFavorite();
		swingGUI.visible(true);
		
		hmapAnh_Viet = new HashMap<String, String>();
		hmapViet_Anh = new HashMap<String, String>();
		
		Dictionary dic = new Dictionary();
		dic.readDictionaryXML(fileName1, hmapAnh_Viet);
		dic.readDictionaryXML(fileName2, hmapViet_Anh);
	}
	
	public void readDictionaryXML(String filename, HashMap<String, String> hmap)
	{
		try {
			File fXmlFile = new File(filename);
		    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		    DocumentBuilder dBuilder = null;
			dBuilder = dbFactory.newDocumentBuilder();
			org.w3c.dom.Document doc = dBuilder.parse(fXmlFile);

			
			//System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
		    NodeList nList = doc.getElementsByTagName("record");
		    //System.out.println("----------------------------");
		    
		    for (int temp = 0; temp < nList.getLength(); temp++) {

		        org.w3c.dom.Node nNode = nList.item(temp);

		        //System.out.println("\nCurrent Element :" + nNode.getNodeName());

		        if (nNode.getNodeType() == Node.ELEMENT_NODE) {

		            org.w3c.dom.Element eElement =  (org.w3c.dom.Element) nNode;

		            //System.out.println("Word : " +  eElement.getElementsByTagName("word").item(0).getTextContent());
		            //System.out.println("Meaning : " + eElement.getElementsByTagName("meaning").item(0).getTextContent());

		            hmap.put(eElement.getElementsByTagName("word").item(0).getTextContent()
		            		, eElement.getElementsByTagName("meaning").item(0).getTextContent());
		        }
		    }
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void readFavoriteXML(String filename, ArrayList<String> wordFavor, ArrayList<String> meanFavor)
	{
		try {
			File fXmlFile = new File(filename);
		    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		    DocumentBuilder dBuilder = null;
			dBuilder = dbFactory.newDocumentBuilder();
			org.w3c.dom.Document doc = dBuilder.parse(fXmlFile);

			
			//System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
		    NodeList nList = doc.getElementsByTagName("record");
		    //System.out.println("----------------------------");
		    
		    for (int temp = 0; temp < nList.getLength(); temp++) {

		        org.w3c.dom.Node nNode = nList.item(temp);

		        //System.out.println("\nCurrent Element :" + nNode.getNodeName());

		        if (nNode.getNodeType() == Node.ELEMENT_NODE) {

		            org.w3c.dom.Element eElement =  (org.w3c.dom.Element) nNode;

		            //System.out.println("Word : " +  eElement.getElementsByTagName("word").item(0).getTextContent());
		            //System.out.println("Meaning : " + eElement.getElementsByTagName("meaning").item(0).getTextContent());

		            wordFavor.add(eElement.getElementsByTagName("word").item(0).getTextContent());
		            meanFavor.add(eElement.getElementsByTagName("meaning").item(0).getTextContent());
		        }
		    }
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void writeXMLFile(String fileName, ArrayList<Word> saveWordTranslated) throws IOException
	{
		try {
			DocumentBuilderFactory dfac = DocumentBuilderFactory.newInstance();
			DocumentBuilder dbui = dfac.newDocumentBuilder();
			Document doc = dbui.newDocument();
			
			// Write root
			Element root = doc.createElement("statistical");
			doc.appendChild(root);
			
			// Write record element
			for (int i = 0; i < saveWordTranslated.size(); i++)
			{
				Element record = doc.createElement("record");
				root.appendChild(record);
				
				Element word = doc.createElement("word");
				word.appendChild(doc.createTextNode(saveWordTranslated.get(i).getWord()));
				record.appendChild(word);
				
				Element meaning = doc.createElement("date");
				meaning.appendChild(doc.createTextNode(saveWordTranslated.get(i).getDate().toString()));
				record.appendChild(meaning);
			}
			
			TransformerFactory tranfac = TransformerFactory.newInstance();
			Transformer transform = tranfac.newTransformer();
			DOMSource src = new DOMSource(doc);
			
			StreamResult result = new StreamResult(new File(fileName));
			
			transform.transform(src, result);

		} catch (ParserConfigurationException e){
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	public void writeFavoriteXMLFile(String fileName, ArrayList<String> wordFavor, ArrayList<String> mean) throws IOException
	{
		try {
			DocumentBuilderFactory dfac = DocumentBuilderFactory.newInstance();
			DocumentBuilder dbui = dfac.newDocumentBuilder();
			Document doc = dbui.newDocument();
			
			// Write root
			Element root = doc.createElement("favorite");
			doc.appendChild(root);
			
			// Write record element
			for (int i = 0; i < wordFavor.size(); i++)
			{
				Element record = doc.createElement("record");
				root.appendChild(record);
				
				Element word = doc.createElement("word");
				word.appendChild(doc.createTextNode(wordFavor.get(i)));
				record.appendChild(word);
				
				Element meaning = doc.createElement("meaning");
				meaning.appendChild(doc.createTextNode(mean.get(i)));
				record.appendChild(meaning);
			}
			
			TransformerFactory tranfac = TransformerFactory.newInstance();
			Transformer transform = tranfac.newTransformer();
			DOMSource src = new DOMSource(doc);
			
			StreamResult result = new StreamResult(new File(fileName));
			
			transform.transform(src, result);

		} catch (ParserConfigurationException e){
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	public void readXMLFile(String fileName, ArrayList<Word> listWord, ArrayList<Word> saveWordTranslated)
	{
		
		try {
			DocumentBuilderFactory dfac = DocumentBuilderFactory.newInstance();
			DocumentBuilder dbui = dfac.newDocumentBuilder();
			Document doc = dbui.parse(new File(fileName));
			
			
			NodeList nList = doc.getElementsByTagName("record");
			
			
			for (int i = 0; i < nList.getLength(); i++)
			{
				Node temp = nList.item(i);
				
				if (temp.getNodeType() == Node.ELEMENT_NODE)
				{
					Element first = (Element) temp;

					String str1 = first.getElementsByTagName("word").item(0).getTextContent();
					String str2 = first.getElementsByTagName("date").item(0).getTextContent();
					Word w = new Word(str1);
					
					
					String[] list = str2.split("/");
					
					w.setCurrentDay(Integer.parseInt(list[0]) , Integer.parseInt(list[1]), Integer.parseInt(list[2]));
					
					if(listWord.size() == 0)
					{
						
						listWord.add(w);
						listWord.get(0).addCount();
						System.out.println("bằng ko");
					}
					else
					{
						System.out.println("Listword size: " + listWord.size());
						for(int j = 0; j < listWord.size(); j++)
						{
							if(listWord.get(j).getWord().equals(str1))
							{
								System.out.println("Cong");
								listWord.get(j).addCount();
								break;
							}
							else
							{
								if(j == listWord.size() - 1)
								{
									System.out.println("Them moi");
									listWord.add(w);
								}
								
							}
						}
					}
					
					
					saveWordTranslated.add(w);
				}
				
			}
		
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
