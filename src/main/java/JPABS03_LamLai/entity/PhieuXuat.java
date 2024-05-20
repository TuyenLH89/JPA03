package JPABS03_LamLai.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "phieuxuat")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PhieuXuat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "phieuxuatid")
    int phieuXuatId;
    String maPhieu;
    String tieuDe;
    LocalDate ngayXuat;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "phieuXuat")
    @JsonManagedReference
    @JsonIgnore
    List<ChiTietPhieuXuat> chiTietPhieuXuats;
}
