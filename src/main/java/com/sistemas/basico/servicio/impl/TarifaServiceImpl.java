package com.sistemas.basico.servicio.impl;

import com.sistemas.basico.dominio.Tarifa;
import com.sistemas.basico.repositorio.TarifaRepository;
import com.sistemas.basico.servicio.TareaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TarifaServiceImpl implements TareaService {

    @Autowired
    private TarifaRepository tarifaRepository;

    @Override
    public Tarifa agregar(Tarifa entidad){
        Tarifa result;

        result = tarifaRepository.saveAndFlush(entidad);
        return result;
    }

    @Override
    public List<Tarifa> listarTodos(){
        return tarifaRepository.findAll();
    }

    @Override
    public Tarifa buscar(Long id){
        Optional<Tarifa> buscado=tarifaRepository.findById(id);
        Tarifa result=null;

        if (buscado.isPresent()){
            result = buscado.get();
        }
        return result;

    }

    @Override
    public Tarifa actualizar(Tarifa entidad){
        Tarifa result;

        result = tarifaRepository.saveAndFlush(entidad);
        return result;
    }

    @Override
    public void eliminar(Long id){
        tarifaRepository.deleteById(id);
    }
}
