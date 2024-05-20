package JPABS03_LamLai.exception;

public enum ErrorCode {
    KEY_ERROR_NOT_EXIST(0000, "error key not exist"),
    VATTU_EXISTED(1001, "Vat tu exists"),
    PHIEUNHAP_NOT_EXIST(1002, "Phieu Nhap not exist"),
    VATTU_NOT_EXIST(1003, "Vat Tu not exist"),
    PHIEUXUAT_NOT_EXIST(1004, "Phieu Xuat not exist"),
    MAPHIEU_EXIST(1005, "Ma Phieu exist")
    ;
    private int code;
    private String message;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
