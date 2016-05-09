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

        public Rush(Chip chip) : base(chip)
        {

        }

        protected int BAtk
        {
            get
            {
                return base.BonusAtk;
            }
        }

        protected int BDef
        {
            get
            {
                return base.BonusDef;
            }
        }

        protected override int Ataque
        {
            get
            {
                return 4 + BAtk;
            }
        }

        protected override int Defesa
        {
            get
            {
                return 3 + BDef;
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
            int dano = ataque - BDef;
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
                robo.ReceberAtaque(this.Ataque);
            }
        }
    }
}
