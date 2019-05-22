import java.util.* ;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

class Main{
    
	public static void main(String args[]){
        System.out.println("Please Select Account type\n1. Customer\n2. Owner\n3. Admin");
        Scanner readobj = new Scanner(System.in);
		Integer at;
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
        Users users = new Users();
        if (op == 1){
            users.Login(ltype);
        }else if(op == 2){
            users.SignUp(ltype);
        }else{
            System.out.println("invald option");
        }
    }
}


class Users{
    public static final HashMap<String, HashMap<String, String>> user = new HashMap<String, HashMap<String, String>>();
    public static String LoggedUser;
    Users(){
        user.put("tavarsachin@gmail.com", new HashMap<String, String>());
        user.get("tavarsachin@gmail.com").put("name", "sachin kumar");
        user.get("tavarsachin@gmail.com").put("password", "admin123");
        user.get("tavarsachin@gmail.com").put("address", "kondli delhi");
        user.get("tavarsachin@gmail.com").put("type", "1");
        user.put("owner@gmail.com", new HashMap<String, String>());
        user.get("owner@gmail.com").put("name", "owner sachin");
        user.get("owner@gmail.com").put("password", "admin123");
        user.get("owner@gmail.com").put("type", "2");
        user.put("admin", new HashMap<String, String>());
        user.get("admin").put("password", "admin123");
        user.get("admin").put("type", "3");
    }

    public boolean getUser(String username, String pass, Integer type){
		if (user.containsKey(username))  
        { 
            String a = user.get(username).get("password");
            //Integer getType = Integer.parseInt(user.get(username).get(type));
            //System.out.println("get Type is "+user.get(username).get(type)+" type of "+" and inserted type "+type);
            if (a.equals(pass) && (Integer.parseInt(user.get(username).get("type")) == type)){
                System.out.println("Login Succesfully");
                return true;
            }else{
                System.out.println("Incorrect password or Incorrect account type");
				return false;
            } 
        }else{
            System.out.println("User does not exist");
			return false;
        } 
    }
    

    public boolean setUser(String name, String email, String password, String address, Integer type){
        user.put(email, new HashMap<String, String>());
        user.get(email).put("name", name);
        user.get(email).put("password", password);
        user.get(email).put("address", address);
        user.get(email).put("type", Integer.toString(type));
        System.out.println(name+" you are succefully registered please login");
        return true;
    }

    public String getLoggedUser(){
        return LoggedUser;
    }

    public boolean setLoggedUser(String email){
        LoggedUser = email;
        return true;
    }

    public void Login(int type){
        //System.out.println("login type is "+type);
        while(true){  
			System.out.println("\n-------------------Login------------------");
		    Scanner readobj = new Scanner(System.in);
		    System.out.print("Enter Username : ");
		    String username = readobj.nextLine();
		    System.out.print("Enter Password : ");
		    String pass = readobj.nextLine();
		    System.out.println("------------------------------------------\n");
		    if(this.getUser(username, pass, type)){
                this.setLoggedUser(username);
		    	if (type == 3){
		    		System.out.println("Your admin menu");
		    	}else{
		    		Restaurant rst = new Restaurant();
		    		rst.chooseRestaurant();
		    	}
		    	break;
		    }  
		}
        //System.out.println("username is "+username+" and password is "+pass);
    }

    public void SignUp(int type){
        Scanner readobj = new Scanner(System.in);
        System.out.println("\n-----------------Welcome to Register page-------------------\nPlease enter name");
        String name = readobj.nextLine();
        System.out.println("Please Enter Email");
        String email = readobj.nextLine();
        System.out.println("Please Enter Password");
        String pass = readobj.nextLine();
        System.out.println("Please Enter Address");
        String add = readobj.nextLine();
        System.out.println("-------------------------------------------------\n");
        this.setUser(name, email, pass, add, type);
        Login(type);
    }
}


