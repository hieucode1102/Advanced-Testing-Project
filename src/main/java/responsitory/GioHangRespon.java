package responsitory;

import jakarta.persistence.Query;
import model.GioHang;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utility.HibernateUtil;

import java.util.ArrayList;

public class GioHangRespon {
    ArrayList<GioHang> listGH=new ArrayList<>();

    public ArrayList<GioHang> getListGH() {
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query=session.createQuery("FROM GioHang ");
            listGH= (ArrayList<GioHang>) query.getResultList();
        }catch(Exception e){
            e.printStackTrace();
        }
        return listGH;
    }
    public GioHang getOneGH(String id){
        GioHang gh=new GioHang();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            gh=session.get(GioHang.class,id);
        }catch(Exception e){
            e.printStackTrace();
        }
        return gh;
    }
    public GioHang getOneByKH(String id){
        GioHang gh=null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query=session.createQuery("FROM GioHang G WHERE G.khachHang.id =:id AND G.trangThai=0");
            query.setParameter("id",id);
                gh= (GioHang) query.getSingleResult();
            return gh;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public String addGH(GioHang gh){
        Transaction transaction=null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction=session.beginTransaction();
            session.save(gh);
            transaction.commit();
            return (String) session.save(gh);
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }
        return null;
    }
    public void updateGH(GioHang gh){
        Transaction transaction=null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction=session.beginTransaction();
            session.merge(gh);
            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }
    }
    public void deleteGH(GioHang gh){
        Transaction transaction=null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction=session.beginTransaction();
            session.delete(gh);
            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        System.out.println(new GioHangRespon().getOneByKH("5018705B-EE1D-4D9D-A6FC-04B999E29539").toString());
//        ArrayList<GioHang> list=new GioHangRespon().getListGH();
//        list.forEach(s-> System.out.println(s.toString()));

    }
}
