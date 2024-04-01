package responsitory;

import jakarta.persistence.Query;
import model.CuaHang;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utility.HibernateUtil;

import java.util.ArrayList;
import java.util.Collections;

public class CuaHangRespon {
    ArrayList<CuaHang> listCH = new ArrayList<>();

    public ArrayList<CuaHang> getListCH() {
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM CuaHang ");
            listCH = (ArrayList<CuaHang>) query.getResultList();
            Collections.sort(listCH,(CuaHang o1,CuaHang o2) ->catMa(o1.getMa())>catMa(o2.getMa())?1:-1 );
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listCH;
    }
    private int catMa(String ma) {
        String chuSo = ma.substring(2);
        int so = Integer.valueOf(chuSo);
        return so;
    }
    public CuaHang getOneCH(String id){
        CuaHang ch=null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            ch=session.get(CuaHang.class,id);
        }catch(Exception e){
            e.printStackTrace();
        }
        return ch;
    }
    public void addCH(CuaHang ch){
        Transaction transaction=null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction= session.beginTransaction();
            session.save(ch);
            transaction.commit();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void updateCH(CuaHang ch){
        Transaction transaction=null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction= session.beginTransaction();
            session.merge(ch);
            transaction.commit();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void deleteCH(CuaHang ch){
        Transaction transaction=null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction= session.beginTransaction();
            session.delete(ch);
            transaction.commit();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
