package doctorOnCall;

import java.util.ArrayList;
import java.util.List;

public class Hospital {
    enum doctorType { cardio, neuro, diet };
    private String name;
    private List<Cardiologist> cardiologists;
    private List<Neurosurgeon> neurosurgeons;
    private List<Dietitian> dietitians;

    public Hospital(String name) {
        this.name = name;
        this.cardiologists = new ArrayList<>();
        this.neurosurgeons = new ArrayList<>();
        this.dietitians = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Cardiologist> getCardiologists() {
        return cardiologists;
    }

    public List<Neurosurgeon> getNeurosurgeons() {
        return neurosurgeons;
    }

    public List<Dietitian> getDietitians() {
        return dietitians;
    }

    public void setDietitians(List<Dietitian> dietitians) {
        this.dietitians = dietitians;
    }

    public void addDoctor(String doctorName, int age, String dep) {
        if(dep.equalsIgnoreCase(doctorType.cardio.name())) {
            cardiologists.add(new Cardiologist(doctorName, age));
        }
        else if(dep.equalsIgnoreCase(doctorType.neuro.name())) {
            neurosurgeons.add(new Neurosurgeon(doctorName, age));
        }
        else if (dep.equalsIgnoreCase(doctorType.diet.name())) {
            dietitians.add(new Dietitian(doctorName, age));
        }
    }

    public void bookAppointment(String patientName, int patientAge, String docType) {
        Patient p = new Patient(patientName, patientAge);
        int docNum = (int) (Math.random()*10);

        // int randDoc = (int)(Math.random() * cardiologists.size());
        if(docType.equalsIgnoreCase("cardiologist")) {
            docNum = docNum % cardiologists.size();
            System.out.println("Appointment scheduled with "+cardiologists.get(docNum).getName());
        }
        else if(docType.equalsIgnoreCase("neurosurgeon")) {
            docNum = docNum % neurosurgeons.size();
            System.out.println("Appointment scheduled with "+neurosurgeons.get(docNum).getName());
        }
        else if (docType.equalsIgnoreCase("dietitian")) {
            docNum = docNum % dietitians.size();
            System.out.println("Appointment scheduled with "+neurosurgeons.get(docNum).getName());
        }
    }

    public void sendPatient(Doctor doctor) {
        if(doctor.getAvailability()) {
            System.out.println("It’s your turn, please go inside");
            doctor.setAvailability(false);
        } else {
            System.out.println("Sorry for the delay. Please wait for your turn");
        }
    }

    public void printPatient(Patient p) {
        System.out.println(p);
    }

    public void printDoctor(Doctor d) {
        System.out.println(d);
    }

    public void printAllCardiologists() {
        List<Cardiologist> cardio = getCardiologists();
        if(cardio.size()>0) {
            for(Cardiologist cardiologist: cardio) {
                cardiologist.printCardiologist();
            }
        } else {
            System.out.println("No cardiologist hired");
        }
    }

    public void printAllNeurosurgeons() {
        List<Neurosurgeon> neuro = getNeurosurgeons();
        if(neuro.size()>0) {
            for(Neurosurgeon neurosurgeon: neuro) {
                neurosurgeon.printNeurosurgeon();
            }
        } else {
            System.out.println("No neurosurgeon hired");
        }
    }

    public void printAllDietitians() {
        List<Dietitian> diet = getDietitians();
        if(diet.size()>0) {
            for (Dietitian dietitian : diet) {
                dietitian.printDietitian();
            }
        } else {
            System.out.println("No dietitian hired");
        }
    }
}
