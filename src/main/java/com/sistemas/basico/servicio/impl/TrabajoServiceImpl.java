package com.sistemas.basico.servicio.impl;

import com.sistemas.basico.dominio.Trabajo;
import com.sistemas.basico.repositorio.TrabajoRepository;
import com.sistemas.basico.servicio.TrabajoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrabajoServiceImpl implements TrabajoService {

    @Autowired
    private TrabajoRepository trabajoRepository;

    @Override
    public Trabajo agregar(Trabajo entidad){
        Trabajo result;

        result = trabajoRepository.saveAndFlush(entidad);
        return result;
    }

    @Override
    public List<Trabajo> listarTodos(){
        return trabajoRepository.findAll();
    }

    @Override
    public Trabajo buscar(Long id){
        Optional<Trabajo> buscado=trabajoRepository.findById(id);
        Trabajo result=null;

        if (buscado.isPresent()){
            result = buscado.get();
        }
        return result;

    }

    @Override
    public Trabajo actualizar(Trabajo entidad){
        Trabajo result;

        result = trabajoRepository.saveAndFlush(entidad);
        return result;
    }

    @Override
    public void eliminar(Long id){
        trabajoRepository.deleteById(id);
    }
}
