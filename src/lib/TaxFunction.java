package lib;

public class TaxFunction {

	
	/**
	 * Fungsi untuk menghitung jumlah pajak penghasilan pegawai yang harus dibayarkan setahun.
	 * 
	 * Pajak dihitung sebagai 5% dari penghasilan bersih tahunan (gaji dan pemasukan bulanan lainnya dikalikan jumlah bulan bekerja dikurangi pemotongan) dikurangi penghasilan tidak kena pajak.
	 * 
	 * Jika pegawai belum menikah dan belum punya anak maka penghasilan tidak kena pajaknya adalah Rp 54.000.000.
	 * Jika pegawai sudah menikah maka penghasilan tidak kena pajaknya ditambah sebesar Rp 4.500.000.
	 * Jika pegawai sudah memiliki anak maka penghasilan tidak kena pajaknya ditambah sebesar Rp 4.500.000 per anak sampai anak ketiga.
	 * 
	 */
	
	
	public static int calculateTax(int monthlySalary, int otherMonthlyIncome, int numberOfMonthsWorked,
                                    int deductible, boolean isMarried, int numberOfChildren) {

        int totalIncome = (monthlySalary + otherMonthlyIncome) * numberOfMonthsWorked;
        int childDeductible = Math.min(numberOfChildren, CHILD_DEDUCTIBLE_LIMIT) * CHILD_DEDUCTIBLE;

        int taxDeductible = isMarried ? MARRIED_DEDUCTIBLE : SINGLE_DEDUCTIBLE;

        int taxableIncome = totalIncome - deductible - taxDeductible - childDeductible;

        if (taxableIncome < 0) {
            return 0;
        }

        int tax = (int) Math.round(taxableIncome * TAX_RATE_PERCENTAGE / 100.0);

        return tax;
    }
	
}
