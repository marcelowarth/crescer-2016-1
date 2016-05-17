using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace LojaNinja.MVC.Models
{
    public class UsuarioCadastroModel
    {
        [Required]
        [DisplayName("E-mail")]
        [StringLength(50)]
        [EmailAddress(ErrorMessage = "E-mail Invalido!")]
        public string Email { get; set; }

        [Required]
        [DisplayName("Nome")]
        [StringLength(50)]
        public string Nome { get; set; }

        private string _senha;
        [Required]
        [RegularExpression(@"^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,50}$$",
            ErrorMessage = "A senha deve conter no mínimo 8 caracteres tendo uma letra minúscula e uma maiúscula.")]
        [DisplayName("Senha")]
        [StringLength(50)]
        [DataType(DataType.Password)]
        public string Senha
        {
            get
            {
                return this._senha;
            }
            set
            {
                this._senha = value;
            }
        }

        private string _senhaConfirmacao;
        [Required]
        [DisplayName("Confirmar Senha")]
        [StringLength(50)]
        [DataType(DataType.Password)]
        [Compare("Senha", ErrorMessage = "As senhas não correspondem!")]
        public string SenhaConfirmada
        {
            get
            {
                return this._senhaConfirmacao;
            }
            set
            {
                this._senhaConfirmacao = value;
            }
        }
    }
}