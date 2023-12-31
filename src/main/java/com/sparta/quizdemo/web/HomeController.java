package com.sparta.quizdemo.web;

import com.sparta.quizdemo.common.security.UserDetailsImpl;
import com.sparta.quizdemo.product.entity.Product;
import com.sparta.quizdemo.product.repository.ProductRepository;
import com.sparta.quizdemo.user.entity.User;
import com.sparta.quizdemo.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final UserRepository userRepository;
    private final ProductRepository productRepository;

    @GetMapping("/")
    public String mainPage(Model model, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        if (userDetails != null) {
            model.addAttribute("username", userDetails.getUsername());
            model.addAttribute("userRole", userDetails.getUser().getRole());
            if(userDetails.getUser().getAddress() != null ){
                model.addAttribute("userAddress", userDetails.getUser().getAddress().getAddress1());
            }else{
                model.addAttribute("userAddress", "주소없음");
            }
        }
        return "index";
    }

    @GetMapping("/product/{productId}")
    public String selectProduct(@PathVariable Long productId, Model model, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        Product product = productRepository.findById(productId).orElseThrow(() -> new NullPointerException("해당 번호의 상품이 존재하지 않습니다."));

        model.addAttribute("category", product.getCategory());
        model.addAttribute("productId", productId);
        if (userDetails != null) {
            model.addAttribute("username", userDetails.getUsername());
            model.addAttribute("userRole", userDetails.getUser().getRole());
        }
        return "productDetail";
    }

    @GetMapping("/cart")
    public String cartPage(Model model, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        model.addAttribute("username", userDetails.getUsername());

        return "cart";
    }

    @Secured("ROLE_ADMIN")
    @GetMapping("/new-product")
    public String newProduct(Model model, @AuthenticationPrincipal UserDetailsImpl userDetails) {

        model.addAttribute("username", userDetails.getUsername());
        model.addAttribute("userRole", userDetails.getUser().getRole());
        return "newProduct";
    }

    @Secured("ROLE_ADMIN")
    @GetMapping("/new-option")
    public String newOption(Model model, @AuthenticationPrincipal UserDetailsImpl userDetails) {

        model.addAttribute("username", userDetails.getUsername());
        model.addAttribute("userRole", userDetails.getUser().getRole());
        return "newOption";
    }

    @Secured("ROLE_ADMIN")
    @GetMapping("/optionList-page")
    public String optionListPage(Model model, @AuthenticationPrincipal UserDetailsImpl userDetails) {

        model.addAttribute("username", userDetails.getUsername());
        model.addAttribute("userRole", userDetails.getUser().getRole());
        return "optionList";
    }

    @Secured("ROLE_ADMIN")
    @GetMapping("/edit-product/{productId}")
    public String updateProduct(@PathVariable Long productId, Model model) {
        Product product = productRepository.findById(productId).orElseThrow(() -> new NullPointerException("해당 번호의 상품이 존재하지 않습니다."));

        model.addAttribute("productId", productId);
        model.addAttribute("productName", product.getProductName());
        model.addAttribute("productPrice", product.getProductPrice());
        model.addAttribute("productImage", product.getProductImage());
        model.addAttribute("productIntro", product.getProductIntro());
        model.addAttribute("cookingTime", product.getCookingTime());
        model.addAttribute("category", product.getCategory());
        return "editProduct";
    }

    @GetMapping("/order/{orderId}")
    public String orderDetail(Model model, @PathVariable Long orderId, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        model.addAttribute("orderId", orderId);
        model.addAttribute("username", userDetails.getUsername());
        model.addAttribute("userRole", userDetails.getUser().getRole());
        return "orderDetail";
    }

    @GetMapping("/user/orders/{orderId}")
    public String ordersDetail(Model model, @PathVariable Long orderId, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        model.addAttribute("orderId", orderId);
        model.addAttribute("username", userDetails.getUsername());
        model.addAttribute("userRole", userDetails.getUser().getRole());
        return "ordersUserDetail";
    }

    @Secured("ROLE_ADMIN")
    @GetMapping("/admin")
    public String backOffice(Model model, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        if (userDetails != null) {
            model.addAttribute("username", userDetails.getUsername());
            model.addAttribute("userRole", userDetails.getUser().getRole());
        }
        return "backOffice";
    }

    @Secured("ROLE_ADMIN")
    @GetMapping("/user-page/{userName}")
    public String getUserInfoPage(Model model, @PathVariable String userName) {
        User user = userRepository.findByUsername(userName).orElseThrow(() -> new NullPointerException("해당 아이디의 유저가 존재하지 않습니다."));

        model.addAttribute("userNo", user.getId());
        model.addAttribute("username", user.getUsername());
        model.addAttribute("nickname", user.getNickname());
        model.addAttribute("role", user.getRole());
        model.addAttribute("zipCode", user.getAddress().getZip_code());
        model.addAttribute("address1", user.getAddress().getAddress1());
        model.addAttribute("address2", user.getAddress().getAddress2());

        return "user-page";
    }

    @Secured("ROLE_ADMIN")
    @GetMapping("/user-info-update-page/{userName}")
    public String updateOneUserInfoPage(Model model, @PathVariable String userName) {
        User user = userRepository.findByUsername(userName).orElseThrow(() -> new NullPointerException("해당 아이디의 유저가 존재하지 않습니다."));

        model.addAttribute("role", user.getRole());
        model.addAttribute("username", user.getUsername());
        model.addAttribute("nickname", user.getNickname());
        model.addAttribute("zipCode", user.getAddress().getZip_code());
        model.addAttribute("address1", user.getAddress().getAddress1());
        model.addAttribute("address2", user.getAddress().getAddress2());

        return "one-user-info-update";
    }

    @GetMapping("/signup")
    public String signup() {

        return "signup";
    }

    @GetMapping("/login")
    String login() {
        return "login";
    }

    @GetMapping("/mypage")
    String mypage(Model model, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        if (userDetails != null) {
            model.addAttribute("username", userDetails.getUsername());
            model.addAttribute("userRole", userDetails.getUser().getRole());
        }
        return "mypage";
    }

    @GetMapping("/user/orders")
    String orders(Model model, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        if (userDetails != null) {
            model.addAttribute("username", userDetails.getUsername());
            model.addAttribute("userRole", userDetails.getUser().getRole());
        }
        return "myOrders";
    }

    @GetMapping("/user/update")
    String update(Model model, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        if (userDetails != null) {
            model.addAttribute("username", userDetails.getUsername());
            model.addAttribute("userRole", userDetails.getUser().getRole());
        }
        return "myUpdate";
    }

    @GetMapping("/user/reviews")
    String reviews(Model model, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        if (userDetails != null) {
            model.addAttribute("username", userDetails.getUsername());
            model.addAttribute("userRole", userDetails.getUser().getRole());
        }
        return "myReviews";
    }

    @GetMapping("/user/delete")
    String delete(Model model, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        if (userDetails != null) {
            model.addAttribute("username", userDetails.getUsername());
            model.addAttribute("userRole", userDetails.getUser().getRole());
        }
        return "myDelete";
    }

    @GetMapping("/user/address")
    String address(Model model,  @AuthenticationPrincipal UserDetailsImpl userDetails){

        return "myAddress";
    }
    @GetMapping("/user/info/username")
    String findUsername(){

        return "findUsername";
    }
    @GetMapping("/comment")
    String comment(Model model, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        if (userDetails != null) {
            model.addAttribute("username", userDetails.getUsername());
            model.addAttribute("userRole", userDetails.getUser().getRole());
        }
        return "comment";
    }
    @GetMapping("/user/info/password")
    String password(){

        return "findPassword";
    }
}
