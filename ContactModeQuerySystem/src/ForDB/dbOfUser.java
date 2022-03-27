package ForDB;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class dbOfUser {

	public ArrayList<String> user=new ArrayList<>();
	public ArrayList<String> password=new ArrayList<>();
	
	public dbOfUser() 
	{
		File data=new File("d:/test/user.txt");
		if(!data.exists())
		{
			try {
				data.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		Scanner input=null;
		try {
			input = new Scanner(data);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while(input.hasNext())
		{
			user.add(input.next());
			password.add(input.next());
		}
		input.close();
		
	}
	
	public void updata() 
	{
		File data=new File("d:/test/user.txt");
		if(!data.exists())
		{
			try {
				data.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		PrintWriter output=null;
		try {
			output = new PrintWriter(data);
			for(int i=0;i<user.size();i++)
			{
				String str=user.get(i)+" "+password.get(i);
				output.println(str);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		output.close();
		
	}
}
