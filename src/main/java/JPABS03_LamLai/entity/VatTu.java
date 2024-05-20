package JPABS03_LamLai.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Entity
@Table(name = "vattu")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class VatTu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vattuid")
    int vatTuId;
    String tenVatTu;
    int soLuongTon;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "vatTu")
    @JsonManagedReference
    @JsonIgnore
    List<ChiTietPhieuNhap> chiTietPhieuNhaps;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "vatTu")
    @JsonManagedReference
    @JsonIgnore
    List<ChiTietPhieuXuat> chiTietPhieuXuats;
}
