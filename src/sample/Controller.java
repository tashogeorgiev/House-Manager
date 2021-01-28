package sample;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.Font;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;

/*
This is the Controller class for all the functions in the JavaFX menu
*/

public class Controller {
    public ComboBox<Company> removeCompanyComboBox;
    public ComboBox<Company> addEmployeeCompanyComboBox;
    public ComboBox<Company> removeEmployeeCompanyComboBox;
    public ComboBox<Company> addRemoveBuildingCompanyComboBox;
    public ComboBox<Company> editTaxForCompanyComboBox;
    public ComboBox<Company> taxForCompanyComboBox;
    public ComboBox<Company> writeTaxToFileCombBox;
    public ComboBox<Company> collectTaxForCompanyComboBox;
    public ComboBox<Company> collectTaxForApartmentCompanyComboBox;
    public ComboBox<Company> sortFromCompanyComboBox;
    public ComboBox<Building> addRemoveBuildingComboBox;
    public ComboBox<Building> editBuildingComboBox;
    public ComboBox<Building> addApartmentChooseBuildingComboBox;
    public ComboBox<Building> removeApartmentChooseBuildingComboBox;
    public ComboBox<Building> addInhabitantBuildingComboBox;
    public ComboBox<Building> removeInhabitantBuildingComboBox;
    public ComboBox<Building> changeOwnerBuildingComboBox;
    public ComboBox<Building> sortInhabitantsBuildingComboBox;
    public ComboBox<Building> chooseBuildingComboBox;
    public ComboBox<Building> editApartmentBuildingComboBox;
    public ComboBox<Building> showTaxComboBox;
    public ComboBox<Employee> removeEmployeeComboBox;
    public ComboBox<Employee> editEmployeeComboBox;
    public ComboBox<Employee> showEmployeeTaxComboBox;
    public ComboBox<Employee> showEmployeeBuildingsEmployeeComboBox;
    public ComboBox<Apartment> collectTaxForApartmentComboBox;
    public ComboBox<Apartment> removeApartmentComboBox;
    public ComboBox<Apartment> addInhabitantApartmentComboBox;
    public ComboBox<Apartment> removeInhabitantApartmentComboBox;
    public ComboBox<Apartment> changeOwnerApartmentComboBox;
    public ComboBox<Apartment> editApartmentComboBox;
    public ComboBox<Apartment> showTaxComboBox1;
    public ComboBox<Person> removeInhabitantComboBox;
    public ComboBox<Person> editPersonComboBox;
    public ComboBox<Person> changeOwnerComboBox;
    public ComboBox<String> addRemoveOptionComboBox;
    public ComboBox<String> showEmployeeBuildingsNumOrList;
    public ComboBox<String> taxForEmployeeComboBox;
    public ComboBox<String> showTaxForCompanyComboBox;
    public ComboBox<String> sortCompaniesOrEmployeesComboBox;
    public ComboBox<String> typeOfSortComboBox;
    public ComboBox<String> sortInhabitantsNameOrAgeComboBox;
    public ComboBox<String> showNumOrListComboBox;
    public ComboBox<String> showApartmentsOrInhabitantsComboBox;
    public ComboBox<String> showTypeOfTaxComboBox;
    public ComboBox<String> taxForBuildingOrApartmentComboBox;
    public ComboBox<Integer> addApartmentChooseFloorComboBox;
    public ComboBox<Integer> editApartmentFloorComboBox;

    public TextField companyNameField;
    public TextField addEmployeeNameField;
    public TextField addEmployeeAgeField;
    public TextField addEmployeeWorkExperience;
    public TextField editEmployeeNameField;
    public TextField editEmployeeAgeField;
    public TextField editEmployeeSalaryField;
    public TextField taxForAdultsField;
    public TextField taxForPetsField;
    public TextField taxForElevatorField;
    public TextField taxForAreaField;
    public TextField createBuildingAddressField;
    public TextField createBuildingFloorsField;
    public TextField createBuildingNumOfApartmentsField;
    public TextField editBuildingAddressField;
    public TextField editBuildingFloorsField;
    public TextField editBuildingNumOfApartmentsField;
    public TextField addApartmentNumberField;
    public TextField addApartmentAreaField;
    public TextField addApartmentOwnerName;
    public TextField addApartmentOwnerAge;
    public TextField addInhabitantNameField;
    public TextField addInhabitantAgeField;
    public TextField editApartmentNumberField;
    public TextField editApartmentAreaField;
    public TextField editPersonNameField;
    public TextField editPersonAgeField;

    public Button createCompanyButton;
    public Button addEmployeeButton;
    public Button removeEmployeeButton;
    public Button removeCompanyButton;
    public Button addRemoveBuildingButton;
    public Button editEmployeeButton;
    public Button showEmployeeBuildingsButton;
    public Button taxForEmployeeButton;
    public Button setTaxButton;
    public Button showTaxForCompanyButton;
    public Button collectTaxForCompanyButton;
    public Button collectTaxForApartmentButton;
    public Button WriteCollectedTaxesToFileButton;
    public Button sortButton;
    public Button createBuildingButton;
    public Button editBuildingNumOfApartmentsButton;
    public Button addApartmentButton;
    public Button removeApartmentButton;
    public Button addInhabitantButton;
    public Button removeInhabitantButton;
    public Button ChangeOwnerButton;
    public Button sortInhabitantsButton;
    public Button showInfoButton;
    public Button showTaxButton;
    public Button editApartmentButton;
    public Button editPersonButton;

    public Label createRemoveCompaniesTabLabel;
    public Label buildingsSortingInfoTabLabel;
    public Label addRemoveApartmentsTabLabel;
    public Label createEditBuildingsTabLabel;
    public Label CompanyTaxTabLabel;
    public Label CompanySortTabLabel;
    public Label employeesTabLabel;
    public Label editApartmentsPeopleLabel;

    public CheckBox addApartmentPetCheckBox;
    public CheckBox editApartmentPetCheckBox;

    ArrayList<Person> peopleArrayList = new ArrayList<>();
    ArrayList<Employee> employeeArrayList = new ArrayList<>();
    ArrayList<Apartment> apartmentArrayList = new ArrayList<>();
    ArrayList<Building> buildingArrayList = new ArrayList<>();
    ArrayList<Company> companyArrayList = new ArrayList<>();



