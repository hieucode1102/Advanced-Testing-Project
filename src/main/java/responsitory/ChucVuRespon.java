package responsitory;

import jakarta.persistence.Query;
import model.ChucVu;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utility.HibernateUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class ChucVuRespon {

    ArrayList<ChucVu> listCV = new ArrayList<>();
    public ArrayList<ChucVu> getList() {

        try(Session session= HibernateUtil.getFACTORY().openSession()){
            Query query=session.createQuery("from ChucVu");
            listCV= (ArrayList<ChucVu>) query.getResultList();
            Collections.sort(listCV,(ChucVu c1, ChucVu c2) ->catMa(c1.getMa())>catMa(c2.getMa())?1:-1 );
        }catch (Exception e){
            e.printStackTrace();
        }
        return listCV;
    }
    private int catMa(String ma) {
        String chuSo = ma.substring(2);
        int so = Integer.valueOf(chuSo);
        return so;
    }
    public ChucVu getOne(String id){
        ChucVu cv=null;
        try(Session session= HibernateUtil.getFACTORY().openSession()){
           cv=session.get(ChucVu.class,id);

        }catch (Exception e){
            e.printStackTrace();
        }
        return cv;
    }
    public void addCV(ChucVu cv){
        Transaction transaction=null;
        try(Session session=HibernateUtil.getFACTORY().openSession()){
            transaction=session.beginTransaction();
            session.save(cv);
            transaction.commit();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void updateCV(ChucVu cv){
        Transaction transaction=null;
        try(Session session=HibernateUtil.getFACTORY().openSession()){
            transaction=session.beginTransaction();
            session.merge(cv);
            transaction.commit();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void deleteCV(ChucVu cv){
        Transaction transaction=null;
        try(Session session=HibernateUtil.getFACTORY().openSession()){
            transaction=session.beginTransaction();
            session.delete(cv);
            transaction.commit();

        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
