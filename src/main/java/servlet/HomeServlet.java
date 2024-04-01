package servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.*;
import responsitory.*;

import javax.swing.*;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

@WebServlet(name = "HomeServlet", value = {"/HomeServlet",
        "/searchSP",
        "/LoginServlet",
        "/LogoutServlet",
        "/QuickServlet",
        "/LocGiaServlet",
        "/LocMSServlet",
        "/LocDSPServlet",
        "/SortByTenServlet",
        "/SortByGiaNhoServlet",
        "/SortByGiaLonServlet",
        "/ProductServlet",
        "/LocGiaProServlet",
        "/LocMSProServlet",
        "/LocDSPProServlet",
        "/SortByTenProServlet",
        "/SortByGiaNhoProServlet",
        "/SortByGiaLonProServlet",
        "/searchSPPro",
        "/AddToCart",
        "/GioHangServlet",
        "/UpdateGH",
        "/deleteGH",
        "/ThanhToan"
})
public class HomeServlet extends HttpServlet {
    ChiTietSPRespon ctspr = new ChiTietSPRespon();
    KhachHangRespon khr = new KhachHangRespon();
    GioHangChiTietRespon ghctr = new GioHangChiTietRespon();
    GioHangRespon ghr = new GioHangRespon();
    DongSPRespon dr = new DongSPRespon();
    HoaDonRespon hdr=new HoaDonRespon();
    HoaDonChiTietRespon hdctr=new HoaDonChiTietRespon();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();

