using System;

namespace MegaMan1
{
    public interface IUpgrade
    {
        String Tipo { get; }
        int BonusAtk { get; }
        int BonusDef { get; }
    }
}