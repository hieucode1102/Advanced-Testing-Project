package responsitory;

import jakarta.persistence.Query;
import model.NhanVien;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utility.HibernateUtil;

import java.util.ArrayList;

public class NhanVienRespon {
    ArrayList<NhanVien> listNV=new ArrayList<>();

    public ArrayList<NhanVien> getListNV() {
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query=session.createQuery("FROM NhanVien ");
            listNV= (ArrayList<NhanVien>) query.getResultList();
        }catch (Exception e){
            e.printStackTrace();
        }
        return listNV;
    }
    public NhanVien getOneNV(String id){
        NhanVien nv=null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            nv=session.get(NhanVien.class,id);
        }catch (Exception e){
            e.printStackTrace();
        }
        return nv;
    }
    public void addNV(NhanVien nv){
        Transaction transaction=null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction= session.beginTransaction();
            session.save(nv);
            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }
    }
    public void updateNV(NhanVien nv){
        Transaction transaction=null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction= session.beginTransaction();
            session.merge(nv);
            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }
    }
    public void deleteNV(NhanVien nv){
        Transaction transaction=null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction= session.beginTransaction();
            session.delete(nv);
            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ArrayList<NhanVien> list=new NhanVienRespon().getListNV();
        list.forEach(s -> System.out.println(s.toString()) );

    }
}
