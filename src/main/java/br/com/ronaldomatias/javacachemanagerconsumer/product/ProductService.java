package br.com.ronaldomatias.javacachemanagerconsumer.product;

import br.com.ronaldomatias.cachemanager.annotation.Cacheable;
import br.com.ronaldomatias.cachemanager.annotation.InvalidateCache;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ProductService {

	@Cacheable(key = "category", ttl = 60)
	public List<String> loadCategories() {
		return Arrays.asList("Controlados", "Alimentos", "Genericos");
	}

	@InvalidateCache(key = "category", invalidateOnError = true)
	public void saveCategory(ProductController.SaveCategoryDTO dto) {
	}

}
