package social;


import java.util.ArrayList;
import java.util.Scanner;

public class social_main {
	static ArrayList<user> users = new ArrayList<user>();
	static String name;
	static String lastname;
	static String birthplace;
	static String password;
	static int year;
	static int conn=0;
	static Scanner in = new Scanner(System.in);
	public static void main(String[] args) 
	{
		String input = new String();
		int index;
		System.out.println("///////////////////////Initial//////////////////////////");
		users.add(new user("arek","raj","mad",2003,"123"));
		users.add(new user("pondy","neeru","pondy",2003,"123"));
		users.add(new user("anty","anton","trichy",2004,"123"));
		users.add(new user("dan","dhanush","pondy",2003,"123"));
		users.add(new user("maddy","madhavan","chennai",2004,"123"));
		users.add(new user("deeban","deeb","salem",2003,"123"));
		users.add(new user("rohith","vishwa","palakkad",2004,"123"));
		users.add(new user("aasil","mdx","coimbatore",2003,"123"));
		users.add(new user("hari","swami","salem",2003,"123"));
		users.add(new user("dev","pras","thiruppur",2004,"123"));
		
		addfriend(users.get(0), users.get(1));
		addfriend(users.get(1), users.get(0));
		
		addfriend(users.get(0), users.get(2));
		addfriend(users.get(2), users.get(0));
		
		addfriend(users.get(0), users.get(3));
		addfriend(users.get(3), users.get(0));
		
		addfriend(users.get(1), users.get(3));
		addfriend(users.get(3), users.get(1));
		
		addfriend(users.get(0), users.get(5));
		addfriend(users.get(5), users.get(0));
		
		addfriend(users.get(1), users.get(5));
		addfriend(users.get(5), users.get(1));
		
		addfriend(users.get(2), users.get(7));
		addfriend(users.get(7), users.get(2));
		
		addfriend(users.get(5), users.get(7));
		addfriend(users.get(7), users.get(5));
		
		addfriend(users.get(9), users.get(7));
		addfriend(users.get(7), users.get(9));
		
		addfriend(users.get(1), users.get(4));
		addfriend(users.get(4), users.get(1));
		
		addfriend(users.get(4), users.get(5));
		addfriend(users.get(5), users.get(4));
		
		addfriend(users.get(4), users.get(2));
		addfriend(users.get(2), users.get(4));
		
		addfriend(users.get(2), users.get(8));
		addfriend(users.get(8), users.get(2));
		
		addfriend(users.get(8), users.get(5));
		addfriend(users.get(5), users.get(8));
		
		addfriend(users.get(8), users.get(1));
		addfriend(users.get(1), users.get(8));
		
		addfriend(users.get(1), users.get(6));
		addfriend(users.get(6), users.get(1));

		showall(users,"friends");
		System.out.println("////////////////////////////////////////////////////////");
		
		
		while(true)
		{
			System.out.println(  ""
					         + "\r1: Create new account"
					         + "\r2: Log in          "
					         + "\r//////////////////////////////");
			System.out.print("Please select 1, 2 : ");
			input = in.next();
			switch (input) 
			{
			case "1" :
				System.out.print("Name: ");
				name=in.next();
				System.out.print("LastName: ");
				lastname=in.next();
				System.out.print("Birthplace: ");
				birthplace=in.next();
				System.out.print("year of Birth: ");
				year=in.nextInt();
				System.out.print("password: ");
				password=in.next();
				users.add(new user(name,lastname,birthplace,year,password));
				break;
			case "2" :
				System.out.print("Please input name: ");
				name=in.next();
				index=find(name);
				if(index==-1)
				{
					System.out.println("The user not fount");
				}
				else
				{
					System.out.print("Please input password: ");
					password=in.next();
					if(users.get(index).password.equals(password))
					{
						login(index);
					}
					else
					{
						System.out.println("Password is not true, try again ");
					}
				}
				break;
			default :
				break;
			}
			if (input.equals("exit"))
			{
				break;
			}
		}
		showall(users,"friends");
		
	}
	//////////////////////////login////////////////////////////////////
	public static void login(int index)
	{
		acceptorreject(index, users.get(index));
		//showall(users,"friendrequest");
		String input;
		int num;
		while(true)
		{
			System.out.println("///////////////////////////////////"
					       + "\r1: Show my friends"
						   + "\r2: Friend request "
						   + "\r3: delete         "
						   + "\r4: Block          "
						   + "\r5: Connection     "
						   + "\rlogout            "
						   + "\r//////////////////////////////////");
			System.out.print("Please select any number from 1 to 5: ");
			input = in.next();
			switch (input) 
			{
			case "1" :
				show(users.get(index), "'s friends: ", "friends");
				System.out.println();
			break;
			case "2" :
			System.out.print("Please input name: ");
			name=in.next();
			num=find(name);
				if(num==-1)
				{
					System.out.println("The user not fount");
				}
				else
				{
					if(!search(users.get(num),users.get(index),"friends") 
					&& !search(users.get(num),users.get(index),"friendrequest")
					&& !search(users.get(num),users.get(index),"block")
					&& !search(users.get(index),users.get(num),"block"))
					{
						friendrequest(users.get(num), users.get(index));
						System.out.println("Your friend request has been sent");
					}
					else
					{
						System.out.println("Is not possible");
					}
						//showall(users,"friendrequest");
					
				}
			break;
			case "3" :
				System.out.print("Please input name: ");
				name=in.next();
				num=find(name);
					if(num==-1)
					{
						System.out.println("The user not fount");
					}
					else
					{
						deletefriend(users.get(index), users.get(num));
						deletefriend(users.get(num), users.get(index));
					}
			break;
			case "4" :
				System.out.print("Please input name: ");
				name=in.next();
				num=find(name);
					if(num==-1)
					{
						System.out.println("The user not fount");
					}
					else
					{
						deletefriend(users.get(index), users.get(num));
						deletefriend(users.get(num), users.get(index));
						block(users.get(index), users.get(num));
						showall(users,"block");
					}
			break;
			case "5" :
				System.out.print("Please input name to find connection: ");
				name=in.next();
				num=find(name);
				if(num==-1)
				{
					System.out.println("The user not fount");
				}
				else
				{
					if(!searchname(users.get(index), name))
					{
						conn=0;
						users.get(index).suggestfriend=null;
						connection(users.get(index), index, name);
						if(conn==0)
						{
							System.out.println("No connection between you and "+name+" exist");
						}
						else
						{
							System.out.println(conn+" connection between you and "+name+" exist");
						}
					}
					else
					{
						System.out.println(name+" is your friend");
					}
				}
			break;
			default :
			break;
			}
			if (input.equals("logout"))
			{
				break;
			}
		}
	}
	///////////////////////////////////////////////////////////////////
	//////////////////////////find////////////////////////////////////
	public static int find(String name)
	{
		int j=-1;
		for (int i=0;i<users.size();i++) 
		{
			if(users.get(i).name.equals(name))
			{
				j=i;
				break;
			}
		}
		return j;
	}
	///////////////////////////////////////////////////////////////////
	//////////////////////////addfriend////////////////////////////////
	public static void addfriend(user next,user friend)
	{
		if(next.friends != null)
		{
			addfriend(next.friends, friend);
		}
		else
		{
			next.friends = new user(friend.name);
		}
	}
	///////////////////////////////////////////////////////////////////
	//////////////////////////friendrequest///////////////////////////
	public static void friendrequest(user next,user friend)
	{
		if(next.friendrequest != null)
		{
			friendrequest(next.friendrequest, friend);
		}
		else
		{
			next.friendrequest = new user(friend.name);
		}
	}
	///////////////////////////////////////////////////////////////////
	//////////////////////////acceptorreject///////////////////////////
	public static void acceptorreject(int index,user next)
	{
		String input;
		int num;
		if(next.friendrequest != null)
		{
			num=find(next.friendrequest.name);
			System.out.println("Are you accept "+next.friendrequest.name +" friend request?(Y/N/ignore)");
			input=in.next();
			switch (input) 
			{
			case "y" :
				addfriend(users.get(index), users.get(num));
				addfriend(users.get(num), users.get(index));
				acceptorreject(index, next.friendrequest);
				deletefriendrequest(users.get(index), users.get(num));		
			break;
			case "Y" :
				addfriend(users.get(index), users.get(num));
				addfriend(users.get(num), users.get(index));
				acceptorreject(index, next.friendrequest);
				deletefriendrequest(users.get(index), users.get(num));
			break;
			case "N" :
				acceptorreject(index, next.friendrequest);
				deletefriendrequest(users.get(index), users.get(num));
			break;
			case "n" :
				acceptorreject(index, next.friendrequest);
				deletefriendrequest(users.get(index), users.get(num));
			break;
			default :
				acceptorreject(index, next.friendrequest);
			break;
			}
			
		}
	}
	///////////////////////////////////////////////////////////////////
	//////////////////////////block///////////////////////////////////
	public static void block(user next,user block)
	{
		if(next.block != null)
		{
			block(next.block, block);
		}
		else
		{
			next.block = new user(block.name);
		}
	}
	///////////////////////////////////////////////////////////////////
	
