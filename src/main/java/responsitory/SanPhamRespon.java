package responsitory;

import jakarta.persistence.Query;
import model.SanPham;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utility.HibernateUtil;

import java.util.ArrayList;
import java.util.Collections;

public class SanPhamRespon {
    ArrayList<SanPham> listSP=new ArrayList<>();

    public ArrayList<SanPham> getListSP() {
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query= session.createQuery("FROM SanPham ");
            listSP= (ArrayList<SanPham>) query.getResultList();
            Collections.sort(listSP,(SanPham o1,SanPham o2) ->catMa(o1.getMa())>catMa(o2.getMa())?1:-1);
        }catch (Exception e){
            e.printStackTrace();
        }
        return listSP;
    }
    private int catMa(String ma) {
        String chuSo = ma.substring(1);
        int so = Integer.valueOf(chuSo);
        return so;
    }
    public SanPham getOneSP(String id){
        SanPham sp=null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            sp=session.get(SanPham.class,id);
        }catch (Exception e){
            e.printStackTrace();
        }
        return sp;
    }
    public void addSP(SanPham sp){
        Transaction transaction=null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction=session.beginTransaction();
            session.save(sp);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void updateSP(SanPham sp){
        Transaction transaction=null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction=session.beginTransaction();
            session.merge(sp);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void deleteSP(SanPham sp){
        Transaction transaction=null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction=session.beginTransaction();
            session.delete(sp);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
