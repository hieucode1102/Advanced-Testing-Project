package servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import responsitory.HoaDonChiTietRespon;
import responsitory.HoaDonRespon;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "LichSuServlet", value = {"/LichSuServlet","/LichSuDetail"})
public class LichSuServlet extends HttpServlet {
    HoaDonRespon hdr=new HoaDonRespon();
    HoaDonChiTietRespon hdctr=new HoaDonChiTietRespon();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri =request.getRequestURI();
        if (uri.contains("LichSuServlet")){
            Cookie ck[] = request.getCookies();
            String value="";
            if (ck != null) {
                for (Cookie cookie : ck) {
                    if (cookie.getName().equals("Username")) {
                         value = cookie.getValue();
                    }
                }
            }
                request.setAttribute("LIST_HD",hdr.getAllLichSu(value));
            request.getRequestDispatcher("/viewLichSu/LichSuMuaHang.jsp").forward(request,response);
        } else if(uri.contains("LichSuDetail")) {
            String idHD=request.getParameter("idHD");
            request.setAttribute("LIST_HDCT",hdctr.getAllHDCTByHD(idHD));
            request.getRequestDispatcher("/viewLichSu/hoaDonCT.jsp").forward(request,response);
        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        String ngayBD=request.getParameter("ngayBD");
        String ngayKT=request.getParameter("ngayKT");

        try {
            Date bd=sdf.parse(ngayBD);
            Date kt;
            if(ngayKT.isEmpty()){
                kt=new Date();
            }else{
                kt=sdf.parse(ngayKT);
            }
            Cookie ck[] = request.getCookies();
            String value="";
            if (ck != null) {
                for (Cookie cookie : ck) {
                    if (cookie.getName().equals("Username")) {
                        value = cookie.getValue();
                    }
                }
            }
            request.setAttribute("LIST_HD",hdr.getLichSu(value,bd,kt));
            request.getRequestDispatcher("/viewLichSu/LichSuMuaHang.jsp").forward(request,response);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
