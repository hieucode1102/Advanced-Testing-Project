package servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.*;
import org.apache.commons.beanutils.BeanUtils;
import responsitory.*;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;
import java.nio.file.Paths;

@MultipartConfig
@WebServlet(name = "ChiTietSPServlet", value = {"/ChiTietSPServlet",
        "/view-addCTSP",
        "/view-detailCTSP",
        "/view-updateCTSP",
        "/updateCTSP",
        "/addCTSP",
        "/deleteCTSP"
})
public class ChiTietSPServlet extends HttpServlet {
    ChiTietSPRespon ctspr = new ChiTietSPRespon();
    NSXRespon nr = new NSXRespon();
    SanPhamRespon spr = new SanPhamRespon();
    MauSauRespon msr = new MauSauRespon();
    DongSPRespon dr = new DongSPRespon();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("ChiTietSPServlet")) {
            request.setAttribute("LIST_CTSP", ctspr.getListCTSP());
            request.getRequestDispatcher("/viewsCTSP/viewCTSP.jsp").forward(request, response);
        } else if (uri.contains("view-addCTSP")) {
            request.setAttribute("LIST_SP", spr.getListSP());
            request.setAttribute("LIST_NSX", nr.getListNSX());
            request.setAttribute("LIST_MS", msr.getListMS());
            request.setAttribute("LIST_DSP", dr.getListDSP());
            request.getRequestDispatcher("/viewsCTSP/addCTSP.jsp").forward(request, response);
        } else if (uri.contains("view-detailCTSP")) {
            request.setAttribute("LIST_SP", spr.getListSP());
            request.setAttribute("LIST_NSX", nr.getListNSX());
            request.setAttribute("LIST_MS", msr.getListMS());
            request.setAttribute("LIST_DSP", dr.getListDSP());
            String id = request.getParameter("id");
            ChiTietSP c = ctspr.getOneCTSP(id);
            request.setAttribute("CT", c);
            request.getRequestDispatcher("/viewsCTSP/detailCTSP.jsp").forward(request, response);
        } else if (uri.contains("view-updateCTSP")) {
            request.setAttribute("LIST_SP", spr.getListSP());
            request.setAttribute("LIST_NSX", nr.getListNSX());
            request.setAttribute("LIST_MS", msr.getListMS());
            request.setAttribute("LIST_DSP", dr.getListDSP());
            String id = request.getParameter("id");
            ChiTietSP c = ctspr.getOneCTSP(id);
            request.setAttribute("C", c);
            request.getRequestDispatcher("/viewsCTSP/updateCTSP.jsp").forward(request, response);
        }else if(uri.contains("deleteCTSP")){
            String id = request.getParameter("id");
            ChiTietSP c = ctspr.getOneCTSP(id);
            ctspr.deleteCTSP(c);
            request.setAttribute("LIST_CTSP", ctspr.getListCTSP());
            request.getRequestDispatcher("/viewsCTSP/viewCTSP.jsp").forward(request, response);
        } else {
            request.setAttribute("LIST_CTSP", ctspr.getListCTSP());
            request.getRequestDispatcher("/viewsCTSP/viewCTSP.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("addCTSP")) {
            try {

                ChiTietSP c = new ChiTietSP();
                NSX n = new NSX();
                MauSac m = new MauSac();
                DongSP d = new DongSP();
                SanPham s = new SanPham();
                n.setId(request.getParameter("nsx.id"));
                s.setId(request.getParameter("sanPham.id"));
                m.setId(request.getParameter("mauSac.id"));
                d.setId(request.getParameter("dongSP.id"));
                BeanUtils.populate(c, request.getParameterMap());
                c.setSanPham(s);
                c.setNsx(n);
                c.setMauSac(m);
                c.setDongSP(d);
                int checkMS = 0;
                for (ChiTietSP ct : ctspr.getListCTSP()
                ) {
                    if (c.getSanPham().getId().equals(ct.getSanPham().getId()) && c.getNsx().getId().equals(ct.getNsx().getId()) && c.getMauSac().getId().equals(ct.getMauSac().getId()) && c.getDongSP().getId().equals(ct.getDongSP().getId())) {
                        request.setAttribute("LOI_TRUNG", "Đã có sản phẩm này");
                        checkMS = 1;
                    }
                }
                if (checkMS == 1) {
                    request.setAttribute("LIST_SP", spr.getListSP());
                    request.setAttribute("LIST_NSX", nr.getListNSX());
                    request.setAttribute("LIST_MS", msr.getListMS());
                    request.setAttribute("LIST_DSP", dr.getListDSP());
                    request.setAttribute("C", c);
                    request.getRequestDispatcher("/viewsCTSP/addCTSP.jsp").forward(request, response);
                } else {
                    ctspr.addCTSP(c);
                    response.sendRedirect("view-addCTSP");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (uri.contains("updateCTSP")) {
            try {
                ChiTietSP c = new ChiTietSP();
                NSX n = new NSX();
                MauSac m = new MauSac();
                DongSP d = new DongSP();
                SanPham s = new SanPham();
                n.setId(request.getParameter("nsx.id"));
                s.setId(request.getParameter("sanPham.id"));
                m.setId(request.getParameter("mauSac.id"));
                d.setId(request.getParameter("dongSP.id"));
                BeanUtils.populate(c, request.getParameterMap());
                c.setSanPham(s);
                c.setNsx(n);
                c.setMauSac(m);
                c.setDongSP(d);
                int checkMS = 0;
                for (ChiTietSP ct : ctspr.getListCTSP()
                ) {
                    if (c.getId().compareTo(ct.getId())!=0 && c.getSanPham().getId().equals(ct.getSanPham().getId()) && c.getNsx().getId().equals(ct.getNsx().getId()) && c.getMauSac().getId().equals(ct.getMauSac().getId()) && c.getDongSP().getId().equals(ct.getDongSP().getId())) {
                        request.setAttribute("LOI_TRUNG", "Đã có sản phẩm này");
                        checkMS = 1;
                    }
                }
                if (checkMS == 1) {
                    request.setAttribute("LIST_SP", spr.getListSP());
                    request.setAttribute("LIST_NSX", nr.getListNSX());
                    request.setAttribute("LIST_MS", msr.getListMS());
                    request.setAttribute("LIST_DSP", dr.getListDSP());
                    request.setAttribute("C", c);
                    request.getRequestDispatcher("/viewsCTSP/updateCTSP.jsp").forward(request, response);
                } else {
                    ctspr.updateCTSP(c);
                    response.sendRedirect("view-updateCTSP");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
