public abstract class Rekening {
    private String nomor;
    private String pemilik;
    protected int saldo;

    public Rekening(String nomor, String pemilik, int saldo) {
        this.nomor = nomor;
        this.pemilik = pemilik;
        this.saldo = saldo;
    }

    public String getNomor() {
        return nomor;
    }

    public int getSaldo() {
        return saldo;
    }

    public abstract int biayaAdminBulanan();

    public int potongBiayaAdmin() {
        int biaya = biayaAdminBulanan();
        saldo -= biaya;
        return biaya;
    }

    public boolean setor(int jumlah) {
        if (jumlah <= 0) {
            return false;
        }
        saldo += jumlah;
        return true;
    }

    public boolean tarik(int jumlah) {
        if (jumlah > 0 && jumlah <= saldo) {
            saldo -= jumlah;
            return true;
        }
        return false;
    }

    public void cetakInfo() {
        System.out.printf("%s | %-6s | %s%n", nomor, pemilik, formatRupiah(saldo));
    }

    public static String formatRupiah(int uang) {
        String angka = String.valueOf(Math.abs(uang));
        String hasil = "";
        int hitung = 0;

        for (int i = angka.length() - 1; i >= 0; i--) {
            hasil = angka.charAt(i) + hasil;
            hitung++;
            if (hitung % 3 == 0 && i > 0) {
                hasil = "." + hasil;
            }
        }

        return (uang < 0 ? "-Rp" : "Rp") + hasil;
    }
}