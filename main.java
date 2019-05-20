import java.util.* ;

class Main{
    
	public static void main(String args[]){
        System.out.println("Please Select Account type\n1. Customer\n2. Owner\n3. Admin");
        Scanner readobj = new Scanner(System.in);
		int at;
		at = readobj.nextInt();
        Option op = new Option(at);
    }
}


class Option{
    int ltype;

	Option(int ltype){
		System.out.println("selected option is "+ltype);
        Scanner readobj = new Scanner(System.in);
        System.out.println("Please Select Operation\n1. Login\n2. Register");
        int op = readobj.nextInt();
        UserOption login = new UserOption();
        if (op == 1){
            login.Login(ltype);
        }else if(op == 2){
            login.SignUp(ltype);
        }else{
            System.out.println("invald option");
        }
    }
}


class UserOption{
	public void Login(int type){
        System.out.println("login type is "+type);
        System.out.println("------------Option----------");
        Scanner readobj = new Scanner(System.in);
        System.out.print("Enter Username : ");
        String username = readobj.nextLine();
        System.out.print("Enter Password : ");
        String pass = readobj.nextLine();
        //System.out.println("username is "+username+" and password is "+pass);
        Users users = new Users();
        //users.getUser(username, pass);
    }

    public void SignUp(int type){
        Scanner readobj = new Scanner(System.in);
        System.out.println("Welcome to Register page\nPlease enter name");
        String name = readobj.nextLine();
    }
}


class Users{
    Map<String, String> user = new HashMap<String, String>();
    Users(){
        user.put("sachin", "tavarsachin@gmail.com");
        user.put("admin", "admin@gmail.cm");
        System.out.println(user);
    }

    public void getUser(String username, String pass){
        if (user.containsKey(username))  
        { 
            String a = user.get(username);
            if (a.equals(pass)){
                System.out.println("Login Succesfully");
            }else{
                System.out.println("incorrect password");
            } 
        }else{
            System.out.println("User does not exist");
        } 
    }
}
