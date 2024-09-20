package br.com.ronaldomatias.javacachemanagerconsumer.product;

import br.com.ronaldomatias.cachemanager.annotation.AnnotationDTO;
import br.com.ronaldomatias.cachemanager.annotation.Cacheable;
import br.com.ronaldomatias.cachemanager.annotation.InvalidateCache;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@Service
public class ProductService {

	@Cacheable(key = "categories_by_distributor; ", ttl = 60)
	public List<String> loadCategories(Long distributorId, BigDecimal value, AnnotationDTO annotationDTO) {
		return Arrays.asList("Controlados", "Alimentos", "Genericos");
	}

	@InvalidateCache(key = "category")
	public String saveCategory(ProductController.CategoryDTO dto) {
		return dto.getCategory();
	}

	@InvalidateCache(key = "category")
	public void deleteCategory(String category) {
	}

}
