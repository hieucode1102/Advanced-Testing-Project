package responsitory;

import jakarta.persistence.Query;
import model.HoaDonChiTiet;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utility.HibernateUtil;

import java.util.ArrayList;

public class HoaDonChiTietRespon {
    ArrayList<HoaDonChiTiet> listHDCT=new ArrayList<>();

    public ArrayList<HoaDonChiTiet> getListHDCT() {
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query=session.createQuery("FROM HoaDonChiTiet ");
            listHDCT= (ArrayList<HoaDonChiTiet>) query.getResultList();
            return listHDCT;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public ArrayList<HoaDonChiTiet> getAllHDCTByHD(String id){
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query=session.createQuery("FROM HoaDonChiTiet H WHERE H.hoaDon.id=:id");
            query.setParameter("id",id);
            listHDCT= (ArrayList<HoaDonChiTiet>) query.getResultList();
            return listHDCT;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public HoaDonChiTiet getOneHDCT(String idHD,String idSP){
        HoaDonChiTiet hdct=null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query=session.createQuery("FROM HoaDonChiTiet H WHERE H.hoaDon.id=:idHD AND H.chiTietSP.id=:idSP");
            query.setParameter("idHD",idHD);
            query.setParameter("idSP",idSP);
            hdct= (HoaDonChiTiet) query.getSingleResult();
            return hdct;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public void addHDCT(HoaDonChiTiet hdct){
        Transaction transaction=null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction=session.beginTransaction();
            session.save(hdct);
            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }
    }
    public void updateHDCT(HoaDonChiTiet hdct){
        Transaction transaction=null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction=session.beginTransaction();
            session.merge(hdct);
            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }
    }
    public void deleteHDCT(HoaDonChiTiet hdct){
        Transaction transaction=null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction=session.beginTransaction();
            session.delete(hdct);
            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ArrayList<HoaDonChiTiet> lits=new HoaDonChiTietRespon().getAllHDCTByHD("8BFCA1B4-4DF7-438E-90E5-387BDD88EBBD");
        lits.forEach(s-> System.out.println(s.toString()));
    }
}
