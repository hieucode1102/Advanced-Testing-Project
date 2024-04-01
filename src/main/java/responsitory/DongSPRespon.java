package responsitory;

import jakarta.persistence.Query;
import model.DongSP;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utility.HibernateUtil;

import java.util.ArrayList;
import java.util.Collections;

public class DongSPRespon {
    ArrayList<DongSP> listDSP=new ArrayList<>();

    public ArrayList<DongSP> getListDSP() {
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query=session.createQuery("FROM DongSP ");
            listDSP= (ArrayList<DongSP>) query.getResultList();
            Collections.sort(listDSP,(DongSP d1, DongSP d2) ->catMa(d1.getMa())>catMa(d2.getMa())?1:-1 );
        }catch (Exception e){
            e.printStackTrace();
        }
        return listDSP;
    }
    private int catMa(String ma) {
        String chuSo = ma.substring(1);
        int so = Integer.valueOf(chuSo);
        return so;
    }
    public DongSP getOneDSP(String id){
        DongSP dsp=null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            dsp=session.get(DongSP.class,id);
        }catch (Exception e){
            e.printStackTrace();
        }
        return dsp;
    }
    public void addDSP(DongSP d){
        Transaction transaction=null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction= session.beginTransaction();
            session.save(d);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void updateDSP(DongSP d){
        Transaction transaction=null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction= session.beginTransaction();
            session.merge(d);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void deleteDSP(DongSP d){
        Transaction transaction=null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction= session.beginTransaction();
            session.delete(d);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
