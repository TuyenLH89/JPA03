package JPABS03_LamLai.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.validator.constraints.UniqueElements;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "phieunhap")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PhieuNhap {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "phieunhapid")
    int phieuNhapId;
    String maPhieu;
    String tieuDe;
    LocalDate ngayNhap;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "phieuNhap")
    @JsonManagedReference
    @JsonIgnore
    List<ChiTietPhieuNhap> chiTietPhieuNhaps;
}
