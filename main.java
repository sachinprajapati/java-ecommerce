import java.util.* ;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

class Main{
    
	public static void main(String args[]){
        Option op = new Option();
        op.LoginType();
    }
}


class Option{
    int ltype;
    
    public void LoginType(){
    	System.out.println("\nPlease Select Account type\n1. Customer\n2. Owner\n3. Admin");
        Scanner readobj = new Scanner(System.in);
		Integer at;
		at = readobj.nextInt();
		SelectOption(at);
    }

	public void SelectOption(int ltype){
        Users users = new Users();
        if(ltype == 3){
            users.Login(ltype);
        }else{
			System.out.println("selected option is "+ltype);
		    Scanner readobj = new Scanner(System.in);
		    System.out.println("Please Select Operation\n1. Login\n2. Register");
		    int op = readobj.nextInt();
		    if (op == 1){
		        users.Login(ltype);
		    }else if(op == 2){
		        users.SignUp(ltype);
		    }else{
		        System.out.println("invald option");
		    }
        }
    }
}


class Users{
    public static final HashMap<String, HashMap<String, String>> user = new HashMap<String, HashMap<String, String>>();
    private static String LoggedUser;
    Users(){
        user.put("sachin@gmail.com", new HashMap<String, String>());
        user.get("sachin@gmail.com").put("name", "sachin kumar");
        user.get("sachin@gmail.com").put("password", "admin123");
        user.get("sachin@gmail.com").put("address", "kondli delhi");
        user.get("sachin@gmail.com").put("type", "1");
        user.put("kartik@gmail.com", new HashMap<String, String>());
        user.get("kartik@gmail.com").put("name", "Kartik Tomar");
        user.get("kartik@gmail.com").put("password", "kartik123");
        user.get("kartik@gmail.com").put("address", "44, Clayton, vic, 3168");
        user.get("kartik@gmail.com").put("type", "1");
        user.put("anand@gmail.com", new HashMap<String, String>());
        user.get("anand@gmail.com").put("name", "Anand Prakash");
        user.get("anand@gmail.com").put("password", "anand123");
        user.get("anand@gmail.com").put("address", "44, Clayton, vic, 3168");
        user.get("anand@gmail.com").put("type", "1");
        user.put("sumit@gmail.com", new HashMap<String, String>());
        user.get("sumit@gmail.com").put("name", "Sumit Garg");
        user.get("sumit@gmail.com").put("password", "sumit123");
        user.get("sumit@gmail.com").put("address", "12, Duncan rd, newpoint, vic, 3122");
        user.get("sumit@gmail.com").put("type", "1");
        user.put("owner@gmail.com", new HashMap<String, String>());
        user.get("owner@gmail.com").put("name", "owner sachin");
        user.get("owner@gmail.com").put("password", "admin123");
        user.get("owner@gmail.com").put("type", "2");
        user.put("carla@gmail.com", new HashMap<String, String>());
        user.get("carla@gmail.com").put("name", "Carla Bruni");
        user.get("carla@gmail.com").put("password", "carla123");
        user.get("carla@gmail.com").put("type", "2");
        user.put("raghav@gmail.com", new HashMap<String, String>());
        user.get("raghav@gmail.com").put("name", "Raghav Sethi");
        user.get("raghav@gmail.com").put("password", "raghav123");
        user.get("raghav@gmail.com").put("type", "2");
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

    public boolean checkUser(String email){
        //System.out.println("check user "+user.get(email));
        if(user.get(email) == null){
            return false;
        }
        return true;
    }

    public void getUsers(){
		System.out.println("----------------------------Delete Users--------------------------");
		System.out.println("\n Name\t\t\tEmail\t\t\t\tAddress\t\t\t\tRole\n");
		String role = "Customer";
		Integer type;
		for (Object objectName : user.keySet()) {
			type = Integer.parseInt(user.get(objectName).get("type"));
			if(type == 2){
				role = "Owner";
			}
			if(Integer.parseInt(user.get(objectName).get("type")) != 3){
				System.out.println(user.get(objectName).get("name")+"\t\t"+objectName+"\t\t\t"+user.get(objectName).get("address")+"\t\t\t"+role);
			}
		}

        System.out.println("\n1. Delete User\n2. Logout\n");
        Scanner dltop = new Scanner(System.in);
		Integer dlop = dltop.nextInt();
		if(dlop == 1){
		    while(true){
		        System.out.print("\nPlease Enter User email for delete : ");
		        Scanner Userop = new Scanner(System.in);
				String email = Userop.nextLine();
		        if(checkUser(email)){
		            user.remove(email);
		            System.out.println("Deleted user "+email);
		            getUsers();
		        }else{
		            System.out.println("User Does not exist");
		        }
		    }
		}else{
			setLoggedUser(null);
        	Option op = new Option();
        	op.LoginType();
		}

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
		    		getUsers();
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
        System.out.print("\n-----------------Welcome to Register page-------------------\nPlease enter name : ");
        String name = readobj.nextLine();
        System.out.print("Please Enter Email : ");
        String email = readobj.nextLine();
        System.out.print("Please Enter Password : ");
        String pass = readobj.nextLine();
        System.out.print("Please Enter Address : ");
        String add = readobj.nextLine();
        System.out.println("\n-------------------------------------------------\n");
        this.setUser(name, email, pass, add, type);
        Login(type);
    }
}


class Restaurant{
    public static final HashMap<Integer, HashMap<String, String>> rst = new HashMap<Integer, HashMap<String, String>>();
    public static final HashMap<Integer, HashMap<String, String>> dish = new HashMap<Integer, HashMap<String, String>>();
    public static final HashMap<Integer, Integer> cart = new HashMap<Integer, Integer>();
    public static Integer itemnumber = 11;
    Scanner readobj = new Scanner(System.in);
	Users users = new Users();
    Restaurant(){
        rst.put(1, new HashMap<String, String>());
        rst.get(1).put("name", "Derby Thai");
        rst.get(1).put("address", "4, Derby Rd, Caulfield East, VIC, 3145");
        rst.get(1).put("owner", "owner@gmail.com");
        rst.put(2, new HashMap<String, String>());
        rst.get(2).put("name", "KFC");
        rst.get(2).put("address", "13-14, Sir John Monash Dr, Caulfield, VIC, 3145");
        rst.get(2).put("owner", "owner@gmail.com");
        rst.put(3, new HashMap<String, String>());
        rst.get(3).put("name", "EC Kitchen");
        rst.get(3).put("address", "1 Sir John Monash Dr, Caulfield East, VIC, 3145");
        rst.get(3).put("owner", "owner@gmail.com");
        dish.put(1, new HashMap<String, String>());
        dish.get(1).put("name", "Chilly Potato");
        dish.get(1).put("price", "10");
        dish.get(1).put("rst", "1");
        dish.put(2, new HashMap<String, String>());
        dish.get(2).put("name", "Fried Rice");
        dish.get(2).put("price", "8");
        dish.get(2).put("rst", "1");
        dish.put(3, new HashMap<String, String>());
        dish.get(3).put("name", "Tofu");
        dish.get(3).put("price", "6");
        dish.get(3).put("rst", "1");
        dish.put(4, new HashMap<String, String>());
        dish.get(4).put("name", "Burger");
        dish.get(4).put("price", "5");
        dish.get(4).put("rst", "2");
        dish.put(5, new HashMap<String, String>());
        dish.get(5).put("name", "Chicken");
        dish.get(5).put("price", "6");
        dish.get(5).put("rst", "2");
        dish.put(6, new HashMap<String, String>());
        dish.get(6).put("name", "Fries");
        dish.get(6).put("price", "4");
        dish.get(6).put("rst", "2");
        dish.put(7, new HashMap<String, String>());
        dish.get(7).put("name", "Coke");
        dish.get(7).put("price", "3");
        dish.get(7).put("rst", "2");
        dish.put(8, new HashMap<String, String>());
        dish.get(8).put("name", "Chilly Potato");
        dish.get(8).put("price", "10");
        dish.get(8).put("rst", "2");
        dish.put(9, new HashMap<String, String>());
        dish.get(9).put("name", "Fried Rice");
        dish.get(9).put("price", "8");
        dish.get(9).put("rst", "2");
        dish.put(10, new HashMap<String, String>());
        dish.get(10).put("name", "Tofu");
        dish.get(10).put("price", "6");
        dish.get(10).put("rst", "2");
    }
    public void chooseRestaurant(){
        System.out.println("\n-------------Please Select Restaurant--------------------");
        for (Object objectName : rst.keySet()) {
               System.out.println(objectName+"\tName :- "+rst.get(objectName).get("name"));
               System.out.println("\tAddress: "+rst.get(objectName).get("Address")+"\n\tContact : "+rst.get(objectName).get("contact")+"\n");
        }
        System.out.println("----------------------------------------------------------");
        Scanner readobj = new Scanner(System.in);
        String selectedrst = readobj.nextLine();
        getRestaurantItem(selectedrst);
    }
   
