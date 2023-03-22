package com.InstituteManagementSystemUI.IMSui.Service;

import com.InstituteManagementSystemUI.IMSui.Model.Staff;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;

@Service
public class StaffService {
    /**
     * Retrieve a list of all Staff.
     * @return a list of all Staff
     */
    public  List<Staff> listofStaff  = new CopyOnWriteArrayList<>();
    int currId = 1;

    private static final Logger logger = LoggerFactory.getLogger(StaffService.class);

    /**
     * Retrieve a list of all Staff.
     * @return a list of all Staff
     */
    public List<Staff>getAllStaff(){
        logger.info("Getting all Staff");
        return listofStaff;
    }

    /**
     * Retrieve a specific Staff by ID.
     * @param id the ID of the Staff to retrieve
     * @return the Staff with the specified ID
     */
    public Staff getStaff(int id) {
        Optional<Staff> foundRecode =  listofStaff.stream().filter(
                (currentStaff) -> {
                    return currentStaff.StaffId == id;
                }
        ).findFirst();

        logger.info("get Staff with id: " + id);
        return foundRecode.orElse(null);

    }

    /**
     * Create a new Staff.
     * @param currStaff the Staff to create
     * @return the newly created Staff
     */
    public  Staff createStaff(Staff currStaff){
        currStaff.StaffId=this.currId ++;
        listofStaff.add(currStaff);
        logger.info("Created Staff with id: " + currStaff.StaffId);

        return currStaff;
    }

    /**
     * Update an existing Staff.
     * @param id the ID of the Staff to update
     * @param updatedStaff the updated Staff data
     * @return the updated Staff
     */
    public Staff updateStaff(int id, Staff updatedStaff){
        Staff foundStaff = getStaff(id);
        foundStaff.StaffName = updatedStaff.StaffName;
        foundStaff.StaffEmail= updatedStaff.StaffEmail;
        foundStaff.salary= updatedStaff.salary;

        logger.info("updated Staff with id: " + id);
        return foundStaff;
    }

    /**
     * Delete a Staff.
     * @param id the ID of the Staff to delete
     * @return the deleted Staff
     */
    public Staff deleatStaff(int id){
        Staff foundStaff = getStaff(id);
        listofStaff.remove(foundStaff);

        logger.info("delete Staff with id: " + id);
        return foundStaff;
    }
}
