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
    public class UsuarioRepositorio : RepositorioConnection, IUsuarioRepositorio
    {
        public Usuario BuscarUsuarioPorAutenticacao(string email, string senha)
        {
            var user = new Usuario();

            using (TransactionScope scope = new TransactionScope())
            {
                using (var conexao = new SqlConnection(ConnectionString))
                {
                    try
                    {
                        string sql = "SELECT * FROM Usuarios WHERE email_usuario=@p_email and senha_usuario=@p_senha";

                        var comando = new SqlCommand(sql, conexao);
                        comando.Parameters.Add(new SqlParameter("p_email", email));
                        comando.Parameters.Add(new SqlParameter("p_senha", senha));

                        conexao.Open();

                        SqlDataReader leitor = comando.ExecuteReader();

                        if (leitor.Read())
                        {
                            user.Nome = leitor["nome_usuario"].ToString();
                            user.Senha = leitor["senha_usuario"].ToString();
                            user.Email = leitor["email_usuario"].ToString();
                        }

                        scope.Complete();
                    }
                    catch (Exception)
                    {
                        throw;
                    }
                }
            }

            return user;
        }

    }
}
