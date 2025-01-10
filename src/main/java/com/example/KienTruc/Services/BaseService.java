package com.example.KienTruc.Services;

import java.util.List;
import java.util.Optional;

public interface BaseService<T, ID> {
    /**
     * Lấy tất cả các bản ghi.
     * @return danh sách các bản ghi
     */
    List<T> getAll();

    /**
     * Lấy thông tin một bản ghi theo ID.
     * @param id ID của bản ghi
     * @return Optional chứa bản ghi (nếu tồn tại)
     */
    Optional<T> getById(ID id);

    /**
     * Thêm mới một bản ghi.
     * @param entity thông tin bản ghi cần thêm
     * @return bản ghi sau khi được lưu
     */
    T save(T entity);

    /**
     * Cập nhật thông tin bản ghi.
     * @param id ID của bản ghi cần cập nhật
     * @param entity thông tin mới của bản ghi
     * @return bản ghi sau khi cập nhật
     */
    T update(ID id, T entity);

    /**
     * Xóa một bản ghi theo ID.
     * @param id ID của bản ghi cần xóa
     */
    void delete(ID id);
}
