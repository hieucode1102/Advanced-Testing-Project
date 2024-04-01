package responsitory;

import jakarta.persistence.Query;
import model.NSX;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utility.HibernateUtil;

import java.util.ArrayList;
import java.util.Collections;


public class NSXRespon {
    ArrayList<NSX> listNSX=new ArrayList<>();

    public ArrayList<NSX> getListNSX() {
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query=session.createQuery("FROM NSX ");
            listNSX= (ArrayList<NSX>) query.getResultList();
            Collections.sort(listNSX,(NSX n1, NSX n2) ->catMa(n1.getMa())>catMa(n2.getMa())?1:-1 );
        }catch (Exception e){
            e.printStackTrace();
        }
        return listNSX;
    }
    private int catMa(String ma) {
        String chuSo = ma.substring(1);
        int so = Integer.valueOf(chuSo);
        return so;
    }
    public NSX getOneNSX(String id){
        NSX nsx=null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
           nsx=session.get(NSX.class,id);
        }catch (Exception e){
            e.printStackTrace();
        }
        return nsx;
    }
    public void addNSX(NSX n){
        Transaction transaction=null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction=session.beginTransaction();
            session.save(n);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void updateNSX(NSX n){
        Transaction transaction=null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction=session.beginTransaction();
            session.merge(n);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void deleteNSX(NSX n){
        Transaction transaction=null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction=session.beginTransaction();
            session.delete(n);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