class Restaurant{
    public static final HashMap<Integer, HashMap<String, String>> rst = new HashMap<Integer, HashMap<String, String>>();
    public static final HashMap<Integer, HashMap<String, String>> dish = new HashMap<Integer, HashMap<String, String>>();
    public static final HashMap<Integer, Integer> cart = new HashMap<Integer, Integer>();
    Scanner readobj = new Scanner(System.in);
	Users users = new Users();
    Restaurant(){
        rst.put(1, new HashMap<String, String>());
        rst.get(1).put("name", "kesar");
        rst.get(1).put("address", "delhi india");
        rst.get(1).put("contact", "11120392");
        rst.put(2, new HashMap<String, String>());
        rst.get(2).put("name", "haldi ram");
        rst.get(2).put("address", "noida india");
        rst.get(2).put("contact", "222392");
        rst.put(3, new HashMap<String, String>());
        rst.get(3).put("name", "bikaner");
        rst.get(3).put("address", "gurgaon india");
        rst.get(3).put("contact", "3333234234");
        dish.put(1, new HashMap<String, String>());
        dish.get(1).put("name", "chilly potato");
        dish.get(1).put("price", "50");
        dish.get(1).put("rst", "1");
        dish.put(2, new HashMap<String, String>());
        dish.get(2).put("name", "chhole bhature");
        dish.get(2).put("price", "20");
        dish.get(2).put("rst", "1");
        dish.put(3, new HashMap<String, String>());
        dish.get(3).put("name", "pizza");
        dish.get(3).put("price", "60");
        dish.get(3).put("rst", "2");
        dish.put(4, new HashMap<String, String>());
        dish.get(4).put("name", "pasta");
        dish.get(4).put("price", "40");
        dish.get(4).put("rst", "3");
    }
    public void chooseRestaurant(){
        System.out.println("\n-------------Please Select Restaurant--------------------");
        for (Object objectName : rst.keySet()) {
               System.out.println(objectName+"\tName :- "+rst.get(objectName).get("name"));
               System.out.println("\tAddress: "+rst.get(objectName).get("Address")+"\n\tContact : "+rst.get(objectName).get("contact")+"\n");
        }
        System.out.println("----------------------------------------------------------");
        String selectedrst = readobj.nextLine();
        getRestaurantItem(selectedrst);
    }
    
    public void getRestaurantItem(String selectedrst){	
		Integer UserType = Integer.parseInt(users.user.get(users.getLoggedUser()).get("type"));
        System.out.println("\t\t\tMenu\n\n-------------Please Select Item Id--------------------");
        for (Object objectName : dish.keySet()) {
            if(selectedrst.equals(dish.get(objectName).get("rst"))){
               System.out.println("\tId : "+objectName+"\n\tName :- "+dish.get(objectName).get("name"));
               System.out.println("\tPrice: "+dish.get(objectName).get("price")+"\n");
            }
        }
        System.out.println("----------------------------------------------------------");
        Integer selecteditem = readobj.nextInt();
        if (UserType == 1){
            System.out.print("\nPlease Enter Quantities : ");
            Integer qty = readobj.nextInt();
            setItemToCart(selecteditem, qty, selectedrst);
        }else if(UserType == 2){
            System.out.println("Add new item");
        }
    }

    public void getRestaurantByOwner(Integer rid){
    	System.out.println("items "+dish);
    }

    public void setItemToCart(Integer ItemId, Integer qty, String rstID){
        cart.put(ItemId, qty);
        System.out.println("Item aded to your cart");
        System.out.println("\nPlease Select Option\n1. Add more item\n2. Checkout");
        Integer cartop = readobj.nextInt();
        if (cartop == 1){
            getRestaurantItem(rstID);
        }else{
            if(getCheckout()){
                getInvoice();
            }
        }
    }

    public boolean getCheckout(){
        System.out.println("----------------------------Welcome to cart--------------------------");
        System.out.println("\n Item\t\tPrice\t\tQuantity\t\tTotal\n");
        Integer price, gtotal = 0;
        for (Object objectName : cart.keySet()) {
            price = cart.get(objectName)*Integer.parseInt(dish.get(objectName).get("price"));
            gtotal += price;
            System.out.println(dish.get(objectName).get("name")+"\t"+dish.get(objectName).get("price")+"\t\t"+cart.get(objectName)+"\t\t\t"+price);
        }
        System.out.println("\t\t\t\t\t\t----------------------\n\t\t\t\t\t\t\t"+gtotal);
        System.out.println("\n-------------Please Enter Any Character to Continue--------------\n");
        System.out.print("Enter Any Value : ");
		Scanner input = new Scanner(System.in);
        String orderop = input.nextLine();
        if(orderop != null && !orderop.trim().isEmpty()){
            return true;
        }else{
            return false;
        }
    }

    public void getInvoice(){
        System.out.println("\n\n----------------------------------Invoice---------------------------------");
        System.out.println("\n Item\t\tPrice\t\tQuantity\t\tTotal\n");
        Integer price, gtotal = 0;
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	    Date date = new Date();
        for (Object objectName : cart.keySet()) {
            price = cart.get(objectName)*Integer.parseInt(dish.get(objectName).get("price"));
            gtotal += price;
            System.out.println(dish.get(objectName).get("name")+"\t"+dish.get(objectName).get("price")+"\t\t"+cart.get(objectName)+"\t\t\t"+price);
        }
        System.out.println("\t\t\t\t\t\t----------------------\n\t\t\t\t\t\t\t"+gtotal);
        System.out.println("\n-----------------Delivery Detail---------------");
        System.out.println("Name        \t: \t"+users.user.get(users.getLoggedUser()).get("name"));
        System.out.println("Email       \t: \t"+users.getLoggedUser());
        System.out.println("Address     \t: \t"+users.user.get(users.getLoggedUser()).get("address"));
        System.out.println("Date & Time \t: \t"+dateFormat.format(date));
        System.out.println("\n-----------------End of Invoice Thanks for purchasing-------------------\n\n");
    }
}
