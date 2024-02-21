import axios from "axios";

const REST_API_BASE_URL = 'http://localhost:8080/employee';

export const listEmployees = () => axios.get(REST_API_BASE_URL + '/getall');

export const createEmployee = (employee) => axios.post(REST_API_BASE_URL + '/add', employee);

export const getEmployee = (employeeId) => axios.get(REST_API_BASE_URL + '/get/' + employeeId);

export const updateEmployee = (employeeId, employee) => axios.put(REST_API_BASE_URL + '/update/' + employeeId, employee);

export const deleteEmployee = (employeeId) => axios.delete(REST_API_BASE_URL + '/delete/' + employeeId);