	//////////////////////////deletefriend////////////////////////////////
	public static void deletefriend(user next,user friend)
	{
		if(next.friends != null)
		{
			if(next.friends.name.equals(friend.name))
			{
				user temp=new user();
				temp=next.friends.friends;
				next.friends=temp;
			}
			else
			{
				deletefriend(next.friends,friend);
			}
		}
	}
	///////////////////////////////////////////////////////////////////
	//////////////////////////deletefriendrequest////////////////////////////////
	public static void deletefriendrequest(user next,user friend)
	{
		if(next.friendrequest != null)
		{
			if(next.friendrequest.name.equals(friend.name))
			{
				user temp=new user();
				temp=next.friendrequest.friendrequest;
				next.friendrequest=temp;
			}
			else
			{
				deletefriendrequest(next.friendrequest,friend);
			}
		}
	}

	///////////////////////////////////////////////////////////////////	
	////////////////////////suggestfriend///////////////////////////////
	public static void suggestfriend(user next,String name)
	{
		if(next.suggestfriend != null)
		{
			suggestfriend(next.suggestfriend, name);
		}
		else
		{
			next.suggestfriend = new user(name);
		}
	}
	//////////////////////////deletesuggestfriend////////////////////////////////
	public static void deletesuggestfriend(user next,user friend)
	{
		if(next.suggestfriend != null)
		{
			if(next.suggestfriend.name.equals(friend.name))
			{
				user temp=new user();
				temp=next.suggestfriend.suggestfriend;
				next.suggestfriend=temp;
			}
			else
			{
				deletesuggestfriend(next.suggestfriend,friend);
			}
		}
	}
	///////////////////////////////////////////////////////////////////
	////////////////////////connection/////////////////////////////////
	public static void connection(user u1,int index,String name)
	{
		
		if(u1.friends!=null)
		{
				if(!u1.friends.name.equals(name))
				{
					connection(users.get(find(u1.friends.name)), index, name);
						System.out.print("("+findlength(users.get(index))+")");
						conn++;
						System.out.println("");
						connection(u1.friends, index, name);
					
				}
			else
			{
				connection(u1.friends, index, name);
			}
		}
		
	}
	///////////////////////////////////////////////////////////////////
	///////////////////////////findlength//////////////////////////////
	public static int findlength(user u1)
	{
		int count=0;
		user temp=new user();
		temp=u1;
		while(temp.suggestfriend!=null)
		{
			count++;
			temp=temp.suggestfriend;
		}

		return count;
	}
	///////////////////////////////////////////////////////////////////	
	////////////////////////////searchname/////////////////////////////
	public static boolean searchname(user u1, String name)
	{
		user temp=new user();
		temp=u1;
		boolean flag=false;
		while(temp.friends!=null)
		{
			if(temp.friends.name.equals(name))
			{
				flag=true;
				break;
			}
				temp=temp.friends;
				
		}
		return flag;
	}
	///////////////////////////////////////////////////////////////////	
	//////////////////////////////search//////////////////////////////
	public static boolean search(user u1, user u2, String s)
	{
		user temp=new user();
		temp=u1;
		boolean flag=false;
		while(temp!=null)
		{
			if(temp.name.equals(u2.name))
			{
				flag=true;
				break;
			}
			switch (s)
			{
				case "friends" :	
					temp=temp.friends;
					break;
				case "friendrequest" :
					temp=temp.friendrequest;
					break;
				case "block" :
					temp=temp.block;
					break;
				case "suggestfriend" :
					temp=temp.suggestfriend;
				break;
				default :	
			}
				
		}
		return flag;
	}
	///////////////////////////////////////////////////////////////////
	public static void show(user person, String n,String s)
	{
		if(person != null)
		{
			System.out.print(person.name+n);
			switch (s)
			{
				case "friends" :	
					show(person.friends,", ",s);
				break;
				case "friendrequest" :
					show(person.friendrequest,", ",s);
				break;
				case "block" :
					show(person.block,", ",s);
				break;
				case "suggestfriend" :
					show(person.suggestfriend,", ",s);
				break;
				default :
				break;
			}
		}
		
	}
	public static void showall(ArrayList<user> list, String s)
	{
		
		for (user user : list) 
		{
			show(user," : ",s);
			System.out.println();
		}
	}

}

