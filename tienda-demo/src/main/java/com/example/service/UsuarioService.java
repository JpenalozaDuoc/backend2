package com.example.service;

import java.util.List;
import java.util.Optional;

import com.example.model.Usuario;

public interface UsuarioService {

    //Listar Todos
    List<Usuario> getAllUsuarios();

    //Lstar 1 Usuario
    Optional<Usuario> getUsuarioById(Long id);

    //Crear Usuario
    Usuario createUsuario(Usuario usuario);
    
    //Actualizar Usuario
    Usuario updateUsuario(Long id, Usuario usuario);

    //Borrar Usuario
    void deleteUsuario(Long id);


}
