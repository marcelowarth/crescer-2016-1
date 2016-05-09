using System;

namespace MegaMan1
{
    public interface IUpgrade
    {
        int BonusAtk { get; }
        int BonusDef { get; }
    }
}