package servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.NSX;
import org.apache.commons.beanutils.BeanUtils;
import responsitory.NSXRespon;

import java.io.IOException;

@WebServlet(name = "NSXServlet", value = {"/NSXServlet",
        "/view-addNSX",
        "/view-detailNSX",
        "/view-updateNSX",
        "/updateNSX",
        "/addNSX",
        "/deleteNSX"
})
public class NSXServlet extends HttpServlet {
    NSXRespon nr=new NSXRespon();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri=request.getRequestURI();
        if(uri.contains("NSXServlet")){
            request.setAttribute("LIST_NSX",nr.getListNSX());
            request.getRequestDispatcher("/viewsNSX/viewNSX.jsp").forward(request,response);
        } else if(uri.contains("view-addNSX")) {
            request.getRequestDispatcher("/viewsNSX/addNSX.jsp").forward(request,response);
        }else if(uri.contains("view-detailNSX")){
            String id=request.getParameter("id");
            request.setAttribute("NSX",nr.getOneNSX(id));
            request.getRequestDispatcher("/viewsNSX/detailNSX.jsp").forward(request,response);
        }else if(uri.contains("view-updateNSX")){
            String id=request.getParameter("id");
            request.setAttribute("NSX",nr.getOneNSX(id));
            request.getRequestDispatcher("/viewsNSX/updateNSX.jsp").forward(request,response);
        }else if(uri.contains("deleteNSX")){
            String id=request.getParameter("id");
            NSX n=nr.getOneNSX(id);
            nr.deleteNSX(n);
            request.setAttribute("LIST_NSX",nr.getListNSX());
            request.getRequestDispatcher("/viewsNSX/viewNSX.jsp").forward(request,response);
        }else{
            request.setAttribute("LIST_NSX",nr.getListNSX());
            request.getRequestDispatcher("/viewsNSX/viewNSX.jsp").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri=request.getRequestURI();
        if(uri.contains("addNSX")){
            try {
                NSX n=new NSX();
                BeanUtils.populate(n,request.getParameterMap());
                int checkMS=0;
                for (NSX n1: nr.getListNSX()
                ) {
                    if(n1.getMa().equalsIgnoreCase(n.getMa())){
                        request.setAttribute("LOI_MA","Đã có mã NSX này");

                        checkMS=1;
                    }
                    if(n1.getTen().equalsIgnoreCase(n.getTen())){
                        request.setAttribute("LOI_TEN","Đã có tên NSX này");

                        checkMS=1;
                    }
                }
                if(checkMS==1){
                    request.getRequestDispatcher("/viewsNSX/addNSX.jsp").forward(request,response);
                }else{
                    nr.addNSX(n);
                    response.sendRedirect("/view-addNSX");
                }

            }catch (Exception e) {
                e.printStackTrace();
            }
        } else if(uri.contains("updateNSX")) {
            try {
                NSX n=new NSX();
                BeanUtils.populate(n,request.getParameterMap());
                nr.updateNSX(n);
                response.sendRedirect("/view-updateNSX");
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
