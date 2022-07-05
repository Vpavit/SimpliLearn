
import java.util.*;
import java.io.*;

public class LockedMe {
	
	public static void Display(String path)
	{
		
		
		List<String> results = new ArrayList<String>();
		File[] files = new File(path).listFiles();
		for (File file : files) {
		    if (file.isFile()) {
		        results.add(file.getName());
		    }
		}
		
		Collections.sort(results);
	boolean ans = results.isEmpty();
	
	if(ans == true)
	{
		System.out.println("directory is empty");
	}
	else {
	
		for(String s:results){
			System.out.println(s);
		}
		}
	
		}
	
	public static void AddFile(String path)
	{
		String filename= new String();
		System.out.println("Enter the File name");
		Scanner sc= new Scanner(System.in);
		filename=sc.nextLine();
		
		File file = new File(path+"\\"+filename);   
		boolean result;  
		
		try   
		{  
		result = file.createNewFile();  
		if(result)       
		{  
		System.out.println("file created "+file.getCanonicalPath());  
		}  
		else  
		{  
		System.out.println("File already exist at location: "+file.getCanonicalPath());  
		}  
		}   
		catch (IOException e)   
		{  
		e.printStackTrace();      
		}         
		
	}
	
	public static void DeleteFile(String path)
	{
		String filename= new String();
		System.out.println("Enter the File name to be deleted");
		Scanner sc= new Scanner(System.in);
		filename=sc.nextLine();
		
		File file = new File(path+"\\"+filename);   
		try  
		{         
		          //file to be delete  
		if(file.delete())                      //returns Boolean value  
		{  
		System.out.println(file.getName() + " deleted");   //getting and printing the file name  
		}  
		else  
		{  
		System.out.println("The file deoes not exist");  
		}  
		}  
		catch(Exception e)  
		{  
		e.printStackTrace();  
		}  
	}
	
	public static void SearchFile(String path)
	{

		Scanner sc= new Scanner(System.in);
		
		int count=0;
		
		File file = new File(path);   
		
		System.out.println("Enter a keyword to search");
        String search = sc.nextLine();

        File arr1[] = file.listFiles();
        for(int a=0;a<arr1.length;a++)
        {
            if(arr1[a].getName().startsWith(search))
            {
                System.out.println(arr1[a]);
                count++;
            }
            
        }
		
        if(count==0)
        {
        	System.out.println("No file found");
        }
        
		
	}
	
	public static String VaildPath() {
		
		String path= new String();
		String path1= new String();
		Scanner sc=new Scanner(System.in);
		 System.out.println("Enter the path");
		  path1 = sc.nextLine();
		 File file = new File(path1);
		 
		 if(file.exists()==true) {
			 System.out.println("path exist");
			path= path1;
		 }
		 else {
			 System.out.println("Enter Valid path");
		 }
		
		 return path;
	}

	public static void main(String[] args) {
		int ch1=0,ch2=0;
		
		String path=new String();
		
		do {
		try {
	    System.out.println("**********Prototype of the Application LockedMe.com**********  \n");
	    System.out.println("**********Developed by Vyshnave Pavithran*********  \n");
		System.out.println("--------------------------------");
		System.out.println("1.Specify the directory");
		System.out.println("2.Display");
		System.out.println("3.File Operation");
		System.out.println("4.Exit");
		System.out.println("--------------------------------");
		
		System.out.println("Enter your Choice: ");
		Scanner sc=new Scanner(System.in);
		System.out.println("--------------------------------");
		
		ch1=sc.nextInt();
		
		if(ch1==1) {
		
			
			path=VaildPath();
			
				 
		}
		
		
		else if(ch1==2) {
			if(path == null || path.length() == 0) {
				 System.out.println("Enter Valid path");
			}
			else
			Display(path);
		
		}
		
		else if(ch1==3) {
			
			if(path == null || path.length() == 0) {
				 System.out.println("Enter Valid path");
			}
			else {
			
			
			System.out.println("--------------------------------");
			System.out.println("1.Add a file");
			System.out.println("2.Delete specified file");
			System.out.println("3.Search");
			System.out.println("4.Main menu");
			
			System.out.println("--------------------------------");
			System.out.println("Enter your Choice: ");
			ch2=sc.nextInt();
			switch(ch2) {
			case 1:
				AddFile(path);
				break;
			case 2:
				DeleteFile(path);
				break;
				
			case 3:
				SearchFile(path);
			case 4:
				break;
				
			default :
				break;
				
			}
				
			}
			
		
		}
		
		else if(ch1==4) {
			
			System.out.println("Terminating the program ");
			break;
			
		}
		
		else
			System.out.println("enter the correct choice");
		}
		
		catch (InputMismatchException ex) {
			
			System.out.println("enter the correct choice ");
		}
			
		
		
		}while(ch1!=4);
		
		
		}
	}
