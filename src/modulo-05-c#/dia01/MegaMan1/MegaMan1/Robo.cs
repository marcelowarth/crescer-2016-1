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

        public Robo()
        {
            Vida = 100;
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
                return 5 + BonusAtk;
            }
        }

        protected virtual int Defesa
        {
            get
            {
                return 0 + BonusDef;
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

        public virtual void ToString()
        {
            Console.WriteLine("Nome: " + "" 
                + " Vida: " + this.Vida
                + " Ataque: " + this.Ataque
                + " Defesa: " + this.Defesa);
        }

        public virtual void EquiparUpgrade(IUpgrade upgrade)
        {
            if (upgrades.Count < this.MaxUpgrades)
            {
                upgrades.Add(upgrade);
                adicionarBonus(upgrade);
            }
        }

        protected virtual void adicionarBonus(IUpgrade upgrade)
        {
            BonusAtk += upgrade.BonusAtk;
            BonusDef += upgrade.BonusDef;
        }
    }
}
