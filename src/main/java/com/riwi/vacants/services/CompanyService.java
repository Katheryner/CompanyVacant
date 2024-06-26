package com.riwi.vacants.services;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.riwi.vacants.entities.Company;
import com.riwi.vacants.repositories.CompanyRespository;
import com.riwi.vacants.services.interfaces.ICompanyService;
import com.riwi.vacants.utils.dto.request.CompanyRequest;
import com.riwi.vacants.utils.dto.response.CompanyResponse;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CompanyService implements ICompanyService{

    @Autowired
    private final CompanyRespository companyRespository;

    @Override
    public Page<CompanyResponse> getAll(int page, int size) {
        //1.Configuramos la paginacion 
       if(page<0) page =0;
        
       PageRequest pagination = PageRequest.of(page,size);
        //2. Llamamos el repositorio
       return this.companyRespository.findAll(pagination).map(Company -> this.entityToResponse(Company)); //2da forma map(this::entityToResponse);
    }

    @Override
    public CompanyResponse create(CompanyRequest request) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public CompanyResponse update(CompanyRequest request, String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public CompanyResponse getById(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getById'");
    }
    
    //Metodo para convertir una entidad en el DTO de respuesta de la entidad
    private CompanyResponse entityToResponse(Company entity){
        CompanyResponse response = new CompanyResponse();
        
        //BeanUtils nos permite hacer una copia de una clase en otra, en este caso toda la entidad de tipo company será copiada con la informacion requerida por la variable tipo CompanyResponse
        BeanUtils.copyProperties(entity, response);
        return response;
    }
}
