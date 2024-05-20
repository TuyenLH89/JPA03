package JPABS03_LamLai.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "chitietphieunhap")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ChiTietPhieuNhap {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "chitietphieunhapid")
    int chiTietPhieuNhapId;
    int soLuongNhap;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "phieuNhapId")
    @JsonBackReference
    @JsonIgnore
    PhieuNhap phieuNhap;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vatTuId")
    @JsonBackReference
    @JsonIgnore
    VatTu vatTu;
}
