package servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.ChucVu;
import model.CuaHang;
import model.KhachHang;
import model.NhanVien;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.commons.beanutils.converters.DateTimeConverter;
import responsitory.ChucVuRespon;
import responsitory.CuaHangRespon;
import responsitory.NhanVienRespon;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "NhanVienServlet", value = {"/NhanVienServlet",
        "/view-addNV",
        "/view-detailNV",
        "/view-updateNV",
        "/updateNV",
        "/addNV",
        "/deleteNV"
})
public class NhanVienServlet extends HttpServlet {
    NhanVienRespon nvr=new NhanVienRespon();
    CuaHangRespon chr=new CuaHangRespon();
    ChucVuRespon cvr=new ChucVuRespon();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri=request.getRequestURI();
        if(uri.contains("NhanVienServlet")){
            request.setAttribute("LIST_NV",nvr.getListNV());
            request.getRequestDispatcher("/viewsNhanVien/viewNhanVien.jsp").forward(request,response);
        } else if(uri.contains("view-addNV")) {
            DateTimeConverter dtc=new DateConverter(new Date());
            dtc.setPattern("yyyy-MM-dd");
            ConvertUtils.register(dtc,Date.class);
            request.setAttribute("LIST_CV",cvr.getList());
            request.setAttribute("LIST_CH",chr.getListCH());
            request.getRequestDispatcher("/viewsNhanVien/addNV.jsp").forward(request,response);
        }else if(uri.contains("view-detailNV")){
            DateTimeConverter dtc=new DateConverter(new Date());
            dtc.setPattern("yyyy-MM-dd");
            ConvertUtils.register(dtc,Date.class);
            String id=request.getParameter("id");
            request.setAttribute("NV",nvr.getOneNV(id));
            request.getRequestDispatcher("/viewsNhanVien/detailNV.jsp").forward(request,response);
        }else if(uri.contains("view-updateNV")){
            request.setAttribute("LIST_CV",cvr.getList());
            request.setAttribute("LIST_CH",chr.getListCH());
            String id=request.getParameter("id");
            request.setAttribute("NV",nvr.getOneNV(id));
            request.getRequestDispatcher("/viewsNhanVien/updateNV.jsp").forward(request,response);
        }else if(uri.contains("deleteNV")){
            String id=request.getParameter("id");
            NhanVien nv=nvr.getOneNV(id);
            nvr.deleteNV(nv);
            request.setAttribute("LIST_NV",nvr.getListNV());
            request.getRequestDispatcher("/viewsNhanVien/viewNhanVien.jsp").forward(request,response);
        }else{
            request.setAttribute("LIST_NV",nvr.getListNV());
            request.getRequestDispatcher("/viewsNhanVien/viewNhanVien.jsp").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri=request.getRequestURI();
        if(uri.contains("addNV")){
            try {
                DateTimeConverter dtc=new DateConverter(new Date());
                dtc.setPattern("yyyy-MM-dd");
                ConvertUtils.register(dtc,Date.class);
                NhanVien nv=new NhanVien();
                CuaHang ch=new CuaHang();
                ChucVu cv=new ChucVu();
                ch.setId(request.getParameter("cuaHang.id"));
                cv.setId(request.getParameter("chucVu.id"));
                BeanUtils.populate(nv,request.getParameterMap());
                nv.setTrangThai(0);
                nv.setCuaHang(ch);
                nv.setChucVu(cv);
                int checkMS=0;
                String ktsdt = "0\\d{9}";
                if(nv.getSdt().matches(ktsdt)==false){
                    request.setAttribute("LOI_SDT","Sai định dạng số điện thoại");
                    checkMS=1;
                }
                for (NhanVien nv1: nvr.getListNV()
                ) {
                    if(nv1.getMa().equalsIgnoreCase(nv.getMa())){
                        request.setAttribute("LOI_MA","Đã có mã nhân viên này");

                        checkMS=1;
                    }
                }
                if(checkMS==1){
                    request.setAttribute("LIST_CV",cvr.getList());
                    request.setAttribute("LIST_CH",chr.getListCH());
                    request.setAttribute("NV",nv);
                    request.getRequestDispatcher("/viewsNhanVien/addNV.jsp").forward(request,response);
                }else{
                    nvr.addNV(nv);
                    response.sendRedirect("/view-addNV");
                }

            }catch (Exception e) {
                e.printStackTrace();
            }
        }else if(uri.contains("updateNV")){
            try {
//                String date = request.getParameter("ngaySinh");
//                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                DateTimeConverter dtc = new DateConverter(new Date());
                dtc.setPattern("yyyy-MM-dd");
                ConvertUtils.register(dtc, Date.class);
                NhanVien nv = new NhanVien();
                CuaHang ch = new CuaHang();
                ChucVu cv = new ChucVu();
                ch.setId(request.getParameter("cuaHang.id"));
                cv.setId(request.getParameter("chucVu.id"));

                BeanUtils.populate(nv, request.getParameterMap());
//                nv.setNgaySinh(format.parse(date));
//                System.out.println(date);
                nv.setCuaHang(ch);
                nv.setChucVu(cv);
                int checkMS = 0;
                String ktsdt = "0\\d{9}";
                if (nv.getSdt().matches(ktsdt) == false) {
                    request.setAttribute("LOI_SDT", "Sai định dạng số điện thoại");

                    checkMS = 1;
                }
                if (checkMS == 1) {
                    request.setAttribute("LIST_CV",cvr.getList());
                    request.setAttribute("LIST_CH",chr.getListCH());
                    request.setAttribute("NV",nv);
                    request.getRequestDispatcher("/viewsNhanVien/updateNV.jsp").forward(request, response);
                } else {
                    nvr.updateNV(nv);
                    response.sendRedirect("/view-updateNV");
                }
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
