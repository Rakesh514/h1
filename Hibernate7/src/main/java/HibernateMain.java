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
		
		Vehicle vehicle1 = new Vehicle();
		vehicle1.setModel("i10");
		vehicle1.setRegNumber(5431);
		
		user1.setVehicle(vehicle1);
		
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(user1);
		session.save(vehicle1);
		
		transaction.commit();
		session.close();
	}
}