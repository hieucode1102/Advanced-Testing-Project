package responsitory;


import jakarta.persistence.Query;
import model.GioHangChiTiet;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utility.HibernateUtil;

import java.util.ArrayList;

public class GioHangChiTietRespon {
    ArrayList<GioHangChiTiet> listGHCT = new ArrayList<>();

    public ArrayList<GioHangChiTiet> getListGHCT() {
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM GioHangChiTiet ");
            listGHCT = (ArrayList<GioHangChiTiet>) query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listGHCT;
    }

    public GioHangChiTiet getOneGHCT(String idGH, String idSP) {
        GioHangChiTiet ghct = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM GioHangChiTiet G WHERE G.gioHang.id=:idGH AND G.chiTietSP.id=:idSP AND G.gioHang.trangThai=0");
            query.setParameter("idGH", idGH);
            query.setParameter("idSP", idSP);

            ghct = (GioHangChiTiet) query.getSingleResult();
            return ghct;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<GioHangChiTiet> getByGH(String idGH) {
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM GioHangChiTiet G WHERE G.gioHang.id=:idGH ");
            query.setParameter("idGH", idGH);
            listGHCT = (ArrayList<GioHangChiTiet>) query.getResultList();
            return listGHCT;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void addGHCT(GioHangChiTiet ghct) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.save(ghct);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
    }

    public void updateGHCT(GioHangChiTiet ghct) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.merge(ghct);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
    }

    public void deleteGHCT(GioHangChiTiet ghct) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(ghct);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
//        GioHangRespon ghr=new GioHangRespon();
//        GioHang gh=new GioHang();
//        ghr.addGH(gh);
//        String id=ghr.addGH(gh);
//        GioHang gh1=new GioHang();
//        gh1.setId("377C804E-521C-4D6C-A2DF-B40913FD5DAA");
//        System.out.println("id là:"+id);
//        System.out.println(gh1);
//        ChiTietSP sp=new ChiTietSP();
//        sp.setId("F2C416F0-F67B-4517-AF0C-39E2E0126C4C");
//        GioHangChiTiet ghct=new GioHangChiTiet();
//        ghct.setGioHang(gh1);
//        ghct.setChiTietSP(sp);
//
//        new GioHangChiTietRespon().addGHCT(ghct);

//            ArrayList<GioHangChiTiet> list=new GioHangChiTietRespon().getByGH("E700CF4C-13D0-4974-B36A-1043099F8CFF");
//        ArrayList<GioHangChiTiet> list=new GioHangChiTietRespon().getListGHCT();
//            list.forEach(s-> System.out.println(s.toString()));
        GioHangChiTiet ghct = new GioHangChiTietRespon().getOneGHCT("E700CF4C-13D0-4974-B36A-1043099F8CFF", "F2C416F0-F67B-4517-AF0C-39E2E0126C4C");
        System.out.println(ghct.toString());
    }
}