        if (uri.contains("HomeServlet")) {
            request.setAttribute("LIST_CTSP", ctspr.getListCTSP());
            request.setAttribute("LIST_DM", dr.getListDSP());
            getCookie(request, response);
            getAllGHCT(request,response);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } else if (uri.contains("searchSP")) {
            String tim = request.getParameter("search");
            request.setAttribute("LIST_CTSP", ctspr.getByTen(tim));
            request.setAttribute("LIST_DM", dr.getListDSP());
            getCookie(request, response);
            getAllGHCT(request,response);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } else if (uri.contains("LoginServlet")) {
            request.getRequestDispatcher("login.jsp").forward(request, response);
        } else if (uri.contains("LogoutServlet")) {
            Cookie ck = new Cookie("Username", "");
            Cookie ck1 = new Cookie("TenKH", "");
            ck.setMaxAge(0);
            ck1.setMaxAge(0);
            response.addCookie(ck);
            response.addCookie(ck1);
//            HttpSession session= request.getSession();
//            session.invalidate();
            request.setAttribute("LIST_CTSP", ctspr.getListCTSP());
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } else if (uri.contains("QuickServlet")) {
            String idSP = request.getParameter("idSP");
            ChiTietSP ct = ctspr.getOneCTSP(idSP);
            if (ct != null) {
                request.setAttribute("SP", ct);
                request.setAttribute("LIST_CTSP", ctspr.getListCTSP());
                getCookie(request, response);
                getAllGHCT(request,response);
                request.getRequestDispatcher("product-detail.jsp").forward(request, response);
            }
        } else if (uri.contains("LocGiaServlet")) {
            String s = request.getParameter("start");
            String e = request.getParameter("end");
            request.setAttribute("LIST_CTSP", ctspr.getByGia(s, e));
            request.setAttribute("LIST_DM", dr.getListDSP());
            getCookie(request, response);
            getAllGHCT(request,response);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } else if (uri.contains("LocMSServlet")) {
            String ms = request.getParameter("ms");
            request.setAttribute("LIST_CTSP", ctspr.getByMauSac(ms));
            request.setAttribute("LIST_DM", dr.getListDSP());
            getCookie(request, response);
            getAllGHCT(request,response);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } else if (uri.contains("LocDSPServlet")) {
            String dsp = request.getParameter("dsp");
            request.setAttribute("LIST_CTSP", ctspr.getByDanhMuc(dsp));
            request.setAttribute("LIST_DM", dr.getListDSP());
            getCookie(request, response);
            getAllGHCT(request,response);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } else if (uri.contains("SortByTenServlet")) {
            getCookie(request, response);
            request.setAttribute("LIST_DM", dr.getListDSP());
            request.setAttribute("LIST_CTSP", ctspr.sortByTen());
            getAllGHCT(request,response);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } else if (uri.contains("SortByGiaNhoServlet")) {
            getCookie(request, response);
            request.setAttribute("LIST_DM", dr.getListDSP());
            request.setAttribute("LIST_CTSP", ctspr.sortByGiaNho());
            getAllGHCT(request,response);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } else if (uri.contains("SortByGiaLonServlet")) {
            getCookie(request, response);
            request.setAttribute("LIST_DM", dr.getListDSP());
            request.setAttribute("LIST_CTSP", ctspr.sortByGiaLon());
            getAllGHCT(request,response);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } else if (uri.contains("ProductServlet")) {
            getCookie(request, response);
            request.setAttribute("LIST_DM", dr.getListDSP());
            request.setAttribute("LIST_CTSP", ctspr.getListCTSP());
            getAllGHCT(request,response);
            request.getRequestDispatcher("product.jsp").forward(request, response);
        } else if (uri.contains("searchSPPro")) {
            String tim = request.getParameter("search");
            request.setAttribute("LIST_CTSP", ctspr.getByTen(tim));
            request.setAttribute("LIST_DM", dr.getListDSP());
            getCookie(request, response);
            getAllGHCT(request,response);
            request.getRequestDispatcher("product.jsp").forward(request, response);
        } else if (uri.contains("LocGiaProServlet")) {
            String s = request.getParameter("start");
            String e = request.getParameter("end");
            request.setAttribute("LIST_CTSP", ctspr.getByGia(s, e));
            request.setAttribute("LIST_DM", dr.getListDSP());
            getCookie(request, response);
            getAllGHCT(request,response);
            request.getRequestDispatcher("product.jsp").forward(request, response);
        } else if (uri.contains("LocMSProServlet")) {
            String ms = request.getParameter("ms");
            request.setAttribute("LIST_CTSP", ctspr.getByMauSac(ms));
            request.setAttribute("LIST_DM", dr.getListDSP());
            getCookie(request, response);
            getAllGHCT(request,response);
            request.getRequestDispatcher("product.jsp").forward(request, response);
        } else if (uri.contains("LocDSPProServlet")) {
            String dsp = request.getParameter("dsp");
            request.setAttribute("LIST_CTSP", ctspr.getByDanhMuc(dsp));
            request.setAttribute("LIST_DM", dr.getListDSP());
            getCookie(request, response);
            getAllGHCT(request,response);
            request.getRequestDispatcher("product.jsp").forward(request, response);
        } else if (uri.contains("SortByTenProServlet")) {
            getCookie(request, response);
            getAllGHCT(request,response);
            request.setAttribute("LIST_DM", dr.getListDSP());
            request.setAttribute("LIST_CTSP", ctspr.sortByTen());
            request.getRequestDispatcher("product.jsp").forward(request, response);
        } else if (uri.contains("SortByGiaNhoProServlet")) {
            getCookie(request, response);
            getAllGHCT(request,response);
            request.setAttribute("LIST_DM", dr.getListDSP());
            request.setAttribute("LIST_CTSP", ctspr.sortByGiaNho());
            request.getRequestDispatcher("product.jsp").forward(request, response);
        } else if (uri.contains("SortByGiaLonProServlet")) {
            getCookie(request, response);
            getAllGHCT(request,response);
            request.setAttribute("LIST_DM", dr.getListDSP());
            request.setAttribute("LIST_CTSP", ctspr.sortByGiaLon());
            request.getRequestDispatcher("product.jsp").forward(request, response);
        } else if (uri.contains("GioHangServlet")) {
            getAllGHCT(request, response);
            request.getRequestDispatcher("shopping-cart.jsp").forward(request, response);
        }else if(uri.contains("deleteGH")) {
            String idGH = request.getParameter("idGH");
            String idSP = request.getParameter("idSP");
            GioHangChiTiet ghct=ghctr.getOneGHCT(idGH,idSP);
            ghctr.deleteGHCT(ghct);
            getCookie(request, response);
            getAllGHCT(request,response);
            response.sendRedirect("/GioHangServlet");
        } else {
            request.setAttribute("LIST_CTSP", ctspr.getListCTSP());
            request.setAttribute("LIST_DM", dr.getListDSP());
            getCookie(request, response);
            getAllGHCT(request,response);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }

    public void getCookie(HttpServletRequest req, HttpServletResponse res) {
        Cookie ck[] = req.getCookies();
        if (ck != null) {
            for (Cookie cookie : ck) {
                if (cookie.getName().equals("TenKH")) {
                    String value = cookie.getValue();
                    req.setAttribute("USER", value);
                }
            }
        }
    }

