package JPABS03_LamLai.service;

import JPABS03_LamLai.dto.request.ChiTietPhieuNhap_Request;
import JPABS03_LamLai.dto.request.PhieuNhap_Request;
import JPABS03_LamLai.dto.response.ChiTietPhieuNhap_Response;
import JPABS03_LamLai.dto.response.PhieuNhap_Response;
import JPABS03_LamLai.entity.ChiTietPhieuNhap;
import JPABS03_LamLai.entity.PhieuNhap;
import JPABS03_LamLai.entity.VatTu;
import JPABS03_LamLai.exception.AppException;
import JPABS03_LamLai.exception.ErrorCode;
import JPABS03_LamLai.mapper.PhieuNhapMapper;
import JPABS03_LamLai.repository.ChiTietPhieuNhapRepo;
import JPABS03_LamLai.repository.PhieuNhapRepo;
import JPABS03_LamLai.repository.VatTuRepo;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class PhieuNhapService {
    PhieuNhapRepo phieuNhapRepo;
    ChiTietPhieuNhapRepo chiTietPhieuNhapRepo;
    PhieuNhapMapper phieuNhapMapper;
    VatTuRepo vatTuRepo;
    public PhieuNhap_Response addPhieuNhap(PhieuNhap_Request request){
        PhieuNhap phieuNhap = phieuNhapMapper.toPhieuNhap(request);
        PhieuNhap_Response response = phieuNhapMapper.toPhieuNhapResponse(phieuNhapRepo.save(phieuNhap));
        List<ChiTietPhieuNhap_Response> value = new ArrayList<>();
        phieuNhap.setChiTietPhieuNhaps(addChiTiet(phieuNhap.getPhieuNhapId(), request.getChiTietPhieuNhaps(), value));
        response.setChiTietPhieuNhaps(value);
        return response;
    }
    List<ChiTietPhieuNhap> addChiTiet(int phieuNhapId, List<ChiTietPhieuNhap_Request> requests, List<ChiTietPhieuNhap_Response> responses){
        List<ChiTietPhieuNhap> result = new ArrayList<>();
        PhieuNhap phieuNhap = phieuNhapRepo.findById(phieuNhapId)
                .orElseThrow(()-> new AppException(ErrorCode.PHIEUNHAP_NOT_EXIST));
        for (ChiTietPhieuNhap_Request ct : requests){
            VatTu vatTu = vatTuRepo.findById(ct.getVatTuId())
                    .orElseThrow(()-> new AppException(ErrorCode.VATTU_NOT_EXIST));
            ChiTietPhieuNhap value = new ChiTietPhieuNhap();
            ChiTietPhieuNhap_Response response = new ChiTietPhieuNhap_Response();
            value.setPhieuNhap(phieuNhap);
            value.setVatTu(vatTu);
            value.setSoLuongNhap(ct.getSoLuongNhap());
            chiTietPhieuNhapRepo.save(value);

            vatTu.setSoLuongTon(vatTu.getSoLuongTon()+ct.getSoLuongNhap());
            vatTuRepo.save(vatTu);

            response.setTenVatTu(vatTu.getTenVatTu());
            response.setSoLuongNhap(ct.getSoLuongNhap());
            responses.add(response);

            result.add(value);
        }
        return result;
    }
}
