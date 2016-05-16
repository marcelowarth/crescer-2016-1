using Dominio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Configuration;
using System.Data.SqlClient;
using System.Transactions;

namespace Repositorio
{
    public class UsuarioRepositorioADO : IUsuarioRepositorio
    {
        public Usuario BuscarUsuarioPorAutenticacao(string email, string senha)
        {
            var user = new Usuario();

            string connectionString = ConfigurationManager.ConnectionStrings["db_LojaNinja"].ConnectionString;

            using (TransactionScope scope = new TransactionScope())
            {
                using (var conexao = new SqlConnection(connectionString))
                {
                    try
                    {
                        string sql = "SELECT * FROM Usuarios WHERE email=@p_email and senha=@p_senha";

                        var comando = new SqlCommand(sql, conexao);
                        comando.Parameters.Add(new SqlParameter("p_email", email));
                        comando.Parameters.Add(new SqlParameter("p_senha", senha));

                        conexao.Open();

                        SqlDataReader leitor = comando.ExecuteReader();

                        if (leitor.Read())
                        {
                            user.Nome = leitor["nome"].ToString();
                            user.Senha = leitor["senha"].ToString();
                            user.Email = leitor["email"].ToString();
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
