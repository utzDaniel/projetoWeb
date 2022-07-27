package br.com.sinqia.projetoweb;

import br.com.sinqia.projetoweb.bo.LivroBusinessObjectI;
import br.com.sinqia.projetoweb.model.Livro;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(value = "/livro-servlet")
public class LivroServlet extends HttpServlet {

    private LivroBusinessObjectI livroBusinessObject;

    @Inject
    public LivroServlet(LivroBusinessObjectI livroBusinessObject) {
        this.livroBusinessObject = livroBusinessObject;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String nome = req.getParameter("nome");
        String autor = req.getParameter("autor");

        Livro livro = new Livro(nome,autor);
        livroBusinessObject.save(livro);

        List<Livro> livros = livroBusinessObject.listarAll();

        req.setAttribute("livros",livros);

        RequestDispatcher dispatcher = req.getRequestDispatcher("lista-livros.jsp");
        dispatcher.forward(req,resp);

    }
}
