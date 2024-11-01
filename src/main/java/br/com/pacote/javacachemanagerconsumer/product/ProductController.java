package br.com.pacote.javacachemanagerconsumer.product;

import br.com.pacote.javacachemanagerconsumer.dto.ProductDTO;
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

	@GetMapping("/category/{distributorKey}")
	public List<String> loadCategories(@PathVariable Long distributorKey) {
		return productService.loadCategories(distributorKey, BigDecimal.valueOf(0.25), new ProductDTO(1234L, "1248"));
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
