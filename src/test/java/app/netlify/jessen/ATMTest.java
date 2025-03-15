package app.netlify.jessen;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ATMTest {
    private ATM atm;
    private double saldoAwal = 1000;

    @BeforeMethod
    public void setSaldoAwal() {
        atm = new ATM(saldoAwal);
    }
    @Test
    public void testLihatSaldo() {
        Assert.assertEquals(saldoAwal, atm.lihatSaldo());
    }

    @Test
    public void testSetorUang() {
        double setor = 1234;
        atm.setorUang(setor);
        Assert.assertEquals(setor + saldoAwal, atm.lihatSaldo());
    }

    @Test
    public void testSetorUangNegative() {
        double setor = -1234;
        Assert.expectThrows(IllegalArgumentException.class, () -> atm.setorUang(setor));
    }

    @Test
    public void testTarikUang() {
        double currentSaldo = atm.lihatSaldo();
        double jumlahTarik = 100;
        atm.tarikUang(jumlahTarik);
        Assert.assertEquals(currentSaldo - jumlahTarik, atm.lihatSaldo());
    }

    @Test
    public void testTarikUangLebihDariSaldo() {
        double jumlahTarik = 1234;
        Assert.expectThrows(IllegalArgumentException.class, () -> atm.tarikUang(jumlahTarik));
    }

    @Test
    public void testTarikUangNegatif() {
        double jumlahTarik = -1234;
        Assert.expectThrows(IllegalArgumentException.class, () -> atm.tarikUang(jumlahTarik));
    }
}
