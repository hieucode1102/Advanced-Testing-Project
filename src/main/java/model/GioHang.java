package model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "GioHang")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class GioHang implements Serializable{
    @Id
    @GenericGenerator(name = "generator", strategy = "guid", parameters = {})
    @GeneratedValue(generator = "generator")
    @Column(name="Id")
    private String id;
    @ManyToOne
    @JoinColumn(name = "IdKH",referencedColumnName = "Id")
    private KhachHang khachHang;
    @ManyToOne
    @JoinColumn(name = "IdNV",referencedColumnName = "Id")
    private NhanVien nhanVien;
    @Column(name = "Ma")
    private String ma;
    @Column(name = "NgayTao")
    private Date ngayTao;
    @Column(name = "NgayThanhToan")
    private Date ngayThanhToan;
    @Column(name = "TenNguoiNhan")
    private String tenNguoiNhan;
    @Column(name = "DiaChi")
    private String diaChi;
    @Column(name = "Sdt")
    private String sdt;
    @Column(name = "TinhTrang")
    private int trangThai;
}
