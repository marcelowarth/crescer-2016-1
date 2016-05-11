using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace ExercicioRazor.Models
{
    public class SobreMimModel
    {
        public string Nome { get; set; }
        public string Nascimento { get; set; }
        public string Contato { get; set; }
        public string Escolaridade { get; set; }
        public string InstituicaoEnsino { get; set; }
        public int Semestre { get; set; }
    }
}