    @FXML
    public void initialize(){
        //Set the options for the comboBoxes which aren't objects, the others are being set by the UpdateComboBoxes() function
        addRemoveOptionComboBox.setItems(FXCollections.observableArrayList("Add", "Remove"));
        showEmployeeBuildingsNumOrList.setItems(FXCollections.observableArrayList("Number", "List"));
        taxForEmployeeComboBox.setItems(FXCollections.observableArrayList("Collected", "Uncollected"));
        showTaxForCompanyComboBox.setItems(FXCollections.observableArrayList("Collected", "Uncollected"));
        sortCompaniesOrEmployeesComboBox.setItems(FXCollections.observableArrayList("Companies", "Employees"));
        sortInhabitantsNameOrAgeComboBox.setItems(FXCollections.observableArrayList("Name", "Age"));
        showNumOrListComboBox.setItems(FXCollections.observableArrayList("Number", "List"));
        showApartmentsOrInhabitantsComboBox.setItems(FXCollections.observableArrayList("Apartments", "Inhabitants"));
        showTypeOfTaxComboBox.setItems(FXCollections.observableArrayList("Collected", "Uncollected"));
        taxForBuildingOrApartmentComboBox.setItems(FXCollections.observableArrayList("Building", "Apartment"));

        //add the hardcoded objects
        //AddSampleItems();

        UpdateComboBoxes();
    }


    /*
     ***************************************************************
     ***************************************************************
     *                     COMPANY MAIN TAB                        *
     ***************************************************************
     ***************************************************************
     */




    /*
     ***************************************************************
     ***************************************************************
     *                    CREATE/REMOVE TAB                        *
     ***************************************************************
     ***************************************************************
     */



    /*
     ***************************************************************
     *                       Create Company                        *
     ***************************************************************
     */
    public void CreateCompany(){
        if(!companyNameField.getText().equals("")){
            Company newCompany = new Company(companyNameField.getText());
            if(companyArrayList.contains(newCompany)){
                createRemoveCompaniesTabLabel.setText("Company Already Created");
            }
            else {
                companyArrayList.add(newCompany);
                createRemoveCompaniesTabLabel.setText("Company " + newCompany.getName() + " Created");
                removeCompanyComboBox.getItems().add(newCompany);
                UpdateComboBoxes();
            }
        }
        else{
            createRemoveCompaniesTabLabel.setText("No Name Entered");
        }
    }



    /*
     ***************************************************************
     *                       Remove Company                        *
     ***************************************************************
     */
    public void RemoveCompany(){
        try {
            companyArrayList.remove(removeCompanyComboBox.getValue());
            createRemoveCompaniesTabLabel.setText("Company " + removeCompanyComboBox.getValue().getName() + " Removed");
            UpdateComboBoxes();
        }
        catch(Exception e) {
            createRemoveCompaniesTabLabel.setText("Couldn't Remove Company");
        }
    }

    /*
     ***************************************************************
     *                        Add Employee                         *
     ***************************************************************
     */
    public void AddEmployee(){
        try{
            String name = addEmployeeNameField.getText();
            int age = Integer.parseInt(addEmployeeAgeField.getText());
            int workExperience = Integer.parseInt(addEmployeeWorkExperience.getText());

            Employee newEmployee = new Employee(name, age ,workExperience);
            if(!employeeArrayList.contains(newEmployee)) {
                employeeArrayList.add(newEmployee);
                addEmployeeCompanyComboBox.getValue().addEmployee(newEmployee);

                createRemoveCompaniesTabLabel.setText("Employee Added");
                UpdateComboBoxes();
            }
            else{
                createRemoveCompaniesTabLabel.setText("Employee Already Exists");
            }

        }catch (Exception e){
            createRemoveCompaniesTabLabel.setText("Error Adding Employee");
        }
    }


    /*
     ***************************************************************
     *                       Remove Employee                       *
     ***************************************************************
     */

    //When a company is selected, update the employees combobox with the employees from that company
    public void UpdateRemoveEmployeeComboBox(){
        try {
            removeEmployeeComboBox.getItems().clear();
            removeEmployeeComboBox.getItems().setAll(removeEmployeeCompanyComboBox.getValue().ShowEmployees());
        }
        catch (Exception e){
            System.out.print("");
        }
    }


    public void RemoveEmployee(){
        try{
            removeEmployeeCompanyComboBox.getValue().removeEmployee(removeEmployeeComboBox.getValue());
            employeeArrayList.remove(removeEmployeeComboBox.getValue());
            createRemoveCompaniesTabLabel.setText("Employee Removed");
            UpdateComboBoxes();
        }catch(Exception e){
            createRemoveCompaniesTabLabel.setText("Couldn't Remove Employee");
        }
    }



    /*
     ***************************************************************
     *                   Add/Remove Building                       *
     ***************************************************************
     */

    /*
     * Every time the "Add/Remove" option is changed
     * update the buildings combobox for the selected building
     */
    public void UpdateBuildingComboBox(){
        if(addRemoveBuildingCompanyComboBox.getValue()!=null){
            SetAddRemoveBuildingComboBox();
        }
    }

    /*
     * Used for the Add/Remove Building Option,
     * If "Add" is selected, update the buildings combobox
     * with all the buildings which are not worked on by any
     * company, if "Remove" is selected, update it with all
     * the buildings, which are worked on by the selected company
     */
    public void SetAddRemoveBuildingComboBox(){
        try {
            if(addRemoveOptionComboBox.getValue().equals("Remove")) {
                addRemoveBuildingComboBox.getItems().clear();
                for (Employee employee : addRemoveBuildingCompanyComboBox.getValue().ShowEmployees()) {
                    addRemoveBuildingComboBox.getItems().addAll(addRemoveBuildingCompanyComboBox.getValue().BuildingsByEmployee(employee));
                }
            }
            else if(addRemoveOptionComboBox.getValue().equals("Add")){
                addRemoveBuildingComboBox.getItems().clear();
                    for(Building building: buildingArrayList){
                        if(!addRemoveBuildingCompanyComboBox.getValue().containsBuilding(building)){
                            if(!building.hasCompany()) {
                                addRemoveBuildingComboBox.getItems().addAll(building);
                            }
                        }
                    }
            }
        }
        catch (Exception e){
            System.out.print("");
        }
    }


    public void AddOrRemoveBuilding(){
        try {
            if (addRemoveOptionComboBox.getValue().equals("Add")) {
                try{
                    addRemoveBuildingCompanyComboBox.getValue().addBuilding(addRemoveBuildingComboBox.getValue());
                    addRemoveBuildingComboBox.getValue().setHasCompany(true);
                    createRemoveCompaniesTabLabel.setText("Building Added");
                }
                catch (Exception e){
                    createRemoveCompaniesTabLabel.setText("Couldn't Add Building");
                }
            } else if (addRemoveOptionComboBox.getValue().equals("Remove")) {
                try{
                    addRemoveBuildingCompanyComboBox.getValue().removeBuilding(addRemoveBuildingComboBox.getValue());
                    addRemoveBuildingComboBox.getValue().setHasCompany(false);
                    createRemoveCompaniesTabLabel.setText("Building Removed");
                }
                catch (Exception e){
                    createRemoveCompaniesTabLabel.setText("Couldn't Remove Building");
                }
            }
        }catch (Exception e){
            createRemoveCompaniesTabLabel.setText("No Option Selected");
        }
    }



