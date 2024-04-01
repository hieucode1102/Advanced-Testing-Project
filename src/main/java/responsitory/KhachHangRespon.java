package responsitory;

import jakarta.persistence.Query;
import model.KhachHang;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utility.HibernateUtil;

import java.util.ArrayList;
import java.util.Collections;

public class KhachHangRespon {
    ArrayList<KhachHang> listKH=new ArrayList<>();

    public ArrayList<KhachHang> getListKH() {
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query=session.createQuery("FROM KhachHang ");
            listKH= (ArrayList<KhachHang>) query.getResultList();
            Collections.sort(listKH,(KhachHang o1,KhachHang o2) -> catMa(o1.getMa())>catMa(o2.getMa())?1:-1);
        }catch (Exception e){
            e.printStackTrace();
        }
        return listKH;
    }
    private int catMa(String ma) {
        String chuSo = ma.substring(2);
        int so = Integer.valueOf(chuSo);
        return so;
    }
    public KhachHang getOneKH(String id){
        KhachHang kh=null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query=session.createQuery("FROM KhachHang K WHERE K.id=:id");
            query.setParameter("id",id);
            kh= (KhachHang) query.getSingleResult();
//            kh=session.get(KhachHang.class,id);
        }catch (Exception e){
            e.printStackTrace();
        }
        return kh;
    }
    public boolean addKH(KhachHang kh){
        Transaction transaction=null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction=session.beginTransaction();
            session.save(kh);
            transaction.commit();

        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return  true;
    }
    public boolean updateKH(KhachHang kh){
        Transaction transaction=null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction=session.beginTransaction();
            session.merge(kh);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return  true;

    }
    public boolean deleteKH(KhachHang kh){
        Transaction transaction=null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction=session.beginTransaction();
            session.delete(kh);
            transaction.commit();
            return  true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
    public KhachHang login(String user, String pass){
        KhachHang khachHang= new KhachHang();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            String hql="from  KhachHang where ma =: tk and  matKhau =: mk";
            Query query =session.createQuery(hql);
            query.setParameter("tk",user);
            query.setParameter("mk",pass);
            khachHang= (KhachHang) query.getSingleResult();
        }catch (Exception e ){
            e.printStackTrace();
        }
        return khachHang;
    }

    public static void main(String[] args) {
        KhachHang kh=new KhachHangRespon().getOneKH("5018705B-EE1D-4D9D-A6FC-04B999E29539");
        System.out.println(kh.toString());
    }
}
