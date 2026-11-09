public abstract class Rekening {
    private String nomor;
    private String pemilik;
    protected int saldo;          // sebelumnya private

    // konstruktor tetap sama

    public String getNomor() {    // method baru, wajib public
        return nomor;
    }

    public abstract int biayaAdminBulanan();   // tanpa body, titik koma aja

    public int potongBiayaAdmin() {            // method konkret
        int biaya = biayaAdminBulanan();
        saldo -= biaya;
        return biaya;
    }

    public static String formatRupiah(int uang) {   // sebelumnya private
        // isi sama persis
    }
}