    /*
     ***************************************************************
     ***************************************************************
     *                      EMPLOYEES TAB                          *
     ***************************************************************
     ***************************************************************
     */

    /*
     ***************************************************************
     *                       Edit Employee                         *
     ***************************************************************
     */
    public void EditEmployee(){
        boolean edited = false;
        try{//since any field can be edited, only one input is needed
            if(!editEmployeeNameField.getText().equals("")){
                editEmployeeComboBox.getValue().setName(editEmployeeNameField.getText());
                edited = true;
            }
            if(!editEmployeeAgeField.getText().equals("")){
                editEmployeeComboBox.getValue().setAge(Integer.parseInt(editEmployeeAgeField.getText()));
                edited = true;
            }
            if(!editEmployeeSalaryField.getText().equals("")){
                editEmployeeComboBox.getValue().setSalary(Integer.parseInt(editEmployeeSalaryField.getText()));
                edited = true;
            }
            if(edited){
                employeesTabLabel.setText("Employee Info Updated");
                UpdateComboBoxes();
            }
        }
        catch(Exception e){
            employeesTabLabel.setText("Couldn't Edit Employee");
        }
    }


    /*
     ***************************************************************
     *                   Buildings By Employee                     *
     ***************************************************************
     */
    public void ShowBuildingsByEmployee(){
        try{
            Employee tempEmployee = showEmployeeBuildingsEmployeeComboBox.getValue();

            if(showEmployeeBuildingsNumOrList.getValue().equals("Number")){
                employeesTabLabel.setText(tempEmployee.getName() + " Is Working On " +
                        tempEmployee.getWorksForCompany().BuildingsByEmployee(tempEmployee).size() + " Building(s)");
            }

            else if(showEmployeeBuildingsNumOrList.getValue().equals("List")){
                employeesTabLabel.setFont(new Font(25));//the list could be bigger, so lower the font to fit them in the Label
                StringBuilder BuildingsString = new StringBuilder(); //String for buildings info

                for(Building building : tempEmployee.getWorksForCompany().BuildingsByEmployee(tempEmployee)){
                    BuildingsString.append(building).append("\n");//Add all the buildings for that employee
                }
                employeesTabLabel.setText(tempEmployee.getName() + " Is Working On: \n" + BuildingsString);
            }
        }
        catch(Exception e){
            employeesTabLabel.setText("Couldn't Show Buildings");
        }
    }


    /*
     ***************************************************************
     *                      Taxes By Employee                      *
     ***************************************************************
     */
    public void ShowTaxForEmployee(){
        try{
            Employee tempEmployee = showEmployeeTaxComboBox.getValue();

            if(taxForEmployeeComboBox.getValue().equals("Collected")){
                employeesTabLabel.setText(tempEmployee.getName() + " Has Collected $" + tempEmployee.getCollectedTax());
            }

            else if(taxForEmployeeComboBox.getValue().equals("Uncollected")){
                tempEmployee.getWorksForCompany().calculateTaxToCollect();//Calculate the taxes which have to be collected
                employeesTabLabel.setText(tempEmployee.getName() + " Has To Collect $" + tempEmployee.getTaxToCollect());
            }
        }
        catch(Exception e){
            employeesTabLabel.setText("Couldn't Show Tax");
        }
    }



    /*
     ***************************************************************
     ***************************************************************
     *                          TAX TAB                            *
     ***************************************************************
     ***************************************************************
     */

    /*
     ***************************************************************
     *                      Taxes By Employee                      *
     ***************************************************************
     */
    public void EditTax(){
        boolean edited = false;
        try{//same logic as edit employee
            Company tempCompany = editTaxForCompanyComboBox.getValue();
            if(!taxForAdultsField.getText().equals("")){
                tempCompany.setAdultTax(Double.parseDouble(taxForAdultsField.getText()));
                edited = true;
            }
            if(!taxForElevatorField.getText().equals("")){
                tempCompany.setElevatorTax(Double.parseDouble(taxForElevatorField.getText()));
                edited = true;
            }
            if(!taxForPetsField.getText().equals("")){
                tempCompany.setPetTax(Double.parseDouble(taxForPetsField.getText()));
                edited = true;
            }
            if(!taxForAreaField.getText().equals("")){
                tempCompany.setAreaTax(Double.parseDouble(taxForAreaField.getText()));
                edited = true;
            }
            if(edited){
                CompanyTaxTabLabel.setText(tempCompany.getName() + " Tax Rates Updated");
            }
        }
        catch(Exception e){
            CompanyTaxTabLabel.setText("Couldn't Edit Tax Rates");
        }
    }


    /*
     ***************************************************************
     *                      Taxes For Company                      *
     ***************************************************************
     */
    public void ShowTaxForCompany(){
        try{
            Company tempCompany = taxForCompanyComboBox.getValue();

            if(showTaxForCompanyComboBox.getValue().equals("Collected")){
                CompanyTaxTabLabel.setText(tempCompany.getName() + " Has Collected $" + tempCompany.getTaxCollected());
            }

            else if(showTaxForCompanyComboBox.getValue().equals("Uncollected")){
                tempCompany.calculateTaxToCollect();
                CompanyTaxTabLabel.setText(tempCompany.getName() + " Has To Collect $" + tempCompany.getTaxToCollect());
            }
            else{
                CompanyTaxTabLabel.setText("No Option Selected");
            }
        }
        catch(Exception e){
            CompanyTaxTabLabel.setText("Couldn't Show Tax");
        }
    }

    /*
     ***************************************************************
     *                   Collect Tax For Company                   *
     ***************************************************************
     */
    public void CollectTax(){
        try{
            Company tempCompany = collectTaxForCompanyComboBox.getValue();
            tempCompany.calculateTaxToCollect();
            tempCompany.collectTax();
            CompanyTaxTabLabel.setText("Tax For " + tempCompany.getName() + " Collected");
        }
        catch(Exception e){
            CompanyTaxTabLabel.setText("Couldn't Collect Tax");
        }
    }

    /*
     ***************************************************************
     *                 Collect Tax For Apartment                   *
     ***************************************************************
     */

