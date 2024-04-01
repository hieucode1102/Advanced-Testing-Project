package servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.KhachHang;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.commons.beanutils.converters.DateTimeConverter;
import responsitory.KhachHangRespon;
import service.KhachHangService;

import java.io.IOException;
import java.util.Date;

@WebServlet(name = "KhachHangServlet", value = {"/KhachHangServlet",
        "/view-addKH",
        "/view-detailKH",
        "/view-updateKH",
        "/updateKH",
        "/addKH",
        "/deleteKH"
})
public class KhachHangServlet extends HttpServlet {
//        KhachHangRespon khr=new KhachHangRespon();
    KhachHangService khr = new KhachHangService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri=request.getRequestURI();
        if(uri.contains("KhachHangServlet")){
            request.setAttribute("LIST_KH",khr.getListKH());
            request.getRequestDispatcher("/viewsKhachHang/viewKhachHang.jsp").forward(request,response);
        } else if(uri.contains("view-addKH")) {
            request.getRequestDispatcher("/viewsKhachHang/addKH.jsp").forward(request,response);
        }else if(uri.contains("view-detailKH")){
            String id=request.getParameter("id");
            request.setAttribute("KH",khr.getOneKH(id));
            request.getRequestDispatcher("/viewsKhachHang/detailKH.jsp").forward(request,response);
        }else if(uri.contains("view-updateKH")){
            String id=request.getParameter("id");
            request.setAttribute("KH",khr.getOneKH(id));
            request.getRequestDispatcher("/viewsKhachHang/updateKH.jsp").forward(request,response);
        }else if(uri.contains("deleteKH")){
            String id=request.getParameter("id");
            KhachHang kh=khr.getOneKH(id);
            khr.deleteKH(kh);
            request.setAttribute("LIST_KH",khr.getListKH());
            request.getRequestDispatcher("/viewsKhachHang/viewKhachHang.jsp").forward(request,response);
        }else{
            request.setAttribute("LIST_KH",khr.getListKH());
            request.getRequestDispatcher("/viewsKhachHang/viewKhachHang.jsp").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri=request.getRequestURI();
        if(uri.contains("addKH")){
            try {
                DateTimeConverter dtc=new DateConverter(new Date());
                dtc.setPattern("yyyy-MM-dd");
                ConvertUtils.register(dtc,Date.class);
                KhachHang kh=new KhachHang();
                BeanUtils.populate(kh,request.getParameterMap());
                int checkMS=0;
                String ktsdt = "0\\d{9}";
                if(kh.getSdt().matches(ktsdt)==false){
                    request.setAttribute("LOI_SDT","Sai định dạng số điện thoại");
                    checkMS=1;
                }
                for (KhachHang kh1: khr.getListKH()
                ) {
                    if(kh1.getMa().equalsIgnoreCase(kh.getMa())){
                        request.setAttribute("LOI_MA","Đã có mã khách hàng này");

                        checkMS=1;
                    }
                }
                if(checkMS==1){
                    request.getRequestDispatcher("/viewsKhachHang/addKH.jsp").forward(request,response);
                }else{
                    khr.addKH(kh);
                    response.sendRedirect("view-addKH");
                }

            }catch (Exception e) {
                e.printStackTrace();
            }
        } else if(uri.contains("updateKH")) {
            try {
                DateTimeConverter dtc=new DateConverter(new Date());
                dtc.setPattern("yyyy-MM-dd");
                ConvertUtils.register(dtc,Date.class);
                KhachHang kh=new KhachHang();
                BeanUtils.populate(kh,request.getParameterMap());
                int checkMS=0;
                String ktsdt = "0\\d{9}";
                if(kh.getSdt().matches(ktsdt)==false){
                    request.setAttribute("LOI_SDT","Sai định dạng số điện thoại");
                    checkMS=1;
                }
                if(checkMS==1){
                    request.setAttribute("LIST_KH",khr.getListKH());
                    request.getRequestDispatcher("/viewsKhachHang/updateKH.jsp").forward(request,response);
                }else{
                    khr.updateKH(kh);
                    response.sendRedirect("KhachHangServlet");
                }

            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
