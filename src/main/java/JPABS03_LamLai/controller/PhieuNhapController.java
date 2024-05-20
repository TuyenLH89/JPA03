package JPABS03_LamLai.controller;

import JPABS03_LamLai.dto.request.PhieuNhap_Request;
import JPABS03_LamLai.dto.response.ApiResponse;
import JPABS03_LamLai.dto.response.PhieuNhap_Response;
import JPABS03_LamLai.service.PhieuNhapService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/phieunhap")
public class PhieuNhapController {
    @Autowired
    PhieuNhapService phieuNhapService;
    @PostMapping("/addphieunhap")
    ApiResponse<PhieuNhap_Response> addPhieuNhap(@RequestBody @Valid PhieuNhap_Request request){
        ApiResponse<PhieuNhap_Response> apiResponse = new ApiResponse<>();
        apiResponse.setResult(phieuNhapService.addPhieuNhap(request));
        return apiResponse;
    }
}
