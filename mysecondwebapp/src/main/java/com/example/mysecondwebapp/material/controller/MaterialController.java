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
		List<MaterialCategory> materialCategory = materialCategoryRepository.findAll();
		model.addAttribute("materialCategory",materialCategory);
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
		List<MaterialType> materialType = materialTypeRepository.findAll();
		List<MaterialCategory> materialCategory = materialCategoryRepository.findAll();
		model.addAttribute("materialType",materialType);
		model.addAttribute("materialCategory",materialCategory);
		model.addAttribute("formWrapper",new FormWrapper());
		return "addMaterial";
	}
	

	
	@PostMapping("/add-material")
	public String  addNewMaterialPage(ModelMap model, FormWrapper formWrapper) {
		
		
		Material material = formWrapper.getMaterial();
		materialRepository.save(material);
		
		
		List<Integer> selectedCategory = formWrapper.getSelectedCategory();

	    // Lưu các materialCatId đã chọn vào cơ sở dữ liệu
	    for (Integer materialCatId : selectedCategory) {
	        RelMaterialCat relMaterialCat = new RelMaterialCat();
	        relMaterialCat.setMaterialId(material.getMaterialId());
	        relMaterialCat.setMaterialCatId(materialCatId); // Chuyển đổi thành kiểu phù hợp
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
		List<MaterialCategory> materialCategory = materialCategoryRepository.findAll();
		model.addAttribute("materialCategory",materialCategory);
		
		FormWrapperUpdate formWrapperUpdate = new FormWrapperUpdate();
		Material material = materialRepository.findById(materialId).get();
		formWrapperUpdate.setMaterial(material);
		MaterialCategory materialCategoryUpdate = materialCategoryRepository.findByCategory(category);
		formWrapperUpdate.setMaterialCatIdOfSelectedCategory(materialCategoryUpdate.getMaterialCatId());
		RelMaterialCat relMaterialCat = relMaterialCatRepository.findByMaterialIdAndMaterialCatId(materialId, materialCategoryUpdate.getMaterialCatId());
		formWrapperUpdate.setRelMaterialCat(relMaterialCat);
		model.addAttribute(formWrapperUpdate);
		return "updateMaterial";
	}
	
	@PostMapping("/update-material")
	public String  updateMaterial(ModelMap model, FormWrapperUpdate formWrapperUpdate) {
		
		

		Material material = formWrapperUpdate.getMaterial();
		int materialCatId = formWrapperUpdate.getMaterialCatIdOfSelectedCategory();
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
