using LojaNinja.Dominio;
using System;
using System.Collections.Generic;
using System.Data.SqlClient;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LojaNinja.Repositorio
{
    public static class SqlDataReaderExtensions
    {
        public static int ReadInt(this SqlDataReader leitor, string nomeColuna)
        {
            return Convert.ToInt32(leitor[nomeColuna]);
        }

        public static DateTime ReadDateTime(this SqlDataReader leitor, string nomeColuna)
        {
            return Convert.ToDateTime(leitor[nomeColuna]);
        }

        public static Decimal ReadDecimal(this SqlDataReader leitor, string nomeColuna)
        {
            return Convert.ToDecimal(leitor[nomeColuna]);
        }
        
        public static bool ReadBoolean(this SqlDataReader leitor, string nomeColuna)
        {
            return Convert.ToBoolean(leitor[nomeColuna]);
        }
    }
}