    //Update the apartments combobox when a new company is selected
    public void UpdateTaxForApartmentComboBox(){
        try{
            collectTaxForApartmentComboBox.getItems().clear();
            Company tempCompany = collectTaxForApartmentCompanyComboBox.getValue();
            for(Employee employee : tempCompany.ShowEmployees()){
                for(Building building : tempCompany.BuildingsByEmployee(employee)){
                    collectTaxForApartmentComboBox.getItems().addAll(building.getApartments());
                }
            }
        }
        catch(Exception e){
            System.out.print("");
        }
    }


    public void CollectTaxForApartment(){
        try{
            Company tempCompany = collectTaxForApartmentCompanyComboBox.getValue();
            Apartment tempApartment = collectTaxForApartmentComboBox.getValue();
            if(!tempApartment.isTaxPaid()) {
                tempCompany.collectTaxForApartment(tempApartment);
                CompanyTaxTabLabel.setText("Tax For Apartment Collected");
            }
            else{
                CompanyTaxTabLabel.setText("Tax For Apartment Is Already Collected");
            }
        }
        catch(Exception e){
            CompanyTaxTabLabel.setText("Couldn't Collect Tax");
        }
    }

    public void WriteTaxesToFile(){
        try{
            Company tempCompany = writeTaxToFileCombBox.getValue();
            tempCompany.writeTaxesToFile();
            CompanyTaxTabLabel.setText("Taxes Written To File");
        }
        catch(Exception e){
            CompanyTaxTabLabel.setText("Couldn't Write Taxes To File");
        }
    }


    /*
     ***************************************************************
     ***************************************************************
     *                      SORTING TAB                            *
     ***************************************************************
     ***************************************************************
     */


    /*
     * If Companies is selected, put the only option to be sorting by taxes
     * If Employees is selected, put the two options to be by name or num of buildings
     */
    public void UpdateSortingOption(){
        try{
            if(sortCompaniesOrEmployeesComboBox.getValue().equals("Companies")){
                sortFromCompanyComboBox.setDisable(true);
                typeOfSortComboBox.getItems().clear();
                typeOfSortComboBox.getItems().addAll("Collected Taxes");
            }
            else if(sortCompaniesOrEmployeesComboBox.getValue().equals("Employees")){
                sortFromCompanyComboBox.setDisable(false);
                typeOfSortComboBox.getItems().clear();
                typeOfSortComboBox.getItems().addAll("Name");
                typeOfSortComboBox.getItems().addAll("Number Of Buildings");
            }
        }
        catch(Exception e){
            System.out.print("");
        }
    }


    public void SortCompaniesOrEmployees(){
        try{
            StringBuilder ResultString = new StringBuilder();//Text which will display the result
            int cnt = 1;

            //Sorting Companies By Collected Taxes
            if(sortCompaniesOrEmployeesComboBox.getValue().equals("Companies") && typeOfSortComboBox.getValue().equals("Collected Taxes")){
                companyArrayList.sort(Comparator.comparing(Company::getTaxCollected));//sorted list
                ResultString.append("Companies Sorted By Taxes:").append("\n");

                for(int i = companyArrayList.size()-1; i>= 0; i--){
                    ResultString.append(cnt).append(". ").append(companyArrayList.get(i))
                    .append(" Taxes: $").append(companyArrayList.get(i).getTaxCollected()).append("\n");
                    cnt+=1;
                }
                CompanySortTabLabel.setText(String.valueOf(ResultString));
            }

            //Sorting Employees
            else if(sortCompaniesOrEmployeesComboBox.getValue().equals("Employees")) {
                ArrayList<Employee> tempList;
                Company company = sortFromCompanyComboBox.getValue();

                //By Name
                if(typeOfSortComboBox.getValue().equals("Name")){
                    tempList = company.sortEmployeesByName();//sorted list
                    ResultString.append("Employees Sorted By Name:" + "\n");

                    for (Employee employee : tempList) {
                        ResultString.append(cnt).append(". ").append(employee).append("\n");
                        cnt += 1;
                    }
                }
                //By Number of Buildings
                else if(typeOfSortComboBox.getValue().equals("Number Of Buildings")){
                    tempList = company.sortEmployeesByNumOfBuildings();//sorted list
                    ResultString.append("Employees Sorted By Number Of Buildings:" + "\n");

                    for(int i = tempList.size()-1; i>= 0; i--){
                        ResultString.append(cnt).append(". ").append(tempList.get(i))
                        .append(", Number Of Buildings: ").append(tempList.get(i).getNumberOfBuildings()).append("\n");
                        cnt+=1;
                    }
                }

                CompanySortTabLabel.setText(String.valueOf(ResultString));
            }
        }
        catch(Exception e){
            CompanySortTabLabel.setText("Couldn't Sort");
        }
    }

    /*
     ***************************************************************
     ***************************************************************
     *                     BUILDINGS MAIN TAB                      *
     ***************************************************************
     ***************************************************************
     */




    /*
     ***************************************************************
     ***************************************************************
     *                      CREATE/Edit TAB                        *
     ***************************************************************
     ***************************************************************
     */

    /*
     ***************************************************************
     *                      Create Building                        *
     ***************************************************************
     */
    public void CreateBuilding(){
        try{
            String address = createBuildingAddressField.getText();
            int floors = Integer.parseInt(createBuildingFloorsField.getText());
            int numOfApartments = Integer.parseInt(createBuildingNumOfApartmentsField.getText());

            Building newBuilding = new Building(address,floors,numOfApartments);

            //if building doesnt exist, create it
            if(!buildingArrayList.contains(newBuilding)) {
                buildingArrayList.add(newBuilding);
                createEditBuildingsTabLabel.setText("Building Created");
            }
            else{
                createEditBuildingsTabLabel.setText("Building Already Exists");
            }
            UpdateComboBoxes();
        }
        catch (IOException e1){//building constructor throws IOException if address is invalid
            createEditBuildingsTabLabel.setText("Invalid Address");
        }
        catch(Exception e2){
            createEditBuildingsTabLabel.setText("Couldn't Create Building");
        }
    }

    /*
     ***************************************************************
     *                      Edit Building                          *
     ***************************************************************
     */
    public void EditBuilding() {
        boolean edited = false;
        try{//same as edit employee, taxes
            if(!editBuildingAddressField.getText().equals("")){
                editBuildingComboBox.getValue().setAddress(editBuildingAddressField.getText());
                edited = true;
            }
            if(!editBuildingFloorsField.getText().equals("")){
                editBuildingComboBox.getValue().setFloors(Integer.parseInt(editBuildingFloorsField.getText()));
                edited = true;
            }
            if(!editBuildingNumOfApartmentsField.getText().equals("")){
                editBuildingComboBox.getValue().setNumberOfApartments(Integer.parseInt(editBuildingNumOfApartmentsField.getText()));
                edited = true;
            }
            if(edited){
                createEditBuildingsTabLabel.setText("Building Edited");
                UpdateComboBoxes();
            }
        }
        catch (IOException e1){//Building constructor throws IOException if address is invalid
            createEditBuildingsTabLabel.setText("Invalid Address");
        }
        catch(Exception e2){
            createEditBuildingsTabLabel.setText("Couldn't Edit Building");
        }
    }



