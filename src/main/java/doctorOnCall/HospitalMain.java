package doctorOnCall;

import java.util.List;

public class HospitalMain {

    public static void main(String[] args) {
        Hospital hospital = new Hospital("MCH Care");

        /* Adding two cardiologists*/
        hospital.addDoctor("David", 43, "cardio");
        hospital.addDoctor("Linda", 31, "cardio");

        /* Adding two neurosurgeons*/
        hospital.addDoctor("Mike", 37, "neuro");
        hospital.addDoctor("Katherine", 50, "neuro");

        /* Adding two dietiants*/
        hospital.addDoctor("Bob", 29, "diet");
        hospital.addDoctor("Chris", 41, "diet");

//        /* Printing size of the lists of doctors */
//        System.out.println(hospital.getCardiologists().size());
//        System.out.println(hospital.getNeurosurgeons().size());
//        System.out.println(hospital.getDietitians().size());

        List<Cardiologist> cList = hospital.getCardiologists();
        List<Neurosurgeon> nList = hospital.getNeurosurgeons();
        List<Dietitian> dList = hospital.getDietitians();

        /* Printing first element from every list */
        // hospital.printDoctor(cList.get(0));
        // hospital.printDoctor(nList.get(0));
        // hospital.printDoctor(dList.get(0));
        System.out.println("------------ Booking Appointments ------------");
        hospital.bookAppointment("Dave", 21, "neurosurgeon");
        hospital.bookAppointment("Kim", 19, "cardiologist");
        hospital.bookAppointment("Sarah", 27, "dietitian");
        System.out.println("------------ Printing Doctors ------------");
        hospital.printAllCardiologists();
        hospital.printAllNeurosurgeons();
        hospital.printAllDietitians();

        System.out.println("------------ Send Patients ------------");
        hospital.sendPatient(cList.get(0));
        /* Trying sending another patient to the same doctor */
        hospital.sendPatient(cList.get(0));
        cList.get(0).setAvailability(true);
        hospital.sendPatient(cList.get(0));
    }
}
