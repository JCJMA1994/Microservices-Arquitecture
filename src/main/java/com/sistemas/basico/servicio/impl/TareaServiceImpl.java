package com.sistemas.basico.servicio.impl;

import com.sistemas.basico.dominio.Tarea;
import com.sistemas.basico.repositorio.TareaRepository;
import com.sistemas.basico.servicio.TareaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TareaServiceImpl implements TareaService {
    @Autowired
    private TareaRepository tareaRepository;

    @Override
    public Tarea agregar(Tarea entidad) {
        Tarea result;

        result = tareaRepository.saveAndFlush(entidad);
        return result;
    }

    @Override
    public List<Tarea> listarTodos() {
        return tareaRepository.findAll();
    }

    @Override
    public Tarea buscar(Long id) {
        Optional<Tarea> buscado = tareaRepository.findById(id);
        Tarea result = null;

        if (buscado.isPresent()) {
            result = buscado.get();
        }
        return result;

    }

    @Override
    public Tarea actualizar(Tarea entidad) {
        Tarea result;

        result = tareaRepository.saveAndFlush(entidad);
        return result;
    }

    @Override
    public void eliminar(Long id) {
        tareaRepository.deleteById(id);
    }

}
