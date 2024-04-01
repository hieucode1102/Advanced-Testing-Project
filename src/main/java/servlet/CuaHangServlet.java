package servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.CuaHang;
import org.apache.commons.beanutils.BeanUtils;
import responsitory.CuaHangRespon;

import java.io.IOException;

@WebServlet(name = "CuaHangServlet", value = {"/CuaHangServlet",
        "/view-addCH",
        "/view-detailCH",
        "/view-updateCH",
        "/updateCH",
        "/addCH",
        "/deleteCH"

})
public class CuaHangServlet extends HttpServlet {
    CuaHangRespon chr=new CuaHangRespon();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri=request.getRequestURI();
        if(uri.contains("CuaHangServlet")){
            request.setAttribute("LIST_CH",chr.getListCH());
            request.getRequestDispatcher("/viewsCuaHang/viewCuaHang.jsp").forward(request,response);
        } else if(uri.contains("view-addCH")) {
            request.getRequestDispatcher("/viewsCuaHang/addCH.jsp").forward(request,response);
        }else if(uri.contains("view-detailCH")){
            String id=request.getParameter("id");
            request.setAttribute("CH",chr.getOneCH(id));
            request.getRequestDispatcher("/viewsCuaHang/detailCH.jsp").forward(request,response);
        }else if(uri.contains("view-updateCH")){
            String id=request.getParameter("id");
            request.setAttribute("CH",chr.getOneCH(id));
            request.getRequestDispatcher("/viewsCuaHang/updateCH.jsp").forward(request,response);
        }else if(uri.contains("deleteCH")){
            String id=request.getParameter("id");
            CuaHang ch=chr.getOneCH(id);
            chr.deleteCH(ch);
            request.setAttribute("LIST_CH",chr.getListCH());
            request.getRequestDispatcher("/viewsCuaHang/viewCuaHang.jsp").forward(request,response);
        }else{
            request.setAttribute("LIST_CH",chr.getListCH());
            request.getRequestDispatcher("/viewsCuaHang/viewCuaHang.jsp").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri=request.getRequestURI();
        if(uri.contains("addCH")){
            try {
                CuaHang ch=new CuaHang();
                BeanUtils.populate(ch,request.getParameterMap());
                int checkMS=0;
                for (CuaHang ch1: chr.getListCH()
                ) {
                    if(ch1.getMa().equalsIgnoreCase(ch.getMa())){
                        request.setAttribute("LOI_MA","Đã có mã cửa hàng này");

                        checkMS=1;
                    }
                }
                if(checkMS==1){
                    request.getRequestDispatcher("/viewsCuaHang/addCH.jsp").forward(request,response);
                }else{
                    chr.addCH(ch);
                    response.sendRedirect("/view-addCH");
                }

            }catch (Exception e) {
                e.printStackTrace();
            }
        } else if(uri.contains("updateCH")) {
            try {
                CuaHang ch=new CuaHang();
                BeanUtils.populate(ch,request.getParameterMap());
                chr.updateCH(ch);
                response.sendRedirect("/view-updateCH");
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