    /*
     ***************************************************************
     ***************************************************************
     *              CREATE/REMOVE APARTMENTS TAB                   *
     ***************************************************************
     ***************************************************************
     */


    /*
     ***************************************************************
     *                      Create Apartment                       *
     ***************************************************************
     */


    //When a building is selected, update the floors combobox with
    //the number of floors in that building
    public void UpdateBuildingFloorsComboBox(){
        try{
            addApartmentChooseFloorComboBox.getItems().clear();
            for(int i = 1; i <= addApartmentChooseBuildingComboBox.getValue().getFloors(); i++){
                addApartmentChooseFloorComboBox.getItems().addAll(i);
            }
        }
        catch(Exception e){
            System.out.print("");
        }
    }


    public void AddApartment(){
        try{
            Building selectedBuilding = addApartmentChooseBuildingComboBox.getValue();
            int apartmentNum = Integer.parseInt(addApartmentNumberField.getText());
            int floor = addApartmentChooseFloorComboBox.getValue();
            int area = Integer.parseInt(addApartmentAreaField.getText());
            boolean hasPet = addApartmentPetCheckBox.isSelected();
            Person owner = new Person(addApartmentOwnerName.getText(), Integer.parseInt(addApartmentOwnerAge.getText()));
            Apartment newApartment = new Apartment(apartmentNum,floor,area,hasPet,owner);

            if (!peopleArrayList.contains(owner)) {//add the owner to the people list if he isn't there already
                peopleArrayList.add(owner);
            }

            if (!selectedBuilding.getApartments().contains(newApartment)) {//if the building doesn't have this apartment, add it
                //if the max num of apartments in the building is passed, deny adding the building
                if(selectedBuilding.getApartments().size() < selectedBuilding.getNumberOfApartments()) {
                    addApartmentChooseBuildingComboBox.getValue().addApartment(newApartment);
                    apartmentArrayList.add(newApartment);
                    addRemoveApartmentsTabLabel.setText("Apartment Added");
                }
                else {
                    addRemoveApartmentsTabLabel.setText("Cannot Exceed Maximum Number Of Apartments In This Building");
                }
            } else {
                addRemoveApartmentsTabLabel.setText("Apartment Already Exists");
            }

            UpdateComboBoxes();
        }
        catch(Exception e){
            addRemoveApartmentsTabLabel.setText("Couldn't Add Apartment");
        }
    }


    /*
     ***************************************************************
     *                     Remove Apartment                        *
     ***************************************************************
     */

    //update the apartments combobox with the apartments from the selected building
    public void UpdateRemoveApartmentComboBox(){
        try{
            removeApartmentComboBox.getItems().clear();
            removeApartmentComboBox.getItems().addAll(removeApartmentChooseBuildingComboBox.getValue().getApartments());
        }
        catch(Exception e){
            System.out.print("");
        }
    }

    public void RemoveApartment(){
        try{
            removeApartmentChooseBuildingComboBox.getValue().removeApartment(removeApartmentComboBox.getValue());
            UpdateRemoveApartmentComboBox();
            addRemoveApartmentsTabLabel.setText("Apartment Removed");
        }
        catch (Exception e){
            addRemoveApartmentsTabLabel.setText("Couldn't Remove Apartment");
        }
    }


    /*
     ***************************************************************
     *                  Change Apartment Owner                     *
     ***************************************************************
     */

    //Update apartments combobox when a building is selected
    public void UpdateChangeOwnerApartmentComboBox(){
        try{
            changeOwnerApartmentComboBox.getItems().clear();
            changeOwnerApartmentComboBox.getItems().addAll(changeOwnerBuildingComboBox.getValue().getApartments());
        }
        catch(Exception e){
            System.out.print("");
        }
    }

    //Update owners combobox when an apartment is selected
    public void UpdateChangeOwnerComboBox(){
        try{
            changeOwnerComboBox.getItems().clear();
            //add all the people to the new owner selection menu except the current owner
            for (Person person : peopleArrayList) {
                if (person != changeOwnerApartmentComboBox.getValue().getOwner()) {
                    changeOwnerComboBox.getItems().addAll(person);
                }
            }
        }
        catch(Exception e){
            System.out.print("");
        }
    }

    public void ChangeOwner() {
        try {
            changeOwnerApartmentComboBox.getValue().setOwner(changeOwnerComboBox.getValue());
            UpdateComboBoxes();
            addRemoveApartmentsTabLabel.setText("Owner Changed");
        }
        catch (Exception e){
            addRemoveApartmentsTabLabel.setText("Couldn't Change Owner");
        }
    }



    /*
     ***************************************************************
     *              Add Inhabitant To Apartment                    *
     ***************************************************************
     */

    //when a building is selected, update the apartments combobox with the apartments from that building
    public void UpdateNewInhabitantApartmentComboBox(){
        try{
            addInhabitantApartmentComboBox.getItems().clear();
            addInhabitantApartmentComboBox.getItems().addAll(addInhabitantBuildingComboBox.getValue().getApartments());
        }
        catch(Exception e){
            System.out.print("");
        }
    }


    public void AddInhabitant(){
        try {
            Person inhabitant = new Person(addInhabitantNameField.getText(), Integer.parseInt(addInhabitantAgeField.getText()));
            addInhabitantApartmentComboBox.getValue().addInhabitant(inhabitant);
            if(!peopleArrayList.contains(inhabitant)){
                peopleArrayList.add(inhabitant);
            }
            UpdateComboBoxes();
            addRemoveApartmentsTabLabel.setText("Inhabitant Added");
        }
        catch (Exception e){
            addRemoveApartmentsTabLabel.setText("Couldn't Add Inhabitant");
        }
    }

    /*
     ***************************************************************
     *              Remove Inhabitant From Apartment               *
     ***************************************************************
     */

    //when a building is selected, update the apartments combobox with the apartments from that building
    public void UpdateRemoveInhabitantApartmentComboBox(){
        try{
            removeInhabitantApartmentComboBox.getItems().clear();
            removeInhabitantApartmentComboBox.getItems().addAll(removeInhabitantBuildingComboBox.getValue().getApartments());
        }
        catch(Exception e){
            System.out.print("");
        }
    }

