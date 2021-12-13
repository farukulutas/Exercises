import { BaseLogger, ElasticLogger, MongoLogger } from "../crossCuttingConcerns/logging/logger.js"
import Customer from "../models/customer.js"
import User from "../models/user.js"
import UserService from "../services/userService.js"

console.log("User component yüklendi")

let userService = new UserService( new MongoLogger())

userService.add( new User(1, "Engin", "Demiroğ", "Ankara"))
userService.add( new User(2, "Baran", "Gökçekli", "Muğla"))

let customer = { id: 1, firstName: "Engin" }

//prototyping
customer.lastName = "Demiroğ"

console.log(customer.lastName)

console.log("--------------------------")
userService.load()

let customerToAdd = new Customer(1, "Seda", "Yılmaz", "Ankara", "fdgdfg");
customerToAdd.type = "customer"

userService.add(customerToAdd)
console.log(userService.customers)
console.log(userService.employees)
console.log(userService.errors)
console.log(userService.getCustomersSorted())