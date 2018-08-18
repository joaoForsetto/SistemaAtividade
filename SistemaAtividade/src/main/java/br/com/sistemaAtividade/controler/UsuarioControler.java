package br.com.sistemaAtividade.controler;

import br.com.sistemaAtividade.domain.Usuario;
import br.com.sistemaAtividade.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/usuario")

public class UsuarioControler {

    @Autowired private UsuarioService usuarioService;

    @GetMapping ("/listarUsuario")
    public ModelAndView listar(ModelMap model){
        model.addAttribute("listarUsuario",usuarioService.findAll());
        return new ModelAndView("usuario/listUsuario");
    }
    @GetMapping ("/cadastro")
    public String preCadastro(@ModelAttribute("usuario") Usuario usuario){
        return "/usuario/cadastroUsuario";

    }
    @PostMapping ("/salvar")
    public String salvar(@ModelAttribute("usuario")Usuario usuario, BindingResult result, RedirectAttributes attr){
        if(result.hasErrors()){
            return "/usuario/cadastroUsuario";
        }
        usuarioService.salvar(usuario);
        attr.addFlashAttribute("mensagem","Usuário salvo com sucesso");
        return "redirect:/usuario/listarUsuario";
    }
    @GetMapping ("/{id}/atualizar")
    public ModelAndView preEditar (@PathVariable("id") Long id, ModelMap model) {

        Usuario usuario = usuarioService.findBy(id);
        model.addAttribute("usuario", usuario);
        return new ModelAndView("/usuario/cadastroUsuario", model);
    }

    @PutMapping("salvar")
    public String editar (@ModelAttribute ("usuario")Usuario usuario, BindingResult result, RedirectAttributes attr) {
        if(result.hasErrors()){
            return "/usuario/cadastroUsuario";
        }
        usuarioService.atualizar(usuario);
        attr.addFlashAttribute("mensagem","Usuário editado com sucesso");
        return "redirect:/usuario/listarUsuario";
    }
    @GetMapping ("{id}/remover")
    public String remover (@PathVariable("id") Long id, RedirectAttributes attr){

        usuarioService.deletar(id);
        attr.addFlashAttribute("mensagem","Usuário removido com sucesso");
        return "redirect:/usuario/listarUsuario";
    }

}
