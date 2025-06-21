public class MVC {
    public static void main(String[] args) {
        Student model = new Student();
        model.setId("101");
        model.setName("John Doe");
        model.setGrade("A");
        StudentView view = new StudentView();
        StudentController controller = new StudentController(model, view);
        controller.updateView();
        controller.setStudentName("Jane Smith");
        controller.setStudentGrade("B");
        controller.updateView();
    }
}

