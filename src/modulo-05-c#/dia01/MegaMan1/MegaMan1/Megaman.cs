using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MegaMan1
{
    public class Megaman : Robo
    {
        public Megaman() : base()
        {

        }

        protected override int Ataque
        {
            get
            {
                return 6 + BonusAtk;
            }
        }

        public override void Atacar(Robo robo)
        {
            if (this.Vida < 30)
            {
                robo.ReceberAtaque(this.Ataque + 3);
            }
            else
            {
                robo.ReceberAtaque(this.Ataque);
            }
        }
    }
}