    //when an apartment is selected, update the inhabitants combobox with the inhabitants from that apartment
    public void UpdateRemoveInhabitantComboBox(){
        try{
            removeInhabitantComboBox.getItems().clear();
            //add all the people from the selected apartment to the inhabitants menu
            for (Person person : peopleArrayList) {
                if (removeInhabitantApartmentComboBox.getValue().getInhabitants().contains(person)) {
                    removeInhabitantComboBox.getItems().addAll(person);
                }
            }
        }
        catch(Exception e){
            System.out.print("");
        }
    }


    public void RemoveInhabitant(){
        try{
            removeInhabitantApartmentComboBox.getValue().removeInhabitant(removeInhabitantComboBox.getValue());
            UpdateRemoveInhabitantComboBox();
            addRemoveApartmentsTabLabel.setText("Inhabitant Removed From Apartment");
        }
        catch(Exception e){
            addRemoveApartmentsTabLabel.setText("Couldn't Remove Inhabitant");
        }
    }


    /*
     ***************************************************************
     ***************************************************************
     *                      SORTING/INFO TAB                       *
     ***************************************************************
     ***************************************************************
     */



    /*
     ***************************************************************
     *                      Sort Inhabitants                       *
     ***************************************************************
     */

    public void SortInhabitants(){
        try{
            int cnt = 1;
            ArrayList<Person> sortedList;
            StringBuilder ListString = new StringBuilder();
            Building selectedBuilding = sortInhabitantsBuildingComboBox.getValue();

            if(sortInhabitantsNameOrAgeComboBox.getValue().equals("Name")){
                sortedList = selectedBuilding.sortInhabitantsByName();

                for(Person person : sortedList){
                    ListString.append(cnt).append(". ").append(person.getName()).append("\n");
                    cnt++;
                }

                buildingsSortingInfoTabLabel.setText(String.valueOf(ListString));
            }

            else if(sortInhabitantsNameOrAgeComboBox.getValue().equals("Age")){
                sortedList = selectedBuilding.sortInhabitantsByAge();

                for(Person person : sortedList){
                    ListString.append(cnt).append(". ").append(person).append("\n");
                    cnt++;
                }

                buildingsSortingInfoTabLabel.setText(String.valueOf(ListString));
            }
            else{
                buildingsSortingInfoTabLabel.setText("No Type Of Sort Selected");
            }
        }
        catch(Exception E){
            buildingsSortingInfoTabLabel.setText("Couldn't Sort Inhabitants");
        }
    }


    /*
     ***************************************************************
     *                Show Inhabitants/Apartments                  *
     ***************************************************************
     */
    public void ShowApartmentsOrInhabitants(){
        try{
            Building selectedBuilding = chooseBuildingComboBox.getValue();
            StringBuilder infoString = new StringBuilder();

            if(showNumOrListComboBox.getValue().equals("Number")){
                if(showApartmentsOrInhabitantsComboBox.getValue().equals("Apartments")){
                    infoString.append("Total Number Of Apartments is: ").append(selectedBuilding.getNumberOfApartments());
                    buildingsSortingInfoTabLabel.setText(String.valueOf(infoString));
                }

                else if(showApartmentsOrInhabitantsComboBox.getValue().equals("Inhabitants")){
                    int inhabitantsSum = 0;
                    for(Apartment apartment : selectedBuilding.getApartments()){
                        inhabitantsSum += apartment.getInhabitants().size();
                    }

                    infoString.append("Total Number Of Inhabitants is: ").append(inhabitantsSum);
                    buildingsSortingInfoTabLabel.setText(String.valueOf(infoString));
                }
                else{
                    buildingsSortingInfoTabLabel.setText("No Type Selected");
                }
            }

            else if(showNumOrListComboBox.getValue().equals("List")){
                if(showApartmentsOrInhabitantsComboBox.getValue().equals("Apartments")){
                    infoString.append("Apartments List:").append("\n");

                    for(Apartment apartment : selectedBuilding.getApartments()){
                        infoString.append(apartment).append("\n");
                    }

                    buildingsSortingInfoTabLabel.setText(String.valueOf(infoString));
                }

                else if(showApartmentsOrInhabitantsComboBox.getValue().equals("Inhabitants")){
                    infoString.append("Inhabitants List:").append("\n");

                    for(Apartment apartment : selectedBuilding.getApartments()){
                        for(Person person : apartment.getInhabitants()){
                            infoString.append(person).append("\n");
                        }
                    }

                    buildingsSortingInfoTabLabel.setText(String.valueOf(infoString));
                }
                else{
                    buildingsSortingInfoTabLabel.setText("No Type Selected");
                }
            }
            else{
                buildingsSortingInfoTabLabel.setText("No Type Selected");
            }
        }
        catch(Exception e){
            buildingsSortingInfoTabLabel.setText("Couldn't Show Info");
        }
    }

    /*
     ***************************************************************
     *                        Show Taxes                           *
     ***************************************************************
     */


    //Whenever Building or Apartment is selected,
    //change the other combobox to not be visible
    //and add all the items from the correct arraylist
    public void UpdateBuildingOrApartmentTax(){
        try{
            showTaxComboBox.getItems().clear();
            showTaxComboBox1.getItems().clear();

            if(taxForBuildingOrApartmentComboBox.getValue().equals("Building")){
                showTaxComboBox1.setOpacity(0);
                showTaxComboBox1.setDisable(true);

                showTaxComboBox.setOpacity(1);
                showTaxComboBox.setDisable(false);
                showTaxComboBox.getItems().addAll(buildingArrayList);
            }
            else if(taxForBuildingOrApartmentComboBox.getValue().equals("Apartment")){
                showTaxComboBox.setOpacity(0);
                showTaxComboBox.setDisable(true);

                showTaxComboBox1.setOpacity(1);
                showTaxComboBox1.setDisable(false);
                showTaxComboBox1.getItems().addAll(apartmentArrayList);
            }
        }
        catch(Exception e){
            System.out.print("");
        }
    }



