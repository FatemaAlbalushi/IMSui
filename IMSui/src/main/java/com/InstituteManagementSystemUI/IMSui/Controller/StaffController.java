package com.InstituteManagementSystemUI.IMSui.Controller;

import com.InstituteManagementSystemUI.IMSui.Model.Staff;
import com.InstituteManagementSystemUI.IMSui.Service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The StaffController class is a REST controller for managing Staff data in the Institute Management System.
 */
@RestController
@RequestMapping(path = "/api/staff")
public class StaffController {
    @Autowired
    private StaffService StaffService;

    /**
     * Retrieve a list of all Staff
     * @return a list of all Staff
     */
    @GetMapping
    public List<Staff> getStaff(){
        return StaffService.getAllStaff();
    }

    /**
     * Retrieve a specific Staff by ID
     * @param id the ID of the Staff to retrieve
     * @return the Staff with the specified ID
     */
    @GetMapping(path = "/{id}")
    public Staff getStaff(@PathVariable(name="id") int id){
        return StaffService.getStaff(id);
    }

    /**
     * Create a new Staff
     * @param currStaff Staff to create
     * @return the newly created Staff
     */
    @PostMapping
    public Staff createStaff(@RequestBody Staff currStaff){
        StaffService.createStaff(currStaff);
        return currStaff;
    }

    /**
     * Update an existing Staff
     * @param id the ID of the Staff to update
     * @param currStaff the updated Staff data
     * @return the updated Staff
     */
    @PutMapping(path = "/{id}")
    public Staff updateStaff(@PathVariable(name="id") int id, @RequestBody Staff currStaff){
        StaffService.updateStaff(id, currStaff);
        return currStaff;
    }

    /**
     * Delete a Staff
     * @param id the ID of the Staff to delete
     * @return the deleted Staff
     */
    @DeleteMapping(path = "/{id}")
    public Staff deleteStaff(@PathVariable(name="id") int id) {
        return StaffService.deleatStaff(id);
    }
}
