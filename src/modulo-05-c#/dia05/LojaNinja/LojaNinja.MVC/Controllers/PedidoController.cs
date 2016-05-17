using LojaNinja.Dominio;
using LojaNinja.MVC.Filters;
using LojaNinja.MVC.Models;
using LojaNinja.Repositorio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace LojaNinja.MVC.Controllers
{
    public class PedidoController : Controller
    {
        private RepositorioVendasADO repositorio = new RepositorioVendasADO();
        
        [CWIToken]
        public ActionResult Manter(int? id)
        {
            if (id.HasValue)
            {
                var pedido = repositorio.ObterPedidoPorId(id.Value);

                var model = new PedidoModel()
                //{
                //    Id = pedido.Id,
                //    DataEntrega = pedido.DataEntregaDesejada,
                //    NomeCliente = pedido.NomeCliente,
                //    //...
                //}
                ;

                return View("Manter", model);
            }
            else
            {
                return View("Manter");
            }
        }
        
        [CWIToken]
        public ActionResult Salvar(PedidoModel model)
        {
            if (ModelState.IsValid)
                try
                {
                    var pedido = new Pedido(
                    model.DataEntrega,
                    model.NomeProduto,
                    model.Valor,
                    model.TipoPagamento,
                    model.NomeCliente,
                    model.Cidade,
                    model.Estado
                    );
                    repositorio.IncluirPedido(pedido);
                    ViewBag.MensagemSucesso = "Pedido salvo com sucesso!";
                    return View("Detalhes", pedido);
                }
                catch (ArgumentException ex)
                {
                    ModelState.AddModelError("", ex.Message);
                }

            return View("Manter", model);
        }
        
        [CWIToken]
        public ActionResult Detalhes(int id)
        {
            var pedido = repositorio.ObterPedidoPorId(id);

            return View(pedido);
        }
        
        [CWIToken]
        public ActionResult Listagem(string cliente, string produto)
        {
            if(String.IsNullOrWhiteSpace(cliente) && String.IsNullOrWhiteSpace(produto))
            {
                var pedidos = repositorio.ObterPedidos();
                return View(pedidos);
            }
            else if (String.IsNullOrWhiteSpace(cliente))
            {
                var pedidos = repositorio.ObterPedidoFiltradoProduto(produto);
                return View(pedidos);
            }
            else if(String.IsNullOrWhiteSpace(produto))
            {
                var pedidos = repositorio.ObterPedidoFiltradoCliente(cliente);
                return View(pedidos);
            }
            else
            {
                var pedidos = repositorio.ObterPedidoFiltradoClienteProduto(cliente, produto);
                return View(pedidos);
            }

        }
        
        [CWIToken]
        public ActionResult Excluir(int id)
        {
            repositorio.ExcluirPedido(id);
            var pedidos = repositorio.ObterPedidos();

            return View("Listagem", pedidos);
        }
    }
}