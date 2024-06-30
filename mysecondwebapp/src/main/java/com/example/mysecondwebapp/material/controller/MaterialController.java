package com.example.mysecondwebapp.material.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.mysecondwebapp.material.FormWrapper;
import com.example.mysecondwebapp.material.FormWrapperUpdate;
import com.example.mysecondwebapp.material.entity.Material;
import com.example.mysecondwebapp.material.entity.MaterialCategory;
import com.example.mysecondwebapp.material.entity.MaterialType;
import com.example.mysecondwebapp.material.entity.RelMaterialCat;
import com.example.mysecondwebapp.material.repository.MaterialCategoryRepository;
import com.example.mysecondwebapp.material.repository.MaterialRepository;
import com.example.mysecondwebapp.material.repository.MaterialTypeRepository;
import com.example.mysecondwebapp.material.repository.RelMaterialCatRepository;

@Controller
public class MaterialController {
	
	private MaterialRepository materialRepository;
	private RelMaterialCatRepository relMaterialCatRepository;
	private MaterialCategoryRepository materialCategoryRepository;
	private MaterialTypeRepository materialTypeRepository;
	
	public MaterialController(MaterialRepository materialRepository, RelMaterialCatRepository relMaterialCatRepository
			, MaterialCategoryRepository materialCategoryRepository, MaterialTypeRepository materialTypeRepository) {
		super();
		this.materialRepository = materialRepository;
		this.relMaterialCatRepository = relMaterialCatRepository;
		this.materialCategoryRepository = materialCategoryRepository;
		this.materialTypeRepository = materialTypeRepository;
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
		List<MaterialType> materialTypes = materialTypeRepository.findAll();
		model.addAttribute("materialTypes",materialTypes);
		model.addAttribute("formWrapper",new FormWrapper());
		return "addMaterial";
	}
	
	// Annotation 
    @ModelAttribute("category") 
  
    // Method 
    public List<String> category() 
    { 
    	List<MaterialCategory> all = materialCategoryRepository.findAll();
        List<String> category = new ArrayList<>();
        for(MaterialCategory addCategory : all) {
        	category.add(addCategory.getCategory());
        	
        }
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
	
	@RequestMapping("/delete-material")
	public String deleteMaterial(@RequestParam("materialId") int id, @RequestParam("category") String category) {
		int materialCatId = materialCategoryRepository.findByCategory(category).getMaterialCatId();
		RelMaterialCat relMaterialCat = relMaterialCatRepository.findByMaterialIdAndMaterialCatId(id, materialCatId);
		relMaterialCatRepository.delete(relMaterialCat);
		return "redirect:material";
	}
	
	@GetMapping("/update-material")
	public String showUpdateMaterialPage(@RequestParam("materialId") int materialId, @RequestParam("category") String category, ModelMap model) {
		List<MaterialType> materialTypes = materialTypeRepository.findAll();
		model.addAttribute("materialTypes",materialTypes);
		
		FormWrapperUpdate formWrapperUpdate = new FormWrapperUpdate();
		Material material = materialRepository.findById(materialId).get();
		formWrapperUpdate.setMaterial(material);
		MaterialCategory materialCategory = materialCategoryRepository.findByCategory(category);
		formWrapperUpdate.setMaterialCategory(materialCategory);
		RelMaterialCat relMaterialCat = relMaterialCatRepository.findByMaterialIdAndMaterialCatId(materialId, materialCategory.getMaterialCatId());
		formWrapperUpdate.setRelMaterialCat(relMaterialCat);
		model.addAttribute(formWrapperUpdate);
		return "updateMaterial";
	}
	
	@PostMapping("/update-material")
	public String  updateMaterial(ModelMap model, FormWrapperUpdate formWrapperUpdate) {
		
		
//		Material material = formWrapper.getMaterial();
//		material.setCreatedDate(LocalDate.now());
//		material.setDeleteFlag(true);
		Material material = formWrapperUpdate.getMaterial();
		String category = formWrapperUpdate.getMaterialCategory().getCategory();
		int materialCatId = materialCategoryRepository.findByCategory(category).getMaterialCatId();
		RelMaterialCat relMaterialCat = relMaterialCatRepository.findByMaterialIdAndMaterialCatId(material.getMaterialId(), materialCatId);
//		if(relMaterialCat.getRelMaterialCatId() == formWrapperUpdate.getRelMaterialCat().getRelMaterialCatId()) {
//			return "addMaterial";
//		}
		
		if(relMaterialCat!=null && relMaterialCat.getRelMaterialCatId() != formWrapperUpdate.getRelMaterialCat().getRelMaterialCatId()) {
			model.addAttribute("errorMessage", "The material with the given category already exists.");
			
			List<MaterialType> materialTypes = materialTypeRepository.findAll();
			model.addAttribute("materialTypes",materialTypes);
			return "updateMaterial";
		}
		
		
		materialRepository.save(material);
					
	    // Lưu các materialCatId đã chọn vào cơ sở dữ liệu	   	        
	        formWrapperUpdate.getRelMaterialCat().setMaterialCatId(materialCatId);
	        relMaterialCatRepository.save(formWrapperUpdate.getRelMaterialCat());	   	
		return "redirect:material";
	}
}
