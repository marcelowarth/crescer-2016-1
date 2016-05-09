using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MegaMan1
{
    public class Rush : Robo, IUpgrade
    {
        public Rush() : base()
        {
            Ataque = 4;
            Defesa = 3;
        }

        public Rush(Chip chip) : base(chip)
        {
            Ataque = 4;
            Defesa = 3;
        }

        protected override int MaxUpgrades
        {
            get { return 2; }
        }

        public int BonusAtk
        {
            get
            {
                return Ataque + AtaqueChipAtual + BonusAtkUpgrades;
            }
        }

        public int BonusDef
        {
            get
            {
                return Defesa + DefesaChipAtual + BonusDefUpgrades;
            }
        }

        public override void ReceberAtaque(int ataque)
        {
            int dano = ataque - BonusDefUpgrades;
            bool positive = dano >= 0;
            if (positive)
            {
                this.Vida -= dano;
            }
        }

        public override void Atacar(Robo robo)
        {
            if (!(robo is Megaman))
            {
                robo.ReceberAtaque(this.Ataque + this.BonusAtkUpgrades + this.AtaqueChipAtual);
            }
        }
    }
}
