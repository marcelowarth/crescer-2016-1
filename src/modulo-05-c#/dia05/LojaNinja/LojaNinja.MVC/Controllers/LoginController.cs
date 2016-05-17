using LojaNinja.Dominio;
using LojaNinja.MVC.Models;
using LojaNinja.MVC.Services;
using LojaNinja.Repositorio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Security.Cryptography;
using System.Text;
using System.Web;
using System.Web.Mvc;

namespace LojaNinja.MVC.Controllers
{
    public class LoginController : Controller
    {
        private UsuarioServico _usuarioServico;
        private UsuarioRepositorio usuarioRepositorio = new UsuarioRepositorio();

        public LoginController()
        {
            _usuarioServico = new UsuarioServico(
                    new UsuarioRepositorio()
                );
        }

        public ActionResult Login()
        {
            return View();
        }

        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Entrar(LoginViewModel loginViewModel)
        {
            if (ModelState.IsValid)
            {
                Usuario usuarioEncontrado =
                    _usuarioServico.BuscarUsuarioPorAutenticacao(
                            loginViewModel.Email, loginViewModel.Senha
                        );

                if (usuarioEncontrado != null)
                {
                    var usuarioLogadoModel = new UsuarioLogadoModel(usuarioEncontrado);
                    Session["BemVindo"] = "Olá, " + usuarioLogadoModel.Nome;

                    ServicoDeSessao.CriarSessao(usuarioLogadoModel);
                    return RedirectToAction("Listagem", "Pedido");
                }
                else
                {
                    ModelState.AddModelError("INVALID_USER", "Usuário ou senha inválido.");
                    return View("Login", loginViewModel);
                }
            }

            return View("Login", loginViewModel);
        }

        public ActionResult CadastroUsuario()
        {
            return View();
        }

        public ActionResult Salvar(UsuarioCadastroModel model)
        {
            string senhaCriptografada = Criptografar(model.Senha);

            if (ModelState.IsValid)
                try
                {
                    var user = new Usuario();
                    user.Nome = model.Nome;
                    user.Email = model.Email;
                    user.Senha = senhaCriptografada;

                    usuarioRepositorio.IncluirUsuario(user);
                    ViewBag.MensagemSucesso = "Usuário salvo com sucesso!";
                    return View("Login");
                    //return View("Detalhes", user);
                }
                catch (ArgumentException ex)
                {
                    ModelState.AddModelError("", ex.Message);
                }

            return View("Manter", model);
        }

        [HttpGet]
        public ActionResult Sair()
        {
            ServicoDeSessao.Deslogar();
            return View("Login");
        }

        public ActionResult ListagemUsuarios()
        {
            var usuarios = usuarioRepositorio.ObterUsuarios();
            return View(usuarios);
        }

        private string Criptografar(string texto)
        {
            using (MD5 md5Hash = MD5.Create())
            {
                byte[] data = md5Hash.ComputeHash(Encoding.UTF8.GetBytes(texto));
                StringBuilder sBuilder = new StringBuilder();

                for (int i = 0; i < data.Length; i++)
                {
                    sBuilder.Append(data[i].ToString("x2"));
                }

                return sBuilder.ToString();
            }
        }
    }
}