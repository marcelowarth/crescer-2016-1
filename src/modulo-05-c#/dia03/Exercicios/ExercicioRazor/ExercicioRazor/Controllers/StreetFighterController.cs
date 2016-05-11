using ExercicioRazor.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace ExercicioRazor.Controllers
{
    public class StreetFighterController : Controller
    {
        // GET: StreetFighter
        public ActionResult Index()
        {
            return View();
        }

        public ActionResult FichaTecnica()
        {
            return View();
        }

        public ActionResult Sobre()
        {
            var eu = new SobreMimModel()
            {
                Nome = "Sasuke",
                Nascimento = "08 de junho de 1992",
                Contato = "marcelowarth@gmail.com",
                Escolaridade = "Superior Incompleto",
                InstituicaoEnsino = "Feevale",
                Semestre = 8
            };
            return View(eu);
        }
    }
}