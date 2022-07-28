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

@WebServlet(value = "/livro-servlet/*")
public class LivroServlet extends HttpServlet {

    private LivroBusinessObjectI livroBusinessObject;

    @Inject
    public LivroServlet(LivroBusinessObjectI livroBusinessObject) {
        this.livroBusinessObject = livroBusinessObject;
    }

    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String opcao = req.getPathInfo();

        switch (opcao) {
            case "/cadastrar-livro":
                doPost(req, resp);
                break;
            case "/edicao":
                updateLivro(req, resp);
                break;
            case "/editar-livro":
                doPut(req, resp);
                break;
            case "/deletar":
                doDelete(req, resp);
                break;
            default:
                super.service(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Livro> livros = livroBusinessObject.findAll();

        req.setAttribute("livros", livros);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/lista-livros.jsp");
        dispatcher.forward(req,resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String nome = req.getParameter("nome");
        String autor = req.getParameter("autor");

        Livro livro = new Livro(nome,autor);
        livroBusinessObject.save(livro);

        List<Livro> livros = livroBusinessObject.findAll();

        req.setAttribute("livros",livros);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/lista-livros.jsp");
        dispatcher.forward(req,resp);
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idLivro = request.getParameter("id");
        livroBusinessObject.delete(idLivro.trim());

        List<Livro> livros = livroBusinessObject.findAll();
        request.setAttribute("livros", livros);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/lista-livros.jsp");
        dispatcher.forward(request,response);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");

        Livro livro = criaLivro(req);

        livro.setId(Long.valueOf(id.trim()));

        livroBusinessObject.update(livro);

        List<Livro> livros = livroBusinessObject.findAll();

        req.setAttribute("livros", livros);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/lista-livros.jsp");
        dispatcher.forward(req,resp);
    }
    private void updateLivro(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String idLivro = req.getParameter("id");
        Livro livro = livroBusinessObject.getById(idLivro.trim());

        req.setAttribute("livro", livro);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/edicao-livro.jsp");
        dispatcher.forward(req,resp);
    }
    private Livro criaLivro(HttpServletRequest req) {
        String nome = req.getParameter("nome");
        String autor = req.getParameter("autor");
        Livro livro = new Livro(nome, autor);
        return livro;
    }
}
