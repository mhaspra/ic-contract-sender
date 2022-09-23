package ch.mhaspra.insurancecase.iccontractsender;

public record Contract(Long contractNr, Long partnerNr, String title, boolean active) {
}
