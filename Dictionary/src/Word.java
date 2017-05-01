
import java.util.Calendar;
import java.util.Date;

public class Word {
	private String word;
	private int day;
	private int month;
	private int year;
	private int count;
	public Word(String word)
	{
		this.word = word;
		count = 0;
	}
	public void setCurrentDay(int a, int b, int c)
	{
		this.day = a;
		this.month = b;
		this.year = c;
	}
	public void setWord(String word)
	{
		this.word = word;
	}
	
	public String getWord()
	{
		return word;
	}
	public String getDate()
	{
		String str = day + "/" + month + "/" + year;
		return str;
	}
	public void addCount()
	{
		count++;
	}
	public int getCount()
	{
		return count;
	}
}
