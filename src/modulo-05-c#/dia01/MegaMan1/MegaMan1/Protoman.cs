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

        protected override int Ataque
        {
            get
            {
                if (Morreu)
                {
                    return 7 + BonusAtk;
                }
                return base.Ataque;
            }
        }

        protected override int Defesa
        {
            get
            {
                return 2 + BonusDef;
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
