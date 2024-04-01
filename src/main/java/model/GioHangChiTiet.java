package model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.NaturalId;

import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "GioHangChiTiet")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class GioHangChiTiet implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "IdGioHang",referencedColumnName = "Id")
    private GioHang gioHang;
    @Id
    @ManyToOne
    @JoinColumn(name = "IdChiTietSP",referencedColumnName = "Id")
    private ChiTietSP chiTietSP;
    @Column(name = "SoLuong")
    private int soLuong;
    @Column(name = "DonGia")
    private BigDecimal donGia;
    @Column(name = "DonGiaKhiGiam")
    private BigDecimal donGiaKhiGiam;

}
