package com.example.mysecondwebapp.material;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MaterialController {
	
	private MaterialRepository materialRepository;
	private RelMaterialCatRepository relMaterialCatRepository;
	private MaterialCategoryRepository materialCategoryRepository;
	
	public MaterialController(MaterialRepository materialRepository, RelMaterialCatRepository relMaterialCatRepository, MaterialCategoryRepository materialCategoryRepository) {
		super();
		this.materialRepository = materialRepository;
		this.relMaterialCatRepository = relMaterialCatRepository;
		this.materialCategoryRepository = materialCategoryRepository;
	}
	
	@RequestMapping("/material")
	public String listAllMaterial(ModelMap model) {
		
		List<Object[]> materials = materialRepository.findMaterialDetails();
        model.addAttribute("materials", materials);
 
		return "material";
	}
	
	@RequestMapping("/material/detail")
	public String detailsMaterial(@RequestParam int id, ModelMap model) {
		Material material = materialRepository.findById(id).get();
		model.addAttribute("material",material);
		return "materialDetails";
	}
	
	@GetMapping("/add-material")
	public String  showAddMaterialPage(ModelMap model) {
		model.addAttribute("formWrapper",new FormWrapper());
		return "addMaterial";
	}
	
	// Annotation 
    @ModelAttribute("category") 
  
    // Method 
    public List<String> category() 
    { 
        List<String> category = Arrays.asList( 
            "Category1", "Category2", "Category3", 
            "Category4", "Category5"); 
  
        return category; 
    } 
	
	@PostMapping("/add-material")
	public String  addNewMaterialPage(ModelMap model, FormWrapper formWrapper) {
		Material material = formWrapper.getMaterial();
		material.setCreatedDate(LocalDate.now());
		material.setDeleteFlag(true);
		materialRepository.save(material);
		
		
		List<String> selectedCategory = formWrapper.getSelectedCategory();

	    // Lưu các materialCatId đã chọn vào cơ sở dữ liệu
	    for (String category : selectedCategory) {
	        RelMaterialCat relMaterialCat = new RelMaterialCat();
	        relMaterialCat.setMaterialId(material.getMaterialId());
	        MaterialCategory materialCategory = new MaterialCategory();
	        materialCategory = materialCategoryRepository.findByCategory(category);
	        relMaterialCat.setMaterialCatId(materialCategory.getMaterialCatId()); // Chuyển đổi thành kiểu phù hợp
	        relMaterialCatRepository.save(relMaterialCat);
	    }
	
		return "redirect:material";
	}

}
