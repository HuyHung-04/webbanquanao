package com.example.asmj5.asm.service;

import com.example.asmj5.asm.entity.HoaDon;
import com.example.asmj5.asm.entity.KhachHang;
import com.example.asmj5.asm.entity.NhanVien;
import com.example.asmj5.asm.repository.HoaDonRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.*;

import static org.mockito.Mockito.*;

class HoaDonServiceTest {

    @InjectMocks
    private HoaDonService hoaDonService;

    @Mock
    private HoaDonRepository hoaDonRepository;

    @BeforeEach
    void setUp() {
        // Mở mock để Mockito có thể giả lập đối tượng repository
        MockitoAnnotations.openMocks(this);
    }

    // Test Case 1: Tạo hóa đơn với thông tin đầy đủ
    @Test
    void add_ShouldSaveHoaDon() {
        HoaDon hoaDon = new HoaDon(1, LocalDate.now(), false, new KhachHang(), new NhanVien());
        hoaDonService.add(hoaDon);
        verify(hoaDonRepository, times(1)).save(hoaDon);
    }

    // Test Case 2: Tạo hóa đơn với trạng thái thanh toán là true
    @Test
    void add_ShouldSaveHoaDonWithPaidStatus() {
        HoaDon hoaDon = new HoaDon(2, LocalDate.now(), true, new KhachHang(), new NhanVien());
        hoaDonService.add(hoaDon);
        verify(hoaDonRepository, times(1)).save(hoaDon);
    }

    // Test Case 3: Tạo hóa đơn không có khách hàng
    @Test
    void add_ShouldSaveHoaDonWithoutCustomer() {
        HoaDon hoaDon = new HoaDon(3, LocalDate.now(), false, null, new NhanVien());
        hoaDonService.add(hoaDon);
        verify(hoaDonRepository, times(1)).save(hoaDon);
    }

    // Test Case 4: Tạo hóa đơn không có nhân viên
    @Test
    void add_ShouldSaveHoaDonWithoutEmployee() {
        HoaDon hoaDon = new HoaDon(4, LocalDate.now(), false, new KhachHang(), null);
        hoaDonService.add(hoaDon);
        verify(hoaDonRepository, times(1)).save(hoaDon);
    }

    // Test Case 5: Tạo hóa đơn với ngày mua hàng trong tương lai
    @Test
    void add_ShouldSaveHoaDonWithFuturePurchaseDate() {
        HoaDon hoaDon = new HoaDon(5, LocalDate.now().plusDays(1), false, new KhachHang(), new NhanVien());
        hoaDonService.add(hoaDon);
        verify(hoaDonRepository, times(1)).save(hoaDon);
    }

    // Test Case 6: Tạo hóa đơn với ngày mua hàng quá khứ
    @Test
    void add_ShouldSaveHoaDonWithPastPurchaseDate() {
        HoaDon hoaDon = new HoaDon(6, LocalDate.now().minusDays(1), false, new KhachHang(), new NhanVien());
        hoaDonService.add(hoaDon);
        verify(hoaDonRepository, times(1)).save(hoaDon);
    }

    // Test Case 7: Tạo hóa đơn với trạng thái thanh toán là false
    @Test
    void add_ShouldSaveHoaDonWithUnpaidStatus() {
        HoaDon hoaDon = new HoaDon(7, LocalDate.now(), false, new KhachHang(), new NhanVien());
        hoaDonService.add(hoaDon);
        verify(hoaDonRepository, times(1)).save(hoaDon);
    }

    // Test Case 8: Tạo hóa đơn với ID đã có (Kiểm tra việc không cập nhật)
    @Test
    void add_ShouldNotSaveHoaDonWithExistingId() {
        HoaDon hoaDon = new HoaDon(1, LocalDate.now(), false, new KhachHang(), new NhanVien());
        when(hoaDonRepository.existsById(1)).thenReturn(true); // Giả lập ID đã tồn tại
        hoaDonService.add(hoaDon);
        verify(hoaDonRepository, never()).save(hoaDon); // Không gọi save nếu ID đã có
    }

    // Test Case 9: Tạo hóa đơn với thông tin null
    @Test
    void add_ShouldThrowExceptionWithNullInfo() {
        HoaDon hoaDon = new HoaDon(); // Không có thông tin nào
        Assertions.assertThrows(IllegalArgumentException.class, () -> hoaDonService.add(hoaDon));
    }