    public void getAllGHCT(HttpServletRequest req, HttpServletResponse res) {
        String value = "";
        Cookie ck[] = req.getCookies();
        if (ck != null) {
            for (Cookie cookie : ck) {
                if (cookie.getName().equals("Username")) {
                    value = cookie.getValue();
                }
            }
        }
        if(ghr.getOneByKH(value)!=null){
            GioHang gh = ghr.getOneByKH(value);

            ArrayList<GioHangChiTiet> listGHCT = ghctr.getByGH(gh.getId());
            double tong=0;
            for (GioHangChiTiet g:listGHCT
                 ) {
                tong+=g.getDonGia().doubleValue();
            }
            req.setAttribute("TONGTIEN",tong);
            req.setAttribute("SLSP", listGHCT.size());
            req.setAttribute("GHCT", listGHCT);
            getCookie(req, res);
        }else{
            req.setAttribute("SLSP",0);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("LoginServlet")) {
            String user = request.getParameter("userKH");
            String pass = request.getParameter("passKH");
            KhachHang kh = khr.login(user, pass);
            if (!user.equalsIgnoreCase(kh.getMa()) && !pass.equals(kh.getMatKhau())) {
                request.setAttribute("LOI_LOGIN", "Nhập sai username or password");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            } else {
                request.setAttribute("USER", kh.getTen());
                request.setAttribute("LIST_CTSP", ctspr.getListCTSP());
//            HttpSession session= request.getSession();;
//            session.setAttribute("tkhoan",user);
//            session.setAttribute("tentk",kh.getTen());
                Cookie u = new Cookie("Username", kh.getId());
                Cookie ten = new Cookie("TenKH", kh.getTen());
                u.setMaxAge(10 * 60 * 60);
                ten.setMaxAge(10 * 60 * 60);
                u.setPath("/");
                response.addCookie(ten);
                response.addCookie(u);
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        } else if (uri.contains("AddToCart")) {
            addGH(request, response);
            getCookie(request, response);
            request.setAttribute("LIST_CTSP", ctspr.getListCTSP());
            request.setAttribute("LIST_DM", dr.getListDSP());
            getCookie(request, response);
            getAllGHCT(request, response);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } else if (uri.contains("UpdateGH")) {
            updateGH(request, response);
            getCookie(request, response);
            response.sendRedirect("/GioHangServlet");
        } else if(uri.contains("ThanhToan")) {
            thanhToan(request,response);

        }
    }

    public void addGH(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String value = "";
        Cookie ck[] = req.getCookies();
        int checkTK=0;
        if (ck != null) {
            for (Cookie cookie : ck) {
                if (cookie.getName().equals("Username")) {
                    value = cookie.getValue();
                    checkTK=1;
                }
            }
        }
//        if(checkTK==0){
//            JOptionPane.showMessageDialog(null,"Vui lòng đăng nhập trước khi mua hàng");
//            req.setAttribute("LIST_CTSP", ctspr.getListCTSP());
//            req.setAttribute("LIST_DM", dr.getListDSP());
//            getCookie(req, res);
//
//            req.getRequestDispatcher("index.jsp").forward(req, res);
//        }
        GioHang gh = ghr.getOneByKH(value);
        if (gh == null) {
            GioHang ghnew = new GioHang();
            KhachHang kh = new KhachHang();
            kh.setId(value);
            ghnew.setMa("GH" + (ghr.getListGH().size() + 1));
            ghnew.setKhachHang(kh);
            ghnew.setNgayTao(new Date());
            ghnew.setTrangThai(0);
            ghr.addGH(ghnew);
            String idsp = req.getParameter("id");
            int sl = Integer.parseInt(req.getParameter("soLuong"));
            ChiTietSP ctsp = ctspr.getOneCTSP(idsp);
            GioHangChiTiet ghct = new GioHangChiTiet();
            ghct.setGioHang(ghnew);
            ghct.setChiTietSP(ctsp);
            double gia;
            if(sl<ctsp.getSlt()) {
                ghct.setSoLuong(sl);
                 gia= sl * ctsp.getGiaBan().doubleValue();
            }else{
                ghct.setSoLuong(ctsp.getSlt());
                gia= (ctsp.getSlt()*ctsp.getGiaBan().doubleValue());
            }
            ghct.setDonGia(BigDecimal.valueOf(gia));
            ghctr.addGHCT(ghct);
        } else {
            String idsp = req.getParameter("id");
            int sl = Integer.parseInt(req.getParameter("soLuong"));
            ChiTietSP ctsp = ctspr.getOneCTSP(idsp);
            if (ghctr.getOneGHCT(gh.getId(), idsp) == null) {
                GioHangChiTiet ghct = new GioHangChiTiet();
                ghct.setGioHang(gh);
                ghct.setChiTietSP(ctsp);
                double gia;
                if(sl<ctsp.getSlt()) {
                    ghct.setSoLuong(sl);
                    gia= sl * ctsp.getGiaBan().doubleValue();
                }else{
                    ghct.setSoLuong(ctsp.getSlt());
                    gia= (ctsp.getSlt()*ctsp.getGiaBan().doubleValue());
                }
                ghct.setDonGia(BigDecimal.valueOf(gia));
                ghctr.addGHCT(ghct);

            } else {
                GioHangChiTiet ghct = ghctr.getOneGHCT(gh.getId(), idsp);
                double gia;
                if((ghct.getSoLuong()+sl)<ctsp.getSlt()) {
                    ghct.setSoLuong(ghct.getSoLuong() + sl);
                    gia = (sl * ctsp.getGiaBan().doubleValue()) + ghct.getDonGia().doubleValue();
                }else{
                    ghct.setSoLuong(ctsp.getSlt());
                    gia= (ctsp.getSlt()*ctsp.getGiaBan().doubleValue());
                }
                ghct.setDonGia(BigDecimal.valueOf(gia));
                ghctr.updateGHCT(ghct);
            }
        }
    }

    public void updateGH(HttpServletRequest req, HttpServletResponse res) {
        String idGH = req.getParameter("idGH");
        String idSP = req.getParameter("idSP");
        ChiTietSP ctsp = ctspr.getOneCTSP(idSP);
        GioHang gh = ghr.getOneGH(idGH);
        int sl = Integer.parseInt(req.getParameter("soLuong"));
        double gia;
        if(sl>0) {
            GioHangChiTiet ghct = ghctr.getOneGHCT(idGH, idSP);
            if(sl<ctsp.getSlt()) {
                ghct.setSoLuong(sl);
                gia = sl * ctsp.getGiaBan().doubleValue();
            }else{
                ghct.setSoLuong(ctsp.getSlt());
                gia= (ctsp.getSlt()*ctsp.getGiaBan().doubleValue());
            }
            ghct.setDonGia(BigDecimal.valueOf(gia));
            ghctr.updateGHCT(ghct);
        }else{
            GioHangChiTiet ghct = ghctr.getOneGHCT(idGH, idSP);
            ghctr.deleteGHCT(ghct);
        }
        getAllGHCT(req,res);
    }
    public void thanhToan(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
        getAllGHCT(req,res);
        String value = "";
        Cookie ck[] = req.getCookies();
        if (ck != null) {
            for (Cookie cookie : ck) {
                if (cookie.getName().equals("Username")) {
                    value = cookie.getValue();
                }
            }
        }
        if(ghr.getOneByKH(value)!=null) {
            String tenNN=req.getParameter("tenNguoiNhan");
            String sdt=req.getParameter("sdt");
            String diaChi=req.getParameter("diaChi");
            GioHang gh = ghr.getOneByKH(value);
            KhachHang kh=khr.getOneKH(value);
            HoaDon hd=new HoaDon();
            int checkMS=0;
            hd.setMa("HD"+(hdr.getListHD().size()+1));
            hd.setKhachHang(kh);
            hd.setNgayTao(new Date());
            hd.setNgayThanhToan(new Date());
            hd.setTenNguoiNhan(tenNN);
            hd.setSdt(sdt);
            hd.setDiaChi(diaChi);
            hd.setTinhTrang(1);

            String ktsdt = "0\\d{9}";
            if(sdt.matches(ktsdt)==false){
                req.setAttribute("LOI_SDT","Sai định dạng số điện thoại");
                checkMS=1;
            }
            if(tenNN.trim().length()==0){
                req.setAttribute("LOI_TEN","Không được để trống tên người nhận");
                checkMS=1;
            }
            if(sdt.trim().length()==0){
                req.setAttribute("LOI_SDT","Không được để trống số điện thoại");
                checkMS=1;
            }
            if(diaChi.trim().length()==0){
                req.setAttribute("LOI_DCHI","Không được để trống địa chỉ");
                checkMS=1;
            }
            if(checkMS==1){
                req.setAttribute("TENNN",tenNN);
                req.setAttribute("DIACHI",diaChi);
                req.setAttribute("SDT",sdt);
                getAllGHCT(req,res);
                getCookie(req,res);
                req.getRequestDispatcher("shopping-cart.jsp").forward(req,res);
            }else{
                hdr.addHD(hd);
                ArrayList<GioHangChiTiet> listGHCT = ghctr.getByGH(gh.getId());
                for (GioHangChiTiet g:listGHCT
                ) {
                    HoaDonChiTiet hdct=new HoaDonChiTiet();
                    HoaDon hd1=hdr.getOneHD(hd.getId());
                    hdct.setHoaDon(hd1);
                    hdct.setChiTietSP(g.getChiTietSP());
                    ChiTietSP ctsp=ctspr.getOneCTSP(g.getChiTietSP().getId());
                    ctsp.setSlt(ctsp.getSlt()-g.getSoLuong());
                    ctspr.updateCTSP(ctsp);
                    hdct.setSoLuong(g.getSoLuong());
                    hdct.setDonGia(g.getDonGia());
                    hdctr.addHDCT(hdct);
                }
                gh.setNgayThanhToan(new Date());
                gh.setTenNguoiNhan(tenNN);
                gh.setSdt(sdt);
                gh.setDiaChi(diaChi);
                gh.setTrangThai(1);
                ghr.updateGH(gh);
                getCookie(req,res);
                res.sendRedirect("/HomeServlet");
            }

        }
    }
}
