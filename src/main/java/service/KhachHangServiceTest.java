package service;

import model.KhachHang;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

public class KhachHangServiceTest {
    KhachHangService khachHangService = new KhachHangService();

    @Test
    public void addKH1() {

//        Kiểm tra chức năng thêm khách hàng thành công với:
//        Mã khách hàng đúng (KH001) , Tên khách hàng đúng (Hiếu),
//        Tên đệm đúng (Danh) , Họ đúng (Lê), Ngày sinh đúng (11/02/2003),
//        Số điện thoại đúng (0369706003), Địa chỉ đúng (Phương Canh),
//        Thành phố đúng(Hà Nội), Quốc gia đúng(Việt Nam), Mật khẩu đúng(hieucode1102@)

        KhachHang kh = new KhachHang();
        kh.setMa("KH001");
        kh.setTen("Hiếu");
        kh.setTenDem("Danh");
        kh.setHo("Lê");
        kh.setNgaySinh("11/02/2003");
        kh.setSdt("0369706003");
        kh.setDiaChi("Phương canh");
        kh.setThanhPho("Hà Nội");
        kh.setQuocGia("Việt Nam");
        kh.setMatKhau("hieucode1102@");
        boolean t = khachHangService.addKH(kh);
        Assert.assertEquals(true, t);


    }

    @Test
    public void addKH2() {

//        Kiểm tra chức năng thêm khách hàng thành công với:
//        Mã khách hàng đúng (KH002) , Tên khách hàng đúng (Phong),
//        Tên đệm đúng (Hiểu) , Họ đúng (Phạm), Ngày sinh đúng (11/10/2003),
//        Số điện thoại đúng (0394921483), Địa chỉ đúng (Bạch Đằng),
//        Thành phố đúng(Hải Phòng), Quốc gia đúng(Việt Nam), Mật khẩu đúng(phongdoctor1110@)

        KhachHang kh = new KhachHang();
        kh.setMa("KH002");
        kh.setTen("Phong");
        kh.setTenDem("Hiểu");
        kh.setHo("Phạm");
        kh.setNgaySinh("11/10/2003");
        kh.setSdt("0394921483");
        kh.setDiaChi("Bạch Đằng");
        kh.setThanhPho("Hải Phòng");
        kh.setQuocGia("Việt Nam");
        kh.setMatKhau("phongdoctor@");
        boolean t = khachHangService.addKH(kh);
        Assert.assertEquals(true, t);


    }

    @Test
    public void addKH3() {

//        Kiểm tra chức năng thêm khách hàng thành công với:
//        Mã khách hàng đúng (KH003) , Tên khách hàng đúng (Dương),
//        Tên đệm đúng (Hữu) , Họ đúng (Phạm), Ngày sinh đúng (08/04/2003),
//        Số điện thoại đúng (0123456789), Địa chỉ đúng (Phương Mai),
//        Thành phố đúng(Hà Nội), Quốc gia đúng(Việt Nam), Mật khẩu đúng(duongcode0804@)

        KhachHang kh = new KhachHang();
        kh.setMa("KH003");
        kh.setTen("Dương");
        kh.setTenDem("Hữu");
        kh.setHo("Phạm");
        kh.setNgaySinh("08/04/2003");
        kh.setSdt("0123456789");
        kh.setDiaChi("Phương Mai");
        kh.setThanhPho("Hà Nội");
        kh.setQuocGia("Việt Nam");
        kh.setMatKhau("duongcode0804@");
        boolean t = khachHangService.addKH(kh);
        Assert.assertEquals(true, t);


    }

    @Test
    public void addKH4() {

//        Kiểm tra chức năng thêm khách hàng không thành công với:
//        Mã khách hàng trống, Tên khách hàng đúng ,
//        Tên đệm đúng , Họ đúng, Ngày sinh đúng,
//        Số điện thoại đúng, Địa chỉ đúng,
//        Thành phố đúng, Quốc gia đúng,Mật khẩu đúng

        KhachHang kh = new KhachHang();
        kh.setMa(null);
        kh.setTen("Hiếu");
        kh.setTenDem("Danh");
        kh.setHo("Lê");
        kh.setNgaySinh("11/02/2003");
        kh.setSdt("0369706003");
        kh.setDiaChi("Phương Canh");
        kh.setThanhPho("Hà Nội");
        kh.setQuocGia("Việt Nam");
        kh.setMatKhau("hieucode1102@");
        boolean t = khachHangService.addKH(kh);
        Assert.assertEquals(false, t);


    }

    @Test
    public void addKH5() {

//        Kiểm tra chức năng thêm khách hàng không thành công với:
//        Mã khách hàng đúng, Tên khách hàng trống,
//        Tên đệm đúng , Họ đúng, Ngày sinh đúng,
//        Số điện thoại đúng, Địa chỉ đúng,
//        Thành phố đúng, Quốc gia đúng,Mật khẩu đúng

        KhachHang kh = new KhachHang();
        kh.setMa("KH004");
        kh.setTen(null);
        kh.setTenDem("Danh");
        kh.setHo("Lê");
        kh.setNgaySinh("11/02/2003");
        kh.setSdt("0369706003");
        kh.setDiaChi("Phương Canh");
        kh.setThanhPho("Hà Nội");
        kh.setQuocGia("Việt Nam");
        kh.setMatKhau("hieucode1102@");
        boolean t = khachHangService.addKH(kh);
        Assert.assertEquals(false, t);


    }

