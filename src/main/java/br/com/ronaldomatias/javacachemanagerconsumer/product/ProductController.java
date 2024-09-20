package br.com.ronaldomatias.javacachemanagerconsumer.product;

import br.com.ronaldomatias.cachemanager.annotation.AnnotationDTO;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
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
		return productService.loadCategories(99254L, BigDecimal.valueOf(0.25), new AnnotationDTO("1", 25L, false));
	}

	@PostMapping("/category")
	public String saveCategory(@RequestBody CategoryDTO dto) {
		return productService.saveCategory(dto);
	}

	@DeleteMapping("/category/{category}")
	public ResponseEntity<?> deleteCategory(@RequestBody String category) {
		productService.deleteCategory(category);
		return ResponseEntity.ok().build();
	}

	@Data
	public static class CategoryDTO {
		private String category;
	}

}
