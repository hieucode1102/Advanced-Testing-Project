package servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.NSX;
import model.SanPham;
import org.apache.commons.beanutils.BeanUtils;
import responsitory.SanPhamRespon;

import java.io.IOException;

@WebServlet(name = "SanPhamServlet", value = {"/SanPhamServlet",
        "/view-addSP",
        "/view-detailSP",
        "/view-updateSP",
        "/updateSP",
        "/addSP",
        "/deleteSP"
})
public class SanPhamServlet extends HttpServlet {
    SanPhamRespon sr=new SanPhamRespon();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri=request.getRequestURI();
        if(uri.contains("SanPhamServlet")){
            request.setAttribute("LIST_SP",sr.getListSP());
            request.getRequestDispatcher("/viewsSanPham/viewSanPham.jsp").forward(request,response);
        } else if(uri.contains("view-addSP")) {
            request.getRequestDispatcher("/viewsSanPham/addSP.jsp").forward(request,response);
        }else if(uri.contains("view-detailSP")){
            String id=request.getParameter("id");
            request.setAttribute("SP",sr.getOneSP(id));
            request.getRequestDispatcher("/viewsSanPham/detailSP.jsp").forward(request,response);
        }else if(uri.contains("view-updateSP")){
            String id=request.getParameter("id");
            request.setAttribute("SP",sr.getOneSP(id));
            request.getRequestDispatcher("/viewsSanPham/updateSP.jsp").forward(request,response);
        }else if(uri.contains("deleteSP")){
            String id=request.getParameter("id");
            SanPham sp=sr.getOneSP(id);
            sr.deleteSP(sp);
            request.setAttribute("LIST_SP",sr.getListSP());
            request.getRequestDispatcher("/viewsSanPham/viewSanPham.jsp").forward(request,response);
        }else{
            request.setAttribute("LIST_SP",sr.getListSP());
            request.getRequestDispatcher("/viewsSanPham/viewSanPham.jsp").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri=request.getRequestURI();
        if(uri.contains("addSP")){
            try {
               SanPham s=new SanPham();
                BeanUtils.populate(s,request.getParameterMap());
                int checkMS=0;
                for (SanPham s1: sr.getListSP()
                ) {
                    if(s1.getMa().equalsIgnoreCase(s.getMa())){
                        request.setAttribute("LOI_MA","Đã có mã sản phẩm này");

                        checkMS=1;
                    }
                    if(s1.getTen().equalsIgnoreCase(s.getTen())){
                        request.setAttribute("LOI_TEN","Đã có tên sản phẩm này");

                        checkMS=1;
                    }
                }
                if(checkMS==1){
                    request.getRequestDispatcher("/viewsSanPham/addSP.jsp").forward(request,response);
                }else{
                    sr.addSP(s);
                    response.sendRedirect("/view-addSP");
                }

            }catch (Exception e) {
                e.printStackTrace();
            }
        } else if(uri.contains("updateSP")) {
            try {
                SanPham s=new SanPham();
                BeanUtils.populate(s,request.getParameterMap());
                sr.updateSP(s);
                response.sendRedirect("/view-updateSP");
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
