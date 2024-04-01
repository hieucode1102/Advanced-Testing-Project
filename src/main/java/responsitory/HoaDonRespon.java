package responsitory;

import jakarta.persistence.Query;
import model.HoaDon;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utility.HibernateUtil;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public class HoaDonRespon {
    ArrayList<HoaDon> listHD=new ArrayList<>();

    public ArrayList<HoaDon> getListHD() {
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query=session.createQuery("FROM HoaDon ");
            listHD= (ArrayList<HoaDon>) query.getResultList();
            return listHD;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public HoaDon getOneHD(String id){
        HoaDon hd=null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            hd=session.get(HoaDon.class,id);
            return hd;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public String addHD(HoaDon hd){
        Transaction transaction=null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction=session.beginTransaction();
            session.save(hd);
            transaction.commit();
            return (String) session.save(hd);
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }
        return null;
    }
    public void updateHD(HoaDon hd){
        Transaction transaction=null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction=session.beginTransaction();
            session.merge(hd);
            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }
    }
    public void deleteHD(HoaDon hd){
        Transaction transaction=null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction=session.beginTransaction();
            session.delete(hd);
            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }

    }
    public ArrayList<Object[]> getThongKe(Date ngayBD,Date ngayKT){
        ArrayList<Object[]> list=new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query=session.createQuery("SELECT HD.id,HD.khachHang.ten,HD.ma,HD.ngayTao,HD.ngayThanhToan,HD.tenNguoiNhan,HD.sdt,HD.diaChi,HD.tinhTrang, SUM(HDCT.donGia) FROM HoaDon HD JOIN HoaDonChiTiet HDCT ON HD.id=HDCT.hoaDon.id " +
                    "GROUP BY HD.id,HD.khachHang.ten,HD.ma,HD.ngayTao,HD.ngayThanhToan,HD.tenNguoiNhan,HD.sdt,HD.diaChi,HD.tinhTrang HAVING HD.ngayThanhToan BETWEEN :ngayBD AND :ngayKT");
            query.setParameter("ngayBD",ngayBD);
            query.setParameter("ngayKT",ngayKT);
            list= (ArrayList<Object[]>) query.getResultList();
            return list;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public ArrayList<Object[]> getAllThongKe(){
        ArrayList<Object[]> list=new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query=session.createQuery("SELECT HD.id,HD.khachHang.ten,HD.ma,HD.ngayTao,HD.ngayThanhToan,HD.tenNguoiNhan,HD.sdt,HD.diaChi,HD.tinhTrang, SUM(HDCT.donGia) FROM HoaDon HD JOIN HoaDonChiTiet HDCT ON HD.id=HDCT.hoaDon.id " +
                    "GROUP BY HD.id,HD.khachHang.ten,HD.ma,HD.ngayTao,HD.ngayThanhToan,HD.tenNguoiNhan,HD.sdt,HD.diaChi,HD.tinhTrang ");
            list= (ArrayList<Object[]>) query.getResultList();
            return list;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public ArrayList<Object[]> getAllLichSu(String id){
        ArrayList<Object[]> list=new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query=session.createQuery("SELECT HD.id,HD.khachHang.ten,HD.ma,HD.ngayTao,HD.ngayThanhToan,HD.tenNguoiNhan,HD.sdt,HD.diaChi,HD.tinhTrang, SUM(HDCT.donGia) FROM HoaDon HD JOIN HoaDonChiTiet HDCT ON HD.id=HDCT.hoaDon.id " +
                    "GROUP BY HD.id,HD.khachHang.ten,HD.ma,HD.ngayTao,HD.ngayThanhToan,HD.tenNguoiNhan,HD.sdt,HD.diaChi,HD.tinhTrang,HD.khachHang.id HAVING HD.khachHang.id=:id");
            query.setParameter("id",id);
            list= (ArrayList<Object[]>) query.getResultList();
            return list;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public ArrayList<Object[]> getLichSu(String id,Date ngayBD,Date ngayKT){
        ArrayList<Object[]> list=new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query=session.createQuery("SELECT HD.id,HD.khachHang.ten,HD.ma,HD.ngayTao,HD.ngayThanhToan,HD.tenNguoiNhan,HD.sdt,HD.diaChi,HD.tinhTrang, SUM(HDCT.donGia) FROM HoaDon HD JOIN HoaDonChiTiet HDCT ON HD.id=HDCT.hoaDon.id " +
                    "GROUP BY HD.id,HD.khachHang.ten,HD.ma,HD.ngayTao,HD.ngayThanhToan,HD.tenNguoiNhan,HD.sdt,HD.diaChi,HD.tinhTrang,HD.khachHang.id HAVING HD.khachHang.id=:id AND HD.ngayThanhToan BETWEEN :ngayBD AND :ngayKT");
            query.setParameter("id",id);
            query.setParameter("ngayBD",ngayBD);
            query.setParameter("ngayKT",ngayKT);
            list= (ArrayList<Object[]>) query.getResultList();
            return list;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public BigDecimal getDTNgay(Date date){
        BigDecimal list=null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query=session.createQuery("SELECT SUM(HDCT.donGia) FROM HoaDon HD JOIN HoaDonChiTiet HDCT ON HD.id=HDCT.hoaDon.id " +
                    "GROUP BY HD.ngayThanhToan HAVING day(HD.ngayThanhToan)=day(:date) AND month(HD.ngayThanhToan) = month(:date) AND year(HD.ngayThanhToan)= year(:date)");
            query.setParameter("date",date);
            list= (BigDecimal) query.getSingleResult();
            return list;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public ArrayList<Object[]> getDTThang(Date date){
        ArrayList<Object[]> list=new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query=session.createQuery("SELECT HD.ngayThanhToan, SUM(HDCT.donGia) FROM HoaDon HD JOIN HoaDonChiTiet HDCT ON HD.id=HDCT.hoaDon.id " +
                    "GROUP BY HD.ngayThanhToan HAVING month(HD.ngayThanhToan) = month(:date) AND year(HD.ngayThanhToan)= year(:date)");
            query.setParameter("date",date);
            list= (ArrayList<Object[]>) query.getResultList();
            return list;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public ArrayList<Object[]> getDTNAM(Date date){
        ArrayList<Object[]> list=new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query=session.createQuery("SELECT HD.ngayThanhToan, SUM(HDCT.donGia) FROM HoaDon HD JOIN HoaDonChiTiet HDCT ON HD.id=HDCT.hoaDon.id " +
                    "GROUP BY HD.ngayThanhToan HAVING YEAR(HD.ngayThanhToan) =YEAR(:date)");
            query.setParameter("date",date);
            list= (ArrayList<Object[]>) query.getResultList();
            return list;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public static void main(String[] args) {
       BigDecimal dt=new HoaDonRespon().getDTNgay(new Date());
        System.out.println("DT"+dt);

    }
}
