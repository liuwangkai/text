package ForDB;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class dbOfContact {

	public ArrayList<String>id=new ArrayList<String>();
	public ArrayList<String>name=new ArrayList<String>();
	public ArrayList<String>contact=new ArrayList<String>();
	public ArrayList<String>department =new ArrayList<String>();
	public int lenght;
	
	public dbOfContact()
	{
		File data=new File("d:/test/data.txt");
		if(!data.exists())
		{
			try {
				data.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		int i=0;
		Scanner input = null;
		try {
			input = new Scanner(data);
			
			while(input.hasNext())
			{
				id.add(input.next());
				name.add(input.next());
				contact.add(input.next());
				department.add(input.next());
				i++;
				
			}
			lenght=i;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		input.close();
	
	}
	
	public void updata() throws FileNotFoundException
	{
		File data=new File("d:/test/data.txt");
		if(!data.exists())
		{
			try {
				data.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		PrintWriter output=new PrintWriter(data);
		for(int i=0;i<id.size();i++)
		{
			String str=id.get(i)+" "+name.get(i)+" "+contact.get(i)+" "+department.get(i)+"";
			output.println(str);
		}
		
		output.close();
	}
}