    public boolean getRstItemExist(String selectedrst, Integer ItemId){
        boolean itemExist = false;
        for (Object objectName : dish.keySet()) {
            if((objectName == ItemId) && (dish.get(objectName).get("rst").equals(selectedrst))){
                itemExist = true;
            }
        }
        return itemExist;

    }

    public void getRestaurantItem(String selectedrst){	
		Integer UserType = Integer.parseInt(users.user.get(users.getLoggedUser()).get("type"));
        System.out.println("\t\t\tMenu\n\n-------------Please Select Item Id--------------------");
        for (Object objectName : dish.keySet()) {
            if(selectedrst.equals(dish.get(objectName).get("rst"))){
               System.out.println("\tId : "+objectName+"\n\tName :- "+dish.get(objectName).get("name"));
               System.out.println("\tPrice: $"+dish.get(objectName).get("price")+"\n");
            }
        }
        System.out.println("----------------------------------------------------------");
        if (UserType == 1){
            while(true){
                System.out.print("Please Select Item : ");
                Integer selecteditem = readobj.nextInt();
                if(getRstItemExist(selectedrst, selecteditem)){
                    System.out.print("\nPlease Enter Quantities : ");
                    Integer qty = readobj.nextInt();
                    setItemToCart(selecteditem, qty, selectedrst);
                    break;
                }else{
                    System.out.println("Item Not Exists");
                }
            }
        }else if(UserType == 2){
            while(true){
				System.out.println("\n1. Add Item\n2. Delete Item\n3. Lgout\n");
				Scanner readitem = new Scanner(System.in);
				Integer Itemoption = readitem.nextInt();
				if (Itemoption == 1){
					Scanner dishobj = new Scanner(System.in);
					System.out.print("Please Enter Dish Name : ");
					String name = dishobj.nextLine();
					System.out.print("Please Enter Dish Price : ");
					String price = dishobj.nextLine();
					dish.put(itemnumber, new HashMap<String, String>());
					dish.get(itemnumber).put("name", name);
					dish.get(itemnumber).put("price", price);
					dish.get(itemnumber).put("rst", selectedrst);
					itemnumber += 1;
					chooseRestaurant();
				}else if(Itemoption == 2){
					Scanner readid = new Scanner(System.in);
					Integer itemId = readid.nextInt();
					if(ItemExist(itemId)){
						dish.remove(itemId);
						System.out.println("\nitem deleted\n");
						System.out.println("1. Logout\n2. Select Restaurent");
						Scanner finalobj = new Scanner(System.in);
						Integer cont = finalobj.nextInt();
						if (cont == 1){
							users.setLoggedUser(null);
							Option op = new Option();
							op.LoginType();
						}else{
							chooseRestaurant();
						}
		                //break;
					}else{
						System.out.println("item not exists");
					}
				}else{
					users.setLoggedUser(null);
					Option op = new Option();
					op.LoginType();	
				}
			}
        }
    }

