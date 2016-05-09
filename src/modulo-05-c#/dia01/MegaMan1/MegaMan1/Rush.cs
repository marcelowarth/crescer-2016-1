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

        }

        protected override int MaxUpgrades
        {
            get
            {
                return 2;
            }
        }

        protected override int Ataque
        {
            get
            {
                return 4 + BonusAtk;
            }
        }

        protected override int Defesa
        {
            get
            {
                return 3 + BonusDef;
            }
        }

        public string Tipo
        {
            get
            {
                return "Lendário";
            }
        }

        public override int BonusAtk
        {
            get
            {
                return Ataque;
            }
        }

        public override int BonusDef
        {
            get
            {
                return Defesa;
            }
        }

        public override void ReceberAtaque(int ataque)
        {
            base.ReceberAtaque(ataque);
        }
    }
}
