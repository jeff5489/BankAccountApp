package MainPackage;

public class Main {

	public static void main(String[] args) {
//		Customer customer = new Customer("Tom", "Smith");
//		customer.getFirstName();
		
		CurrentCustomer.setFirstName("Pope");
		CurrentCustomer.setLastName("John");
		
//		CurrentCustomer.getFirstName();
//		CurrentCustomer.getLastName();
		System.out.println(CurrentCustomer.getFirstName() + " " + CurrentCustomer.getLastName());

	}

}
