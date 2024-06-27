package com.example.mysecondwebapp.material;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

public interface MaterialRepository extends JpaRepository<Material, Integer> {
	// Truy vấn để lấy thông tin từ nhiều bảng
	@Query(name = "Material.findMaterialDetails")
    List<Object[]> findMaterialDetails();
}
