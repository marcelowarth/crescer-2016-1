using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using MegaMan1;

namespace MegaMan1Test
{
    [TestClass]
    public class MegaMan1Test
    {
        [TestMethod]
        public void MegamanAtacaBot1Vez()
        {
            Bot bot = new Bot();
            Megaman mg = new Megaman();

            mg.Atacar(bot);

            Assert.AreEqual(94, bot.Vida);
        }

        [TestMethod]
        public void MegamanAtacaBotComBonus()
        {
            Bot bot = new Bot();
            Megaman mg = new Megaman();

            for (int i = 0; i < 15; i++)
            {
                bot.Atacar(mg);
            }

            mg.Atacar(bot);

            Assert.AreEqual(91, bot.Vida);
        }

        [TestMethod]
        public void ProtomanRecebeDanoBot()
        {
            Bot bot = new Bot();
            Protoman mg = new Protoman();

            bot.Atacar(mg);
            
            Assert.AreEqual(97, mg.Vida);
        }

        [TestMethod]
        public void ProtomanMorre()
        {
            Bot bot = new Bot();
            Protoman mg = new Protoman();

            for (int i = 0; i < 34; i++)
            {
                bot.Atacar(mg);
            }

            Assert.AreEqual(20, mg.Vida);
        }

        [TestMethod]
        public void ProtomanMorre2Vez()
        {
            Bot bot = new Bot();
            Protoman mg = new Protoman();

            for (int i = 0; i < 41; i++)
            {
                bot.Atacar(mg);
            }

            Assert.AreEqual(-1, mg.Vida);
        }

        [TestMethod]
        public void ProtomanMorreAtacaBonus()
        {
            Bot bot = new Bot();
            Protoman mg = new Protoman();

            for (int i = 0; i < 34; i++)
            {
                bot.Atacar(mg);
            }

            mg.Atacar(bot);

            Assert.AreEqual(93, bot.Vida);
        }

        [TestMethod]
        public void MegamanCanhaoAtaque8Dano()
        {
            var megaman = new Megaman();
            var canhao = new CanhaoDePlasma();
            var bot = new Bot();
            megaman.EquiparUpgrade(canhao);
            megaman.Atacar(bot);
            Assert.AreEqual(bot.Vida, 92);
        }

        [TestMethod]
        public void MegamanEscudoToma3Dano()
        {
            var megaman = new Megaman();
            var escudo = new EscudoDeEnergia();
            var bot = new Bot();
            megaman.EquiparUpgrade(escudo);
            bot.Atacar(megaman);
            Assert.AreEqual(megaman.Vida, 97);
        }

        [TestMethod]
        public void MegaManRecebeLendarioToma4Causa7Dano()
        {
            var megaman = new Megaman();
            var botas = new BotasDeSuperVelocidade();
            var bot = new Bot();
            megaman.EquiparUpgrade(botas);
            megaman.Atacar(bot);
            bot.Atacar(megaman);
            Assert.AreEqual(bot.Vida, 93);
            Assert.AreEqual(megaman.Vida, 96);
        }

        [TestMethod]
        public void MegaManTentaEquiparQuatroCanhoesRecebe6DeBonus()
        {
            var megaman = new Megaman();
            var canhao = new CanhaoDePlasma();
            var bot = new Bot();
            for (int i = 0; i < 4; i++)
            {
                megaman.EquiparUpgrade(canhao);
            }
            megaman.Atacar(bot);
            Assert.AreEqual(bot.Vida, 88);
        }

        [TestMethod]
        public void ProtomanCanhaoAtaque7Dano()
        {
            var protoman = new Protoman();
            var canhao = new CanhaoDePlasma();
            var bot = new Bot();
            protoman.EquiparUpgrade(canhao);
            protoman.Atacar(bot);
            Assert.AreEqual(bot.Vida, 93);
        }

        [TestMethod]
        public void ProtomanEscudoToma1Dano()
        {
            var protoman = new Protoman();
            var escudo = new EscudoDeEnergia();
            var bot = new Bot();
            protoman.EquiparUpgrade(escudo);
            bot.Atacar(protoman);
            Assert.AreEqual(protoman.Vida, 99);
        }

        [TestMethod]
        public void ProtomanRecebeLendarioToma2Causa6Dano()
        {
            var protoman = new Protoman();
            var botas = new BotasDeSuperVelocidade();
            var bot = new Bot();
            protoman.EquiparUpgrade(botas);
            protoman.Atacar(bot);
            bot.Atacar(protoman);
            Assert.AreEqual(bot.Vida, 94);
            Assert.AreEqual(protoman.Vida, 98);
        }

        [TestMethod]
        public void ProtomanTentaEquiparQuatroCanhoesRecebe6DeBonus()
        {
            var protoman = new Protoman();
            var canhao = new CanhaoDePlasma();
            var bot = new Bot();
            for (int i = 0; i < 4; i++)
            {
                protoman.EquiparUpgrade(canhao);
            }
            protoman.Atacar(bot);
            Assert.AreEqual(bot.Vida, 89);
        }

        /*
        [TestMethod]
        public void RushRecebeCanhaoPlasmaAtaqueCausa6Dano()
        {
            var rush = new Rush();
            var canhao = new CanhaoDePlasma();
            var bot = new Bot();
            rush.EquiparUpgrade(canhao);
            rush.Atacar(bot);
            Assert.AreEqual(bot.Vida, 94);
        }

        [TestMethod]
        public void RushRecebeEscudoDeEnergiaTomaZeroDano()
        {
            var rush = new Rush();
            var escudo = new EscudoDeEnergia();
            var bot = new Bot();
            rush.EquiparUpgrade(escudo);
            bot.Atacar(rush);
            Assert.AreEqual(bot.Vida, 100);
        }

        [TestMethod]
        public void RushTentaEquiparTresCanhoesRecebe4DeBonus()
        {
            var rush = new Rush();
            var canhao = new CanhaoDePlasma();
            var bot = new Bot();
            for (int i = 0; i < 3; i++)
            {
                rush.EquiparUpgrade(canhao);
            }
            rush.Atacar(bot);
            Assert.AreEqual(bot.Vida, 92);
        }
        
        [TestMethod]
        public void RushEquipaRushEquipadoComDoisCanhoesCausa13Dano()
        {
            var rush = new Rush();
            var rushEquip = new Rush();
            var canhao = new CanhaoDePlasma();
            rushEquip.EquiparUpgrade(canhao);
            rushEquip.EquiparUpgrade(canhao);
            rush.EquiparUpgrade(rushEquip);
            var bot = new Bot();
            rush.Atacar(bot);
            Assert.AreEqual(bot.Vida, 87);
        }
        */
    }
}
