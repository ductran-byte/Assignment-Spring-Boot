-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th10 30, 2025 lúc 01:17 PM
-- Phiên bản máy phục vụ: 10.4.32-MariaDB
-- Phiên bản PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `restaurant_db`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `categories`
--

CREATE TABLE `categories` (
  `id` bigint(20) NOT NULL,
  `name` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `categories`
--

INSERT INTO `categories` (`id`, `name`) VALUES
(4, 'Hải sản'),
(3, 'Món chay'),
(2, 'Món luộc'),
(1, 'Món nướng'),
(5, 'Đồ uống');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `dishes`
--

CREATE TABLE `dishes` (
  `id` varchar(20) NOT NULL,
  `description` text DEFAULT NULL,
  `image_url` varchar(500) DEFAULT NULL,
  `last_modified_date` datetime(6) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `price` double NOT NULL,
  `start_date` datetime(6) NOT NULL,
  `status` enum('DELETED','ON_SALE','STOPPED') NOT NULL,
  `category_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `dishes`
--

INSERT INTO `dishes` (`id`, `description`, `image_url`, `last_modified_date`, `name`, `price`, `start_date`, `status`, `category_id`) VALUES
('DU001', 'Nước ép cam nguyên chất, mát lành và bổ dưỡng.', 'https://cdn.tgdd.vn/2020/07/CookProductThumb/nuocscam-620x620.jpg', '2025-10-29 01:01:20.000000', 'Nước ép cam tươi', 45000, '2025-10-28 19:31:10.000000', 'ON_SALE', 5),
('DU002', 'Sinh tố bơ béo ngậy kết hợp sữa tươi thơm ngon.', 'https://hasuka.com.vn/storage/uploads/v4ojgTcmGzX0bmRzgIdBHjIErtbCKL8eqZ9GKSc6.jpg', '2025-10-29 01:01:20.000000', 'Sinh tố bơ sữa', 50000, '2025-10-28 19:31:10.000000', 'ON_SALE', 5),
('DU003', 'Trà chanh pha mật ong tự nhiên, giải khát hiệu quả.', 'https://file.hstatic.net/1000135323/article/c3_4427dd948bdc4f46aa65853bf3f6aa03.jpg', '2025-10-29 01:01:20.000000', 'Trà chanh mật ong', 40000, '2025-10-28 19:31:10.000000', 'ON_SALE', 5),
('DU004', 'Cà phê phin truyền thống pha sữa đặc đậm đà.', 'https://images.openai.com/thumbnails/url/28TDMXicu5meUVJSUGylr5-al1xUWVCSmqJbkpRnoJdeXJJYkpmsl5yfq5-Zm5ieWmxfaAuUsXL0S7F0Tw4q9cktTw9zD3Z1qixyc_HzMTDwTy8ocvJz9K60LIkP8DeN9HL2tfQMDw92VCu2NTQAAAlpJGo', '2025-10-29 01:01:20.000000', 'Cà phê sữa đá', 35000, '2025-10-28 19:31:10.000000', 'STOPPED', 5),
('DU005', 'Dừa xiêm tươi mát lạnh, bổ sung năng lượng tức thì.', 'https://cdn.tgdd.vn/2021/09/CookDish/mach-ban-cach-bao-quan-nuoc-dua-dua-tuoi-got-vo-va-dua-chua-avt-1200x676.jpg', '2025-10-29 01:01:20.000000', 'Nước dừa tươi', 30000, '2025-10-28 19:31:10.000000', 'DELETED', 5),
('HS001', 'Tôm sú hấp bia giữ vị ngọt tự nhiên, thơm mùi lúa mạch.', 'https://cdn.pastaxi-manager.onepas.vn/content/uploads/articles/datnt/C%C3%A1ch%20l%C3%A0m%20t%C3%B4m%20h%E1%BA%A5p%20bia/cach-lam-tom-hap-bia%20%281%29.png', '2025-10-29 01:01:20.000000', 'Tôm hấp bia', 180000, '2025-10-28 19:31:10.000000', 'ON_SALE', 4),
('HS002', 'Cá hồi nướng bơ tỏi thơm béo, hấp dẫn.', 'https://cdn.tgdd.vn/Files/2020/03/19/1243099/ca-hoi-nuong-bo-toi-thom-ngon-giau-duong-chat-lai-lam-cuc-de-dang-202003190933577877.jpg', '2025-10-29 01:01:20.000000', 'Cá hồi nướng bơ tỏi', 200000, '2025-10-28 19:31:10.000000', 'ON_SALE', 4),
('HS003', 'Mực tươi xào sa tế cay nồng, đậm đà hương vị biển.', 'https://i.ytimg.com/vi/kQZ34Hl2X7s/maxresdefault.jpg', '2025-10-29 01:01:20.000000', 'Mực xào sa tế', 160000, '2025-10-28 19:31:10.000000', 'ON_SALE', 4),
('HS004', 'Cua rang me chua ngọt, đậm đà, hấp dẫn.', 'https://cdn.tgdd.vn/2022/01/CookRecipe/Avatar/cua-bien-rang-me-cong-thuc-chia-se-tu-nguoi-dung-thumbnail.jpg', '2025-10-29 01:01:20.000000', 'Cua rang me', 220000, '2025-10-28 19:31:10.000000', 'STOPPED', 4),
('HS005', 'Hàu tươi nướng cùng mỡ hành, hương vị tuyệt hảo.', 'https://delightfulplate.com/wp-content/uploads/2017/11/Vietnamese-grilled-oysters-with-scallion-oil-and-roasted-peanuts-hau-nuong-mo-hanh.jpg', '2025-10-29 01:01:20.000000', 'Hàu nướng mỡ hành', 130000, '2025-10-28 19:31:10.000000', 'DELETED', 4),
('MC001', 'Đậu hũ mềm sốt nấm đông cô đậm đà, bổ dưỡng.', 'https://cdn.tgdd.vn/Files/2021/08/04/1372963/cach-lam-dau-hu-non-sot-nam-dong-co-thom-ngon-cho-bua-com-thanh-tinh-202108042233276685.jpg', '2025-10-29 01:01:20.000000', 'Đậu hũ sốt nấm đông cô', 90000, '2025-10-28 19:31:10.000000', 'ON_SALE', 3),
('MC002', 'Bông cải, cà rốt, nấm, đậu Hà Lan xào chay thơm ngon.', 'https://bizweb.dktcdn.net/100/524/612/files/mon-chay-don-gian-3.jpg?v=1742533058220', '2025-10-29 01:01:20.000000', 'Rau củ xào thập cẩm', 85000, '2025-10-28 19:31:10.000000', 'ON_SALE', 3),
('MC003', 'Cà ri chay thơm béo với khoai, đậu và nước cốt dừa.', 'https://fullofplants.com/wp-content/uploads/2019/07/easy-spicy-vietnamese-curry-vegan-vegetarian-with-tofu-mushrooms-broccoli-taro-eggplant-thumb-768x768.jpg', '2025-10-29 01:01:20.000000', 'Cà ri chay kiểu Ấn', 95000, '2025-10-28 19:31:10.000000', 'ON_SALE', 3),
('MC004', 'Cơm chiên hạt tơi vàng ươm, đậm đà vị rau củ.', 'https://i.ytimg.com/vi/HCOjGOxUNj8/maxresdefault.jpg', '2025-10-29 01:01:20.000000', 'Cơm chiên chay Dương Châu', 80000, '2025-10-28 19:31:10.000000', 'STOPPED', 3),
('MC005', 'Nước dùng thanh mát, đậu hũ và chả chay đậm đà.', 'https://www.wokandkin.com/wp-content/uploads/2020/04/Bun-Rieu-Chay-saved-for-web.png', '2025-10-29 01:01:20.000000', 'Bún riêu chay', 90000, '2025-10-28 19:31:10.000000', 'DELETED', 3),
('ML001', 'Gà ta luộc lá chanh vàng ươm, thịt mềm ngọt tự nhiên.', 'https://images.openai.com/thumbnails/url/LJoX8nicu5mVUVJSUGylr5-al1xUWVCSmqJbkpRnoJdeXJJYkpmsl5yfq5-Zm5ieWmxfaAuUsXL0S7F0Tw4KCPNw8qssLXV3TcqpCi9zLUoMDkkL94n0MksJTfYqSEt1DnQMi8qqSnT3C3fJj3RMVisGAJXAJwM', '2025-10-29 01:01:20.000000', 'Gà luộc lá chanh', 120000, '2025-10-28 19:31:10.000000', 'ON_SALE', 2),
('ML002', 'Thịt ba chỉ luộc mềm, chấm mắm tôm pha ớt chanh.', 'https://images.squarespace-cdn.com/content/v1/5fea2abc039da13de8f0a346/1635356860996-R6D94R0K47ZGBODR9OLM/9504E2A5-49E3-4C67-B2EC-E353995DECCE.JPG', '2025-10-29 01:01:20.000000', 'Thịt ba chỉ luộc', 110000, '2025-10-28 19:31:10.000000', 'ON_SALE', 2),
('ML003', 'Tôm tươi luộc cùng sả và gừng, giữ trọn vị ngọt.', 'https://i0.wp.com/mmbonappetit.com/wp-content/uploads/2021/01/Tom-luoc-bia-2.jpg?resize=750%2C938&ssl=1', '2025-10-29 01:01:20.000000', 'Tôm luộc sả gừng', 150000, '2025-10-28 19:31:10.000000', 'ON_SALE', 2),
('ML004', 'Bò luộc thái mỏng chấm nước mắm gừng cay nồng.', 'https://i.ytimg.com/vi/qxo40XHXdKE/hq720.jpg?rs=AOn4CLD6Ucoj1vyujqk51BBgNmGC-6DbwA&sqp=-oaymwEhCK4FEIIDSFryq4qpAxMIARUAAAAAGAElAADIQj0AgKJD', '2025-10-29 01:01:20.000000', 'Bò luộc chấm gừng', 180000, '2025-10-28 19:31:10.000000', 'STOPPED', 2),
('ML005', 'Mực luộc giữ vị ngọt tự nhiên, ăn kèm nước chấm gừng.', 'https://cdn.tgdd.vn/Files/2021/11/06/1396117/bo-tui-2-cong-thuc-lam-muc-hap-hanh-thom-lung-cho-bua-com-gia-dinh-202111060937001495.jpg', '2025-10-29 01:01:20.000000', 'Mực luộc ớt tỏi', 170000, '2025-10-28 19:31:10.000000', 'DELETED', 2),
('MN001', 'Sườn heo ướp gia vị BBQ nướng than hồng thơm lừng.', 'https://images.openai.com/thumbnails/url/rr2HVHicu5mZUVJSUGylr5-al1xUWVCSmqJbkpRnoJdeXJJYkpmsl5yfq5-Zm5ieWmxfaAuUsXL0S7F0Tw4MDo4oNTBxzgrzcDKsLPXzSsw1DDEuSasMK3c0C3L0ywn1yyx1ifDxMsqxcDeqjExWKwYATFQlkw', '2025-10-29 01:01:20.000000', 'Sườn nướng BBQ', 150000, '2025-10-28 19:31:10.000000', 'ON_SALE', 1),
('MN002', 'Ba chỉ heo nướng kiểu Hàn ăn kèm kim chi và rau cuốn.', 'https://static.hawonkoo.vn/hwks1/images/2023/10/cach-lam-thit-ba-chi-nuong-han-quoc-2.jpg', '2025-10-29 01:01:20.000000', 'Ba chỉ nướng Hàn Quốc', 180000, '2025-10-28 19:31:10.000000', 'ON_SALE', 1),
('MN003', 'Gà ta tẩm mật ong nướng lửa than vàng ươm, thơm ngọt.', 'https://cdn.tgdd.vn/2020/09/CookProduct/1-1200x676-24.jpg', '2025-10-29 01:01:20.000000', 'Gà nướng mật ong', 160000, '2025-10-28 19:31:10.000000', 'ON_SALE', 1),
('MN004', 'Thịt bò cuộn lá lốt nướng thơm lừng, ăn kèm bún và rau sống.', 'https://upload.wikimedia.org/wikipedia/commons/9/95/B%C3%B2_n%C6%B0%E1%BB%9Bng_l%C3%A1_l%E1%BB%91t_t%E1%BA%A1i_Manchester.jpg', '2025-10-29 01:01:20.000000', 'Bò nướng lá lốt', 140000, '2025-10-28 19:31:10.000000', 'STOPPED', 1),
('MN005', 'Tôm nướng muối ớt cay nồng, đậm vị, hấp dẫn.', 'https://cdn.netspace.edu.vn/images/2020/05/01/cach-lam-tom-nuong-muoi-ot-ai-cung-ghien-800.jpg', '2025-10-29 01:01:20.000000', 'Tôm nướng muối ớt', 190000, '2025-10-28 19:31:10.000000', 'DELETED', 1);

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `categories`
--
ALTER TABLE `categories`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UKt8o6pivur7nn124jehx7cygw5` (`name`);

--
-- Chỉ mục cho bảng `dishes`
--
ALTER TABLE `dishes`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKgbu6erefir17660qutbbjnma7` (`category_id`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `categories`
--
ALTER TABLE `categories`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `dishes`
--
ALTER TABLE `dishes`
  ADD CONSTRAINT `FKgbu6erefir17660qutbbjnma7` FOREIGN KEY (`category_id`) REFERENCES `categories` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