    public boolean ItemExist(Integer itemId){
		if(dish.get(itemId) == null){
			return false;	
		}
		return true;	
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
            System.out.println(dish.get(objectName).get("name")+"\t$"+dish.get(objectName).get("price")+"\t\t"+cart.get(objectName)+"\t\t\t$"+price);
        }
        System.out.println("\t\t\t\t\t\t----------------------\n\t\t\t\t\t\t\t$"+gtotal);
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
            System.out.println(dish.get(objectName).get("name")+"\t$"+dish.get(objectName).get("price")+"\t\t"+cart.get(objectName)+"\t\t\t$"+price);
        }
        System.out.println("\t\t\t\t\t\t----------------------\n\t\t\t\t\t\t\t"+gtotal);
        System.out.println("\n-----------------Delivery Detail---------------");
        System.out.println("Name        \t: \t"+users.user.get(users.getLoggedUser()).get("name"));
        System.out.println("Email       \t: \t"+users.getLoggedUser());
        System.out.println("Address     \t: \t"+users.user.get(users.getLoggedUser()).get("address"));
        System.out.println("Date & Time \t: \t"+dateFormat.format(date));
        System.out.println("\n-----------------End of Invoice Thanks for purchasing-------------------\n\n");
        System.out.println("1. Logout\n2. Select Restaurent");
        Integer cont = readobj.nextInt();
        if (cont == 1){
        	users.setLoggedUser(null);
        	Option op = new Option();
        	op.LoginType();	
        }else{
            chooseRestaurant();
        }
    }
}
