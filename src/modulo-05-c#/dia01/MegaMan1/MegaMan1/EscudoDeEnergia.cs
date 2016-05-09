using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MegaMan1
{
    public class EscudoDeEnergia : IUpgrade
    {
        public int BonusAtk
        {
            get
            {
                return 0;
            }
        }

        public int BonusDef
        {
            get
            {
                return 2;
            }
        }
    }
}
