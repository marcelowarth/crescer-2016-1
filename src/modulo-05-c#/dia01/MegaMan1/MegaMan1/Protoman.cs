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

        }

        public Protoman(Chip chip) : base(chip)
        {

        }

        protected override int Ataque
        {
            get
            {
                if (Morreu)
                {
                    return 7 + BonusAtk + AtaqueChipAtual;
                }
                return base.Ataque;
            }
        }

        protected override int Defesa
        {
            get
            {
                return 2 + BonusDef + DefesaChipAtual;
            }
        }

        public override void ReceberAtaque(int ataque)
        {
            base.ReceberAtaque(ataque);
            if (this.Vida <= 0 && Morreu == false)
            {
                this.Vida = 20;
                this.Morreu = true;
            }
        }
    }
}