    @Test
    public void addKH6() {

//        Kiểm tra chức năng thêm khách hàng không thành công với:
//        Mã khách hàng đúng, Tên khách hàng đúng,
//        ên đệm trống, Họ đúng, Ngày sinh đúng,
//        Số điện thoại đúng, Địa chỉ đúng,
//        Thành phố đúng, Quốc gia đúng,Mật khẩu đúng

        KhachHang kh = new KhachHang();
        kh.setMa("KH001");
        kh.setTen("Hiếu");
        kh.setTenDem(null);
        kh.setHo("Lê");
        kh.setNgaySinh("11/02/2003");
        kh.setSdt("0369706003");
        kh.setDiaChi("Phương Canh");
        kh.setThanhPho("Hà Nội");
        kh.setQuocGia("Việt Nam");
        kh.setMatKhau("hieucode1102@");
        boolean t = khachHangService.addKH(kh);
        Assert.assertEquals(false, t);


    }

    @Test
    public void addKH7() {

//        Kiểm tra chức năng thêm khách hàng không thành công với:
//        Mã khách hàng đúng, Tên khách hàng đúng,
//        Tên đệm đúng , Họ trống, Ngày sinh đúng,
//        Số điện thoại đúng, Địa chỉ đúng,
//        Thành phố đúng, Quốc gia đúng,Mật khẩu đúng

        KhachHang kh = new KhachHang();
        kh.setMa("KH006");
        kh.setTen("Hiếu");
        kh.setTenDem("Danh");
        kh.setHo(null);
        kh.setNgaySinh("11/02/2003");
        kh.setSdt("0369706003");
        kh.setDiaChi("Phương Canh");
        kh.setThanhPho("Hà Nội");
        kh.setQuocGia("Việt Nam");
        kh.setMatKhau("hieucode1102@");
        boolean t = khachHangService.addKH(kh);
        Assert.assertEquals(false, t);


    }

    @Test
    public void addKH8() {

//        Kiểm tra chức năng thêm khách hàng không thành công với:
//        Mã khách hàng đúng, Tên khách hàng đúng,
//        Tên đệm đúng , Họ đúng, Ngày sinh trống,
//        Số điện thoại đúng, Địa chỉ đúng,
//        Thành phố đúng, Quốc gia đúng,Mật khẩu đúng

        KhachHang kh = new KhachHang();
        kh.setMa("KH007");
        kh.setTen("Hiếu");
        kh.setTenDem("Danh");
        kh.setHo("Lê");
        kh.setNgaySinh((Date) null);
        kh.setSdt("0369706003");
        kh.setDiaChi("Phương Canh");
        kh.setThanhPho("Hà Nội");
        kh.setQuocGia("Việt Nam");
        kh.setMatKhau("hieucode1102@");
        boolean t = khachHangService.addKH(kh);
        Assert.assertEquals(false, t);


    }

    @Test
    public void addKH9() {

//        Kiểm tra chức năng thêm khách hàng không thành công với:
//        Mã khách hàng đã tồn tại, Tên khách hàng trống,
//        Tên đệm đúng , Họ đúng, Ngày sinh đúng,
//        Số điện thoại đúng, Địa chỉ đúng,
//        Thành phố đúng, Quốc gia đúng,Mật khẩu đúng

        KhachHang kh = new KhachHang();
        kh.setMa("KH001");
        kh.setTen("Hiếu");
        kh.setTenDem("Danh");
        kh.setHo("Lê");
        kh.setNgaySinh("11/02/2003");
        kh.setSdt("0369706003");
        kh.setDiaChi("Phương Canh");
        kh.setThanhPho("Hà Nội");
        kh.setQuocGia("Việt Nam");
        kh.setMatKhau("hieucode1102@");
        boolean t = khachHangService.addKH(kh);
        Assert.assertEquals(false, t);

    }

    @Test
    public void addKH10() {

//        Kiểm tra chức năng thêm khách hàng không thành công với:
//        Mã khách hàng trống, Tên khách hàng trống,
//        Tên đệm trống, Họ trống, Ngày sinh trống,
//        Số điện thoại trống, Địa chỉ trống,
//        Thành phố trống, Quốc gia trống,Mật khẩu trống

        KhachHang kh = new KhachHang();
        kh.setMa(null);
        kh.setTen(null);
        kh.setTenDem(null);
        kh.setHo(null);
        kh.setNgaySinh((Date) null);
        kh.setSdt(null);
        kh.setDiaChi(null);
        kh.setThanhPho(null);
        kh.setQuocGia(null);
        kh.setMatKhau(null);
        boolean t = khachHangService.addKH(kh);
        Assert.assertEquals(false, t);


    }
}