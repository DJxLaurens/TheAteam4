package Onderdelen;

public class Auto {
	private String kenteken;
	private String merk;
	private int bouwjaar;
	private String type;
	private int eigenaarID;
	private Gebruiker eigenaar;
	private String brandstoftype;
	private int autoID;

	public Auto(int id, String kt, String mk, int bj, String tp, Gebruiker eig,
			String bt) {
		autoID = id;
		kenteken = kt;
		merk = mk;
		bouwjaar = bj;
		type = tp;
		eigenaar = eig;
		brandstoftype = bt;
	}

	public Auto() {
	}

	public String getKenteken() {
		return kenteken;
	}

	public void setKenteken(String kt) {
		kenteken = kt;
	}

	public int getEigenaarID() {
		return eigenaarID;
	}

	public void setEigenaarID(int id) {
		eigenaarID = id;
	}

	public String getMerk() {
		return merk;
	}

	public void setMerk(String mk) {
		merk = mk;
	}

	public int getBouwjaar() {
		return bouwjaar;
	}

	public void setBouwjaar(int bj) {
		bouwjaar = bj;
	}

	public String getType() {
		return type;
	}

	public void setType(String tp) {
		type = tp;
	}

	public Gebruiker getEigenaar() {
		return eigenaar;
	}

	public void setEigenaar(Gebruiker eig) {
		eigenaar = eig;
	}

	public String getBrandstoftype() {
		return brandstoftype;
	}

	public void setBrandstoftype(String tp) {
		brandstoftype = tp;
	}

	public void setAutoID(int id) {
		autoID = id;
	}

	public int getAutoID() {
		return autoID;
	}

	public String toString() {
		return merk + " " + type;
	}
}