    public void ShowTaxes(){
        try{
            StringBuilder infoString = new StringBuilder();

            if(showTypeOfTaxComboBox.getValue().equals("Collected")){
                if(taxForBuildingOrApartmentComboBox.getValue().equals("Apartment")){
                    Apartment apartment = showTaxComboBox1.getValue();
                    infoString.append("Collected Taxes for this apartment are: $");

                    if(apartment.isTaxPaid()){ //if the apartment has paid its tax, it will be calculated so we directly use it's value
                        infoString.append(apartment.getTax());
                    }
                    else{
                        infoString.append("0"); //if the apartment hasn't paid, then logically 0 dollars have been collected
                    }

                    buildingsSortingInfoTabLabel.setText(String.valueOf(infoString));
                }

                else if(taxForBuildingOrApartmentComboBox.getValue().equals("Building")){
                    Building building = showTaxComboBox.getValue();

                    //if the building has collected it's tax, then we directly show that value
                    infoString.append("Collected Taxes for this building are: $").append(building.getCollectedTax());

                    buildingsSortingInfoTabLabel.setText(String.valueOf(infoString));
                }
                else{
                    buildingsSortingInfoTabLabel.setText("No Type Selected");
                }
            }

            else if(showTypeOfTaxComboBox.getValue().equals("Uncollected")){
                if(taxForBuildingOrApartmentComboBox.getValue().equals("Apartment")){
                    Apartment apartment = showTaxComboBox1.getValue();
                    infoString.append("Uncollected Taxes for this apartment are: $");

                    //if the apartment has uncollected taxes, we need to find out their value
                    //since every company has different tax rates, we cycle through the companies
                    //to find the one which works on this apartment and use it's rates to
                    //calculate the tax which needs to be paid for this apartment
                    if(!apartment.isTaxPaid()){
                        for(Company company : companyArrayList){
                            if(company.containsApartment(apartment)){
                                infoString.append(apartment.calculateTax(company.getAreaTax(),company.getAdultTax(),
                                        company.getPetTax(),company.getElevatorTax()));
                                break;
                            }
                        }
                    }
                    else{
                        infoString.append("0");
                    }

                    buildingsSortingInfoTabLabel.setText(String.valueOf(infoString));
                }

                else if(taxForBuildingOrApartmentComboBox.getValue().equals("Building")){
                    Building building = showTaxComboBox.getValue();

                    //same procedure as the apartment's tax cycle
                    for(Company company : companyArrayList){
                        if(company.containsBuilding(building)){
                            building.calculateTaxesForAllApartments(company.getAreaTax(),company.getAdultTax(),
                                    company.getPetTax(),company.getElevatorTax());
                            break;
                        }
                    }
                    infoString.append("Uncollected Taxes for this building are: $").append(building.getTaxToCollect());

                    buildingsSortingInfoTabLabel.setText(String.valueOf(infoString));
                }
                else{
                    buildingsSortingInfoTabLabel.setText("Nothing Selected");
                }
            }
            else{
                buildingsSortingInfoTabLabel.setText("Nothing Selected");
            }
        }
        catch(Exception e){
            buildingsSortingInfoTabLabel.setText("Couldn't Show Taxes");
        }
    }


    /*
     ***************************************************************
     ***************************************************************
     *                 EDIT APARTMENTS/PEOPLE TAB                  *
     ***************************************************************
     ***************************************************************
     */


    /*
     ***************************************************************
     *                      Edit Apartments                        *
     ***************************************************************
     */
    public void UpdateEditApartmentComboBox(){
        try{
            editApartmentComboBox.getItems().clear();
            editApartmentComboBox.getItems().addAll(editApartmentBuildingComboBox.getValue().getApartments());

            editApartmentFloorComboBox.getItems().clear();//update floor combobox with the number of floors in the selected building
            for(int i = 1; i <= editApartmentBuildingComboBox.getValue().getFloors(); i++){
                editApartmentFloorComboBox.getItems().addAll(i);
            }

        }
        catch(Exception e){
            System.out.print("");
        }
    }



    public void EditApartment(){
        boolean edited = false;
        try{
            if(!editApartmentNumberField.getText().equals("")){
                editApartmentComboBox.getValue().setApartmentNumber(Integer.parseInt(editApartmentNumberField.getText()));
                edited = true;
            }

            if(!editApartmentAreaField.getText().equals("")){
                editApartmentComboBox.getValue().setArea(Integer.parseInt(editApartmentAreaField.getText()));
                edited = true;
            }

            if(!editApartmentFloorComboBox.getSelectionModel().isEmpty()) {
                editApartmentComboBox.getValue().setFloor(editApartmentFloorComboBox.getValue());
                edited = true;
            }

            boolean hasPet = editApartmentPetCheckBox.isSelected();
            if(editApartmentComboBox.getValue().getHasPet() != hasPet){
                editApartmentComboBox.getValue().setHasPet(hasPet);
                edited = true;
            }

            if(edited){
                editApartmentsPeopleLabel.setText("Apartment Edited");
                UpdateEditApartmentComboBox();
            }
        }
        catch (Exception e){
            editApartmentsPeopleLabel.setText("Couldn't Edit Apartment");
        }
    }



    public void EditPerson(){
        boolean edited = false;
        try{
            if(!editPersonNameField.getText().equals("")){
                editPersonComboBox.getValue().setName(editPersonNameField.getText());
                edited = true;
            }
            if(!editPersonAgeField.getText().equals("")) {
                editPersonComboBox.getValue().setAge(Integer.parseInt(editPersonAgeField.getText()));
                edited = true;
            }

            if(edited){
                editApartmentsPeopleLabel.setText("Person Info Edited");
                UpdateComboBoxes();
            }
        }
        catch (Exception e){
            editApartmentsPeopleLabel.setText("Couldn't Edit Person Info");
        }
    }



