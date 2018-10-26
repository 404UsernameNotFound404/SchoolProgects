
public class Book 
{
	String authorLName, authorFName, title, format, publisher, language;
	int year;
	long numISBN;
	float cost;
	public Book(String allInfo)
	{
		String[] stringArr = allInfo.split(", ");
		authorLName = stringArr[0];
		authorFName	= stringArr[1];
		title = stringArr[2];
		format = stringArr[3];
		publisher = stringArr[4];
		year = Integer.parseInt(stringArr[5]);
		language = stringArr[6];
		numISBN = Long.parseLong(stringArr[7]);
		cost = Float.parseFloat(stringArr[8]);
		
	}
	@Override
	public String toString() 
	{
		//return authorLName + " " + authorFName + " " + title + "\n" + format + " " + publisher + " " + year + " " + language + " " + numISBN + " " + cost ; 
		return authorLName + " " + authorFName + " " + title;
	}
}
