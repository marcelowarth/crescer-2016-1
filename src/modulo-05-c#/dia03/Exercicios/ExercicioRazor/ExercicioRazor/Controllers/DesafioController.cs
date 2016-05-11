using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace ExercicioRazor.Controllers
{
    public class DesafioController : Controller
    {
        // GET: PokemonDigimon
        public ActionResult PokemonDigimon(string aluno)
        {
            ViewBag.Path = ("~/Content/Estilo/PokemonDigimon/" + aluno + ".css");
            return View();
        }
    }
}