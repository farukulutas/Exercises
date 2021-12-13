import { users } from "../data/users.js"
import DataError from "../models/dataError.js"

// CONSTANTS
const comesFirstForSort = 1
const comesEqualForSort = 0
const comesLastForSort = -1

export default class UserService {


    // Constructor
    constructor(loggerService) {
        this.employees = []
        this.customers = []
        this.errors = []
        this.loggerService = loggerService
    }

    // If there is no user validation error, it adds the user, if there is, it generates an error. 
    load() {
        for (const user of users) {
            /*
            switch (user.type) {
                case "customer":
                    if (!this.checkCustomerValidityForErrors(user)) {
                        this.customers.push(user)
                    }
                    break;
                case "employee":
                    if (!this.checkEmployeeValidityForErrors(user)) {
                        this.employees.push(user)
                    }
                    break;
                default:
                    this.errors.push(new DataError("Wrong user type", user))
                    break;
            }
            */

            checkUserAndAdd( user)
        }
    }

    /*
    //formik-yup
    checkCustomerValidityForErrors(user) {
        let requiredFields = "id firstName lastName age city".split(" ")
        let hasErrors = false
        for (const field of requiredFields) {
            if (!user[field]) {
                hasErrors = true
                this.errors.push(
                    new DataError(`Validation problem. ${field} is required`, user))
            }
        }

        if (Number.isNaN(Number.parseInt(user.age))) {
            hasErrors = true
            this.errors.push(new DataError(`Validation problem. ${user.age} is not a number`, user))
        }

        return hasErrors
    }

    checkEmployeeValidityForErrors(user) {
        let requiredFields = "id firstName lastName age city salary".split(" ")
        let hasErrors = false
        for (const field of requiredFields) {
            if (!user[field]) {
                hasErrors = true
                this.errors.push(
                    new DataError(`Validation problem. ${field} is required`, user))
            }
        }

        if (Number.isNaN(Number.parseInt(user.age))) {
            hasErrors = true
            this.errors.push(new DataError(`Validation problem. ${user.age} is not a number`, user))
        }
        return hasErrors
    }
    */

    // This method checks the user type and returns the required fields. 
    getRequiredFields(user) {
        if ( typeof user == "Employee" ) {
            return "id firstName lastName age city salary".split(" ")
        }
        
        if ( typeof user == "Customer" ) {
            return "id firstName lastName age city".split(" ")
        }
    }

    // This method checks for errors using the required fields for user validation. 
    checkUserValidityForErrors(user) {
        let requiredFields = getRequiredFields(user)
        let hasErrors = false
        for (const field of requiredFields) {
            if (!user[field]) {
                hasErrors = true
                this.errors.push(
                    new DataError(`Validation problem. ${field} is required`, user))
            }
        }

        if (Number.isNaN(Number.parseInt(user.age))) {
            hasErrors = true
            this.errors.push(new DataError(`Validation problem. ${user.age} is not a number`, user))
        }
        return hasErrors
    }

    // This method adds the user to the array of the appropriate class.
    add(user) {
        /*
        switch (user.type) {
            case "customer":
                if (!this.checkCustomerValidityForErrors(user)) {
                    this.customers.push(user)
                }
                break;
            case "employee":
                if (!this.checkEmployeeValidityForErrors(user)) {
                    this.employees.push(user)
                }
                break;
            default:
                this.errors.push(
                    new DataError("This user can not be added. Wrong user type", user))
                break;
        }*/
        checkUserAndAdd( user)
        this.loggerService.log(user)
    }

    // This method checks user validity and adds user. 
    checkUserAndAdd ( user) {
        try {
            if ( !this.checkUserValidityForErrors(user) ) {
                if ( typeof user == "Customer") {
                    this.customers.push(user)
                }
                if ( typeof user == "Employee") {
                    this.employees.push(user)
                }
            }
        }
        catch {
            this.errors.push(new DataError("Wrong user type", user))
        }
    }

    // This method returns the customer array. 
    listCustomers() {
        return this.customers
    }

    // This method finds the customer by looking at the id. 
    getCustomerById(id) {
        return this.customers.find(u=>u.id ===id)
    }

    // This method sorts the customers given in the parameters and returns their alphabetical numbers.
    getCustomersSorted(){
        return this.customers.sort((customer1,customer2)=>{
            if (customer1.firstName > customer2.firstName){
                return comesFirstForSort
            } else if (customer1.firstName === customer2.firstName) {
                return comesEqualForSort
            } else {
                return comesLastForSort
            }
        })
    }

}