package br.com.ronaldomatias.javacachemanagerconsumer.product;

import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
	private final ProductService productService;

	public ProductController(ProductService anyService) {
		this.productService = anyService;
	}

	@GetMapping("/category")
	public List<String> loadCategories() {
		return productService.loadCategories();
	}

	@PostMapping("/category")
	public ResponseEntity<?> saveCategory(@RequestBody SaveCategoryDTO dto) {
		productService.saveCategory(dto);
		return ResponseEntity.ok().build();
	}

	@Data
	public static class SaveCategoryDTO {
		private String category;
	}

}
