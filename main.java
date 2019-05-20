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
        if (op == 1){
            Login login = new Login(op);
        }else if(op == 2){
            System.out.println("your reigstering");
        }else{
            System.out.println("invald option");
        }
    }
}


class Login{
	Login(int type){
        System.out.println("login type is "+type);
        System.out.println("------------Option----------");
        Scanner readobj = new Scanner(System.in);
        System.out.print("Enter Username : ");
        String username = readobj.nextLine();
        System.out.print("Enter Password : ");
        String pass = readobj.nextLine();
        //System.out.println("username is "+username+" and password is "+pass);
        Users users = new Users();
        users.getUser(username, pass);
    }
}


class Users{
    Map<String, String> user = new HashMap<String, String>();
    Users(){
        user.put("sachin", "pass");
        user.put("admin", "admin123");
    }

    public void getUser(String username, String pass){
        if (user.containsKey(username))  
        { 
            String a = user.get(username);
            System.out.println("entered password is "+pass+" stored pass is "+a); 
            if (a == pass){
                System.out.println("password for "+username+" = " + a);
            }else{
                System.out.println("incorrect password");
            } 
        }else{
            System.out.println("User does not exist");
        } 
    }
}
