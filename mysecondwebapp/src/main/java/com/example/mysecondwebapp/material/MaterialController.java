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
	
	public MaterialController(MaterialRepository materialRepository, RelMaterialCatRepository relMaterialCatRepository) {
		super();
		this.materialRepository = materialRepository;
		this.relMaterialCatRepository = relMaterialCatRepository;
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
    @ModelAttribute("materialCatId") 
  
    // Method 
    public List<String> materialCatIdList() 
    { 
        List<String> materialCatId = Arrays.asList( 
            "1", "2", "3", 
            "4", "5"); 
  
        return materialCatId; 
    } 
	
	@PostMapping("/add-material")
	public String  addNewMaterialPage(ModelMap model, FormWrapper formWrapper) {
		Material material = formWrapper.getMaterial();
		material.setCreatedDate(LocalDate.now());
		material.setDeleteFlag(true);
		materialRepository.save(material);
		
		
		List<String> selectedMaterialCatIds = formWrapper.getSelectedMaterialCatIds();

	    // Lưu các materialCatId đã chọn vào cơ sở dữ liệu
	    for (String materialCatId : selectedMaterialCatIds) {
	        RelMaterialCat relMaterialCat = new RelMaterialCat();
	        relMaterialCat.setMaterialId(material.getMaterialId());
	        relMaterialCat.setMaterialCatId(Integer.parseInt(materialCatId)); // Chuyển đổi thành kiểu phù hợp
	        relMaterialCatRepository.save(relMaterialCat);
	    }
	
		return "redirect:material";
	}

}
