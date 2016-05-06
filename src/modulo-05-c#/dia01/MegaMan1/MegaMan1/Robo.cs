using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MegaMan1
{
    public abstract class Robo
    {
        public abstract string Nome { get; }
        private int vida;
        public virtual int Vida()
        {
            get
            {
                return vida;
            }
            private set
            {

            }
        }
        public int Ataque
        {
            get
            {
                return 5;
            }         
        }
        public virtual int Defesa
        {
            get
            {
                return 0;
            }
        }

        public virtual void Atacar(Robo robo) { }
        public virtual void ReceberAtaque(int dano) { }
    }
}
