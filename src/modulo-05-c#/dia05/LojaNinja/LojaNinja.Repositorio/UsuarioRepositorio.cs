using LojaNinja.Dominio;
using LojaNinja.Repositorio;
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
        public List<Usuario> ObterUsuarios()
        {
            List<Usuario> lista = new List<Usuario>();

            using (TransactionScope scope = new TransactionScope())
            {
                using (var conexao = new SqlConnection(ConnectionString))
                {
                    try
                    {
                        string sql = "Select * from Usuarios";

                        var comando = new SqlCommand(sql, conexao);

                        conexao.Open();

                        SqlDataReader leitor = comando.ExecuteReader();

                        while (leitor.Read())
                        {
                            Usuario user = new Usuario();
                            user.Nome = leitor["nome_usuario"].ToString();
                            user.Senha = leitor["senha_usuario"].ToString();
                            user.Email = leitor["email_usuario"].ToString();

                            lista.Add(user);
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


        public Usuario BuscarUsuarioPorAutenticacao(string email, string senha)
        {
            Usuario user = null;

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
                            user = new Usuario();
                            user.Nome = leitor["nome_usuario"].ToString();
                            user.Senha = leitor["senha_usuario"].ToString();
                            user.Email = leitor["email_usuario"].ToString();
                            //user.Permissoes = BuscaPermissoesUsuario(leitor.ReadInt("id_usuario")).ToArray();
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

        private List<string> BuscaPermissoesUsuario(int id_user)
        {
            List<string> lista = new List<string>();

            using (TransactionScope scope = new TransactionScope())
            {
                using (var conexao = new SqlConnection(ConnectionString))
                {
                    try
                    {
                        string sql = "select p.permissao from Permissoes p JOIN Usuarios_Permissoes up ON p.id_permissao = up.id_permissao JOIN Usuarios u ON u.id_usuario = up.id_usuario where u.id_usuario = @p_iduser";

                        var comando = new SqlCommand(sql, conexao);
                        comando.Parameters.Add(new SqlParameter("p_iduser", id_user));
                        
                        conexao.Open();

                        SqlDataReader leitor = comando.ExecuteReader();

                        while (leitor.Read())
                        {
                            lista.Add(leitor["permissao"].ToString());
                        }
                    }
                    catch (Exception)
                    {
                        throw;
                    }
                }
            }

            return lista;
        }

        public void IncluirUsuario(Usuario user)
        {
            using (TransactionScope scope = new TransactionScope())
            {
                using (var conexao = new SqlConnection(ConnectionString))
                {
                    try
                    {
                        string sql = "Insert into Usuarios (nome_usuario, senha_usuario, email_usuario) values (@p_nome, @p_senha, @p_email)";

                        var comando = new SqlCommand(sql, conexao);
                        comando.Parameters.Add(new SqlParameter("p_email", user.Email));
                        comando.Parameters.Add(new SqlParameter("p_senha", user.Senha));
                        comando.Parameters.Add(new SqlParameter("p_nome", user.Nome));
                        
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
    }
}
