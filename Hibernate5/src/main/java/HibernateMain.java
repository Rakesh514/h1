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
	}
}