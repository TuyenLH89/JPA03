package JPABS03_LamLai.service;

import JPABS03_LamLai.dto.request.ChiTietPhieuNhap_Request;
import JPABS03_LamLai.dto.request.ChiTietPhieuXuat_Request;
import JPABS03_LamLai.dto.request.PhieuNhap_Request;
import JPABS03_LamLai.dto.request.PhieuXuat_Request;
import JPABS03_LamLai.dto.response.ChiTietPhieuXuat_Response;
import JPABS03_LamLai.dto.response.PhieuXuat_Response;
import JPABS03_LamLai.entity.ChiTietPhieuXuat;
import JPABS03_LamLai.entity.PhieuXuat;
import JPABS03_LamLai.entity.VatTu;
import JPABS03_LamLai.exception.AppException;
import JPABS03_LamLai.exception.ErrorCode;
import JPABS03_LamLai.mapper.PhieuNhapMapper;
import JPABS03_LamLai.mapper.PhieuXuatMapper;
import JPABS03_LamLai.repository.*;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class PhieuXuatService {
    PhieuXuatRepo phieuXuatRepo;
    ChiTietPhieuXuatRepo chiTietPhieuXuatRepo;
    PhieuXuatMapper phieuXuatMapper;
    VatTuRepo vatTuRepo;

    public PhieuXuat_Response addPhieuXuat(PhieuXuat_Request request){
        PhieuXuat phieuXuat = phieuXuatMapper.toPhieuXuat(request);
        PhieuXuat_Response response = phieuXuatMapper.toPhieuXuatResponse(phieuXuatRepo.save(phieuXuat));
        List<ChiTietPhieuXuat_Response> value = new ArrayList<>();
        phieuXuat.setChiTietPhieuXuats(addChiTiet(phieuXuat.getPhieuXuatId(), request.getChiTietPhieuXuats(), value));
        response.setChiTietPhieuXuats(value);
        return response;
    }
    List<ChiTietPhieuXuat> addChiTiet(int phieuXuatId, List<ChiTietPhieuXuat_Request> requests, List<ChiTietPhieuXuat_Response> responses){
        List<ChiTietPhieuXuat> result = new ArrayList<>();
        PhieuXuat phieuXuat = phieuXuatRepo.findById(phieuXuatId)
                .orElseThrow(()-> new AppException(ErrorCode.PHIEUXUAT_NOT_EXIST));
        for (ChiTietPhieuXuat_Request ct : requests){
            ChiTietPhieuXuat_Response response = new ChiTietPhieuXuat_Response();
            VatTu vatTu = vatTuRepo.findById(ct.getVatTuId())
                    .orElseThrow(()-> new AppException(ErrorCode.VATTU_NOT_EXIST));
            ChiTietPhieuXuat value = new ChiTietPhieuXuat();
            value.setPhieuXuat(phieuXuat);
            value.setVatTu(vatTu);
            value.setSoLuongXuat(ct.getSoLuongXuat());
            chiTietPhieuXuatRepo.save(value);

            vatTu.setSoLuongTon(vatTu.getSoLuongTon() - ct.getSoLuongXuat());
            vatTuRepo.save(vatTu);

            response.setTenVatTu(vatTu.getTenVatTu());
            response.setSoLuongXuat(ct.getSoLuongXuat());
            responses.add(response);

            result.add(value);
        }
        return result;
    }
}