    // Test Case 10: Tạo hóa đơn với khách hàng và nhân viên đều null
    @Test
    void add_ShouldThrowExceptionWithNullCustomerAndEmployee() {
        HoaDon hoaDon = new HoaDon(10, LocalDate.now(), false, null, null);
        Assertions.assertThrows(IllegalArgumentException.class, () -> hoaDonService.add(hoaDon));
    }
    // Test Case 11: Cập nhật và lưu HoaDon với dữ liệu hợp lệ
    @Test
    void update_ShouldSaveHoaDonWithValidData() {
        HoaDon hoaDon = new HoaDon(1, LocalDate.now(), false, null, null);
        when(hoaDonRepository.findById(1)).thenReturn(Optional.of(hoaDon));
        hoaDonService.update(hoaDon);
        verify(hoaDonRepository, times(1)).save(hoaDon);
    }
    // Test Case 12: Cập nhật và ném lỗi khi HoaDon không tồn tại
    @Test
    void update_ShouldThrowExceptionWhenHoaDonDoesNotExist() {
        HoaDon hoaDon = new HoaDon(99, LocalDate.now(), false, null, null);
        when(hoaDonRepository.findById(99)).thenReturn(Optional.empty());
        Assertions.assertThrows(NoSuchElementException.class, () -> hoaDonService.update(hoaDon));
    }
    // Test Case 13: Cập nhật và ném lỗi khi HoaDon là null
    @Test
    void update_ShouldThrowExceptionWhenHoaDonIsNull() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> hoaDonService.update(null));
    }
    // Test Case 14: Cập nhật và ném lỗi khi repository ném lỗi
    @Test
    void update_ShouldThrowExceptionWhenRepositoryThrowsError() {
        HoaDon hoaDon = new HoaDon(1, LocalDate.now(), false, null, null);
        when(hoaDonRepository.save(any())).thenThrow(RuntimeException.class);
        Assertions.assertThrows(RuntimeException.class, () -> hoaDonService.update(hoaDon));
    }
    // Test Case 15: Cập nhật và lưu HoaDon với khách hàng null
    @Test
    void update_ShouldSaveHoaDonWithNullCustomer() {
        HoaDon hoaDon = new HoaDon(2, LocalDate.now(), false, null, null);
        when(hoaDonRepository.findById(2)).thenReturn(Optional.of(hoaDon));
        hoaDonService.update(hoaDon);
        verify(hoaDonRepository, times(1)).save(hoaDon);
    }
    // Test Case 16: Cập nhật và lưu HoaDon với nhân viên null
    @Test
    void update_ShouldSaveHoaDonWithNullEmployee() {
        HoaDon hoaDon = new HoaDon(3, LocalDate.now(), false, null, null);
        when(hoaDonRepository.findById(3)).thenReturn(Optional.of(hoaDon));
        hoaDonService.update(hoaDon);
        verify(hoaDonRepository, times(1)).save(hoaDon);
    }
    // Test Case 17: Cập nhật và lưu HoaDon với ngày trong tương lai
    @Test
    void update_ShouldSaveHoaDonWithFutureDate() {
        HoaDon hoaDon = new HoaDon(4, LocalDate.now().plusDays(5), false, null, null);
        when(hoaDonRepository.findById(4)).thenReturn(Optional.of(hoaDon));
        hoaDonService.update(hoaDon);
        verify(hoaDonRepository, times(1)).save(hoaDon);
    }
    // Test Case 18: Cập nhật và lưu HoaDon với ngày trong quá khứ
    @Test
    void update_ShouldSaveHoaDonWithPastDate() {
        HoaDon hoaDon = new HoaDon(5, LocalDate.now().minusDays(5), false, null, null);
        when(hoaDonRepository.findById(5)).thenReturn(Optional.of(hoaDon));
        hoaDonService.update(hoaDon);
        verify(hoaDonRepository, times(1)).save(hoaDon);
    }
    // Test Case 19: Cập nhật và lưu HoaDon khi trạng thái thanh toán thay đổi thành true
    @Test
    void update_ShouldSaveHoaDonWhenPaymentStatusChangesToTrue() {
        HoaDon hoaDon = new HoaDon(6, LocalDate.now(), false, null, null);
        when(hoaDonRepository.findById(6)).thenReturn(Optional.of(hoaDon));
        hoaDon.setTrangThai(true);
        hoaDonService.update(hoaDon);
        verify(hoaDonRepository, times(1)).save(hoaDon);
    }
    // Test Case 20: Cập nhật và lưu HoaDon khi trạng thái thanh toán thay đổi thành false
    @Test
    void update_ShouldSaveHoaDonWhenPaymentStatusChangesToFalse() {
        HoaDon hoaDon = new HoaDon(7, LocalDate.now(), true, null, null);
        when(hoaDonRepository.findById(7)).thenReturn(Optional.of(hoaDon));
        hoaDon.setTrangThai(false);
        hoaDonService.update(hoaDon);
        verify(hoaDonRepository, times(1)).save(hoaDon);
    }
    // Test Case 21: Trả về HoaDon với ID hợp lệ
    @Test
    void findById_ShouldReturnHoaDonWithValidId() {
        HoaDon hoaDon = new HoaDon(1, LocalDate.now(), false, new KhachHang(), new NhanVien());
        when(hoaDonRepository.findById(1)).thenReturn(Optional.of(hoaDon));
        HoaDon result = hoaDonService.findById(1);
        Assertions.assertEquals(hoaDon, result);
    }
    // Test Case 22: Ném lỗi khi ID không tồn tại
    @Test
    void findById_ShouldThrowExceptionForNonExistentId() {
        when(hoaDonRepository.findById(99)).thenReturn(Optional.empty());
        Assertions.assertThrows(NoSuchElementException.class, () -> hoaDonService.findById(99));
    }
    // Test Case 23: Ném lỗi khi ID là null
    @Test
    void findById_ShouldThrowExceptionForNullId() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> hoaDonService.findById(null));
    }
    // Test Case 24: Ném lỗi khi ID là giá trị âm
    @Test
    void findById_ShouldThrowExceptionForNegativeId() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> hoaDonService.findById(-1));
    }
    // Test Case 25: Ném lỗi khi ID là 0
    @Test
    void findById_ShouldThrowExceptionForZeroId() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> hoaDonService.findById(0));
    }
    // Test Case 26: Xử lý ID lớn
    @Test
    void findById_ShouldHandleLargeId() {
        HoaDon hoaDon = new HoaDon(1234567890, LocalDate.now(), true, new KhachHang(), new NhanVien());
        when(hoaDonRepository.findById(1234567890)).thenReturn(Optional.of(hoaDon));
        HoaDon result = hoaDonService.findById(1234567890);
        Assertions.assertEquals(hoaDon, result);
    }
    // Test Case 27: Ném lỗi khi repository ném lỗi
    @Test
    void findById_ShouldThrowExceptionWhenRepositoryThrowsError() {
        when(hoaDonRepository.findById(anyInt())).thenThrow(RuntimeException.class);
        Assertions.assertThrows(RuntimeException.class, () -> hoaDonService.findById(1));
    }
    // Test Case 28: Trả về HoaDon với trạng thái chưa thanh toán
    @Test
    void findById_ShouldReturnHoaDonWithUnpaidStatus() {
        HoaDon hoaDon = new HoaDon(8, LocalDate.now(), false, new KhachHang(), new NhanVien());
        when(hoaDonRepository.findById(8)).thenReturn(Optional.of(hoaDon));
        HoaDon result = hoaDonService.findById(8);
        Assertions.assertFalse(result.isTrangThai());
    }
    // Test Case 29: Trả về HoaDon với trạng thái đã thanh toán
    @Test
    void findById_ShouldReturnHoaDonWithPaidStatus() {
        HoaDon hoaDon = new HoaDon(9, LocalDate.now(), true, new KhachHang(), new NhanVien());
        when(hoaDonRepository.findById(9)).thenReturn(Optional.of(hoaDon));
        HoaDon result = hoaDonService.findById(9);
        Assertions.assertTrue(result.isTrangThai());
    }
    // Test Case 30: Ném lỗi khi ID có định dạng không hợp lệ
    @Test
    void findById_ShouldThrowExceptionForInvalidIdFormat() {
        Assertions.assertThrows(NumberFormatException.class, () -> hoaDonService.findById(Integer.parseInt("invalid")));
    }
    // Test Case 31: Trả về danh sách HoaDon chưa thanh toán
    @Test
    void getAll_ShouldReturnUnpaidHoaDons() {
        HoaDon hoaDon1 = new HoaDon(1, LocalDate.now(), false, new KhachHang(), new NhanVien());
        HoaDon hoaDon2 = new HoaDon(2, LocalDate.now(), false, new KhachHang(), new NhanVien());
        when(hoaDonRepository.findByTrangThai(false)).thenReturn(List.of(hoaDon1, hoaDon2));

        List<HoaDon> result = hoaDonService.getAll();

        Assertions.assertEquals(2, result.size());
        Assertions.assertFalse(result.get(0).isTrangThai());
        Assertions.assertFalse(result.get(1).isTrangThai());
    }
    // Test Case 32: Trả về danh sách rỗng khi không có HoaDon chưa thanh toán
    @Test
    void getAll_ShouldReturnEmptyListWhenNoUnpaidHoaDons() {
        when(hoaDonRepository.findByTrangThai(false)).thenReturn(Collections.emptyList());

        List<HoaDon> result = hoaDonService.getAll();

        Assertions.assertTrue(result.isEmpty());
    }
    // Test Case 33: Trả về null khi repository trả về null
    @Test
    void getAll_ShouldReturnNullWhenRepositoryReturnsNull() {
        when(hoaDonRepository.findByTrangThai(false)).thenReturn(null);

        List<HoaDon> result = hoaDonService.getAll();

        Assertions.assertNull(result);
    }
    // Test Case 34: Xử lý với số lượng HoaDon lớn
    @Test
    void getAll_ShouldHandleLargeNumberOfHoaDons() {
        List<HoaDon> hoaDons = new ArrayList<>();
        for (int i = 1; i <= 1001; i++) {
            hoaDons.add(new HoaDon(i, LocalDate.now(), false, new KhachHang(), new NhanVien()));
        }
        when(hoaDonRepository.findByTrangThai(false)).thenReturn(hoaDons);

        List<HoaDon> result = hoaDonService.getAll();

        Assertions.assertEquals(1001, result.size());
    }
    // Test Case 35: Trả về danh sách rỗng khi tất cả HoaDon đã thanh toán
    @Test
    void getAll_ShouldReturnEmptyListWhenAllHoaDonsArePaid() {
        HoaDon hoaDon1 = new HoaDon(1, LocalDate.now(), true, new KhachHang(), new NhanVien());
        HoaDon hoaDon2 = new HoaDon(2, LocalDate.now(), true, new KhachHang(), new NhanVien());
        when(hoaDonRepository.findByTrangThai(false)).thenReturn(Collections.emptyList());

        List<HoaDon> result = hoaDonService.getAll();

        Assertions.assertTrue(result.isEmpty());
    }
    // Test Case 36: Ném lỗi khi repository ném lỗi
    @Test
    void getAll_ShouldThrowExceptionWhenRepositoryThrowsError() {
        when(hoaDonRepository.findByTrangThai(false)).thenThrow(RuntimeException.class);

        Assertions.assertThrows(RuntimeException.class, () -> hoaDonService.getAll());
    }
    // Test Case 37: Trả về HoaDon chưa thanh toán với trạng thái mặc định
    @Test
    void getAll_ShouldReturnUnpaidHoaDonsWithDefaultStatus() {
        HoaDon hoaDon1 = new HoaDon(1, LocalDate.now(), false, new KhachHang(), new NhanVien());
        HoaDon hoaDon2 = new HoaDon(2, LocalDate.now(), false, new KhachHang(), new NhanVien());
        when(hoaDonRepository.findByTrangThai(false)).thenReturn(List.of(hoaDon1, hoaDon2));

        List<HoaDon> result = hoaDonService.getAll();

        Assertions.assertFalse(result.get(0).isTrangThai());
        Assertions.assertFalse(result.get(1).isTrangThai());
    }
    // Test Case 38: Trả về HoaDon chưa thanh toán với khách hàng null
    @Test
    void getAll_ShouldReturnUnpaidHoaDonsWithNullCustomer() {
        HoaDon hoaDon1 = new HoaDon(1, LocalDate.now(), false, null, new NhanVien());
        HoaDon hoaDon2 = new HoaDon(2, LocalDate.now(), false, null, new NhanVien());
        when(hoaDonRepository.findByTrangThai(false)).thenReturn(List.of(hoaDon1, hoaDon2));

        List<HoaDon> result = hoaDonService.getAll();

        Assertions.assertNull(result.get(0).getKhachHang());
        Assertions.assertNull(result.get(1).getKhachHang());
    }
    // Test Case 39: Trả về HoaDon chưa thanh toán với nhân viên null
    @Test
    void getAll_ShouldReturnUnpaidHoaDonsWithNullEmployee() {
        HoaDon hoaDon1 = new HoaDon(1, LocalDate.now(), false, new KhachHang(), null);
        HoaDon hoaDon2 = new HoaDon(2, LocalDate.now(), false, new KhachHang(), null);
        when(hoaDonRepository.findByTrangThai(false)).thenReturn(List.of(hoaDon1, hoaDon2));

        List<HoaDon> result = hoaDonService.getAll();

        Assertions.assertNull(result.get(0).getNhanVien());
        Assertions.assertNull(result.get(1).getNhanVien());
    }
    // Test Case 40: Trả về HoaDon chưa thanh toán với ngày mua hàng không hợp lệ
    @Test
    void getAll_ShouldReturnUnpaidHoaDonsWithInvalidPurchaseDate() {
        HoaDon hoaDon1 = new HoaDon(1, LocalDate.now().plusDays(1), false, new KhachHang(), new NhanVien()); // Future date
        HoaDon hoaDon2 = new HoaDon(2, LocalDate.now().minusDays(1), false, new KhachHang(), new NhanVien()); // Past date
        when(hoaDonRepository.findByTrangThai(false)).thenReturn(List.of(hoaDon1, hoaDon2));

        List<HoaDon> result = hoaDonService.getAll();
        Assertions.assertFalse(result.get(0).isTrangThai());
        Assertions.assertFalse(result.get(1).isTrangThai());
    }
    // Test Case 41: Trả về danh sách hóa đơn đã thanh toán
    @Test
    void getAllDaThanhToan_ShouldReturnPaidHoaDons() {
        HoaDon hoaDon1 = new HoaDon(1, LocalDate.now(), true, new KhachHang(), new NhanVien());
        HoaDon hoaDon2 = new HoaDon(2, LocalDate.now(), true, new KhachHang(), new NhanVien());
        when(hoaDonRepository.findByTrangThaiTrue()).thenReturn(List.of(hoaDon1, hoaDon2));

        List<HoaDon> result = hoaDonService.getAllDaThanhToan();

        Assertions.assertEquals(2, result.size());
        Assertions.assertTrue(result.get(0).isTrangThai());
        Assertions.assertTrue(result.get(1).isTrangThai());
    }
    // Test Case 42: Trả về danh sách rỗng khi không có hóa đơn đã thanh toán
    @Test
    void getAllDaThanhToan_ShouldReturnEmptyListWhenNoPaidHoaDons() {
        when(hoaDonRepository.findByTrangThai(true)).thenReturn(Collections.emptyList());

        List<HoaDon> result = hoaDonService.getAllDaThanhToan();

        Assertions.assertTrue(result.isEmpty());
    }
    // Test Case 43: Trả về null khi repository trả về null
    @Test
    void getAllDaThanhToan_ShouldReturnNullWhenRepositoryReturnsNull() {
        when(hoaDonRepository.findByTrangThaiTrue()).thenReturn(null);

        List<HoaDon> result = hoaDonService.getAllDaThanhToan();

        Assertions.assertNull(result);
    }
    // Test Case 44: Trả về danh sách rỗng khi tất cả hóa đơn đều chưa thanh toán
    @Test
    void getAllDaThanhToan_ShouldReturnEmptyListWhenAllHoaDonsAreUnpaid() {
        HoaDon hoaDon1 = new HoaDon(1, LocalDate.now(), false, new KhachHang(), new NhanVien());
        HoaDon hoaDon2 = new HoaDon(2, LocalDate.now(), false, new KhachHang(), new NhanVien());
        when(hoaDonRepository.findByTrangThai(true)).thenReturn(Collections.emptyList());

        List<HoaDon> result = hoaDonService.getAllDaThanhToan();

        Assertions.assertTrue(result.isEmpty());
    }
    // Test Case 45: Ném lỗi khi repository ném lỗi
    @Test
    void getAllDaThanhToan_ShouldThrowExceptionWhenRepositoryThrowsError() {
        when(hoaDonRepository.findByTrangThaiTrue()).thenThrow(RuntimeException.class);

        Assertions.assertThrows(RuntimeException.class, () -> hoaDonService.getAllDaThanhToan());
    }
    // Test Case 46: Trả về hóa đơn đã thanh toán với trạng thái mặc định
    @Test
    void getAllDaThanhToan_ShouldReturnPaidHoaDonsWithDefaultStatus() {
        HoaDon hoaDon1 = new HoaDon(1, LocalDate.now(), true, new KhachHang(), new NhanVien());
        HoaDon hoaDon2 = new HoaDon(2, LocalDate.now(), true, new KhachHang(), new NhanVien());
        when(hoaDonRepository.findByTrangThaiTrue()).thenReturn(List.of(hoaDon1, hoaDon2));

        List<HoaDon> result = hoaDonService.getAllDaThanhToan();

        Assertions.assertTrue(result.get(0).isTrangThai());
        Assertions.assertTrue(result.get(1).isTrangThai());
    }
    // Test Case 47: Trả về hóa đơn đã thanh toán với khách hàng là null
    @Test
    void getAllDaThanhToan_ShouldReturnPaidHoaDonsWithNullCustomer() {
        HoaDon hoaDon1 = new HoaDon(1, LocalDate.now(), true, null, new NhanVien());
        HoaDon hoaDon2 = new HoaDon(2, LocalDate.now(), true, null, new NhanVien());
        when(hoaDonRepository.findByTrangThaiTrue()).thenReturn(List.of(hoaDon1, hoaDon2));

        List<HoaDon> result = hoaDonService.getAllDaThanhToan();

        Assertions.assertNull(result.get(0).getKhachHang());
        Assertions.assertNull(result.get(1).getKhachHang());
    }
    // Test Case 48: Trả về hóa đơn đã thanh toán với nhân viên là null
    @Test
    void getAllDaThanhToan_ShouldReturnPaidHoaDonsWithNullEmployee() {
        HoaDon hoaDon1 = new HoaDon(1, LocalDate.now(), true, new KhachHang(), null);
        HoaDon hoaDon2 = new HoaDon(2, LocalDate.now(), true, new KhachHang(), null);
        when(hoaDonRepository.findByTrangThaiTrue()).thenReturn(List.of(hoaDon1, hoaDon2));

        List<HoaDon> result = hoaDonService.getAllDaThanhToan();

        Assertions.assertNull(result.get(0).getNhanVien());
        Assertions.assertNull(result.get(1).getNhanVien());
    }
    // Test Case 49: Trả về hóa đơn đã thanh toán với ngày mua hàng không hợp lệ
    @Test
    void getAllDaThanhToan_ShouldReturnPaidHoaDonsWithInvalidPurchaseDate() {
        HoaDon hoaDon1 = new HoaDon(1, LocalDate.now().plusDays(1), true, new KhachHang(), new NhanVien()); // Future date
        HoaDon hoaDon2 = new HoaDon(2, LocalDate.now().minusDays(1), true, new KhachHang(), new NhanVien()); // Past date
        when(hoaDonRepository.findByTrangThaiTrue()).thenReturn(List.of(hoaDon1, hoaDon2));

        List<HoaDon> result = hoaDonService.getAllDaThanhToan();

        // Assert that both entries are returned, even with invalid dates
        Assertions.assertTrue(result.get(0).isTrangThai());
        Assertions.assertTrue(result.get(1).isTrangThai());
    }
    // Test Case 50: Kiểm tra hiệu suất với số lượng hóa đơn lớn
    @Test
    void getAllDaThanhToan_ShouldHandleLargeNumberOfHoaDons() {
        List<HoaDon> hoaDons = new ArrayList<>();
        for (int i = 1; i <= 1001; i++) {
            hoaDons.add(new HoaDon(i, LocalDate.now(), true, new KhachHang(), new NhanVien()));
        }
        when(hoaDonRepository.findByTrangThaiTrue()).thenReturn(hoaDons);

        List<HoaDon> result = hoaDonService.getAllDaThanhToan();

        Assertions.assertEquals(1001, result.size());
    }
}
