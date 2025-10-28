package com.t2404e.assignment1.config;

import com.t2404e.assignment1.entity.Category;
import com.t2404e.assignment1.entity.Dish;
import com.t2404e.assignment1.entity.DishStatus;
import com.t2404e.assignment1.repository.CategoryRepository;
import com.t2404e.assignment1.repository.DishRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
@RequiredArgsConstructor
public class DataSeeder implements CommandLineRunner {

    private final CategoryRepository categoryRepository;
    private final DishRepository dishRepository;

    @Override
    public void run(String... args) {

        // Định nghĩa thời gian chung
        LocalDateTime now = LocalDateTime.now();

        // ====== 1️⃣ Thêm danh mục ======
        List<Category> categories = List.of(
                new Category(1L, "Món nướng"),
                new Category(2L, "Món luộc"),
                new Category(3L, "Món chay"),
                new Category(4L, "Hải sản"),
                new Category(5L, "Đồ uống")
        );
        categoryRepository.saveAll(categories);
        System.out.println("✅ Seeded 5 categories!");

        // ====== 2️⃣ Lấy lại danh mục ======
        Category nuong = categoryRepository.findById(1L).orElseThrow();
        Category luoc = categoryRepository.findById(2L).orElseThrow();
        Category chay = categoryRepository.findById(3L).orElseThrow();
        Category haisan = categoryRepository.findById(4L).orElseThrow();
        Category drink = categoryRepository.findById(5L).orElseThrow();

        // ====== 3️⃣ Thêm món ăn ======
        List<Dish> dishes = List.of(
                // MÓN NƯỚNG
                Dish.builder().id("MN001").name("Sườn nướng BBQ")
                        .description("Sườn heo ướp gia vị BBQ nướng than hồng thơm lừng.")
                        .imageUrl("https://images.unsplash.com/photo-1606755962773-0b3eb4a7e70d")
                        .price(150000.0).status(DishStatus.ON_SALE).category(nuong).startDate(now).build(),

                Dish.builder().id("MN002").name("Ba chỉ nướng Hàn Quốc")
                        .description("Ba chỉ heo nướng kiểu Hàn ăn kèm kim chi và rau cuốn.")
                        .imageUrl("https://images.unsplash.com/photo-1598136490941-431d6a5c1bb1")
                        .price(180000.0).status(DishStatus.ON_SALE).category(nuong).startDate(now).build(),

                Dish.builder().id("MN003").name("Gà nướng mật ong")
                        .description("Gà ta tẩm mật ong nướng lửa than vàng ươm, thơm ngọt.")
                        .imageUrl("https://images.unsplash.com/photo-1637041736872-c0b86eb3b8b3")
                        .price(160000.0).status(DishStatus.ON_SALE).category(nuong).startDate(now).build(),

                Dish.builder().id("MN004").name("Bò nướng lá lốt")
                        .description("Thịt bò cuộn lá lốt nướng thơm lừng, ăn kèm bún và rau sống.")
                        .imageUrl("https://images.unsplash.com/photo-1629381492672-3a2f81a41f75")
                        .price(140000.0).status(DishStatus.STOPPED).category(nuong).startDate(now).build(),

                Dish.builder().id("MN005").name("Tôm nướng muối ớt")
                        .description("Tôm nướng muối ớt cay nồng, đậm vị, hấp dẫn.")
                        .imageUrl("https://images.unsplash.com/photo-1613145993488-64b3d2039cc1")
                        .price(190000.0).status(DishStatus.DELETED).category(nuong).startDate(now).build(),

                // MÓN LUỘC
                Dish.builder().id("ML001").name("Gà luộc lá chanh")
                        .description("Gà ta luộc lá chanh vàng ươm, thịt mềm ngọt tự nhiên.")
                        .imageUrl("https://images.unsplash.com/photo-1598514982886-1eea3a4b7f7c")
                        .price(120000.0).status(DishStatus.ON_SALE).category(luoc).startDate(now).build(),

                Dish.builder().id("ML002").name("Thịt ba chỉ luộc")
                        .description("Thịt ba chỉ luộc mềm, chấm mắm tôm pha ớt chanh.")
                        .imageUrl("https://images.unsplash.com/photo-1627308595187-4af7fd51d1b5")
                        .price(110000.0).status(DishStatus.ON_SALE).category(luoc).startDate(now).build(),

                Dish.builder().id("ML003").name("Tôm luộc sả gừng")
                        .description("Tôm tươi luộc cùng sả và gừng, giữ trọn vị ngọt.")
                        .imageUrl("https://images.unsplash.com/photo-1576402187870-50a42c0ac84f")
                        .price(150000.0).status(DishStatus.ON_SALE).category(luoc).startDate(now).build(),

                Dish.builder().id("ML004").name("Bò luộc chấm gừng")
                        .description("Bò luộc thái mỏng chấm nước mắm gừng cay nồng.")
                        .imageUrl("https://images.unsplash.com/photo-1607330283240-79589b53be3d")
                        .price(180000.0).status(DishStatus.STOPPED).category(luoc).startDate(now).build(),

                Dish.builder().id("ML005").name("Mực luộc ớt tỏi")
                        .description("Mực luộc giữ vị ngọt tự nhiên, ăn kèm nước chấm gừng.")
                        .imageUrl("https://images.unsplash.com/photo-1625948515741-d5ce88c7b13a")
                        .price(170000.0).status(DishStatus.DELETED).category(luoc).startDate(now).build(),

                // MÓN CHAY
                Dish.builder().id("MC001").name("Đậu hũ sốt nấm đông cô")
                        .description("Đậu hũ mềm sốt nấm đông cô đậm đà, bổ dưỡng.")
                        .imageUrl("https://images.unsplash.com/photo-1638191872054-97b706b7aef1")
                        .price(90000.0).status(DishStatus.ON_SALE).category(chay).startDate(now).build(),

                Dish.builder().id("MC002").name("Rau củ xào thập cẩm")
                        .description("Bông cải, cà rốt, nấm, đậu Hà Lan xào chay thơm ngon.")
                        .imageUrl("https://images.unsplash.com/photo-1627308595190-07a3b3b20e9a")
                        .price(85000.0).status(DishStatus.ON_SALE).category(chay).startDate(now).build(),

                Dish.builder().id("MC003").name("Cà ri chay kiểu Ấn")
                        .description("Cà ri chay thơm béo với khoai, đậu và nước cốt dừa.")
                        .imageUrl("https://images.unsplash.com/photo-1625944230949-2a2a3cbfce8d")
                        .price(95000.0).status(DishStatus.ON_SALE).category(chay).startDate(now).build(),

                Dish.builder().id("MC004").name("Cơm chiên chay Dương Châu")
                        .description("Cơm chiên hạt tơi vàng ươm, đậm đà vị rau củ.")
                        .imageUrl("https://images.unsplash.com/photo-1612874742218-68d8b38f4b0f")
                        .price(80000.0).status(DishStatus.STOPPED).category(chay).startDate(now).build(),

                Dish.builder().id("MC005").name("Bún riêu chay")
                        .description("Nước dùng thanh mát, đậu hũ và chả chay đậm đà.")
                        .imageUrl("https://images.unsplash.com/photo-1641221218824-7e2ab1dcfd2a")
                        .price(90000.0).status(DishStatus.DELETED).category(chay).startDate(now).build(),

                // HẢI SẢN
                Dish.builder().id("HS001").name("Tôm hấp bia")
                        .description("Tôm sú hấp bia giữ vị ngọt tự nhiên, thơm mùi lúa mạch.")
                        .imageUrl("https://images.unsplash.com/photo-1617196039712-163e9cdbcf9f")
                        .price(180000.0).status(DishStatus.ON_SALE).category(haisan).startDate(now).build(),

                Dish.builder().id("HS002").name("Cá hồi nướng bơ tỏi")
                        .description("Cá hồi nướng bơ tỏi thơm béo, hấp dẫn.")
                        .imageUrl("https://images.unsplash.com/photo-1603133872878-684f36ec0a10")
                        .price(200000.0).status(DishStatus.ON_SALE).category(haisan).startDate(now).build(),

                Dish.builder().id("HS003").name("Mực xào sa tế")
                        .description("Mực tươi xào sa tế cay nồng, đậm đà hương vị biển.")
                        .imageUrl("https://images.unsplash.com/photo-1607434472258-3e93e6c1a90e")
                        .price(160000.0).status(DishStatus.ON_SALE).category(haisan).startDate(now).build(),

                Dish.builder().id("HS004").name("Cua rang me")
                        .description("Cua rang me chua ngọt, đậm đà, hấp dẫn.")
                        .imageUrl("https://images.unsplash.com/photo-1607434472258-3e93e6c1a90e")
                        .price(220000.0).status(DishStatus.STOPPED).category(haisan).startDate(now).build(),

                Dish.builder().id("HS005").name("Hàu nướng mỡ hành")
                        .description("Hàu tươi nướng cùng mỡ hành, hương vị tuyệt hảo.")
                        .imageUrl("https://images.unsplash.com/photo-1579584425555-c3ce17fd4351")
                        .price(130000.0).status(DishStatus.DELETED).category(haisan).startDate(now).build(),

                // ĐỒ UỐNG
                Dish.builder().id("DU001").name("Nước ép cam tươi")
                        .description("Nước ép cam nguyên chất, mát lành và bổ dưỡng.")
                        .imageUrl("https://images.unsplash.com/photo-1551024709-8f23befc6f87")
                        .price(45000.0).status(DishStatus.ON_SALE).category(drink).startDate(now).build(),

                Dish.builder().id("DU002").name("Sinh tố bơ sữa")
                        .description("Sinh tố bơ béo ngậy kết hợp sữa tươi thơm ngon.")
                        .imageUrl("https://images.unsplash.com/photo-1605478371345-4912d8b1c2c2")
                        .price(50000.0).status(DishStatus.ON_SALE).category(drink).startDate(now).build(),

                Dish.builder().id("DU003").name("Trà chanh mật ong")
                        .description("Trà chanh pha mật ong tự nhiên, giải khát hiệu quả.")
                        .imageUrl("https://images.unsplash.com/photo-1631815581457-68dffaeb7a89")
                        .price(40000.0).status(DishStatus.ON_SALE).category(drink).startDate(now).build(),

                Dish.builder().id("DU004").name("Cà phê sữa đá")
                        .description("Cà phê phin truyền thống pha sữa đặc đậm đà.")
                        .imageUrl("https://images.unsplash.com/photo-1523906834658-6e24ef2386f9")
                        .price(35000.0).status(DishStatus.STOPPED).category(drink).startDate(now).build(),

                Dish.builder().id("DU005").name("Nước dừa tươi")
                        .description("Dừa xiêm tươi mát lạnh, bổ sung năng lượng tức thì.")
                        .imageUrl("https://images.unsplash.com/photo-1600334129128-7b3a1a1edb37")
                        .price(30000.0).status(DishStatus.DELETED).category(drink).startDate(now).build()
        );

        dishRepository.saveAll(dishes);
        System.out.println("✅ Đã seed thành công 25 món ăn!");
    }
}
