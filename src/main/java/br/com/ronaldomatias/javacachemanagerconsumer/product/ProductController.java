package br.com.ronaldomatias.javacachemanagerconsumer.product;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
	private final ProductService productService;

	public ProductController(ProductService anyService) {
		this.productService = anyService;
	}

	@GetMapping("/categories")
	public List<String> getCategories() {
		return productService.getCategories();
	}

}
