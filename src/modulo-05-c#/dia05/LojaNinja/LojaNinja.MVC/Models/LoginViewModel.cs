using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace LojaNinja.MVC.Models
{
    public class LoginViewModel
    {
        [Required]
        [DisplayName("E-mail")]
        [StringLength(50)]
        [EmailAddress]
        public string Email { get; set; }

        [Required]
        [DisplayName("Senha")]
        [StringLength(50)]
        [DataType(DataType.Password)]
        public string Senha { get; set; }
    }
}