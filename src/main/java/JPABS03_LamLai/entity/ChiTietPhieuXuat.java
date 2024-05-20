package JPABS03_LamLai.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "chitietphieuxuat")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ChiTietPhieuXuat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "chitietphieuxuatid")
    int chiTietPhieuXuatId;
    int soLuongXuat;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "phieuXuatId")
    @JsonBackReference
    @JsonIgnore
    PhieuXuat phieuXuat;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vatTuId")
    @JsonBackReference
    @JsonIgnore
    VatTu vatTu;
}
