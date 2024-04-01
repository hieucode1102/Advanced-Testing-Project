package service;

import model.KhachHang;
import responsitory.KhachHangRespon;

import java.util.List;

public class KhachHangService {
    KhachHangRespon khachHangRespon = new KhachHangRespon();
    public List<KhachHang> getListKH() {
        return khachHangRespon.getListKH();
    }

    public boolean addKH(KhachHang kh) {
        if(khachHangRespon.addKH(kh)){
            return true;
        }
        return false;
    }

    public KhachHang getOneKH(String id) {
        return  khachHangRespon.getOneKH(id);
    }

    public boolean deleteKH(KhachHang kh) {
        return khachHangRespon.deleteKH(kh);
    }

    public boolean updateKH(KhachHang kh) {
        if(khachHangRespon.addKH(kh)){
            return true;
        }
        return false;
    }
}
