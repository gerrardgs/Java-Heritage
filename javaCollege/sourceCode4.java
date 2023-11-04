public class Doctor {
    protected boolean worksAtHospital;

    public Doctor(boolean worksAtHospital){
        this.worksAtHospital = worksAtHospital;
    }

    public void treatPatient(){
        System.out.println("Memeriksa Pasien...");
    }

    // setter
    public void setWorksAtHospital(boolean worksAtHospital){
        this.worksAtHospital = worksAtHospital;
    }

    // getter
    public boolean getWorksAtHospital(){
        return this.worksAtHospital;
    }
}

public class FamilyDoctor extends Doctor{
    private boolean makeHouseCalls;

    public FamilyDoctor(boolean worksAtHospital, boolean makeHouseCalls){
        super(worksAtHospital);
        this.makeHouseCalls = makeHouseCalls;
    }

    public void giveAdvice(){
        System.out.println("Memberikan Anjuran Dokter...");
    }

    public boolean getMakeHouseCalls(){
        return this.makeHouseCalls;
    }
}

public class Surgeon extends Doctor{
    public Surgeon(boolean worksAtHospital){
        super(worksAtHospital);
    }

    // Overriding Methods
    @Override
    public void treatPatient(){
        System.out.println("\nMembedah Pasien...");
    }

    public void makeIncision(){
        System.out.println("Membuat Irisan di Kulit...");
    }
}

public class Main {
    public static void main(String[] args){

        // Kelas Doctor
        Doctor doctor = new Doctor(true);
        doctor.setWorksAtHospital(false);
        System.out.println("Doctor: " + doctor.getWorksAtHospital());
        doctor.treatPatient();

        // Kelas FamilyDoctor
        FamilyDoctor familyDoctor = new FamilyDoctor(false, true);
        familyDoctor.setWorksAtHospital(true);
        System.out.println("\nFamily Doctor: " + familyDoctor.getWorksAtHospital());
        System.out.println("Family Doctor: " + familyDoctor.getMakeHouseCalls());

        // Kelas Surgeon
        Surgeon surgeon = new Surgeon(true);
        surgeon.treatPatient();
        surgeon.makeIncision();
    }
}
