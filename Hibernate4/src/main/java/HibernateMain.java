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

		User user = new User();
		user.setFirstName("Rakesh");
		user.setLastName("Kumar");

		Address localAddress = new Address();
		localAddress.setDoorNumber("#465");
		localAddress.setStreetName("BTM");
		
		user.setLocal_address(localAddress);
		
		Address permanentAddress = new Address();
		permanentAddress.setDoorNumber("#301");
		permanentAddress.setStreetName("Kadri");
		
		user.setPermanent_address(permanentAddress);
		
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(user);
		transaction.commit();
		session.close();
	}
}