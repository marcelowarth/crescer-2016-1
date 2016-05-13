using LojaNinja.Dominio;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace LojaNinja.MVC.Models
{
    public class PedidoModel
    {
        public int? Id { get; set; }

        [Required(ErrorMessage = "Data de Entrega deve ser informada")]
        [DisplayName("Data de Entrega")]
        [DisplayFormat(DataFormatString = "{0:dd/MM/yyyy}")]
        public DateTime DataEntrega { get; set; }

        [Required(ErrorMessage = "Nome do Produto deve ser informado")]
        [DisplayName("Nome do Produto")]
        public string NomeProduto { get; set; }

        [Required(ErrorMessage = "Valor deve ser informado")]
        [DisplayName("Valor")]
        [DisplayFormat(DataFormatString = "{0:c}", ApplyFormatInEditMode = true)]
        public Decimal Valor { get; set; }

        [Required]
        public TipoPagamento TipoPagamento { get; set; }

        [Required]
        [DisplayName("Tipo de Pagamento")]
        public TipoPagamento TipoDePagamento { get; set; }

        [Required(ErrorMessage = "Nome do Cliente deve ser informado")]
        [DisplayName("Nome do Cliente")]
        public string NomeCliente { get; set; }

        [Required(ErrorMessage = "Cidade deve ser informada")]
        public string Cidade { get; set; }

        [Required(ErrorMessage = "Estado deve ser informado")]
        public string Estado { get; set; }
    }
}