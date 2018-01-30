package metier;

public class FichierCSV {
	private Long id;
	private String csv;

	public String getCsv() {
		return csv;
	}

	public void setCsv(String csv) {
		this.csv = csv;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public FichierCSV(Long id, String csv) {
		super();
		this.id = id;
		this.csv = csv;
	}
	
	
	
}
