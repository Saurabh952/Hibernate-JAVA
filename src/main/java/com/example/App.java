package com.example;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

 

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
    	System.out.println( "Hello World!" );
        Configuration cfg=new Configuration();
        cfg.configure("/com/example/hibernate.cfg.xml");
        SessionFactory factory=cfg.buildSessionFactory();
        System.out.println(factory);
        
        Student st=new Student();
        st.setId(4);
        st.setName("Saurabh");
        st.setCity("Jaunpur");
        
        //Creating Address Object
        
        Address ad=new Address();
        ad.setStreet("Street1");
        ad.setCity("Delhi");
        ad.setOpen(true);
        ad.setAddedDate(new Date());
        ad.setX(1222);
        FileInputStream fis= new FileInputStream("src/main/java/bg.png");        
        byte[] date=new byte[fis.available()];
        fis.read(date);
        ad.setImage(date);
        
        
        
        
        Session session=factory.getCurrentSession();
        
        Transaction tx=session.beginTransaction();
        session.save(st);
        session.save(ad);
         tx.commit();
        session.close();
        System.out.println( "Done" );
    }
}
