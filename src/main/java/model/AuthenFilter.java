package model;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import responsitory.ChiTietSPRespon;

import java.io.IOException;

@WebFilter({"/ChucVuServlet"})
public class AuthenFilter implements Filter {
    ChiTietSPRespon ctspr=new ChiTietSPRespon();
    public void init(FilterConfig config) throws ServletException {
        Filter.super.init(config);
        System.out.println("Khi init");
    }

    public void destroy() {
        Filter.super.destroy();
        System.out.println("Khi destroy ");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
            HttpServletRequest req = (HttpServletRequest) request;
            HttpServletResponse res = (HttpServletResponse) response;
            Cookie ck[] = req.getCookies();
        for (Cookie c: ck) {
            if(!c.getName().equals("TenKH")){
                request.setAttribute("LIST_CTSP",ctspr.getListCTSP());
                request.getRequestDispatcher("index.jsp").forward(req,res);
            }else {
                chain.doFilter(request, response);
            }
        }
            System.out.println("Check @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");


    }

}
