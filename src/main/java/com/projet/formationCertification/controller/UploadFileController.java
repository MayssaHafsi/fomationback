package com.projet.formationCertification.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.projet.formationCertification.dao.FichierRepository;
import com.projet.formationCertification.dao.FormateurRepository;
import com.projet.formationCertification.entities.Fichier;
import com.projet.formationCertification.entities.Formateur;

@RestController
@CrossOrigin
public class UploadFileController {
	  @Autowired
	  FichierRepository fileRepository;
	 
	  @Autowired
	FormateurRepository ic ;
	    /*
	     * MultipartFile Upload
	     */
	    @PostMapping("/api1/file1/upload1/{email}")
	    public String uploadMultipartFile(@RequestParam("file") MultipartFile file,@PathVariable String email) {
	      try {
	 Fichier filemode=new Fichier(); 
	filemode.setFormateurfichier(ic.find1(email));
	 filemode.setMimetype(file.getContentType());
	 filemode.setName(file.getOriginalFilename());
	 filemode.setPic(file.getBytes());
	        // save file to PostgreSQL
	     //   Cours filemode = new Cours(file.getOriginalFilename(), file.getContentType(), file.getBytes());
	        fileRepository.save(filemode);
	        return "File uploaded successfully! -> filename = " + file.getOriginalFilename();
	    } catch (  Exception e) {
	      return "FAIL! Maybe You had uploaded the file before or the file's size > 500KB";
	    }    
	    }
	    
	    
}
