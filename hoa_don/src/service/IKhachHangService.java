package service;

import entity.KhachHang;

import java.util.List;

public interface IKhachHangService extends IService<KhachHang>,ILoaiKhachService {
    List<KhachHang> findByName(String name);
}
