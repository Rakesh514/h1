import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

public class HibernateMain {
	private static SessionFactory factory;

	public static void main(String[] args) {
		try {

			factory = new AnnotationConfiguration().configure()
					.buildSessionFactory();

		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
		}

		User user1 = new User();
		user1.setId(100);
		user1.setFirstName("Rakesh");
		user1.setLastName("Kumar");
		
		Address address1 = new Address();
		Address address2 = new Address();
		
		address1.setDoorNumber("365");
		address1.setStreetName("Kadri");
		
		address2.setDoorNumber("465");
		address2.setStreetName("BTM");
		
		user1.getListAddresses().add(address1);
		user1.getListAddresses().add(address2);
		
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(user1);
		transaction.commit();
		session.close();
		
		session = factory.openSession();
		transaction = session.beginTransaction();
		user1 = (User) session.get(User.class, 100);
		transaction.commit();
		session.close();
		
		//The below statements are written after session.close() to make sure no requests are sent to database from hibernate
		//when we use getters on the object.
		//Uncommenting 28th line in 'User.java' (Eager initialization, >>..@ElementCollection(fetch=FetchType.EAGER)..<<)
		//throws exception.
		System.out.println("User ID: " + user1.getId());
		System.out.println("User First Name: " + user1.getFirstName());
		System.out.println("User Last Name: " + user1.getLastName());
		System.out.println("User List of Address: " + user1.getListAddresses());
	}
}