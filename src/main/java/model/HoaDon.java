package model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "HoaDon")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class HoaDon implements Serializable {
    @Id
    @GenericGenerator(name = "generator", strategy = "guid", parameters = {})
    @GeneratedValue(generator = "generator")
    @Column(name="Id")
    private String id;
    @ManyToOne
    @JoinColumn(name = "IdKH")
    private KhachHang khachHang;
    @Column(name = "Ma")
    private String ma;
    @Column(name = "NgayTao")
    private Date ngayTao;
    @Column(name = "NgayThanhToan")
    private Date ngayThanhToan;
    @Column(name = "TinhTrang")
    private int tinhTrang;
    @Column(name = "TenNguoiNhan")
    private String tenNguoiNhan;
    @Column(name = "DiaChi")
    private String diaChi;
    @Column(name = "Sdt")
    private String sdt;
}
