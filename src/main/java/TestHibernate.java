import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TestHibernate {
    public static void main(String[] args) {
        try (SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory()) {
            Session session = factory.getCurrentSession();
            Employee employee = new Employee("Alexei", "Khudoshyn", "ID", 5000);
            session.beginTransaction();
            session.save(employee);
            session.getTransaction().commit();
        }
    }
}