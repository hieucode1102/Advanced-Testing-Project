package model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "ChiTietSP")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ChiTietSP implements Serializable {
    @Id
    @GenericGenerator(name = "generator", strategy = "guid", parameters = {})
    @GeneratedValue(generator = "generator")
    @Column(name="Id")
    private String id;
    @ManyToOne
    @JoinColumn(name="IdSP")
    private SanPham sanPham;
    @ManyToOne
    @JoinColumn(name="IdNsx")
    private NSX nsx;
    @ManyToOne
    @JoinColumn(name="IdMauSac")
    private MauSac mauSac;
    @ManyToOne
    @JoinColumn(name="IdDongSP")
    private DongSP dongSP;
    @Column(name="NamBH")
    private int namBH;
    @Column(name="MoTa")
    private String moTa;
    @Column(name="SoLuongTon")
    private int slt;
    @Column(name = "GiaNhap")
    private BigDecimal giaNhap;
    @Column(name = "GiaBan")
    private BigDecimal giaBan;
    @Column(name = "Hinh")
    private String hinhAnh;
}
