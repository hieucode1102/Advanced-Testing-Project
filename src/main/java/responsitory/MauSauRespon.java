package responsitory;

import jakarta.persistence.Query;
import model.ChucVu;
import model.MauSac;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utility.HibernateUtil;

import java.util.ArrayList;
import java.util.Collections;


public class MauSauRespon {
    ArrayList<MauSac> listMS=new ArrayList<>();

    public ArrayList<MauSac> getListMS() {
        try(Session session= HibernateUtil.getFACTORY().openSession()) {
            Query query=session.createQuery("FROM MauSac ");
            listMS= (ArrayList<MauSac>) query.getResultList();
            Collections.sort(listMS,(MauSac m1, MauSac m2) ->catMa(m1.getMa())>catMa(m2.getMa())?1:-1 );
        }catch (Exception e){
            e.printStackTrace();
        }
        return listMS;
    }
    private int catMa(String ma) {
        String chuSo = ma.substring(1);
        int so = Integer.valueOf(chuSo);
        return so;
    }
    public MauSac getOneMS(String id){
        MauSac ms=null;
        try(Session session= HibernateUtil.getFACTORY().openSession()) {
           ms=session.get(MauSac.class,id);
        }catch (Exception e){
            e.printStackTrace();
        }
        return ms;
    }
    public void addMS(MauSac ms){
        Transaction transaction=null;
        try(Session session=HibernateUtil.getFACTORY().openSession()) {
            transaction=session.beginTransaction();
            session.save(ms);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void updateMS(MauSac ms){
        Transaction transaction=null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction=session.beginTransaction();
            session.merge(ms);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void deleteMS(MauSac ms){
        Transaction transaction=null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction=session.beginTransaction();
            session.delete(ms);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
