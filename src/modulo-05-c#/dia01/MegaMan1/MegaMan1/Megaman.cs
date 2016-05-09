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
            Ataque = 6;
        }

        public Megaman(Chip chip) : base(chip)
        {
            Ataque = 6;
        }

        protected override int Ataque { get; set; }

        public override void Atacar(Robo robo)
        {
            if (this.Vida < 30)
            {
                robo.ReceberAtaque(this.Ataque + 3 + AtaqueChipAtual + BonusAtkUpgrades);
            }
            else
            {
                robo.ReceberAtaque(this.Ataque + AtaqueChipAtual + BonusAtkUpgrades);
            }
        }
    }
}
