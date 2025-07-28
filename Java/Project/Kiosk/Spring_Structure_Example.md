# Directories

```
📁 Java_Kiosk_Spring
├── 📁 src
│   ├── 📁 main
│   │   ├── 📁 java
│   │   │   └── 📁 com.example.kiosk
│   │   │       ├── 📁 controller
│   │   │       │   ├── IntroController.java
│   │   │       │   ├── CategoryController.java
│   │   │       │   ├── MenuController.java
│   │   │       │   └── CartController.java
│   │   │       ├── 📁 service
│   │   │       │   ├── KioskService.java
│   │   │       │   └── CartService.java
│   │   │       ├── 📁 model
│   │   │       │   ├── Menu.java
│   │   │       │   ├── CartItem.java
│   │   │       │   └── Category.java (enum)
│   │   │       └── KioskApplication.java
│   │   └── 📁 resources
│   │       ├── 📁 templates
│   │       │   ├── intro.html
│   │       │   ├── categories.html
│   │       │   ├── menus.html
│   │       │   ├── add.html
│   │       │   ├── cart.html
│   │       │   └── checkout.html
│   │       └── application.yml
└── ...
```


# ✅ Controller 예시

```@RestController
@RequestMapping("/")
public class IntroController {
    @GetMapping
    public String introPage() {
        return "intro"; // templates/intro.html 렌더링
    }
}

@Controller
@RequestMapping("/categories")
public class CategoryController {
    @GetMapping
    public String showCategories(Model model) {
        model.addAttribute("categories", List.of("Coffees", "Non-Coffees", "Desserts"));
        return "categories";
    }
}

@Controller
@RequestMapping("/menus")
public class MenuController {
    @GetMapping
    public String showMenus(@RequestParam String category, Model model) {
        model.addAttribute("menus", kioskService.getMenusByCategory(category));
        return "menus";
    }
}

@Controller
@RequestMapping("/cart")
public class CartController {
    @GetMapping
    public String showCart(Model model) {
        model.addAttribute("cartItems", cartService.getCart());
        return "cart";
    }

    @PostMapping("/add")
    public String addToCart(@ModelAttribute CartItem item) {
        cartService.addItem(item);
        return "redirect:/cart";
    }

    @PostMapping("/checkout")
    public String checkout() {
        cartService.checkout();
        return "checkout";
    }
}
```
