using LojaNinja.Dominio;
using System;
using System.Collections.Generic;
using System.Configuration;
using System.Data.SqlClient;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Transactions;

namespace LojaNinja.Repositorio
{
    public class RepositorioVendasADO : RepositorioConnection
    {
        public List<Pedido> ObterPedidos()
        {
            List<Pedido> lista = new List<Pedido>();

            using (TransactionScope scope = new TransactionScope())
            {
                using (var conexao = new SqlConnection(ConnectionString))
                {
                    try
                    {
                        string sql = "Select * from Pedidos";

                        var comando = new SqlCommand(sql, conexao);

                        conexao.Open();

                        SqlDataReader leitor = comando.ExecuteReader();

                        while (leitor.Read())
                        {
                            int tipoPag = Convert.ToInt32(leitor["tipoPagamento"]);

                            lista.Add(new Pedido(
                                leitor.ReadInt("id_pedido"),
                                leitor.ReadDateTime("dataEntrega"),
                                leitor.ReadDateTime("dataPedido"),
                                leitor["nomeProduto"].ToString(),
                                leitor.ReadDecimal("valor"),
                                (TipoPagamento)leitor.ReadInt("tipoPagamento"),
                                leitor["cliente"].ToString(),
                                leitor["cidade"].ToString(),
                                leitor["estado"].ToString(),
                                leitor.ReadBoolean("urgente")
                                ));
                        }

                        scope.Complete();
                    }
                    catch (Exception)
                    {
                        throw;
                    }
                }
            }

            return lista;
        }

        public Pedido ObterPedidoPorId(int id)
        {
            return this.ObterPedidos().FirstOrDefault(x => x.Id == id);
        }

        public void IncluirPedido(Pedido pedido)
        {
            using (TransactionScope scope = new TransactionScope())
            {
                using (var conexao = new SqlConnection(ConnectionString))
                {
                    try
                    {
                        string sql = "Insert into Pedidos (nomeProduto, dataPedido, dataEntrega, valor, tipoPagamento, cliente, cidade, estado, urgente) values (@p_nomeProd, @p_dataPedido, @p_dataEntrega, @p_valor, @p_tipoPagamento, @p_cliente, @p_cidade, @p_estado, @p_urgente)";

                        var comando = new SqlCommand(sql, conexao);
                        comando.Parameters.Add(new SqlParameter("p_nomeProd", pedido.NomeProduto));
                        comando.Parameters.Add(new SqlParameter("p_dataPedido", pedido.DataPedido));
                        comando.Parameters.Add(new SqlParameter("p_dataEntrega", pedido.DataEntregaDesejada));
                        comando.Parameters.Add(new SqlParameter("p_valor", pedido.Valor));
                        comando.Parameters.Add(new SqlParameter("p_tipoPagamento", pedido.TipoPagamento));
                        comando.Parameters.Add(new SqlParameter("p_cliente", pedido.NomeCliente));
                        comando.Parameters.Add(new SqlParameter("p_cidade", pedido.Cidade));
                        comando.Parameters.Add(new SqlParameter("p_estado", pedido.Estado));
                        comando.Parameters.Add(new SqlParameter("p_urgente", pedido.PedidoUrgente));
                        
                        conexao.Open();

                        comando.ExecuteNonQuery();

                        scope.Complete();
                    }
                    catch (Exception)
                    {
                        throw;
                    }
                }
            }
        }

        public void AtualizarPedido(Pedido pedido)
        {
            //TODO: Implementar
        }

        public void ExcluirPedido(int id)
        {
            using (TransactionScope scope = new TransactionScope())
            {
                using (var conexao = new SqlConnection(ConnectionString))
                {
                    try
                    {
                        string sql = "Delete from Pedidos where id_pedido = @p_id";

                        var comando = new SqlCommand(sql, conexao);
                        comando.Parameters.Add(new SqlParameter("p_id", id));

                        conexao.Open();

                        comando.ExecuteNonQuery();

                        scope.Complete();

                    }
                    catch (Exception)
                    {
                        throw;
                    }
                }
            }
        }

        public List<Pedido> ObterPedidoFiltradoCliente(string cliente)
        {
            var pedidosCli = ObterPedidos().Where(x => x.NomeCliente.ToLower() == cliente.ToLower()).ToList();

            return pedidosCli;
        }

        public List<Pedido> ObterPedidoFiltradoProduto(string produto)
        {
            var pedidosProd = ObterPedidos().Where(x => x.NomeProduto.ToLower() == produto.ToLower()).ToList();

            return pedidosProd;
        }


        public List<Pedido> ObterPedidoFiltradoClienteProduto(string cliente, string produto)
        {
            var pedidos = ObterPedidoFiltradoProduto(produto).Where(x => x.NomeCliente == cliente).ToList();

            return pedidos;
        }
    }
}