    public void UpdateComboBoxes(){
        removeCompanyComboBox.setItems(FXCollections.observableArrayList(companyArrayList));
        addEmployeeCompanyComboBox.setItems(FXCollections.observableArrayList(companyArrayList));
        removeEmployeeCompanyComboBox.setItems(FXCollections.observableArrayList(companyArrayList));
        addRemoveBuildingCompanyComboBox.setItems(FXCollections.observableArrayList(companyArrayList));
        editTaxForCompanyComboBox.setItems(FXCollections.observableArrayList(companyArrayList));
        taxForCompanyComboBox.setItems(FXCollections.observableArrayList(companyArrayList));
        collectTaxForCompanyComboBox.setItems(FXCollections.observableArrayList(companyArrayList));
        writeTaxToFileCombBox.setItems(FXCollections.observableArrayList(companyArrayList));
        collectTaxForApartmentCompanyComboBox.setItems(FXCollections.observableArrayList(companyArrayList));
        sortFromCompanyComboBox.setItems(FXCollections.observableArrayList(companyArrayList));
        editBuildingComboBox.setItems(FXCollections.observableArrayList(buildingArrayList));
        addApartmentChooseBuildingComboBox.setItems(FXCollections.observableArrayList(buildingArrayList));
        removeApartmentChooseBuildingComboBox.setItems(FXCollections.observableArrayList(buildingArrayList));
        addInhabitantBuildingComboBox.setItems(FXCollections.observableArrayList(buildingArrayList));
        removeInhabitantBuildingComboBox.setItems(FXCollections.observableArrayList(buildingArrayList));
        changeOwnerBuildingComboBox.setItems(FXCollections.observableArrayList(buildingArrayList));
        sortInhabitantsBuildingComboBox.setItems(FXCollections.observableArrayList(buildingArrayList));
        chooseBuildingComboBox.setItems(FXCollections.observableArrayList(buildingArrayList));
        editApartmentBuildingComboBox.setItems(FXCollections.observableArrayList(buildingArrayList));
        editEmployeeComboBox.setItems(FXCollections.observableArrayList(employeeArrayList));
        showEmployeeBuildingsEmployeeComboBox.setItems(FXCollections.observableArrayList(employeeArrayList));
        showEmployeeTaxComboBox.setItems(FXCollections.observableArrayList(employeeArrayList));
        editPersonComboBox.setItems(FXCollections.observableArrayList(peopleArrayList));
    }

/*  //Some hardcoded items that are used to test the functions without creating new ones every time
    public void AddSampleItems() throws IOException {

        Person a = new Person("a",50);
        Person b = new Person("b",40);
        Person c = new Person("c",56);
        Person d = new Person("d",38);
        Person e = new Person("e",76);
        Person f = new Person("f",59);
        Person g = new Person("g",15);
        Person h = new Person("h",82);
        Person i = new Person("i",92);
        Person j = new Person("j",5);
        Person k = new Person("k",31);
        Person l = new Person("l",29);
        Person m = new Person("m",6);
        Person n = new Person("n",12);
        Person o = new Person("o",19);
        Person p = new Person("p",7);
        Person q = new Person("q",43);
        Person r = new Person("r",66);
        Person s = new Person("s",70);
        Person t = new Person("t",51);
        Person u = new Person("u",14);
        Person v = new Person("v",33);
        Person w = new Person("w",26);
        Person x = new Person("x",39);
        Person y = new Person("y",48);
        Person z = new Person("z",2);

        Apartment apartment1 = new Apartment(1,1,90,true,a);
        Apartment apartment2 = new Apartment(2,2,50,false,b);
        Apartment apartment3 = new Apartment(3,3,60,false,c);
        Apartment apartment4 = new Apartment(1,1,80,false,d);
        Apartment apartment5 = new Apartment(2,2,95,true,e);
        Apartment apartment6 = new Apartment(3,3,87,false,f);
        Apartment apartment7 = new Apartment(1,1,120,false,h);
        Apartment apartment8 = new Apartment(2,2,86,true,i);
        Apartment apartment9 = new Apartment(3,3,92,false,j);
        Apartment apartment10 = new Apartment(1,1,75,false,k);
        Apartment apartment11 = new Apartment(2,2,100,true,l);
        Apartment apartment12 = new Apartment(3,3,89,true,s);

        Building building1 = new Building("Sofia-Vasil Levski-4",3,3);
        Building building2 = new Building("Sofia-Tsarigradsko Shose-65",3,3);
        Building building3 = new Building("Sofia-prof. Asen Zlatarov-21",3,3);
        Building building4 = new Building("Sofia-d-r Ivan Seliminski-10",3,3);


        Employee employee1 = new Employee("Mark",30,5);
        Employee employee2 = new Employee("Peter",50,21);
        Employee employee3 = new Employee("John",42,11);

        Company company1 = new Company("C");

        apartment1.addInhabitant(g);
        apartment2.addInhabitant(m);
        apartment3.addInhabitant(n);
        apartment4.addInhabitant(o);
        apartment5.addInhabitant(p);
        apartment5.addInhabitant(y);
        apartment6.addInhabitant(q);
        apartment7.addInhabitant(r);
        apartment8.addInhabitant(t);
        apartment9.addInhabitant(u);
        apartment10.addInhabitant(v);
        apartment10.addInhabitant(z);
        apartment11.addInhabitant(w);
        apartment12.addInhabitant(x);

        building1.addApartment(apartment1);
        building1.addApartment(apartment2);
        building1.addApartment(apartment3);
        building2.addApartment(apartment4);
        building2.addApartment(apartment5);
        building2.addApartment(apartment6);
        building3.addApartment(apartment7);
        building3.addApartment(apartment8);
        building3.addApartment(apartment9);
        building4.addApartment(apartment10);
        building4.addApartment(apartment11);
        building4.addApartment(apartment12);


        company1.addEmployee(employee3);
        company1.addEmployee(employee2);
        company1.addEmployee(employee1);


        company1.addBuilding(building1);
        company1.addBuilding(building2);
        company1.addBuilding(building3);
        company1.addBuilding(building4);



        peopleArrayList.add(a);
        peopleArrayList.add(b);
        peopleArrayList.add(c);
        peopleArrayList.add(d);
        peopleArrayList.add(e);
        peopleArrayList.add(f);
        peopleArrayList.add(g);
        peopleArrayList.add(h);
        peopleArrayList.add(i);
        peopleArrayList.add(j);
        peopleArrayList.add(k);
        peopleArrayList.add(l);
        peopleArrayList.add(m);
        peopleArrayList.add(n);
        peopleArrayList.add(o);
        peopleArrayList.add(p);
        peopleArrayList.add(q);
        peopleArrayList.add(r);
        peopleArrayList.add(s);
        peopleArrayList.add(t);
        peopleArrayList.add(u);
        peopleArrayList.add(v);
        peopleArrayList.add(w);
        peopleArrayList.add(x);
        peopleArrayList.add(y);
        peopleArrayList.add(z);

        apartmentArrayList.add(apartment1);
        apartmentArrayList.add(apartment2);
        apartmentArrayList.add(apartment3);
        apartmentArrayList.add(apartment4);
        apartmentArrayList.add(apartment5);
        apartmentArrayList.add(apartment5);
        apartmentArrayList.add(apartment6);
        apartmentArrayList.add(apartment7);
        apartmentArrayList.add(apartment8);
        apartmentArrayList.add(apartment9);
        apartmentArrayList.add(apartment10);
        apartmentArrayList.add(apartment11);
        apartmentArrayList.add(apartment12);


        buildingArrayList.add(building1);
        buildingArrayList.add(building2);
        buildingArrayList.add(building3);
        buildingArrayList.add(building4);
        buildingArrayList.add(new Building("sofia-a-1",1,1));


        employeeArrayList.add(employee1);
        employeeArrayList.add(employee2);
        employeeArrayList.add(employee3);


        companyArrayList.add(company1);
        companyArrayList.add(new Company("B"));
    }
    */
}