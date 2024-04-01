package responsitory;

import jakarta.persistence.Query;
import model.ChiTietSP;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utility.HibernateUtil;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ChiTietSPRespon {
    ArrayList<ChiTietSP> listCTSP = new ArrayList<>();

    public ArrayList<ChiTietSP> getListCTSP() {
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM ChiTietSP ");
            listCTSP = (ArrayList<ChiTietSP>) query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listCTSP;
    }

    public ChiTietSP getOneCTSP(String id) {
        ChiTietSP ctsp = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            ctsp = session.get(ChiTietSP.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ctsp;
    }

    public void addCTSP(ChiTietSP ctsp) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.save(ctsp);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
    }

    public void updateCTSP(ChiTietSP ctsp) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.merge(ctsp);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
    }

    public void deleteCTSP(ChiTietSP ctsp) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(ctsp);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
    }

    public ArrayList<ChiTietSP> getByTen(String ten) {
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            if (ten == null) {
                ten = "%";
            } else {
                ten = "%" + ten.replaceAll(" ","") + "%";
            }
            String hql = "FROM ChiTietSP C WHERE REPLACE(CONCAT(C.sanPham.ten,C.mauSac.ten,C.nsx.ten,C.dongSP.ten),' ','') like : ten";
            Query query = session.createQuery(hql);
            query.setParameter("ten", ten);
            listCTSP = (ArrayList<ChiTietSP>) query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listCTSP;
    }
    public ArrayList<ChiTietSP> getByGia(String gs,String ge){
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query=session.createQuery("FROM ChiTietSP C WHERE C.giaBan BETWEEN :gs AND :ge ORDER BY C.giaBan ASC");

            query.setParameter("gs",BigDecimal.valueOf(Double.parseDouble(gs)));
            query.setParameter("ge", BigDecimal.valueOf(Double.parseDouble(ge)));
            listCTSP= (ArrayList<ChiTietSP>) query.getResultList();
        }catch (Exception e){
            e.printStackTrace();
        }
        return listCTSP;
    }
    public ArrayList<ChiTietSP> getByMauSac(String ms){
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query=session.createQuery("FROM ChiTietSP C WHERE C.mauSac.ten =:ms");

            query.setParameter("ms",ms);

            listCTSP= (ArrayList<ChiTietSP>) query.getResultList();
        }catch (Exception e){
            e.printStackTrace();
        }
        return listCTSP;
    }
    public ArrayList<ChiTietSP> getByDanhMuc(String dm){
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query=session.createQuery("FROM ChiTietSP C WHERE C.dongSP.ten =:dm");

            query.setParameter("dm",dm);

            listCTSP= (ArrayList<ChiTietSP>) query.getResultList();
        }catch (Exception e){
            e.printStackTrace();
        }
        return listCTSP;
    }
    public ArrayList<ChiTietSP> sortByTen(){
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM ChiTietSP C ORDER BY C.sanPham.ten ASC");
            listCTSP = (ArrayList<ChiTietSP>) query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listCTSP;
    }
    public ArrayList<ChiTietSP> sortByGiaNho(){
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM ChiTietSP C ORDER BY C.giaBan ASC");
            listCTSP = (ArrayList<ChiTietSP>) query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listCTSP;
    }
    public ArrayList<ChiTietSP> sortByGiaLon(){
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM ChiTietSP C ORDER BY C.giaBan DESC");
            listCTSP = (ArrayList<ChiTietSP>) query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listCTSP;
    }
    public static void main(String[] args) {
        ArrayList<ChiTietSP> list = new ChiTietSPRespon().getListCTSP();
        list.forEach(s -> System.out.println(s.toString()));
    }
}
