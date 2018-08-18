package br.com.sistemaAtividade.conversor;
import br.com.sistemaAtividade.domain.Usuario;
import br.com.sistemaAtividade.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component

public class ConversorToUsuario implements Converter<String, Usuario> {

    @Autowired
    private UsuarioService usuarioService;


    @Override
    public Usuario convert(String text) {
        if(text.isEmpty()){
            return null;
        }
        Long id = Long.valueOf(text);
        return usuarioService.findBy(id);
    }
}
