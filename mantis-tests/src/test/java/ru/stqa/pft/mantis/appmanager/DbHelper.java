package ru.stqa.pft.mantis.appmanager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import ru.stqa.pft.mantis.model.UserData;
import ru.stqa.pft.mantis.model.Users;
import java.util.List;


public class DbHelper {
  private final SessionFactory sessionFactory;
  private Users getUsersFromBD;


  public DbHelper() throws Exception {
    final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure()
            .build();
    sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
  }

  public Users users() {
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    List<UserData> result = session.createQuery("from UserData").list();
    session.getTransaction().commit();
    session.close();
    return new Users(result);
  }

  public void refresh(Object o){
    Session session = sessionFactory.openSession();
    session.refresh(o);
    session.close();
  }

  public Users getUsersFromBD() {
    return getUsersFromBD();
  }

  public void setUsersFromBD(Users usersFromBD) {
    this.getUsersFromBD = usersFromBD;
  }
}

