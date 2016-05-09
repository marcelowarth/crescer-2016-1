using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MegaMan1
{
    public class BotasDeSuperVelocidade : IUpgrade
    {
        public int BonusAtk
        {
            get
            {
                return 1;
            }
        }

        public int BonusDef
        {
            get
            {
                return 1;
            }
        }
    }
}
