using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MegaMan1
{
    public class Robo
    {
        List<IUpgrade> upgrades = new List<IUpgrade>();
        public virtual int BonusAtk { get; set; }
        public virtual int BonusDef { get; set; }
        private Chip ChipAtual;

        public Robo()
        {
            Vida = 100;
            ChipAtual = Chip.Nivel2;
        }

        public Robo(Chip chip) : this()
        {
            ChipAtual = chip;
        }

        public int AtaqueChipAtual
        {
            get
            {
                switch (ChipAtual)
                {
                    case Chip.Nivel1:
                        return -1;
                    case Chip.Nivel3:
                        return 2;
                    default:
                        return 0;
                }
            }
        }

        public int DefesaChipAtual
        {
            get
            {
                switch (ChipAtual)
                {
                    case Chip.Nivel3:
                        return 1;
                    default:
                        return 0;
                }
            }
        }

        public int Vida { get; protected set; }

        protected virtual int MaxUpgrades
        {
            get { return 3; }
        }

        protected virtual int Ataque
        {
            get
            {
                return 5 + BonusAtk + AtaqueChipAtual;
            }
        }

        protected virtual int Defesa
        {
            get
            {
                return 0 + BonusDef + DefesaChipAtual;
            }
        }

        public virtual void Atacar(Robo robo)
        {
            robo.ReceberAtaque(this.Ataque);
        }

        public virtual void ReceberAtaque(int ataque)
        {
            int dano = ataque - this.Defesa;
            bool positive = dano >= 0;
            if(positive)
            {
                this.Vida -= dano;
            }
        }

        public virtual string ToString()
        {
            return ("Nome: " + "" 
                + ", Vida: " + this.Vida
                + ", Ataque: " + this.Ataque
                + ", Defesa: " + this.Defesa);
        }

        public virtual void EquiparUpgrade(IUpgrade upgrade)
        {
            if (upgrades.Count < this.MaxUpgrades)
            {
                upgrades.Add(upgrade);
                BonusAtk += upgrade.BonusAtk;
                BonusDef += upgrade.BonusDef;
            }
        }
    }
}
