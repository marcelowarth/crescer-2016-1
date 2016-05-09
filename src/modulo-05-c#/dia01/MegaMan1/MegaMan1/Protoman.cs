using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MegaMan1
{
    public class Protoman : Robo
    {
        bool Morreu = false;
        public Protoman() : base()
        {
            Defesa = 2;
        }

        public Protoman(Chip chip) : base(chip)
        {
            Defesa = 2;
        }

        protected override int Ataque { get; set; }

        protected override int Defesa { get; set; }

        public override void ReceberAtaque(int ataque)
        {
            base.ReceberAtaque(ataque);

            if (this.Vida <= 0 && Morreu == false)
            {
                this.Vida = 20;
                this.Ataque = 7;
                this.Morreu = true;
            }
        }
    }
}
