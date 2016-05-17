using System;
using System.Collections.Generic;
using System.Configuration;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LojaNinja.Repositorio
{
    public class RepositorioConnection
    {
        public string ConnectionString
        {
            get
            {
                return ConfigurationManager.ConnectionStrings["db_LojaNinja"].ConnectionString;
            }
        }
    }
}
