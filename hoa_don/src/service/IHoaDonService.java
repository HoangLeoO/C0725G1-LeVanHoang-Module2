package service;

import entity.HoaDon;

public interface IHoaDonService extends IService<HoaDon> {
    boolean update(HoaDon hoaDon);
}
