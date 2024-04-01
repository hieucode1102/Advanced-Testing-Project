package servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.commons.beanutils.converters.DateTimeConverter;
import responsitory.HoaDonRespon;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@WebServlet(name = "ThongKeServlet", value = "/ThongKeServlet")
public class ThongKeServlet extends HttpServlet {
    HoaDonRespon hdr=new HoaDonRespon();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Date date=new Date();
        if(hdr.getDTNgay(date)!=null) {
            request.setAttribute("DTNGAY", hdr.getDTNgay(date));
        }else{
            request.setAttribute("DTNGAY", 0);
        }
        if(hdr.getDTThang(date)!=null){
            ArrayList<Object[]> listThang=hdr.getDTThang(date);
            double dtThang=0;
            for (Object[] o: listThang){
                dtThang+=Double.parseDouble(o[1].toString());
            }
            request.setAttribute("DTTHANG", dtThang);
        }else{
            request.setAttribute("DTTHANG", 0);
        }
        if(hdr.getDTNAM(date)!=null){
            ArrayList<Object[]> listNam=hdr.getDTNAM(date);
            double dtNam=0;
            for (Object[] o: listNam){
                dtNam+=Double.parseDouble(o[1].toString());
            }
            request.setAttribute("DTNAM", dtNam);
        }else{
            request.setAttribute("DTNAM", 0);
        }
        request.setAttribute("LIST_HD",hdr.getAllThongKe());
     request.getRequestDispatcher("/viewThongKe/viewThongKe.jsp").forward(request,response);
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
            request.setAttribute("LIST_HD",hdr.getThongKe(bd,kt));
        } catch (ParseException e) {
           e.printStackTrace();
        }
        Date date=new Date();
        if(hdr.getDTNgay(date)!=null) {
            request.setAttribute("DTNGAY", hdr.getDTNgay(date));
        }else{
            request.setAttribute("DTNGAY", 0);
        }
        if(hdr.getDTThang(date)!=null){
            ArrayList<Object[]> listThang=hdr.getDTThang(date);
            double dtThang=0;
            for (Object[] o: listThang){
                dtThang+=Double.parseDouble(o[1].toString());
            }
            request.setAttribute("DTTHANG", dtThang);
        }else{
            request.setAttribute("DTTHANG", 0);
        }
        if(hdr.getDTNAM(date)!=null){
            ArrayList<Object[]> listNam=hdr.getDTNAM(date);
            double dtNam=0;
            for (Object[] o: listNam){
                dtNam+=Double.parseDouble(o[1].toString());
            }
            request.setAttribute("DTNAM", dtNam);
        }else{
            request.setAttribute("DTNAM", 0);
        }
        request.getRequestDispatcher("/viewThongKe/viewThongKe.jsp").forward(request,response);
    }
}
