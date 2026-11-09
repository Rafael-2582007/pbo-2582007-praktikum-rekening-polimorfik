public class Tabungan extends Rekening implements BerBunga {
    private double bunga;   // persen per bulan, contoh 2.5

    public Tabungan(String nomor, String pemilik, int saldo, double bunga) {
        super(nomor, pemilik, saldo);
        this.bunga = bunga;
    }

    @Override
    public int biayaAdminBulanan() {
        return saldo >= 1000000 ? 0 : 5000;
    }

    @Override
    public int tambahBunga() {
        int hasil = (int) (saldo * bunga / 100);
        saldo += hasil;
        return hasil;
    }
}