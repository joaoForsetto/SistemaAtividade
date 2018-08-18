package br.com.sistemaAtividade.controler;

import br.com.sistemaAtividade.domain.Atividade;
import br.com.sistemaAtividade.domain.Usuario;
import br.com.sistemaAtividade.service.AtividadeService;
import br.com.sistemaAtividade.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/atividade")

public class AtividadeControler {

    @Autowired
    private AtividadeService atividadeService;
    @Autowired
    UsuarioService usuarioService;

    @GetMapping("/listarAtividade")
    public ModelAndView lista(ModelMap modelMap) {
        modelMap.addAttribute("listaAtividade", atividadeService.findAll());
        return new ModelAndView("/atividade/listaAtividade");
    }

    @ModelAttribute("listaUsuario")
    public List<Usuario> getUsuarios() {
        return usuarioService.findAll();
    }


    @PostMapping("/salvar")
    public String salvar(@ModelAttribute("atividade") Atividade atividade, BindingResult result, RedirectAttributes attr) {
        if (result.hasErrors()) {
            return "/atividade/listaAtividade";
        }
        atividadeService.salvar(atividade);
        attr.addFlashAttribute("mensagem", "Atividade salva com sucesso");
        return "redirect:/atividade/listarAtividade";
    }

    @GetMapping("/cadastro")
    public String preCadastro(@ModelAttribute("atividade") Atividade atividade) {
        return "atividade/cadastroAtividade";
    }

    @GetMapping("/{id}/atualizar")
    public ModelAndView atualizar(@PathVariable("id") Long id, ModelMap model) {
        model.addAttribute("atividade", atividadeService.findBy(id));
        return new ModelAndView("/atividade/cadastroAtividade", model);

    }

    @PutMapping("/salvar")
    public String editar(@ModelAttribute("atividade") Atividade atividade, BindingResult result, RedirectAttributes attr) {
        if (result.hasErrors()) {
            return "/atividade/listaAtividade";
        }
        atividadeService.atualizar(atividade);
        attr.addFlashAttribute("mensagem", "Atividade editada com sucesso");
        return "redirect:/atividade/listarAtividade";
    }
    @GetMapping ("{id}/remover")
    public String remover (@PathVariable ("id") Long id, RedirectAttributes attr){
        atividadeService.deletar(id);
        attr.addFlashAttribute("mensagem", "Atividade deletada com sucesso");
        return "redirect:/atividade/listarAtividade";


    }
}
